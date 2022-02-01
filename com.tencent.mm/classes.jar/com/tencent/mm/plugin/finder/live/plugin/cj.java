package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.d.a.a.a.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.plugin.finder.live.model.ad;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.j;
import com.tencent.mm.plugin.finder.live.report.q.bw;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.utils.bj;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "canClearScreen", "", "doClose", "", "resume", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "visibleInCurrentLiveMode", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cj
  extends b
{
  private static final cj.a DlH;
  private final com.tencent.mm.live.b.b ngl;
  private int ngo;
  private final View niB;
  
  static
  {
    AppMethodBeat.i(354383);
    DlH = new cj.a((byte)0);
    AppMethodBeat.o(354383);
  }
  
  public cj(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354329);
    this.ngl = paramb;
    this.niB = paramViewGroup.findViewById(b.e.live_visitor_close_btn_group);
    this.ngo = bf.bk(paramViewGroup.getContext());
    this.niB.setOnClickListener(new cj..ExternalSyntheticLambda0(this));
    if ((paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) && (isLandscape())) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this);
      AppMethodBeat.o(354329);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354329);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bf.bk(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(354329);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(bd.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  private static final void a(cj paramcj, View paramView)
  {
    AppMethodBeat.i(354374);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramcj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramcj, "this$0");
    paramView = bj.GlQ;
    if (bj.y(paramcj.getBuContext()))
    {
      paramView = ad.CGB;
      if (ad.ekZ()) {
        paramcj.ngl.statusChange(b.c.nfN, null);
      }
    }
    for (;;)
    {
      Log.i("Finder.FinderLiveVisitorClosePlugin", "close click!");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorClosePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354374);
      return;
      paramView = j.CFo;
      paramView = ((e)paramcj.getBuContext().business(e.class)).mIC;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramcj.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).hUQ;
      boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramcj.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg;
      s.u(paramView, "anchorUserName");
      s.u(localObject1, "bizUsername");
      long l3 = Util.nowSecond();
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      int i;
      if (l3 - com.tencent.mm.plugin.finder.live.utils.a.aBP().getLong("last_show_follow_guide_time", 0L) < 86400L)
      {
        Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide showed in 24 hour");
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          paramcj.ngl.statusChange(b.c.nfk, null);
          break;
          if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveActionRecordStorage().b(paramView, com.tencent.d.a.a.a.b.a.a.ahmE))
          {
            Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide had unfollow");
            i = 0;
          }
          else
          {
            if (bool)
            {
              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE((String)localObject1);
              if ((localObject1 != null) && (d.rs(((az)localObject1).field_type) == true)) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label390;
                }
                i = 0;
                break;
              }
            }
            if (((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).Ss(paramView))
            {
              Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide followed");
              i = 0;
            }
            else
            {
              label390:
              localObject1 = com.tencent.mm.plugin.finder.live.model.ao.CIe;
              s.u(paramView, "anchorUserName");
              long l2 = Util.nowSecond();
              paramView = (Long)com.tencent.mm.plugin.finder.live.model.ao.emf().get(paramView);
              long l1;
              if (paramView == null)
              {
                l1 = l2;
                label428:
                l1 = l2 - l1;
                Log.i("Finder.FinderLiveCloseShowFollowGuideLogic", "shouldShowFollowGuide watchTime:" + l1 + " threshold:" + j.ekE());
                if (l1 < j.ekE()) {
                  break label519;
                }
              }
              label519:
              for (int j = 1;; j = 0)
              {
                i = j;
                if (j == 0) {
                  break;
                }
                paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
                com.tencent.mm.plugin.finder.live.utils.a.aBP().putLong("last_show_follow_guide_time", l3);
                i = j;
                break;
                l1 = paramView.longValue();
                break label428;
              }
            }
          }
        }
      }
      paramcj.esI();
    }
  }
  
  private final void esI()
  {
    AppMethodBeat.i(354350);
    Object localObject = this.CTi.getContext();
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.live.viewmodel.component.b)com.tencent.mm.ui.component.k.nq((Context)localObject).q(com.tencent.mm.plugin.finder.live.viewmodel.component.b.class)).Eae = true;
        localObject = aj.CGT;
        localObject = (e)aj.business(e.class);
        if (localObject == null) {
          break label234;
        }
        i = ((e)localObject).eyu();
        localObject = e.b.mKf;
        if (i != e.b.bcu()) {
          break label234;
        }
      }
    }
    label234:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = com.tencent.mm.live.core.core.b.a.mOr;
        com.tencent.mm.live.core.core.b.a.a.beC();
        if (com.tencent.mm.live.core.core.b.a.bez())
        {
          localObject = com.tencent.mm.live.core.core.b.a.mOr;
          com.tencent.mm.live.core.core.b.a.a.beD();
          Log.i("Finder.FinderLiveService", "releaseP2P");
        }
      }
      b.b.a(this.ngl, b.c.nck);
      localObject = com.tencent.mm.plugin.finder.live.component.ao.CAQ;
      com.tencent.mm.plugin.finder.live.component.ao.c(3, ((e)getBuContext().business(e.class)).Eeo, ((e)getBuContext().business(e.class)).EcS, true);
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, this.mJe.getContext(), q.bw.DDz);
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveVideoDefinitionStorage().eud();
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage().etV();
      AppMethodBeat.o(354350);
      return;
      localObject = null;
      break;
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final boolean eoJ()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(354398);
    super.resume();
    int j = bf.bk(this.mJe.getContext());
    int i = j;
    if (j == 0) {
      i = bd.fromDPToPix(this.mJe.getContext(), 16);
    }
    this.ngo = i;
    AppMethodBeat.o(354398);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354419);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354419);
      return;
      tO(8);
      AppMethodBeat.o(354419);
      return;
      tO(0);
      AppMethodBeat.o(354419);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((b)this, false);
      AppMethodBeat.o(354419);
      return;
      esI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cj
 * JD-Core Version:    0.7.0.1
 */