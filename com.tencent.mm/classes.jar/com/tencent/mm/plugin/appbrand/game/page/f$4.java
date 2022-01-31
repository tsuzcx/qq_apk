package com.tencent.mm.plugin.appbrand.game.page;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.sdk.platformtools.y;

final class f$4
  implements WAGamePageViewContainerLayout.a
{
  f$4(f paramf) {}
  
  public final void a(WAGamePageViewContainerLayout.b paramb1, WAGamePageViewContainerLayout.b paramb2)
  {
    y.v("AppBrandGame.WAGamePageView", "hy: after change. old direction:%s, new direction: %s", new Object[] { paramb1, paramb2 });
    if ((f.c(this.gcI) == null) || (f.c(this.gcI).content == null)) {
      y.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
    }
    while (((f.a(paramb1)) && (f.a(paramb2))) || ((f.b(paramb1)) && (f.b(paramb2)))) {
      return;
    }
    if (f.a(paramb2))
    {
      Matrix localMatrix = new Matrix();
      if (((paramb2 == WAGamePageViewContainerLayout.b.gcM) && (paramb1 == WAGamePageViewContainerLayout.b.gcN)) || ((paramb2 == WAGamePageViewContainerLayout.b.gcO) && (paramb1 == WAGamePageViewContainerLayout.b.gcP))) {
        localMatrix.postRotate(90.0F);
      }
      for (;;)
      {
        f.d(this.gcI).setVisibility(0);
        f.d(this.gcI).setImageBitmap(Bitmap.createBitmap(f.c(this.gcI).content, 0, 0, f.c(this.gcI).content.getWidth(), f.c(this.gcI).content.getHeight(), localMatrix, true));
        f.e(this.gcI);
        return;
        localMatrix.postRotate(270.0F);
      }
    }
    f.f(this.gcI);
    f.g(this.gcI).setOnConfigurationChangedListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.f.4
 * JD-Core Version:    0.7.0.1
 */