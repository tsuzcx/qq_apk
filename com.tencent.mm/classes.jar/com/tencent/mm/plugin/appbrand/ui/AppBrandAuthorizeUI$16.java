package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;

final class AppBrandAuthorizeUI$16
  implements b.h
{
  AppBrandAuthorizeUI$16(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final Bitmap J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(227576);
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, false, a.fromDPToPix(this.nRR.getContext(), 4), false);
    AppMethodBeat.o(227576);
    return paramBitmap;
  }
  
  public final String Lb()
  {
    return "setting_wxa_user_info_icon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.16
 * JD-Core Version:    0.7.0.1
 */