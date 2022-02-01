package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.a.c.1;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

final class IPCallRechargeUI$a$1
  implements View.OnClickListener
{
  IPCallRechargeUI$a$1(IPCallRechargeUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25883);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = IPCallRechargeUI.a.a(this.uTn);
    if (!j.fjZ())
    {
      localObject = new d.a((Context)localObject);
      ((d.a)localObject).afi(2131760544);
      ((d.a)localObject).afl(2131755793).c(new c.1());
      ((d.a)localObject).fMb().show();
    }
    for (int i = 1; i != 0; i = 0)
    {
      ad.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
      a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(25883);
      return;
    }
    IPCallRechargeUI.b(IPCallRechargeUI.a.a(this.uTn), ((Integer)paramView.getTag()).intValue());
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1
 * JD-Core Version:    0.7.0.1
 */