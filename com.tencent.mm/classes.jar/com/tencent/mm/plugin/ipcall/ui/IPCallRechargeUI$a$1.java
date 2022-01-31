package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.c.1;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;

final class IPCallRechargeUI$a$1
  implements View.OnClickListener
{
  IPCallRechargeUI$a$1(IPCallRechargeUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22263);
    Object localObject = IPCallRechargeUI.a.a(this.nVa);
    if (!g.dsn())
    {
      localObject = new c.a((Context)localObject);
      ((c.a)localObject).Rf(2131300943);
      ((c.a)localObject).Ri(2131296977).a(new c.1());
      ((c.a)localObject).aLZ().show();
    }
    for (int i = 1; i != 0; i = 0)
    {
      ab.i("MicroMsg.IPCallRechargeUI", "onClick recharged, non gp version!");
      AppMethodBeat.o(22263);
      return;
    }
    IPCallRechargeUI.b(IPCallRechargeUI.a.a(this.nVa), ((Integer)paramView.getTag()).intValue());
    AppMethodBeat.o(22263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a.1
 * JD-Core Version:    0.7.0.1
 */