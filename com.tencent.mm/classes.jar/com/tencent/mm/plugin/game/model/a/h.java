package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x;
import com.tencent.mm.al.x.a;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static void cancelDownload(String paramString)
  {
    AppMethodBeat.i(41706);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41706);
      return;
    }
    d locald = new d();
    locald.field_appId = paramString;
    boolean bool = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().delete(locald, new String[0]);
    ad.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      paramString = com.tencent.mm.plugin.downloader.model.f.bQt().Sp(paramString);
      if ((paramString != null) && (paramString.id > 0L))
      {
        long l = paramString.id;
        com.tencent.mm.plugin.downloader.model.f.bQt().og(l);
        ad.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
      }
    }
    AppMethodBeat.o(41706);
  }
  
  public static void pauseDownload()
  {
    AppMethodBeat.i(41705);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().cDU();
    if (bt.gL((List)localObject1))
    {
      AppMethodBeat.o(41705);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((d)localObject2).field_expireTime <= bt.aGK())
        {
          ad.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((d)localObject2).field_appId });
          f.acG(((d)localObject2).field_appId);
          cancelDownload(((d)localObject2).field_appId);
        }
        else
        {
          localObject2 = ((d)localObject2).field_appId;
          localObject2 = com.tencent.mm.plugin.downloader.model.f.bQt().Sp((String)localObject2);
          if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
          {
            boolean bool = b.oi(((FileDownloadTaskInfo)localObject2).id);
            ad.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(41705);
  }
  
  public final void lS(final boolean paramBoolean)
  {
    AppMethodBeat.i(196764);
    com.tencent.mm.plugin.game.commlib.c.a.cBs().a("game_silent_download", new com.tencent.mm.plugin.game.commlib.c.a.a()
    {
      public final void bQi()
      {
        AppMethodBeat.i(196760);
        h.this.lT(paramBoolean);
        AppMethodBeat.o(196760);
      }
    });
    AppMethodBeat.o(196764);
  }
  
  public final void lT(boolean paramBoolean)
  {
    AppMethodBeat.i(41704);
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf();
      localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
      if (localObject2 == null)
      {
        ad.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        ad.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
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
          ad.i("MicroMsg.GameSilentDownloadStorage", "no running task");
          ((Cursor)localObject2).close();
          localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(bt.aGK()) });
          if (localObject2 == null)
          {
            ad.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
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
            ad.i("MicroMsg.GameSilentDownloadStorage", "no record");
            localObject1 = null;
          }
        }
      }
      ad.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { ((d)localObject1).field_appId });
      if (((d)localObject1).field_expireTime > bt.aGK()) {
        break;
      }
      ad.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { ((d)localObject1).field_appId });
      f.acG(((d)localObject1).field_appId);
      cancelDownload(((d)localObject1).field_appId);
      paramBoolean = false;
    }
    if (!ay.isWifi(aj.getContext()))
    {
      ad.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().acI(((d)localObject1).field_appId);
    com.tencent.mm.kernel.g.afC();
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      ad.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().acJ(((d)localObject1).field_appId);
    if ((((d)localObject1).field_size > 0L) && (!com.tencent.mm.plugin.downloader.model.h.oA(((d)localObject1).field_size)) && (!com.tencent.mm.plugin.downloader.model.h.oz(((d)localObject1).field_size)))
    {
      ad.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().acK(((d)localObject1).field_appId);
    ad.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      localObject2 = a.cDT();
      ad.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(((a.a)localObject2).lNg), Float.valueOf(((a.a)localObject2).rZb) });
      if ((!((a.a)localObject2).lNg) && (((a.a)localObject2).rZb < 0.2D))
      {
        ad.i("MicroMsg.GameSilentDownloader", "battery is low");
        AppMethodBeat.o(41704);
        return;
      }
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().acL(((d)localObject1).field_appId);
    }
    for (;;)
    {
      com.tencent.mm.cj.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(196762);
          com.tencent.mm.pluginsdk.model.app.h.cn(this.rZj.field_appId, false);
          aq.f(new Runnable()
          {
            public final void run()
            {
              long l1 = 0L;
              AppMethodBeat.i(196761);
              Object localObject;
              String str;
              long l2;
              label81:
              int i;
              if (h.2.this.rZj.field_isFirst)
              {
                localObject = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf();
                str = h.2.this.rZj.field_appId;
                if (bt.isNullOrNil(str))
                {
                  ad.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                  l2 = h.2.this.rZj.field_randomTime;
                  if (l2 > 0L) {
                    break label358;
                  }
                  ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().at(h.2.this.rZj.field_appId, l1);
                  if (bt.aGK() < l1) {
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
                  str = h.2.this.rZj.field_appId;
                  ad.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
                  b.a locala = new b.a();
                  locala.funcId = 2819;
                  locala.reqCmdId = 0;
                  locala.respCmdId = 0;
                  locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                  com.tencent.mm.plugin.game.b.a.a locala1 = new com.tencent.mm.plugin.game.b.a.a();
                  locala1.rNz = 1;
                  locala1.hnC = str;
                  com.tencent.mm.plugin.downloader.g.a locala2 = com.tencent.mm.plugin.downloader.model.d.Sk(str);
                  if (locala2 != null)
                  {
                    locala1.rNA = locala2.field_downloadUrl;
                    locala1.rNB = locala2.field_downloadedSize;
                  }
                  locala.gUU = locala1;
                  locala.gUV = new com.tencent.mm.plugin.game.b.a.b();
                  x.a(locala.atI(), new h.3((h)localObject, str));
                }
                AppMethodBeat.o(196761);
                return;
                ad.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((g)localObject).execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
                break;
                label358:
                i = bt.iX((int)l2, 0);
                ad.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = bt.aGK();
                l1 = i + l1;
                break label81;
                if (bt.aGK() >= h.2.this.rZj.field_nextCheckTime) {
                  i = 1;
                } else {
                  label418:
                  i = 0;
                }
              }
            }
          });
          AppMethodBeat.o(196762);
        }
      });
      AppMethodBeat.o(41704);
      return;
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBf().acL(((d)localObject1).field_appId);
    }
  }
  
  public static final class a
  {
    private static h rZl;
    
    static
    {
      AppMethodBeat.i(41703);
      rZl = new h((byte)0);
      AppMethodBeat.o(41703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h
 * JD-Core Version:    0.7.0.1
 */