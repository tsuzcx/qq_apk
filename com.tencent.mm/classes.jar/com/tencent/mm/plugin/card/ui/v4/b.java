package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.d.b.c;
import android.support.v7.d.b.d;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"getOverlayColorDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "loadAndOverlayImageFromUrl", "", "view", "Landroid/widget/ImageView;", "url", "", "width", "height", "pickPrimaryColor", "bitmap", "Landroid/graphics/Bitmap;", "defColor", "getPrimaryColorCallback", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "plugin-card_release"})
public final class b
{
  public static final Drawable EE(int paramInt)
  {
    AppMethodBeat.i(201606);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = new ColorDrawable(paramInt);
    localObject2 = new ColorDrawable(a.n((Context)localObject2, 2131099832));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | paramInt & 0xFFFFFF, 0x1A000000 | paramInt & 0xFFFFFF });
    localGradientDrawable.setGradientType(0);
    localObject1 = (Drawable)new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
    AppMethodBeat.o(201606);
    return localObject1;
  }
  
  public static final void a(final ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201605);
    if ((paramString == null) || (paramImageView == null))
    {
      AppMethodBeat.o(201605);
      return;
    }
    com.tencent.mm.plugin.card.d.m.b(paramImageView, paramString, paramInt1, paramInt2, (kotlin.g.a.m)new a(paramString, paramImageView));
    AppMethodBeat.o(201605);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.m<g<?>, Bitmap, x>
  {
    a(String paramString, ImageView paramImageView)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "palette", "Landroid/support/v7/graphics/Palette;", "onGenerated"})
  static final class b
    implements b.c
  {
    b(f paramf, int paramInt) {}
    
    public final void a(android.support.v7.d.b paramb)
    {
      AppMethodBeat.i(201604);
      if (paramb != null)
      {
        paramb = paramb.hh();
        if (paramb != null)
        {
          this.qiz.BN(paramb.hm());
          AppMethodBeat.o(201604);
          return;
        }
        Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated but swatch is null");
        this.qiz.BN(this.qiA);
        AppMethodBeat.o(201604);
        return;
      }
      Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated fail");
      this.qiz.BN(this.qiA);
      AppMethodBeat.o(201604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.b
 * JD-Core Version:    0.7.0.1
 */