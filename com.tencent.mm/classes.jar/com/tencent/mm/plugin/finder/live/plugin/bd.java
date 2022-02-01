package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.g;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q;
import com.tencent.mm.plugin.finder.live.report.q.aw;
import com.tencent.mm.plugin.finder.live.report.q.bm;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.cc;
import com.tencent.mm.plugin.finder.live.view.adapter.w;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bim;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.k.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Lcom.tencent.mm.protocal.protobuf.blq;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DEFAULT_PANEL_HEIGHT", "", "getDEFAULT_PANEL_HEIGHT", "()I", "setDEFAULT_PANEL_HEIGHT", "(I)V", "DEFAULT_TITLE_GROUP_HEIGHT", "getDEFAULT_TITLE_GROUP_HEIGHT", "setDEFAULT_TITLE_GROUP_HEIGHT", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "PORTRAIT_ACTION_KEY_FINDER_USERNAME", "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_BLACK_LIST", "SHEET_MORE_ACTION_GOTO_PROFILE", "SHEET_MORE_ACTION_RECOVER_COMMENT", "SHEET_MORE_ACTION_REPORT", "SHEET_REMOVE", "TAG", "backGroup", "Landroid/view/View;", "blankArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "curSelectedContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "diffRewardMember", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;", "Lkotlin/collections/ArrayList;", "emptyActionTip", "Landroid/widget/TextView;", "emptyGroup", "emptyTip", "helpIcon", "kickMemberBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "loadingBar", "Landroid/widget/ProgressBar;", "membersAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "moreActionBottomSheet", "moreActionItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "recyclerRoot", "Landroid/widget/RelativeLayout;", "retryTip", "singleRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "singleTitleTv", "stickViewContainer", "subTitleLine", "titleGroup", "titleTipTv", "visibilityTipTv", "adjustPanelLayout", "", "titleGroupHeight", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "buildConfirmDialog", "title", "item", "titleColor", "itemColor", "click", "Lkotlin/Function0;", "remote", "Ljava/util/LinkedList;", "doCommentAction", "enableComment", "", "goToFinderProfile", "finderUsername", "hideMembersList", "initListener", "initTitleGroupHeight", "isAnchorOrAssistant", "kickMember", "mount", "onBackPress", "onGetLiveOnlineMemberFail", "onGetLiveOnlineMemberSuccess", "autoRefresh", "onPortraitDelayAction", "extraData", "", "delayMs", "", "prepareMenuItems", "menuItem", "Lcom/tencent/mm/ui/base/MMMenu;", "roleType", "showMembersListContent", "showMembersListLoading", "showMoreActionSheet", "showProfileSheet", "username", "showTitle", "totalCnt", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "uninitListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
  extends b
{
  private int CwP;
  private final String DeM;
  private final String DeN;
  private final int DeO;
  private final int DeP;
  private final int DeQ;
  private final int DeR;
  private final int DeS;
  private int DeT;
  private final View DeU;
  private final TextView DeV;
  final View DeW;
  private final RelativeLayout DeX;
  private final View DeY;
  private final TextView DeZ;
  private final TextView Dfa;
  private final View Dfb;
  private final View Dfc;
  private final w Dfd;
  private bgh Dfe;
  private com.tencent.mm.ui.widget.a.f Dff;
  private com.tencent.mm.ui.widget.a.f Dfg;
  private ArrayList<blq> Dfh;
  private u.i Dfi;
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private final int niO;
  private final View niW;
  private final LiveBottomSheetPanel niX;
  private final TextView njf;
  final TextView njg;
  private final TextView njh;
  final RecyclerView nji;
  final ProgressBar njj;
  final View njm;
  
  public bd(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355156);
    this.nfT = paramb;
    this.TAG = "Finder.FinderLiveMemberListPlugin";
    this.DeM = "PORTRAIT_ACTION_GOTO_PROFILE_MEMBERLIST";
    this.DeN = "PORTRAIT_ACTION_KEY_FINDER_USERNAME";
    this.niO = 1;
    this.DeO = 10;
    this.DeP = 11;
    this.DeQ = 12;
    this.DeR = 13;
    this.DeS = 14;
    float f = bf.bf(MMApplicationContext.getContext()).y;
    paramb = com.tencent.d.a.a.a.a.a.ahiX;
    this.CwP = ((int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F)));
    paramb = paramViewGroup.findViewById(p.e.BNQ);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…bers_list_icon_btn_group)");
    this.DeU = paramb;
    paramb = paramViewGroup.findViewById(p.e.BNW);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ve_members_list_title_tv)");
    this.njf = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNS);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…e_members_list_retry_tip)");
    this.njg = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNN);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…e_members_list_empty_tip)");
    this.njh = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNM);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…rs_list_empty_action_tip)");
    this.DeV = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNO);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ers_list_empty_tip_group)");
    this.DeW = paramb;
    paramb = paramViewGroup.findViewById(p.e.BNL);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…embers_list_content_view)");
    this.nji = ((RecyclerView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNJ);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…embers_list_content_area)");
    this.niX = ((LiveBottomSheetPanel)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNK);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…mbers_list_content_group)");
    this.DeX = ((RelativeLayout)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNR);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…ive_members_list_loading)");
    this.njj = ((ProgressBar)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNI);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…_members_list_blank_area)");
    this.niW = paramb;
    paramb = paramViewGroup.findViewById(p.e.BNP);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…e_members_list_help_icon)");
    this.DeY = paramb;
    paramb = paramViewGroup.findViewById(p.e.BNV);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…embers_list_title_tip_tv)");
    this.DeZ = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNX);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…s_list_visibility_tip_tv)");
    this.Dfa = ((TextView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BNG);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…e_member_stick_container)");
    this.Dfb = paramb;
    paramb = paramViewGroup.findViewById(p.e.BNT);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…mbers_list_subtitle_line)");
    this.Dfc = paramb;
    this.Dfd = new w(this.nji, this.Dfb, (e)business(e.class));
    paramb = paramViewGroup.findViewById(p.e.BNU);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…members_list_title_group)");
    this.njm = paramb;
    this.Dfh = new ArrayList();
    this.Dfi = new bd..ExternalSyntheticLambda6(this, paramViewGroup);
    paramb = this.njm.getLayoutParams();
    if (paramb == null) {}
    int j;
    for (int i = 0;; i = paramb.height)
    {
      this.DeT = i;
      if (this.DeT <= 0) {
        this.DeT = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      }
      Log.i(this.TAG, kotlin.g.b.s.X("initTitleGroupHeight:", Integer.valueOf(this.DeT)));
      paramb = this.nji;
      paramViewGroup.getContext();
      paramb.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      this.nji.setAdapter((RecyclerView.a)this.Dfd);
      i = this.DeT;
      j = bf.bk(this.mJe.getContext());
      if (isLandscape()) {
        break label868;
      }
      this.niX.setTranslationY(bf.bf(this.mJe.getContext()).y);
      this.niX.getLayoutParams().height = this.CwP;
      paramViewGroup = this.DeX.getLayoutParams();
      if (paramViewGroup != null) {
        break;
      }
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(355156);
      throw paramViewGroup;
    }
    paramViewGroup = (ViewGroup.MarginLayoutParams)paramViewGroup;
    paramViewGroup.bottomMargin += j;
    this.DeX.getLayoutParams().height = (this.CwP - i - j);
    for (this.nji.getLayoutParams().height = (this.CwP - i - j);; this.nji.getLayoutParams().height = (bf.bf(this.mJe.getContext()).y - i))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if ((com.tencent.mm.plugin.finder.live.utils.a.a((e)business(e.class))) && (!eqc())) {
        this.njh.setText(this.njh.getContext().getText(p.h.CkR));
      }
      aw.a((Paint)this.njf.getPaint(), 0.8F);
      AppMethodBeat.o(355156);
      return;
      label868:
      this.niX.getLayoutParams().width = bf.bf(this.mJe.getContext()).y;
      this.niX.setTranslationX(bf.bf(this.mJe.getContext()).x);
      this.DeX.getLayoutParams().height = (bf.bf(this.mJe.getContext()).y - i);
    }
  }
  
  private final void Pb(int paramInt)
  {
    AppMethodBeat.i(355175);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    long l;
    label253:
    int i;
    if (((eqc()) && (((e)((e)business(e.class)).business(e.class)).Edv)) || (((e)((e)business(e.class)).business(e.class)).Edw)) {
      label409:
      if (((e)((e)business(e.class)).business(e.class)).eyr())
      {
        this.DeZ.setVisibility(8);
        this.DeY.setVisibility(0);
        localObject1 = am.aixg;
        localObject1 = this.mJe.getContext().getString(p.h.finder_live_members_total_tip);
        kotlin.g.b.s.s(localObject1, "root.context.getString(R…r_live_members_total_tip)");
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((e)business(e.class)).EcL) }, 1));
        kotlin.g.b.s.s(localObject1, "java.lang.String.format(format, *args)");
        localObject2 = am.aixg;
        localObject2 = this.mJe.getContext().getString(p.h.CtR);
        kotlin.g.b.s.s(localObject2, "root.context.getString(R…ive_wecoin_amount_in_hot)");
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo);
        if (localObject3 != null) {
          break label536;
        }
        l = 0L;
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(l) }, 1));
        kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
        this.njf.setText((CharSequence)((String)localObject1 + " · " + (String)localObject2));
        label319:
        if (eqc())
        {
          if ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis == 0) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis == 524288)) {
            break label712;
          }
          this.Dfa.setText((CharSequence)MMApplicationContext.getContext().getResources().getString(p.h.Ctw));
          this.Dfa.setVisibility(0);
          i = this.DeT;
          paramInt = i;
          if (this.Dfa.getVisibility() == 0)
          {
            paramInt = i;
            if (this.DeZ.getVisibility() == 0) {
              paramInt = this.DeT + MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
            }
          }
          if ((this.DeZ.getVisibility() != 0) || (this.Dfa.getVisibility() != 0)) {
            break label724;
          }
          this.Dfc.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      this.njm.getLayoutParams().height = paramInt;
      AppMethodBeat.o(355175);
      return;
      this.DeZ.setText((CharSequence)this.mJe.getContext().getString(p.h.CkL));
      this.DeZ.setVisibility(0);
      break;
      label536:
      l = ((Long)localObject3).longValue();
      break label253;
      this.DeZ.setVisibility(8);
      this.DeY.setVisibility(8);
      localObject1 = this.mJe.getContext().getResources();
      i = p.h.finder_live_members_total_tip;
      localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject1 = ((Resources)localObject1).getString(i, new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(paramInt) });
      kotlin.g.b.s.s(localObject1, "root.context.resources.g…umber(totalCnt.toLong()))");
      localObject2 = this.mJe.getContext().getResources();
      paramInt = p.h.Cnq;
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject2 = ((Resources)localObject2).getString(paramInt, new Object[] { com.tencent.mm.plugin.finder.live.utils.a.jp(((o)business(o.class)).EhT) });
      kotlin.g.b.s.s(localObject2, "root.context.resources.g…ineMemberCount.toLong()))");
      this.njf.setText((CharSequence)((String)localObject1 + " · " + (String)localObject2));
      break label319;
      label712:
      this.Dfa.setVisibility(8);
      break label409;
      label724:
      this.Dfc.setVisibility(8);
    }
  }
  
  private static final void a(int paramInt1, bd parambd, int paramInt2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355305);
    kotlin.g.b.s.u(parambd, "this$0");
    params.clear();
    if (paramInt1 == 0)
    {
      params.c(parambd.niO, (CharSequence)parambd.mJe.getContext().getResources().getString(paramInt2));
      AppMethodBeat.o(355305);
      return;
    }
    params.a(parambd.niO, parambd.mJe.getContext().getResources().getColor(paramInt1), (CharSequence)parambd.mJe.getContext().getResources().getString(paramInt2));
    AppMethodBeat.o(355305);
  }
  
  private static final void a(bd parambd, int paramInt, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(355242);
    kotlin.g.b.s.u(parambd, "this$0");
    params.clear();
    kotlin.g.b.s.s(params, "it");
    if (paramInt == 3) {
      params.c(parambd.DeS, (CharSequence)parambd.mJe.getContext().getResources().getString(p.h.CtE));
    }
    params.c(parambd.DeR, (CharSequence)parambd.mJe.getContext().getResources().getString(p.h.finder_live_more_action_report));
    AppMethodBeat.o(355242);
  }
  
  private static final void a(bd parambd, Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(355353);
    kotlin.g.b.s.u(parambd, "this$0");
    if (!parambd.isFinished())
    {
      paramBundle = aj.CGT;
      paramBundle = aj.getFinderLiveAssistant();
      if (paramBundle != null)
      {
        paramBundle.m(paramObject, parambd.DeN);
        AppMethodBeat.o(355353);
      }
    }
    else
    {
      Log.i(parambd.TAG, "goToFinderProfileImpl delayMs:" + paramLong + ",isFinished!");
    }
    AppMethodBeat.o(355353);
  }
  
  private static final void a(bd parambd, View paramView)
  {
    AppMethodBeat.i(355259);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.niX.hide();
    if (parambd.nfT.getLiveRole() == 1) {
      j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBx.action));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355259);
  }
  
  private static final void a(bd parambd, ViewGroup paramViewGroup, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(355229);
    kotlin.g.b.s.u(parambd, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    if (paramMenuItem == null)
    {
      paramMenuItem = null;
      paramInt = parambd.DeO;
      if (paramMenuItem != null) {
        break label104;
      }
      label35:
      paramInt = parambd.DeP;
      if (paramMenuItem != null) {
        break label275;
      }
      label44:
      paramInt = parambd.DeQ;
      if (paramMenuItem != null) {
        break label446;
      }
      label53:
      paramInt = parambd.DeR;
      if (paramMenuItem != null) {
        break label727;
      }
      label62:
      paramInt = parambd.DeS;
      if (paramMenuItem != null) {
        break label985;
      }
    }
    label104:
    while (paramMenuItem.intValue() != paramInt)
    {
      parambd = parambd.Dff;
      if (parambd != null) {
        parambd.cyW();
      }
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(355229);
              return;
              paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
              break;
              if (paramMenuItem.intValue() != paramInt) {
                break label35;
              }
              parambd.rs(false);
              paramViewGroup = parambd.Dff;
              if (paramViewGroup != null) {
                paramViewGroup.cyW();
              }
            } while (parambd.nfT.getLiveRole() != 1);
            paramViewGroup = j.Dob;
            paramViewGroup = j.Doc.Dqq;
            paramViewGroup.DGf += 1L;
            paramMenuItem = new JSONObject();
            paramInt = q.aw.DzZ.action;
            parambd = parambd.Dfe;
            if (parambd == null) {
              parambd = "";
            }
            for (;;)
            {
              paramMenuItem.put(String.valueOf(paramInt), parambd);
              parambd = q.c.Drk;
              paramViewGroup = j.Dob;
              if (j.Doc.Dqt) {
                parambd = q.c.Drm;
              }
              j.Dob.a(parambd, paramMenuItem.toString());
              AppMethodBeat.o(355229);
              return;
              parambd = parambd.contact;
              if (parambd == null)
              {
                parambd = "";
              }
              else
              {
                paramViewGroup = parambd.username;
                parambd = paramViewGroup;
                if (paramViewGroup == null) {
                  parambd = "";
                }
              }
            }
            if (paramMenuItem.intValue() != paramInt) {
              break label44;
            }
            parambd.rs(true);
            paramViewGroup = parambd.Dff;
            if (paramViewGroup != null) {
              paramViewGroup.cyW();
            }
          } while (parambd.nfT.getLiveRole() != 1);
          paramViewGroup = j.Dob;
          paramViewGroup = j.Doc.Dqq;
          paramViewGroup.DGg += 1L;
          paramMenuItem = new JSONObject();
          paramInt = q.aw.DAa.action;
          parambd = parambd.Dfe;
          if (parambd == null) {
            parambd = "";
          }
          for (;;)
          {
            paramMenuItem.put(String.valueOf(paramInt), parambd);
            parambd = q.c.Drk;
            paramViewGroup = j.Dob;
            if (j.Doc.Dqt) {
              parambd = q.c.Drm;
            }
            j.Dob.a(parambd, paramMenuItem.toString());
            AppMethodBeat.o(355229);
            return;
            parambd = parambd.contact;
            if (parambd == null)
            {
              parambd = "";
            }
            else
            {
              paramViewGroup = parambd.username;
              parambd = paramViewGroup;
              if (paramViewGroup == null) {
                parambd = "";
              }
            }
          }
          if (paramMenuItem.intValue() != paramInt) {
            break label53;
          }
          paramInt = p.h.Crh;
          int i = p.h.Crg;
          int j = p.b.live_title_host_close_btn_color;
          paramViewGroup = (kotlin.g.a.a)new g(parambd);
          if (parambd.Dfg == null)
          {
            parambd.Dfg = new com.tencent.mm.ui.widget.a.f(parambd.mJe.getContext(), 1, true);
            paramMenuItem = parambd.Dfg;
            if (paramMenuItem != null) {
              paramMenuItem.NyV = true;
            }
            paramMenuItem = View.inflate(parambd.mJe.getContext(), p.f.live_bottom_sheet_title_view, null);
            ((TextView)paramMenuItem.findViewById(p.e.live_bottom_sheet_title_tv)).setText((CharSequence)parambd.mJe.getContext().getString(paramInt));
            localObject = parambd.Dfg;
            if (localObject != null) {
              ((com.tencent.mm.ui.widget.a.f)localObject).af(paramMenuItem, false);
            }
            paramMenuItem = parambd.Dfg;
            if (paramMenuItem != null) {
              paramMenuItem.aeLi = bd..ExternalSyntheticLambda10.INSTANCE;
            }
          }
          paramMenuItem = parambd.Dfg;
          if (paramMenuItem != null) {
            paramMenuItem.NE(true);
          }
          paramMenuItem = parambd.Dfg;
          if (paramMenuItem != null) {
            paramMenuItem.setFooterView(null);
          }
          paramMenuItem = parambd.Dfg;
          if (paramMenuItem != null) {
            paramMenuItem.Vtg = new bd..ExternalSyntheticLambda4(j, parambd, i);
          }
          paramMenuItem = parambd.Dfg;
          if (paramMenuItem != null) {
            paramMenuItem.GAC = new bd..ExternalSyntheticLambda7(parambd, paramViewGroup);
          }
          paramViewGroup = parambd.Dfg;
          if (paramViewGroup != null) {
            paramViewGroup.aeLi = new bd..ExternalSyntheticLambda8(parambd);
          }
          paramViewGroup = parambd.Dfg;
          if (paramViewGroup != null) {
            paramViewGroup.dDn();
          }
          parambd = parambd.Dff;
        } while (parambd == null);
        parambd.cyW();
        AppMethodBeat.o(355229);
        return;
        if (paramMenuItem.intValue() != paramInt) {
          break label62;
        }
        paramMenuItem = parambd.Dfe;
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.username;
            if (paramMenuItem != null)
            {
              localObject = aj.CGT;
              localObject = aj.getFinderLiveAssistant();
              if (localObject != null)
              {
                paramViewGroup = paramViewGroup.getContext();
                kotlin.g.b.s.s(paramViewGroup, "root.context");
                ((ap)localObject).a(paramViewGroup, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((e)parambd.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, paramMenuItem, Long.valueOf(0L));
              }
            }
          }
        }
        paramViewGroup = parambd.Dff;
        if (paramViewGroup != null) {
          paramViewGroup.cyW();
        }
      } while (parambd.nfT.getLiveRole() != 1);
      paramViewGroup = j.Dob;
      paramViewGroup = j.Doc.Dqq;
      paramViewGroup.DGc += 1L;
      paramMenuItem = new JSONObject();
      paramInt = q.aw.DAb.action;
      parambd = parambd.Dfe;
      if (parambd == null) {
        parambd = "";
      }
      for (;;)
      {
        paramMenuItem.put(String.valueOf(paramInt), parambd);
        parambd = q.c.Drk;
        paramViewGroup = j.Dob;
        if (j.Doc.Dqt) {
          parambd = q.c.Drm;
        }
        j.Dob.a(parambd, paramMenuItem.toString());
        AppMethodBeat.o(355229);
        return;
        parambd = parambd.contact;
        if (parambd == null)
        {
          parambd = "";
        }
        else
        {
          paramViewGroup = parambd.username;
          parambd = paramViewGroup;
          if (paramViewGroup == null) {
            parambd = "";
          }
        }
      }
    }
    label275:
    label446:
    label727:
    label985:
    paramViewGroup = parambd.Dfe;
    if (paramViewGroup == null)
    {
      paramViewGroup = null;
      paramMenuItem = (CharSequence)paramViewGroup;
      if ((paramMenuItem != null) && (paramMenuItem.length() != 0)) {
        break label1071;
      }
    }
    label1071:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label1076;
      }
      Log.i(parambd.TAG, kotlin.g.b.s.X("goToFinderProfile finderUsername:", paramViewGroup));
      AppMethodBeat.o(355229);
      return;
      paramViewGroup = paramViewGroup.contact;
      if (paramViewGroup == null)
      {
        paramViewGroup = null;
        break;
      }
      paramViewGroup = paramViewGroup.username;
      break;
    }
    label1076:
    if (parambd.nfT.getLiveRole() == 0) {
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cc.DEG, "", 0);
    }
    boolean bool = parambd.isLandscape();
    Log.i(parambd.TAG, kotlin.g.b.s.X("goToFinderProfile isLandscape:", Boolean.valueOf(bool)));
    if (bool)
    {
      paramMenuItem = new Bundle();
      paramMenuItem.putString(parambd.DeN, paramViewGroup);
      b.a((b)parambd, parambd.DeM, paramMenuItem, 0, 4);
      AppMethodBeat.o(355229);
      return;
    }
    paramMenuItem = g.CEN;
    paramMenuItem = parambd.mJe.getContext();
    Object localObject = parambd.getBuContext();
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    parambd = parambd.mJe.getContext();
    kotlin.g.b.s.s(parambd, "root.context");
    g.a(paramMenuItem, (com.tencent.mm.plugin.finder.live.model.context.a)localObject, false, paramViewGroup, ((bn)com.tencent.mm.ui.component.k.nq(parambd).cq(bn.class)).fou());
    AppMethodBeat.o(355229);
  }
  
  private static final void a(bd parambd, kotlin.g.a.a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(355319);
    kotlin.g.b.s.u(parambd, "this$0");
    kotlin.g.b.s.u(parama, "$click");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    if (paramMenuItem.getItemId() == parambd.niO)
    {
      parama.invoke();
      parama = parambd.Dfg;
      if (parama != null) {
        parama.cyW();
      }
      if (parambd.nfT.getLiveRole() == 1)
      {
        parama = j.Dob;
        parama = j.Doc.Dqq;
        parama.DGh += 1L;
        paramMenuItem = new JSONObject();
        paramInt = q.aw.DAc.action;
        parambd = parambd.Dfe;
        if (parambd == null) {
          parambd = "";
        }
        for (;;)
        {
          paramMenuItem.put(String.valueOf(paramInt), parambd);
          parambd = q.c.Drk;
          parama = j.Dob;
          if (j.Doc.Dqt) {
            parambd = q.c.Drm;
          }
          j.Dob.a(parambd, paramMenuItem.toString());
          AppMethodBeat.o(355319);
          return;
          parambd = parambd.contact;
          if (parambd == null)
          {
            parambd = "";
          }
          else
          {
            parama = parambd.username;
            parambd = parama;
            if (parama == null) {
              parambd = "";
            }
          }
        }
      }
    }
    else
    {
      parambd = parambd.Dfg;
      if (parambd != null) {
        parambd.cyW();
      }
    }
    AppMethodBeat.o(355319);
  }
  
  private final ArrayList<blq> ar(LinkedList<blq> paramLinkedList)
  {
    AppMethodBeat.i(355193);
    ArrayList localArrayList = new ArrayList();
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    Object localObject2;
    Object localObject1;
    while (paramLinkedList.hasNext())
    {
      localObject2 = (blq)paramLinkedList.next();
      localObject1 = new blq();
      ((blq)localObject1).parseFrom(((blq)localObject2).toByteArray());
      localObject2 = ah.aiuX;
      localArrayList.add(localObject1);
    }
    int i;
    Iterator localIterator1;
    if (!((Collection)((e)business(e.class)).EeD).isEmpty())
    {
      i = 1;
      if (i != 0) {
        localIterator1 = ((Iterable)((e)business(e.class)).EeD).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label568;
        }
        blq localblq = (blq)localIterator1.next();
        Iterator localIterator2 = ((Iterable)localArrayList).iterator();
        label168:
        label204:
        label221:
        label233:
        Object localObject3;
        label268:
        cxk localcxk1;
        if (localIterator2.hasNext())
        {
          localObject2 = localIterator2.next();
          paramLinkedList = ((blq)localObject2).Ddj;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            localObject1 = localblq.Ddj;
            if (localObject1 != null) {
              break label464;
            }
            localObject1 = "";
            if (!kotlin.g.b.s.p(paramLinkedList, localObject1)) {
              break label506;
            }
            paramLinkedList = (LinkedList<blq>)localObject2;
            localObject3 = (blq)paramLinkedList;
            if (localObject3 == null) {
              continue;
            }
            paramLinkedList = ((blq)localObject3).nUC;
            kotlin.g.b.s.s(paramLinkedList, "it.items");
            localIterator2 = ((Iterable)paramLinkedList).iterator();
            do
            {
              if (!localIterator2.hasNext()) {
                break;
              }
              localcxk1 = (cxk)localIterator2.next();
              paramLinkedList = localblq.nUC;
            } while (paramLinkedList == null);
            Iterator localIterator3 = ((Iterable)paramLinkedList).iterator();
            label311:
            if (!localIterator3.hasNext()) {
              break label536;
            }
            localObject2 = localIterator3.next();
            cxk localcxk2 = (cxk)localObject2;
            paramLinkedList = localcxk2.ZOR;
            if (paramLinkedList != null) {
              break label513;
            }
            paramLinkedList = null;
            label349:
            localObject1 = localcxk1.ZOR;
            if (localObject1 != null) {
              break label521;
            }
            localObject1 = null;
            label364:
            if ((!kotlin.g.b.s.p(paramLinkedList, localObject1)) || (localcxk1.ZnA < localcxk2.ZnA)) {
              break label531;
            }
            i = 1;
            label388:
            if (i == 0) {
              break label534;
            }
          }
        }
        label513:
        label521:
        label531:
        label534:
        label536:
        for (paramLinkedList = (LinkedList<blq>)localObject2;; paramLinkedList = null)
        {
          paramLinkedList = (cxk)paramLinkedList;
          if (paramLinkedList == null) {
            break label268;
          }
          localcxk1.ZnA -= paramLinkedList.ZnA;
          break label268;
          i = 0;
          break;
          paramLinkedList = paramLinkedList.contact;
          if (paramLinkedList == null)
          {
            paramLinkedList = "";
            break label204;
          }
          localObject1 = paramLinkedList.username;
          paramLinkedList = (LinkedList<blq>)localObject1;
          if (localObject1 != null) {
            break label204;
          }
          paramLinkedList = "";
          break label204;
          label464:
          localObject1 = ((bgh)localObject1).contact;
          if (localObject1 == null)
          {
            localObject1 = "";
            break label221;
          }
          localObject3 = ((FinderContact)localObject1).username;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label221;
          }
          localObject1 = "";
          break label221;
          label506:
          break label168;
          paramLinkedList = null;
          break label233;
          paramLinkedList = paramLinkedList.ZOC;
          break label349;
          localObject1 = ((bim)localObject1).ZOC;
          break label364;
          i = 0;
          break label388;
          break label311;
        }
        paramLinkedList = ((blq)localObject3).nUC;
        kotlin.g.b.s.s(paramLinkedList, "it.items");
        d.a(paramLinkedList, (kotlin.g.a.b)bd.a.Dfj);
      }
      label568:
      d.a(localArrayList, (kotlin.g.a.b)bd.b.Dfk);
    }
    if (localArrayList.size() > 0)
    {
      paramLinkedList = com.tencent.d.a.a.a.a.a.ahiX;
      switch (((Number)com.tencent.d.a.a.a.a.a.jTZ().bmg()).intValue())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(355193);
      return localArrayList;
      i = 0;
      int j;
      do
      {
        j = i + 1;
        localArrayList.add(localArrayList.get(0));
        i = j;
      } while (j <= 1);
      continue;
      i = 0;
      do
      {
        j = i + 1;
        localArrayList.add(localArrayList.get(0));
        i = j;
      } while (j <= 12);
      continue;
      i = 0;
      do
      {
        j = i + 1;
        localArrayList.add(localArrayList.get(0));
        i = j;
      } while (j <= 38);
    }
  }
  
  private static final void b(bd parambd)
  {
    AppMethodBeat.i(355250);
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.Dff = null;
    AppMethodBeat.o(355250);
  }
  
  private static final void b(bd parambd, View paramView)
  {
    AppMethodBeat.i(355266);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.niX.hide();
    if (parambd.nfT.getLiveRole() == 1) {
      j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBx.action));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355266);
  }
  
  private static final void c(bd parambd)
  {
    AppMethodBeat.i(355329);
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.Dfg = null;
    AppMethodBeat.o(355329);
  }
  
  private static final void c(bd parambd, View paramView)
  {
    AppMethodBeat.i(355277);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parambd, "this$0");
    paramView = ((e)((e)parambd.business(e.class)).business(e.class)).Eco;
    if (paramView != null)
    {
      ((e)((e)parambd.business(e.class)).business(e.class)).EcI = false;
      localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
      kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
      localObject1 = (com.tencent.mm.plugin.f)localObject1;
      parambd = parambd.mJe.getContext();
      if (parambd == null)
      {
        parambd = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(355277);
        throw parambd;
      }
      parambd = (AppCompatActivity)parambd;
      localObject2 = FinderItem.Companion;
      f.a.a((com.tencent.mm.plugin.f)localObject1, parambd, FinderItem.a.e(paramView, 16384), null, 0, null, 28);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355277);
  }
  
  private static final void d(bd parambd)
  {
    AppMethodBeat.i(355336);
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.niX.show();
    AppMethodBeat.o(355336);
  }
  
  private static final void d(bd parambd, View paramView)
  {
    AppMethodBeat.i(355292);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambd, "this$0");
    localObject = new Intent();
    if (parambd.nfT.getLiveRole() == 1)
    {
      j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBw.action));
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.a((e)parambd.business(e.class))) {
        break label224;
      }
    }
    label224:
    for (paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index#/base-protocol/v2";; paramView = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index")
    {
      ((Intent)localObject).putExtra("rawUrl", paramView);
      paramView = aj.CGT;
      paramView = aj.getFinderLiveAssistant();
      if (paramView != null)
      {
        parambd = parambd.mJe.getContext();
        kotlin.g.b.s.s(parambd, "root.context");
        paramView.a(parambd, (Intent)localObject, null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(355292);
      return;
      if (parambd.nfT.getLiveRole() != 0) {
        break;
      }
      com.tencent.mm.plugin.finder.live.report.k.Doi.a(q.cc.DED, "", 0);
      break;
    }
  }
  
  private static final void e(bd parambd)
  {
    AppMethodBeat.i(355344);
    kotlin.g.b.s.u(parambd, "this$0");
    parambd.niX.show();
    AppMethodBeat.o(355344);
  }
  
  private static final void eqZ() {}
  
  private final boolean eqc()
  {
    AppMethodBeat.i(355201);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      AppMethodBeat.o(355201);
      return true;
    }
    AppMethodBeat.o(355201);
    return false;
  }
  
  private static final void f(bd parambd)
  {
    AppMethodBeat.i(355362);
    kotlin.g.b.s.u(parambd, "this$0");
    ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveLastRewardInfoStorage().e(String.valueOf(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((e)parambd.business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId), ((e)parambd.business(e.class)).EeD);
    AppMethodBeat.o(355362);
  }
  
  private final void rs(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(355162);
    Object localObject3 = this.TAG;
    Object localObject1 = this.Dfe;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, kotlin.g.b.s.X("kickMember:", localObject1));
      localObject1 = aj.CGT;
      localObject3 = aj.getFinderLiveAssistant();
      if (localObject3 != null)
      {
        localObject1 = this.Dfe;
        if (localObject1 != null) {
          break label111;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      ((ap)localObject3).a((String)localObject1, paramBoolean, (m)new c(this));
      AppMethodBeat.o(355162);
      return;
      localObject1 = ((bgh)localObject1).contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderContact)localObject1).username;
      break;
      label111:
      FinderContact localFinderContact = ((bgh)localObject1).contact;
      localObject1 = localObject2;
      if (localFinderContact != null) {
        localObject1 = localFinderContact.username;
      }
    }
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(355593);
    Object localObject;
    if (paramBundle == null) {
      localObject = "";
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(localObject, this.DeM)) {
        d.a(paramLong, new bd..ExternalSyntheticLambda14(this, paramBundle, paramObject, paramLong));
      }
      AppMethodBeat.o(355593);
      return;
      String str = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public final void applyState(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(355569);
    if (d.ee(paramInt2, 16))
    {
      if (this.mJe.getVisibility() != 0)
      {
        tO(0);
        if (paramBundle == null) {}
        for (boolean bool = false; bool; bool = paramBundle.getBoolean("PARAM_FINDER_LIVE_MEMBER_SKIP_LOADING"))
        {
          this.niX.post(new bd..ExternalSyntheticLambda12(this));
          this.Dfd.evP();
          AppMethodBeat.o(355569);
          return;
        }
        this.njj.setVisibility(0);
        this.njg.setVisibility(8);
        this.DeW.setVisibility(8);
        this.njm.setVisibility(8);
        this.nji.setVisibility(8);
        this.Dfd.evP();
        this.niX.post(new bd..ExternalSyntheticLambda11(this));
        eqc();
        paramBundle = aj.CGT;
        paramBundle = aj.getFinderLiveAssistant();
        if (paramBundle != null) {
          paramBundle.d((kotlin.g.a.r)new j(this));
        }
        AppMethodBeat.o(355569);
      }
    }
    else {
      tO(8);
    }
    AppMethodBeat.o(355569);
  }
  
  public final void mount()
  {
    AppMethodBeat.i(355624);
    super.mount();
    this.DeU.setOnClickListener(new bd..ExternalSyntheticLambda3(this));
    this.niW.setOnClickListener(new bd..ExternalSyntheticLambda2(this));
    this.DeV.setOnClickListener(new bd..ExternalSyntheticLambda1(this));
    this.DeY.setOnClickListener(new bd..ExternalSyntheticLambda0(this));
    this.niX.setOnVisibilityListener((kotlin.g.a.b)new d(this));
    this.Dfd.nod = ((kotlin.g.a.b)new e(this));
    AppMethodBeat.o(355624);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355554);
    if (this.mJe.getVisibility() == 0)
    {
      this.niX.hide();
      if (this.nfT.getLiveRole() == 1) {
        j.Dob.a(q.c.Drz, String.valueOf(q.bm.DBx.action));
      }
      AppMethodBeat.o(355554);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(355554);
    return bool;
  }
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(355615);
    Object localObject1 = ((o)business(o.class)).EhQ;
    Object localObject2 = ((o)business(o.class)).EhS;
    int k = ((o)business(o.class)).EhT;
    business(o.class);
    Object localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    long l;
    int i;
    if ((com.tencent.mm.plugin.finder.live.utils.a.a((e)business(e.class))) && (eqc()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv))
    {
      localObject3 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject3 == null)
      {
        l = 0L;
        if (l <= 0L) {
          break label299;
        }
        i = 1;
        label141:
        localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.a((e)business(e.class))) || (eqc()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv)) {
          break label362;
        }
        localObject4 = (Iterable)localObject1;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
      }
    }
    label222:
    Object localObject5;
    label299:
    label307:
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext()) {
        break label309;
      }
      localObject5 = ((Iterator)localObject4).next();
      if (((bgh)localObject5).ZPR > 0) {}
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label307;
        }
        ((Collection)localObject3).add(localObject5);
        break label222;
        localObject3 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject3).liveInfo;
        if (localObject3 == null)
        {
          l = 0L;
          break;
        }
        l = ((bip)localObject3).ZKy;
        break;
        i = 0;
        break label141;
      }
    }
    label309:
    boolean bool = ((List)localObject3).isEmpty();
    for (;;)
    {
      localObject3 = ((e)business(e.class)).EeE;
      if ((!bool) || (!paramBoolean)) {
        break;
      }
      Log.i(this.TAG, "onGetLiveOnlineMemberSuccess autoRefresh but onlineMembers Is Empty!");
      AppMethodBeat.o(355615);
      return;
      label362:
      localObject3 = (Collection)localObject1;
      if ((localObject3 == null) || (((Collection)localObject3).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    if (bool)
    {
      this.DeW.setVisibility(0);
      this.njj.setVisibility(8);
      this.njm.setVisibility(0);
      localObject3 = this.nji;
      if (i != 0)
      {
        localObject4 = this.Dfd;
        localObject5 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
        if (localObject5 == null) {
          l = 0L;
        }
        for (;;)
        {
          ((w)localObject4).DRU = l;
          this.Dfd.a(this.Dfh, (List)localObject1, ((o)business(o.class)).EhR, (List)localObject2, k, true);
          this.Dfd.DRW = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv;
          this.Dfd.bZE.notifyChanged();
          localObject4 = this.DeW.getLayoutParams();
          if (localObject4 != null) {
            break;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(355615);
          throw ((Throwable)localObject1);
          localObject5 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject5).liveInfo;
          if (localObject5 == null) {
            l = 0L;
          } else {
            l = ((bip)localObject5).ZKy;
          }
        }
        localObject4 = (FrameLayout.LayoutParams)localObject4;
        ((FrameLayout.LayoutParams)localObject4).topMargin += this.DeW.getContext().getResources().getDimensionPixelOffset(p.c.Edge_5A);
      }
      for (i = 0;; i = 8)
      {
        ((RecyclerView)localObject3).setVisibility(i);
        this.njg.setVisibility(8);
        if ((!eqc()) || ((((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis != 0) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eis != 524288)))
        {
          this.DeV.setVisibility(8);
          this.njh.setText(this.njh.getContext().getText(p.h.Cnp));
        }
        Pb(((e)((e)business(e.class)).business(e.class)).EcL);
        localObject3 = this.TAG;
        localObject1 = new StringBuilder("onGetLiveOnlineByRoomSuccess onlineCnt:").append(((ArrayList)localObject1).size()).append(" offlineCnt:").append(((ArrayList)localObject2).size()).append(",amount count:");
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        Log.i((String)localObject3, com.tencent.mm.plugin.finder.live.utils.a.a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo));
        AppMethodBeat.o(355615);
        return;
      }
    }
    this.DeW.setVisibility(8);
    this.njj.setVisibility(8);
    this.njm.setVisibility(0);
    this.nji.setVisibility(0);
    this.njg.setVisibility(8);
    Pb(((e)((e)business(e.class)).business(e.class)).EcL);
    if (eqc())
    {
      paramBoolean = ((e)((e)business(e.class)).business(e.class)).Edv;
      this.Dfd.continueFlag = ((e)((e)business(e.class)).business(e.class)).EdW;
      this.Dfd.DRV = ((e)((e)business(e.class)).business(e.class)).EdX;
      this.Dfh = ar((LinkedList)localObject3);
      if ((eqc()) && (this.Dfh.isEmpty()))
      {
        this.DeZ.setVisibility(0);
        this.DeZ.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CrW));
      }
      if ((this.DeZ.getVisibility() != 0) || (this.Dfa.getVisibility() != 0)) {
        break label1235;
      }
      this.Dfc.setVisibility(0);
    }
    for (;;)
    {
      localObject3 = ((Iterable)((e)business(e.class)).EeE).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (blq)((Iterator)localObject3).next();
        d.a(((e)business(e.class)).EeD, (kotlin.g.a.b)new h((blq)localObject4));
        ((e)business(e.class)).EeD.add(localObject4);
      }
      paramBoolean = ((e)((e)business(e.class)).business(e.class)).Edw;
      break;
      label1235:
      this.Dfc.setVisibility(8);
    }
    com.tencent.threadpool.h.ahAA.bn(new bd..ExternalSyntheticLambda13(this));
    localObject3 = this.Dfd;
    Object localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
    if (localObject4 == null) {
      l = 0L;
    }
    for (;;)
    {
      ((w)localObject3).DRU = l;
      this.Dfd.a(this.Dfh, (List)localObject1, ((o)business(o.class)).EhR, (List)localObject2, k, paramBoolean);
      this.Dfd.DRW = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.r)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.r.class)).Eiv;
      this.Dfd.bZE.notifyChanged();
      this.nji.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new i(this));
      break;
      localObject4 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject4).liveInfo;
      if (localObject4 == null) {
        l = 0L;
      } else {
        l = ((bip)localObject4).ZKy;
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355580);
    kotlin.g.b.s.u(paramc, "status");
    AppMethodBeat.o(355580);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355633);
    super.unMount();
    this.DeU.setOnClickListener(null);
    this.niW.setOnClickListener(null);
    this.DeV.setOnClickListener(null);
    this.DeY.setOnClickListener(null);
    this.niX.setOnVisibilityListener(null);
    this.Dfd.nod = null;
    AppMethodBeat.o(355633);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "enable"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, Boolean, ah>
  {
    c(bd parambd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(bd parambd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<bgh, ah>
  {
    e(bd parambd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<bpp, aux, ah>
  {
    f(bd parambd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(bd parambd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "local", "Lcom/tencent/mm/protocal/protobuf/FinderLiveRecentRewardOnlineMember;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<blq, Boolean>
  {
    h(blq paramblq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$onGetLiveOnlineMemberSuccess$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    i(bd parambd) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(353416);
      bd.k(this.Dfl).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      bd.k(this.Dfl).scrollBy(0, 1);
      AppMethodBeat.o(353416);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errCode", "", "errType", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.r<Integer, Integer, String, azv, ah>
  {
    j(bd parambd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bd
 * JD-Core Version:    0.7.0.1
 */