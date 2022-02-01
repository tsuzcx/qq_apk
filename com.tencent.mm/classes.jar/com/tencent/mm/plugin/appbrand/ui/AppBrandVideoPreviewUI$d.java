package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    ad.i(this.lDR.TAG, "hy: on click menu");
    paramView = new rc();
    paramView.dwG.context = ((Context)this.lDR);
    paramView.dwG.dwH = w.pF(AppBrandVideoPreviewUI.a(this.lDR));
    ArrayList localArrayList = new ArrayList();
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).cOI();
    Long localLong = AppBrandVideoPreviewUI.b(this.lDR);
    if (localLong == null) {
      d.g.b.k.fvU();
    }
    localArrayList.add(((h)localObject).rm(localLong.longValue()));
    paramView.dwG.dvg = ((List)localArrayList);
    paramView.dwG.talker = AppBrandVideoPreviewUI.a(this.lDR);
    paramView.dwG.dwI = ((z)this.lDR);
    a.ESL.l((b)paramView);
    AppBrandVideoPreviewUI.a(this.lDR, 3);
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */