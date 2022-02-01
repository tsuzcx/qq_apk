package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.f.a.tu;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    Object localObject1 = new b();
    ((b)localObject1).bn(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aFi());
    Log.i(this.ral.TAG, "hy: on click menu");
    paramView = new tu();
    paramView.fTd.context = ((Context)this.ral);
    paramView.fTd.fTe = ab.Lj(AppBrandVideoPreviewUI.a(this.ral));
    localObject1 = new ArrayList();
    Object localObject2 = h.ae(n.class);
    p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
    localObject2 = ((n)localObject2).eSe();
    Long localLong = AppBrandVideoPreviewUI.b(this.ral);
    if (localLong == null) {
      p.iCn();
    }
    ((ArrayList)localObject1).add(((i)localObject2).Oq(localLong.longValue()));
    paramView.fTd.fRB = ((List)localObject1);
    paramView.fTd.talker = AppBrandVideoPreviewUI.a(this.ral);
    paramView.fTd.fTf = ((z)this.ral);
    EventCenter.instance.publish((IEvent)paramView);
    AppBrandVideoPreviewUI.a(this.ral, 3);
    a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */