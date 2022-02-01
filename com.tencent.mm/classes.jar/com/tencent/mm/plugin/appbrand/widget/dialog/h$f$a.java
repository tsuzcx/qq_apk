package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$UserInfoViewHolder$reanderView$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
public final class h$f$a
  implements b.h
{
  public final Bitmap H(Bitmap paramBitmap)
  {
    AppMethodBeat.i(242530);
    p.k(paramBitmap, "bitmap");
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, a.fromDPToPix(this.rsz.view.getContext(), 4) * 1.0F, false);
    p.j(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
    AppMethodBeat.o(242530);
    return paramBitmap;
  }
  
  public final String key()
  {
    return "appbrand_user_avatar";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h.f.a
 * JD-Core Version:    0.7.0.1
 */