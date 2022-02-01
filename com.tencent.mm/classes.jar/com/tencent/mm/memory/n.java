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

public class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> liQ;
  private boolean DEBUG;
  private boolean bPc;
  public Bitmap bitmap;
  private MMHandler knk;
  private boolean liO;
  private AtomicInteger liP;
  private Runnable liR;
  private int liS;
  private int liT;
  
  static
  {
    AppMethodBeat.i(156452);
    liQ = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.knk = new MMHandler(Looper.getMainLooper());
    this.liO = false;
    this.liP = new AtomicInteger();
    this.bPc = true;
    this.liR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.liS = 0;
    this.liT = 0;
    this.bitmap = paramBitmap;
    this.liP.set(1);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + Util.getStack().toString());
    }
    this.liO = false;
    bbb();
    AppMethodBeat.o(156438);
  }
  
  public static n F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156439);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(156439);
      return null;
    }
    paramBitmap = new n(paramBitmap);
    AppMethodBeat.o(156439);
    return paramBitmap;
  }
  
  private boolean baZ()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.liO + " isMutable:" + this.bPc + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.liP + Util.getStack().toString());
    }
    if ((this.liO) || (this.liP.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.liO = true;
    if (this.DEBUG) {
      liQ.remove(this.bitmap);
    }
    if (this.bPc) {
      l.baT().s(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int bba()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.liS + " " + toString());
      i = this.liS;
      AppMethodBeat.o(156446);
      return i;
    }
    this.liS = this.bitmap.getByteCount();
    int i = this.liS;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void baR()
  {
    AppMethodBeat.i(156440);
    this.liP.incrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.liP + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void baS()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.liP + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    if (this.liP.get() > 0)
    {
      this.liP.decrementAndGet();
      if (this.liP.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.knk.removeCallbacks(this.liR);
      this.knk.postDelayed(this.liR, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap baV()
  {
    this.bPc = false;
    return this.bitmap;
  }
  
  public final Bitmap baW()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + Util.getStack().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean baX()
  {
    AppMethodBeat.i(156443);
    if ((this.liO) || (this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      AppMethodBeat.o(156443);
      return true;
    }
    AppMethodBeat.o(156443);
    return false;
  }
  
  public final boolean baY()
  {
    AppMethodBeat.i(156444);
    this.liP.decrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.liO + " isMutable:" + this.bPc + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.liP + Util.getStack().toString());
    }
    baZ();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final int bbb()
  {
    AppMethodBeat.i(156447);
    if (d.qW(19))
    {
      i = bba();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.liT + " " + toString());
      i = this.liT;
      AppMethodBeat.o(156447);
      return i;
    }
    this.liT = this.bitmap.getAllocationByteCount();
    int i = this.liT;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final String bbc()
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
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.liP;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.n
 * JD-Core Version:    0.7.0.1
 */