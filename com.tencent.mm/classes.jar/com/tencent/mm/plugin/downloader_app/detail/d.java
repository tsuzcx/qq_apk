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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static k ohb;
  private static String ohc = "";
  private static String ohd = "action_id";
  private static String ohe = "preload_url";
  private static String ohf = "detail_url";
  private static int ohg = 1;
  private static int ohh = 2;
  private static int ohi = 3;
  private static int ohj = 4;
  
  public static void SA(String paramString)
  {
    AppMethodBeat.i(8813);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(8813);
      return;
    }
    if ((!aj.eFJ()) && (!aj.eFK()))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt(ohd, ohi);
      ((Bundle)localObject).putString(ohe, paramString);
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
    if (!bt.isNullOrNil((String)localObject)) {}
    for (paramString = paramString.replace((CharSequence)localObject, "");; paramString = "")
    {
      if ((!bt.isNullOrNil(paramString)) && (!paramString.equals(ohc)))
      {
        ohc = paramString;
        ad.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { ohc });
        bQQ();
      }
      AppMethodBeat.o(8813);
      return;
    }
  }
  
  private static void bQQ()
  {
    AppMethodBeat.i(8814);
    if ((!aj.eFJ()) && (!aj.eFK()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(ohd, ohg);
      a.b(localBundle, a.class, null);
      AppMethodBeat.o(8814);
      return;
    }
    if (bt.isNullOrNil(ohc))
    {
      AppMethodBeat.o(8814);
      return;
    }
    f.a(b.class, ohc, new f.a()
    {
      public final void AI()
      {
        AppMethodBeat.i(8809);
        if (d.bQR() != null) {
          d.destroy();
        }
        d.a(f.aq(aj.getContext(), d.ohc));
        if (d.bQR() != null) {
          e.a(d.bQR(), d.ohc, false);
        }
        AppMethodBeat.o(8809);
      }
    });
    AppMethodBeat.o(8814);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(8817);
    if ((!aj.eFJ()) && (!aj.eFK()))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(ohd, ohh);
      a.b(localBundle, a.class, null);
      AppMethodBeat.o(8817);
      return;
    }
    if (ohb != null)
    {
      ohb.destroy();
      ohb = null;
    }
    AppMethodBeat.o(8817);
  }
  
  public static k ep(Context paramContext)
  {
    AppMethodBeat.i(8815);
    if (ohb != null) {
      ohb.setContext(paramContext);
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
    paramContext = ohb;
    ohb = null;
    AppMethodBeat.o(8815);
    return paramContext;
  }
  
  public static void setUrl(String paramString)
  {
    AppMethodBeat.i(8816);
    if ((aj.eFJ()) || (aj.eFK()))
    {
      if (ohb != null)
      {
        ad.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        ohb.a(new c()
        {
          public final JSONObject AM()
          {
            AppMethodBeat.i(8811);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("appid", this.iHZ);
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
      localBundle.putInt(ohd, ohj);
      localBundle.putString(ohf, paramString);
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