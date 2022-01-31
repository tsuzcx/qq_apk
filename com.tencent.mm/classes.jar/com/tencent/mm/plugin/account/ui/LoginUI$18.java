package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class LoginUI$18
  implements Runnable
{
  LoginUI$18(LoginUI paramLoginUI, com.tencent.mm.ah.m paramm) {}
  
  public final void run()
  {
    y.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
    Intent localIntent = a.eUR.aN(this.fnM);
    localIntent.addFlags(67108864);
    localIntent.putExtra("kstyle_show_bind_mobile_afterauth", ((q)this.bEe).QD());
    localIntent.putExtra("kstyle_bind_wording", ((q)this.bEe).QE());
    localIntent.putExtra("kstyle_bind_recommend_show", ((q)this.bEe).QG());
    this.fnM.startActivity(localIntent);
    this.fnM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.18
 * JD-Core Version:    0.7.0.1
 */