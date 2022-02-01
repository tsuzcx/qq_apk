package com.tencent.d.a.b.a;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/IPluginFinderNearby;", "Lcom/tencent/mm/kernel/plugin/IAlias;", "enterFinderLbsLiveFriendsUI", "", "context", "Landroid/content/Context;", "i", "Landroid/content/Intent;", "enterNearbyLiveMoreUI", "get3TabTargetTabCommentScene", "", "getClickTabId", "", "fragment", "Landroidx/fragment/app/Fragment;", "getCommentScene", "getExitLiveTabId", "commentScene", "getNearByReadFeedRecorder", "Lcom/tencent/plugin/finder/nearby/api/INearbyReadFeedRecorder;", "getNearbyEnterTargetLiveRoomChecker", "Lcom/tencent/plugin/finder/nearby/api/INearbyEnterTargetLiveRoomChecker;", "getNearbyTabLifecycleReporter", "Lcom/tencent/plugin/finder/nearby/api/INearbyTabLifecycleReporter;", "getReportType", "getTabType", "isInFinderLiveSquareFindPageUI", "", "isInNearby", "isNearby", "isNearbyActivity", "finder", "Lcom/tencent/mm/ui/MMActivity;", "nearbyReport", "action", "", "nearbySayHiReport", "position", "sex", "onEnterFinder", "onExitFinder", "parseTabIdFlag", "tabId", "resetLiveFirstPagePreload", "Companion", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
  extends com.tencent.mm.kernel.b.a
{
  public static final e.a ahpW = e.a.ahpX;
  
  public abstract void enterFinderLbsLiveFriendsUI(Context paramContext, Intent paramIntent);
  
  public abstract void enterNearbyLiveMoreUI(Context paramContext, Intent paramIntent);
  
  public abstract int get3TabTargetTabCommentScene();
  
  public abstract String getClickTabId(Fragment paramFragment);
  
  public abstract int getCommentScene(Fragment paramFragment);
  
  public abstract int getExitLiveTabId(int paramInt);
  
  public abstract b getNearByReadFeedRecorder();
  
  public abstract a getNearbyEnterTargetLiveRoomChecker();
  
  public abstract c getNearbyTabLifecycleReporter();
  
  public abstract int getReportType(Fragment paramFragment);
  
  public abstract int getTabType(Fragment paramFragment);
  
  public abstract boolean isInFinderLiveSquareFindPageUI();
  
  public abstract boolean isInNearby();
  
  public abstract boolean isNearby(Fragment paramFragment);
  
  public abstract boolean isNearbyActivity(MMActivity paramMMActivity);
  
  public abstract void nearbyReport(long paramLong);
  
  public abstract void nearbySayHiReport(long paramLong1, long paramLong2, int paramInt);
  
  public abstract boolean onEnterFinder(MMActivity paramMMActivity);
  
  public abstract void onExitFinder(MMActivity paramMMActivity);
  
  public abstract int parseTabIdFlag(int paramInt1, int paramInt2);
  
  public abstract void resetLiveFirstPagePreload(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.b.a.e
 * JD-Core Version:    0.7.0.1
 */