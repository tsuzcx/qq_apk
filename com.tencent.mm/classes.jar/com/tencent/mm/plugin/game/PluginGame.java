package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.i
{
  c ucD;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    h.MqF.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40854);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZo();
            localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
            ae.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
            localObject2 = ((com.tencent.mm.plugin.game.media.g)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject2 == null)
            {
              localObject1 = null;
              if (!bu.ht((List)localObject1)) {
                break;
              }
              ae.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
              AppMethodBeat.o(40854);
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
            ae.printErrStackTrace("MicroMsg.PluginGame", localException, "", new Object[0]);
            AppMethodBeat.o(40854);
            return;
          }
        }
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cZo().amJ(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(40854);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.ucD == null) {
        this.ucD = new c();
      }
    }
    if (paramg.xO(":tools")) {
      com.tencent.mm.plugin.report.service.g.yxI.n(939L, 1L, 1L);
    }
    if (paramg.xO(":toolsmp")) {
      com.tencent.mm.plugin.report.service.g.yxI.n(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.akL())
    {
      ae.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.br.c.aPn("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.f.class, new f());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.xO(":tools")) || (paramg.xO(":toolsmp")) || (paramg.xP(":appbrand"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40857);
    ae.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.ucD != null)
    {
      paramc = this.ucD;
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("gamecenter", paramc.qkv, true);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uca);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucc);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uce);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.fLW);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucf);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucg);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uch);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uci);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucj);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucn);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uco);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.uck);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucp);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucq);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.riP);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucr);
      com.tencent.mm.sdk.b.a.IvT.c(paramc.ucd);
      k.cds();
      com.tencent.mm.plugin.game.model.a.e.cds();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xJX;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.ucb);
    }
    checkHaowanPublishState();
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    ae.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.ucD != null)
    {
      c localc = this.ucD;
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("gamecenter", localc.qkv, true);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uca);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucc);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uce);
      com.tencent.mm.sdk.b.a.IvT.d(localc.fLW);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucf);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucg);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uch);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uci);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucj);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucn);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uco);
      com.tencent.mm.sdk.b.a.IvT.d(localc.uck);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucp);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucq);
      com.tencent.mm.sdk.b.a.IvT.d(localc.riP);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucr);
      com.tencent.mm.sdk.b.a.IvT.d(localc.ucd);
      k.cdt();
      com.tencent.mm.plugin.game.model.a.e.cdt();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xJX;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.ucb);
    }
    com.tencent.mm.plugin.game.f.c.bCi();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */