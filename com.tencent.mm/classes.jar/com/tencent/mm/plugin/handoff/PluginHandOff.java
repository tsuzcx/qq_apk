package com.tencent.mm.plugin.handoff;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.handoff.c.e;
import com.tencent.mm.plugin.handoff.c.e.j;
import com.tencent.mm.plugin.handoff.c.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.handoff.a.b
{
  private final a DrE;
  private final bd DrF;
  private final String TAG;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.DrE = new a();
    this.DrF = ((bd)new b(this));
    AppMethodBeat.o(10338);
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    Log.i(this.TAG, "dependency");
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    p.k(paramg, "profile");
    Log.i(this.TAG, "execute");
    if (paramg.aIE())
    {
      h.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)e.Dso);
      AppMethodBeat.o(10335);
      return;
    }
    h.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.c.g());
    AppMethodBeat.o(10335);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(10333);
    Log.i(this.TAG, "installed");
    alias(com.tencent.mm.plugin.handoff.a.b.class);
    AppMethodBeat.o(10333);
  }
  
  public final String name()
  {
    return "plugin-handoff";
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(10336);
    Log.i(this.TAG, "onAccountInitialized");
    this.DrE.alive();
    h.aHE().a(this.DrF);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    Log.i(this.TAG, "onAccountRelease");
    this.DrE.dead();
    h.aHE().b(this.DrF);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    Log.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = e.Dso;
      e.W((kotlin.g.a.a)e.j.Dst);
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = e.Dso;
      e.W((kotlin.g.a.a)e.k.Dsu);
      AppMethodBeat.o(10329);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements bd
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void bez()
    {
      AppMethodBeat.i(10331);
      Object localObject1 = PluginHandOff.access$getTAG$p(this.DrG);
      Object localObject2 = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.b localb = h.aHE();
      p.j(localb, "MMKernel.account()");
      Log.i((String)localObject1, localb.aGK());
      localObject1 = (o)h.ae(o.class);
      if (localObject1 != null)
      {
        localObject2 = new GetOnLineInfoInfoResult();
        ((GetOnLineInfoInfoResult)localObject2).nwq = ((o)localObject1).boc();
        ((GetOnLineInfoInfoResult)localObject2).lZJ = ((o)localObject1).boa();
        ((GetOnLineInfoInfoResult)localObject2).lZO = ((o)localObject1).bob();
        ((com.tencent.mm.plugin.appbrand.service.f)h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a("Common_IPC_appid", (Parcelable)localObject2);
        ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).a((GetOnLineInfoInfoResult)localObject2);
      }
      localObject1 = h.aHE();
      p.j(localObject1, "MMKernel.account()");
      if (((com.tencent.mm.kernel.b)localObject1).aGK())
      {
        Log.i(PluginHandOff.access$getTAG$p(this.DrG), "webwx is online, send alllist");
        e.Dso.eBI();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */