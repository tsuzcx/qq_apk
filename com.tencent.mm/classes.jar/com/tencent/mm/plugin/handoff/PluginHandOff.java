package com.tencent.mm.plugin.handoff;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.plugin.handoff.a.b;
import com.tencent.mm.plugin.handoff.b.a.g;
import com.tencent.mm.plugin.handoff.b.a.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.api.c, b
{
  private final String TAG;
  private final a uPj;
  private final ay uPk;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.uPj = new a();
    this.uPk = ((ay)new b(this));
    AppMethodBeat.o(10338);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    ae.i(this.TAG, "dependency");
    if (ak.coh()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    p.h(paramg, "profile");
    ae.i(this.TAG, "execute");
    if (paramg.akL())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.handoff.b.a.uPL);
      AppMethodBeat.o(10335);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.b.c());
    AppMethodBeat.o(10335);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(10333);
    ae.i(this.TAG, "installed");
    alias(b.class);
    AppMethodBeat.o(10333);
  }
  
  public final String name()
  {
    return "plugin-handoff";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(10336);
    ae.i(this.TAG, "onAccountInitialized");
    this.uPj.alive();
    com.tencent.mm.kernel.g.ajP().a(this.uPk);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    ae.i(this.TAG, "onAccountRelease");
    this.uPj.dead();
    com.tencent.mm.kernel.g.ajP().b(this.uPk);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    ae.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = com.tencent.mm.plugin.handoff.b.a.uPL;
      ae.i("HandOffService", "onAppBackground");
      com.tencent.mm.plugin.handoff.b.a.cCq = false;
      if (!com.tencent.mm.plugin.handoff.b.a.uPH) {
        com.tencent.mm.plugin.handoff.b.a.A((d.g.a.a)a.g.uPQ);
      }
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = com.tencent.mm.plugin.handoff.b.a.uPL;
      ae.i("HandOffService", "onAppForeground");
      com.tencent.mm.plugin.handoff.b.a.cCq = true;
      com.tencent.mm.plugin.handoff.b.a.A((d.g.a.a)a.h.uPR);
      AppMethodBeat.o(10329);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements ay
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void aBX()
    {
      AppMethodBeat.i(10331);
      Object localObject1 = PluginHandOff.access$getTAG$p(this.uPl);
      Object localObject2 = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.ajP();
      p.g(locala, "MMKernel.account()");
      ae.i((String)localObject1, locala.aiX());
      localObject1 = (m)com.tencent.mm.kernel.g.ab(m.class);
      if (localObject1 != null)
      {
        localObject2 = new GetOnLineInfoInfoResult();
        ((GetOnLineInfoInfoResult)localObject2).kRc = ((m)localObject1).aKM();
        ((GetOnLineInfoInfoResult)localObject2).ioG = ((m)localObject1).aKJ();
        ((GetOnLineInfoInfoResult)localObject2).ioL = ((m)localObject1).aKL();
        ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).a("Common_IPC_appid", (Parcelable)localObject2);
      }
      localObject1 = com.tencent.mm.kernel.g.ajP();
      p.g(localObject1, "MMKernel.account()");
      if (((com.tencent.mm.kernel.a)localObject1).aiX())
      {
        ae.i(PluginHandOff.access$getTAG$p(this.uPl), "webwx is online, send alllist");
        com.tencent.mm.plugin.handoff.b.a.uPL.deB();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */