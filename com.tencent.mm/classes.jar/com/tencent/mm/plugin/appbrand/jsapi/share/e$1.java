package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

final class e$1
  implements MMActivity.a
{
  e$1(e parame, MMActivity paramMMActivity, String paramString1, String paramString2, p paramp, int paramInt) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 == -1)
      {
        h.bC(this.byc, this.byc.getResources().getString(y.j.app_shared));
        e.b(this.val$appId, this.dlh, "", 1, paramInt2);
        y.i("MicroMsg.JsApiShareTimeline", "result is success");
        this.gbW.C(this.dIS, this.gBD.h("success", null));
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.JsApiShareTimeline", "result is cancel");
    this.gbW.C(this.dIS, this.gBD.h("cancel", null));
    e.b(this.val$appId, this.dlh, "", 3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.e.1
 * JD-Core Version:    0.7.0.1
 */