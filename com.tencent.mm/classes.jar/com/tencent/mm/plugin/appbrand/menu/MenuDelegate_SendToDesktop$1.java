package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.concurrent.atomic.AtomicBoolean;

final class MenuDelegate_SendToDesktop$1
  implements Runnable
{
  MenuDelegate_SendToDesktop$1(MenuDelegate_SendToDesktop paramMenuDelegate_SendToDesktop, AtomicBoolean paramAtomicBoolean, Context paramContext, q.a parama, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public final void run()
  {
    this.gOV.set(q.a(this.val$context, this.gOW, this.fAF, false));
    if (this.gOV.get()) {
      h.nFQ.a(443L, 1L, 1L, false);
    }
    if ((this.val$context == null) || (!this.gOV.get())) {}
    do
    {
      return;
      localResources = this.val$context.getResources();
      if (this.gOX == 0)
      {
        b.h((Activity)this.val$context, localResources.getString(y.j.appbrand_shortcut_permission_toast_had_add_to_desktop));
        h.nFQ.f(15787, new Object[] { Integer.valueOf(this.gOY), Integer.valueOf(0), this.gOW.appId });
        return;
      }
    } while ((!this.gOZ) || ((this.gOY != 2) && (this.gOY != 4)));
    Resources localResources = this.val$context.getResources();
    b.a((Activity)this.val$context, localResources.getString(y.j.appbrand_shortcut_permission_toast_had_add_to_desktop), localResources.getString(y.j.appbrand_shortcut_permission_dialog_know_detail), new a.b()
    {
      public final void amw()
      {
        MenuDelegate_SendToDesktop.a(MenuDelegate_SendToDesktop.1.this.val$context, true, MenuDelegate_SendToDesktop.1.this.gOY, MenuDelegate_SendToDesktop.1.this.gOW.appId);
      }
    });
    h.nFQ.f(15787, new Object[] { Integer.valueOf(this.gOY), Integer.valueOf(0), this.gOW.appId });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.1
 * JD-Core Version:    0.7.0.1
 */