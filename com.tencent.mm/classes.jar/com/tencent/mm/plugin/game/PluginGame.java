package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.commlib.c.a.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.i
{
  c Cgt;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    com.tencent.e.h.ZvG.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(189637);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evr();
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
              AppMethodBeat.o(189637);
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
            AppMethodBeat.o(189637);
            return;
          }
        }
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evr().aJJ(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(189637);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    ab.aE("Game", "Game", 5);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.Cgt == null) {
        this.Cgt = new c();
      }
    }
    if (paramg.MY(":tools")) {
      com.tencent.mm.plugin.report.service.h.IzE.p(939L, 1L, 1L);
    }
    if (paramg.MY(":toolsmp")) {
      com.tencent.mm.plugin.report.service.h.IzE.p(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.aIE())
    {
      Log.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.by.b.bsj("game");
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.f.class, new f());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.c.class, new d());
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.game.api.d.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.MY(":tools")) || (paramg.MY(":toolsmp")) || (paramg.MZ(":appbrand"))) {
      com.tencent.mm.kernel.h.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(40857);
    Log.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.Cgt != null)
    {
      paramc = this.Cgt;
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("gamecenter", paramc.vgX, true);
      EventCenter.instance.addListener(paramc.CfO);
      EventCenter.instance.addListener(paramc.CfQ);
      EventCenter.instance.addListener(paramc.CfS);
      EventCenter.instance.addListener(paramc.iVt);
      EventCenter.instance.addListener(paramc.CfT);
      EventCenter.instance.addListener(paramc.CfU);
      EventCenter.instance.addListener(paramc.CfV);
      EventCenter.instance.addListener(paramc.CfW);
      EventCenter.instance.addListener(paramc.CfX);
      EventCenter.instance.addListener(paramc.Cgb);
      EventCenter.instance.addListener(paramc.Cgc);
      EventCenter.instance.addListener(paramc.CfY);
      EventCenter.instance.addListener(paramc.Cgd);
      EventCenter.instance.addListener(paramc.Cge);
      EventCenter.instance.addListener(paramc.wqp);
      EventCenter.instance.addListener(paramc.Cgf);
      EventCenter.instance.addListener(paramc.CfR);
      EventCenter.instance.addListener(paramc.Cgg);
      k.cPR();
      com.tencent.mm.plugin.game.model.a.e.cPR();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.HGl;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.CfP);
    }
    checkHaowanPublishState();
    com.tencent.mm.plugin.game.commlib.c.a.ewo().a("game_resource_check", new a.a()
    {
      public final void cPQ()
      {
        AppMethodBeat.i(194075);
        com.tencent.mm.plugin.game.b.b localb = com.tencent.mm.plugin.game.b.b.CzF;
        com.tencent.mm.plugin.game.b.b.ewq();
        AppMethodBeat.o(194075);
      }
    });
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    Log.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.Cgt != null)
    {
      c localc = this.Cgt;
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("gamecenter", localc.vgX, true);
      EventCenter.instance.removeListener(localc.CfO);
      EventCenter.instance.removeListener(localc.CfQ);
      EventCenter.instance.removeListener(localc.CfS);
      EventCenter.instance.removeListener(localc.iVt);
      EventCenter.instance.removeListener(localc.CfT);
      EventCenter.instance.removeListener(localc.CfU);
      EventCenter.instance.removeListener(localc.CfV);
      EventCenter.instance.removeListener(localc.CfW);
      EventCenter.instance.removeListener(localc.CfX);
      EventCenter.instance.removeListener(localc.Cgb);
      EventCenter.instance.removeListener(localc.Cgc);
      EventCenter.instance.removeListener(localc.CfY);
      EventCenter.instance.removeListener(localc.Cgd);
      EventCenter.instance.removeListener(localc.Cge);
      EventCenter.instance.removeListener(localc.wqp);
      EventCenter.instance.removeListener(localc.Cgf);
      EventCenter.instance.removeListener(localc.CfR);
      EventCenter.instance.removeListener(localc.Cgg);
      k.cPS();
      com.tencent.mm.plugin.game.model.a.e.cPS();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.HGl;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.CfP);
    }
    com.tencent.mm.plugin.game.d.c.clU();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */