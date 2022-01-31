package com.tencent.mm.plugin.facedetect.model;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class o$1
  implements Runnable
{
  o$1(Bitmap paramBitmap, String paramString) {}
  
  public final void run()
  {
    long l = bk.UZ();
    o.b(this.jON, this.jOO);
    y.i("MicroMsg.FaceUtils", "hy: saving blur bm using: %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.o.1
 * JD-Core Version:    0.7.0.1
 */