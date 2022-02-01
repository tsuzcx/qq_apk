package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> hzz;
  private boolean DEBUG;
  public Bitmap bitmap;
  private aq gKO;
  private boolean hzA;
  private Runnable hzB;
  private int hzC;
  private int hzD;
  private boolean hzx;
  private AtomicInteger hzy;
  
  static
  {
    AppMethodBeat.i(156452);
    hzz = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.gKO = new aq(Looper.getMainLooper());
    this.hzx = false;
    this.hzy = new AtomicInteger();
    this.hzA = true;
    this.hzB = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.hzC = 0;
    this.hzD = 0;
    this.bitmap = paramBitmap;
    this.hzy.set(1);
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bu.fpN().toString());
    }
    this.hzx = false;
    getAllocationByteCount();
    AppMethodBeat.o(156438);
  }
  
  public static n E(Bitmap paramBitmap)
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
  
  private boolean ayX()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.hzx + " isMutable:" + this.hzA + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hzy + bu.fpN().toString());
    }
    if ((this.hzx) || (this.hzy.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.hzx = true;
    if (this.DEBUG) {
      hzz.remove(this.bitmap);
    }
    if (this.hzA) {
      l.ayS().D(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int ayY()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ae.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.hzC + " " + toString());
      i = this.hzC;
      AppMethodBeat.o(156446);
      return i;
    }
    this.hzC = this.bitmap.getByteCount();
    int i = this.hzC;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void ayQ()
  {
    AppMethodBeat.i(156440);
    this.hzy.incrementAndGet();
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.hzy + " bitmap:" + this.bitmap + " " + this + " " + bu.fpN().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void ayR()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.hzy + " bitmap:" + this.bitmap + " " + this + " " + bu.fpN().toString());
    }
    if (this.hzy.get() > 0)
    {
      this.hzy.decrementAndGet();
      if (this.hzy.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.gKO.removeCallbacks(this.hzB);
      this.gKO.postDelayed(this.hzB, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap ayU()
  {
    this.hzA = false;
    return this.bitmap;
  }
  
  public final Bitmap ayV()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bu.fpN().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean ayW()
  {
    AppMethodBeat.i(156444);
    this.hzy.decrementAndGet();
    if (this.DEBUG) {
      ae.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.hzx + " isMutable:" + this.hzA + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.hzy + bu.fpN().toString());
    }
    ayX();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final String ayZ()
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
      ae.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    AppMethodBeat.o(156449);
  }
  
  public final int getAllocationByteCount()
  {
    AppMethodBeat.i(156447);
    if (d.lB(19))
    {
      i = ayY();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ae.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.hzD + " " + toString());
      i = this.hzD;
      AppMethodBeat.o(156447);
      return i;
    }
    this.hzD = this.bitmap.getAllocationByteCount();
    int i = this.hzD;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(156443);
    if ((this.hzx) || (this.bitmap == null) || (this.bitmap.isRecycled()))
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
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.hzy;
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