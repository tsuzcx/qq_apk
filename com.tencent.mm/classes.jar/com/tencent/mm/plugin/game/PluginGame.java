package com.tencent.mm.plugin.game;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.br.c.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.api.j;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.media.p;
import com.tencent.mm.plugin.game.model.NotifyGameWebviewOperationListener;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.af;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, j
{
  c HSC;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    com.tencent.threadpool.h.ahAA.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275308);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk();
            localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
            Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
            localObject2 = ((com.tencent.mm.plugin.game.media.g)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject2 == null)
            {
              localObject1 = null;
              if (!Util.isNullOrNil((List)localObject1)) {
                break;
              }
              Log.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
              AppMethodBeat.o(275308);
              return;
            }
            localObject1 = new LinkedList();
            if (((Cursor)localObject2).moveToNext())
            {
              com.tencent.mm.plugin.game.media.e locale = new com.tencent.mm.plugin.game.media.e();
              locale.convertFrom((Cursor)localObject2);
              ((LinkedList)localObject1).add(locale);
            }
            else
            {
              ((Cursor)localObject2).close();
            }
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace("MicroMsg.PluginGame", localException, "", new Object[0]);
            AppMethodBeat.o(275308);
            return;
          }
        }
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCk().aGx(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(275308);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    af.aR("Game", "Game", 5);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.HSC == null) {
        this.HSC = new c();
      }
    }
    if (paramg.FH(":tools")) {
      com.tencent.mm.plugin.report.service.h.OAn.p(939L, 1L, 1L);
    }
    if (paramg.FH(":toolsmp")) {
      com.tencent.mm.plugin.report.service.h.OAn.p(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.bbA())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.br.b.bsa("game");
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.f.class, new f());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.c.class, new d());
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.game.api.h.class, new com.tencent.mm.kernel.c.e(new p()));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.d.class, new com.tencent.mm.plugin.game.media.f());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.g.class, new g());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.FH(":tools")) || (paramg.FH(":toolsmp")) || (paramg.FI(":appbrand"))) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.game.api.h.class, new com.tencent.mm.kernel.c.e(new p()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(40857);
    Log.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.HSC != null)
    {
      paramc = this.HSC;
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("gamecenter", paramc.ysZ, true);
      paramc.HRV.alive();
      paramc.HRX.alive();
      paramc.HRZ.alive();
      paramc.lxy.alive();
      paramc.HSa.alive();
      paramc.HSb.alive();
      paramc.HSc.alive();
      paramc.HSd.alive();
      paramc.HSe.alive();
      paramc.HSi.alive();
      paramc.HSj.alive();
      paramc.HSf.alive();
      paramc.HSk.alive();
      paramc.HSl.alive();
      paramc.zMr.alive();
      paramc.HSm.alive();
      paramc.HRY.alive();
      paramc.HSn.alive();
      paramc.HSo.alive();
      k.duo();
      com.tencent.mm.plugin.game.model.silent_download.e.duo();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.HRW);
    }
    checkHaowanPublishState();
    com.tencent.mm.plugin.game.commlib.c.a.fEf().a("game_resource_check", new a.a()
    {
      public final void dun()
      {
        AppMethodBeat.i(275307);
        com.tencent.mm.plugin.game.b.b localb = com.tencent.mm.plugin.game.b.b.Itw;
        com.tencent.mm.plugin.game.b.b.fEh();
        AppMethodBeat.o(275307);
      }
    });
    com.tencent.mm.br.c.a(new c.c()
    {
      public final boolean aR(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(275306);
        if (((paramAnonymousString.startsWith("game")) || (paramAnonymousString.startsWith("gamelife"))) && (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu()))
        {
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(paramAnonymousContext);
          AppMethodBeat.o(275306);
          return true;
        }
        AppMethodBeat.o(275306);
        return false;
      }
    });
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    Log.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.HSC != null)
    {
      c localc = this.HSC;
      ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("gamecenter", localc.ysZ, true);
      localc.HRV.dead();
      localc.HRX.dead();
      localc.HRZ.dead();
      localc.lxy.dead();
      localc.HSa.dead();
      localc.HSb.dead();
      localc.HSc.dead();
      localc.HSd.dead();
      localc.HSe.dead();
      localc.HSi.dead();
      localc.HSj.dead();
      localc.HSf.dead();
      localc.HSk.dead();
      localc.HSl.dead();
      localc.zMr.dead();
      localc.HSm.dead();
      localc.HRY.dead();
      localc.HSn.dead();
      localc.HSo.dead();
      k.cuD();
      com.tencent.mm.plugin.game.model.silent_download.e.cuD();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.NDM;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.HRW);
    }
    com.tencent.mm.plugin.game.d.c.cNl();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */