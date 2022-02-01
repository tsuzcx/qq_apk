package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.i
{
  c tRM;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    h.LTJ.r(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40854);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWK();
            localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
            ad.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
            localObject2 = ((com.tencent.mm.plugin.game.media.g)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject2 == null)
            {
              localObject1 = null;
              if (!bt.hj((List)localObject1)) {
                break;
              }
              ad.i("MicroMsg.PluginGame", "checkHaowanPublishState none");
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
            ad.printErrStackTrace("MicroMsg.PluginGame", localException, "", new Object[0]);
            AppMethodBeat.o(40854);
            return;
          }
        }
        Iterator localIterator = localException.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (com.tencent.mm.plugin.game.media.e)localIterator.next();
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.f.class)).cWK().alJ(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(40854);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    if (paramg.akw())
    {
      ad.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.tRM == null) {
        this.tRM = new c();
      }
    }
    if (paramg.xf(":tools")) {
      com.tencent.mm.plugin.report.service.g.yhR.n(939L, 1L, 1L);
    }
    if (paramg.xf(":toolsmp")) {
      com.tencent.mm.plugin.report.service.g.yhR.n(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.akw())
    {
      ad.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.bs.c.aNQ("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.f.class, new f());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.xf(":tools")) || (paramg.xf(":toolsmp")) || (paramg.xg(":appbrand"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.g.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40857);
    ad.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.tRM != null)
    {
      paramc = this.tRM;
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("gamecenter", paramc.qdQ, true);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRj);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRl);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRn);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.fJT);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRo);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRp);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRq);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRr);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRs);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRw);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRx);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRt);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRy);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRz);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.raJ);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRA);
      com.tencent.mm.sdk.b.a.IbL.c(paramc.tRm);
      k.ccd();
      com.tencent.mm.plugin.game.model.a.e.ccd();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xua;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.tRk);
    }
    checkHaowanPublishState();
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    ad.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.tRM != null)
    {
      c localc = this.tRM;
      ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("gamecenter", localc.qdQ, true);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRj);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRl);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRn);
      com.tencent.mm.sdk.b.a.IbL.d(localc.fJT);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRo);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRp);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRq);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRr);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRs);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRw);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRx);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRt);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRy);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRz);
      com.tencent.mm.sdk.b.a.IbL.d(localc.raJ);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRA);
      com.tencent.mm.sdk.b.a.IbL.d(localc.tRm);
      k.cce();
      com.tencent.mm.plugin.game.model.a.e.cce();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.xua;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.tRk);
    }
    com.tencent.mm.plugin.game.f.c.bBo();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */