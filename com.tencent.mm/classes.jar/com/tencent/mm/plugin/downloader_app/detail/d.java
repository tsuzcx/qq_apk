package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static com.tencent.luggage.d.p puP;
  private static String puQ = "";
  private static String puR = "action_id";
  private static String puS = "preload_url";
  private static String puT = "detail_url";
  private static int puU = 1;
  private static int puV = 2;
  private static int puW = 3;
  private static int puX = 4;
  
  public static void abk(String paramString)
  {
    AppMethodBeat.i(8813);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8813);
      return;
    }
    if ((!ak.foC()) && (!ak.foD()))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt(puR, puW);
      ((Bundle)localObject).putString(puS, paramString);
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
    if (!bu.isNullOrNil((String)localObject)) {}
    for (paramString = paramString.replace((CharSequence)localObject, "");; paramString = "")
    {
      if ((!bu.isNullOrNil(paramString)) && (!paramString.equals(puQ)))
      {
        puQ = paramString;
        ae.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { puQ });
        cdZ();
      }
      AppMethodBeat.o(8813);
      return;
    }
  }
  
  private static void cdZ()
  {
    AppMethodBeat.i(8814);
    if ((!ak.foC()) && (!ak.foD()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(puR, puU);
      com.tencent.mm.plugin.game.luggage.b.b(localBundle, a.class, null);
      AppMethodBeat.o(8814);
      return;
    }
    if (bu.isNullOrNil(puQ))
    {
      AppMethodBeat.o(8814);
      return;
    }
    h.a(b.class, puQ, new h.a()
    {
      public final void BK()
      {
        AppMethodBeat.i(8809);
        if (d.cea() != null) {
          d.destroy();
        }
        d.a(h.av(ak.getContext(), d.puQ));
        if (d.cea() != null) {
          g.a(d.cea(), d.puQ, false);
        }
        AppMethodBeat.o(8809);
      }
    });
    AppMethodBeat.o(8814);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(8817);
    if ((!ak.foC()) && (!ak.foD()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(puR, puV);
      com.tencent.mm.plugin.game.luggage.b.b(localBundle, a.class, null);
      AppMethodBeat.o(8817);
      return;
    }
    if (puP != null)
    {
      puP.destroy();
      puP = null;
    }
    AppMethodBeat.o(8817);
  }
  
  public static com.tencent.luggage.d.p eB(Context paramContext)
  {
    AppMethodBeat.i(8815);
    if (puP != null) {
      puP.setContext(paramContext);
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
    paramContext = puP;
    puP = null;
    AppMethodBeat.o(8815);
    return paramContext;
  }
  
  public static void setUrl(String paramString)
  {
    AppMethodBeat.i(8816);
    if ((ak.foC()) || (ak.foD()))
    {
      if (puP != null)
      {
        ae.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        puP.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BP()
          {
            AppMethodBeat.i(8811);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", this.jEl);
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
      localBundle.putInt(puR, puX);
      localBundle.putString(puT, paramString);
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