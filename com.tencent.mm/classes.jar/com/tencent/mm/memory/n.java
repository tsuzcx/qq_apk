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
  private static ConcurrentHashMap<Bitmap, Integer> itH;
  private boolean DEBUG;
  private boolean bNd;
  public Bitmap bitmap;
  private MMHandler hAk;
  private boolean itF;
  private AtomicInteger itG;
  private Runnable itI;
  private int itJ;
  private int itK;
  
  static
  {
    AppMethodBeat.i(156452);
    itH = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.itF = false;
    this.itG = new AtomicInteger();
    this.bNd = true;
    this.itI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.itJ = 0;
    this.itK = 0;
    this.bitmap = paramBitmap;
    this.itG.set(1);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + Util.getStack().toString());
    }
    this.itF = false;
    getAllocationByteCount();
    AppMethodBeat.o(156438);
  }
  
  public static n H(Bitmap paramBitmap)
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
  
  private boolean aSd()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.itF + " isMutable:" + this.bNd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.itG + Util.getStack().toString());
    }
    if ((this.itF) || (this.itG.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.itF = true;
    if (this.DEBUG) {
      itH.remove(this.bitmap);
    }
    if (this.bNd) {
      l.aRY().x(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int aSe()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.itJ + " " + toString());
      i = this.itJ;
      AppMethodBeat.o(156446);
      return i;
    }
    this.itJ = this.bitmap.getByteCount();
    int i = this.itJ;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void aRW()
  {
    AppMethodBeat.i(156440);
    this.itG.incrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.itG + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void aRX()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.itG + " bitmap:" + this.bitmap + " " + this + " " + Util.getStack().toString());
    }
    if (this.itG.get() > 0)
    {
      this.itG.decrementAndGet();
      if (this.itG.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.hAk.removeCallbacks(this.itI);
      this.hAk.postDelayed(this.itI, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap aSa()
  {
    this.bNd = false;
    return this.bitmap;
  }
  
  public final Bitmap aSb()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + Util.getStack().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean aSc()
  {
    AppMethodBeat.i(156444);
    this.itG.decrementAndGet();
    if (this.DEBUG) {
      Log.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.itF + " isMutable:" + this.bNd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.itG + Util.getStack().toString());
    }
    aSd();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final String aSf()
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
  
  public final int getAllocationByteCount()
  {
    AppMethodBeat.i(156447);
    if (d.oE(19))
    {
      i = aSe();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      Log.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.itK + " " + toString());
      i = this.itK;
      AppMethodBeat.o(156447);
      return i;
    }
    this.itK = this.bitmap.getAllocationByteCount();
    int i = this.itK;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(156443);
    if ((this.itF) || (this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      AppMethodBeat.o(156443);
      return true;
    }
    AppMethodBeat.o(156443);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(156448);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.itG;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.n
 * JD-Core Version:    0.7.0.1
 */