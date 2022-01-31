package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.s;

final class c$8
  implements MMActivity.a
{
  c$8(c paramc, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 100)
    {
      this.gkx.gku = 1;
      if (paramInt2 != -1) {
        break label173;
      }
      this.gkx.gkv = 1;
      y.i("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_OK");
      com.tencent.mm.plugin.report.service.h.nFQ.f(14249, new Object[] { this.gkx.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.gkx.gku), Integer.valueOf(this.gkx.gkv), Integer.valueOf(this.gkx.gkt) });
      com.tencent.mm.ui.base.h.bC(this.gkC.mController.uMN, this.gkC.getResources().getString(y.j.app_brand_get_phone_number_bind_success));
      this.gkx.aie();
    }
    for (;;)
    {
      this.gkC.gJb = null;
      return;
      label173:
      this.gkx.gkv = 0;
      this.gkx.gkh.C(this.gkx.gfg, this.gkx.h("fail:user cancel", null));
      y.e("MicroMsg.JsApiGetPhoneNumber", "mmOnActivityResult RESULT_CANCEL OR RESULT_FIRST_USER");
      com.tencent.mm.plugin.report.service.h.nFQ.f(14249, new Object[] { this.gkx.gkh.mAppId, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.gkx.gku), Integer.valueOf(this.gkx.gkv), Integer.valueOf(this.gkx.gkt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.8
 * JD-Core Version:    0.7.0.1
 */