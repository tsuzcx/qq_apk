package com.tencent.mm.plugin.game.model.silent_download;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.am.z.a;
import com.tencent.mm.plugin.downloader.b.b.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static void cancelDownload(String paramString)
  {
    AppMethodBeat.i(41706);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41706);
      return;
    }
    d locald = new d();
    locald.field_appId = paramString;
    boolean bool = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().delete(locald, new String[0]);
    Log.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      paramString = com.tencent.mm.plugin.downloader.model.f.duv().amO(paramString);
      if ((paramString != null) && (paramString.id > 0L))
      {
        long l = paramString.id;
        com.tencent.mm.plugin.downloader.model.f.duv().kR(l);
        Log.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
      }
    }
    AppMethodBeat.o(41706);
  }
  
  public static void pauseDownload()
  {
    AppMethodBeat.i(41705);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().fHg();
    if (Util.isNullOrNil((List)localObject1))
    {
      AppMethodBeat.o(41705);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((d)localObject2).field_expireTime <= Util.nowSecond())
        {
          Log.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((d)localObject2).field_appId });
          f.aGT(((d)localObject2).field_appId);
          cancelDownload(((d)localObject2).field_appId);
        }
        else
        {
          localObject2 = ((d)localObject2).field_appId;
          localObject2 = com.tencent.mm.plugin.downloader.model.f.duv().amO((String)localObject2);
          if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
          {
            boolean bool = b.kT(((FileDownloadTaskInfo)localObject2).id);
            Log.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(41705);
  }
  
  public final void ws(final boolean paramBoolean)
  {
    AppMethodBeat.i(275446);
    com.tencent.mm.plugin.game.commlib.c.a.fEf().a("game_silent_download", new com.tencent.mm.plugin.game.commlib.c.a.a()
    {
      public final void dun()
      {
        AppMethodBeat.i(275439);
        h.this.wt(paramBoolean);
        AppMethodBeat.o(275439);
      }
    });
    AppMethodBeat.o(275446);
  }
  
  public final void wt(boolean paramBoolean)
  {
    AppMethodBeat.i(41704);
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj();
      localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
      if (localObject2 == null)
      {
        Log.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        Log.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
        AppMethodBeat.o(41704);
        return;
        if (((Cursor)localObject2).moveToFirst())
        {
          localObject1 = new d();
          ((d)localObject1).convertFrom((Cursor)localObject2);
          ((Cursor)localObject2).close();
        }
        else
        {
          Log.i("MicroMsg.GameSilentDownloadStorage", "no running task");
          ((Cursor)localObject2).close();
          localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(Util.nowSecond()) });
          if (localObject2 == null)
          {
            Log.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
            localObject1 = null;
          }
          else if (((Cursor)localObject2).moveToFirst())
          {
            localObject1 = new d();
            ((d)localObject1).convertFrom((Cursor)localObject2);
            ((Cursor)localObject2).close();
          }
          else
          {
            ((Cursor)localObject2).close();
            Log.i("MicroMsg.GameSilentDownloadStorage", "no record");
            localObject1 = null;
          }
        }
      }
      Log.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { ((d)localObject1).field_appId });
      if (((d)localObject1).field_expireTime > Util.nowSecond()) {
        break;
      }
      Log.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { ((d)localObject1).field_appId });
      f.aGT(((d)localObject1).field_appId);
      cancelDownload(((d)localObject1).field_appId);
      paramBoolean = false;
    }
    if (!NetStatusUtil.isWifi(MMApplicationContext.getContext()))
    {
      Log.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      com.tencent.mm.game.report.api.a.mtH.a(12, ((d)localObject1).field_appId, "not_wifi", 0L);
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aGV(((d)localObject1).field_appId);
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      Log.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      com.tencent.mm.game.report.api.a.mtH.a(12, ((d)localObject1).field_appId, "sdcard_not_available", 0L);
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aGW(((d)localObject1).field_appId);
    if ((((d)localObject1).field_size > 0L) && (!com.tencent.mm.plugin.downloader.model.h.lj(((d)localObject1).field_size)) && (!com.tencent.mm.plugin.downloader.model.h.li(((d)localObject1).field_size)))
    {
      Log.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      com.tencent.mm.game.report.api.a.mtH.a(12, ((d)localObject1).field_appId, "space_not_enough", 0L);
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aGX(((d)localObject1).field_appId);
    Log.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      localObject2 = a.fHf();
      Log.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(((a.a)localObject2).use), Float.valueOf(((a.a)localObject2).agH) });
      if ((!((a.a)localObject2).use) && (((a.a)localObject2).agH < 0.2D))
      {
        Log.i("MicroMsg.GameSilentDownloader", "battery is low");
        com.tencent.mm.game.report.api.a.mtH.a(12, ((d)localObject1).field_appId, "battery_is_low", 0L);
        AppMethodBeat.o(41704);
        return;
      }
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aGY(((d)localObject1).field_appId);
    }
    for (;;)
    {
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275438);
          com.tencent.mm.pluginsdk.model.app.h.dV(this.IGC.field_appId, false);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(275437);
              Object localObject;
              String str;
              long l;
              label79:
              int i;
              if (h.2.this.IGC.field_isFirst)
              {
                localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj();
                str = h.2.this.IGC.field_appId;
                if (Util.isNullOrNil(str))
                {
                  Log.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                  l = h.2.this.IGC.field_randomTime;
                  if (l > 0L) {
                    break label356;
                  }
                  l = 0L;
                  ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aJ(h.2.this.IGC.field_appId, l);
                  if (Util.nowSecond() < l) {
                    break label442;
                  }
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0)
                {
                  localObject = h.this;
                  str = h.2.this.IGC.field_appId;
                  Log.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
                  c.a locala = new c.a();
                  locala.funcId = 2819;
                  locala.otG = 0;
                  locala.respCmdId = 0;
                  locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                  com.tencent.mm.plugin.game.autogen.a.a locala1 = new com.tencent.mm.plugin.game.autogen.a.a();
                  locala1.IcB = 1;
                  locala1.oOI = str;
                  com.tencent.mm.plugin.downloader.f.a locala2 = com.tencent.mm.plugin.downloader.model.d.amJ(str);
                  if (locala2 != null)
                  {
                    locala1.IcC = locala2.field_downloadUrl;
                    locala1.IcD = locala2.field_downloadedSize;
                  }
                  locala.otE = locala1;
                  locala.otF = new com.tencent.mm.plugin.game.autogen.a.b();
                  z.a(locala.bEF(), new h.3((h)localObject, str));
                  AppMethodBeat.o(275437);
                  return;
                  Log.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((g)localObject).execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
                  break;
                  label356:
                  i = Util.getIntRandom((int)l, 0);
                  Log.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                  l = Util.nowSecond();
                  l = i + l;
                  break label79;
                  if (Util.nowSecond() < h.2.this.IGC.field_nextCheckTime) {
                    break label442;
                  }
                  i = 1;
                  continue;
                }
                com.tencent.mm.game.report.api.a.mtH.a(12, h.2.this.IGC.field_appId, "random_time", 0L);
                AppMethodBeat.o(275437);
                return;
                label442:
                i = 0;
              }
            }
          });
          AppMethodBeat.o(275438);
        }
      });
      AppMethodBeat.o(41704);
      return;
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().aGY(((d)localObject1).field_appId);
    }
  }
  
  public static final class a
  {
    private static h IGE;
    
    static
    {
      AppMethodBeat.i(41703);
      IGE = new h((byte)0);
      AppMethodBeat.o(41703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.silent_download.h
 * JD-Core Version:    0.7.0.1
 */