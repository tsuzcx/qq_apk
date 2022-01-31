package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.k;
import com.tencent.mm.ui.base.i;

public final class d
{
  public static i cw(Context paramContext)
  {
    View localView = View.inflate(paramContext, y.h.appbrand_loading_dialog_layout, null);
    i locali = new i(paramContext, y.k.AppBrandLoadingDialogStyle);
    locali.setContentView(localView);
    locali.setCancelable(true);
    locali.setCanceledOnTouchOutside(false);
    locali.setOnCancelListener(new d.1(paramContext, locali));
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.d
 * JD-Core Version:    0.7.0.1
 */