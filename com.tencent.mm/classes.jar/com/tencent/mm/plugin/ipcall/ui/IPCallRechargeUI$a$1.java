package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.c.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

final class IPCallRechargeUI$a$1
  implements View.OnClickListener
{
  IPCallRechargeUI$a$1(IPCallRechargeUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25883);
    Object localObject = IPCallRechargeUI.a.a(this.tQA);
    if (!i.eUv())
    {
      localObject = new d.a((Context)localObject);
      ((d.a)localObject).acJ(2131760544);
      ((d.a)localObject).acM(2131755793).b(new c.1());
      ((d.a)localObject).fvp().show();
    }
    for (int i = 1; i != 0; i = 0)
    {
      ac.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
      AppMethodBeat.o(25883);
      return;
    }
    IPCallRechargeUI.b(IPCallRechargeUI.a.a(this.tQA), ((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(25883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1
 * JD-Core Version:    0.7.0.1
 */