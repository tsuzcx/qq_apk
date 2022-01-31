package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class e$4
  extends e.b
{
  e$4(e parame, e.b paramb, int paramInt1, int paramInt2, String paramString) {}
  
  public final void a(View paramView, Bitmap paramBitmap)
  {
    y.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      Bitmap localBitmap = e.b(paramBitmap, this.aUo, this.aUp);
      y.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
      paramBitmap = localBitmap;
      if (this.lgx != 0) {
        paramBitmap = c.a(localBitmap, true, this.lgx);
      }
      e.b(this.lgp).f(this.val$url, paramBitmap);
      if (this.lgw != null) {
        this.lgw.a(paramView, paramBitmap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.4
 * JD-Core Version:    0.7.0.1
 */