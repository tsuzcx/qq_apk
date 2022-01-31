package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.v.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;

final class MenuDelegate_SendToDesktop$3
  implements e.b
{
  MenuDelegate_SendToDesktop$3(MenuDelegate_SendToDesktop paramMenuDelegate_SendToDesktop, a.a parama, Context paramContext, String paramString, e.a parama1) {}
  
  public final void r(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.gPc.cB(this.val$context);
      h.nFQ.f(15783, new Object[] { Integer.valueOf(this.gOY), Integer.valueOf(0), this.val$appId });
    }
    for (;;)
    {
      MenuDelegate_SendToDesktop.d(paramBoolean2, this.val$appId, this.gOY);
      return;
      MenuDelegate_SendToDesktop.a(this.gPd, this.gOY, this.val$appId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.3
 * JD-Core Version:    0.7.0.1
 */