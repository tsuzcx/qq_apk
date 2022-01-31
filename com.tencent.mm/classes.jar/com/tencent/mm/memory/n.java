package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> dPl = new ConcurrentHashMap();
  private boolean DEBUG = false;
  public Bitmap bitmap = null;
  private ah dPi = new ah(Looper.getMainLooper());
  private boolean dPj = false;
  private AtomicInteger dPk = new AtomicInteger();
  private boolean dPm = true;
  private Runnable dPn = new n.1(this);
  private int dPo = 0;
  private int dPp = 0;
  
  private n(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
    this.dPk.set(1);
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bk.csb().toString());
    }
    this.dPj = false;
    getAllocationByteCount();
  }
  
  private boolean Fg()
  {
    boolean bool = true;
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.dPj + " isMutable:" + this.dPm + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.dPk + bk.csb().toString());
    }
    if ((this.dPj) || (this.dPk.get() > 0)) {
      bool = false;
    }
    do
    {
      return bool;
      this.dPj = true;
      if (this.DEBUG) {
        dPl.remove(this.bitmap);
      }
    } while (!this.dPm);
    l.Fb().n(this.bitmap);
    return true;
  }
  
  public static n o(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new n(paramBitmap);
  }
  
  public final void EZ()
  {
    this.dPk.incrementAndGet();
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.dPk + " bitmap:" + this.bitmap + " " + this + " " + bk.csb().toString());
    }
  }
  
  public final void Fa()
  {
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.dPk + " bitmap:" + this.bitmap + " " + this + " " + bk.csb().toString());
    }
    if (this.dPk.get() > 0)
    {
      this.dPk.decrementAndGet();
      if (this.dPk.get() >= 0) {}
    }
    else
    {
      return;
    }
    this.dPi.removeCallbacks(this.dPn);
    this.dPi.postDelayed(this.dPn, 500L);
  }
  
  public final Bitmap Fd()
  {
    this.dPm = false;
    return this.bitmap;
  }
  
  public final Bitmap Fe()
  {
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bk.csb().toString());
    }
    return this.bitmap;
  }
  
  public final boolean Ff()
  {
    this.dPk.decrementAndGet();
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.dPj + " isMutable:" + this.dPm + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.dPk + bk.csb().toString());
    }
    Fg();
    return true;
  }
  
  public final String Fh()
  {
    return this + " " + this.bitmap;
  }
  
  protected final void finalize()
  {
    if (this.DEBUG) {
      y.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
  }
  
  public final int getAllocationByteCount()
  {
    if (d.gG(19))
    {
      if ((this.bitmap == null) || (this.bitmap.isRecycled()))
      {
        y.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.dPo + " " + toString());
        return this.dPo;
      }
      this.dPo = this.bitmap.getByteCount();
      return this.dPo;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      y.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.dPp + " " + toString());
      return this.dPp;
    }
    this.dPp = this.bitmap.getAllocationByteCount();
    return this.dPp;
  }
  
  public final boolean isRecycled()
  {
    return (this.dPj) || (this.bitmap == null) || (this.bitmap.isRecycled());
  }
  
  public final String toString()
  {
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.dPk;
      String str1 = str2;
      if (this.bitmap != null) {
        str1 = str2 + this.bitmap;
      }
      return str1;
    }
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.n
 * JD-Core Version:    0.7.0.1
 */