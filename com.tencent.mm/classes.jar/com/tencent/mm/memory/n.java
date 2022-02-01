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
  private static ConcurrentHashMap<Bitmap, Integer> gEc;
  private boolean DEBUG;
  public Bitmap bitmap;
  private ap gAC;
  private boolean gEa;
  private AtomicInteger gEb;
  private boolean gEd;
  private Runnable gEe;
  private int gEf;
  private int gEg;
  
  static
  {
    AppMethodBeat.i(156452);
    gEc = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.gAC = new ap(Looper.getMainLooper());
    this.gEa = false;
    this.gEb = new AtomicInteger();
    this.gEd = true;
    this.gEe = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.gEf = 0;
    this.gEg = 0;
    this.bitmap = paramBitmap;
    this.gEb.set(1);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bt.eGN().toString());
    }
    this.gEa = false;
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
  
  private boolean ape()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.gEa + " isMutable:" + this.gEd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.gEb + bt.eGN().toString());
    }
    if ((this.gEa) || (this.gEb.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.gEa = true;
    if (this.DEBUG) {
      gEc.remove(this.bitmap);
    }
    if (this.gEd) {
      l.aoZ().C(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int apf()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ad.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.gEf + " " + toString());
      i = this.gEf;
      AppMethodBeat.o(156446);
      return i;
    }
    this.gEf = this.bitmap.getByteCount();
    int i = this.gEf;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void aoX()
  {
    AppMethodBeat.i(156440);
    this.gEb.incrementAndGet();
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.gEb + " bitmap:" + this.bitmap + " " + this + " " + bt.eGN().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void aoY()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.gEb + " bitmap:" + this.bitmap + " " + this + " " + bt.eGN().toString());
    }
    if (this.gEb.get() > 0)
    {
      this.gEb.decrementAndGet();
      if (this.gEb.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.gAC.removeCallbacks(this.gEe);
      this.gAC.postDelayed(this.gEe, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap apb()
  {
    this.gEd = false;
    return this.bitmap;
  }
  
  public final Bitmap apc()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bt.eGN().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean apd()
  {
    AppMethodBeat.i(156444);
    this.gEb.decrementAndGet();
    if (this.DEBUG) {
      ad.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.gEa + " isMutable:" + this.gEd + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.gEb + bt.eGN().toString());
    }
    ape();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final String apg()
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
    if (d.lg(19))
    {
      i = apf();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ad.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.gEg + " " + toString());
      i = this.gEg;
      AppMethodBeat.o(156447);
      return i;
    }
    this.gEg = this.bitmap.getAllocationByteCount();
    int i = this.gEg;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(156443);
    if ((this.gEa) || (this.bitmap == null) || (this.bitmap.isRecycled()))
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
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.gEb;
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