package com.tencent.mm.plugin.handoff;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.handoff.a.b;
import com.tencent.mm.plugin.handoff.c.e;
import com.tencent.mm.plugin.handoff.c.e.j;
import com.tencent.mm.plugin.handoff.c.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"})
public final class PluginHandOff
  extends com.tencent.mm.kernel.b.f
  implements c, b
{
  private final String TAG;
  private final a yhC;
  private final bc yhD;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.yhC = new a();
    this.yhD = ((bc)new b(this));
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
    p.h(paramg, "profile");
    Log.i(this.TAG, "execute");
    if (paramg.aBb())
    {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)e.yim);
      AppMethodBeat.o(10335);
      return;
    }
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.c.g());
    AppMethodBeat.o(10335);
  }
  
  public final void installed()
  {
    AppMethodBeat.i(10333);
    Log.i(this.TAG, "installed");
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
    Log.i(this.TAG, "onAccountInitialized");
    this.yhC.alive();
    com.tencent.mm.kernel.g.aAf().a(this.yhD);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    Log.i(this.TAG, "onAccountRelease");
    this.yhC.dead();
    com.tencent.mm.kernel.g.aAf().b(this.yhD);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    Log.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"})
  public static final class a
    extends o.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = e.yim;
      e.T((kotlin.g.a.a)e.j.yir);
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = e.yim;
      e.T((kotlin.g.a.a)e.k.yis);
      AppMethodBeat.o(10329);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onNotifyUserStatusChange"})
  static final class b
    implements bc
  {
    b(PluginHandOff paramPluginHandOff) {}
    
    public final void aVw()
    {
      AppMethodBeat.i(10331);
      Object localObject1 = PluginHandOff.access$getTAG$p(this.yhE);
      Object localObject2 = new StringBuilder("webwx online status: ");
      com.tencent.mm.kernel.a locala = com.tencent.mm.kernel.g.aAf();
      p.g(locala, "MMKernel.account()");
      Log.i((String)localObject1, locala.azn());
      localObject1 = (o)com.tencent.mm.kernel.g.af(o.class);
      if (localObject1 != null)
      {
        localObject2 = new GetOnLineInfoInfoResult();
        ((GetOnLineInfoInfoResult)localObject2).kDf = ((o)localObject1).beN();
        ((GetOnLineInfoInfoResult)localObject2).jjN = ((o)localObject1).beL();
        ((GetOnLineInfoInfoResult)localObject2).jjS = ((o)localObject1).beM();
        ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a("Common_IPC_appid", (Parcelable)localObject2);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).a((GetOnLineInfoInfoResult)localObject2);
      }
      localObject1 = com.tencent.mm.kernel.g.aAf();
      p.g(localObject1, "MMKernel.account()");
      if (((com.tencent.mm.kernel.a)localObject1).azn())
      {
        Log.i(PluginHandOff.access$getTAG$p(this.yhE), "webwx is online, send alllist");
        e.yim.dYk();
      }
      AppMethodBeat.o(10331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */