package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.aj;

final class FreeWifiManufacturerLoadingUI$7
  implements Runnable
{
  FreeWifiManufacturerLoadingUI$7(FreeWifiManufacturerLoadingUI paramFreeWifiManufacturerLoadingUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(25076);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.tqw);
    localIntent.putExtra("show_bottom", false);
    localIntent.putExtra("allow_wx_schema_url", true);
    localIntent.putExtra("neverGetA8Key", true);
    localIntent.putExtra("stastic_scene", 7);
    localIntent.putExtra("neverBlockLocalRequest", true);
    if (FreeWifiManufacturerLoadingUI.g(this.tqs)) {
      d.b(aj.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(25076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI.7
 * JD-Core Version:    0.7.0.1
 */