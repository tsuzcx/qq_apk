package com.tencent.mm.plugin.appbrand.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.luggage.sdk.config.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.RelievedBuySetting;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;

final class h$2
  implements AppBrandUILoadingSplash.a
{
  h$2(w paramw) {}
  
  public final void a(ViewStub paramViewStub)
  {
    AppMethodBeat.i(321979);
    if ((g.mq(this.qrd.getInitConfig().qYr)) && (((c)h.ax(c.class)).a(c.a.zqA, 0) == 1))
    {
      paramViewStub.setLayoutResource(ba.g.app_brand_splash_brand_official_label);
      paramViewStub.inflate();
    }
    AppMethodBeat.o(321979);
  }
  
  public final void b(ViewStub paramViewStub)
  {
    AppMethodBeat.i(321984);
    if ((g.da(this.qrd.getInitConfig().nOX, 5)) && (((c)h.ax(c.class)).a(c.a.znj, 0) == 1))
    {
      paramViewStub.setLayoutResource(ba.g.app_brand_splash_trading_guarantee_label);
      paramViewStub = (ImageView)paramViewStub.inflate().findViewById(ba.f.icon);
      int i = ba.h.app_brand_relieved_buy_loading_logo;
      Log.i("MicroMsg.WxaRelievedBuyIconApply", "applyGrayIcon");
      String str = AppBrandGlobalSystemConfig.ckD().qXt.qXP;
      int j = AppBrandGlobalSystemConfig.ckD().qXt.qXQ;
      int k = AppBrandGlobalSystemConfig.ckD().qXt.qXR;
      if ((!TextUtils.isEmpty(str)) && (j > 0) && (k > 0))
      {
        ViewGroup.LayoutParams localLayoutParams = paramViewStub.getLayoutParams();
        localLayoutParams.width = ((int)(j * localLayoutParams.height / k));
        paramViewStub.setLayoutParams(localLayoutParams);
        b.bEY().a(paramViewStub, str, i, null);
        AppMethodBeat.o(321984);
        return;
      }
      paramViewStub.setImageResource(i);
    }
    AppMethodBeat.o(321984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h.2
 * JD-Core Version:    0.7.0.1
 */