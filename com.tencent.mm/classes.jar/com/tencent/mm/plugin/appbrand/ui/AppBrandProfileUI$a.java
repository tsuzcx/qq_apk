package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.plugin.appbrand.config.g;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

final class AppBrandProfileUI$a
  implements s.a
{
  final al tXF;
  private final WeakReference<AppBrandProfileUI> udM;
  
  public AppBrandProfileUI$a(AppBrandProfileUI paramAppBrandProfileUI, al paramal)
  {
    AppMethodBeat.i(322102);
    this.udM = new WeakReference(paramAppBrandProfileUI);
    this.tXF = paramal;
    AppMethodBeat.o(322102);
  }
  
  final void cLp()
  {
    AppMethodBeat.i(322113);
    AppBrandProfileUI localAppBrandProfileUI = (AppBrandProfileUI)this.udM.get();
    if (localAppBrandProfileUI == null)
    {
      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "realDoEnter, ui is null");
      AppMethodBeat.o(322113);
      return;
    }
    if (8 == AppBrandProfileUI.e(localAppBrandProfileUI))
    {
      Log.i("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "realDoEnter, from service chatting");
      localAppBrandProfileUI.finish();
      AppMethodBeat.o(322113);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", this.tXF.username);
    localIntent.putExtra("app_brand_chatting_expose_params", AppBrandProfileUI.f(localAppBrandProfileUI));
    localIntent.putExtra("finish_direct", true);
    g localg = g.qWE;
    if (!g.ckz()) {
      localIntent.putExtra("key_need_send_video", false);
    }
    localIntent.putExtra("app_brand_chatting_from_scene_new", 7);
    localIntent.putExtra("app_brand_chatting_from_app_id", this.tXF.appId);
    c.g(localAppBrandProfileUI, ".ui.chatting.AppBrandServiceChattingUI", localIntent);
    AppMethodBeat.o(322113);
  }
  
  public final void onGetWeAppInfo(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(322106);
    if (paramWxaAttributes == null) {
      Log.w("MicroMsg.AppBrand.Profile.AppBrandProfileUI", "onGetWeAppInfo, wxaAttrs is null");
    }
    cLp();
    AppMethodBeat.o(322106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.a
 * JD-Core Version:    0.7.0.1
 */