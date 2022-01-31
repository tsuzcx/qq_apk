package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c$2
  implements n
{
  c$2(c paramc, n paramn) {}
  
  public void onTakePhotoComplete(Bitmap paramBitmap)
  {
    AppMethodBeat.i(146401);
    if (this.a != null) {
      this.a.onTakePhotoComplete(paramBitmap);
    }
    AppMethodBeat.o(146401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.c.2
 * JD-Core Version:    0.7.0.1
 */