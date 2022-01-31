package com.tencent.mm.plugin.downloader_app.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.downloader_app.a.a.a;
import com.tencent.mm.plugin.downloader_app.a.a.b;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private static String JU(String paramString)
  {
    AppMethodBeat.i(136108);
    if ((paramString != null) && (paramString.contains("OpInWidget")))
    {
      AppMethodBeat.o(136108);
      return paramString;
    }
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
        }
        catch (Exception paramString)
        {
          try
          {
            ((JSONObject)localObject).put("OpInWidget", 1);
            try
            {
              paramString = URLEncoder.encode(((JSONObject)localObject).toString(), "utf-8");
              AppMethodBeat.o(136108);
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
  
  public static long a(a parama, a.b paramb)
  {
    AppMethodBeat.i(136101);
    if (!j.contains(parama.appId))
    {
      localObject = j.bjU();
      ((LinkedList)localObject).add(parama.appId);
      g.a((LinkedList)localObject, new c.14());
      j.JP(parama.appId);
    }
    Object localObject = new g.a();
    ((g.a)localObject).JJ(parama.downloadUrl);
    ((g.a)localObject).JK(parama.laB);
    ((g.a)localObject).iR(parama.laC);
    ((g.a)localObject).JL(parama.appName);
    ((g.a)localObject).setAppId(parama.appId);
    ((g.a)localObject).JM(parama.laD);
    ((g.a)localObject).gr(true);
    ((g.a)localObject).gs(false);
    int i;
    long l;
    if (parama.fileType == 0)
    {
      i = 1;
      ((g.a)localObject).tV(i);
      ((g.a)localObject).dC(parama.packageName);
      ((g.a)localObject).bjv();
      ((g.a)localObject).setScene(parama.scene);
      ((g.a)localObject).JN(parama.extInfo);
      ((g.a)localObject).gt(parama.kYZ);
      ((g.a)localObject).tZ(parama.kZB);
      ((g.a)localObject).tW(parama.kZA);
      ((g.a)localObject).tY(parama.kZz);
      ((g.a)localObject).tX(parama.kZy);
      if (parama.cvQ != 1) {
        break label356;
      }
      l = f.bjl().b(((g.a)localObject).kYR);
      label236:
      ab.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.cvQ) });
      if (paramb != null)
      {
        if ((!parama.kYZ) || (at.isWifi(ah.getContext()))) {
          break label371;
        }
        localObject = a.a.laa;
      }
    }
    for (;;)
    {
      paramb.a((a.a)localObject, l);
      if ((parama.kYZ) && (!at.isWifi(ah.getContext()))) {
        d.JW(parama.appId);
      }
      com.tencent.mm.modelstat.d.b(10, "DownloadPluginUtil_downloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(136101);
      return l;
      i = parama.fileType;
      break;
      label356:
      l = f.bjl().a(((g.a)localObject).kYR);
      break label236;
      label371:
      if (l > 0L) {
        localObject = a.a.kZY;
      } else {
        localObject = a.a.kZZ;
      }
    }
  }
  
  public static void a(Context paramContext, long paramLong, a.b paramb)
  {
    AppMethodBeat.i(138738);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if (locala == null)
    {
      paramb.a(a.a.kZZ, -1L);
      AppMethodBeat.o(138738);
      return;
    }
    ((com.tencent.mm.plugin.downloader_app.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader_app.a.c.class)).b(paramContext, locala.field_appId, new c.4(locala, paramb), new c.5(locala, paramb, paramLong), null);
    AppMethodBeat.o(138738);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.downloader.g.a parama, i parami, a.b paramb)
  {
    AppMethodBeat.i(136103);
    if (!at.isConnected(paramContext))
    {
      h.a(paramContext, paramContext.getString(2131301796), paramContext.getString(2131301797), paramContext.getString(2131300998), false, new c.15(parama, paramb));
      AppMethodBeat.o(136103);
      return;
    }
    if (at.isWifi(paramContext))
    {
      d.JV(parama.field_appId);
      a(parama, false, paramb);
      AppMethodBeat.o(136103);
      return;
    }
    if (parami.lbb.kWw)
    {
      ((com.tencent.mm.plugin.downloader_app.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader_app.a.c.class)).a(paramContext, parama.field_appId, new c.16(parama, paramb), new c.17(parama, paramb), null);
      AppMethodBeat.o(136103);
      return;
    }
    if (parama.field_reserveInWifi)
    {
      parama.field_downloadInWifi = false;
      parama.field_reserveInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(parama);
    }
    h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new c.2(parama, paramb), new c.3(parami), 2131690701);
    AppMethodBeat.o(136103);
  }
  
  public static void a(Context paramContext, a parama, a.b paramb)
  {
    AppMethodBeat.i(136100);
    if ((paramContext == null) || (!parama.isValid()))
    {
      AppMethodBeat.o(136100);
      return;
    }
    if (!at.isWifi(paramContext))
    {
      if (parama.kYZ)
      {
        ((com.tencent.mm.plugin.downloader_app.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader_app.a.c.class)).a(paramContext, parama.appId, new c.10(parama, paramb), new c.11(parama, paramb), null);
        AppMethodBeat.o(136100);
        return;
      }
      h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new c.12(parama, paramb), new c.13(), 2131690701);
      AppMethodBeat.o(136100);
      return;
    }
    d.JV(parama.appId);
    parama.kYZ = false;
    a(parama, paramb);
    AppMethodBeat.o(136100);
  }
  
  public static void a(Context paramContext, i parami)
  {
    AppMethodBeat.i(138734);
    a(paramContext, parami, false);
    AppMethodBeat.o(138734);
  }
  
  public static void a(Context paramContext, i parami, a.b paramb)
  {
    AppMethodBeat.i(138736);
    a(paramContext, parami, true, paramb);
    AppMethodBeat.o(138736);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(136099);
    if (!paramBoolean) {
      com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 23, parami.appId, "", "");
    }
    b(paramContext, parami, paramBoolean);
    AppMethodBeat.o(136099);
  }
  
  public static void a(Context paramContext, i parami, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(136102);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(parami.appId);
    if (locala != null)
    {
      locala.field_extInfo = JU(locala.field_extInfo);
      locala.field_downloadType = 1;
      a(paramContext, locala, parami, paramb);
      paramContext = new com.tencent.mm.plugin.downloader.f.b();
      paramContext.i(locala);
      com.tencent.mm.plugin.downloader.f.a.a(10, paramContext);
    }
    if (paramBoolean) {
      com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 6, parami.appId, "", "");
    }
    AppMethodBeat.o(136102);
  }
  
  public static void a(i parami)
  {
    AppMethodBeat.i(136105);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(parami.appId);
    if (locala != null)
    {
      f.bjl().iB(locala.field_downloadId);
      com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 5, locala.field_appId, "", "");
    }
    AppMethodBeat.o(136105);
  }
  
  public static boolean a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, a.b paramb)
  {
    AppMethodBeat.i(136104);
    if (!j.contains(parama.field_appId))
    {
      localObject = j.bjU();
      ((LinkedList)localObject).add(parama.field_appId);
      g.a((LinkedList)localObject, null);
      j.JP(parama.field_appId);
    }
    parama.field_showNotification = false;
    parama.field_fromDownloadApp = true;
    parama.field_downloadInWifi = paramBoolean;
    parama.field_reserveInWifi = paramBoolean;
    com.tencent.mm.plugin.downloader.model.d.e(parama);
    paramBoolean = f.bjl().iC(parama.field_downloadId);
    if (paramb != null) {
      if (!paramBoolean) {
        break label121;
      }
    }
    label121:
    for (Object localObject = a.a.kZY;; localObject = a.a.kZZ)
    {
      paramb.a((a.a)localObject, parama.field_downloadId);
      com.tencent.mm.modelstat.d.b(10, "DownloadPluginUtil_resumeDownloadTaskStraight", c.class.hashCode());
      AppMethodBeat.o(136104);
      return paramBoolean;
    }
  }
  
  private static void b(Context paramContext, i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(138735);
    if ((paramContext == null) || (parami == null))
    {
      AppMethodBeat.o(138735);
      return;
    }
    a locala = new a();
    locala.downloadUrl = parami.lbb.eds;
    locala.laB = parami.lbb.kWu;
    locala.appId = parami.appId;
    locala.appName = parami.appName;
    locala.laC = parami.lbb.kWo;
    locala.laD = parami.lbb.kWp;
    locala.packageName = parami.lbb.kWn;
    locala.cvQ = parami.lbb.kWq;
    locala.extInfo = bjN();
    if (paramBoolean) {}
    for (int i = 6003;; i = 6002)
    {
      locala.scene = i;
      locala.kYZ = parami.lbb.kWw;
      locala.fileType = 1;
      locala.cvQ = 1;
      com.tencent.mm.plugin.downloader.f.a.a(9, new com.tencent.mm.plugin.downloader.f.b(locala.appId, locala.scene, -1L, ""));
      if (at.isConnected(paramContext)) {
        break;
      }
      h.a(paramContext, paramContext.getString(2131301796), paramContext.getString(2131301797), paramContext.getString(2131300998), false, new c.1(locala));
      AppMethodBeat.o(138735);
      return;
    }
    a(paramContext, locala, null);
    AppMethodBeat.o(138735);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(138737);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(parami.appId);
    if (locala != null) {
      f.bjl().iz(locala.field_downloadId);
    }
    com.tencent.mm.plugin.downloader_app.c.a.a(11, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 81, parami.appId, "", "");
    AppMethodBeat.o(138737);
  }
  
  public static boolean b(Context paramContext, i parami)
  {
    AppMethodBeat.i(136106);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.JD(parami.appId);
    if (locala == null)
    {
      AppMethodBeat.o(136106);
      return false;
    }
    if (e.cN(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.i.a.a(locala.field_downloadId, false, null);
      com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 44, parami.appId, "", "");
      AppMethodBeat.o(136106);
      return true;
    }
    h.a(paramContext, paramContext.getString(2131302042), paramContext.getString(2131302043), paramContext.getString(2131302649), paramContext.getString(2131304262), false, new c.6(paramContext, parami), new c.7());
    AppMethodBeat.o(136106);
    return false;
  }
  
  private static String bjN()
  {
    AppMethodBeat.i(136107);
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("DownloadInWidget", 1);
      ((JSONObject)localObject2).put("OpInWidget", 1);
      label31:
      Object localObject1 = null;
      try
      {
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "utf-8");
        localObject1 = localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label45:
        break label45;
      }
      AppMethodBeat.o(136107);
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      break label31;
    }
  }
  
  public static void c(Context paramContext, i parami)
  {
    AppMethodBeat.i(138739);
    if (p.u(paramContext, parami.lbb.kWn))
    {
      com.tencent.mm.plugin.downloader.i.a.a(paramContext, parami.appId, null);
      com.tencent.mm.plugin.downloader_app.c.a.a(10, com.tencent.mm.plugin.downloader_app.c.a.uc(parami.type), parami.position, 22, parami.appId, "", "");
      AppMethodBeat.o(138739);
      return;
    }
    h.a(paramContext, paramContext.getString(2131297092), paramContext.getString(2131297093), paramContext.getString(2131302649), paramContext.getString(2131304262), false, new c.8(paramContext, parami), new c.9());
    AppMethodBeat.o(138739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c
 * JD-Core Version:    0.7.0.1
 */