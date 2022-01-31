package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class e$3
  extends e.b
{
  e$3(e parame, ImageView paramImageView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void a(View paramView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(112331);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      al.d(new e.3.1(this, paramBitmap));
    }
    AppMethodBeat.o(112331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.3
 * JD-Core Version:    0.7.0.1
 */