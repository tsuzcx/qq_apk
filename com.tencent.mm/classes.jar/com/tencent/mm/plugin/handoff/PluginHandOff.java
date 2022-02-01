package com.tencent.mm.plugin.handoff;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends f
  implements c, com.tencent.mm.plugin.handoff.a.b
{
  private final String TAG;
  private final a stf;
  private final av stg;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.stf = new a();
    this.stg = ((av)new b(this));
    AppMethodBeat.o(10338);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    ad.i(this.TAG, "dependency");
    if (aj.cbe()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    k.h(paramg, "profile");
    ad.i(this.TAG, "execute");
    if (paramg.agu())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.handoff.b.a.stG);
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
    this.stf.alive();
    com.tencent.mm.kernel.g.afz().a(this.stg);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    ad.i(this.TAG, "onAccountRelease");
    this.stf.dead();
    com.tencent.mm.kernel.g.afz().b(this.stg);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    ad.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = com.tencent.mm.plugin.handoff.b.a.stG;
      com.tencent.mm.plugin.handoff.b.a.cFz();
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = com.tencent.mm.plugin.handoff.b.a.stG;
      com.tencent.mm.plugin.handoff.b.a.cFy();
      AppMethodBeat.o(10329);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements av
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void arM()
    {
      AppMethodBeat.i(10331);
      Object localObject = PluginHandOff.access$getTAG$p(this.sth);
      StringBuilder localStringBuilder = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.afz();
      k.g(locala, "MMKernel.account()");
      ad.i((String)localObject, locala.aeG());
      localObject = com.tencent.mm.kernel.g.afz();
      k.g(localObject, "MMKernel.account()");
      if (((com.tencent.mm.kernel.a)localObject).aeG())
      {
        ad.i(PluginHandOff.access$getTAG$p(this.sth), "webwx is online, send alllist");
        com.tencent.mm.plugin.handoff.b.a.stG.cFt();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */