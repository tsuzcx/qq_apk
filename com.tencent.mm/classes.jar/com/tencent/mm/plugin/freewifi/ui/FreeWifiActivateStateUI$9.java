package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

final class FreeWifiActivateStateUI$9
  implements Runnable
{
  FreeWifiActivateStateUI$9(FreeWifiActivateStateUI paramFreeWifiActivateStateUI, c paramc) {}
  
  public final void run()
  {
    Intent localIntent = new Intent();
    String str = x.d(this.kqR.getSharedPreferences(ae.cqR(), 0));
    localIntent.putExtra("rawUrl", this.kqS.field_showUrl + "&lang=" + str);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("stastic_scene", 7);
    d.b(this.kqR, "webview", ".ui.tools.WebViewUI", localIntent);
    y.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
    this.kqR.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.9
 * JD-Core Version:    0.7.0.1
 */