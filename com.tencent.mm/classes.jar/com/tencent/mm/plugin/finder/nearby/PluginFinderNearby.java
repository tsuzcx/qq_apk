package com.tencent.mm.plugin.finder.nearby;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/PluginFinderNearby;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/plugin/finder/nearby/api/IPluginFinderNearby;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "finderLiveSquareFindPageActivity", "", "Lcom/tencent/mm/ui/MMActivity;", "kotlin.jvm.PlatformType", "", "nearbyActivity", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "enterFinderLbsLiveFriendsUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterNearbyLiveMoreUI", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "get3TabTargetTabCommentScene", "", "getClickTabId", "", "fragment", "Landroidx/fragment/app/Fragment;", "getCommentScene", "getExitLiveTabId", "commentScene", "getNearByReadFeedRecorder", "Lcom/tencent/plugin/finder/nearby/api/INearbyReadFeedRecorder;", "getNearbyEnterTargetLiveRoomChecker", "Lcom/tencent/plugin/finder/nearby/api/INearbyEnterTargetLiveRoomChecker;", "getNearbyTabLifecycleReporter", "Lcom/tencent/plugin/finder/nearby/api/INearbyTabLifecycleReporter;", "getReportType", "getTabType", "getViewModelStore", "isInFinderLiveSquareFindPageUI", "", "isInNearby", "isNearby", "isNearbyActivity", "finder", "nearbyReport", "action", "", "nearbySayHiReport", "position", "sex", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onEnterFinder", "onExitFinder", "parseTabIdFlag", "tabId", "resetLiveFirstPagePreload", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginFinderNearby
  extends f
  implements ak, com.tencent.d.a.b.a.e, com.tencent.mm.kernel.api.c
{
  private final Set<MMActivity> EFC;
  private final Set<MMActivity> EFD;
  private final aj er;
  
  public PluginFinderNearby()
  {
    AppMethodBeat.i(339793);
    this.er = new aj();
    this.EFC = Collections.synchronizedSet((Set)new HashSet());
    this.EFD = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(339793);
  }
  
  public final void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339859);
    s.u(paramContext, "context");
    a locala = a.EFh;
    a.enterFinderLbsLiveFriendsUI(paramContext, paramIntent);
    AppMethodBeat.o(339859);
  }
  
  public final void enterNearbyLiveMoreUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(339865);
    s.u(paramContext, "context");
    a locala = a.EFh;
    a.enterNearbyLiveMoreUI(paramContext, paramIntent);
    AppMethodBeat.o(339865);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(339799);
    s.u(paramg, "profile");
    AppMethodBeat.o(339799);
  }
  
  public final int get3TabTargetTabCommentScene()
  {
    AppMethodBeat.i(339872);
    d locald = d.EFs;
    int i = d.get3TabTargetTabCommentScene();
    AppMethodBeat.o(339872);
    return i;
  }
  
  public final String getClickTabId(Fragment paramFragment)
  {
    AppMethodBeat.i(339889);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      paramFragment = ((AbsNearByFragment)paramFragment).eEt();
      AppMethodBeat.o(339889);
      return paramFragment;
    }
    AppMethodBeat.o(339889);
    return "";
  }
  
  public final int getCommentScene(Fragment paramFragment)
  {
    AppMethodBeat.i(339883);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      int i = ((AbsNearByFragment)paramFragment).getCommentScene();
      AppMethodBeat.o(339883);
      return i;
    }
    AppMethodBeat.o(339883);
    return 0;
  }
  
  public final int getExitLiveTabId(int paramInt)
  {
    AppMethodBeat.i(339909);
    d locald = d.EFs;
    paramInt = d.getExitLiveTabId(paramInt);
    AppMethodBeat.o(339909);
    return paramInt;
  }
  
  public final com.tencent.d.a.b.a.b getNearByReadFeedRecorder()
  {
    return (com.tencent.d.a.b.a.b)com.tencent.mm.plugin.finder.nearby.report.e.EQU;
  }
  
  public final com.tencent.d.a.b.a.a getNearbyEnterTargetLiveRoomChecker()
  {
    return (com.tencent.d.a.b.a.a)com.tencent.mm.plugin.finder.nearby.live.base.b.EJG;
  }
  
  public final com.tencent.d.a.b.a.c getNearbyTabLifecycleReporter()
  {
    return (com.tencent.d.a.b.a.c)com.tencent.mm.plugin.finder.nearby.report.g.ERj;
  }
  
  public final int getReportType(Fragment paramFragment)
  {
    AppMethodBeat.i(339896);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      int i = ((AbsNearByFragment)paramFragment).edC();
      AppMethodBeat.o(339896);
      return i;
    }
    AppMethodBeat.o(339896);
    return 0;
  }
  
  public final int getTabType(Fragment paramFragment)
  {
    if ((paramFragment instanceof AbsNearByFragment)) {
      return ((AbsNearByFragment)paramFragment).hJx;
    }
    return 0;
  }
  
  public final aj getViewModelStore()
  {
    return this.er;
  }
  
  public final boolean isInFinderLiveSquareFindPageUI()
  {
    AppMethodBeat.i(339834);
    if (this.EFC.size() > 0)
    {
      AppMethodBeat.o(339834);
      return true;
    }
    AppMethodBeat.o(339834);
    return false;
  }
  
  public final boolean isInNearby()
  {
    AppMethodBeat.i(339840);
    if (this.EFD.size() > 0)
    {
      AppMethodBeat.o(339840);
      return true;
    }
    AppMethodBeat.o(339840);
    return false;
  }
  
  public final boolean isNearby(Fragment paramFragment)
  {
    return paramFragment instanceof AbsNearByFragment;
  }
  
  public final boolean isNearbyActivity(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339823);
    s.u(paramMMActivity, "finder");
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    int i = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(as.class)).AJo;
    if ((com.tencent.mm.plugin.findersdk.a.k.Vz(i)) || (paramMMActivity.containUIC(e.class)) || (((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).isFinderLiveSquareCommentScene(i)) || ((paramMMActivity instanceof FinderLiveFindPageUI)))
    {
      AppMethodBeat.o(339823);
      return true;
    }
    AppMethodBeat.o(339823);
    return false;
  }
  
  public final void nearbyReport(long paramLong)
  {
    AppMethodBeat.i(339914);
    com.tencent.mm.plugin.finder.nearby.report.d locald = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.report(paramLong);
    AppMethodBeat.o(339914);
  }
  
  public final void nearbySayHiReport(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(339919);
    com.tencent.mm.plugin.finder.nearby.report.d locald = com.tencent.mm.plugin.finder.nearby.report.d.EQT;
    com.tencent.mm.plugin.finder.nearby.report.d.a(null, null, null, null, 0L, paramLong1, 0L, 0L, 0L, 0L, paramLong2 + 1L, paramInt, 0L, 5087);
    AppMethodBeat.o(339919);
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(339808);
    paramc = d.EFs;
    d.init();
    h.b(com.tencent.d.a.b.a.b.a.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.finder.nearby.service.impl.a());
    AppMethodBeat.o(339808);
  }
  
  public final void onAccountRelease() {}
  
  public final boolean onEnterFinder(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339817);
    s.u(paramMMActivity, "finder");
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    int i = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramMMActivity).q(as.class)).AJo;
    if ((com.tencent.mm.plugin.findersdk.a.k.Vz(i)) || (paramMMActivity.containUIC(e.class)))
    {
      if (!this.EFD.contains(paramMMActivity)) {
        this.EFD.add(paramMMActivity);
      }
      AppMethodBeat.o(339817);
      return true;
    }
    if ((((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).isFinderLiveSquareCommentScene(i)) || ((paramMMActivity instanceof FinderLiveFindPageUI)))
    {
      if (!this.EFC.contains(paramMMActivity)) {
        this.EFC.add(paramMMActivity);
      }
      AppMethodBeat.o(339817);
      return true;
    }
    AppMethodBeat.o(339817);
    return false;
  }
  
  public final void onExitFinder(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(339830);
    s.u(paramMMActivity, "finder");
    this.EFD.remove(paramMMActivity);
    this.EFC.remove(paramMMActivity);
    AppMethodBeat.o(339830);
  }
  
  public final int parseTabIdFlag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339905);
    com.tencent.mm.plugin.finder.nearby.live.square.page.b localb = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    paramInt1 = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(paramInt1, paramInt2);
    AppMethodBeat.o(339905);
    return paramInt1;
  }
  
  public final void resetLiveFirstPagePreload(int paramInt)
  {
    AppMethodBeat.i(339923);
    Object localObject = new bnn();
    ((bnn)localObject).ZVZ = paramInt;
    com.tencent.mm.plugin.finder.nearby.preload.a locala = com.tencent.mm.plugin.finder.nearby.preload.a.EPD;
    localObject = com.tencent.mm.plugin.finder.nearby.preload.a.b((bnn)localObject);
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).eGB();
    }
    AppMethodBeat.o(339923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.PluginFinderNearby
 * JD-Core Version:    0.7.0.1
 */