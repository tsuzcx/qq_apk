package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class p$1
  implements Runnable
{
  p$1(Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(262);
    long l = bo.yB();
    p.b(this.mjd, this.mje);
    ab.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.p.1
 * JD-Core Version:    0.7.0.1
 */