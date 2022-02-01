package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.game.luggage.a;
import com.tencent.mm.plugin.game.luggage.e;
import com.tencent.mm.plugin.game.luggage.f;
import com.tencent.mm.plugin.game.luggage.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static k oKB;
  private static String oKC = "";
  private static String oKD = "action_id";
  private static String oKE = "preload_url";
  private static String oKF = "detail_url";
  private static int oKG = 1;
  private static int oKH = 2;
  private static int oKI = 3;
  private static int oKJ = 4;
  
  public static void WM(String paramString)
  {
    AppMethodBeat.i(8813);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8813);
      return;
    }
    if ((!ai.eVd()) && (!ai.eVe()))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt(oKD, oKI);
      ((Bundle)localObject).putString(oKE, paramString);
      a.b((Parcelable)localObject, a.class, null);
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
    if (!bs.isNullOrNil((String)localObject)) {}
    for (paramString = paramString.replace((CharSequence)localObject, "");; paramString = "")
    {
      if ((!bs.isNullOrNil(paramString)) && (!paramString.equals(oKC)))
      {
        oKC = paramString;
        ac.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { oKC });
        bYg();
      }
      AppMethodBeat.o(8813);
      return;
    }
  }
  
  private static void bYg()
  {
    AppMethodBeat.i(8814);
    if ((!ai.eVd()) && (!ai.eVe()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(oKD, oKG);
      a.b(localBundle, a.class, null);
      AppMethodBeat.o(8814);
      return;
    }
    if (bs.isNullOrNil(oKC))
    {
      AppMethodBeat.o(8814);
      return;
    }
    f.a(b.class, oKC, new f.a()
    {
      public final void Am()
      {
        AppMethodBeat.i(8809);
        if (d.bYh() != null) {
          d.destroy();
        }
        d.a(f.ar(ai.getContext(), d.oKC));
        if (d.bYh() != null) {
          e.a(d.bYh(), d.oKC, false);
        }
        AppMethodBeat.o(8809);
      }
    });
    AppMethodBeat.o(8814);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(8817);
    if ((!ai.eVd()) && (!ai.eVe()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(oKD, oKH);
      a.b(localBundle, a.class, null);
      AppMethodBeat.o(8817);
      return;
    }
    if (oKB != null)
    {
      oKB.destroy();
      oKB = null;
    }
    AppMethodBeat.o(8817);
  }
  
  public static k ex(Context paramContext)
  {
    AppMethodBeat.i(8815);
    if (oKB != null) {
      oKB.setContext(paramContext);
    }
    p.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8810);
        d.access$200();
        AppMethodBeat.o(8810);
      }
    }, 50L);
    paramContext = oKB;
    oKB = null;
    AppMethodBeat.o(8815);
    return paramContext;
  }
  
  public static void setUrl(String paramString)
  {
    AppMethodBeat.i(8816);
    if ((ai.eVd()) || (ai.eVe()))
    {
      if (oKB != null)
      {
        ac.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        oKB.a(new c()
        {
          public final JSONObject Aq()
          {
            AppMethodBeat.i(8811);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", this.jib);
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
      localBundle.putInt(oKD, oKJ);
      localBundle.putString(oKF, paramString);
      a.b(localBundle, a.class, null);
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