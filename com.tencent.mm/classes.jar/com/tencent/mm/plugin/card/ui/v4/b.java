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
import androidx.j.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"getOverlayColorDrawable", "Landroid/graphics/drawable/Drawable;", "color", "", "loadAndOverlayImageFromUrl", "", "view", "Landroid/widget/ImageView;", "url", "", "width", "height", "pickPrimaryColor", "bitmap", "Landroid/graphics/Bitmap;", "defColor", "getPrimaryColorCallback", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "plugin-card_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Drawable II(int paramInt)
  {
    AppMethodBeat.i(294372);
    Object localObject2 = MMApplicationContext.getContext();
    Object localObject1 = new ColorDrawable(paramInt);
    localObject2 = new ColorDrawable(com.tencent.mm.cd.a.w((Context)localObject2, a.a.UN_BW_0_Alpha_0_1));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | paramInt & 0xFFFFFF, 0x1A000000 | paramInt & 0xFFFFFF });
    localGradientDrawable.setGradientType(0);
    localObject1 = (Drawable)new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
    AppMethodBeat.o(294372);
    return localObject1;
  }
  
  public static final void a(Bitmap paramBitmap, int paramInt, h paramh)
  {
    AppMethodBeat.i(294348);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      androidx.j.a.b.l(paramBitmap).a(new b..ExternalSyntheticLambda0(paramh, paramInt));
      AppMethodBeat.o(294348);
      return;
    }
    Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, bitmap is null");
    paramh.onGetColor(paramInt);
    AppMethodBeat.o(294348);
  }
  
  public static final void a(final ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(294356);
    if ((paramString == null) || (paramImageView == null))
    {
      AppMethodBeat.o(294356);
      return;
    }
    com.tencent.mm.plugin.card.c.m.b(paramImageView, paramString, paramInt1, paramInt2, (kotlin.g.a.m)new a(paramString, paramImageView));
    AppMethodBeat.o(294356);
  }
  
  private static final void a(h paramh, int paramInt, androidx.j.a.b paramb)
  {
    AppMethodBeat.i(294385);
    if (paramb != null)
    {
      paramb = paramb.bTd;
      if (paramb != null)
      {
        paramh.onGetColor(paramb.bTp);
        AppMethodBeat.o(294385);
        return;
      }
      Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated but swatch is null");
      paramh.onGetColor(paramInt);
      AppMethodBeat.o(294385);
      return;
    }
    Log.i("MicroMsg.CardViewUtils", "getPrimaryColor, palette generated fail");
    paramh.onGetColor(paramInt);
    AppMethodBeat.o(294385);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "imageView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<g<?>, Bitmap, ah>
  {
    a(String paramString, ImageView paramImageView)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v4/CardViewUtilsKt$loadAndOverlayImageFromUrl$1$1$1", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "onGetColor", "", "color", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h
    {
      a(Bitmap paramBitmap, String paramString, Context paramContext, ImageView paramImageView) {}
      
      public final void onGetColor(int paramInt)
      {
        AppMethodBeat.i(294311);
        long l = com.tencent.mm.loader.k.a.dl(this.wIc);
        Log.d("MicroMsg.CardViewUtils", "bitmap size:%d B newsize:%s, url:%s", new Object[] { Long.valueOf(l), Util.getSizeKB(l), this.mrs });
        Object localObject1 = new BitmapDrawable(this.$context.getResources(), this.wIc);
        Object localObject2 = new ColorDrawable(com.tencent.mm.cd.a.w(this.$context, a.a.UN_BW_0_Alpha_0_1));
        GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | 0xFFFFFF & paramInt, 0x1A000000 | 0xFFFFFF & paramInt });
        localGradientDrawable.setGradientType(0);
        localObject1 = new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
        localObject2 = this.wIb;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        }
        AppMethodBeat.o(294311);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.b
 * JD-Core Version:    0.7.0.1
 */