package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

final class b
  implements c.a
{
  private final float cun;
  private final float cuo;
  final WeakReference<TextureImageViewLikeImpl> cup;
  
  public b(j paramj, TextureImageViewLikeImpl paramTextureImageViewLikeImpl)
  {
    AppMethodBeat.i(186802);
    this.cun = paramj.cvq.cvc;
    this.cuo = paramj.cvq.cvd;
    ad.i("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", new Object[] { Float.valueOf(this.cun), Float.valueOf(this.cuo) });
    this.cup = new WeakReference(paramTextureImageViewLikeImpl);
    AppMethodBeat.o(186802);
  }
  
  public final void a(final boolean paramBoolean, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(186803);
    ad.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramBoolean)
    {
      ad.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
      AppMethodBeat.o(186803);
      return;
    }
    if ((TextureImageViewLikeImpl)this.cup.get() == null)
    {
      ad.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
      AppMethodBeat.o(186803);
      return;
    }
    float f1 = paramFloat1 / this.cun;
    float f2 = paramFloat2 / this.cuo;
    if (f1 >= f2)
    {
      paramFloat1 = f2 / f1 * 1.0F;
      paramBoolean = false;
      paramFloat2 = 1.0F;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(paramBoolean) });
      h.LTJ.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186801);
          TextureImageViewLikeImpl localTextureImageViewLikeImpl = (TextureImageViewLikeImpl)b.this.cup.get();
          if (localTextureImageViewLikeImpl == null)
          {
            ad.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
            AppMethodBeat.o(186801);
            return;
          }
          if (paramBoolean)
          {
            localTextureImageViewLikeImpl.setTextureViewWidthWeight(paramFloat2);
            AppMethodBeat.o(186801);
            return;
          }
          localTextureImageViewLikeImpl.setTextureViewHeightWeight(paramFloat1);
          AppMethodBeat.o(186801);
        }
      });
      AppMethodBeat.o(186803);
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