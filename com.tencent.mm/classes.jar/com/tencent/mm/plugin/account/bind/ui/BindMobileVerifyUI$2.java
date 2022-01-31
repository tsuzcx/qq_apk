package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.hv;
import com.tencent.mm.h.a.hv.b;
import com.tencent.mm.h.a.hw;
import com.tencent.mm.h.a.hw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;

final class BindMobileVerifyUI$2
  implements MenuItem.OnMenuItemClickListener
{
  BindMobileVerifyUI$2(BindMobileVerifyUI paramBindMobileVerifyUI) {}
  
  public final boolean onMenuItemClick(final MenuItem paramMenuItem)
  {
    paramMenuItem = BindMobileVerifyUI.a(this.fcM).getText().toString().trim();
    if (paramMenuItem.equals(""))
    {
      h.h(this.fcM, a.i.bind_mcontact_verifynull, a.i.app_tip);
      return true;
    }
    this.fcM.XM();
    Object localObject1 = new hv();
    ((hv)localObject1).bPQ.context = this.fcM;
    a.udP.m((b)localObject1);
    localObject1 = ((hv)localObject1).bPR.bPS;
    Object localObject2 = new hw();
    a.udP.m((b)localObject2);
    localObject2 = ((hw)localObject2).bPT.bPU;
    paramMenuItem = new x(BindMobileVerifyUI.b(this.fcM), 2, paramMenuItem, "", (String)localObject1, (String)localObject2);
    g.Dk().a(paramMenuItem, 0);
    localObject1 = this.fcM;
    localObject2 = this.fcM;
    this.fcM.getString(a.i.app_tip);
    BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.b((Context)localObject2, this.fcM.getString(a.i.bind_mcontact_verifing), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        g.Dk().c(paramMenuItem);
      }
    }));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */