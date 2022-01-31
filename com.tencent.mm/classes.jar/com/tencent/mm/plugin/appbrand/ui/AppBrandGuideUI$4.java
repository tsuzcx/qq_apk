package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;

final class AppBrandGuideUI$4
  implements DialogInterface.OnKeyListener
{
  AppBrandGuideUI$4(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
    {
      if (1 == paramKeyEvent.getAction())
      {
        n.a(n.a.gZJ, "");
        this.hcM.finish();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.4
 * JD-Core Version:    0.7.0.1
 */