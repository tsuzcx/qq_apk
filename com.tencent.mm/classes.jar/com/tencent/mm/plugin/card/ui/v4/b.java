package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.widget.ImageView;
import androidx.j.a.b.c;
import androidx.j.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getOverlayColorDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "loadAndOverlayImageFromUrl", "", "view", "Landroid/widget/ImageView;", "url", "", "width", "height", "pickPrimaryColor", "bitmap", "Landroid/graphics/Bitmap;", "defColor", "getPrimaryColorCallback", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "plugin-card_release"})
public final class b
{
  public static final Drawable If(int paramInt)
  {
    AppMethodBeat.i(248407);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = new ColorDrawable(paramInt);
    localObject2 = new ColorDrawable(com.tencent.mm.ci.a.w((Context)localObject2, a.a.UN_BW_0_Alpha_0_1));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | paramInt & 0xFFFFFF, 0x1A000000 | paramInt & 0xFFFFFF });
    localGradientDrawable.setGradientType(0);
    localObject1 = (Drawable)new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
    AppMethodBeat.o(248407);
    return localObject1;
  }
  
  public static final void a(final ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248405);
    if ((paramString == null) || (paramImageView == null))
    {
      AppMethodBeat.o(248405);
      return;
    }
    com.tencent.mm.plugin.card.d.m.b(paramImageView, paramString, paramInt1, paramInt2, (kotlin.g.a.m)new a(paramString, paramImageView));
    AppMethodBeat.o(248405);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.m<g<?>, Bitmap, x>
  {
    a(String paramString, ImageView paramImageView)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/card/ui/v4/CardViewUtilsKt$loadAndOverlayImageFromUrl$1$1$1", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "onGetColor", "", "color", "", "plugin-card_release"})
    public static final class a
      implements i
    {
      a(Bitmap paramBitmap, Context paramContext, b.a parama) {}
      
      public final void Fo(int paramInt)
      {
        AppMethodBeat.i(252036);
        long l = com.tencent.mm.loader.l.a.bR(this.tEt);
        Log.d("MicroMsg.CardViewUtils", "bitmap size:%d B newsize:%s, url:%s", new Object[] { Long.valueOf(l), Util.getSizeKB(l), this.tEu.piM });
        Object localObject1 = this.$context;
        p.j(localObject1, "context");
        localObject1 = new BitmapDrawable(((Context)localObject1).getResources(), this.tEt);
        Object localObject2 = new ColorDrawable(com.tencent.mm.ci.a.w(this.$context, a.a.UN_BW_0_Alpha_0_1));
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | 0xFFFFFF & paramInt, 0x1A000000 | 0xFFFFFF & paramInt });
        localGradientDrawable.setGradientType(0);
        localObject1 = new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
        localObject2 = this.tEu.jHv;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          AppMethodBeat.o(252036);
          return;
        }
        AppMethodBeat.o(252036);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "palette", "Landroidx/palette/graphics/Palette;", "onGenerated"})
  static final class b
    implements b.c
  {
    b(i parami, int paramInt) {}
    
    public final void a(androidx.j.a.b paramb)
    {
      AppMethodBeat.i(246006);
      if (paramb != null)
      {
        paramb = paramb.jT();
        if (paramb != null)
        {
          this.tEv.Fo(paramb.jY());
          AppMethodBeat.o(246006);
          return;
        }
        Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated but swatch is null");
        this.tEv.Fo(this.tEw);
        AppMethodBeat.o(246006);
        return;
      }
      Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated fail");
      this.tEv.Fo(this.tEw);
      AppMethodBeat.o(246006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.b
 * JD-Core Version:    0.7.0.1
 */