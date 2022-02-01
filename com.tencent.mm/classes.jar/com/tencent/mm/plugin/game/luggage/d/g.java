package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    a.d(getWebView());
    p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        g.this.bXF.a(new c()
        {
          public final JSONObject Aq()
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
    p.A(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (g.this.getWebView() != null)
        {
          String str = g.this.getWebView().getTitle();
          if (!bs.isNullOrNil(str)) {
            g.this.dt(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    });
    cPa();
    AppMethodBeat.o(83212);
  }
  
  private void cPa()
  {
    AppMethodBeat.i(83218);
    this.bXF.a(new c()
    {
      public final JSONObject Aq()
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
  
  public final String AQ()
  {
    AppMethodBeat.i(83213);
    String str = d.Rn("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  protected final h agY(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = h.aDC(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean agZ(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(bLL()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.agZ(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final void bL(String paramString)
  {
    AppMethodBeat.i(83216);
    super.bL(paramString);
    cPa();
    AppMethodBeat.o(83216);
  }
  
  public final void e(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    ac.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
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