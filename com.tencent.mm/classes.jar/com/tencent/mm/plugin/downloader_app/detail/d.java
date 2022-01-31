package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.e.k;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.game.luggage.h;
import com.tencent.mm.plugin.game.luggage.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static h iRC;
  private static String iRD = "";
  private static String iRE = "action_id";
  private static String iRF = "preload_url";
  private static String iRG = "detail_url";
  private static int iRH = 1;
  private static int iRI = 2;
  private static int iRJ = 3;
  private static int iRK = 4;
  
  private static void aGf()
  {
    if (!ae.cqX())
    {
      localBundle = new Bundle();
      localBundle.putInt(iRE, iRH);
      ToolsProcessIPCService.a(localBundle, d.a.class, null);
    }
    while (bk.bl(iRD))
    {
      Bundle localBundle;
      return;
    }
    i.a(b.class, iRD, new d.1());
  }
  
  public static k cU(Context paramContext)
  {
    if (iRC != null) {
      iRC.setContext(paramContext);
    }
    l.postDelayed(new d.2(), 50L);
    paramContext = iRC;
    iRC = null;
    return paramContext;
  }
  
  public static void destroy()
  {
    if (!ae.cqX())
    {
      localBundle = new Bundle();
      localBundle.putInt(iRE, iRI);
      ToolsProcessIPCService.a(localBundle, d.a.class, null);
    }
    while (iRC == null)
    {
      Bundle localBundle;
      return;
    }
    iRC.destroy();
    iRC = null;
  }
  
  public static void setUrl(String paramString)
  {
    if (ae.cqX())
    {
      if (iRC != null)
      {
        y.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", new Object[] { paramString });
        paramString = Uri.parse(paramString).getQueryParameter("appid");
        iRC.a(new d.3(paramString));
      }
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(iRE, iRK);
    localBundle.putString(iRG, paramString);
    ToolsProcessIPCService.a(localBundle, d.a.class, null);
  }
  
  public static void zV(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      if (!ae.cqX())
      {
        localObject = new Bundle();
        ((Bundle)localObject).putInt(iRE, iRJ);
        ((Bundle)localObject).putString(iRF, paramString);
        ToolsProcessIPCService.a((Parcelable)localObject, d.a.class, null);
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
      if (!bk.bl((String)localObject)) {}
      for (paramString = paramString.replace((CharSequence)localObject, ""); (!bk.bl(paramString)) && (!paramString.equals(iRD)); paramString = "")
      {
        iRD = paramString;
        y.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", new Object[] { iRD });
        aGf();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.detail.d
 * JD-Core Version:    0.7.0.1
 */