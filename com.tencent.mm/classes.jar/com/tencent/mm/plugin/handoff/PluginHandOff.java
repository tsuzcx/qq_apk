package com.tencent.mm.plugin.handoff;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends f
  implements c, com.tencent.mm.plugin.handoff.a.b
{
  private final String TAG;
  private final a tAV;
  private final av tAW;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.tAV = new a();
    this.tAW = ((av)new b(this));
    AppMethodBeat.o(10338);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    ac.i(this.TAG, "dependency");
    if (ai.cin()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    k.h(paramg, "profile");
    ac.i(this.TAG, "execute");
    if (paramg.ahL())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.handoff.b.a.tBw);
      AppMethodBeat.o(10335);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.b.b());
    AppMethodBeat.o(10335);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(10333);
    ac.i(this.TAG, "installed");
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
    ac.i(this.TAG, "onAccountInitialized");
    this.tAV.alive();
    com.tencent.mm.kernel.g.agP().a(this.tAW);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    ac.i(this.TAG, "onAccountRelease");
    this.tAV.dead();
    com.tencent.mm.kernel.g.agP().b(this.tAW);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    ac.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends n.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = com.tencent.mm.plugin.handoff.b.a.tBw;
      com.tencent.mm.plugin.handoff.b.a.cSJ();
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = com.tencent.mm.plugin.handoff.b.a.tBw;
      com.tencent.mm.plugin.handoff.b.a.cSI();
      AppMethodBeat.o(10329);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements av
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void ayD()
    {
      AppMethodBeat.i(10331);
      Object localObject = PluginHandOff.access$getTAG$p(this.tAX);
      StringBuilder localStringBuilder = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.agP();
      k.g(locala, "MMKernel.account()");
      ac.i((String)localObject, locala.afW());
      localObject = com.tencent.mm.kernel.g.agP();
      k.g(localObject, "MMKernel.account()");
      if (((com.tencent.mm.kernel.a)localObject).afW())
      {
        ac.i(PluginHandOff.access$getTAG$p(this.tAX), "webwx is online, send alllist");
        com.tencent.mm.plugin.handoff.b.a.tBw.cSD();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */