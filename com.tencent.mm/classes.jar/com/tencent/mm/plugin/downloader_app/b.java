package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.plugin.downloader_app.a.a.c;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.downloader_app.a.d
{
  private static String JQ(String paramString)
  {
    AppMethodBeat.i(136024);
    if (!bo.isNullOrNil(paramString)) {}
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
              AppMethodBeat.o(136024);
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
  
  public final void JP(String paramString)
  {
    AppMethodBeat.i(136023);
    if (!j.contains(paramString))
    {
      LinkedList localLinkedList = j.bjU();
      localLinkedList.add(paramString);
      com.tencent.mm.plugin.downloader_app.b.g.a(localLinkedList, null);
      j.JP(paramString);
    }
    AppMethodBeat.o(136023);
  }
  
  public final long a(com.tencent.mm.plugin.downloader_app.b.a parama, a.b paramb)
  {
    AppMethodBeat.i(136017);
    parama.extInfo = JQ(parama.extInfo);
    long l = c.a(parama, paramb);
    AppMethodBeat.o(136017);
    return l;
  }
  
  public final void a(Context paramContext, Intent paramIntent, a.c paramc)
  {
    AppMethodBeat.i(136016);
    if (paramContext == null)
    {
      if (paramc != null) {
        paramc.aBK();
      }
      AppMethodBeat.o(136016);
      return;
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.getExtras();
    localIntent.setClass(paramContext, DownloadMainUI.class);
    paramContext.startActivity(localIntent);
    if (paramc != null) {
      paramc.aBK();
    }
    AppMethodBeat.o(136016);
  }
  
  public final boolean a(long paramLong, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(136022);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if (locala != null)
    {
      locala.field_extInfo = JQ(locala.field_extInfo);
      com.tencent.mm.plugin.downloader.model.d.e(locala);
      paramBoolean = c.a(locala, paramBoolean, paramb);
      AppMethodBeat.o(136022);
      return paramBoolean;
    }
    paramb.a(com.tencent.mm.plugin.downloader_app.a.a.a.kZZ, paramLong);
    AppMethodBeat.o(136022);
    return false;
  }
  
  public final void aj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(136018);
    l.postDelayed(new b.1(this, paramContext, paramString), 200L);
    AppMethodBeat.o(136018);
  }
  
  public final boolean bjD()
  {
    AppMethodBeat.i(136014);
    boolean bool = j.bjD();
    AppMethodBeat.o(136014);
    return bool;
  }
  
  public final void bjE()
  {
    AppMethodBeat.i(136015);
    j.bjT();
    AppMethodBeat.o(136015);
  }
  
  public final LinkedList<com.tencent.mm.plugin.downloader_app.a.b> bjF()
  {
    AppMethodBeat.i(136019);
    Object localObject1 = j.bjV();
    if (bo.es((List)localObject1))
    {
      AppMethodBeat.o(136019);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      com.tencent.mm.plugin.downloader_app.a.b localb = new com.tencent.mm.plugin.downloader_app.a.b();
      localb.appId = ((String)localObject2);
      localObject2 = f.bjl().JH((String)localObject2);
      if (localObject2 != null)
      {
        localb.cmm = ((FileDownloadTaskInfo)localObject2).id;
        switch (((FileDownloadTaskInfo)localObject2).status)
        {
        default: 
          localb.lad = "default";
        }
        for (;;)
        {
          if (((FileDownloadTaskInfo)localObject2).jyU > 0L)
          {
            localb.progress = ((int)(((FileDownloadTaskInfo)localObject2).kYX * 100L / ((FileDownloadTaskInfo)localObject2).jyU));
            localb.hAP = ((float)((FileDownloadTaskInfo)localObject2).kYX * 100.0F / (float)((FileDownloadTaskInfo)localObject2).jyU);
          }
          if (((FileDownloadTaskInfo)localObject2).kZa) {
            localb.kZa = true;
          }
          localLinkedList.add(localb);
          break;
          localb.lad = "downloading";
          continue;
          localb.lad = "download_succ";
          continue;
          localb.lad = "download_pause";
          continue;
          localb.lad = "download_fail";
        }
      }
    }
    AppMethodBeat.o(136019);
    return localLinkedList;
  }
  
  public final void g(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(136020);
    if (paramContext == null)
    {
      AppMethodBeat.o(136020);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(paramBundle);
    if (((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lRy, false))
    {
      p.C(paramContext, localIntent);
      AppMethodBeat.o(136020);
      return;
    }
    com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.game.GameWebViewUI", localIntent);
    AppMethodBeat.o(136020);
  }
  
  public final void lI(String paramString)
  {
    AppMethodBeat.i(136021);
    j.lI(paramString);
    AppMethodBeat.o(136021);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b
 * JD-Core Version:    0.7.0.1
 */