package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;

public final class g
  extends f
{
  public g(com.tencent.luggage.d.g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(135996);
    a.c(getWebView());
    l.post(new g.1(this));
    l.h(new g.2(this), 100L);
    bFF();
    AppMethodBeat.o(135996);
  }
  
  private void bFF()
  {
    AppMethodBeat.i(136002);
    this.bzs.a(new g.3(this));
    AppMethodBeat.o(136002);
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.game.g PU(String paramString)
  {
    AppMethodBeat.i(136003);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.aiO(paramString);
    AppMethodBeat.o(136003);
    return paramString;
  }
  
  public final boolean PV(String paramString)
  {
    AppMethodBeat.i(136001);
    if (paramString.equals(daZ()))
    {
      AppMethodBeat.o(136001);
      return false;
    }
    boolean bool = super.PV(paramString);
    AppMethodBeat.o(136001);
    return bool;
  }
  
  public final void bF(String paramString)
  {
    AppMethodBeat.i(136000);
    super.bF(paramString);
    bFF();
    AppMethodBeat.o(136000);
  }
  
  public final void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(135998);
    ab.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(135998);
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(135999);
    super.g(paramString, paramBundle);
    AppMethodBeat.o(135999);
  }
  
  public final String ux()
  {
    AppMethodBeat.i(135997);
    String str = i.p(this.mContext, "preload_game_adapter.js");
    AppMethodBeat.o(135997);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.g
 * JD-Core Version:    0.7.0.1
 */