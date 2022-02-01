package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.b;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class k
  implements m
{
  private static Set<a> oFR;
  private static HashMap<String, b> tdA;
  private static k tdz;
  
  static
  {
    AppMethodBeat.i(41432);
    tdz = null;
    oFR = Collections.synchronizedSet(new HashSet());
    tdA = new HashMap();
    AppMethodBeat.o(41432);
  }
  
  private void M(long paramLong, final int paramInt)
  {
    AppMethodBeat.i(41417);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    b localb;
    int i;
    if (locala != null)
    {
      localb = (b)tdA.get(locala.field_downloadUrl);
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
          ac.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
          localObject = ai.getContext().getSharedPreferences("download_pref", 0);
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
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41410);
          synchronized (k.oFR)
          {
            Iterator localIterator = k.oFR.iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).e(paramInt, this.cro, this.tdB);
            }
          }
          AppMethodBeat.o(41410);
        }
      });
      AppMethodBeat.o(41417);
      return;
      int j = 1;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 0L);
      i = j;
      if (localb == null) {
        break;
      }
      if (localb.tdE)
      {
        com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 1L);
        i = j;
        break;
      }
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 2L);
      i = j;
      break;
      i = 7;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 4L);
      break;
      i = 6;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 3L);
      break;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 5L);
      i = 2;
      break;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 6L);
      i = 3;
      break;
      i = 8;
      com.tencent.mm.plugin.downloader.f.a.U(locala.field_appId, 7L);
      break;
      com.tencent.mm.plugin.downloader.f.a.a(localb.appId, localb.scene, i, localb.md5, locala.field_downloadUrl, localb.tdD, localb.dbZ);
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(41413);
    synchronized (oFR)
    {
      oFR.add(parama);
      AppMethodBeat.o(41413);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(41429);
    if ((paramInt == 710) || (paramInt == 711)) {
      paramInt = com.tencent.mm.plugin.downloader.a.a.oFG;
    }
    for (;;)
    {
      ac.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
      if (!paramBoolean)
      {
        com.tencent.mm.game.report.api.a.fYF.c(paramString1, 2, paramInt, null, paramString2);
        AppMethodBeat.o(41429);
        return;
      }
      com.tencent.mm.game.report.api.a.fYF.c(paramString1, 4, paramInt, null, paramString2);
      AppMethodBeat.o(41429);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(41420);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41420);
      return;
    }
    tdA.put(paramString1, new b(paramString2, paramInt, paramString3, paramString4, paramString5));
    AppMethodBeat.o(41420);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(41414);
    synchronized (oFR)
    {
      oFR.remove(parama);
      ac.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(oFR.size()), parama });
      AppMethodBeat.o(41414);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41418);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41418);
      return;
    }
    paramString2 = new b(paramString2, paramInt, paramString3, "", paramString4);
    paramString2.tdE = true;
    tdA.put(paramString1, paramString2);
    AppMethodBeat.o(41418);
  }
  
  public static void bXA()
  {
    AppMethodBeat.i(41415);
    if (tdz == null) {
      tdz = new k();
    }
    com.tencent.mm.plugin.downloader.b.a.a(new a.b()
    {
      public final void K(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(41409);
        if (paramAnonymousInt == 9) {
          k.access$000(paramAnonymousLong);
        }
        AppMethodBeat.o(41409);
      }
    });
    f.bXJ();
    c.a(tdz);
    AppMethodBeat.o(41415);
  }
  
  public static void bXB()
  {
    AppMethodBeat.i(41416);
    f.bXJ();
    c.b(tdz);
    tdz = null;
    oFR.clear();
    tdA.clear();
    AppMethodBeat.o(41416);
  }
  
  public static k cQm()
  {
    AppMethodBeat.i(41412);
    if (tdz == null) {
      tdz = new k();
    }
    k localk = tdz;
    AppMethodBeat.o(41412);
    return localk;
  }
  
  private static void d(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41428);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    String str2;
    String str1;
    if (locala != null)
    {
      str2 = null;
      str1 = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.oFE) {
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
      str2 = com.tencent.mm.plugin.game.e.a.tu(localJSONObject.toString());
      str1 = str2;
      ac.d("MicroMsg.GameDownloadEventBus", "extInfo = " + localJSONObject.toString());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + localException.getMessage());
      }
    }
    a(locala.field_appId, paramInt, paramBoolean, str1);
    AppMethodBeat.o(41428);
  }
  
  public static void gN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41430);
    com.tencent.mm.game.report.api.a.fYF.c(paramString1, 6, 0, null, paramString2);
    AppMethodBeat.o(41430);
  }
  
  public static void o(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41419);
    if (bs.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41419);
      return;
    }
    tdA.put(paramString1, new b(paramString2, 1002, paramString3, "", paramString4));
    AppMethodBeat.o(41419);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41423);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi) && (!ax.isWifi(ai.getContext())))
    {
      ac.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      locala.field_status = 2;
      locala.field_errCode = 0;
      d.e(locala);
      b localb = new b();
      localb.k(locala);
      com.tencent.mm.plugin.downloader.f.a.a(13, localb);
      AppMethodBeat.o(41423);
      return;
    }
    M(paramLong, 5);
    d(paramLong, paramInt, paramBoolean);
    com.tencent.mm.plugin.game.c.a.report(paramLong);
    com.tencent.mm.plugin.downloader.model.a.rR(paramLong);
    AppMethodBeat.o(41423);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41422);
    ac.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(i.eA(paramString)) });
    if ((!bs.isNullOrNil(paramString)) && (i.eA(paramString)))
    {
      M(paramLong, 3);
      if (paramBoolean)
      {
        paramString = d.sc(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          com.tencent.mm.game.report.api.a.fYF.c(paramString, 5, 0, null, null);
        }
      }
      com.tencent.mm.plugin.game.c.a.report(paramLong);
      AppMethodBeat.o(41422);
      return;
    }
    paramString = d.sc(paramLong);
    if (paramString != null)
    {
      paramString.field_status = 4;
      paramString.field_errCode = com.tencent.mm.plugin.downloader.a.a.oFH;
      d.e(paramString);
    }
    a(paramLong, com.tencent.mm.plugin.downloader.a.a.oFH, paramBoolean);
    if (paramString != null) {
      com.tencent.mm.plugin.downloader.f.a.U(paramString.field_appId, 9L);
    }
    AppMethodBeat.o(41422);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(41427);
    M(paramLong, 7);
    AppMethodBeat.o(41427);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(41425);
    M(paramLong, 2);
    AppMethodBeat.o(41425);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(41424);
    M(paramLong, 4);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if (locala != null) {
      e.at(ai.getContext(), locala.field_appId);
    }
    AppMethodBeat.o(41424);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(41421);
    M(paramLong, 1);
    AppMethodBeat.o(41421);
  }
  
  public final void qN(long paramLong)
  {
    AppMethodBeat.i(41426);
    M(paramLong, 6);
    AppMethodBeat.o(41426);
  }
  
  public final void qO(long paramLong) {}
  
  public static abstract interface a
  {
    public abstract void e(int paramInt, String paramString, boolean paramBoolean);
  }
  
  static final class b
  {
    String appId = "";
    String dbZ = "";
    String md5 = "";
    int scene = 0;
    String tdD = "";
    boolean tdE = false;
    
    b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.md5 = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
      this.tdD = paramString3;
      this.dbZ = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */