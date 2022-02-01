package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.model.r;
import com.tencent.mm.live.model.r.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.g;
import com.tencent.mm.plugin.finder.live.report.q.m;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "COMMON_INFO_LIVE_CHARGE", "", "COMMON_INFO_PANEL_COL", "COMMON_INFO_TYPE_AVG_DURATION", "COMMON_INFO_TYPE_BIZ_FANS", "COMMON_INFO_TYPE_FANS", "COMMON_INFO_TYPE_HOT", "COMMON_INFO_TYPE_LIKE", "COMMON_INFO_TYPE_ONLINE", "COMMON_INFO_TYPE_TOTAL", "TAG", "", "backBtn", "Landroid/widget/ImageView;", "commonInfoAdapter", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter;", "commonInfoPanel", "Landroidx/recyclerview/widget/RecyclerView;", "liveDurationTv", "Landroid/widget/TextView;", "liveTask", "livingToFinish", "", "replay", "Landroid/view/View;", "replaySwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "rootContent", "Landroid/widget/RelativeLayout;", "titleTv", "isBizMode", "onBackPress", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareCommonInfoPanel", "info", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/AnchorFinishInfo;", "prepareReplayPanel", "setLiveTaskInfo", "setReplay", "replayLive", "show", "afterAction", "Lkotlin/Function0;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateBg", "bgUrl", "updateBgByUsername", "updateFinishInfo", "CommonInfo", "CommonInfoAdapter", "CommonInfoViewHolder", "GridSpaceItemDecoration", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b
  implements com.tencent.mm.am.h
{
  private final int CTA;
  private final int CTB;
  private final int CTC;
  private final TextView CTD;
  private final View CTE;
  private final MMSwitchBtn CTF;
  private final RecyclerView CTG;
  private b CTH;
  private boolean CTI;
  private final int CTu;
  private final int CTv;
  private final int CTw;
  private final int CTx;
  private final int CTy;
  private final int CTz;
  private final String TAG;
  private final ImageView nfU;
  private final TextView ngb;
  private final RelativeLayout ngh;
  private final com.tencent.mm.live.b.b ngl;
  private final TextView titleTv;
  
  public g(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354578);
    this.ngl = paramb;
    this.TAG = "Finder.LiveAnchorAfterPlugin";
    this.CTv = 1;
    this.CTw = 2;
    this.CTx = 3;
    this.CTy = 4;
    this.CTz = 5;
    this.CTA = 6;
    this.CTB = 7;
    this.CTC = 3;
    paramb = paramViewGroup.findViewById(p.e.live_after_over_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_over_tv)");
    this.titleTv = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.live_after_duration_tv);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_duration_tv)");
    this.ngb = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BXa);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_task_entrance)");
    this.CTD = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.live_after_ui_root_group);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.live_after_ui_root_group)");
    this.ngh = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBL);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.back_icon)");
    this.nfU = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBx);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.a…_after_live_replay_group)");
    this.CTE = paramb;
    paramb = paramViewGroup.findViewById(p.e.BWn);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.l…after_live_replay_switch)");
    this.CTF = ((MMSwitchBtn)paramb);
    paramb = paramViewGroup.findViewById(p.e.BBw);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.a…_after_common_info_panel)");
    this.CTG = ((RecyclerView)paramb);
    this.CTH = new b(new ArrayList());
    paramb = this.titleTv.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(354578);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.topMargin += bf.getStatusBarHeight(MMApplicationContext.getContext());
    aw.a((Paint)this.titleTv.getPaint(), 0.8F);
    this.nfU.setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_filled_close, -1));
    this.nfU.setOnClickListener(new g..ExternalSyntheticLambda0(this));
    paramb = this.CTG;
    paramb.setAdapter((RecyclerView.a)this.CTH);
    paramb.a((RecyclerView.h)new d(bd.fromDPToPix(paramViewGroup.getContext(), 24)));
    paramb.setLayoutManager((RecyclerView.LayoutManager)new FinderLiveAnchorAfterPlugin.2.1(paramViewGroup.getContext(), this.CTC));
    AppMethodBeat.o(354578);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(354613);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    paramg.ngl.statusChange(b.c.ncl, null);
    if (paramg.ngl.getLiveRole() == 1)
    {
      paramg = j.Dob;
      j.a(q.g.Dso, "");
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354613);
  }
  
  private static final void a(g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(354622);
    kotlin.g.b.s.u(paramg, "this$0");
    paramg.qY(paramBoolean);
    AppMethodBeat.o(354622);
  }
  
  private static final void b(g paramg, View paramView)
  {
    AppMethodBeat.i(354636);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    paramView = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
    kotlin.g.b.s.s(paramView, "service(IActivityRouter::class.java)");
    paramView = (com.tencent.mm.plugin.f)paramView;
    paramg = paramg.mJe.getContext();
    kotlin.g.b.s.s(paramg, "root.context");
    f.a.a(paramView, paramg, 3);
    com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(3), Integer.valueOf(2), Long.valueOf(cn.bDw()), z.bAW() });
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354636);
  }
  
  private static final void bi(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(354646);
    parama.invoke();
    AppMethodBeat.o(354646);
  }
  
  private final void eoO()
  {
    AppMethodBeat.i(354588);
    com.tencent.mm.plugin.finder.live.util.g localg = com.tencent.mm.plugin.finder.live.util.g.DIp;
    com.tencent.mm.plugin.finder.live.util.g.a(((e)business(e.class)).mIC, ((e)business(e.class)).eyo(), (View)this.ngh);
    AppMethodBeat.o(354588);
  }
  
  private final void qY(boolean paramBoolean)
  {
    AppMethodBeat.i(354604);
    w localw = w.a(this.mJe.getContext(), (CharSequence)this.mJe.getContext().getString(p.h.app_waiting), false, 3, null);
    auw localauw = new auw();
    localauw.cmdId = 0;
    bjt localbjt = new bjt();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbjt.ZTi = i;
      ah localah = ah.aiuX;
      localauw.ZFn = com.tencent.mm.bx.b.cX(localbjt.toByteArray());
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)new com.tencent.mm.plugin.finder.live.model.cgi.aj(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, 0, localauw).bFJ(), (kotlin.g.a.b)new g.f(localw));
      Log.i(this.TAG, kotlin.g.b.s.X("setReplay replayLive:", Boolean.valueOf(paramBoolean)));
      AppMethodBeat.o(354604);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.live.viewmodel.data.a parama)
  {
    AppMethodBeat.i(354775);
    kotlin.g.b.s.u(parama, "info");
    Log.i(this.TAG, "updateFinishInfo");
    Object localObject1 = this.ngb;
    Object localObject2 = new StringBuilder().append(this.mJe.getContext().getResources().getString(p.h.CjR)).append(' ');
    r.a locala = r.mZi;
    ((TextView)localObject1).setText((CharSequence)r.a.a(parama.duration, ":", false, false, false, 28));
    this.CTH.pUj.clear();
    localObject1 = this.CTH.pUj;
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyj())
    {
      Log.i(this.TAG, kotlin.g.b.s.X("add charge live:", Integer.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eym())));
      i = this.CTB;
      l = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eym();
      localObject2 = this.mJe.getContext().getResources().getString(p.h.ChL);
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…_live_after_charge_title)");
      ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    }
    int i = this.CTu;
    long l = parama.Ebh;
    localObject2 = this.mJe.getContext().getResources().getString(p.h.ChQ);
    kotlin.g.b.s.s(localObject2, "root.context.resources.g…live_after_visitor_title)");
    ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    i = this.CTv;
    l = parama.Ebk;
    localObject2 = this.mJe.getContext().getResources().getString(p.h.ChP);
    kotlin.g.b.s.s(localObject2, "root.context.resources.g…_live_after_online_title)");
    ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    i = this.CTw;
    l = parama.Ebl;
    localObject2 = this.mJe.getContext().getResources().getString(p.h.ChJ);
    kotlin.g.b.s.s(localObject2, "root.context.resources.g…after_avg_duration_title)");
    ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    if (((e)business(e.class)).Ecy)
    {
      i = this.CTx;
      l = parama.DFW;
      localObject2 = this.mJe.getContext().getResources().getString(p.h.ChM);
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…er_live_after_like_title)");
      ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).Ecg)
    {
      i = this.CTA;
      l = parama.Ebn;
      localObject2 = this.mJe.getContext().getResources().getString(p.h.ChN);
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…ter_new_biz_follow_title)");
      ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    }
    for (;;)
    {
      if (((e)business(e.class)).Edv)
      {
        i = this.CTz;
        l = parama.Ebj;
        localObject2 = this.mJe.getContext().getResources().getString(p.h.ChR);
        kotlin.g.b.s.s(localObject2, "root.context.resources.g…e_after_wecoin_hot_title)");
        ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2, parama.Ebm));
      }
      this.CTH.bZE.notifyChanged();
      parama = this.TAG;
      localObject1 = new StringBuilder("prepareReplayPanel liveInfo:");
      localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      Log.i(parama, com.tencent.mm.plugin.finder.live.view.convert.a.c(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo) + ", haveJoinLive:" + ((e)business(e.class)).EcA);
      if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.d)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.class)).eyj()) || (!((e)business(e.class)).EcA)) {
        break;
      }
      this.CTE.setVisibility(0);
      this.CTF.setCheck(true);
      qY(true);
      this.CTF.setSwitchListener(new g..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(354775);
      return;
      i = this.CTy;
      l = parama.Ebi;
      localObject2 = this.mJe.getContext().getResources().getString(p.h.ChO);
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…e_after_new_follow_title)");
      ((ArrayList)localObject1).add(new g.a(i, l, (CharSequence)localObject2));
    }
    this.CTE.setVisibility(8);
    AppMethodBeat.o(354775);
  }
  
  public final void bh(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(354802);
    if (!this.CTI)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.n(getBuContext())) {}
    }
    else
    {
      this.mJe.setAlpha(0.0F);
      tO(0);
      this.nfU.setVisibility(0);
      this.mJe.animate().alpha(1.0F).setDuration(300L).withEndAction(new g..ExternalSyntheticLambda3(parama)).start();
    }
    for (;;)
    {
      if (this.ngl.getLiveRole() == 1)
      {
        parama = j.Dob;
        j.a(q.g.Dsm, "");
      }
      parama = com.tencent.mm.plugin.finder.api.d.AwY;
      if (!d.a.auX("Entrance_LiveComplete")) {
        break;
      }
      this.CTD.setVisibility(0);
      com.tencent.mm.plugin.report.service.h.OAn.b(22748, new Object[] { Integer.valueOf(3), Integer.valueOf(1), Long.valueOf(cn.bDw()), z.bAW() });
      this.CTD.setOnClickListener(new g..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(354802);
      return;
      tO(0);
      this.nfU.setVisibility(0);
      parama.invoke();
    }
    this.CTD.setVisibility(8);
    AppMethodBeat.o(354802);
  }
  
  public final void eoN()
  {
    AppMethodBeat.i(354791);
    this.ngh.setBackgroundColor(this.mJe.getContext().getResources().getColor(p.b.ByY));
    if (((e)business(e.class)).mIC != null)
    {
      localObject = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject = d.a.auT(((e)business(e.class)).mIC);
      if (localObject != null) {
        break label95;
      }
    }
    label95:
    for (Object localObject = null;; localObject = ((m)localObject).field_avatarUrl)
    {
      if (Util.isNullOrNil((String)localObject)) {
        break label103;
      }
      eoO();
      AppMethodBeat.o(354791);
      return;
      localObject = null;
      break;
    }
    label103:
    Log.i(this.TAG, "update bg fail,contact is null!");
    com.tencent.mm.kernel.h.baD().mCm.a(3736, (com.tencent.mm.am.h)this);
    localObject = com.tencent.mm.plugin.finder.live.model.aj.CGT;
    localObject = com.tencent.mm.plugin.finder.live.model.aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((ap)localObject).aws(((e)business(e.class)).mIC);
    }
    AppMethodBeat.o(354791);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(354841);
    if (this.ngl.getLiveRole() == 1)
    {
      j localj = j.Dob;
      j.a(q.g.Dso, "");
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(354841);
    return bool;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(354814);
    Log.i(this.TAG, "onSceneEnd errType:" + paramInt1 + ", errCode:" + paramInt2 + ", scene:" + paramp);
    FinderContact localFinderContact;
    String str;
    StringBuilder localStringBuilder;
    if ((paramp instanceof com.tencent.mm.plugin.api.a))
    {
      localFinderContact = ((com.tencent.mm.plugin.api.a)paramp).caK();
      str = this.TAG;
      localStringBuilder = new StringBuilder("update bg,user page isOnlyFetchUserInfo:").append(((com.tencent.mm.plugin.api.a)paramp).caL()).append(", local username:").append(((e)business(e.class)).mIC).append(",req username:").append(((com.tencent.mm.plugin.api.a)paramp).caM()).append("，contact username:");
      if (localFinderContact != null) {
        break label252;
      }
    }
    label252:
    for (paramString = null;; paramString = localFinderContact.username)
    {
      Log.i(str, paramString);
      if ((((com.tencent.mm.plugin.api.a)paramp).caL()) && (kotlin.g.b.s.p(((com.tencent.mm.plugin.api.a)paramp).caM(), ((e)business(e.class)).mIC)))
      {
        com.tencent.mm.kernel.h.baD().mCm.b(3736, (com.tencent.mm.am.h)this);
        if ((localFinderContact != null) && (localFinderContact.headUrl != null)) {
          eoO();
        }
      }
      AppMethodBeat.o(354814);
      return;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(354825);
    kotlin.g.b.s.u(paramc, "status");
    if (e.$EnumSwitchMapping$0[paramc.ordinal()] == 1) {
      if (paramBundle != null) {
        break label43;
      }
    }
    label43:
    for (boolean bool = false;; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL"))
    {
      this.CTI = bool;
      AppMethodBeat.o(354825);
      return;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(354832);
    super.unMount();
    com.tencent.mm.kernel.h.baD().mCm.b(3736, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(354832);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfo;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<g.c>
  {
    final ArrayList<g.a> pUj;
    
    public b()
    {
      AppMethodBeat.i(354945);
      this.pUj = localObject;
      AppMethodBeat.o(354945);
    }
    
    private static final void c(g paramg, View paramView)
    {
      AppMethodBeat.i(354953);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramg, "this$0");
      paramView = new Intent();
      paramView.putExtra("PARAM_FINDER_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      localObject = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      paramg = paramg.mJe.getContext();
      kotlin.g.b.s.s(paramg, "root.context");
      ((com.tencent.mm.plugin.f)localObject).r(paramg, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354953);
    }
    
    private static final void d(g paramg, View paramView)
    {
      AppMethodBeat.i(354963);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramg);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(paramg, "this$0");
      ((e)paramg.business(e.class)).EcI = false;
      paramView = new Intent();
      paramView.putExtra("KEY_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      paramView.putExtra("KEY_OBJECT_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
      paramView.putExtra("KEY_OBJECT_NONCE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView.putExtra("KEY_IF_USE_NEW_VALUE", com.tencent.mm.plugin.finder.live.utils.a.a((e)paramg.business(e.class)));
      localObject1 = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      localObject2 = paramg.mJe.getContext();
      kotlin.g.b.s.s(localObject2, "root.context");
      ((com.tencent.mm.plugin.f)localObject1).s((Context)localObject2, paramView);
      if (g.i(paramg).getLiveRole() == 1)
      {
        paramg = j.Dob;
        j.a(q.g.Dsn, String.valueOf(q.m.Dtk.action));
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354963);
    }
    
    private static final void e(g paramg, View paramView)
    {
      AppMethodBeat.i(354977);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramg);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramg, "this$0");
      ((e)paramg.business(e.class)).EcI = false;
      paramView = new Intent();
      paramView.putExtra("KEY_LIVE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId);
      paramView.putExtra("KEY_OBJECT_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN);
      paramView.putExtra("KEY_OBJECT_NONCE_ID", ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramg.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).nonceId);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      paramView.putExtra("KEY_IF_USE_NEW_VALUE", com.tencent.mm.plugin.finder.live.utils.a.a((e)paramg.business(e.class)));
      localObject = (com.tencent.mm.plugin.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      paramg = paramg.mJe.getContext();
      kotlin.g.b.s.s(paramg, "root.context");
      ((com.tencent.mm.plugin.f)localObject).t(paramg, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354977);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(355006);
      int i = this.pUj.size();
      AppMethodBeat.o(355006);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$CommonInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "arrowIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getArrowIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "valueTv", "getValueTv", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.v
  {
    final TextView titleTv;
    final TextView tug;
    final WeImageView wEX;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(354924);
      this.titleTv = ((TextView)paramView.findViewById(p.e.BBu));
      this.tug = ((TextView)paramView.findViewById(p.e.BBv));
      this.wEX = ((WeImageView)paramView.findViewById(p.e.BBt));
      AppMethodBeat.o(354924);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin$GridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "rowSpacing", "", "(Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorAfterPlugin;I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends RecyclerView.h
  {
    private final int CTL;
    
    public d()
    {
      AppMethodBeat.i(354914);
      int i;
      this.CTL = i;
      AppMethodBeat.o(354914);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(354926);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView != null)
      {
        params = g.this;
        int i = paramRecyclerView.getItemCount();
        int j = RecyclerView.bA(paramView);
        if (i % g.j(params) == 0) {
          i /= g.j(params);
        }
        while ((i > 1) && (j < (i - 1) * g.j(params)))
        {
          paramRect.bottom = this.CTL;
          AppMethodBeat.o(354926);
          return;
          i = i / g.j(params) + 1;
        }
        paramRect.bottom = 0;
      }
      AppMethodBeat.o(354926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.g
 * JD-Core Version:    0.7.0.1
 */