package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.ipcall.model.f.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;

final class IPCallRechargeUI$9
  implements k.d
{
  IPCallRechargeUI$9(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void qz(int paramInt)
  {
    AppMethodBeat.i(25880);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25880);
      return;
      Log.i("MicroMsg.IPCallRechargeUI", "start restore");
      IPCallRechargeUI.i(this.JOI).start();
      h.OAn.idkeyStat(257L, 14L, 1L, true);
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_action_type", 200002);
      ((Intent)localObject).putExtra("key_force_google", true);
      c.b(this.JOI, "wallet_index", ".ui.WalletIapUI", (Intent)localObject, 2002);
      localObject = this.JOI;
      if (((IPCallRechargeUI)localObject).isFinishing())
      {
        Log.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
        AppMethodBeat.o(25880);
        return;
      }
      AppCompatActivity localAppCompatActivity = ((IPCallRechargeUI)localObject).getContext();
      ((IPCallRechargeUI)localObject).getString(R.l.app_tip);
      ((IPCallRechargeUI)localObject).xZJ = k.a(localAppCompatActivity, ((IPCallRechargeUI)localObject).getString(R.l.gKx), false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.9
 * JD-Core Version:    0.7.0.1
 */