package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.event.a.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class k
  implements m
{
  private static k ICV;
  private static HashMap<String, b> ICW;
  private static Set<a> eO;
  
  static
  {
    AppMethodBeat.i(41432);
    ICV = null;
    eO = Collections.synchronizedSet(new HashSet());
    ICW = new HashMap();
    AppMethodBeat.o(41432);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(41413);
    synchronized (eO)
    {
      eO.add(parama);
      AppMethodBeat.o(41413);
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
    paramString2.IDa = true;
    ICW.put(paramString1, paramString2);
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
    ICW.put(paramString1, new b(paramString2, paramInt, paramString3, paramString4, paramString5));
    AppMethodBeat.o(41420);
  }
  
  private void am(long paramLong, final int paramInt)
  {
    AppMethodBeat.i(41417);
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    b localb;
    int i;
    if (locala != null)
    {
      localb = (b)ICW.get(locala.field_downloadUrl);
      switch (paramInt)
      {
      default: 
        i = 0;
        Object localObject = new b();
        ((b)localObject).k(locala);
        com.tencent.mm.plugin.downloader.e.a.a(i, (b)localObject);
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
          com.tencent.mm.plugin.downloader.e.a.a(locala.field_appId, locala.field_scene, i, locala.field_md5, locala.field_downloadUrl, "", locala.field_extInfo);
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
          synchronized (k.eO)
          {
            Iterator localIterator = k.eO.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).f(paramInt, this.ryL, this.ICX);
            }
          }
          AppMethodBeat.o(41410);
        }
      });
      AppMethodBeat.o(41417);
      return;
      int j = 1;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 0L);
      i = j;
      if (localb == null) {
        break;
      }
      if (localb.IDa)
      {
        com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 1L);
        i = j;
        break;
      }
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 2L);
      i = j;
      break;
      i = 7;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 4L);
      break;
      i = 6;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 3L);
      break;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 5L);
      i = 2;
      break;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 6L);
      i = 3;
      break;
      i = 8;
      com.tencent.mm.plugin.downloader.e.a.af(locala.field_appId, 7L);
      break;
      com.tencent.mm.plugin.downloader.e.a.a(localb.appId, localb.scene, i, localb.md5, locala.field_downloadUrl, localb.ICZ, localb.hDd);
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(41414);
    synchronized (eO)
    {
      eO.remove(parama);
      Log.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(eO.size()), parama });
      AppMethodBeat.o(41414);
      return;
    }
  }
  
  public static void b(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(41429);
    if ((paramInt == 710) || (paramInt == 711)) {
      paramInt = com.tencent.mm.plugin.downloader.a.a.xky;
    }
    for (;;)
    {
      Log.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
      if (!paramBoolean)
      {
        com.tencent.mm.game.report.api.a.mtH.c(paramString1, 2, paramInt, null, paramString2);
        AppMethodBeat.o(41429);
        return;
      }
      com.tencent.mm.game.report.api.a.mtH.c(paramString1, 4, paramInt, null, paramString2);
      AppMethodBeat.o(41429);
      return;
    }
  }
  
  public static void cuD()
  {
    AppMethodBeat.i(41416);
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.b(ICV);
    ICV = null;
    eO.clear();
    ICW.clear();
    AppMethodBeat.o(41416);
  }
  
  public static void duo()
  {
    AppMethodBeat.i(41415);
    if (ICV == null) {
      ICV = new k();
    }
    com.tencent.mm.plugin.downloader.event.a.a(new a.b()
    {
      public final void S(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(41409);
        if (paramAnonymousInt == 9) {
          k.access$000(paramAnonymousLong);
        }
        AppMethodBeat.o(41409);
      }
    });
    f.duv();
    com.tencent.mm.plugin.downloader.model.c.a(ICV);
    AppMethodBeat.o(41415);
  }
  
  private static void e(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41428);
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    String str2;
    String str1;
    if (locala != null)
    {
      str2 = null;
      str1 = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.xkw) {
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
      str2 = com.tencent.mm.plugin.game.c.a.EM(localJSONObject.toString());
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
    b(locala.field_appId, paramInt, paramBoolean, str1);
    AppMethodBeat.o(41428);
  }
  
  public static k fGm()
  {
    AppMethodBeat.i(41412);
    if (ICV == null) {
      ICV = new k();
    }
    k localk = ICV;
    AppMethodBeat.o(41412);
    return localk;
  }
  
  public static void jb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41430);
    com.tencent.mm.game.report.api.a.mtH.c(paramString1, 6, 0, null, paramString2);
    AppMethodBeat.o(41430);
  }
  
  public static void y(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41419);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41419);
      return;
    }
    ICW.put(paramString1, new b(paramString2, 1002, paramString3, "", paramString4));
    AppMethodBeat.o(41419);
  }
  
  public final void a(long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(275431);
    am(paramLong1, 6);
    AppMethodBeat.o(275431);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41422);
    Log.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(y.ZC(paramString)) });
    if ((!Util.isNullOrNil(paramString)) && (y.ZC(paramString)))
    {
      am(paramLong, 3);
      if (paramBoolean)
      {
        paramString = d.la(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          com.tencent.mm.game.report.api.a.mtH.c(paramString, 5, 0, null, null);
        }
      }
      com.tencent.mm.plugin.game.b.e.report(paramLong);
      paramString = com.tencent.mm.plugin.game.b.c.Itx;
      com.tencent.mm.plugin.game.b.c.report(paramLong);
      AppMethodBeat.o(41422);
      return;
    }
    paramString = d.la(paramLong);
    if (paramString != null)
    {
      paramString.field_status = 4;
      paramString.field_errCode = com.tencent.mm.plugin.downloader.a.a.xkz;
      d.e(paramString);
    }
    c(paramLong, com.tencent.mm.plugin.downloader.a.a.xkz, paramBoolean);
    if (paramString != null) {
      com.tencent.mm.plugin.downloader.e.a.af(paramString.field_appId, 9L);
    }
    AppMethodBeat.o(41422);
  }
  
  public final void c(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41423);
    Object localObject = d.la(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadInWifi) && (!NetStatusUtil.isWifi(MMApplicationContext.getContext())))
    {
      Log.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_status = 2;
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_errCode = 0;
      d.e((com.tencent.mm.plugin.downloader.f.a)localObject);
      b localb = new b();
      localb.k((com.tencent.mm.plugin.downloader.f.a)localObject);
      com.tencent.mm.plugin.downloader.e.a.a(13, localb);
      AppMethodBeat.o(41423);
      return;
    }
    am(paramLong, 5);
    e(paramLong, paramInt, paramBoolean);
    com.tencent.mm.plugin.game.b.e.report(paramLong);
    localObject = com.tencent.mm.plugin.game.b.c.Itx;
    com.tencent.mm.plugin.game.b.c.report(paramLong);
    com.tencent.mm.plugin.downloader.model.a.kQ(paramLong);
    AppMethodBeat.o(41423);
  }
  
  public final void jF(long paramLong)
  {
    AppMethodBeat.i(41424);
    am(paramLong, 4);
    Object localObject = d.la(paramLong);
    if (localObject != null) {
      e.aV(MMApplicationContext.getContext(), ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId);
    }
    localObject = com.tencent.mm.plugin.game.b.c.Itx;
    com.tencent.mm.plugin.game.b.c.report(paramLong);
    AppMethodBeat.o(41424);
  }
  
  public final void jG(long paramLong)
  {
    AppMethodBeat.i(41425);
    am(paramLong, 2);
    AppMethodBeat.o(41425);
  }
  
  public final void jH(long paramLong) {}
  
  public final void v(long paramLong, String paramString)
  {
    AppMethodBeat.i(41421);
    am(paramLong, 1);
    paramString = com.tencent.mm.plugin.game.b.c.Itx;
    com.tencent.mm.plugin.game.b.c.report(paramLong);
    AppMethodBeat.o(41421);
  }
  
  public final void w(long paramLong, String paramString)
  {
    AppMethodBeat.i(41427);
    am(paramLong, 7);
    AppMethodBeat.o(41427);
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt, String paramString, boolean paramBoolean);
  }
  
  static final class b
  {
    String ICZ = "";
    boolean IDa = false;
    String appId = "";
    String hDd = "";
    String md5 = "";
    int scene = 0;
    
    b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.md5 = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
      this.ICZ = paramString3;
      this.hDd = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */