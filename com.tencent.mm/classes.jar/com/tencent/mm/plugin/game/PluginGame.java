package com.tencent.mm.plugin.game;

import android.database.Cursor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cc;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.game.media.o;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PluginGame
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.game.api.h
{
  c rNu;
  
  private void checkHaowanPublishState()
  {
    AppMethodBeat.i(40859);
    com.tencent.e.h.Iye.q(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(40854);
        Object localObject2;
        for (;;)
        {
          try
          {
            Object localObject1 = ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBg();
            localObject2 = String.format("select * from %s where %s=%d", new Object[] { "GameHaowanPublishEdition", "publishState", Integer.valueOf(0) });
            ad.i("MicroMsg.Haowan.GameHaowanPublishStorage", "queryAllPublish: %s", new Object[] { localObject2 });
            localObject2 = ((com.tencent.mm.plugin.game.media.g)localObject1).rawQuery((String)localObject2, new String[0]);
            if (localObject2 == null)
            {
              localObject1 = null;
              if (!bt.gL((List)localObject1)) {
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
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.api.e.class)).cBg().acp(((com.tencent.mm.plugin.game.media.e)localObject2).field_taskId);
        }
        AppMethodBeat.o(40854);
      }
    }, 500L);
    AppMethodBeat.o(40859);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40855);
    if (paramg.agu())
    {
      ad.i("MicroMsg.PluginGame", "PluginGame configure");
      b.a.a(new b());
      if (this.rNu == null) {
        this.rNu = new c();
      }
    }
    if (paramg.ra(":tools")) {
      com.tencent.mm.plugin.report.service.h.vKh.m(939L, 1L, 1L);
    }
    if (paramg.ra(":toolsmp")) {
      com.tencent.mm.plugin.report.service.h.vKh.m(939L, 10L, 1L);
    }
    AppMethodBeat.o(40855);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(40856);
    if (paramg.agu())
    {
      ad.i("MicroMsg.PluginGame", "PluginGame execute");
      com.tencent.mm.bs.c.aCW("game");
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.e.class, new e());
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.d.class, new d());
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new o()));
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.game.api.c.class, new com.tencent.mm.plugin.game.media.f());
      AppMethodBeat.o(40856);
      return;
    }
    if ((paramg.ra(":tools")) || (paramg.ra(":toolsmp")) || (paramg.rb(":appbrand"))) {
      com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.game.api.f.class, new com.tencent.mm.kernel.c.e(new o()));
    }
    AppMethodBeat.o(40856);
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(40857);
    ad.i("MicroMsg.PluginGame", "onAccountInitialized");
    if (this.rNu != null)
    {
      paramc = this.rNu;
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("gamecenter", paramc.oXa, true);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rMV);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rMX);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rMY);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.fop);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rMZ);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNa);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNb);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNc);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNd);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNg);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNh);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNe);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNi);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNj);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.pIJ);
      com.tencent.mm.sdk.b.a.ESL.c(paramc.rNk);
      k.bQj();
      com.tencent.mm.plugin.game.model.a.e.bQj();
      c.appForegroundListener.alive();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.vdo;
      com.tencent.mm.plugin.recordvideo.background.a.a(5, paramc.rMW);
    }
    checkHaowanPublishState();
    AppMethodBeat.o(40857);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(40858);
    ad.i("MicroMsg.PluginGame", "onAccountRelease");
    if (this.rNu != null)
    {
      c localc = this.rNu;
      ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("gamecenter", localc.oXa, true);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rMV);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rMX);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rMY);
      com.tencent.mm.sdk.b.a.ESL.d(localc.fop);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rMZ);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNa);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNb);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNc);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNd);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNg);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNh);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNe);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNi);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNj);
      com.tencent.mm.sdk.b.a.ESL.d(localc.pIJ);
      com.tencent.mm.sdk.b.a.ESL.d(localc.rNk);
      k.bQk();
      com.tencent.mm.plugin.game.model.a.e.bQk();
      c.appForegroundListener.dead();
      com.tencent.mm.plugin.recordvideo.background.a locala = com.tencent.mm.plugin.recordvideo.background.a.vdo;
      com.tencent.mm.plugin.recordvideo.background.a.b(5, localc.rMW);
    }
    com.tencent.mm.plugin.game.f.c.bql();
    AppMethodBeat.o(40858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.PluginGame
 * JD-Core Version:    0.7.0.1
 */