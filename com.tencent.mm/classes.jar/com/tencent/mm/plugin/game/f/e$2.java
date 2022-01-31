package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.as.a.c.g;
import com.tencent.mm.as.a.d.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements g
{
  e$2(e parame, e.b paramb, e.a parama, ImageView paramImageView) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, b paramb)
  {
    y.d("MicroMsg.GameImageUtil", "onImageLoadFinish, url: " + paramString);
    if ((paramb != null) && (paramb.bitmap != null))
    {
      Object localObject = paramb.bitmap;
      paramb = (b)localObject;
      if (this.lgr.lgz) {
        paramb = e.A((Bitmap)localObject);
      }
      localObject = paramb;
      if (this.lgr.lgD != 0) {
        localObject = c.a(paramb, true, this.lgr.lgD);
      }
      if (this.lgr.erd) {
        e.b(this.lgp).f(paramString, localObject);
      }
      ai.d(new e.2.1(this, (Bitmap)localObject));
      if (this.lgq != null) {
        this.lgq.a(paramView, (Bitmap)localObject);
      }
    }
  }
  
  public final void mv(String paramString)
  {
    y.d("MicroMsg.GameImageUtil", "onImageLoadStart, url: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.2
 * JD-Core Version:    0.7.0.1
 */