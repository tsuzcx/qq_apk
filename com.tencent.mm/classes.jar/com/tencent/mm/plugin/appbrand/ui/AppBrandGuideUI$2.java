package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;

final class AppBrandGuideUI$2
  implements DialogInterface.OnClickListener
{
  AppBrandGuideUI$2(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(132956);
    n.a(n.a.iHZ, "");
    this.iMz.finish();
    AppMethodBeat.o(132956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.2
 * JD-Core Version:    0.7.0.1
 */