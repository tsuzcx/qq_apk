package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/widget/dialog/WxaUserInfoListAdapter$ViewHolder$applyData$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "luggage-wechat-full-sdk_release"})
public final class o$d$a
  implements b.h
{
  public final String BN()
  {
    return "appbrand_user_avatar";
  }
  
  public final Bitmap G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(183085);
    p.h(paramBitmap, "bitmap");
    paramBitmap = h.a(paramBitmap, false, a.fromDPToPix(this.nhu.view.getContext(), 4) * 1.0F, false);
    p.g(paramBitmap, "BitmapUtil.getRoundedCor…ontext, 4) * 1.0f, false)");
    AppMethodBeat.o(183085);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.o.d.a
 * JD-Core Version:    0.7.0.1
 */