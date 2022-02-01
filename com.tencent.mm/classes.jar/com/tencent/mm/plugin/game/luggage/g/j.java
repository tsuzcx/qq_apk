package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import org.json.JSONObject;

public class j
  extends i
{
  public j(com.tencent.luggage.d.j paramj, com.tencent.luggage.d.p paramp, Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83212);
    Log.i("MicroMsg.PreloadGameWebPage", "create");
    a.e(this.ITd);
    com.tencent.mm.ipcinvoker.p.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        j.this.ctS.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject Ld()
          {
            return null;
          }
          
          public final String name()
          {
            return "onAttachedToWindow";
          }
        });
        j.this.cT("javascript:(function() {window.__game_center_preload_page_present__=true;})();");
        AppMethodBeat.o(83210);
      }
    });
    com.tencent.mm.ipcinvoker.p.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (j.this.ITd != null)
        {
          String str = j.this.ITd.getTitle();
          if (!Util.isNullOrNil(str)) {
            j.this.ec(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    });
    dTV();
    AppMethodBeat.o(83212);
  }
  
  private void dTV()
  {
    AppMethodBeat.i(83218);
    this.ctS.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject Ld()
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
  
  public final String LJ()
  {
    AppMethodBeat.i(83213);
    String str = com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  protected final com.tencent.mm.plugin.webview.ui.tools.game.g azK(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = com.tencent.mm.plugin.webview.ui.tools.game.g.baK(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean azL(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(coX()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.azL(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    Log.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83214);
  }
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(83216);
    super.cW(paramString);
    dTV();
    AppMethodBeat.o(83216);
  }
  
  public final void g(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(83215);
    super.g(paramString, paramBundle);
    AppMethodBeat.o(83215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.j
 * JD-Core Version:    0.7.0.1
 */