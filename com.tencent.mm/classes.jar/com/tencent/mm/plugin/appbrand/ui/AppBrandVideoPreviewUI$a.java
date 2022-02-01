package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$a
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51155);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    ae.i(this.mLq.TAG, "hy: request start to appid " + AppBrandVideoPreviewUI.c(this.mLq));
    paramView = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramView, "MMKernel.service(IMessengerStorage::class.java)");
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).doJ();
    localObject = AppBrandVideoPreviewUI.b(this.mLq);
    if (localObject == null) {
      p.gkB();
    }
    paramView = paramView.ys(((Long)localObject).longValue());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 11);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(paramView.VY()));
    ((Bundle)localObject).putString("stat_chat_talker_username", AppBrandVideoPreviewUI.a(this.mLq));
    ((Bundle)localObject).putString("stat_send_msg_user", AppBrandVideoPreviewUI.d(this.mLq));
    String str = AppBrandVideoPreviewUI.a(this.mLq);
    if (str == null) {
      p.gkB();
    }
    if (AppBrandVideoPreviewUI.d(this.mLq) == null) {
      p.gkB();
    }
    com.tencent.mm.modelappbrand.a.a(str, 1136, k.b.zb(paramView.getContent()), (Bundle)localObject);
    AppBrandVideoPreviewUI.a(this.mLq, 5);
    this.mLq.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */