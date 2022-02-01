package com.tencent.mm.plugin.downloader_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.j;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.a.a;
import com.tencent.mm.plugin.downloader_app.api.a.b;
import com.tencent.mm.plugin.downloader_app.api.a.c;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.plugin.downloader_app.api.c
{
  private static String abi(String paramString)
  {
    AppMethodBeat.i(8779);
    if (!bu.isNullOrNil(paramString)) {}
    for (;;)
    {
      try
      {
        str1 = URLDecoder.decode(paramString, "utf-8");
      }
      catch (UnsupportedEncodingException paramString)
      {
        try
        {
          String str1;
          paramString = new JSONObject(str1);
          localObject = paramString;
          if (paramString == null) {
            localObject = new JSONObject();
          }
          if (((JSONObject)localObject).optInt("OpInWidget") == 1) {
            ((JSONObject)localObject).remove("OpInWidget");
          }
        }
        catch (Exception paramString)
        {
          try
          {
            ((JSONObject)localObject).put("DownloadInWidget", 1);
            try
            {
              paramString = URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8");
              AppMethodBeat.o(8779);
              return paramString;
              localUnsupportedEncodingException = localUnsupportedEncodingException;
              str2 = paramString;
              continue;
              paramString = paramString;
              paramString = null;
            }
            catch (UnsupportedEncodingException paramString)
            {
              paramString = str2;
              continue;
            }
          }
          catch (JSONException paramString)
          {
            continue;
          }
        }
      }
      Object localObject = null;
      String str2 = paramString;
      paramString = (String)localObject;
    }
  }
  
  public final long a(com.tencent.mm.plugin.downloader_app.a.a parama, a.b paramb)
  {
    AppMethodBeat.i(8773);
    parama.extInfo = abi(parama.extInfo);
    long l = com.tencent.mm.plugin.downloader_app.a.c.a(parama, paramb);
    AppMethodBeat.o(8773);
    return l;
  }
  
  public final void a(Context paramContext, Intent paramIntent, a.c paramc)
  {
    AppMethodBeat.i(8772);
    if (paramContext == null)
    {
      if (paramc != null) {
        paramc.bjj();
      }
      AppMethodBeat.o(8772);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.getExtras();
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    localIntent.setClass(paramContext, DownloadMainUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/plugin/downloader_app/DownloaderAppDelegateImpl", "startDownloadManager", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/downloader_app/api/DownloadAppCallback$StartDownloadManagerCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/downloader_app/DownloaderAppDelegateImpl", "startDownloadManager", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/plugin/downloader_app/api/DownloadAppCallback$StartDownloadManagerCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    if (paramc != null) {
      paramc.bjj();
    }
    AppMethodBeat.o(8772);
  }
  
  public final void a(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183800);
    com.tencent.mm.plugin.downloader_app.a.e.ceh();
    com.tencent.mm.plugin.downloader_app.a.e.a(parame);
    AppMethodBeat.o(183800);
  }
  
  public final boolean a(long paramLong, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(8778);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if (locala != null)
    {
      locala.field_extInfo = abi(locala.field_extInfo);
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      paramBoolean = com.tencent.mm.plugin.downloader_app.a.c.a(locala, paramBoolean, paramb);
      AppMethodBeat.o(8778);
      return paramBoolean;
    }
    paramb.a(a.a.puD, paramLong);
    AppMethodBeat.o(8778);
    return false;
  }
  
  public final void ak(final Context paramContext, final String paramString)
  {
    AppMethodBeat.i(8774);
    com.tencent.mm.ipcinvoker.p.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(8769);
        com.tencent.mm.plugin.downloader.i.a.a(paramContext, paramString, null);
        AppMethodBeat.o(8769);
      }
    }, 200L);
    AppMethodBeat.o(8774);
  }
  
  public final void b(com.tencent.mm.plugin.downloader_app.api.e parame)
  {
    AppMethodBeat.i(183801);
    com.tencent.mm.plugin.downloader_app.a.e.ceh();
    com.tencent.mm.plugin.downloader_app.a.e.b(parame);
    AppMethodBeat.o(183801);
  }
  
  public final boolean cdT()
  {
    AppMethodBeat.i(8770);
    boolean bool = j.cdT();
    AppMethodBeat.o(8770);
    return bool;
  }
  
  public final void cdU()
  {
    AppMethodBeat.i(8771);
    j.cep();
    AppMethodBeat.o(8771);
  }
  
  public final LinkedList<DownloadWidgetTaskInfo> cdV()
  {
    AppMethodBeat.i(8775);
    Object localObject1 = j.cer();
    if (bu.ht((List)localObject1))
    {
      AppMethodBeat.o(8775);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      DownloadWidgetTaskInfo localDownloadWidgetTaskInfo = new DownloadWidgetTaskInfo();
      localDownloadWidgetTaskInfo.appId = ((String)localObject2);
      localObject2 = f.cdA().aaZ((String)localObject2);
      if (localObject2 != null)
      {
        localDownloadWidgetTaskInfo.dkO = ((FileDownloadTaskInfo)localObject2).id;
        localDownloadWidgetTaskInfo.state = ((FileDownloadTaskInfo)localObject2).status;
        switch (((FileDownloadTaskInfo)localObject2).status)
        {
        default: 
          localDownloadWidgetTaskInfo.puH = "default";
        }
        for (;;)
        {
          if (((FileDownloadTaskInfo)localObject2).nyl > 0L)
          {
            localDownloadWidgetTaskInfo.progress = ((int)(((FileDownloadTaskInfo)localObject2).ptA * 100L / ((FileDownloadTaskInfo)localObject2).nyl));
            localDownloadWidgetTaskInfo.kyA = ((float)((FileDownloadTaskInfo)localObject2).ptA * 100.0F / (float)((FileDownloadTaskInfo)localObject2).nyl);
          }
          if (((FileDownloadTaskInfo)localObject2).ptD) {
            localDownloadWidgetTaskInfo.ptD = true;
          }
          localLinkedList.add(localDownloadWidgetTaskInfo);
          break;
          localDownloadWidgetTaskInfo.puH = "downloading";
          continue;
          localDownloadWidgetTaskInfo.puH = "download_succ";
          continue;
          localDownloadWidgetTaskInfo.puH = "download_pause";
          continue;
          localDownloadWidgetTaskInfo.puH = "download_fail";
        }
      }
    }
    AppMethodBeat.o(8775);
    return localLinkedList;
  }
  
  public final void cdW()
  {
    AppMethodBeat.i(175256);
    j.cdW();
    AppMethodBeat.o(175256);
  }
  
  public final boolean cdX()
  {
    AppMethodBeat.i(183799);
    com.tencent.mm.plugin.downloader_app.a.e.ceh();
    boolean bool = com.tencent.mm.plugin.downloader_app.a.e.cek();
    AppMethodBeat.o(183799);
    return bool;
  }
  
  public final void e(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(8776);
    if (paramContext == null)
    {
      AppMethodBeat.o(8776);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (((b)g.ab(b.class)).a(b.a.qws, true))
    {
      com.tencent.mm.plugin.webview.luggage.p.ae(paramContext, localIntent);
      AppMethodBeat.o(8776);
      return;
    }
    com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(8776);
  }
  
  public final void wy(String paramString)
  {
    AppMethodBeat.i(8777);
    j.wy(paramString);
    AppMethodBeat.o(8777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c
 * JD-Core Version:    0.7.0.1
 */