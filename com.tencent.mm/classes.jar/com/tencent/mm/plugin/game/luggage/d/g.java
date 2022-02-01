package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends f
{
  public g(com.tencent.luggage.d.g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    AppMethodBeat.i(83212);
    a.e(getWebView());
    p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        g.this.caI.a(new c()
        {
          public final JSONObject AM()
          {
            return null;
          }
          
          public final String name()
          {
            return "onAttachedToWindow";
          }
        });
        AppMethodBeat.o(83210);
      }
    });
    p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (g.this.getWebView() != null)
        {
          String str = g.this.getWebView().getTitle();
          if (!bt.isNullOrNil(str)) {
            g.this.dn(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    });
    cBP();
    AppMethodBeat.o(83212);
  }
  
  private void cBP()
  {
    AppMethodBeat.i(83218);
    this.caI.a(new c()
    {
      public final JSONObject AM()
      {
        return null;
      }
      
      public final String name()
      {
        return "onJsApiReady";
      }
    });
    AppMethodBeat.o(83218);
  }
  
  public final String Bm()
  {
    AppMethodBeat.i(83213);
    String str = d.Ne("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  protected final h acg(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = h.ayl(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean ach(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(bEx()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.ach(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final void bV(String paramString)
  {
    AppMethodBeat.i(83216);
    super.bV(paramString);
    cBP();
    AppMethodBeat.o(83216);
  }
  
  public final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    ad.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83214);
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(83215);
    super.g(paramString, paramBundle);
    AppMethodBeat.o(83215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.g
 * JD-Core Version:    0.7.0.1
 */