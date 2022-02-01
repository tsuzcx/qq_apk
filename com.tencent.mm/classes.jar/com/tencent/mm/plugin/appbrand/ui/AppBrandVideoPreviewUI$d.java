package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    ae.i(this.mLq.TAG, "hy: on click menu");
    paramView = new rx();
    paramView.dHz.context = ((Context)this.mLq);
    paramView.dHz.dHA = x.wb(AppBrandVideoPreviewUI.a(this.mLq));
    localObject1 = new ArrayList();
    Object localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).doJ();
    Long localLong = AppBrandVideoPreviewUI.b(this.mLq);
    if (localLong == null) {
      p.gkB();
    }
    ((ArrayList)localObject1).add(((i)localObject2).ys(localLong.longValue()));
    paramView.dHz.dFX = ((List)localObject1);
    paramView.dHz.talker = AppBrandVideoPreviewUI.a(this.mLq);
    paramView.dHz.dHB = ((z)this.mLq);
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)paramView);
    AppBrandVideoPreviewUI.a(this.mLq, 3);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */