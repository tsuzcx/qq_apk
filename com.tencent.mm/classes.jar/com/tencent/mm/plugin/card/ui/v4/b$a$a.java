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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v4/CardViewUtilsKt$loadAndOverlayImageFromUrl$1$1$1", "Lcom/tencent/mm/plugin/card/ui/v4/GetPrimaryColorCallback;", "onGetColor", "", "color", "", "plugin-card_release"})
public final class b$a$a
  implements f
{
  b$a$a(Bitmap paramBitmap, Context paramContext, b.a parama) {}
  
  public final void BN(int paramInt)
  {
    AppMethodBeat.i(201602);
    long l = com.tencent.mm.loader.l.a.bR(this.qix);
    Log.d("MicroMsg.CardViewUtils", "bitmap size:%d B newsize:%s, url:%s", new Object[] { Long.valueOf(l), Util.getSizeKB(l), this.qiy.mkH });
    Object localObject1 = this.$context;
    p.g(localObject1, "context");
    localObject1 = new BitmapDrawable(((Context)localObject1).getResources(), this.qix);
    Object localObject2 = new ColorDrawable(com.tencent.mm.cb.a.n(this.$context, 2131099832));
    GradientDrawable localGradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { 0xFF000000 | 0xFFFFFF & paramInt, 0x1A000000 | 0xFFFFFF & paramInt });
    localGradientDrawable.setGradientType(0);
    localObject1 = new LayerDrawable(new Drawable[] { (Drawable)localObject1, (Drawable)localGradientDrawable, (Drawable)localObject2 });
    localObject2 = this.qiy.gWz;
    if (localObject2 != null)
    {
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      AppMethodBeat.o(201602);
      return;
    }
    AppMethodBeat.o(201602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.b.a.a
 * JD-Core Version:    0.7.0.1
 */