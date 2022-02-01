package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class k$1
  implements Runnable
{
  k$1(Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(103782);
    long l = Util.currentTicks();
    k.e(this.zTP, this.zTQ);
    Log.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(103782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.k.1
 * JD-Core Version:    0.7.0.1
 */