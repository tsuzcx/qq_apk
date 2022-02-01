package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$a
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51155);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    Log.i(this.nYB.TAG, "hy: request start to appid " + AppBrandVideoPreviewUI.c(this.nYB));
    paramView = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramView, "MMKernel.service(IMessengerStorage::class.java)");
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramView).eiy();
    localObject = AppBrandVideoPreviewUI.b(this.nYB);
    if (localObject == null) {
      p.hyc();
    }
    paramView = paramView.Hb(((Long)localObject).longValue());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("stat_scene", 11);
    ((Bundle)localObject).putString("stat_msg_id", "msg_" + Long.toString(paramView.ajM()));
    ((Bundle)localObject).putString("stat_chat_talker_username", AppBrandVideoPreviewUI.a(this.nYB));
    ((Bundle)localObject).putString("stat_send_msg_user", AppBrandVideoPreviewUI.d(this.nYB));
    String str = AppBrandVideoPreviewUI.a(this.nYB);
    if (str == null) {
      p.hyc();
    }
    if (AppBrandVideoPreviewUI.d(this.nYB) == null) {
      p.hyc();
    }
    com.tencent.mm.modelappbrand.a.a(str, 1136, k.b.HD(paramView.getContent()), (Bundle)localObject);
    AppBrandVideoPreviewUI.a(this.nYB, 5);
    this.nYB.finish();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$initVideoView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */