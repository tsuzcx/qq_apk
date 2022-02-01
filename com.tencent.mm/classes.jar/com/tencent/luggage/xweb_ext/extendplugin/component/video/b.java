package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;

final class b
  implements c.a
{
  private final float cuQ;
  private final float cuR;
  final WeakReference<TextureImageViewLikeImpl> cuS;
  
  public b(j paramj, TextureImageViewLikeImpl paramTextureImageViewLikeImpl)
  {
    AppMethodBeat.i(220485);
    this.cuQ = paramj.cvU.cvF;
    this.cuR = paramj.cvU.cvG;
    ae.i("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", new Object[] { Float.valueOf(this.cuQ), Float.valueOf(this.cuR) });
    this.cuS = new WeakReference(paramTextureImageViewLikeImpl);
    AppMethodBeat.o(220485);
  }
  
  public final void a(final boolean paramBoolean, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(220486);
    ae.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramBoolean)
    {
      ae.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
      AppMethodBeat.o(220486);
      return;
    }
    if ((TextureImageViewLikeImpl)this.cuS.get() == null)
    {
      ae.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
      AppMethodBeat.o(220486);
      return;
    }
    float f1 = paramFloat1 / this.cuQ;
    float f2 = paramFloat2 / this.cuR;
    if (f1 >= f2)
    {
      paramFloat1 = f2 / f1 * 1.0F;
      paramBoolean = false;
      paramFloat2 = 1.0F;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(paramBoolean) });
      h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220484);
          TextureImageViewLikeImpl localTextureImageViewLikeImpl = (TextureImageViewLikeImpl)b.this.cuS.get();
          if (localTextureImageViewLikeImpl == null)
          {
            ae.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
            AppMethodBeat.o(220484);
            return;
          }
          if (paramBoolean)
          {
            localTextureImageViewLikeImpl.setTextureViewWidthWeight(paramFloat2);
            AppMethodBeat.o(220484);
            return;
          }
          localTextureImageViewLikeImpl.setTextureViewHeightWeight(paramFloat1);
          AppMethodBeat.o(220484);
        }
      });
      AppMethodBeat.o(220486);
      return;
      paramFloat2 = f1 / f2 * 1.0F;
      paramBoolean = true;
      paramFloat1 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b
 * JD-Core Version:    0.7.0.1
 */