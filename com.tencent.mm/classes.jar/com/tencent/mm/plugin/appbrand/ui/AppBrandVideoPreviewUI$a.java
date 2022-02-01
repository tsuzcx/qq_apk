package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$a
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51155);
    ac.i(this.mfL.TAG, "hy: request start to appid " + AppBrandVideoPreviewUI.c(this.mfL));
    paramView = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(paramView, "MMKernel.service(IMessengerStorage::class.java)");
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)paramView).dcr();
    Object localObject = AppBrandVideoPreviewUI.b(this.mfL);
    if (localObject == null) {
      d.g.b.k.fOy();
    }
    paramView = paramView.vP(((Long)localObject).longValue());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 11);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(paramView.TA()));
    ((Bundle)localObject).putString("stat_chat_talker_username", AppBrandVideoPreviewUI.a(this.mfL));
    ((Bundle)localObject).putString("stat_send_msg_user", AppBrandVideoPreviewUI.d(this.mfL));
    String str = AppBrandVideoPreviewUI.a(this.mfL);
    if (str == null) {
      d.g.b.k.fOy();
    }
    if (AppBrandVideoPreviewUI.d(this.mfL) == null) {
      d.g.b.k.fOy();
    }
    a.a(str, 1136, k.b.vA(paramView.getContent()), (Bundle)localObject);
    AppBrandVideoPreviewUI.a(this.mfL, 5);
    this.mfL.finish();
    AppMethodBeat.o(51155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */