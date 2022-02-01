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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static Set<a> ocs;
  private static k rVH;
  private static HashMap<String, b> rVI;
  
  static
  {
    AppMethodBeat.i(41432);
    rVH = null;
    ocs = Collections.synchronizedSet(new HashSet());
    rVI = new HashMap();
    AppMethodBeat.o(41432);
  }
  
  private void J(long paramLong, final int paramInt)
  {
    AppMethodBeat.i(41417);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    b localb;
    int i;
    if (locala != null)
    {
      localb = (b)rVI.get(locala.field_downloadUrl);
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
          ad.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
          localObject = aj.getContext().getSharedPreferences("download_pref", 0);
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
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41410);
          synchronized (k.bQl())
          {
            Iterator localIterator = k.bQl().iterator();
            if (localIterator.hasNext()) {
              ((k.a)localIterator.next()).e(paramInt, this.cug, this.rVJ);
            }
          }
          AppMethodBeat.o(41410);
        }
      });
      AppMethodBeat.o(41417);
      return;
      int j = 1;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 0L);
      i = j;
      if (localb == null) {
        break;
      }
      if (localb.rVM)
      {
        com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 1L);
        i = j;
        break;
      }
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 2L);
      i = j;
      break;
      i = 7;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 4L);
      break;
      i = 6;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 3L);
      break;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 5L);
      i = 2;
      break;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 6L);
      i = 3;
      break;
      i = 8;
      com.tencent.mm.plugin.downloader.f.a.T(locala.field_appId, 7L);
      break;
      com.tencent.mm.plugin.downloader.f.a.a(localb.appId, localb.scene, i, localb.md5, locala.field_downloadUrl, localb.rVL, localb.deE);
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(41413);
    synchronized (ocs)
    {
      ocs.add(parama);
      AppMethodBeat.o(41413);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(41429);
    if ((paramInt == 710) || (paramInt == 711)) {
      paramInt = com.tencent.mm.plugin.downloader.a.a.och;
    }
    for (;;)
    {
      ad.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(paramInt) });
      if (!paramBoolean)
      {
        com.tencent.mm.game.report.api.a.fUK.c(paramString1, 2, paramInt, null, paramString2);
        AppMethodBeat.o(41429);
        return;
      }
      com.tencent.mm.game.report.api.a.fUK.c(paramString1, 4, paramInt, null, paramString2);
      AppMethodBeat.o(41429);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(41420);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41420);
      return;
    }
    rVI.put(paramString1, new b(paramString2, paramInt, paramString3, paramString4, paramString5));
    AppMethodBeat.o(41420);
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(41414);
    synchronized (ocs)
    {
      ocs.remove(parama);
      ad.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(ocs.size()), parama });
      AppMethodBeat.o(41414);
      return;
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41418);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41418);
      return;
    }
    paramString2 = new b(paramString2, paramInt, paramString3, "", paramString4);
    paramString2.rVM = true;
    rVI.put(paramString1, paramString2);
    AppMethodBeat.o(41418);
  }
  
  public static void bQj()
  {
    AppMethodBeat.i(41415);
    if (rVH == null) {
      rVH = new k();
    }
    com.tencent.mm.plugin.downloader.b.a.a(new a.b()
    {
      public final void L(int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(41409);
        if (paramAnonymousInt == 9) {
          k.access$000(paramAnonymousLong);
        }
        AppMethodBeat.o(41409);
      }
    });
    f.bQt();
    c.a(rVH);
    AppMethodBeat.o(41415);
  }
  
  public static void bQk()
  {
    AppMethodBeat.i(41416);
    f.bQt();
    c.b(rVH);
    rVH = null;
    ocs.clear();
    rVI.clear();
    AppMethodBeat.o(41416);
  }
  
  public static k cDc()
  {
    AppMethodBeat.i(41412);
    if (rVH == null) {
      rVH = new k();
    }
    k localk = rVH;
    AppMethodBeat.o(41412);
    return localk;
  }
  
  private static void d(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41428);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    String str2;
    String str1;
    if (locala != null)
    {
      str2 = null;
      str1 = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.ocf) {
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
      str2 = com.tencent.mm.plugin.game.e.a.qh(localJSONObject.toString());
      str1 = str2;
      ad.d("MicroMsg.GameDownloadEventBus", "extInfo = " + localJSONObject.toString());
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + localException.getMessage());
      }
    }
    a(locala.field_appId, paramInt, paramBoolean, str1);
    AppMethodBeat.o(41428);
  }
  
  public static void gw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41430);
    com.tencent.mm.game.report.api.a.fUK.c(paramString1, 6, 0, null, paramString2);
    AppMethodBeat.o(41430);
  }
  
  public static void m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(41419);
    if (bt.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(41419);
      return;
    }
    rVI.put(paramString1, new b(paramString2, 1002, paramString3, "", paramString4));
    AppMethodBeat.o(41419);
  }
  
  public final void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(41423);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi) && (!ay.isWifi(aj.getContext())))
    {
      ad.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      locala.field_status = 2;
      locala.field_errCode = 0;
      d.e(locala);
      b localb = new b();
      localb.k(locala);
      com.tencent.mm.plugin.downloader.f.a.a(13, localb);
      AppMethodBeat.o(41423);
      return;
    }
    J(paramLong, 5);
    d(paramLong, paramInt, paramBoolean);
    com.tencent.mm.plugin.game.c.a.report(paramLong);
    com.tencent.mm.plugin.downloader.model.a.of(paramLong);
    AppMethodBeat.o(41423);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(41422);
    ad.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(i.eK(paramString)) });
    if ((!bt.isNullOrNil(paramString)) && (i.eK(paramString)))
    {
      J(paramLong, 3);
      if (paramBoolean)
      {
        paramString = d.oq(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          com.tencent.mm.game.report.api.a.fUK.c(paramString, 5, 0, null, null);
        }
      }
      com.tencent.mm.plugin.game.c.a.report(paramLong);
      AppMethodBeat.o(41422);
      return;
    }
    paramString = d.oq(paramLong);
    if (paramString != null)
    {
      paramString.field_status = 4;
      paramString.field_errCode = com.tencent.mm.plugin.downloader.a.a.oci;
      d.e(paramString);
    }
    a(paramLong, com.tencent.mm.plugin.downloader.a.a.oci, paramBoolean);
    if (paramString != null) {
      com.tencent.mm.plugin.downloader.f.a.T(paramString.field_appId, 9L);
    }
    AppMethodBeat.o(41422);
  }
  
  public final void j(long paramLong, String paramString)
  {
    AppMethodBeat.i(41427);
    J(paramLong, 7);
    AppMethodBeat.o(41427);
  }
  
  public final void mZ(long paramLong)
  {
    AppMethodBeat.i(41426);
    J(paramLong, 6);
    AppMethodBeat.o(41426);
  }
  
  public final void na(long paramLong) {}
  
  public final void onTaskPaused(long paramLong)
  {
    AppMethodBeat.i(41425);
    J(paramLong, 2);
    AppMethodBeat.o(41425);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    AppMethodBeat.i(41424);
    J(paramLong, 4);
    com.tencent.mm.plugin.downloader.g.a locala = d.oq(paramLong);
    if (locala != null) {
      e.as(aj.getContext(), locala.field_appId);
    }
    AppMethodBeat.o(41424);
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    AppMethodBeat.i(41421);
    J(paramLong, 1);
    AppMethodBeat.o(41421);
  }
  
  public static abstract interface a
  {
    public abstract void e(int paramInt, String paramString, boolean paramBoolean);
  }
  
  static final class b
  {
    String appId = "";
    String deE = "";
    String md5 = "";
    String rVL = "";
    boolean rVM = false;
    int scene = 0;
    
    b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
    {
      this.md5 = paramString1;
      this.scene = paramInt;
      this.appId = paramString2;
      this.rVL = paramString3;
      this.deE = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */