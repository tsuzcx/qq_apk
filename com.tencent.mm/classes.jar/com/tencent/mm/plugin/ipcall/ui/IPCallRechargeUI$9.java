package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h.c;

final class IPCallRechargeUI$9
  implements h.c
{
  IPCallRechargeUI$9(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(22260);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22260);
      return;
      ab.i("MicroMsg.IPCallRechargeUI", "start restore");
      IPCallRechargeUI.i(this.nUW).start();
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(257L, 14L, 1L, true);
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_action_type", 200002);
      ((Intent)localObject).putExtra("key_force_google", true);
      d.b(this.nUW, "wallet_index", ".ui.WalletIapUI", (Intent)localObject, 2002);
      localObject = this.nUW;
      if (((IPCallRechargeUI)localObject).isFinishing())
      {
        ab.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
        AppMethodBeat.o(22260);
        return;
      }
      AppCompatActivity localAppCompatActivity = ((IPCallRechargeUI)localObject).getContext();
      ((IPCallRechargeUI)localObject).getString(2131297087);
      ((IPCallRechargeUI)localObject).nSa = com.tencent.mm.ui.base.h.b(localAppCompatActivity, ((IPCallRechargeUI)localObject).getString(2131300856), false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.9
 * JD-Core Version:    0.7.0.1
 */