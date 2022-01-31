package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2$1
  implements Runnable
{
  e$2$1(e.2 param2, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(112327);
    if (this.nEo.mPw != null) {
      this.nEo.mPw.setImageBitmap(this.nEn);
    }
    AppMethodBeat.o(112327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.2.1
 * JD-Core Version:    0.7.0.1
 */