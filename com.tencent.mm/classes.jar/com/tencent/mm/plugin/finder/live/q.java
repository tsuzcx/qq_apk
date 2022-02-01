package com.tencent.mm.plugin.finder.live;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorSecondaryDeviceUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveCountDownUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveCreateVisitorModeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveFansListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveInvitedUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryCreateUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryDetailUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveLotteryHistoryUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLivePrecheckLicenseUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveSelectRoomForLuckMoneyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveSubTagUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveTagUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorRoleUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWhiteListUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveWeCoinHotIncomeUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveWinLotteryListUI;
import com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI;
import com.tencent.mm.plugin.findersdk.e.a;
import com.tencent.mm.plugin.findersdk.e.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/LiveTmpFunction;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "init", "", "plugin-finder-live_release"})
public final class q
{
  private static final String TAG = "LiveTmpFunction";
  public static final q xWy;
  
  static
  {
    AppMethodBeat.i(233342);
    xWy = new q();
    TAG = "LiveTmpFunction";
    a locala = a.Bxf;
    a.a((a.a)new a.a()
    {
      public final boolean an(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(233088);
        p.k(paramAnonymousActivity, "activiy");
        boolean bool = paramAnonymousActivity instanceof FinderLiveVisitorWithoutAffinityUI;
        AppMethodBeat.o(233088);
        return bool;
      }
      
      public final boolean fv(Context paramAnonymousContext)
      {
        AppMethodBeat.i(233087);
        p.k(paramAnonymousContext, "context");
        boolean bool;
        if ((paramAnonymousContext instanceof FinderLiveAnchorWithoutAffinityUI))
        {
          bool = ((FinderLiveAnchorWithoutAffinityUI)paramAnonymousContext).xOB;
          AppMethodBeat.o(233087);
          return bool;
        }
        if ((paramAnonymousContext instanceof FinderLiveVisitorWithoutAffinityUI))
        {
          bool = ((FinderLiveVisitorWithoutAffinityUI)paramAnonymousContext).xOB;
          AppMethodBeat.o(233087);
          return bool;
        }
        AppMethodBeat.o(233087);
        return false;
      }
    });
    locala = a.Bxf;
    a.aN(FinderLiveVisitorWithoutAffinityUI.class);
    locala = a.Bxf;
    a.aO(FinderLiveAnchorWithoutAffinityUI.class);
    locala = a.Bxf;
    a.aP(FinderLiveTagUI.class);
    locala = a.Bxf;
    a.aQ(FinderLivePrecheckLicenseUI.class);
    locala = a.Bxf;
    a.aR(FinderLiveSelectRoomForLuckMoneyUI.class);
    locala = a.Bxf;
    a.aS(FinderLiveCreateVisitorModeUI.class);
    locala = a.Bxf;
    a.aT(FinderLivePostHelperUI.class);
    locala = a.Bxf;
    a.aU(FinderLiveVisitorWhiteListUI.class);
    locala = a.Bxf;
    a.aV(FinderLiveMiniProProxyUI.class);
    locala = a.Bxf;
    a.aW(FinderLiveAnchorSecondaryDeviceUI.class);
    locala = a.Bxf;
    a.aX(FinderLiveVisitorRoleUI.class);
    locala = a.Bxf;
    a.aY(FinderLiveLotteryHistoryUI.class);
    locala = a.Bxf;
    a.aZ(FinderLiveFansListUI.class);
    locala = a.Bxf;
    a.ba(FinderLiveInvitedUI.class);
    locala = a.Bxf;
    a.bb(FinderLiveWinLotteryListUI.class);
    locala = a.Bxf;
    a.bc(FinderLiveLotteryDetailUI.class);
    locala = a.Bxf;
    a.bd(FinderLiveCountDownUI.class);
    locala = a.Bxf;
    a.be(FinderLiveWeCoinHotIncomeUI.class);
    locala = a.Bxf;
    a.bf(FinderLiveLotteryCreateUI.class);
    locala = a.Bxf;
    a.bg(FinderLiveSubTagUI.class);
    AppMethodBeat.o(233342);
  }
  
  public static void init()
  {
    AppMethodBeat.i(233341);
    Log.i(TAG, "LiveTmpFunction");
    AppMethodBeat.o(233341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.q
 * JD-Core Version:    0.7.0.1
 */