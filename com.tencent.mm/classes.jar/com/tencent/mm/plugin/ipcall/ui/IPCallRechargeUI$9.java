package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class IPCallRechargeUI$9
  implements h.c
{
  IPCallRechargeUI$9(IPCallRechargeUI paramIPCallRechargeUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    y.i("MicroMsg.IPCallRechargeUI", "start restore");
    IPCallRechargeUI.i(this.lxJ).start();
    com.tencent.mm.plugin.report.service.h.nFQ.a(257L, 14L, 1L, true);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_action_type", 200002);
    ((Intent)localObject).putExtra("key_force_google", true);
    d.b(this.lxJ, "wallet_index", ".ui.WalletIapUI", (Intent)localObject, 2002);
    localObject = this.lxJ;
    if (((IPCallRechargeUI)localObject).isFinishing())
    {
      y.i("MicroMsg.IPCallRechargeUI", "[showLoadingDialog] acitivity is finished.");
      return;
    }
    AppCompatActivity localAppCompatActivity = ((MMActivity)localObject).mController.uMN;
    ((IPCallRechargeUI)localObject).getString(R.l.app_tip);
    ((IPCallRechargeUI)localObject).luI = com.tencent.mm.ui.base.h.b(localAppCompatActivity, ((IPCallRechargeUI)localObject).getString(R.l.ip_call_loading_tip), false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.9
 * JD-Core Version:    0.7.0.1
 */