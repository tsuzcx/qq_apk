package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderAnchorVerifyWebviewUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveAuthUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLiveFinishUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameLivePostVerifyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameSearchUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderGameSelectUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveCountDownUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveCreateVisitorModeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveInvitedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryCreateUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryHistoryUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveNewFansUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveNoticeQRCodeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveNoticeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLivePrecheckLicenseUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveReplayUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomForLuckMoneyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveSubTagUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveTagUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorRoleUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveWeCoinHotIncomeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveWinLotteryListUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI30;
import com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI;
import com.tencent.mm.plugin.findersdk.e.a;
import com.tencent.mm.plugin.findersdk.e.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/LiveTmpFunction;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j Bxr;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(350748);
    Bxr = new j();
    TAG = "LiveTmpFunction";
    a locala = a.HdV;
    a.a((a.a)new a.a()
    {
      public final boolean ay(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(350788);
        s.u(paramAnonymousActivity, "activiy");
        boolean bool = paramAnonymousActivity instanceof FinderLiveVisitorWithoutAffinityUI;
        AppMethodBeat.o(350788);
        return bool;
      }
      
      public final boolean gs(Context paramAnonymousContext)
      {
        AppMethodBeat.i(350782);
        s.u(paramAnonymousContext, "context");
        boolean bool;
        if ((paramAnonymousContext instanceof FinderLiveAnchorWithoutAffinityUI))
        {
          bool = ((FinderLiveAnchorWithoutAffinityUI)paramAnonymousContext).BoA;
          AppMethodBeat.o(350782);
          return bool;
        }
        if ((paramAnonymousContext instanceof FinderLiveVisitorWithoutAffinityUI))
        {
          bool = ((FinderLiveVisitorWithoutAffinityUI)paramAnonymousContext).BoA;
          AppMethodBeat.o(350782);
          return bool;
        }
        AppMethodBeat.o(350782);
        return false;
      }
    });
    locala = a.HdV;
    a.bi(FinderLiveVisitorWithoutAffinityUI.class);
    locala = a.HdV;
    a.bj(FinderLiveVisitorAffinityUI.class);
    locala = a.HdV;
    a.bk(FinderLiveAnchorWithoutAffinityUI.class);
    locala = a.HdV;
    a.bl(FinderLiveAnchorAffinityUI.class);
    locala = a.HdV;
    a.bm(FinderLiveTagUI.class);
    locala = a.HdV;
    a.bn(FinderLivePrecheckLicenseUI.class);
    locala = a.HdV;
    a.bo(FinderLiveSelectRoomForLuckMoneyUI.class);
    locala = a.HdV;
    a.bp(FinderLiveCreateVisitorModeUI.class);
    locala = a.HdV;
    a.bq(FinderLivePostHelperUI.class);
    locala = a.HdV;
    a.br(FinderLiveVisitorWhiteListUI.class);
    locala = a.HdV;
    a.bs(FinderLiveMiniProProxyUI.class);
    locala = a.HdV;
    a.bt(FinderLiveMiniProProxyAffinityUI.class);
    locala = a.HdV;
    a.bu(FinderLiveAnchorSecondaryDeviceUI.class);
    locala = a.HdV;
    a.bv(FinderLiveAnchorSecondaryDeviceAffinityUI.class);
    locala = a.HdV;
    a.bw(FinderLiveVisitorRoleUI.class);
    locala = a.HdV;
    a.bx(FinderLiveLotteryHistoryUI.class);
    locala = a.HdV;
    a.by(FinderLiveFansListUI.class);
    locala = a.HdV;
    a.bz(FinderLiveInvitedUI.class);
    locala = a.HdV;
    a.bA(FinderLiveWinLotteryListUI.class);
    locala = a.HdV;
    a.bB(FinderLiveLotteryDetailUI.class);
    locala = a.HdV;
    a.bC(FinderLiveCountDownUI.class);
    locala = a.HdV;
    a.bD(FinderLiveWeCoinHotIncomeUI.class);
    locala = a.HdV;
    a.bE(FinderLiveNewFansUI.class);
    locala = a.HdV;
    a.bF(FinderLiveLotteryCreateUI.class);
    locala = a.HdV;
    a.bG(FinderLiveSubTagUI.class);
    locala = a.HdV;
    a.bH(FinderGameLiveAuthUI.class);
    locala = a.HdV;
    a.bI(FinderGameLiveFinishUI.class);
    locala = a.HdV;
    a.bJ(FinderGameLivePostUI.class);
    locala = a.HdV;
    a.bK(FinderGameLivePostVerifyUI.class);
    locala = a.HdV;
    a.bL(FinderGameSearchUI.class);
    locala = a.HdV;
    a.bM(FinderGameSelectUI.class);
    locala = a.HdV;
    a.bN(FinderLiveNoticeQRCodeUI.class);
    locala = a.HdV;
    a.bO(FinderAnchorVerifyWebviewUI.class);
    locala = a.HdV;
    a.bP(FinderLiveNoticeUI.class);
    locala = a.HdV;
    a.bQ(FinderLiveReplayUI.class);
    locala = a.HdV;
    a.bR(OccupyFinderUI30.class);
    AppMethodBeat.o(350748);
  }
  
  public static void init()
  {
    AppMethodBeat.i(350739);
    Log.i(TAG, "LiveTmpFunction");
    AppMethodBeat.o(350739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.j
 * JD-Core Version:    0.7.0.1
 */