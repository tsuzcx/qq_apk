package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.g.a.hz.b;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ia.a;
import com.tencent.mm.kernel.g;
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
    AppMethodBeat.i(13530);
    paramMenuItem = BindMobileVerifyUI.a(this.guw).getText().toString().trim();
    if (paramMenuItem.equals(""))
    {
      h.h(this.guw, 2131297622, 2131297087);
      AppMethodBeat.o(13530);
      return true;
    }
    this.guw.hideVKB();
    Object localObject1 = new hz();
    ((hz)localObject1).cxj.context = this.guw;
    a.ymk.l((b)localObject1);
    localObject1 = ((hz)localObject1).cxk.cxl;
    Object localObject2 = new ia();
    a.ymk.l((b)localObject2);
    localObject2 = ((ia)localObject2).cxm.cxn;
    paramMenuItem = new x(BindMobileVerifyUI.b(this.guw), 2, paramMenuItem, "", (String)localObject1, (String)localObject2);
    g.Rc().a(paramMenuItem, 0);
    localObject1 = this.guw;
    localObject2 = this.guw;
    this.guw.getString(2131297087);
    BindMobileVerifyUI.a((BindMobileVerifyUI)localObject1, h.b((Context)localObject2, this.guw.getString(2131297610), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(13529);
        g.Rc().a(paramMenuItem);
        AppMethodBeat.o(13529);
      }
    }));
    AppMethodBeat.o(13530);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */