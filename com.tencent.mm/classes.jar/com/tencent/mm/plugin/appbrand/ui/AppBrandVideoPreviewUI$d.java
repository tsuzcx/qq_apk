package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.z;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class AppBrandVideoPreviewUI$d
  implements View.OnClickListener
{
  AppBrandVideoPreviewUI$d(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51158);
    ac.i(this.mfL.TAG, "hy: on click menu");
    paramView = new rl();
    paramView.dut.context = ((Context)this.mfL);
    paramView.dut.duu = w.sQ(AppBrandVideoPreviewUI.a(this.mfL));
    ArrayList localArrayList = new ArrayList();
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).dcr();
    Long localLong = AppBrandVideoPreviewUI.b(this.mfL);
    if (localLong == null) {
      d.g.b.k.fOy();
    }
    localArrayList.add(((h)localObject).vP(localLong.longValue()));
    paramView.dut.dsS = ((List)localArrayList);
    paramView.dut.talker = AppBrandVideoPreviewUI.a(this.mfL);
    paramView.dut.duv = ((z)this.mfL);
    a.GpY.l((b)paramView);
    AppBrandVideoPreviewUI.a(this.mfL, 3);
    AppMethodBeat.o(51158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI.d
 * JD-Core Version:    0.7.0.1
 */