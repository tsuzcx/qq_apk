package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class k
  implements m
{
  private static Set<a> qFF;
  private static k xEJ;
  private static HashMap<String, b> xEK;
  
  static
  {
    AppMethodBeat.i(41432);
    xEJ = null;
    qFF = Collections.synchronizedSet(new HashSet());
    xEK = new HashMap();
    AppMethodBeat.o(41432);
  }
  
  private void P(long paramLong, final int paramInt)
  {
    AppMethodBeat.i(41417);
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    b localb;
    int i;
    if (locala != null)
    {
      localb = (b)xEK.get(locala.field_downloadUrl);
      switch (paramInt)
      {
      default: 
        i = 0;
        Object localObject = new b();
        ((b)localObject).k(locala);
        com.tencent.mm.plugin.downloader.f.a.a(i, (b)localObject);
        if ((locala.field_status == 2) || (locala.field_status == 5) || (locala.field_status == 4) || (locala.field_status == 3) || (locala.field_status == 0))
        {
          paramLong = locala.field_downloadId;
          Log.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
          localObject = MMApplicationContext.getContext().getSharedPreferences("download_pref", 0);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().remove(String.valueOf(paramLong)).apply();
          }
        }
        if (localb == null) {
          com.tencent.mm.plugin.downloader.f.a.a(locala.field_appId, locala.field_scene, i, locala.field_md5, locala.field_downloadUrl, "", locala.field_extInfo);
        }
        break;
      }
    }
    for (;;)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41410);
          synchronized (k.qFF)
          {
            Iterator localIterator = k.qFF.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).e(paramInt, this.cQM, this.xEL);
            }
          }
          AppMethodBeat.o(41410);
        }
      });
      AppMethodBeat.o(41417);
      return;
      int j = 1;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 0L);
      i = j;
      if (localb == null) {
        break;
      }
      if (localb.xEO)
      {
        com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 1L);
        i = j;
        break;
      }
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 2L);
      i = j;
      break;
      i = 7;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 4L);
      break;
      i = 6;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 3L);
      break;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 5L);
      i = 2;
      break;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 6L);
      i = 3;
      break;
      i = 8;
      com.tencent.mm.plugin.downloader.f.a.aa(locala.field_appId, 7L);
      break;
      com.tencent.mm.plugin.downloader.f.a.a(localb.appId, localb.scene, i, localb.md5, locala.field_downloadUrl, localb.xEN, localb.dFN);
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(41413);
    synchronized (qFF)
    {
      qFF.add(parama);
      AppMethodBeat.o(41413);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(41429);
    if ((paramInt == 710) || (paramInt == 711)) {
      paramInt = com.tencent.mm.plugin.downloader.a.a.qFu;
    }
    for (;;)
    {
      Log.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
      if (!paramBoolean)
      {
        com.tencent.mm.game.report.api.a.hhr.c(paramString1, 2, paramInt, null, paramString2);
        AppMethodBeat.o(41429);
        return;
      }
      com.tencent.mm.game.report.api.a.hhr.c(paramString1, 4, paramInt, null, paramString2);
      AppMethodBeat.o(41429);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41418);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41418);
      return;
    }
    paramString2 = new b(paramString2, paramInt, paramString3, "", paramString4);
    paramString2.xEO = true;
    xEK.put(paramString1, paramString2);
    AppMethodBeat.o(41418);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(41420);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41420);
      return;
    }
    xEK.put(paramString1, new b(paramString2, paramInt, paramString3, paramString4, paramString5));
    AppMethodBeat.o(41420);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(41414);
    synchronized (qFF)
    {
      qFF.remove(parama);
      Log.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(qFF.size()), parama });
      AppMethodBeat.o(41414);
      return;
    }
  }
  
  public static void cBn()
  {
    AppMethodBeat.i(41415);
    if (xEJ == null) {
      xEJ = new k();
    }
    com.tencent.mm.plugin.downloader.b.a.a(new a.b()
    {
      public final void O(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(41409);
        if (paramAnonymousInt == 9) {
          k.access$000(paramAnonymousLong);
        }
        AppMethodBeat.o(41409);
      }
    });
    f.cBv();
    com.tencent.mm.plugin.downloader.model.c.a(xEJ);
    AppMethodBeat.o(41415);
  }
  
  public static void cBo()
  {
    AppMethodBeat.i(41416);
    f.cBv();
    com.tencent.mm.plugin.downloader.model.c.b(xEJ);
    xEJ = null;
    qFF.clear();
    xEK.clear();
    AppMethodBeat.o(41416);
  }
  
  private static void d(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41428);
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    String str2;
    String str1;
    if (locala != null)
    {
      str2 = null;
      str1 = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.qFs) {
        str1 = str2;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      str1 = str2;
      localJSONObject.put("ChannelId", locala.field_channelId);
      str1 = str2;
      localJSONObject.put("DownloadSize", locala.field_downloadedSize);
      str1 = str2;
      str2 = com.tencent.mm.plugin.game.d.a.Fh(localJSONObject.toString());
      str1 = str2;
      Log.d("MicroMsg.GameDownloadEventBus", "extInfo = " + localJSONObject.toString());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + localException.getMessage());
      }
    }
    a(locala.field_appId, paramInt, paramBoolean, str1);
    AppMethodBeat.o(41428);
  }
  
  public static k dVi()
  {
    AppMethodBeat.i(41412);
    if (xEJ == null) {
      xEJ = new k();
    }
    k localk = xEJ;
    AppMethodBeat.o(41412);
    return localk;
  }
  
  public static void hK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41430);
    com.tencent.mm.game.report.api.a.hhr.c(paramString1, 6, 0, null, paramString2);
    AppMethodBeat.o(41430);
  }
  
  public static void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41419);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41419);
      return;
    }
    xEK.put(paramString1, new b(paramString2, 1002, paramString3, "", paramString4));
    AppMethodBeat.o(41419);
  }
  
  public final void Bd(long paramLong)
  {
    AppMethodBeat.i(41424);
    P(paramLong, 4);
    Object localObject = d.Cw(paramLong);
    if (localObject != null) {
      e.aL(MMApplicationContext.getContext(), ((com.tencent.mm.plugin.downloader.g.a)localObject).field_appId);
    }
    localObject = com.tencent.mm.plugin.game.c.c.xvR;
    com.tencent.mm.plugin.game.c.c.report(paramLong);
    AppMethodBeat.o(41424);
  }
  
  public final void Be(long paramLong)
  {
    AppMethodBeat.i(41425);
    P(paramLong, 2);
    AppMethodBeat.o(41425);
  }
  
  public final void Bf(long paramLong) {}
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(204159);
    P(paramLong1, 6);
    AppMethodBeat.o(204159);
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41423);
    Object localObject = d.Cw(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadInWifi) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())))
    {
      Log.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_status = 2;
      ((com.tencent.mm.plugin.downloader.g.a)localObject).field_errCode = 0;
      d.e((com.tencent.mm.plugin.downloader.g.a)localObject);
      b localb = new b();
      localb.k((com.tencent.mm.plugin.downloader.g.a)localObject);
      com.tencent.mm.plugin.downloader.f.a.a(13, localb);
      AppMethodBeat.o(41423);
      return;
    }
    P(paramLong, 5);
    d(paramLong, paramInt, paramBoolean);
    com.tencent.mm.plugin.game.c.e.report(paramLong);
    localObject = com.tencent.mm.plugin.game.c.c.xvR;
    com.tencent.mm.plugin.game.c.c.report(paramLong);
    com.tencent.mm.plugin.downloader.model.a.Cm(paramLong);
    AppMethodBeat.o(41423);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41422);
    Log.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(s.YS(paramString)) });
    if ((!Util.isNullOrNil(paramString)) && (s.YS(paramString)))
    {
      P(paramLong, 3);
      if (paramBoolean)
      {
        paramString = d.Cw(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          com.tencent.mm.game.report.api.a.hhr.c(paramString, 5, 0, null, null);
        }
      }
      com.tencent.mm.plugin.game.c.e.report(paramLong);
      paramString = com.tencent.mm.plugin.game.c.c.xvR;
      com.tencent.mm.plugin.game.c.c.report(paramLong);
      AppMethodBeat.o(41422);
      return;
    }
    paramString = d.Cw(paramLong);
    if (paramString != null)
    {
      paramString.field_status = 4;
      paramString.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFv;
      d.e(paramString);
    }
    b(paramLong, com.tencent.mm.plugin.downloader.a.a.qFv, paramBoolean);
    if (paramString != null) {
      com.tencent.mm.plugin.downloader.f.a.aa(paramString.field_appId, 9L);
    }
    AppMethodBeat.o(41422);
  }
  
  public final void k(long paramLong, String paramString)
  {
    AppMethodBeat.i(41421);
    P(paramLong, 1);
    paramString = com.tencent.mm.plugin.game.c.c.xvR;
    com.tencent.mm.plugin.game.c.c.report(paramLong);
    AppMethodBeat.o(41421);
  }
  
  public final void l(long paramLong, String paramString)
  {
    AppMethodBeat.i(41427);
    P(paramLong, 7);
    AppMethodBeat.o(41427);
  }
  
  public static abstract interface a
  {
    public abstract void e(int paramInt, String paramString, boolean paramBoolean);
  }
  
  static final class b
  {
    String appId = "";
    String dFN = "";
    String md5 = "";
    int scene = 0;
    String xEN = "";
    boolean xEO = false;
    
    b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.md5 = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
      this.xEN = paramString3;
      this.dFN = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */