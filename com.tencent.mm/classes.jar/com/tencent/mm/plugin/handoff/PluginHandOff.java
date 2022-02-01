package com.tencent.mm.plugin.handoff;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.handoff.c.e;
import com.tencent.mm.plugin.handoff.c.e.h;
import com.tencent.mm.plugin.handoff.c.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/PluginHandOff;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/handoff/api/IPluginHandOff;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1;", "userStatusChangeListener", "Lcom/tencent/mm/model/IOnUserStatusChange;", "dependency", "", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "installed", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "uninstalled", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginHandOff
  extends com.tencent.mm.kernel.b.f
  implements c, com.tencent.mm.plugin.handoff.a.b
{
  private final a Jlm;
  private final bd Jln;
  private final String TAG;
  
  public PluginHandOff()
  {
    AppMethodBeat.i(10338);
    this.TAG = "PluginHandOff";
    this.Jlm = new a();
    this.Jln = new PluginHandOff..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(10338);
  }
  
  private static final void userStatusChangeListener$lambda-0(PluginHandOff paramPluginHandOff)
  {
    AppMethodBeat.i(266008);
    s.u(paramPluginHandOff, "this$0");
    Log.i(paramPluginHandOff.TAG, s.X("webwx online status: ", Boolean.valueOf(com.tencent.mm.kernel.b.sy(h.baC().mBT))));
    q localq = (q)h.ax(q.class);
    GetOnLineInfoInfoResult localGetOnLineInfoInfoResult;
    List localList;
    if (localq != null)
    {
      localGetOnLineInfoInfoResult = new GetOnLineInfoInfoResult();
      localGetOnLineInfoInfoResult.qvq = localq.bLQ();
      localList = localq.bLO();
      if (!localList.contains(Integer.valueOf(1))) {
        break label182;
      }
      localGetOnLineInfoInfoResult.qvo = 1;
      localGetOnLineInfoInfoResult.qvp = localq.bLP();
      if ((localGetOnLineInfoInfoResult.qvo == -1) || (localGetOnLineInfoInfoResult.qvp == 0)) {
        break label211;
      }
      ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a("Common_IPC_appid", (Parcelable)localGetOnLineInfoInfoResult);
      ((com.tencent.mm.plugin.handoff.a.a)h.ax(com.tencent.mm.plugin.handoff.a.a.class)).a(localGetOnLineInfoInfoResult);
    }
    for (;;)
    {
      if (com.tencent.mm.kernel.b.sy(h.baC().mBT))
      {
        Log.i(paramPluginHandOff.TAG, "webwx is online, send alllist");
        e.JlJ.fJK();
      }
      AppMethodBeat.o(266008);
      return;
      label182:
      if (localList.contains(Integer.valueOf(2)))
      {
        localGetOnLineInfoInfoResult.qvo = 2;
        break;
      }
      localGetOnLineInfoInfoResult.qvo = -1;
      break;
      label211:
      Log.i(paramPluginHandOff.TAG, s.X("invalid login: ", localGetOnLineInfoInfoResult));
    }
  }
  
  public final void dependency()
  {
    AppMethodBeat.i(10332);
    Log.i(this.TAG, "dependency");
    dependsOn(com.tencent.mm.ipcinvoker.wx_extension.b.class);
    if (MMApplicationContext.isMainProcess()) {
      dependsOn(com.tencent.mm.plugin.comm.a.b.class);
    }
    AppMethodBeat.o(10332);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(10335);
    s.u(paramg, "profile");
    Log.i(this.TAG, "execute");
    if (paramg.bbA())
    {
      h.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)e.JlJ);
      AppMethodBeat.o(10335);
      return;
    }
    h.b(com.tencent.mm.plugin.handoff.a.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.handoff.c.f());
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
    this.Jlm.alive();
    h.baC().a(this.Jln);
    AppMethodBeat.o(10336);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(10337);
    Log.i(this.TAG, "onAccountRelease");
    this.Jlm.dead();
    h.baC().b(this.Jln);
    AppMethodBeat.o(10337);
  }
  
  public final void uninstalled()
  {
    AppMethodBeat.i(10334);
    Log.i(this.TAG, "uninstalled");
    super.uninstalled();
    AppMethodBeat.o(10334);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/PluginHandOff$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends q.a
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(10330);
      paramString = e.JlJ;
      e.bE((kotlin.g.a.a)e.h.JlX);
      AppMethodBeat.o(10330);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(10329);
      paramString = e.JlJ;
      e.bE((kotlin.g.a.a)e.i.JlY);
      AppMethodBeat.o(10329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.PluginHandOff
 * JD-Core Version:    0.7.0.1
 */