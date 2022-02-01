package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

final class FreeWifiActivateStateUI$9
  implements Runnable
{
  FreeWifiActivateStateUI$9(FreeWifiActivateStateUI paramFreeWifiActivateStateUI, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(24977);
    Intent localIntent = new Intent();
    String str = ab.f(this.ssA.getSharedPreferences(ai.eUX(), 0));
    localIntent.putExtra("rawUrl", this.ssB.field_showUrl + "&lang=" + str);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("stastic_scene", 7);
    d.b(this.ssA, "webview", ".ui.tools.WebViewUI", localIntent);
    ac.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
    this.ssA.finish();
    AppMethodBeat.o(24977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.9
 * JD-Core Version:    0.7.0.1
 */