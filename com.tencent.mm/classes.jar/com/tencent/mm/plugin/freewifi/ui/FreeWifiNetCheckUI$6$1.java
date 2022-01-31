package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.freewifi.d.k;
import com.tencent.mm.sdk.platformtools.bo;

final class FreeWifiNetCheckUI$6$1
  implements f
{
  FreeWifiNetCheckUI$6$1(FreeWifiNetCheckUI.6 param6) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(21039);
    paramString = ((k)paramm).bBd();
    if (!bo.isNullOrNil(paramString))
    {
      FreeWifiNetCheckUI.a(this.mOo.mOl, paramString);
      this.mOo.mOl.getIntent().putExtra("free_wifi_ap_key", paramString);
      FreeWifiNetCheckUI.d(this.mOo.mOl);
      FreeWifiNetCheckUI.e(this.mOo.mOl);
      AppMethodBeat.o(21039);
      return;
    }
    this.mOo.mOl.finish();
    FreeWifiNetCheckUI.c(this.mOo.mOl);
    AppMethodBeat.o(21039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI.6.1
 * JD-Core Version:    0.7.0.1
 */