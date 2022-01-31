package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143989);
    ab.i(this.iPU.TAG, "hy: on click menu");
    paramView = new pk();
    paramView.cFV.context = ((Context)this.iPU);
    paramView.cFV.cFW = com.tencent.mm.model.t.lA(AppBrandVideoPreviewUI.a(this.iPU));
    ArrayList localArrayList = new ArrayList();
    Object localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).bPQ();
    Long localLong = AppBrandVideoPreviewUI.b(this.iPU);
    if (localLong == null) {
      a.f.b.j.ebi();
    }
    localArrayList.add(((h)localObject).kB(localLong.longValue()));
    paramView.cFV.cEF = ((List)localArrayList);
    paramView.cFV.talker = AppBrandVideoPreviewUI.a(this.iPU);
    paramView.cFV.cFX = ((com.tencent.mm.af.t)this.iPU);
    a.ymk.l((b)paramView);
    AppBrandVideoPreviewUI.a(this.iPU, 3);
    AppMethodBeat.o(143989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */