package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.k;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class c$3
  implements Runnable
{
  c$3(c paramc, JsApiChattingTask paramJsApiChattingTask, WxaExposedParams.a parama, q paramq, c.a parama1) {}
  
  public final void run()
  {
    y.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.putExtra("Chat_User", this.gpY.username);
    localIntent.putExtra("app_brand_chatting_from_scene", 2);
    localIntent.putExtra("app_brand_chatting_expose_params", this.gpZ.aes());
    localIntent.putExtra("key_temp_session_from", this.gpY.sessionFrom);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("key_need_send_video", false);
    if (this.gpT.gpP)
    {
      localIntent.putExtra("sendMessageTitle", this.gpT.gpM);
      localIntent.putExtra("sendMessagePath", this.gpT.gpN);
      localIntent.putExtra("sendMessageImg", this.gpT.gpO);
      localIntent.putExtra("sendMessageLocalImg", k.getRealPath(this.gpT.gpQ));
      localIntent.putExtra("needDelThumb", this.gpT.gpR);
    }
    localIntent.putExtra("showMessageCard", this.gpT.gpP);
    MMActivity localMMActivity = (MMActivity)this.gjp.mContext;
    if (localMMActivity == null)
    {
      if (this.gpU != null) {
        this.gpU.a(false, "fail:internal error invalid android context", null);
      }
      y.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
      return;
    }
    localMMActivity.gJb = new c.3.1(this);
    d.c(localMMActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.c.3
 * JD-Core Version:    0.7.0.1
 */