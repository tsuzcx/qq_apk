package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiActivateStateUI$9
  implements Runnable
{
  FreeWifiActivateStateUI$9(FreeWifiActivateStateUI paramFreeWifiActivateStateUI, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(20907);
    Intent localIntent = new Intent();
    String str = aa.f(this.mMD.getSharedPreferences(ah.dsP(), 0));
    localIntent.putExtra("rawUrl", this.mME.field_showUrl + "&lang=" + str);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("stastic_scene", 7);
    d.b(this.mMD, "webview", ".ui.tools.WebViewUI", localIntent);
    ab.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
    this.mMD.finish();
    AppMethodBeat.o(20907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.9
 * JD-Core Version:    0.7.0.1
 */