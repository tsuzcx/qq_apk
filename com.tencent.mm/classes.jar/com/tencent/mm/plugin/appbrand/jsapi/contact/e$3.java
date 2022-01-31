package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

final class e$3
  implements Runnable
{
  e$3(e parame, JsApiChattingTask paramJsApiChattingTask, WxaExposedParams.a parama, z paramz, e.a parama1) {}
  
  public final void run()
  {
    AppMethodBeat.i(131003);
    ab.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    localIntent.putExtra("Chat_User", this.hKI.username);
    localIntent.putExtra("app_brand_chatting_from_scene", 2);
    localIntent.putExtra("app_brand_chatting_expose_params", this.hKJ.ayJ());
    localIntent.putExtra("key_temp_session_from", this.hKI.sessionFrom);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("key_need_send_video", false);
    if (this.hKC.hKy)
    {
      localIntent.putExtra("sendMessageTitle", this.hKC.hKv);
      localIntent.putExtra("sendMessagePath", this.hKC.hKw);
      localIntent.putExtra("sendMessageImg", this.hKC.hKx);
      localIntent.putExtra("sendMessageLocalImg", l.getRealPath(this.hKC.hKz));
      localIntent.putExtra("needDelThumb", this.hKC.hKA);
    }
    localIntent.putExtra("showMessageCard", this.hKC.hKy);
    MMActivity localMMActivity = (MMActivity)this.hKE.getContext();
    if (localMMActivity == null)
    {
      if (this.hKD != null) {
        this.hKD.a(false, "fail:internal error invalid android context", null);
      }
      ab.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
      AppMethodBeat.o(131003);
      return;
    }
    localMMActivity.mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(131002);
        if (paramAnonymousInt1 == 1)
        {
          if (e.3.this.hKD != null) {
            e.3.this.hKD.a(true, "ok", paramAnonymousIntent);
          }
          e.3.this.hKI.aBk();
        }
        AppMethodBeat.o(131002);
      }
    });
    d.b(localMMActivity, ".ui.chatting.AppBrandServiceChattingUI", localIntent, 1);
    AppMethodBeat.o(131003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.e.3
 * JD-Core Version:    0.7.0.1
 */