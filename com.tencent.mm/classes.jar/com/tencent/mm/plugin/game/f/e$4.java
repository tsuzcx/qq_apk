package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;

final class e$4
  extends e.b
{
  e$4(e parame, e.b paramb, int paramInt1, int paramInt2, String paramString) {}
  
  public final void a(View paramView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(112332);
    ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = e.c(paramBitmap, this.val$width, this.val$height);
      ab.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
      paramBitmap = localBitmap;
      if (this.nEs != 0) {
        paramBitmap = d.a(localBitmap, true, this.nEs);
      }
      e.b(this.nEk).f(this.val$url, paramBitmap);
      if (this.nEr != null) {
        this.nEr.a(paramView, paramBitmap);
      }
    }
    AppMethodBeat.o(112332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.4
 * JD-Core Version:    0.7.0.1
 */