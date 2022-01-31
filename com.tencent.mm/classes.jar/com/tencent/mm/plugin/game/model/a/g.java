package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  static void cancelDownload(String paramString)
  {
    if (bk.bl(paramString)) {}
    do
    {
      boolean bool;
      do
      {
        return;
        c localc = new c();
        localc.field_appId = paramString;
        bool = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().a(localc, new String[0]);
        y.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      } while (!bool);
      paramString = d.aFP().zL(paramString);
    } while ((paramString == null) || (paramString.id <= 0L));
    long l = paramString.id;
    d.aFP().dc(l);
    y.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
  }
  
  public static void pauseDownload()
  {
    Object localObject2 = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().rawQuery(String.format("select * from %s", new Object[] { "GameSilentDownload" }), new String[0]);
    Object localObject1;
    if (localObject2 == null)
    {
      y.i("MicroMsg.GameSilentDownloadStorage", "cursor is null");
      localObject1 = null;
      if (!bk.dk((List)localObject1)) {
        break label163;
      }
    }
    for (;;)
    {
      return;
      if (((Cursor)localObject2).moveToFirst())
      {
        localObject1 = new ArrayList();
        do
        {
          c localc = new c();
          localc.d((Cursor)localObject2);
          ((List)localObject1).add(localc);
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
        y.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
        break;
      }
      ((Cursor)localObject2).close();
      y.i("MicroMsg.GameSilentDownloadStorage", "getDownloadInfoList no record");
      localObject1 = null;
      break;
      label163:
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        if (localObject2 != null) {
          if (((c)localObject2).field_expireTime <= bk.UX())
          {
            y.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((c)localObject2).field_appId });
            e.EP(((c)localObject2).field_appId);
            cancelDownload(((c)localObject2).field_appId);
          }
          else
          {
            localObject2 = ((c)localObject2).field_appId;
            localObject2 = d.aFP().zL((String)localObject2);
            if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
            {
              long l = ((FileDownloadTaskInfo)localObject2).id;
              d.aFP().iPp = true;
              boolean bool = d.aFP().de(l);
              y.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
            }
          }
        }
      }
    }
  }
  
  public final void gx(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh();
      localObject2 = ((f)localObject1).rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
      if (localObject2 == null)
      {
        y.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        y.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
        return;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new c();
          ((c)localObject1).d((Cursor)localObject2);
          ((Cursor)localObject2).close();
        }
        else
        {
          y.i("MicroMsg.GameSilentDownloadStorage", "no running task");
          ((Cursor)localObject2).close();
          localObject2 = ((f)localObject1).rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(bk.UX()) });
          if (localObject2 == null)
          {
            y.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
            localObject1 = null;
          }
          else if (((Cursor)localObject2).moveToFirst())
          {
            localObject1 = new c();
            ((c)localObject1).d((Cursor)localObject2);
            ((Cursor)localObject2).close();
          }
          else
          {
            ((Cursor)localObject2).close();
            y.i("MicroMsg.GameSilentDownloadStorage", "no record");
            localObject1 = null;
          }
        }
      }
      y.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { ((c)localObject1).field_appId });
      if (((c)localObject1).field_expireTime > bk.UX()) {
        break;
      }
      y.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { ((c)localObject1).field_appId });
      e.EP(((c)localObject1).field_appId);
      cancelDownload(((c)localObject1).field_appId);
      paramBoolean = false;
    }
    if (!aq.isWifi(ae.getContext()))
    {
      y.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      return;
    }
    ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().ER(((c)localObject1).field_appId);
    com.tencent.mm.kernel.g.DQ();
    if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
    {
      y.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      return;
    }
    ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().ES(((c)localObject1).field_appId);
    if ((((c)localObject1).field_size > 0L) && (!com.tencent.mm.compatible.util.f.bs(((c)localObject1).field_size)))
    {
      y.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      return;
    }
    ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().ET(((c)localObject1).field_appId);
    y.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      localObject2 = a.aZS();
      y.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(((a.a)localObject2).hlS), Float.valueOf(((a.a)localObject2).kFN) });
      if ((!((a.a)localObject2).hlS) && (((a.a)localObject2).kFN < 0.2D))
      {
        y.i("MicroMsg.GameSilentDownloader", "battery is low");
        return;
      }
      ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().EU(((c)localObject1).field_appId);
    }
    for (;;)
    {
      com.tencent.mm.cg.a.post(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.bx(this.kRJ.field_appId, false);
          if (com.tencent.mm.pluginsdk.model.app.g.a(ae.getContext(), localf))
          {
            y.i("MicroMsg.GameSilentDownloader", "app is installed, appid = %s", new Object[] { this.kRJ.field_appId });
            e.C(this.kRJ.field_appId, 4, 0);
            ai.d(new Runnable()
            {
              public final void run()
              {
                g.cancelDownload(g.1.this.kRJ.field_appId);
                g.this.gx(false);
              }
            });
            return;
          }
          ai.d(new g.1.2(this));
        }
      });
      return;
      ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().EU(((c)localObject1).field_appId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.g
 * JD-Core Version:    0.7.0.1
 */