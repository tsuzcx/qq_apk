package com.tencent.mm.plugin.game.model.silent_download;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kt;
import com.tencent.mm.autogen.a.kt.a;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class GameSilentDownloadListener$2
  extends IListener<kt>
{
  GameSilentDownloadListener$2(q paramq)
  {
    super(paramq);
    AppMethodBeat.i(275440);
    this.__eventId = kt.class.getName().hashCode();
    AppMethodBeat.o(275440);
  }
  
  private static boolean a(kt paramkt)
  {
    AppMethodBeat.i(41675);
    switch (paramkt.hMr.hAf)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(41675);
      return false;
      if (Util.secondsToNow(Util.nullAsNil((Long)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSD, Long.valueOf(0L)))) > 600L)
      {
        com.tencent.mm.kernel.h.baE().ban().set(at.a.acSD, Long.valueOf(Util.nowSecond()));
        h.a.fHh().ws(false);
        continue;
        paramkt = paramkt.hMr.appid;
        if (Util.isNullOrNil(paramkt))
        {
          Log.i("MicroMsg.GameSilentDownloadStorage", "deleteAllItem ret:%b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().execSQL("GameSilentDownload", String.format("delete from %s", new Object[] { "GameSilentDownload" }))) });
        }
        else
        {
          Object localObject = new d();
          ((d)localObject).field_appId = paramkt;
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCj().delete((IAutoDBItem)localObject, new String[0]);
          Log.i("MicroMsg.GameSilentDownloadListener", "delete silent download, appid:%s", new Object[] { paramkt });
          continue;
          paramkt = paramkt.hMr.appid;
          if (!Util.isNullOrNil(paramkt))
          {
            localObject = com.tencent.mm.plugin.downloader.model.d.amJ(paramkt);
            if (localObject != null)
            {
              long l = ((a)localObject).field_downloadId;
              com.tencent.mm.plugin.downloader.model.f.duv().kR(l);
              com.tencent.mm.plugin.downloader.model.d.lb(((a)localObject).field_downloadId);
              Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "delete downloadInfo in DB. appId:%s", new Object[] { paramkt });
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.silent_download.GameSilentDownloadListener.2
 * JD-Core Version:    0.7.0.1
 */