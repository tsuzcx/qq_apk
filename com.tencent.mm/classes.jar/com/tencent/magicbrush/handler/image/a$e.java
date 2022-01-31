package com.tencent.magicbrush.handler.image;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class a$e
  implements Runnable
{
  private String bKZ;
  private volatile boolean bLa;
  private WeakReference<MBRuntime> bLb;
  private WeakReference<a> bLc;
  private final a.e.a bLd;
  
  a$e(MBRuntime paramMBRuntime, a parama, String paramString)
  {
    AppMethodBeat.i(115969);
    this.bLa = false;
    this.bLd = new a.e.a();
    this.bKZ = paramString;
    this.bLb = new WeakReference(paramMBRuntime);
    this.bLc = new WeakReference(parama);
    AppMethodBeat.o(115969);
  }
  
  public final void run()
  {
    AppMethodBeat.i(115970);
    if (this.bLa)
    {
      AppMethodBeat.o(115970);
      return;
    }
    if (this.bLc.get() == null)
    {
      AppMethodBeat.o(115970);
      return;
    }
    IBitmap localIBitmap = ((a)this.bLc.get()).loadBitmapSync(this.bKZ);
    if (this.bLa)
    {
      if (localIBitmap != null) {
        localIBitmap.recycle();
      }
      AppMethodBeat.o(115970);
      return;
    }
    MBRuntime localMBRuntime = (MBRuntime)this.bLb.get();
    if ((localMBRuntime == null) || (this.bLa))
    {
      if (localIBitmap != null) {
        localIBitmap.recycle();
      }
      AppMethodBeat.o(115970);
      return;
    }
    localMBRuntime.notifyImageDecoded(this.bKZ, localIBitmap, this.bLd);
    AppMethodBeat.o(115970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.e
 * JD-Core Version:    0.7.0.1
 */