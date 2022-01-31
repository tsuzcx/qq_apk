package com.tencent.mm.plugin.game.luggage;

import android.os.Bundle;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.luggage.d.a;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class LuggageGameWebViewUI$1
  implements j
{
  LuggageGameWebViewUI$1(LuggageGameWebViewUI paramLuggageGameWebViewUI) {}
  
  public final e j(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(135809);
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.LuggageGameWebViewUI", "getPage, __Time__，time = %d", new Object[] { Long.valueOf(l) });
    paramBundle.putInt("minimize_secene", 3);
    boolean bool1 = paramBundle.getBoolean("from_bag", false);
    boolean bool2 = paramBundle.getBoolean("float_layer_page", false);
    if ((LuggageGameWebViewUI.a(this.njn)) || (bool2) || (bool1) || (LuggageGameWebViewUI.PP(paramString))) {}
    for (GameWebPerformanceInfo localGameWebPerformanceInfo = GameWebPerformanceInfo.lN(paramString);; localGameWebPerformanceInfo = GameWebPerformanceInfo.lO(paramString))
    {
      if (bo.isNullOrNil(localGameWebPerformanceInfo.url))
      {
        ab.i("MicroMsg.LuggageGameWebViewUI", "new page, url: %s", new Object[] { paramString });
        localGameWebPerformanceInfo.url = paramString;
        localGameWebPerformanceInfo.eAf = l;
        localGameWebPerformanceInfo.eAa = l;
        localGameWebPerformanceInfo.startTime = l;
        localGameWebPerformanceInfo.ezQ = 1;
      }
      localGameWebPerformanceInfo.eAh = l;
      if (!bool2) {
        LuggageGameWebViewUI.b(this.njn);
      }
      if (!bool1) {
        break;
      }
      paramString = new com.tencent.mm.plugin.game.luggage.d.f(LuggageGameWebViewUI.c(this.njn).byV, m.a(this.njn.getContext(), Integer.valueOf(t.uSZ)), paramBundle);
      AppMethodBeat.o(135809);
      return paramString;
      com.tencent.mm.plugin.webview.ui.tools.game.g.aiN(paramString);
      com.tencent.mm.plugin.webview.ui.tools.game.g.aO(paramString, l);
    }
    if (bool2)
    {
      paramString = new a(LuggageGameWebViewUI.c(this.njn).byV, paramBundle);
      AppMethodBeat.o(135809);
      return paramString;
    }
    paramString = d.aq(this.njn.getContext(), paramString);
    if (paramString != null)
    {
      paramString = new com.tencent.mm.plugin.game.luggage.d.g(LuggageGameWebViewUI.c(this.njn).byV, paramString, paramBundle);
      AppMethodBeat.o(135809);
      return paramString;
    }
    paramString = new com.tencent.mm.plugin.game.luggage.d.f(LuggageGameWebViewUI.c(this.njn).byV, null, paramBundle);
    AppMethodBeat.o(135809);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */