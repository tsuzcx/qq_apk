package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements View.OnClickListener
{
  f$2(f paramf, q paramq) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do know the auth auto fill data protocol");
    paramView = this.gkf.mContext.getString(y.j.app_brand_auth_user_auto_fill_data_url);
    paramView = paramView + x.cqJ();
    y.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "do open url:" + paramView);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    d.b(this.gkf.mContext, "webview", ".ui.tools.WebViewUI", localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.f.2
 * JD-Core Version:    0.7.0.1
 */