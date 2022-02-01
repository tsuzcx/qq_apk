package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static void cancelDownload(String paramString)
  {
    AppMethodBeat.i(41706);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41706);
      return;
    }
    d locald = new d();
    locald.field_appId = paramString;
    boolean bool = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().delete(locald, new String[0]);
    ac.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      paramString = com.tencent.mm.plugin.downloader.model.f.bXJ().WB(paramString);
      if ((paramString != null) && (paramString.id > 0L))
      {
        long l = paramString.id;
        com.tencent.mm.plugin.downloader.model.f.bXJ().rS(l);
        ac.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
      }
    }
    AppMethodBeat.o(41706);
  }
  
  public static void pauseDownload()
  {
    AppMethodBeat.i(41705);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().cRe();
    if (bs.gY((List)localObject1))
    {
      AppMethodBeat.o(41705);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((d)localObject2).field_expireTime <= bs.aNx())
        {
          ac.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((d)localObject2).field_appId });
          f.ahy(((d)localObject2).field_appId);
          cancelDownload(((d)localObject2).field_appId);
        }
        else
        {
          localObject2 = ((d)localObject2).field_appId;
          localObject2 = com.tencent.mm.plugin.downloader.model.f.bXJ().WB((String)localObject2);
          if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
          {
            boolean bool = b.rU(((FileDownloadTaskInfo)localObject2).id);
            ac.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(41705);
  }
  
  public final void mL(final boolean paramBoolean)
  {
    AppMethodBeat.i(199235);
    com.tencent.mm.plugin.game.commlib.c.a.cOB().a("game_silent_download", new com.tencent.mm.plugin.game.commlib.c.a.a()
    {
      public final void bXz()
      {
        AppMethodBeat.i(199231);
        h.this.mM(paramBoolean);
        AppMethodBeat.o(199231);
      }
    });
    AppMethodBeat.o(199235);
  }
  
  public final void mM(boolean paramBoolean)
  {
    AppMethodBeat.i(41704);
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo();
      localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
      if (localObject2 == null)
      {
        ac.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        ac.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
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
          ac.i("MicroMsg.GameSilentDownloadStorage", "no running task");
          ((Cursor)localObject2).close();
          localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(bs.aNx()) });
          if (localObject2 == null)
          {
            ac.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
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
            ac.i("MicroMsg.GameSilentDownloadStorage", "no record");
            localObject1 = null;
          }
        }
      }
      ac.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { ((d)localObject1).field_appId });
      if (((d)localObject1).field_expireTime > bs.aNx()) {
        break;
      }
      ac.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { ((d)localObject1).field_appId });
      f.ahy(((d)localObject1).field_appId);
      cancelDownload(((d)localObject1).field_appId);
      paramBoolean = false;
    }
    if (!ax.isWifi(ai.getContext()))
    {
      ac.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().ahA(((d)localObject1).field_appId);
    com.tencent.mm.kernel.g.agS();
    if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      ac.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().ahB(((d)localObject1).field_appId);
    if ((((d)localObject1).field_size > 0L) && (!com.tencent.mm.plugin.downloader.model.h.sm(((d)localObject1).field_size)) && (!com.tencent.mm.plugin.downloader.model.h.sl(((d)localObject1).field_size)))
    {
      ac.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().ahC(((d)localObject1).field_appId);
    ac.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      localObject2 = a.cRd();
      ac.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(((a.a)localObject2).mpg), Float.valueOf(((a.a)localObject2).tgT) });
      if ((!((a.a)localObject2).mpg) && (((a.a)localObject2).tgT < 0.2D))
      {
        ac.i("MicroMsg.GameSilentDownloader", "battery is low");
        AppMethodBeat.o(41704);
        return;
      }
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().ahD(((d)localObject1).field_appId);
    }
    for (;;)
    {
      com.tencent.mm.ci.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199233);
          com.tencent.mm.pluginsdk.model.app.h.ct(this.thc.field_appId, false);
          ap.f(new Runnable()
          {
            public final void run()
            {
              long l1 = 0L;
              AppMethodBeat.i(199232);
              Object localObject;
              String str;
              long l2;
              label81:
              int i;
              if (h.2.this.thc.field_isFirst)
              {
                localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo();
                str = h.2.this.thc.field_appId;
                if (bs.isNullOrNil(str))
                {
                  ac.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                  l2 = h.2.this.thc.field_randomTime;
                  if (l2 > 0L) {
                    break label358;
                  }
                  ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().av(h.2.this.thc.field_appId, l1);
                  if (bs.aNx() < l1) {
                    break label418;
                  }
                  i = 1;
                }
              }
              for (;;)
              {
                if (i != 0)
                {
                  localObject = h.this;
                  str = h.2.this.thc.field_appId;
                  ac.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
                  b.a locala = new b.a();
                  locala.funcId = 2819;
                  locala.reqCmdId = 0;
                  locala.respCmdId = 0;
                  locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                  com.tencent.mm.plugin.game.b.a.a locala1 = new com.tencent.mm.plugin.game.b.a.a();
                  locala1.sVo = 1;
                  locala1.hOf = str;
                  com.tencent.mm.plugin.downloader.g.a locala2 = com.tencent.mm.plugin.downloader.model.d.Ww(str);
                  if (locala2 != null)
                  {
                    locala1.sVp = locala2.field_downloadUrl;
                    locala1.sVq = locala2.field_downloadedSize;
                  }
                  locala.hvt = locala1;
                  locala.hvu = new com.tencent.mm.plugin.game.b.a.b();
                  x.a(locala.aAz(), new h.3((h)localObject, str));
                }
                AppMethodBeat.o(199232);
                return;
                ac.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((g)localObject).execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
                break;
                label358:
                i = bs.jk((int)l2, 0);
                ac.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = bs.aNx();
                l1 = i + l1;
                break label81;
                if (bs.aNx() >= h.2.this.thc.field_nextCheckTime) {
                  i = 1;
                } else {
                  label418:
                  i = 0;
                }
              }
            }
          });
          AppMethodBeat.o(199233);
        }
      });
      AppMethodBeat.o(41704);
      return;
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cOo().ahD(((d)localObject1).field_appId);
    }
  }
  
  public static final class a
  {
    private static h the;
    
    static
    {
      AppMethodBeat.i(41703);
      the = new h((byte)0);
      AppMethodBeat.o(41703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h
 * JD-Core Version:    0.7.0.1
 */