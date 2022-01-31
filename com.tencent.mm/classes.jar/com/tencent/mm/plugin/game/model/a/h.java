package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.List;

public final class h
{
  static void cancelDownload(String paramString)
  {
    AppMethodBeat.i(111541);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111541);
      return;
    }
    d locald = new d();
    locald.field_appId = paramString;
    boolean bool = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().delete(locald, new String[0]);
    ab.i("MicroMsg.GameSilentDownloader", "remove SilentDownload DB, appid:%s, ret:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (bool)
    {
      paramString = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
      if ((paramString != null) && (paramString.id > 0L))
      {
        long l = paramString.id;
        com.tencent.mm.plugin.downloader.model.f.bjl().iz(l);
        ab.i("MicroMsg.GameSilentDownloader", "remove download task, appid:%s", new Object[] { paramString.appId });
      }
    }
    AppMethodBeat.o(111541);
  }
  
  public static void pauseDownload()
  {
    AppMethodBeat.i(111540);
    Object localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().bHa();
    if (bo.es((List)localObject1))
    {
      AppMethodBeat.o(111540);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (d)((Iterator)localObject1).next();
      if (localObject2 != null) {
        if (((d)localObject2).field_expireTime <= bo.aox())
        {
          ab.i("MicroMsg.GameSilentDownloader", "pauseDownload, task expire time, appId:%s", new Object[] { ((d)localObject2).field_appId });
          f.Qh(((d)localObject2).field_appId);
          cancelDownload(((d)localObject2).field_appId);
        }
        else
        {
          localObject2 = ((d)localObject2).field_appId;
          localObject2 = com.tencent.mm.plugin.downloader.model.f.bjl().JH((String)localObject2);
          if ((localObject2 != null) && (((FileDownloadTaskInfo)localObject2).id > 0L) && (((FileDownloadTaskInfo)localObject2).status == 1))
          {
            boolean bool = b.iB(((FileDownloadTaskInfo)localObject2).id);
            ab.i("MicroMsg.GameSilentDownloader", "pauseDownload, appid:%s, ret:%b", new Object[] { ((FileDownloadTaskInfo)localObject2).appId, Boolean.valueOf(bool) });
          }
        }
      }
    }
    AppMethodBeat.o(111540);
  }
  
  public final void ig(boolean paramBoolean)
  {
    AppMethodBeat.i(111539);
    d locald;
    for (;;)
    {
      locald = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().bGZ();
      if (locald == null)
      {
        ab.i("MicroMsg.GameSilentDownloader", "silentDownload witch can check is empty!");
        AppMethodBeat.o(111539);
        return;
      }
      ab.i("MicroMsg.GameSilentDownloader", "[appid:%s] in DB to check download", new Object[] { locald.field_appId });
      if (locald.field_expireTime > bo.aox()) {
        break;
      }
      ab.i("MicroMsg.GameSilentDownloader", "task expire time, appId:%s", new Object[] { locald.field_appId });
      f.Qh(locald.field_appId);
      cancelDownload(locald.field_appId);
      paramBoolean = false;
    }
    if (!at.isWifi(ah.getContext()))
    {
      ab.i("MicroMsg.GameSilentDownloader", "NetType is not WIFI");
      AppMethodBeat.o(111539);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().Qj(locald.field_appId);
    com.tencent.mm.kernel.g.RM();
    if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
    {
      ab.i("MicroMsg.GameSilentDownloader", "sdcard isnt available");
      AppMethodBeat.o(111539);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().Qk(locald.field_appId);
    if ((locald.field_size > 0L) && (!com.tencent.mm.compatible.util.f.gc(locald.field_size)) && (!com.tencent.mm.plugin.downloader.model.h.iS(locald.field_size)))
    {
      ab.i("MicroMsg.GameSilentDownloader", "sdcard dont have enough space");
      AppMethodBeat.o(111539);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().Ql(locald.field_appId);
    ab.i("MicroMsg.GameSilentDownloader", "fromBattery：%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      a.a locala = a.bGY();
      ab.i("MicroMsg.GameSilentDownloader", "battery isCharging:%b  percent:%f", new Object[] { Boolean.valueOf(locala.iYt), Float.valueOf(locala.npG) });
      if ((!locala.iYt) && (locala.npG < 0.2D))
      {
        ab.i("MicroMsg.GameSilentDownloader", "battery is low");
        AppMethodBeat.o(111539);
        return;
      }
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().Qm(locald.field_appId);
    }
    for (;;)
    {
      com.tencent.mm.ch.a.post(new h.1(this, locald));
      AppMethodBeat.o(111539);
      return;
      ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().Qm(locald.field_appId);
    }
  }
  
  public static final class a
  {
    private static h npP;
    
    static
    {
      AppMethodBeat.i(111538);
      npP = new h((byte)0);
      AppMethodBeat.o(111538);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h
 * JD-Core Version:    0.7.0.1
 */