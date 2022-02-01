package com.tencent.mm.plugin.finder.nearby;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.findersdk.a.j;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/PluginFinderNearby;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/plugin/finder/nearby/api/IPluginFinderNearby;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "finderLiveSquareFindPageActivity", "", "Lcom/tencent/mm/ui/MMActivity;", "kotlin.jvm.PlatformType", "", "nearbyActivity", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "enterFinderLbsLiveFriendsUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterNearbyLiveMoreUI", "execute", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "get3TabTargetTabCommentScene", "", "getClickTabId", "", "fragment", "Landroidx/fragment/app/Fragment;", "getCommentScene", "getExitLiveTabId", "getNearByReadFeedRecorder", "Lcom/tencent/plugin/finder/nearby/api/INearbyReadFeedRecorder;", "getNearbyEnterTargetLiveRoomChecker", "Lcom/tencent/plugin/finder/nearby/api/INearbyEnterTargetLiveRoomChecker;", "getNearbyTabLifecycleReporter", "Lcom/tencent/plugin/finder/nearby/api/INearbyTabLifecycleReporter;", "getReportType", "getTabType", "getViewModelStore", "isInFinderLiveSquareFindPageUI", "", "isInNearby", "isNearby", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onEnterFinder", "finder", "onExitFinder", "parseTabIdFlag", "commentScene", "tabId", "resetLiveFirstPagePreload", "plugin-finder-nearby_release"})
public final class PluginFinderNearby
  extends f
  implements ab, com.tencent.c.a.b.a.e, com.tencent.mm.kernel.api.c
{
  private final aa VK;
  private final Set<MMActivity> zCR;
  private final Set<MMActivity> zCS;
  
  public PluginFinderNearby()
  {
    AppMethodBeat.i(199508);
    this.VK = new aa();
    this.zCR = Collections.synchronizedSet((Set)new HashSet());
    this.zCS = Collections.synchronizedSet((Set)new HashSet());
    AppMethodBeat.o(199508);
  }
  
  public final void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199493);
    p.k(paramContext, "context");
    a locala = a.zCs;
    a.enterFinderLbsLiveFriendsUI(paramContext, paramIntent);
    AppMethodBeat.o(199493);
  }
  
  public final void enterNearbyLiveMoreUI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(199494);
    p.k(paramContext, "context");
    a locala = a.zCs;
    a.enterNearbyLiveMoreUI(paramContext, paramIntent);
    AppMethodBeat.o(199494);
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(199482);
    p.k(paramg, "profile");
    AppMethodBeat.o(199482);
  }
  
  public final int get3TabTargetTabCommentScene()
  {
    AppMethodBeat.i(199495);
    d locald = d.zCK;
    int i = d.get3TabTargetTabCommentScene();
    AppMethodBeat.o(199495);
    return i;
  }
  
  public final String getClickTabId(Fragment paramFragment)
  {
    AppMethodBeat.i(199497);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      paramFragment = ((AbsNearByFragment)paramFragment).dLv();
      AppMethodBeat.o(199497);
      return paramFragment;
    }
    AppMethodBeat.o(199497);
    return "";
  }
  
  public final int getCommentScene(Fragment paramFragment)
  {
    AppMethodBeat.i(199496);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      int i = ((AbsNearByFragment)paramFragment).getCommentScene();
      AppMethodBeat.o(199496);
      return i;
    }
    AppMethodBeat.o(199496);
    return 0;
  }
  
  public final int getExitLiveTabId()
  {
    AppMethodBeat.i(199505);
    d locald = d.zCK;
    int i = d.getExitLiveTabId();
    AppMethodBeat.o(199505);
    return i;
  }
  
  public final com.tencent.c.a.b.a.b getNearByReadFeedRecorder()
  {
    return (com.tencent.c.a.b.a.b)com.tencent.mm.plugin.finder.nearby.report.d.zJm;
  }
  
  public final com.tencent.c.a.b.a.a getNearbyEnterTargetLiveRoomChecker()
  {
    return (com.tencent.c.a.b.a.a)com.tencent.mm.plugin.finder.nearby.live.base.b.zET;
  }
  
  public final com.tencent.c.a.b.a.c getNearbyTabLifecycleReporter()
  {
    return (com.tencent.c.a.b.a.c)com.tencent.mm.plugin.finder.nearby.report.e.zJs;
  }
  
  public final int getReportType(Fragment paramFragment)
  {
    AppMethodBeat.i(199499);
    if ((paramFragment instanceof AbsNearByFragment))
    {
      int i = ((AbsNearByFragment)paramFragment).duR();
      AppMethodBeat.o(199499);
      return i;
    }
    AppMethodBeat.o(199499);
    return 0;
  }
  
  public final int getTabType(Fragment paramFragment)
  {
    if ((paramFragment instanceof AbsNearByFragment)) {
      return ((AbsNearByFragment)paramFragment).fEH;
    }
    return 0;
  }
  
  public final aa getViewModelStore()
  {
    return this.VK;
  }
  
  public final boolean isInFinderLiveSquareFindPageUI()
  {
    AppMethodBeat.i(199489);
    if (this.zCR.size() > 0)
    {
      AppMethodBeat.o(199489);
      return true;
    }
    AppMethodBeat.o(199489);
    return false;
  }
  
  public final boolean isInNearby()
  {
    AppMethodBeat.i(199491);
    if (this.zCS.size() > 0)
    {
      AppMethodBeat.o(199491);
      return true;
    }
    AppMethodBeat.o(199491);
    return false;
  }
  
  public final boolean isNearby(Fragment paramFragment)
  {
    return paramFragment instanceof AbsNearByFragment;
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void onAccountRelease() {}
  
  public final boolean onEnterFinder(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(199486);
    p.k(paramMMActivity, "finder");
    com.tencent.mm.ui.component.g localg = com.tencent.mm.ui.component.g.Xox;
    int i = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramMMActivity).i(aj.class)).xkX;
    if ((j.Sg(i)) || (paramMMActivity.containUIC(e.class)))
    {
      if (!this.zCS.contains(paramMMActivity)) {
        this.zCS.add(paramMMActivity);
      }
      AppMethodBeat.o(199486);
      return true;
    }
    if ((((com.tencent.c.a.b.a.d)h.ag(com.tencent.c.a.b.a.d.class)).isFinderLiveSquareCommentScene(i)) || ((paramMMActivity instanceof FinderLiveFindPageUI)))
    {
      if (!this.zCR.contains(paramMMActivity)) {
        this.zCR.add(paramMMActivity);
      }
      AppMethodBeat.o(199486);
      return true;
    }
    AppMethodBeat.o(199486);
    return false;
  }
  
  public final void onExitFinder(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(199488);
    p.k(paramMMActivity, "finder");
    this.zCS.remove(paramMMActivity);
    this.zCR.remove(paramMMActivity);
    AppMethodBeat.o(199488);
  }
  
  public final int parseTabIdFlag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199503);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    paramInt1 = com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(paramInt2);
    AppMethodBeat.o(199503);
    return paramInt1;
  }
  
  public final void resetLiveFirstPagePreload(int paramInt)
  {
    AppMethodBeat.i(199507);
    Object localObject = new bcz();
    ((bcz)localObject).SOa = paramInt;
    com.tencent.mm.plugin.finder.nearby.preload.a locala = com.tencent.mm.plugin.finder.nearby.preload.a.zIv;
    localObject = com.tencent.mm.plugin.finder.nearby.preload.a.b((bcz)localObject);
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).dMv();
      AppMethodBeat.o(199507);
      return;
    }
    AppMethodBeat.o(199507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.PluginFinderNearby
 * JD-Core Version:    0.7.0.1
 */