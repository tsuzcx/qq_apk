package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    ad.i(this.mGm.TAG, "hy: on click menu");
    paramView = new rw();
    paramView.dGt.context = ((Context)this.mGm);
    paramView.dGt.dGu = w.vF(AppBrandVideoPreviewUI.a(this.mGm));
    localObject1 = new ArrayList();
    Object localObject2 = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject2).dlK();
    Long localLong = AppBrandVideoPreviewUI.b(this.mGm);
    if (localLong == null) {
      p.gfZ();
    }
    ((ArrayList)localObject1).add(((i)localObject2).xY(localLong.longValue()));
    paramView.dGt.dES = ((List)localObject1);
    paramView.dGt.talker = AppBrandVideoPreviewUI.a(this.mGm);
    paramView.dGt.dGv = ((z)this.mGm);
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)paramView);
    AppBrandVideoPreviewUI.a(this.mGm, 3);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */