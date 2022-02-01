package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.core.core.a.b.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.ap;
import com.tencent.mm.plugin.finder.live.report.q.r;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.live.widget.ay;
import com.tencent.mm.plugin.finder.live.widget.i;
import com.tencent.mm.plugin.finder.live.widget.l;
import com.tencent.mm.plugin.finder.live.widget.o;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bf;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "cameraOptWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorCameraOptionWidget;", "fixedWidgetRootList", "Ljava/util/LinkedList;", "Landroid/view/View;", "gameTeamWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorGameTeamWidget;", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "lotteryWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLuckyMoneyEntranceWidget;", "moreOptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMoreOptionEntranceWidget;", "musicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchoMusicEntranceWidget;", "promoteEntrance", "kotlin.jvm.PlatformType", "getPromoteEntrance", "()Landroid/view/View;", "promoteEntrance$delegate", "Lkotlin/Lazy;", "screenShareWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "getVisibleFixedWidgetsCount", "", "goLottery", "goLuckyMoney", "hideOption", "option", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "shoppingEntranceView", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "updateApplyLinkInfo", "updateGameTeamUI", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends b
{
  public static final h.b CTM;
  private static final int CTY;
  private static final int CTZ;
  private final LinkedList<View> CTN;
  private final o CTO;
  private final com.tencent.mm.plugin.finder.live.widget.k CTP;
  private final com.tencent.mm.plugin.finder.live.widget.j CTQ;
  final i CTR;
  private final com.tencent.mm.plugin.finder.live.widget.f CTS;
  private final com.tencent.mm.plugin.finder.live.widget.e CTT;
  private final com.tencent.mm.plugin.finder.live.widget.h CTU;
  private final ay CTV;
  private final kotlin.j CTW;
  private final l CTX;
  private final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354541);
    CTM = new h.b((byte)0);
    CTY = 1;
    CTZ = 2;
    AppMethodBeat.o(354541);
  }
  
  public h(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354483);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveAnchorBottomOptionPlugin";
    this.CTN = new LinkedList();
    paramb = paramViewGroup.findViewById(p.e.CaW);
    s.s(paramb, "root.findViewById(R.id.s…pping_entrance_container)");
    paramb = new o((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    ah localah = ah.aiuX;
    this.CTO = paramb;
    paramb = paramViewGroup.findViewById(p.e.BVZ);
    s.s(paramb, "root.findViewById(R.id.link_entrance_container)");
    paramb = new com.tencent.mm.plugin.finder.live.widget.k((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTP = paramb;
    paramb = paramViewGroup.findViewById(p.e.BXS);
    s.s(paramb, "root.findViewById(R.id.l…money_entrance_container)");
    paramb = new com.tencent.mm.plugin.finder.live.widget.j((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTQ = paramb;
    paramb = paramViewGroup.findViewById(p.e.BXD);
    s.s(paramb, "root.findViewById(R.id.lottery_entrance_container)");
    paramb = new i((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTR = paramb;
    paramb = paramViewGroup.findViewById(p.e.BIf);
    s.s(paramb, "root.findViewById(R.id.f…ve_camera_opt_click_area)");
    paramb = new com.tencent.mm.plugin.finder.live.widget.f((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTS = paramb;
    paramb = paramViewGroup.findViewById(p.e.BYo);
    s.s(paramb, "root.findViewById(R.id.music_entrance_container)");
    paramb = new com.tencent.mm.plugin.finder.live.widget.e((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTT = paramb;
    paramb = paramViewGroup.findViewById(p.e.BKS);
    s.s(paramb, "root.findViewById(R.id.f…live_game_team_container)");
    paramb = new com.tencent.mm.plugin.finder.live.widget.h((ViewGroup)paramb, this.nfT, (b)this);
    this.CTN.add(paramb.mJe);
    localah = ah.aiuX;
    this.CTU = paramb;
    paramb = paramViewGroup.findViewById(p.e.CaC);
    s.s(paramb, "root.findViewById(R.id.s…share_entrance_container)");
    this.CTV = new ay((ViewGroup)paramb, this.nfT, (b)this);
    this.CTW = kotlin.k.cm((kotlin.g.a.a)new e(paramViewGroup, this));
    paramb = paramViewGroup.findViewById(p.e.BYa);
    s.s(paramb, "root.findViewById(R.id.m…ption_entrance_container)");
    this.CTX = new l((ViewGroup)paramb, this.nfT, (b)this);
    if (!isLandscape()) {
      paramViewGroup.post(new h..ExternalSyntheticLambda1(paramViewGroup));
    }
    paramViewGroup = this.CTQ;
    paramb = new h..ExternalSyntheticLambda0(this);
    s.u(paramb, "listener");
    paramViewGroup.ElZ.setOnClickListener(paramb);
    AppMethodBeat.o(354483);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(354515);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramh);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramh, "this$0");
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egt)
    {
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject1 = q.s.DuT;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramView.a((q.s)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      paramh.tO(4);
      paramView = (bp)paramh.getPlugin(bp.class);
      if (paramView != null)
      {
        paramView.CWg = ((kotlin.g.a.a)new a(paramh));
        paramView.mJe.setVisibility(0);
        paramView.DhA.animate().translationY(0.0F).setDuration(200L).setListener(null).start();
        paramh = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramView = q.t.Dwh;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramh.a(paramView, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
        paramh = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramView = q.t.Dwg;
        localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        paramh.a(paramView, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354515);
      return;
      paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject1 = q.s.DuU;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      paramView.a((q.s)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      paramh.eoU();
    }
  }
  
  private final View eoP()
  {
    AppMethodBeat.i(354493);
    View localView = (View)this.CTW.getValue();
    AppMethodBeat.o(354493);
    return localView;
  }
  
  private static final void w(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(354503);
    s.u(paramViewGroup, "$root");
    Object localObject = paramViewGroup.getLayoutParams();
    if (localObject == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354503);
      throw paramViewGroup;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += bf.bk(paramViewGroup.getContext());
    AppMethodBeat.o(354503);
  }
  
  public final void c(Bundle paramBundle, Object paramObject)
  {
    AppMethodBeat.i(354643);
    i locali = this.CTR;
    Object localObject;
    if (paramBundle == null)
    {
      paramObject = "";
      if (s.p(paramObject, i.ElX)) {
        locali.ezY();
      }
      localObject = this.CTT;
      if (paramBundle != null) {
        break label93;
      }
      paramBundle = "";
    }
    for (;;)
    {
      if (s.p(paramBundle, com.tencent.mm.plugin.finder.live.widget.e.ElL)) {
        ((com.tencent.mm.plugin.finder.live.widget.e)localObject).ezU();
      }
      AppMethodBeat.o(354643);
      return;
      localObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramObject = localObject;
      if (localObject != null) {
        break;
      }
      paramObject = "";
      break;
      label93:
      paramObject = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = paramObject;
      if (paramObject == null) {
        paramBundle = "";
      }
    }
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void eoQ()
  {
    AppMethodBeat.i(354580);
    this.CTO.eoD();
    this.CTP.eoD();
    Object localObject1 = this.CTS;
    Object localObject3;
    com.tencent.mm.plugin.finder.live.report.j localj;
    if ((((com.tencent.mm.plugin.finder.live.widget.f)localObject1).mJe.getVisibility() != 0) || (((com.tencent.mm.plugin.finder.live.widget.f)localObject1).ElK))
    {
      ((com.tencent.mm.plugin.finder.live.widget.f)localObject1).ElK = false;
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject3 = q.t.Dwi;
      localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
    }
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    label214:
    boolean bool;
    label335:
    label367:
    int i;
    label382:
    int j;
    if (!com.tencent.mm.plugin.finder.live.utils.a.n(((com.tencent.mm.plugin.finder.live.widget.f)localObject1).CwG.getBuContext()))
    {
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.o(((com.tencent.mm.plugin.finder.live.widget.f)localObject1).CwG.getBuContext())) {}
    }
    else
    {
      ((com.tencent.mm.plugin.finder.live.widget.f)localObject1).mJe.setVisibility(8);
      localObject1 = this.CTT;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.euF()) {
        break label501;
      }
      localObject2 = com.tencent.mm.live.core.core.a.b.mMo;
      if (!b.a.bek()) {
        break label501;
      }
      if ((((com.tencent.mm.plugin.finder.live.widget.e)localObject1).mJe.getVisibility() != 0) || (((com.tencent.mm.plugin.finder.live.widget.e)localObject1).ElK))
      {
        ((com.tencent.mm.plugin.finder.live.widget.e)localObject1).ElK = false;
        localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject3 = q.t.Dwe;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a((q.t)localObject3, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      ((com.tencent.mm.plugin.finder.live.widget.e)localObject1).tO(0);
      localObject1 = this.CTR;
      Log.i(((i)localObject1).TAG, s.X("checkVisible:", Boolean.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((i)localObject1).CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egt)));
      bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((i)localObject1).CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egt;
      localObject2 = this.CTQ;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.e)((com.tencent.mm.plugin.finder.live.widget.j)localObject2).CwG.getBuContext().business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.class)).eys()) {
        break label519;
      }
      if ((((com.tencent.mm.plugin.finder.live.widget.j)localObject2).mJe.getVisibility() != 0) || (((com.tencent.mm.plugin.finder.live.widget.j)localObject2).ElK))
      {
        ((com.tencent.mm.plugin.finder.live.widget.j)localObject2).ElK = false;
        if (!bool) {
          break label511;
        }
        localObject1 = q.t.Dwf;
        localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject3).a((q.t)localObject1, com.tencent.mm.plugin.finder.live.report.j.a(q.r.Duf));
      }
      ((com.tencent.mm.plugin.finder.live.widget.j)localObject2).mJe.setVisibility(0);
      if (this.CTQ.mJe.getVisibility() != 0) {
        break label532;
      }
      i = 1;
      if (i == 0) {
        break label537;
      }
      localObject1 = this.CTR;
      label392:
      i = 8;
      label395:
      ((i)localObject1).tO(i);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.o(getBuContext())) {
        break label560;
      }
      eoP().setVisibility(8);
      this.CTX.setVisible(false);
      this.CTV.setVisible(false);
      label441:
      localObject1 = (Iterable)this.CTN;
      if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty())) {
        break label723;
      }
      j = 0;
    }
    for (;;)
    {
      if (j > 0)
      {
        tO(0);
        AppMethodBeat.o(354580);
        return;
        ((com.tencent.mm.plugin.finder.live.widget.f)localObject1).mJe.setVisibility(0);
        break;
        label501:
        ((com.tencent.mm.plugin.finder.live.widget.e)localObject1).tO(8);
        break label214;
        label511:
        localObject1 = q.t.Dwg;
        break label335;
        label519:
        ((com.tencent.mm.plugin.finder.live.widget.j)localObject2).mJe.setVisibility(8);
        break label367;
        label532:
        i = 0;
        break label382;
        label537:
        localObject2 = this.CTR;
        localObject1 = localObject2;
        if (!bool) {
          break label392;
        }
        i = 0;
        localObject1 = localObject2;
        break label395;
        label560:
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if (com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext()))
        {
          localObject1 = eoP();
          localObject2 = aw.Gjk;
          if (aw.fgy())
          {
            localObject2 = getBuContext();
            if (localObject2 != null)
            {
              localObject3 = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
              com.tencent.mm.plugin.finder.live.component.statecomponent.b.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject2, 1, 0, null, 12);
              localObject2 = ah.aiuX;
            }
          }
          for (i = 0;; i = 8)
          {
            ((View)localObject1).setVisibility(i);
            this.CTX.setVisible(false);
            this.CTV.setVisible(false);
            break;
          }
        }
        localObject1 = aw.Gjk;
        if (aw.fgy())
        {
          eoP().setVisibility(8);
          this.CTX.setVisible(true);
          this.CTV.setVisible(false);
          break label441;
        }
        eoP().setVisibility(8);
        this.CTX.setVisible(false);
        this.CTV.setVisible(true);
        break label441;
        label723:
        localObject1 = ((Iterable)localObject1).iterator();
        i = 0;
        j = i;
        if (((Iterator)localObject1).hasNext()) {
          if (((View)((Iterator)localObject1).next()).getVisibility() == 0)
          {
            j = 1;
            label764:
            if (j == 0) {
              break label804;
            }
            j = i + 1;
            i = j;
            if (j < 0)
            {
              p.kkX();
              i = j;
            }
          }
        }
      }
    }
    label804:
    for (;;)
    {
      break;
      j = 0;
      break label764;
      tO(8);
      AppMethodBeat.o(354580);
      return;
    }
  }
  
  public final void eoR()
  {
    AppMethodBeat.i(354593);
    com.tencent.mm.plugin.finder.live.widget.k localk = this.CTP;
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).Efv;
    Log.i(localk.TAG, "updateApplyLinkInfo newApplyCount:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyU() + ", curLinkUser:" + localObject1);
    localk.Emd.setVisibility(8);
    localk.Emf.setVisibility(8);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyV() > 0)
    {
      localk.Emf.setVisibility(0);
      localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localap = q.ap.DyR;
      localObject1 = localk.Emg.getText();
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a(localap, (String)localObject1, -1, -1);
      }
    }
    while (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyU() <= 0) {
      for (;;)
      {
        localk.eAa();
        AppMethodBeat.o(354593);
        return;
        localObject1 = null;
      }
    }
    localObject1 = localk.Emd;
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.finder.live.utils.a.Pu(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localk.CwG.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).eyU()));
    localk.Emd.setVisibility(0);
    localObject2 = com.tencent.mm.plugin.finder.live.report.j.Dob;
    q.ap localap = q.ap.DyR;
    localObject1 = localk.Emd.getText();
    if ((localObject1 instanceof String)) {}
    for (localObject1 = (String)localObject1;; localObject1 = null)
    {
      ((com.tencent.mm.plugin.finder.live.report.j)localObject2).a(localap, (String)localObject1, -1, -1);
      break;
    }
  }
  
  public final void eoS()
  {
    AppMethodBeat.i(354603);
    Log.i(this.TAG, "updateGameTeamUI");
    this.CTU.eoD();
    AppMethodBeat.o(354603);
  }
  
  public final void eoT()
  {
    AppMethodBeat.i(354610);
    d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(354610);
  }
  
  public final void eoU()
  {
    AppMethodBeat.i(354623);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0));
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(354623);
      throw ((Throwable)localObject);
    }
    switch (((Integer)localObject).intValue())
    {
    default: 
      aa.makeText(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getResources().getString(p.h.CmY), 0).show();
    }
    do
    {
      do
      {
        AppMethodBeat.o(354623);
        return;
      } while (!(this.mJe.getContext() instanceof Activity));
      localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
    } while (localObject == null);
    Context localContext = this.mJe.getContext();
    if (localContext == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(354623);
      throw ((Throwable)localObject);
    }
    ((ap)localObject).aA((Activity)localContext);
    AppMethodBeat.o(354623);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    AppMethodBeat.i(354654);
    paramIntent = this.TAG;
    Object localObject = new StringBuilder("onActivityResult requestCode:").append(paramInt1).append(",resultCode is ok:");
    StringBuilder localStringBuilder;
    if (paramInt2 == -1)
    {
      bool1 = true;
      Log.i(paramIntent, bool1);
      paramIntent = this.CTR;
      localObject = paramIntent.TAG;
      localStringBuilder = new StringBuilder("onActivityResult requestCode:").append(paramInt1).append(",resultCode is ok:");
      if (paramInt2 != -1) {
        break label150;
      }
    }
    label150:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i((String)localObject, bool1);
      if ((paramInt1 == 1002) && (paramInt2 == -1)) {
        b.b.a(paramIntent.nfT, b.c.nei);
      }
      AppMethodBeat.o(354654);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354631);
    s.u(paramc, "status");
    switch (h.c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(354631);
      return;
      this.CTP.eoD();
      AppMethodBeat.o(354631);
      return;
      this.CTU.eoD();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(ViewGroup paramViewGroup, h paramh)
    {
      super();
    }
    
    private static final void b(h paramh, View paramView)
    {
      AppMethodBeat.i(353532);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramh);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin$promoteEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramh, "this$0");
      paramView = h.c(paramh);
      if (paramView != null) {
        b.b.a(paramView, b.c.ndJ);
      }
      paramh = paramh.getBuContext();
      if (paramh != null)
      {
        paramView = com.tencent.mm.plugin.finder.live.component.statecomponent.b.CCd;
        com.tencent.mm.plugin.finder.live.component.statecomponent.b.a(paramh, 2, 0, null, 12);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorBottomOptionPlugin$promoteEntrance$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353532);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.h
 * JD-Core Version:    0.7.0.1
 */