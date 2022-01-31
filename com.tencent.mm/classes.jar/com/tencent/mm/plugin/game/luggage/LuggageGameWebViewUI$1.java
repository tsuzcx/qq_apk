package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.luggage.e.e;
import com.tencent.luggage.e.m;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class LuggageGameWebViewUI$1
  implements com.tencent.luggage.e.j
{
  LuggageGameWebViewUI$1(LuggageGameWebViewUI paramLuggageGameWebViewUI, String paramString) {}
  
  public final e f(String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.LuggageGameWebViewUI", "getPage, time = %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.fv(paramString);
    if (bk.bl(localGameWebPerformanceInfo.url))
    {
      localGameWebPerformanceInfo.url = paramString;
      long l = System.currentTimeMillis();
      localGameWebPerformanceInfo.dCK = l;
      localGameWebPerformanceInfo.dCF = l;
      localGameWebPerformanceInfo.startTime = l;
      localGameWebPerformanceInfo.dCA = 1;
    }
    localGameWebPerformanceInfo.dCM = System.currentTimeMillis();
    paramBundle.putInt("minimize_secene", 3);
    boolean bool1 = paramBundle.getBoolean("from_bag", false);
    boolean bool2 = paramBundle.getBoolean("transparent_page", false);
    if (bool1) {
      return new d(LuggageGameWebViewUI.a(this.kMK).bix, m.a(this.kMK.mController.uMN, Integer.valueOf(t.rdb)), paramBundle);
    }
    if (bool2) {
      return new j(LuggageGameWebViewUI.a(this.kMK).bix, paramBundle);
    }
    paramString = i.ah(this.kMK.mController.uMN, this.eRY);
    if (paramString != null) {
      return new com.tencent.mm.plugin.game.f(LuggageGameWebViewUI.a(this.kMK).bix, paramString, paramBundle);
    }
    return new d(LuggageGameWebViewUI.a(this.kMK).bix, null, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */