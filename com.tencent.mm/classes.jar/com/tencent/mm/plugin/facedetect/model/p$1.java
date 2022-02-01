package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class p$1
  implements Runnable
{
  p$1(Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(103782);
    long l = bt.GC();
    p.b(this.pPO, this.pPP);
    ad.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(103782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.p.1
 * JD-Core Version:    0.7.0.1
 */