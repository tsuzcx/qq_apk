package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.freewifi.d.k;
import com.tencent.mm.sdk.platformtools.bk;

final class FreeWifiNetCheckUI$5$1
  implements f
{
  FreeWifiNetCheckUI$5$1(FreeWifiNetCheckUI.5 param5) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramString = ((k)paramm).aUD();
    if (!bk.bl(paramString))
    {
      FreeWifiNetCheckUI.a(this.ksA.ksx, paramString);
      this.ksA.ksx.getIntent().putExtra("free_wifi_ap_key", paramString);
      FreeWifiNetCheckUI.d(this.ksA.ksx);
      FreeWifiNetCheckUI.e(this.ksA.ksx);
      return;
    }
    this.ksA.ksx.finish();
    FreeWifiNetCheckUI.c(this.ksA.ksx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.5.1
 * JD-Core Version:    0.7.0.1
 */