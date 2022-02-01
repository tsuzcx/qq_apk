package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai.e.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class b
  implements c.a
{
  private final float cJs;
  private final float cJt;
  final WeakReference<TextureImageViewLikeImpl> cJu;
  
  public b(j paramj, TextureImageViewLikeImpl paramTextureImageViewLikeImpl)
  {
    AppMethodBeat.i(224333);
    this.cJs = paramj.cKw.cKh;
    this.cJt = paramj.cKw.cKi;
    Log.i("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", new Object[] { Float.valueOf(this.cJs), Float.valueOf(this.cJt) });
    this.cJu = new WeakReference(paramTextureImageViewLikeImpl);
    AppMethodBeat.o(224333);
  }
  
  public final void a(final boolean paramBoolean, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(224345);
    Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramBoolean)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
      AppMethodBeat.o(224345);
      return;
    }
    if ((TextureImageViewLikeImpl)this.cJu.get() == null)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
      AppMethodBeat.o(224345);
      return;
    }
    float f1 = paramFloat1 / this.cJs;
    float f2 = paramFloat2 / this.cJt;
    if (f1 >= f2)
    {
      paramFloat1 = f2 / f1 * 1.0F;
      paramBoolean = false;
      paramFloat2 = 1.0F;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(paramBoolean) });
      h.ZvG.bc(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(223463);
          TextureImageViewLikeImpl localTextureImageViewLikeImpl = (TextureImageViewLikeImpl)b.this.cJu.get();
          if (localTextureImageViewLikeImpl == null)
          {
            Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
            AppMethodBeat.o(223463);
            return;
          }
          if (paramBoolean)
          {
            localTextureImageViewLikeImpl.setTextureViewWidthWeight(paramFloat2);
            AppMethodBeat.o(223463);
            return;
          }
          localTextureImageViewLikeImpl.setTextureViewHeightWeight(paramFloat1);
          AppMethodBeat.o(223463);
        }
      });
      AppMethodBeat.o(224345);
      return;
      paramFloat2 = f1 / f2 * 1.0F;
      paramBoolean = true;
      paramFloat1 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b
 * JD-Core Version:    0.7.0.1
 */