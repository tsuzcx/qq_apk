package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

final class FreeWifiActivateStateUI$9
  implements Runnable
{
  FreeWifiActivateStateUI$9(FreeWifiActivateStateUI paramFreeWifiActivateStateUI, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(24977);
    Intent localIntent = new Intent();
    String str = ac.f(this.tpc.getSharedPreferences(aj.fkC(), 0));
    localIntent.putExtra("rawUrl", this.tpd.field_showUrl + "&lang=" + str);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("stastic_scene", 7);
    d.b(this.tpc, "webview", ".ui.tools.WebViewUI", localIntent);
    ad.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[] { localIntent.getStringExtra("rawUrl") });
    this.tpc.finish();
    AppMethodBeat.o(24977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.9
 * JD-Core Version:    0.7.0.1
 */