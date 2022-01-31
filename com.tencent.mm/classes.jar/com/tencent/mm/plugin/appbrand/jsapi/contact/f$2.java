package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class f$2
  implements Runnable
{
  f$2(f paramf, JsApiChattingTask paramJsApiChattingTask, v paramv, f.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(131021);
    ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.putExtra("Chat_User", this.hKI.username);
    localIntent.putExtra("app_brand_chatting_from_scene", 2);
    localIntent.putExtra("key_temp_session_from", this.hKI.sessionFrom);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("key_need_send_video", false);
    Object localObject = new WxaExposedParams.a();
    ((WxaExposedParams.a)localObject).appId = this.hKQ.hKL;
    ((WxaExposedParams.a)localObject).username = this.hKQ.hKM;
    ((WxaExposedParams.a)localObject).from = 5;
    localIntent.putExtra("app_brand_chatting_expose_params", ((WxaExposedParams.a)localObject).ayJ());
    localIntent.putExtra("keyPrivateAppId", this.hKQ.hKL);
    localIntent.putExtra("keyPrivateUserName", this.hKQ.hKM);
    localIntent.putExtra("keyPrivateTitle", this.hKQ.hKN);
    localIntent.putExtra("keyPrivateSubTitle", this.hKQ.hKO);
    localIntent.putExtra("keyPrivateHeadImage", this.hKQ.hKP);
    localObject = (MMActivity)this.hxy.getContext();
    if (localObject == null)
    {
      if (this.hKR != null) {
        this.hKR.a(false, "fail:internal error invalid android context", null);
      }
      ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
      AppMethodBeat.o(131021);
      return;
    }
    ((MMActivity)localObject).mmSetOnActivityResultCallback(new f.2.1(this));
    d.b((Context)localObject, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
    AppMethodBeat.o(131021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.f.2
 * JD-Core Version:    0.7.0.1
 */