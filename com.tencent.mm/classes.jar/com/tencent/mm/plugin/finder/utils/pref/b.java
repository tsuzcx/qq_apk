package com.tencent.mm.plugin.finder.utils.pref;

import android.content.Context;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.extension.reddot.h.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveIncomePref;", "Lcom/tencent/mm/plugin/finder/utils/pref/PrefComponent;", "Lcom/tencent/mm/plugin/finder/utils/pref/WithPrepareResp;", "name", "", "preferenceScreen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "context", "Landroid/content/Context;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Landroid/content/Context;)V", "TAG", "getContext", "()Landroid/content/Context;", "hasExposeLiveIncomeEntranceTips", "getName", "()Ljava/lang/String;", "getPreferenceScreen", "()Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "getNameTag", "onClick", "", "onCreate", "onDestroy", "onResume", "onStop", "updatePrepareResp", "updateView", "isFromSceneEnd", "", "plugin-finder_release"})
public final class b
  implements i, j
{
  final com.tencent.mm.ui.base.preference.f AJD;
  String AJE;
  private final String TAG;
  final Context context;
  final String name;
  private ble wZz;
  
  public b(String paramString, com.tencent.mm.ui.base.preference.f paramf, Context paramContext)
  {
    AppMethodBeat.i(290857);
    this.name = paramString;
    this.AJD = paramf;
    this.context = paramContext;
    this.TAG = "Finder.PosterCenterLiveIncomePref";
    this.AJE = "";
    AppMethodBeat.o(290857);
  }
  
  public final void b(ble paramble)
  {
    AppMethodBeat.i(290856);
    p.k(paramble, "prepareResp");
    this.wZz = paramble;
    AppMethodBeat.o(290856);
  }
  
  public final String egv()
  {
    return this.name;
  }
  
  public final void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(290854);
    if (this.wZz == null) {
      this.AJD.dz(this.name, true);
    }
    Object localObject1 = this.wZz;
    if (localObject1 != null)
    {
      paramBoolean = com.tencent.mm.ae.d.dr(((ble)localObject1).SWk, 1);
      Object localObject2 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
      p.j(localObject2, "MMKernel.service(ITeenModeService::class.java)");
      boolean bool1 = ((com.tencent.mm.plugin.teenmode.a.b)localObject2).ZM();
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      localObject2 = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject2 = d.a.aAK(com.tencent.mm.model.z.bdh());
      if (localObject2 != null) {}
      for (long l = ((com.tencent.mm.plugin.finder.api.i)localObject2).field_liveSwitchFlag;; l = 0L)
      {
        boolean bool2 = com.tencent.mm.plugin.finder.live.utils.a.LI(l);
        localObject2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("initLiveIncomeCell FinderLive.entrance,xLab enable live:");
        com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
        Log.i((String)localObject2, com.tencent.c.a.a.a.a.a.imJ() + ", server flag:" + ((ble)localObject1).SWk + ", server enable live:" + paramBoolean + " rewardGainEnable:" + bool2);
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (!com.tencent.mm.plugin.finder.utils.aj.eej())
        {
          localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
          if ((!com.tencent.c.a.a.a.a.a.imJ()) && (!paramBoolean)) {
            break label308;
          }
        }
        if ((!bool2) || (bool1)) {
          break label308;
        }
        this.AJD.dz(this.name, false);
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.xup;
        localObject1 = com.tencent.mm.plugin.finder.extension.reddot.h.drl();
        localObject2 = this.context;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(290854);
        throw ((Throwable)localObject1);
      }
      com.tencent.mm.plugin.finder.extension.reddot.h.a((r)localObject1, (androidx.lifecycle.l)localObject2, (s)new a(this));
      AppMethodBeat.o(290854);
      return;
      label308:
      this.AJD.dz(this.name, true);
      AppMethodBeat.o(290854);
      return;
    }
    AppMethodBeat.o(290854);
  }
  
  public final void onClick()
  {
    AppMethodBeat.i(290855);
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    bkn localbkn = ((PluginFinder)localObject).getRedDotManager().aBe("FinderLiveIncomeEntrance");
    localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    com.tencent.mm.plugin.finder.extension.reddot.l locall = ((PluginFinder)localObject).getRedDotManager().aBf("FinderLiveIncomeEntrance");
    if ((localbkn != null) && (locall != null))
    {
      localObject = com.tencent.mm.plugin.finder.report.l.zWx;
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ(this.context);
      if (localObject == null) {
        break label184;
      }
    }
    label184:
    for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("4", locall, localbkn, 2, (bid)localObject, 0, 0, null, 224);
      localObject = com.tencent.mm.kernel.h.ag(ak.class);
      p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
      ((ak)localObject).getRedDotManager().aBd("FinderLiveIncomeEntrance");
      ((c)com.tencent.mm.kernel.h.ae(c.class)).bY(this.context, "");
      localObject = n.zWF;
      n.a(this.context, 0L, false, 2L, 9L, false, 0L);
      AppMethodBeat.o(290855);
      return;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(290853);
    this.AJD.dz(this.name, true);
    AppMethodBeat.o(290853);
  }
  
  public final void onResume() {}
  
  public final void onStop() {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotNotifier$Result;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/mm/plugin/finder/utils/pref/PosterCenterLiveIncomePref$updateView$1$1"})
  static final class a<T>
    implements s<h.a>
  {
    a(b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.pref.b
 * JD-Core Version:    0.7.0.1
 */