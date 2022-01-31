package com.tencent.mm.plugin.bbom;

import com.tencent.mm.ae.n.a;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.u;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.plugin.welab.b.b;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.y;

public class PluginBigBallOfMudAsync
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.plugin.bbom.a.a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    if ((paramg.Ex()) && (((h)paramg).mProfileCompat != null)) {
      ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile)((h)paramg).mProfileCompat).getNotification());
    }
    com.tencent.mm.pluginsdk.ui.applet.t.a.sdu = new PluginBigBallOfMudAsync.1(this);
    n.a.a(new PluginBigBallOfMudAsync.2(this));
    com.tencent.mm.pluginsdk.ui.d.c.a.sjo = new PluginBigBallOfMudAsync.3(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.f.a.rBZ = new PluginBigBallOfMudAsync.4(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.g.a.rCa = new PluginBigBallOfMudAsync.5(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.c.a.rBY = new PluginBigBallOfMudAsync.6(this);
    com.tencent.mm.plugin.webview.ui.tools.widget.a.a.rBX = new PluginBigBallOfMudAsync.7(this);
    com.tencent.mm.kernel.g.a(ad.class, new com.tencent.mm.pluginsdk.model.f());
    com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.fav.a.v.class, new c());
    if ((((h)paramg).mProfileCompat != null) && (paramg.Ex()))
    {
      WorkerProfile localWorkerProfile = (WorkerProfile)((h)paramg).mProfileCompat;
      com.tencent.mm.app.v localv = localWorkerProfile.bxL;
      u localu = localWorkerProfile.bxM;
      com.tencent.mm.br.c.som = localv;
      com.tencent.mm.br.c.son = localu;
      new com.tencent.mm.plugin.g.e(localWorkerProfile).before(this).after(com.tencent.mm.kernel.g.t(p.class));
    }
    if (paramg.Ex()) {
      ((p)com.tencent.mm.kernel.g.t(p.class)).setIDataTransferFactoryDelegate(new PluginBigBallOfMudAsync.8(this));
    }
  }
  
  public void dependency()
  {
    dependsOn(PluginBigBallOfMud.class);
    dependsOn(com.tencent.mm.plugin.notification.b.a.class);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if ((((h)paramg).mProfileCompat != null) && (paramg.Ex()))
    {
      y.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
      ((h)paramg).mProfileCompat.onCreate();
    }
    if (paramg.Ex())
    {
      ((d)com.tencent.mm.kernel.g.r(d.class)).a("labs1de6f3", new b());
      ((d)com.tencent.mm.kernel.g.r(d.class)).a(new com.tencent.mm.plugin.welab.d.a());
      ((d)com.tencent.mm.kernel.g.r(d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.b.a());
    }
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.bbom.a.a.class);
  }
  
  public String toString()
  {
    return "plugin-big-ball-of-mud-async";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.PluginBigBallOfMudAsync
 * JD-Core Version:    0.7.0.1
 */