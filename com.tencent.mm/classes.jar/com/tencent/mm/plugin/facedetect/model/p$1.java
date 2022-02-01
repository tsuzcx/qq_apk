package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class p$1
  implements Runnable
{
  p$1(Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(103782);
    long l = bs.Gn();
    p.b(this.qyw, this.qyx);
    ac.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(103782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.p.1
 * JD-Core Version:    0.7.0.1
 */