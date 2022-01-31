package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.c.a.1;
import com.tencent.mm.plugin.game.c.a.a;
import com.tencent.mm.protocal.c.bkn;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class k
  implements com.tencent.mm.plugin.downloader.model.k
{
  private static Set<a> iOA = Collections.synchronizedSet(new HashSet());
  private static k kOG = null;
  private static HashMap<String, k.b> kOH = new HashMap();
  
  public static void a(a parama)
  {
    synchronized (iOA)
    {
      iOA.add(parama);
      return;
    }
  }
  
  public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    int i;
    if (paramInt != 710)
    {
      i = paramInt;
      if (paramInt != 711) {}
    }
    else
    {
      i = com.tencent.mm.plugin.downloader.a.a.iOr;
    }
    y.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", new Object[] { paramString1, Integer.valueOf(i) });
    if (!paramBoolean)
    {
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYd();
      u.b(paramString1, 2, i, null, paramString2);
      return;
    }
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYd();
    u.b(paramString1, 4, i, null, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    paramString2 = new k.b(paramString2, paramInt, paramString3, "", paramString4);
    paramString2.kOL = true;
    kOH.put(paramString1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    kOH.put(paramString1, new k.b(paramString2, paramInt, paramString3, paramString4, paramString5));
  }
  
  public static void aFI()
  {
    if (kOG == null) {
      kOG = new k();
    }
    com.tencent.mm.plugin.downloader.b.a.a(new k.1());
    d.aFP();
    com.tencent.mm.plugin.downloader.model.b.a(kOG);
  }
  
  public static void aFJ()
  {
    d.aFP();
    com.tencent.mm.plugin.downloader.model.b.b(kOG);
    kOG = null;
    iOA.clear();
    kOH.clear();
  }
  
  public static k aZi()
  {
    if (kOG == null) {
      kOG = new k();
    }
    return kOG;
  }
  
  public static void b(a parama)
  {
    synchronized (iOA)
    {
      iOA.remove(parama);
      y.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", new Object[] { Integer.valueOf(iOA.size()), parama });
      return;
    }
  }
  
  public static void jdMethod_do(String paramString1, String paramString2)
  {
    ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYd();
    u.b(paramString1, 6, 0, null, paramString2);
  }
  
  private static void eO(long paramLong)
  {
    Object localObject = c.dk(paramLong);
    if (localObject == null)
    {
      y.i("MicroMsg.ReportDownloadAppState", "report, info is null");
      return;
    }
    if (!((com.tencent.mm.plugin.downloader.f.a)localObject).field_fromWeApp)
    {
      y.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
      return;
    }
    if ((((com.tencent.mm.plugin.downloader.f.a)localObject).field_status == 3) && (!e.bK(((com.tencent.mm.plugin.downloader.f.a)localObject).field_filePath)))
    {
      y.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
      return;
    }
    bkn localbkn = new bkn();
    localbkn.euK = ((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId;
    if (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status == 3) {
      localbkn.hQq = a.a.kMi;
    }
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).ecG = 2683;
      ((b.a)localObject).uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
      ((b.a)localObject).ecH = localbkn;
      ((b.a)localObject).ecI = new bko();
      ((b.a)localObject).ecJ = 0;
      ((b.a)localObject).ecK = 0;
      w.a(((b.a)localObject).Kt(), new a.1());
      return;
      if (((com.tencent.mm.plugin.downloader.f.a)localObject).field_status == 4) {
        localbkn.hQq = a.a.DOWNLOAD_STATUS_FAILED;
      }
    }
  }
  
  public static void l(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (bk.bl(paramString1)) {
      return;
    }
    kOH.put(paramString1, new k.b(paramString2, 1002, paramString3, "", paramString4));
  }
  
  private void v(long paramLong, int paramInt)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    k.b localb;
    int i;
    Object localObject;
    if (locala != null)
    {
      localb = (k.b)kOH.get(locala.field_downloadUrl);
      i = 0;
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.game.report.api.b.dCw.bu(locala.field_downloadId);
        if (localObject != null)
        {
          i = ((com.tencent.mm.game.report.api.a)localObject).dCv;
          y.i("MicroMsg.GameDownloadEventBus", "downloadReportInfo.opId: %d", new Object[] { Integer.valueOf(i) });
        }
        break;
      }
    }
    for (;;)
    {
      if (!bk.bl(locala.field_appId))
      {
        if (locala.field_finishTime <= 0L) {
          break label559;
        }
        paramLong = locala.field_finishTime;
        label144:
        com.tencent.mm.game.report.api.b.dCw.a(locala.field_appId, locala.field_scene, i, locala.field_startSize, locala.field_downloadedSize - locala.field_startSize, locala.field_totalSize, locala.field_downloadUrl, locala.field_errCode, locala.field_downloaderType, locala.field_channelId, (paramLong - locala.field_startTime) / 1000L, locala.field_startState, locala.field_downloadId, locala.field_extInfo);
        if ((locala.field_status == 2) || (locala.field_status == 5) || (locala.field_status == 4) || (locala.field_status == 3) || (locala.field_status == 0))
        {
          paramLong = locala.field_downloadId;
          y.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
          localObject = ae.getContext().getSharedPreferences("download_pref", 0);
          if (localObject != null) {
            ((SharedPreferences)localObject).edit().remove(String.valueOf(paramLong)).apply();
          }
        }
      }
      if (localb == null) {
        com.tencent.mm.game.report.api.b.dCw.a(locala.field_appId, locala.field_scene, i, locala.field_md5, locala.field_downloadUrl, "", locala.field_extInfo);
      }
      for (;;)
      {
        ai.d(new k.2(this, paramInt, locala.field_appId));
        return;
        int j = 1;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 0L);
        i = j;
        if (localb == null) {
          break;
        }
        if (localb.kOL)
        {
          com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 1L);
          i = j;
          break;
        }
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 2L);
        i = j;
        break;
        i = 7;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 4L);
        break;
        i = 6;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 3L);
        break;
        i = 2;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 5L);
        break;
        i = 3;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 6L);
        break;
        i = 8;
        com.tencent.mm.game.report.api.b.dCw.i(locala.field_appId, 7L);
        break;
        label559:
        paramLong = System.currentTimeMillis();
        break label144;
        com.tencent.mm.game.report.api.b.dCw.a(localb.appId, localb.scene, i, localb.bIW, locala.field_downloadUrl, localb.kOK, localb.bIm);
      }
    }
  }
  
  public final void b(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = c.dk(paramLong);
    if ((localObject != null) && (((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadInWifi) && (!aq.isWifi(ae.getContext())))
    {
      y.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_status = 2;
      ((com.tencent.mm.plugin.downloader.f.a)localObject).field_errCode = 0;
      c.d((com.tencent.mm.plugin.downloader.f.a)localObject);
      com.tencent.mm.game.report.api.b.dCw.a(((com.tencent.mm.plugin.downloader.f.a)localObject).field_appId, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_scene, 13, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadedSize - ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startSize, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_totalSize, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadUrl, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_errCode, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloaderType, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_channelId, (System.currentTimeMillis() - ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startTime) / 1000L, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_startState, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_downloadId, ((com.tencent.mm.plugin.downloader.f.a)localObject).field_extInfo);
      return;
    }
    v(paramLong, 5);
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    String str;
    if (locala != null)
    {
      str = null;
      localObject = null;
      if (paramInt == com.tencent.mm.plugin.downloader.a.a.iOp) {
        localObject = str;
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localObject = str;
      localJSONObject.put("ChannelId", locala.field_channelId);
      localObject = str;
      localJSONObject.put("DownloadSize", locala.field_downloadedSize);
      localObject = str;
      str = com.tencent.mm.plugin.game.e.a.fy(localJSONObject.toString());
      localObject = str;
      y.d("MicroMsg.GameDownloadEventBus", "extInfo = " + localJSONObject.toString());
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + localException.getMessage());
      }
    }
    a(locala.field_appId, paramInt, paramBoolean, (String)localObject);
    eO(paramLong);
  }
  
  public final void b(long paramLong, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", new Object[] { paramString, Boolean.valueOf(e.bK(paramString)) });
    if ((!bk.bl(paramString)) && (e.bK(paramString)))
    {
      v(paramLong, 3);
      if (paramBoolean)
      {
        paramString = c.dk(paramLong);
        if (paramString != null)
        {
          paramString = paramString.field_appId;
          ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYd();
          u.b(paramString, 5, 0, null, null);
        }
      }
      eO(paramLong);
    }
    do
    {
      return;
      c.j(paramLong, 4);
      b(paramLong, com.tencent.mm.plugin.downloader.a.a.iOs, paramBoolean);
      paramString = c.dk(paramLong);
    } while (paramString == null);
    com.tencent.mm.game.report.api.b.dCw.i(paramString.field_appId, 9L);
  }
  
  public final void cy(long paramLong)
  {
    v(paramLong, 6);
  }
  
  public final void cz(long paramLong) {}
  
  public final void k(long paramLong, String paramString)
  {
    v(paramLong, 7);
  }
  
  public final void onTaskPaused(long paramLong)
  {
    v(paramLong, 2);
  }
  
  public final void onTaskRemoved(long paramLong)
  {
    v(paramLong, 4);
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if (locala != null) {
      f.ak(ae.getContext(), locala.field_appId);
    }
  }
  
  public final void onTaskStarted(long paramLong, String paramString)
  {
    v(paramLong, 1);
  }
  
  public static abstract interface a
  {
    public abstract void f(int paramInt, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.k
 * JD-Core Version:    0.7.0.1
 */