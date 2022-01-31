package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$a
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143986);
    ab.i(this.iPU.TAG, "hy: request start to appid " + AppBrandVideoPreviewUI.c(this.iPU));
    paramView = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(paramView, "MMKernel.service(IMessengerStorage::class.java)");
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramView).bPQ();
    Object localObject = AppBrandVideoPreviewUI.b(this.iPU);
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    paramView = paramView.kB(((Long)localObject).longValue());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 11);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(paramView.HA()));
    ((Bundle)localObject).putString("stat_chat_talker_username", AppBrandVideoPreviewUI.a(this.iPU));
    ((Bundle)localObject).putString("stat_send_msg_user", AppBrandVideoPreviewUI.d(this.iPU));
    String str = AppBrandVideoPreviewUI.a(this.iPU);
    if (str == null) {
      a.f.b.j.ebi();
    }
    if (AppBrandVideoPreviewUI.d(this.iPU) == null) {
      a.f.b.j.ebi();
    }
    a.a(str, 1136, j.b.mY(paramView.getContent()), (Bundle)localObject);
    AppBrandVideoPreviewUI.a(this.iPU, 5);
    this.iPU.finish();
    AppMethodBeat.o(143986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */