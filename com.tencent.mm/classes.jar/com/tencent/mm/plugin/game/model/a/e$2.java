package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hc.a;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class e$2
  extends com.tencent.mm.sdk.b.c<hc>
{
  e$2()
  {
    AppMethodBeat.i(111511);
    this.__eventId = hc.class.getName().hashCode();
    AppMethodBeat.o(111511);
  }
  
  private static boolean a(hc paramhc)
  {
    AppMethodBeat.i(151888);
    switch (paramhc.cwd.coO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(151888);
      return false;
      if (bo.gz(bo.c((Long)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yHp, Long.valueOf(0L)))) > 300L)
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yHp, Long.valueOf(bo.aox()));
        h.a.bHb().ig(false);
        continue;
        paramhc = paramhc.cwd.cwc;
        if (bo.isNullOrNil(paramhc))
        {
          ab.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
        }
        else
        {
          Object localObject = new d();
          ((d)localObject).field_appId = paramhc;
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEU().delete((com.tencent.mm.sdk.e.c)localObject, new String[0]);
          ab.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramhc });
          continue;
          paramhc = paramhc.cwd.cwc;
          if (!bo.isNullOrNil(paramhc))
          {
            localObject = com.tencent.mm.plugin.downloader.model.d.JD(paramhc);
            if (localObject != null)
            {
              long l = ((a)localObject).field_downloadId;
              f.bjl().iz(l);
              com.tencent.mm.plugin.downloader.model.d.iK(((a)localObject).field_downloadId);
              ab.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramhc });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e.2
 * JD-Core Version:    0.7.0.1
 */