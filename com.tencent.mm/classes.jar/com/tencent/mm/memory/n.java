package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class n
  implements i
{
  private static ConcurrentHashMap<Bitmap, Integer> heD;
  private boolean DEBUG;
  public Bitmap bitmap;
  private ao gox;
  private boolean heB;
  private AtomicInteger heC;
  private boolean heE;
  private Runnable heF;
  private int heG;
  private int heH;
  
  static
  {
    AppMethodBeat.i(156452);
    heD = new ConcurrentHashMap();
    AppMethodBeat.o(156452);
  }
  
  private n(Bitmap paramBitmap)
  {
    AppMethodBeat.i(156438);
    this.bitmap = null;
    this.DEBUG = false;
    this.gox = new ao(Looper.getMainLooper());
    this.heB = false;
    this.heC = new AtomicInteger();
    this.heE = true;
    this.heF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(156437);
        n.a(n.this);
        AppMethodBeat.o(156437);
      }
    };
    this.heG = 0;
    this.heH = 0;
    this.bitmap = paramBitmap;
    this.heC.set(1);
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "bitmap " + paramBitmap + " " + this.bitmap.hashCode() + " mm: " + hashCode() + " this: " + this + " " + bs.eWi().toString());
    }
    this.heB = false;
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
  
  private boolean avV()
  {
    AppMethodBeat.i(156445);
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "recycleImpl~:" + this.heB + " isMutable:" + this.heE + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.heC + bs.eWi().toString());
    }
    if ((this.heB) || (this.heC.get() > 0))
    {
      AppMethodBeat.o(156445);
      return false;
    }
    this.heB = true;
    if (this.DEBUG) {
      heD.remove(this.bitmap);
    }
    if (this.heE) {
      l.avQ().C(this.bitmap);
    }
    AppMethodBeat.o(156445);
    return true;
  }
  
  private final int avW()
  {
    AppMethodBeat.i(156446);
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ac.i("MicroMsg.ReleasableBitmap", "getByteCount recycle " + this.heG + " " + toString());
      i = this.heG;
      AppMethodBeat.o(156446);
      return i;
    }
    this.heG = this.bitmap.getByteCount();
    int i = this.heG;
    AppMethodBeat.o(156446);
    return i;
  }
  
  public final void avO()
  {
    AppMethodBeat.i(156440);
    this.heC.incrementAndGet();
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "addLiveReference, attachCount:" + this.heC + " bitmap:" + this.bitmap + " " + this + " " + bs.eWi().toString());
    }
    AppMethodBeat.o(156440);
  }
  
  public final void avP()
  {
    AppMethodBeat.i(156441);
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "removeLiveReference, attachCount:" + this.heC + " bitmap:" + this.bitmap + " " + this + " " + bs.eWi().toString());
    }
    if (this.heC.get() > 0)
    {
      this.heC.decrementAndGet();
      if (this.heC.get() < 0)
      {
        AppMethodBeat.o(156441);
        return;
      }
      this.gox.removeCallbacks(this.heF);
      this.gox.postDelayed(this.heF, 500L);
    }
    AppMethodBeat.o(156441);
  }
  
  public final Bitmap avS()
  {
    this.heE = false;
    return this.bitmap;
  }
  
  public final Bitmap avT()
  {
    AppMethodBeat.i(156442);
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "getBitmapReadOnly " + toString() + " " + bs.eWi().toString());
    }
    Bitmap localBitmap = this.bitmap;
    AppMethodBeat.o(156442);
    return localBitmap;
  }
  
  public final boolean avU()
  {
    AppMethodBeat.i(156444);
    this.heC.decrementAndGet();
    if (this.DEBUG) {
      ac.i("MicroMsg.ReleasableBitmap", "recycle~:" + this.heB + " isMutable:" + this.heE + " bitmap:" + this.bitmap + " " + hashCode() + " attachCount: " + this.heC + bs.eWi().toString());
    }
    avV();
    AppMethodBeat.o(156444);
    return true;
  }
  
  public final String avX()
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
      ac.i("MicroMsg.ReleasableBitmap", "bitmap finalize " + toString());
    }
    AppMethodBeat.o(156449);
  }
  
  public final int getAllocationByteCount()
  {
    AppMethodBeat.i(156447);
    if (d.la(19))
    {
      i = avW();
      AppMethodBeat.o(156447);
      return i;
    }
    if ((this.bitmap == null) || (this.bitmap.isRecycled()))
    {
      ac.i("MicroMsg.ReleasableBitmap", "getAllocationByteCount recycle " + this.heH + " " + toString());
      i = this.heH;
      AppMethodBeat.o(156447);
      return i;
    }
    this.heH = this.bitmap.getAllocationByteCount();
    int i = this.heH;
    AppMethodBeat.o(156447);
    return i;
  }
  
  public final boolean isRecycled()
  {
    AppMethodBeat.i(156443);
    if ((this.heB) || (this.bitmap == null) || (this.bitmap.isRecycled()))
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
      String str2 = super.toString() + " code: " + hashCode() + " attachCount: " + this.heC;
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