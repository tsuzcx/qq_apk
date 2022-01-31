package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;

final class AppBrandGuideUI$3
  implements DialogInterface.OnClickListener
{
  AppBrandGuideUI$3(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.hcM.startActivity(new Intent(this.hcM, AppBrandLauncherUI.class).putExtra("extra_enter_scene", 11));
    n.a(n.a.gZI, "");
    this.hcM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.3
 * JD-Core Version:    0.7.0.1
 */