package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class m
  implements h
{
  private static ConcurrentHashMap<Bitmap, Integer> nNB;
  private boolean DEBUG;
  public Bitmap bitmap;
  private boolean dIE;
  private MMHandler mRi;
  private AtomicInteger nNA;
  private Runnable nNC;
  private int nND;
  private int nNE;
  private boolean nNz;
  
  static
  {
    AppMethodBeat.i(156452);
    nNB = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private m(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.nNz = false;
    this.nNA = new AtomicInteger();
    this.dIE = true;
    this.nNC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        m.a(m.this);
        AppMethodBeat.o(156437);
      }
    };
    this.nND = 0;
    this.nNE = 0;
    this.bitmap = paramBitmap;
    this.nNA.set(1);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + Util.getStack().toString());
    }
    this.nNz = false;
    bvW();
    AppMethodBeat.o(156438);
  }
  
  public static m O(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156439);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156439);
      return null;
    }
    paramBitmap = new m(paramBitmap);
    AppMethodBeat.o(156439);
    return paramBitmap;
  }
  
  private boolean bvU()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.nNz + " isMutable:" + this.dIE + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.nNA + Util.getStack().toString());
    }
    if ((this.nNz) || (this.nNA.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.nNz = true;
    if (this.DEBUG) {
      nNB.remove(this.bitmap);
    }
    if (this.dIE) {
      k.bvO().N(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int bvV()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.nND + " " + toString());
      i = this.nND;
      AppMethodBeat.o(156446);
      return i;
    }
    this.nND = this.bitmap.getByteCount();
    int i = this.nND;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void bvM()
  {
    AppMethodBeat.i(156440);
    this.nNA.incrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.nNA + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void bvN()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.nNA + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    if (this.nNA.get() > 0)
    {
      this.nNA.decrementAndGet();
      if (this.nNA.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.mRi.removeCallbacks(this.nNC);
      this.mRi.postDelayed(this.nNC, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap bvQ()
  {
    this.dIE = false;
    return this.bitmap;
  }
  
  public final Bitmap bvR()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + Util.getStack().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean bvS()
  {
    AppMethodBeat.i(156443);
    if ((this.nNz) || (this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      AppMethodBeat.o(156443);
      return true;
    }
    AppMethodBeat.o(156443);
    return false;
  }
  
  public final boolean bvT()
  {
    AppMethodBeat.i(156444);
    this.nNA.decrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.nNz + " isMutable:" + this.dIE + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.nNA + Util.getStack().toString());
    }
    bvU();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final int bvW()
  {
    AppMethodBeat.i(156447);
    if (d.rc(19))
    {
      i = bvV();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.nNE + " " + toString());
      i = this.nNE;
      AppMethodBeat.o(156447);
      return i;
    }
    this.nNE = this.bitmap.getAllocationByteCount();
    int i = this.nNE;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final String bvX()
  {
    AppMethodBeat.i(156450);
    String str = this + " " + this.bitmap;
    AppMethodBeat.o(156450);
    return str;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(156449);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    AppMethodBeat.o(156449);
  }
  
  public String toString()
  {
    AppMethodBeat.i(156448);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.nNA;
      str1 = str2;
      if (this.bitmap != null) {
        str1 = str2 + this.bitmap;
      }
      AppMethodBeat.o(156448);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(156448);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.m
 * JD-Core Version:    0.7.0.1
 */