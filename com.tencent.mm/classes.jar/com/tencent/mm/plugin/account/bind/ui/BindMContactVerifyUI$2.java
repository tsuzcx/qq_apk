package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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

final class BindMContactVerifyUI$2
  implements View.OnClickListener
{
  BindMContactVerifyUI$2(BindMContactVerifyUI paramBindMContactVerifyUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = BindMContactVerifyUI.a(this.fch).getText().toString().trim();
    if (paramView.equals(""))
    {
      h.h(this.fch, a.i.bind_mcontact_verifynull, a.i.app_tip);
      return;
    }
    this.fch.XM();
    Object localObject1 = new hv();
    ((hv)localObject1).bPQ.context = this.fch;
    a.udP.m((b)localObject1);
    localObject1 = ((hv)localObject1).bPR.bPS;
    Object localObject2 = new hw();
    a.udP.m((b)localObject2);
    localObject2 = ((hw)localObject2).bPT.bPU;
    int i = 2;
    if (BindMContactVerifyUI.b(this.fch)) {
      i = 19;
    }
    paramView = new x(BindMContactVerifyUI.c(this.fch), i, paramView, "", (String)localObject1, (String)localObject2);
    g.Dk().a(paramView, 0);
    localObject1 = this.fch;
    localObject2 = this.fch;
    this.fch.getString(a.i.app_tip);
    BindMContactVerifyUI.a((BindMContactVerifyUI)localObject1, h.b((Context)localObject2, this.fch.getString(a.i.bind_mcontact_verifing), true, new BindMContactVerifyUI.2.1(this, paramView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.2
 * JD-Core Version:    0.7.0.1
 */