package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.n;
import com.tencent.mm.plugin.appbrand.report.model.n.a;

final class AppBrandGuideUI$4
  implements DialogInterface.OnKeyListener
{
  AppBrandGuideUI$4(AppBrandGuideUI paramAppBrandGuideUI) {}
  
  public final boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(132958);
    if (4 == paramInt)
    {
      if (1 == paramKeyEvent.getAction())
      {
        n.a(n.a.iIb, "");
        this.iMz.finish();
      }
      AppMethodBeat.o(132958);
      return true;
    }
    AppMethodBeat.o(132958);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.4
 * JD-Core Version:    0.7.0.1
 */