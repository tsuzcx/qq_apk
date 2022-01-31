package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;

final class AppBrandGuideUI$3
  implements DialogInterface.OnClickListener
{
  AppBrandGuideUI$3(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(132957);
    this.iMz.startActivity(new Intent(this.iMz, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
    n.a(n.a.iIa, "");
    this.iMz.finish();
    AppMethodBeat.o(132957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.3
 * JD-Core Version:    0.7.0.1
 */