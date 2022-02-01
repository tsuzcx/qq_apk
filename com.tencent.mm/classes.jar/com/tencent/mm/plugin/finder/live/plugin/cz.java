package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.c.a.a.a.b.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.component.aa;
import com.tencent.mm.plugin.finder.live.model.am;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "canClearScreen", "", "doClose", "", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class cz
  extends d
{
  @Deprecated
  public static final a yyU;
  private int kCS;
  private final com.tencent.mm.live.c.b kCU;
  private final View kFA;
  
  static
  {
    AppMethodBeat.i(260081);
    yyU = new a((byte)0);
    AppMethodBeat.o(260081);
  }
  
  public cz(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(260078);
    this.kCU = paramb;
    this.kFA = paramViewGroup.findViewById(b.e.live_visitor_close_btn_group);
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(237953);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.plugin.finder.live.model.i.yeN;
        paramAnonymousView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.yyV.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig;
        p.k(paramAnonymousView, "anchorUserName");
        long l3 = Util.nowSecond();
        localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        int i;
        if (l3 - com.tencent.mm.plugin.finder.live.utils.a.aal().getLong("last_show_follow_guide_time", 0L) < 86400L)
        {
          Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide showed in 24 hour");
          i = 0;
          if (i == 0) {
            break label344;
          }
          cz.a(this.yyV).statusChange(b.c.kBK, null);
        }
        for (;;)
        {
          cz.dCT();
          Log.i("Finder.FinderLiveVisitorClosePlugin", "close click!");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(237953);
          return;
          if (((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveActionRecordStorage().b(paramAnonymousView, a.a.ZlJ))
          {
            Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide had unfollow");
            i = 0;
            break;
          }
          localObject = com.tencent.mm.plugin.finder.upload.action.i.ACa;
          if (com.tencent.mm.plugin.finder.upload.action.i.ecE().aAN(paramAnonymousView))
          {
            Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide followed");
            i = 0;
            break;
          }
          localObject = am.yij;
          p.k(paramAnonymousView, "anchorUserName");
          long l2 = Util.nowSecond();
          paramAnonymousView = (Long)am.dzT().get(paramAnonymousView);
          long l1;
          if (paramAnonymousView != null)
          {
            l1 = paramAnonymousView.longValue();
            label254:
            l1 = l2 - l1;
            Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide watchTime:" + l1 + " threshold:" + com.tencent.mm.plugin.finder.live.model.i.dym());
            if (l1 < com.tencent.mm.plugin.finder.live.model.i.dym()) {
              break label339;
            }
          }
          label339:
          for (int j = 1;; j = 0)
          {
            i = j;
            if (j == 0) {
              break;
            }
            paramAnonymousView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            com.tencent.mm.plugin.finder.live.utils.a.aal().putLong("last_show_follow_guide_time", l3);
            i = j;
            break;
            l1 = l2;
            break label254;
          }
          label344:
          cz.b(this.yyV);
        }
      }
    });
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
      AppMethodBeat.o(260078);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(260078);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(260078);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aw.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private final void dCS()
  {
    AppMethodBeat.i(260073);
    b.b.a(this.kCU, b.c.kyV);
    aa localaa = aa.ycv;
    aa.c(3, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgu, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfu, true);
    m.yCt.a(s.bh.yLI);
    AppMethodBeat.o(260073);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(260064);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    AppMethodBeat.o(260064);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(260071);
    p.k(paramc, "status");
    switch (da.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(260071);
      return;
      tU(8);
      AppMethodBeat.o(260071);
      return;
      tU(0);
      AppMethodBeat.o(260071);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      AppMethodBeat.o(260071);
      return;
      dCS();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cz
 * JD-Core Version:    0.7.0.1
 */