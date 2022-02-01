package com.tencent.mm.plugin.handoff;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.handoff.b.a.g;
import com.tencent.mm.plugin.handoff.b.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends f
  implements c, com.tencent.mm.plugin.handoff.a.b
{
  private final String TAG;
  private final a uDE;
  private final aw uDF;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.uDE = new a();
    this.uDF = ((aw)new b(this));
    AppMethodBeat.o(10338);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    ad.i(this.TAG, "dependency");
    if (aj.cmR()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    p.h(paramg, "profile");
    ad.i(this.TAG, "execute");
    if (paramg.akw())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.handoff.b.a.uEf);
      AppMethodBeat.o(10335);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.b.b());
    AppMethodBeat.o(10335);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(10333);
    ad.i(this.TAG, "installed");
    alias(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(10333);
  }
  
  public final String name()
  {
    return "plugin-handoff";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(10336);
    ad.i(this.TAG, "onAccountInitialized");
    this.uDE.alive();
    com.tencent.mm.kernel.g.ajA().a(this.uDF);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    ad.i(this.TAG, "onAccountRelease");
    this.uDE.dead();
    com.tencent.mm.kernel.g.ajA().b(this.uDF);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    ad.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = com.tencent.mm.plugin.handoff.b.a.uEf;
      ad.i("HandOffService", "onAppBackground");
      com.tencent.mm.plugin.handoff.b.a.cBJ = false;
      if (!com.tencent.mm.plugin.handoff.b.a.uEc) {
        com.tencent.mm.plugin.handoff.b.a.X((d.g.a.a)a.g.Odu);
      }
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = com.tencent.mm.plugin.handoff.b.a.uEf;
      ad.i("HandOffService", "onAppForeground");
      com.tencent.mm.plugin.handoff.b.a.cBJ = true;
      com.tencent.mm.plugin.handoff.b.a.X((d.g.a.a)a.h.Odv);
      AppMethodBeat.o(10329);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements aw
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void aBH()
    {
      AppMethodBeat.i(10331);
      Object localObject = PluginHandOff.access$getTAG$p(this.uDG);
      StringBuilder localStringBuilder = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.ajA();
      p.g(locala, "MMKernel.account()");
      ad.i((String)localObject, locala.aiI());
      localObject = com.tencent.mm.kernel.g.ajA();
      p.g(localObject, "MMKernel.account()");
      if (((com.tencent.mm.kernel.a)localObject).aiI())
      {
        ad.i(PluginHandOff.access$getTAG$p(this.uDG), "webwx is online, send alllist");
        com.tencent.mm.plugin.handoff.b.a.uEf.dbK();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */