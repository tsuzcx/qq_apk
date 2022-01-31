package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> fdR;
  private boolean DEBUG;
  public Bitmap bitmap;
  private ak faV;
  private boolean fdP;
  private AtomicInteger fdQ;
  private boolean fdS;
  private Runnable fdT;
  private int fdU;
  private int fdV;
  
  static
  {
    AppMethodBeat.i(115406);
    fdR = new ConcurrentHashMap();
    AppMethodBeat.o(115406);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115392);
    this.bitmap = null;
    this.DEBUG = false;
    this.faV = new ak(Looper.getMainLooper());
    this.fdP = false;
    this.fdQ = new AtomicInteger();
    this.fdS = true;
    this.fdT = new n.1(this);
    this.fdU = 0;
    this.fdV = 0;
    this.bitmap = paramBitmap;
    this.fdQ.set(1);
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bo.dtY().toString());
    }
    this.fdP = false;
    getAllocationByteCount();
    AppMethodBeat.o(115392);
  }
  
  private boolean XV()
  {
    AppMethodBeat.i(115399);
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.fdP + " isMutable:" + this.fdS + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdQ + bo.dtY().toString());
    }
    if ((this.fdP) || (this.fdQ.get() > 0))
    {
      AppMethodBeat.o(115399);
      return false;
    }
    this.fdP = true;
    if (this.DEBUG) {
      fdR.remove(this.bitmap);
    }
    if (this.fdS) {
      l.XQ().u(this.bitmap);
    }
    AppMethodBeat.o(115399);
    return true;
  }
  
  private final int XW()
  {
    AppMethodBeat.i(115400);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ab.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.fdU + " " + toString());
      i = this.fdU;
      AppMethodBeat.o(115400);
      return i;
    }
    this.fdU = this.bitmap.getByteCount();
    int i = this.fdU;
    AppMethodBeat.o(115400);
    return i;
  }
  
  public static n v(Bitmap paramBitmap)
  {
    AppMethodBeat.i(115393);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(115393);
      return null;
    }
    paramBitmap = new n(paramBitmap);
    AppMethodBeat.o(115393);
    return paramBitmap;
  }
  
  public final void XO()
  {
    AppMethodBeat.i(115394);
    this.fdQ.incrementAndGet();
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.fdQ + " bitmap:" + this.bitmap + " " + this + " " + bo.dtY().toString());
    }
    AppMethodBeat.o(115394);
  }
  
  public final void XP()
  {
    AppMethodBeat.i(115395);
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.fdQ + " bitmap:" + this.bitmap + " " + this + " " + bo.dtY().toString());
    }
    if (this.fdQ.get() > 0)
    {
      this.fdQ.decrementAndGet();
      if (this.fdQ.get() < 0)
      {
        AppMethodBeat.o(115395);
        return;
      }
      this.faV.removeCallbacks(this.fdT);
      this.faV.postDelayed(this.fdT, 500L);
    }
    AppMethodBeat.o(115395);
  }
  
  public final Bitmap XS()
  {
    this.fdS = false;
    return this.bitmap;
  }
  
  public final Bitmap XT()
  {
    AppMethodBeat.i(115396);
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bo.dtY().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(115396);
    return localBitmap;
  }
  
  public final boolean XU()
  {
    AppMethodBeat.i(115398);
    this.fdQ.decrementAndGet();
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.fdP + " isMutable:" + this.fdS + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.fdQ + bo.dtY().toString());
    }
    XV();
    AppMethodBeat.o(115398);
    return true;
  }
  
  public final String XX()
  {
    AppMethodBeat.i(115404);
    String str = this + " " + this.bitmap;
    AppMethodBeat.o(115404);
    return str;
  }
  
  protected void finalize()
  {
    AppMethodBeat.i(115403);
    if (this.DEBUG) {
      ab.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    AppMethodBeat.o(115403);
  }
  
  public final int getAllocationByteCount()
  {
    AppMethodBeat.i(115401);
    if (d.fw(19))
    {
      i = XW();
      AppMethodBeat.o(115401);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ab.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.fdV + " " + toString());
      i = this.fdV;
      AppMethodBeat.o(115401);
      return i;
    }
    this.fdV = this.bitmap.getAllocationByteCount();
    int i = this.fdV;
    AppMethodBeat.o(115401);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(115397);
    if ((this.fdP) || (this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      AppMethodBeat.o(115397);
      return true;
    }
    AppMethodBeat.o(115397);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(115402);
    if (this.DEBUG)
    {
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.fdQ;
      str1 = str2;
      if (this.bitmap != null) {
        str1 = str2 + this.bitmap;
      }
      AppMethodBeat.o(115402);
      return str1;
    }
    String str1 = super.toString();
    AppMethodBeat.o(115402);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.n
 * JD-Core Version:    0.7.0.1
 */