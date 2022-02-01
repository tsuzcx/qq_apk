package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.ipcall.a.c.1;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;

final class IPCallRechargeUI$a$1
  implements View.OnClickListener
{
  IPCallRechargeUI$a$1(IPCallRechargeUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25883);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = IPCallRechargeUI.a.a(this.JOM);
    if (!ChannelUtil.isGPVersion())
    {
      localObject = new e.a((Context)localObject);
      ((e.a)localObject).aEO(R.l.gLE);
      ((e.a)localObject).aER(R.l.app_i_known).c(new c.1());
      ((e.a)localObject).jHH().show();
    }
    for (int i = 1; i != 0; i = 0)
    {
      Log.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
      a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(25883);
      return;
    }
    IPCallRechargeUI.b(IPCallRechargeUI.a.a(this.JOM), ((Integer)paramView.getTag()).intValue());
    a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallRechargeUI$RechargeAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1
 * JD-Core Version:    0.7.0.1
 */