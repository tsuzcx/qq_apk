package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.z;
import com.tencent.mm.g.a.st;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    Log.i(this.nYB.TAG, "hy: on click menu");
    paramView = new st();
    paramView.dZk.context = ((Context)this.nYB);
    paramView.dZk.dZl = ab.Eq(AppBrandVideoPreviewUI.a(this.nYB));
    localObject1 = new ArrayList();
    Object localObject2 = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).eiy();
    Long localLong = AppBrandVideoPreviewUI.b(this.nYB);
    if (localLong == null) {
      p.hyc();
    }
    ((ArrayList)localObject1).add(((i)localObject2).Hb(localLong.longValue()));
    paramView.dZk.dXK = ((List)localObject1);
    paramView.dZk.talker = AppBrandVideoPreviewUI.a(this.nYB);
    paramView.dZk.dZm = ((z)this.nYB);
    EventCenter.instance.publish((IEvent)paramView);
    AppBrandVideoPreviewUI.a(this.nYB, 3);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */