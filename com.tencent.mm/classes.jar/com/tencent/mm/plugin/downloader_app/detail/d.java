package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static com.tencent.luggage.d.p poi;
  private static String poj = "";
  private static String pok = "action_id";
  private static String pol = "preload_url";
  private static String pom = "detail_url";
  private static int pon = 1;
  private static int poo = 2;
  private static int pop = 3;
  private static int poq = 4;
  
  public static void aat(String paramString)
  {
    AppMethodBeat.i(8813);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8813);
      return;
    }
    if ((!aj.fkI()) && (!aj.fkJ()))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt(pok, pop);
      ((Bundle)localObject).putString(pol, paramString);
      com.tencent.mm.plugin.game.luggage.b.b((Parcelable)localObject, a.class, null);
      AppMethodBeat.o(8813);
      return;
    }
    int k = paramString.indexOf("appid");
    Object localObject = "";
    if (k != -1)
    {
      int j = paramString.indexOf('&', k);
      int i = j;
      if (j == -1) {
        i = paramString.length();
      }
      localObject = paramString.substring(k, i);
    }
    if (!bt.isNullOrNil((String)localObject)) {}
    for (paramString = paramString.replace((CharSequence)localObject, "");; paramString = "")
    {
      if ((!bt.isNullOrNil(paramString)) && (!paramString.equals(poj)))
      {
        poj = paramString;
        ad.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { poj });
        ccK();
      }
      AppMethodBeat.o(8813);
      return;
    }
  }
  
  private static void ccK()
  {
    AppMethodBeat.i(8814);
    if ((!aj.fkI()) && (!aj.fkJ()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(pok, pon);
      com.tencent.mm.plugin.game.luggage.b.b(localBundle, a.class, null);
      AppMethodBeat.o(8814);
      return;
    }
    if (bt.isNullOrNil(poj))
    {
      AppMethodBeat.o(8814);
      return;
    }
    h.a(b.class, poj, new h.a()
    {
      public final void BJ()
      {
        AppMethodBeat.i(8809);
        if (d.ccL() != null) {
          d.destroy();
        }
        d.a(h.at(aj.getContext(), d.poj));
        if (d.ccL() != null) {
          g.a(d.ccL(), d.poj, false);
        }
        AppMethodBeat.o(8809);
      }
    });
    AppMethodBeat.o(8814);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(8817);
    if ((!aj.fkI()) && (!aj.fkJ()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(pok, poo);
      com.tencent.mm.plugin.game.luggage.b.b(localBundle, a.class, null);
      AppMethodBeat.o(8817);
      return;
    }
    if (poi != null)
    {
      poi.destroy();
      poi = null;
    }
    AppMethodBeat.o(8817);
  }
  
  public static com.tencent.luggage.d.p ex(Context paramContext)
  {
    AppMethodBeat.i(8815);
    if (poi != null) {
      poi.setContext(paramContext);
    }
    com.tencent.mm.ipcinvoker.p.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8810);
        d.access$200();
        AppMethodBeat.o(8810);
      }
    }, 50L);
    paramContext = poi;
    poi = null;
    AppMethodBeat.o(8815);
    return paramContext;
  }
  
  public static void setUrl(String paramString)
  {
    AppMethodBeat.i(8816);
    if ((aj.fkI()) || (aj.fkJ()))
    {
      if (poi != null)
      {
        ad.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        poi.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BO()
          {
            AppMethodBeat.i(8811);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", this.jBr);
              label25:
              AppMethodBeat.o(8811);
              return localJSONObject;
            }
            catch (JSONException localJSONException)
            {
              break label25;
            }
          }
          
          public final String name()
          {
            return "onDataEnvReady";
          }
        });
        AppMethodBeat.o(8816);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(pok, poq);
      localBundle.putString(pom, paramString);
      com.tencent.mm.plugin.game.luggage.b.b(localBundle, a.class, null);
    }
    AppMethodBeat.o(8816);
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d
 * JD-Core Version:    0.7.0.1
 */