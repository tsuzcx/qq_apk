package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

final class l$4
  implements Runnable
{
  l$4(l paraml) {}
  
  public final void run()
  {
    y.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
    Intent localIntent = a.eUR.aN(this.fok.fnW);
    localIntent.addFlags(67108864);
    this.fok.fnW.startActivity(localIntent);
    this.fok.fnW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.l.4
 * JD-Core Version:    0.7.0.1
 */