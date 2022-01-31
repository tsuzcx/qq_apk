package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.sdk.platformtools.ab;

final class j$3
  implements View.OnClickListener
{
  j$3(j paramj, dap paramdap) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133472);
    ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke WxApp click listener, invoke wxapp");
    paramView = new AppBrandStatObject();
    AppBrandLaunchProxyUI.a(this.iUR.gQx, this.iUT.username, this.iUT.path, 0, this.iUT.wAy, paramView, null, null);
    AppMethodBeat.o(133472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j.3
 * JD-Core Version:    0.7.0.1
 */