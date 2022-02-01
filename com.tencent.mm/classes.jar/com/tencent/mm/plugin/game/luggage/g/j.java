package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
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

public class j
  extends i
{
  public j(com.tencent.luggage.d.j paramj, p paramp, final Bundle paramBundle)
  {
    super(paramj, paramp, paramBundle);
    AppMethodBeat.i(83212);
    Log.i("MicroMsg.PreloadGameWebPage", "create");
    a.f(this.PPv);
    com.tencent.mm.ipcinvoker.s.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83210);
        j.this.crX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject NU()
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
          j.this.dt(str);
        }
        j.this.dt("javascript:(function() {window.__game_center_preload_page_present__=true;})();");
        AppMethodBeat.o(83210);
      }
    });
    com.tencent.mm.ipcinvoker.s.z(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83211);
        if (j.this.PPv != null)
        {
          String str = j.this.PPv.getTitle();
          if (!Util.isNullOrNil(str)) {
            j.this.eA(str, 0);
          }
        }
        AppMethodBeat.o(83211);
      }
    });
    exc();
    AppMethodBeat.o(83212);
  }
  
  private void exc()
  {
    AppMethodBeat.i(83218);
    this.crX.a(new com.tencent.luggage.d.d()
    {
      public final JSONObject NU()
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
  
  public final String Oz()
  {
    AppMethodBeat.i(83213);
    String str = com.tencent.mm.plugin.appbrand.ac.d.anc("preload_game_adapter.js");
    AppMethodBeat.o(83213);
    return str;
  }
  
  protected final h aJw(String paramString)
  {
    AppMethodBeat.i(83219);
    paramString = h.bmI(paramString);
    AppMethodBeat.o(83219);
    return paramString;
  }
  
  public final boolean aJx(String paramString)
  {
    AppMethodBeat.i(83217);
    if (paramString.equals(cDu()))
    {
      AppMethodBeat.o(83217);
      return false;
    }
    boolean bool = super.aJx(paramString);
    AppMethodBeat.o(83217);
    return bool;
  }
  
  public final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(83214);
    Log.i("MicroMsg.PreloadGameWebPage", "onUrlRedirect, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    AppMethodBeat.o(83214);
  }
  
  public final void dw(String paramString)
  {
    AppMethodBeat.i(83216);
    super.dw(paramString);
    exc();
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.j
 * JD-Core Version:    0.7.0.1
 */