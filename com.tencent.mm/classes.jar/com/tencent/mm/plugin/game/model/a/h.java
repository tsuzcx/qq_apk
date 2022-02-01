package com.tencent.mm.plugin.game.model.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static void cancelDownload(String paramString)
  {
    AppMethodBeat.i(41706);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41706);
      return;
    }
    d locald = new d();
    locald.field_appId = paramString;
    boolean bool = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().delete(locald, new String[0]);
    ae.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      paramString = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ(paramString);
      if ((paramString != null) && (paramString.id > 0L))
      {
        long l = paramString.id;
        com.tencent.mm.plugin.downloader.model.f.cdA().ui(l);
        ae.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
      }
    }
    AppMethodBeat.o(41706);
  }
  
  public static void pauseDownload()
  {
    AppMethodBeat.i(41705);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().dcv();
    if (bu.ht((List)localObject1))
    {
      AppMethodBeat.o(41705);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((d)localObject2).field_expireTime <= bu.aRi())
        {
          ae.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((d)localObject2).field_appId });
          f.ana(((d)localObject2).field_appId);
          cancelDownload(((d)localObject2).field_appId);
        }
        else
        {
          localObject2 = ((d)localObject2).field_appId;
          localObject2 = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ((String)localObject2);
          if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
          {
            boolean bool = b.uk(((FileDownloadTaskInfo)localObject2).id);
            ae.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(41705);
  }
  
  public final void nj(final boolean paramBoolean)
  {
    AppMethodBeat.i(195664);
    com.tencent.mm.plugin.game.commlib.c.a.cZE().a("game_silent_download", new com.tencent.mm.plugin.game.commlib.c.a.a()
    {
      public final void cdr()
      {
        AppMethodBeat.i(195660);
        h.this.nk(paramBoolean);
        AppMethodBeat.o(195660);
      }
    });
    AppMethodBeat.o(195664);
  }
  
  public final void nk(boolean paramBoolean)
  {
    AppMethodBeat.i(41704);
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn();
      localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s=1 limit 1", new Object[] { "GameSilentDownload", "isRunning" }), new String[0]);
      if (localObject2 == null)
      {
        ae.i("MicroMsg.GameSilentDownloadStorage", "first cursor is null");
        localObject1 = null;
      }
      while (localObject1 == null)
      {
        ae.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
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
          ae.i("MicroMsg.GameSilentDownloadStorage", "no running task");
          ((Cursor)localObject2).close();
          localObject2 = ((g)localObject1).rawQuery(String.format("select * from %s where %s < ? limit 1", new Object[] { "GameSilentDownload", "nextCheckTime" }), new String[] { String.valueOf(bu.aRi()) });
          if (localObject2 == null)
          {
            ae.i("MicroMsg.GameSilentDownloadStorage", "second cursor is null");
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
            ae.i("MicroMsg.GameSilentDownloadStorage", "no record");
            localObject1 = null;
          }
        }
      }
      ae.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { ((d)localObject1).field_appId });
      if (((d)localObject1).field_expireTime > bu.aRi()) {
        break;
      }
      ae.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { ((d)localObject1).field_appId });
      f.ana(((d)localObject1).field_appId);
      cancelDownload(((d)localObject1).field_appId);
      paramBoolean = false;
    }
    if (!az.isWifi(ak.getContext()))
    {
      ae.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().anc(((d)localObject1).field_appId);
    com.tencent.mm.kernel.g.ajS();
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      ae.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().and(((d)localObject1).field_appId);
    if ((((d)localObject1).field_size > 0L) && (!com.tencent.mm.plugin.downloader.model.h.uB(((d)localObject1).field_size)) && (!com.tencent.mm.plugin.downloader.model.h.uA(((d)localObject1).field_size)))
    {
      ae.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      AppMethodBeat.o(41704);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().ane(((d)localObject1).field_appId);
    ae.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      localObject2 = a.dcu();
      ae.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(((a.a)localObject2).mUV), Float.valueOf(((a.a)localObject2).upR) });
      if ((!((a.a)localObject2).mUV) && (((a.a)localObject2).upR < 0.2D))
      {
        ae.i("MicroMsg.GameSilentDownloader", "battery is low");
        AppMethodBeat.o(41704);
        return;
      }
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().anf(((d)localObject1).field_appId);
    }
    for (;;)
    {
      com.tencent.mm.ch.a.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195662);
          com.tencent.mm.pluginsdk.model.app.h.cC(this.uqa.field_appId, false);
          ar.f(new Runnable()
          {
            public final void run()
            {
              long l1 = 0L;
              AppMethodBeat.i(195661);
              Object localObject;
              String str;
              long l2;
              label81:
              int i;
              if (h.2.this.uqa.field_isFirst)
              {
                localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn();
                str = h.2.this.uqa.field_appId;
                if (bu.isNullOrNil(str))
                {
                  ae.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
                  l2 = h.2.this.uqa.field_randomTime;
                  if (l2 > 0L) {
                    break label358;
                  }
                  ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().ay(h.2.this.uqa.field_appId, l1);
                  if (bu.aRi() < l1) {
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
                  str = h.2.this.uqa.field_appId;
                  ae.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
                  b.a locala = new b.a();
                  locala.funcId = 2819;
                  locala.hQH = 0;
                  locala.respCmdId = 0;
                  locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
                  com.tencent.mm.plugin.game.b.a.a locala1 = new com.tencent.mm.plugin.game.b.a.a();
                  locala1.ucK = 1;
                  locala1.ikm = str;
                  com.tencent.mm.plugin.downloader.g.a locala2 = com.tencent.mm.plugin.downloader.model.d.aaU(str);
                  if (locala2 != null)
                  {
                    locala1.ucL = locala2.field_downloadUrl;
                    locala1.ucM = locala2.field_downloadedSize;
                  }
                  locala.hQF = locala1;
                  locala.hQG = new com.tencent.mm.plugin.game.b.a.b();
                  x.a(locala.aDS(), new h.3((h)localObject, str));
                }
                AppMethodBeat.o(195661);
                return;
                ae.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((g)localObject).execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
                break;
                label358:
                i = bu.jA((int)l2, 0);
                ae.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
                l1 = bu.aRi();
                l1 = i + l1;
                break label81;
                if (bu.aRi() >= h.2.this.uqa.field_nextCheckTime) {
                  i = 1;
                } else {
                  label418:
                  i = 0;
                }
              }
            }
          });
          AppMethodBeat.o(195662);
        }
      });
      AppMethodBeat.o(41704);
      return;
      ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZn().anf(((d)localObject1).field_appId);
    }
  }
  
  public static final class a
  {
    private static h uqc;
    
    static
    {
      AppMethodBeat.i(41703);
      uqc = new h((byte)0);
      AppMethodBeat.o(41703);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h
 * JD-Core Version:    0.7.0.1
 */