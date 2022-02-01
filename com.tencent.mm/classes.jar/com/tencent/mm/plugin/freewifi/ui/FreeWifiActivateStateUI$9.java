package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class FreeWifiActivateStateUI$9
  implements Runnable
{
  FreeWifiActivateStateUI$9(FreeWifiActivateStateUI paramFreeWifiActivateStateUI, com.tencent.mm.plugin.freewifi.g.c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(24977);
    Intent localIntent = new Intent();
    String str = LocaleUtil.loadApplicationLanguage(this.wQV.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.wQV);
    localIntent.putExtra("rawUrl", this.wQW.field_showUrl + "&lang=" + str);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("stastic_scene", 7);
    com.tencent.mm.br.c.b(this.wQV, "webview", ".ui.tools.WebViewUI", localIntent);
    Log.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
    this.wQV.finish();
    AppMethodBeat.o(24977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.9
 * JD-Core Version:    0.7.0.1
 */