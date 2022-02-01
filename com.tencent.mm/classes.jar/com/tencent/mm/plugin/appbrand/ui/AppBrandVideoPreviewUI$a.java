package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$a
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51155);
    ad.i(this.lDR.TAG, "hy: request start to appid " + AppBrandVideoPreviewUI.c(this.lDR));
    paramView = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramView, "MMKernel.service(IMessengerStorage::class.java)");
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).cOI();
    Object localObject = AppBrandVideoPreviewUI.b(this.lDR);
    if (localObject == null) {
      d.g.b.k.fvU();
    }
    paramView = paramView.rm(((Long)localObject).longValue());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 11);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(paramView.SG()));
    ((Bundle)localObject).putString("stat_chat_talker_username", AppBrandVideoPreviewUI.a(this.lDR));
    ((Bundle)localObject).putString("stat_send_msg_user", AppBrandVideoPreviewUI.d(this.lDR));
    String str = AppBrandVideoPreviewUI.a(this.lDR);
    if (str == null) {
      d.g.b.k.fvU();
    }
    if (AppBrandVideoPreviewUI.d(this.lDR) == null) {
      d.g.b.k.fvU();
    }
    a.a(str, 1136, k.b.rx(paramView.getContent()), (Bundle)localObject);
    AppBrandVideoPreviewUI.a(this.lDR, 5);
    this.lDR.finish();
    AppMethodBeat.o(51155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */