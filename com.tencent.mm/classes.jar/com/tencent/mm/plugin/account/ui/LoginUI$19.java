package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

final class LoginUI$19
  implements Runnable
{
  LoginUI$19(LoginUI paramLoginUI, m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(152565);
    ab.d("MicroMsg.LoginUI", "onSceneEnd, in runnable");
    Intent localIntent = a.gmO.bm(this.gFf);
    localIntent.addFlags(67108864);
    localIntent.putExtra("kstyle_show_bind_mobile_afterauth", ((s)this.ckS).ajL());
    localIntent.putExtra("kstyle_bind_wording", ((s)this.ckS).ajM());
    localIntent.putExtra("kstyle_bind_recommend_show", ((s)this.ckS).ajO());
    this.gFf.startActivity(localIntent);
    this.gFf.finish();
    AppMethodBeat.o(152565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.19
 * JD-Core Version:    0.7.0.1
 */