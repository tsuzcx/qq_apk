package com.tencent.mm.plugin.game.luggage.page;

import android.os.Bundle;
import com.tencent.luggage.d.j;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import org.json.JSONObject;

public class i
  extends GameWebPage
{
  public i(j paramj, p paramp, final Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83212);
    Log.i("MicroMsg.PreloadGameWebPage", "create");
    a.h(this.WFO);
    com.tencent.mm.ipcinvoker.s.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        i.this.ejR.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject aoe()
          {
            return null;
          }
          
          public final String name()
          {
            return "onAttachedToWindow";
          }
        });
        String str = paramBundle.getString("KGamePreloadData");
        if (!Util.isNullOrNil(str))
        {
          Log.i("MicroMsg.PreloadGameWebPage", "preloadData:%s", new Object[] { str });
          str = String.format("javascript:(function() {window.__game_center_present_custom_data__=\"%s\";})();", new Object[] { str });
          i.this.eE(str);
        }
        i.this.eE("javascript:(function() {window.__game_center_preload_page_present__=true;})();");
        AppMethodBeat.o(83210);
      }
    });
    com.tencent.mm.ipcinvoker.s.E(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (i.this.WFO != null)
        {
          String str = i.this.WFO.getTitle();
          if (!Util.isNullOrNil(str)) {
            i.this.fq(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    });
    fEZ();
    AppMethodBeat.o(83212);
  }
  
  private void fEZ()
  {
    AppMethodBeat.i(83218);
    this.ejR.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject aoe()
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
  
  protected final h aGk(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = h.bmm(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean aGl(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(dgY()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.aGl(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final String aoH()
  {
    AppMethodBeat.i(83213);
    String str = com.tencent.mm.plugin.appbrand.af.d.ags("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  public final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    Log.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83214);
  }
  
  public final void eH(String paramString)
  {
    AppMethodBeat.i(83216);
    super.eH(paramString);
    fEZ();
    AppMethodBeat.o(83216);
  }
  
  public final void l(String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(83215);
    super.l(paramString, paramBundle);
    AppMethodBeat.o(83215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.i
 * JD-Core Version:    0.7.0.1
 */