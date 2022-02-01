package com.tencent.mm.plugin.freewifi.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ai;

final class b$2
  implements Runnable
{
  b$2(b paramb, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(24746);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", this.spE);
    ((Intent)localObject).putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", this.spF);
    ((Intent)localObject).setClass(ai.getContext(), FreeWifiManufacturerLoadingUI.class);
    ((Intent)localObject).addFlags(268435456);
    Context localContext = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/manufacturer/FreeWifiManufacturerConnectWifiHelper$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/freewifi/manufacturer/FreeWifiManufacturerConnectWifiHelper$2", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.b.b.2
 * JD-Core Version:    0.7.0.1
 */