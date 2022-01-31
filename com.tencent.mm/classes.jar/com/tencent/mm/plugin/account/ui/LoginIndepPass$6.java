package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

final class LoginIndepPass$6
  implements Runnable
{
  LoginIndepPass$6(LoginIndepPass paramLoginIndepPass) {}
  
  public final void run()
  {
    y.d("MicroMsg.LoginIndepPass", "onSceneEnd, in runnable");
    Intent localIntent = a.eUR.aN(this.fnl);
    localIntent.addFlags(67108864);
    this.fnl.startActivity(localIntent);
    this.fnl.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.6
 * JD-Core Version:    0.7.0.1
 */