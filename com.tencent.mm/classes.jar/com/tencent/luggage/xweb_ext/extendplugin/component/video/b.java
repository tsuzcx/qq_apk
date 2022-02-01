package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;

final class b
  implements c.a
{
  private final float eDb;
  private final float eDc;
  final WeakReference<TextureImageViewLikeImpl> eDd;
  
  public b(j paramj, TextureImageViewLikeImpl paramTextureImageViewLikeImpl)
  {
    AppMethodBeat.i(220983);
    this.eDb = paramj.eEh.eDS;
    this.eDc = paramj.eEh.eDT;
    Log.i("MicroMsg.AppBrand.TextureScaleLogic", "<init>, originWidthScale: %f, originHeightScale: %f", new Object[] { Float.valueOf(this.eDb), Float.valueOf(this.eDc) });
    this.eDd = new WeakReference(paramTextureImageViewLikeImpl);
    AppMethodBeat.o(220983);
  }
  
  public final void a(final boolean paramBoolean, final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(220990);
    Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged: %b, widthScale: %f, heightScale: %f", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    if (paramBoolean)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, justTextureSizeChanged");
      AppMethodBeat.o(220990);
      return;
    }
    if ((TextureImageViewLikeImpl)this.eDd.get() == null)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, textureImageViewLike already release");
      AppMethodBeat.o(220990);
      return;
    }
    float f1 = paramFloat1 / this.eDb;
    float f2 = paramFloat2 / this.eDc;
    if (f1 >= f2)
    {
      paramFloat1 = f2 / f1 * 1.0F;
      paramBoolean = false;
      paramFloat2 = 1.0F;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale, fixedWidthScale: %f, fixedHeightScale: %f, finalWidthScale: %f, finalHeightScale: %f, willScaleWidth: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramFloat2), Float.valueOf(paramFloat1), Boolean.valueOf(paramBoolean) });
      h.ahAA.bk(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220886);
          TextureImageViewLikeImpl localTextureImageViewLikeImpl = (TextureImageViewLikeImpl)b.this.eDd.get();
          if (localTextureImageViewLikeImpl == null)
          {
            Log.i("MicroMsg.AppBrand.TextureScaleLogic", "onTextureScale#ui, textureImageViewLike already release");
            AppMethodBeat.o(220886);
            return;
          }
          if (paramBoolean)
          {
            localTextureImageViewLikeImpl.setTextureViewWidthWeight(paramFloat2);
            AppMethodBeat.o(220886);
            return;
          }
          localTextureImageViewLikeImpl.setTextureViewHeightWeight(paramFloat1);
          AppMethodBeat.o(220886);
        }
      });
      AppMethodBeat.o(220990);
      return;
      paramFloat2 = f1 / f2 * 1.0F;
      paramBoolean = true;
      paramFloat1 = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b
 * JD-Core Version:    0.7.0.1
 */