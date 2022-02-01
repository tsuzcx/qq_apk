package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends g
{
  public h(j paramj, com.tencent.luggage.d.p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83212);
    ae.i("MicroMsg.PreloadGameWebPage", "create");
    a.e(getWebView());
    com.tencent.mm.ipcinvoker.p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        h.this.chX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BP()
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
    com.tencent.mm.ipcinvoker.p.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (h.this.getWebView() != null)
        {
          String str = h.this.getWebView().getTitle();
          if (!bu.isNullOrNil(str)) {
            h.this.dN(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    }, 100L);
    dan();
    AppMethodBeat.o(83212);
  }
  
  private void dan()
  {
    AppMethodBeat.i(83218);
    this.chX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject BP()
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
  
  public final String Cs()
  {
    AppMethodBeat.i(83213);
    String str = com.tencent.mm.plugin.appbrand.y.d.VE("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.game.g amv(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.aKw(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean amw(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(bRn()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.amw(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final void cF(String paramString)
  {
    AppMethodBeat.i(83216);
    super.cF(paramString);
    dan();
    AppMethodBeat.o(83216);
  }
  
  public final void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    ae.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.h
 * JD-Core Version:    0.7.0.1
 */