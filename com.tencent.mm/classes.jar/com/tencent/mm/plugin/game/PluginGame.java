package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.i
{
  c xtU;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    com.tencent.f.h.RTc.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204097);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSN();
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
              AppMethodBeat.o(204097);
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
            AppMethodBeat.o(204097);
            return;
          }
        }
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.api.f.class)).dSN().azY(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(204097);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    y.at("Game", "Game", 7);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.xtU == null) {
        this.xtU = new c();
      }
    }
    if (paramg.FY(":tools")) {
      com.tencent.mm.plugin.report.service.h.CyF.n(939L, 1L, 1L);
    }
    if (paramg.FY(":toolsmp")) {
      com.tencent.mm.plugin.report.service.h.CyF.n(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.aBb())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.br.b.bfQ("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.f.class, new f());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.FY(":tools")) || (paramg.FY(":toolsmp")) || (paramg.FZ(":appbrand"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40857);
    Log.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.xtU != null)
    {
      paramc = this.xtU;
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("gamecenter", paramc.rBq, true);
      EventCenter.instance.addListener(paramc.xtq);
      EventCenter.instance.addListener(paramc.xts);
      EventCenter.instance.addListener(paramc.xtu);
      EventCenter.instance.addListener(paramc.grk);
      EventCenter.instance.addListener(paramc.xtv);
      EventCenter.instance.addListener(paramc.xtw);
      EventCenter.instance.addListener(paramc.xtx);
      EventCenter.instance.addListener(paramc.xty);
      EventCenter.instance.addListener(paramc.xtz);
      EventCenter.instance.addListener(paramc.xtD);
      EventCenter.instance.addListener(paramc.xtE);
      EventCenter.instance.addListener(paramc.xtA);
      EventCenter.instance.addListener(paramc.xtF);
      EventCenter.instance.addListener(paramc.xtG);
      EventCenter.instance.addListener(paramc.sKr);
      EventCenter.instance.addListener(paramc.xtH);
      EventCenter.instance.addListener(paramc.xtt);
      k.cBn();
      com.tencent.mm.plugin.game.model.a.e.cBn();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.BKb;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.xtr);
    }
    checkHaowanPublishState();
    com.tencent.mm.plugin.game.commlib.c.a.dTf().a("game_resource_check", new a.a()
    {
      public final void cBm()
      {
        AppMethodBeat.i(204096);
        com.tencent.mm.plugin.game.c.b localb = com.tencent.mm.plugin.game.c.b.xvL;
        com.tencent.mm.plugin.game.c.b.dTh();
        AppMethodBeat.o(204096);
      }
    });
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    Log.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.xtU != null)
    {
      c localc = this.xtU;
      ((s)com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("gamecenter", localc.rBq, true);
      EventCenter.instance.removeListener(localc.xtq);
      EventCenter.instance.removeListener(localc.xts);
      EventCenter.instance.removeListener(localc.xtu);
      EventCenter.instance.removeListener(localc.grk);
      EventCenter.instance.removeListener(localc.xtv);
      EventCenter.instance.removeListener(localc.xtw);
      EventCenter.instance.removeListener(localc.xtx);
      EventCenter.instance.removeListener(localc.xty);
      EventCenter.instance.removeListener(localc.xtz);
      EventCenter.instance.removeListener(localc.xtD);
      EventCenter.instance.removeListener(localc.xtE);
      EventCenter.instance.removeListener(localc.xtA);
      EventCenter.instance.removeListener(localc.xtF);
      EventCenter.instance.removeListener(localc.xtG);
      EventCenter.instance.removeListener(localc.sKr);
      EventCenter.instance.removeListener(localc.xtH);
      EventCenter.instance.removeListener(localc.xtt);
      k.cBo();
      com.tencent.mm.plugin.game.model.a.e.cBo();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.BKb;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.xtr);
    }
    com.tencent.mm.plugin.game.e.c.bZm();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */