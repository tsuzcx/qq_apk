package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> hwL;
  private boolean DEBUG;
  public Bitmap bitmap;
  private ap gIf;
  private boolean hwJ;
  private AtomicInteger hwK;
  private boolean hwM;
  private Runnable hwN;
  private int hwO;
  private int hwP;
  
  static
  {
    AppMethodBeat.i(156452);
    hwL = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.gIf = new ap(Looper.getMainLooper());
    this.hwJ = false;
    this.hwK = new AtomicInteger();
    this.hwM = true;
    this.hwN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.hwO = 0;
    this.hwP = 0;
    this.bitmap = paramBitmap;
    this.hwK.set(1);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bt.flS().toString());
    }
    this.hwJ = false;
    getAllocationByteCount();
    AppMethodBeat.o(156438);
  }
  
  public static n D(Bitmap paramBitmap)
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
  
  private boolean ayI()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.hwJ + " isMutable:" + this.hwM + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hwK + bt.flS().toString());
    }
    if ((this.hwJ) || (this.hwK.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.hwJ = true;
    if (this.DEBUG) {
      hwL.remove(this.bitmap);
    }
    if (this.hwM) {
      l.ayD().C(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int ayJ()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ad.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.hwO + " " + toString());
      i = this.hwO;
      AppMethodBeat.o(156446);
      return i;
    }
    this.hwO = this.bitmap.getByteCount();
    int i = this.hwO;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void ayB()
  {
    AppMethodBeat.i(156440);
    this.hwK.incrementAndGet();
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.hwK + " bitmap:" + this.bitmap + " " + this + " " + bt.flS().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void ayC()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.hwK + " bitmap:" + this.bitmap + " " + this + " " + bt.flS().toString());
    }
    if (this.hwK.get() > 0)
    {
      this.hwK.decrementAndGet();
      if (this.hwK.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.gIf.removeCallbacks(this.hwN);
      this.gIf.postDelayed(this.hwN, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap ayF()
  {
    this.hwM = false;
    return this.bitmap;
  }
  
  public final Bitmap ayG()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bt.flS().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean ayH()
  {
    AppMethodBeat.i(156444);
    this.hwK.decrementAndGet();
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.hwJ + " isMutable:" + this.hwM + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hwK + bt.flS().toString());
    }
    ayI();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final String ayK()
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
      ad.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    AppMethodBeat.o(156449);
  }
  
  public final int getAllocationByteCount()
  {
    AppMethodBeat.i(156447);
    if (d.lz(19))
    {
      i = ayJ();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ad.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.hwP + " " + toString());
      i = this.hwP;
      AppMethodBeat.o(156447);
      return i;
    }
    this.hwP = this.bitmap.getAllocationByteCount();
    int i = this.hwP;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(156443);
    if ((this.hwJ) || (this.bitmap == null) || (this.bitmap.isRecycled()))
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
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.hwK;
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