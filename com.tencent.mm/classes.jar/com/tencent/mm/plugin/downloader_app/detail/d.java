package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class d
{
  private static k lal;
  private static String lam = "";
  private static String lan = "action_id";
  private static String lao = "preload_url";
  private static String lap = "detail_url";
  private static int laq = 1;
  private static int lar = 2;
  private static int las = 3;
  private static int lau = 4;
  
  public static void JS(String paramString)
  {
    AppMethodBeat.i(136058);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(136058);
      return;
    }
    if (!ah.dsW())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putInt(lan, las);
      ((Bundle)localObject).putString(lao, paramString);
      ToolsProcessIPCService.a((Parcelable)localObject, d.a.class, null);
      AppMethodBeat.o(136058);
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
    if (!bo.isNullOrNil((String)localObject)) {}
    for (paramString = paramString.replace((CharSequence)localObject, "");; paramString = "")
    {
      if ((!bo.isNullOrNil(paramString)) && (!paramString.equals(lam)))
      {
        lam = paramString;
        ab.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { lam });
        bjH();
      }
      AppMethodBeat.o(136058);
      return;
    }
  }
  
  private static void bjH()
  {
    AppMethodBeat.i(136059);
    if (!ah.dsW())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(lan, laq);
      ToolsProcessIPCService.a(localBundle, d.a.class, null);
      AppMethodBeat.o(136059);
      return;
    }
    if (bo.isNullOrNil(lam))
    {
      AppMethodBeat.o(136059);
      return;
    }
    com.tencent.mm.plugin.game.luggage.d.a(b.class, lam, new d.1());
    AppMethodBeat.o(136059);
  }
  
  public static k dH(Context paramContext)
  {
    AppMethodBeat.i(136060);
    if (lal != null) {
      lal.setContext(paramContext);
    }
    l.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136055);
        d.access$200();
        AppMethodBeat.o(136055);
      }
    }, 50L);
    paramContext = lal;
    lal = null;
    AppMethodBeat.o(136060);
    return paramContext;
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(136062);
    if (!ah.dsW())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(lan, lar);
      ToolsProcessIPCService.a(localBundle, d.a.class, null);
      AppMethodBeat.o(136062);
      return;
    }
    if (lal != null)
    {
      lal.destroy();
      lal = null;
    }
    AppMethodBeat.o(136062);
  }
  
  public static void setUrl(String paramString)
  {
    AppMethodBeat.i(136061);
    if (ah.dsW())
    {
      if (lal != null)
      {
        ab.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        lal.a(new d.3(paramString));
        AppMethodBeat.o(136061);
      }
    }
    else
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt(lan, lau);
      localBundle.putString(lap, paramString);
      ToolsProcessIPCService.a(localBundle, d.a.class, null);
    }
    AppMethodBeat.o(136061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d
 * JD-Core Version:    0.7.0.1
 */