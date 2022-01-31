package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;

final class g$3
  implements Runnable
{
  g$3(g paramg, MMActivity paramMMActivity) {}
  
  public final void run()
  {
    Intent localIntent = a.eUR.aN(this.byc);
    localIntent.addFlags(67108864);
    this.byc.startActivity(localIntent);
    this.byc.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.g.3
 * JD-Core Version:    0.7.0.1
 */