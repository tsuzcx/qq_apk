package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.b;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ak;
import com.tencent.mm.plugin.finder.live.model.ak.b;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.ce;
import com.tencent.mm.plugin.finder.live.report.q.cf;
import com.tencent.mm.plugin.finder.live.report.q.cj;
import com.tencent.mm.plugin.finder.live.view.adapter.v;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_NO_WIN_UI", "", "getDONE_NO_WIN_UI", "()I", "DONE_WINNER_LIST_UI", "getDONE_WINNER_LIST_UI", "DONE_WIN_UI", "getDONE_WIN_UI", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "UNDEFINE_UI", "getUNDEFINE_UI", "attendBtn", "Landroid/widget/TextView;", "attendedBtn", "chaseWayTip", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "curLotteryUIState", "getCurLotteryUIState", "setCurLotteryUIState", "(I)V", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneLotteryBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "doneNoWin", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerLotteryResultContainer", "doneWinnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "lotteryArrow", "lotteryDetail", "lotteryDetailContainer", "oplogCallback", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "runningContainer", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "winnerAvatar", "Landroid/widget/ImageView;", "winnerNickname", "winnerTips", "changeToUnvisible", "checkLoadMoreWinner", "lastVisiblePosition", "checkParticipability", "chooseContainer", "ui", "doBlockOpLog", "username", "initDoneDetailView", "initRunningView", "initView", "initWinnerListView", "isAnchorFollowed", "isDoneUIShowing", "onAttendBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "reportAttendBtnExposure", "type", "requestAttendLotteryWithFollowCondition", "resetLotteryFunIcon", "setAttendBtnStyle", "setAttendBtnTxt", "setFooterTvVisibility", "visibility", "setLotteryFunIcon", "res", "setVisible", "visible", "updateCountDown", "localRemainTime", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "visitorDoneAction", "visitorLotteryCancelled", "visitorLotteryComputing", "visitorLotteryDone", "fromUpdate", "visitorLotteryDoneWinnerList", "showBackIcon", "visitorLotteryRunning", "visitorOpenCard", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cq
  extends bb
{
  final int CVG;
  private final int CVI;
  private View CVJ;
  private TextView CVK;
  private TextView CVL;
  private View CVM;
  private View CVN;
  private TextView CVQ;
  private TextView CVR;
  private RecyclerView CVS;
  private TextView CVT;
  private v CVW;
  private boolean CVX;
  final kotlin.g.a.b<bjc, ah> CVY;
  final kotlin.g.a.b<bjc, ah> CVZ;
  private final int Dmi;
  private final int Dmj;
  private final int Dmk;
  private final int Dml;
  private volatile int Dmm;
  private TextView Dmn;
  private TextView Dmo;
  private WeImageView Dmp;
  private View Dmq;
  private TextView Dmr;
  private TextView Dms;
  private ImageView Dmt;
  private TextView Dmu;
  private TextView Dmv;
  private View Dmw;
  private TextView Dmx;
  private View Dmy;
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private TextView pmf;
  private View uiF;
  
  public cq(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354495);
    this.nfT = paramb;
    this.TAG = "FinderLiveLotteryVisitorCardPlugin";
    this.Dmi = -1;
    this.Dmj = 1;
    this.Dmk = 2;
    this.Dml = 3;
    this.Dmm = this.Dmi;
    this.CVI = 10;
    this.CVY = ((kotlin.g.a.b)new b(this));
    this.CVZ = ((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(354495);
  }
  
  private final void OU(int paramInt)
  {
    AppMethodBeat.i(354508);
    Log.i(this.TAG, s.X("chooseContainer ui mode:", Integer.valueOf(paramInt)));
    this.Dmm = paramInt;
    Object localObject;
    if (paramInt == this.CVG)
    {
      localObject = this.CVJ;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.CVM;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = eqT();
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(p.d.icon_live_lottery_card_bg);
        AppMethodBeat.o(354508);
      }
    }
    else if (paramInt == this.Dmj)
    {
      localObject = this.CVJ;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.CVM;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.CVN;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.Dmq;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = eqT();
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(p.d.icon_live_lottery_card_bg);
        AppMethodBeat.o(354508);
      }
    }
    else
    {
      if (paramInt == this.Dmk)
      {
        localObject = this.CVJ;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = this.CVM;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.CVN;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = this.Dmq;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.Dmr;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.Dms;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = this.Dmt;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(8);
        }
        localObject = this.Dmu;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = eqT();
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(p.d.icon_live_lottery_card_bg);
        }
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFj, String.valueOf(q.cj.DFG.result));
        AppMethodBeat.o(354508);
        return;
      }
      if (paramInt == this.Dml)
      {
        localObject = this.CVJ;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = this.CVM;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.CVN;
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        localObject = this.Dmq;
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        localObject = this.Dmr;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localObject = this.Dms;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.Dmt;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = this.Dmu;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = eqT();
        if (localObject != null) {
          ((View)localObject).setBackgroundResource(p.d.BBh);
        }
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFj, String.valueOf(q.cj.DFF.result));
      }
    }
    AppMethodBeat.o(354508);
  }
  
  private final void OV(final int paramInt)
  {
    AppMethodBeat.i(354539);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new g(this, paramInt));
    AppMethodBeat.o(354539);
  }
  
  private final void Pf(int paramInt)
  {
    AppMethodBeat.i(354560);
    Drawable localDrawable = this.mJe.getContext().getResources().getDrawable(paramInt);
    localDrawable.setBounds(0, 0, com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 21), com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 20));
    TextView localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setCompoundDrawablePadding(com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 4));
    }
    localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setPadding(com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 16), 0, com.tencent.mm.cd.a.fromDPToPix(this.mJe.getContext(), 16), 0);
    }
    localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setCompoundDrawables(localDrawable, null, null, null);
    }
    AppMethodBeat.o(354560);
  }
  
  private static final void a(cq paramcq)
  {
    AppMethodBeat.i(354677);
    s.u(paramcq, "this$0");
    Rect localRect = new Rect();
    Object localObject = paramcq.Dmp;
    if (localObject != null) {
      ((WeImageView)localObject).getHitRect(localRect);
    }
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_2A);
    localRect.inset(-i, -i);
    localObject = paramcq.Dmp;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((WeImageView)localObject).getParent())
    {
      paramcq = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(354677);
      throw paramcq;
    }
    ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, (View)paramcq.Dmp));
    AppMethodBeat.o(354677);
  }
  
  private static final void a(cq paramcq, View paramView)
  {
    AppMethodBeat.i(354667);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcq, "this$0");
    paramcq.esO();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354667);
  }
  
  private static final void a(cq paramcq, bcz parambcz)
  {
    AppMethodBeat.i(354714);
    Object localObject1 = paramcq.Dmt;
    Object localObject2;
    com.tencent.mm.plugin.finder.loader.b localb;
    com.tencent.mm.plugin.finder.loader.p localp;
    if (localObject1 != null)
    {
      if (parambcz.ZNI != 3) {
        break label105;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
      localb = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(parambcz.xkY));
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localb, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    }
    for (;;)
    {
      localObject1 = paramcq.Dmu;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramcq.mJe.getContext(), (CharSequence)parambcz.nickname));
      }
      AppMethodBeat.o(354714);
      return;
      label105:
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCq();
      localb = new com.tencent.mm.plugin.finder.loader.b(Util.nullAsNil(parambcz.xkY));
      localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject2).a(localb, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
    }
  }
  
  private final void a(bib parambib)
  {
    Object localObject3 = null;
    AppMethodBeat.i(354523);
    Object localObject1;
    Object localObject2;
    if (parambib == null)
    {
      localObject1 = null;
      Object localObject4 = this.CVQ;
      if (localObject4 != null)
      {
        localObject2 = am.aixg;
        String str = this.mJe.getContext().getResources().getString(p.h.CmV);
        s.s(str, "root.context.resources.g…ive_lottery_winner_count)");
        if (localObject1 != null) {
          break label227;
        }
        localObject2 = null;
        label62:
        localObject2 = String.format(str, Arrays.copyOf(new Object[] { localObject2 }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)localObject2);
      }
      localObject2 = this.CVR;
      if (localObject2 != null)
      {
        localObject4 = am.aixg;
        localObject4 = this.mJe.getContext().getResources().getString(p.h.CmQ);
        s.s(localObject4, "root.context.resources.g…ottery_participate_count)");
        if (localObject1 != null) {
          break label238;
        }
        localObject1 = null;
        label142:
        localObject1 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject1 }, 1));
        s.s(localObject1, "java.lang.String.format(format, *args)");
        ((TextView)localObject2).setText((CharSequence)localObject1);
      }
      localObject1 = this.CVW;
      if (localObject1 != null)
      {
        if (parambib != null) {
          break label249;
        }
        parambib = localObject3;
      }
    }
    for (;;)
    {
      ((v)localObject1).av(parambib);
      parambib = this.CVW;
      if (parambib != null) {
        parambib.bZE.notifyChanged();
      }
      AppMethodBeat.o(354523);
      return;
      localObject1 = parambib.Bhm;
      break;
      label227:
      localObject2 = Integer.valueOf(((bjc)localObject1).ZSL);
      break label62;
      label238:
      localObject1 = Integer.valueOf(((bjc)localObject1).Avb);
      break label142;
      label249:
      localObject2 = parambib.ZRh;
      parambib = localObject3;
      if (localObject2 != null) {
        parambib = ((bjf)localObject2).ZSS;
      }
    }
  }
  
  private final void a(bjc parambjc, boolean paramBoolean)
  {
    AppMethodBeat.i(354582);
    if ((this.mJe.getVisibility() == 0) && ((this.Dmm == this.Dml) || (this.Dmm == this.Dmk) || (this.Dmm == this.Dmj))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "visitorLotteryDone fromUpdate:" + paramBoolean + ",isDoneUIShowing:" + bool);
      if ((!paramBoolean) || (!bool)) {
        break;
      }
      AppMethodBeat.o(354582);
      return;
    }
    bool = com.tencent.mm.ae.d.ee(parambjc.extFlag, 2);
    paramBoolean = com.tencent.mm.ae.d.ee(parambjc.extFlag, 1);
    int j = parambjc.Avb;
    int k = parambjc.ZSL;
    z.bAO();
    Object localObject;
    label215:
    int i;
    if (bool)
    {
      OU(this.Dml);
      localObject = parambjc.ZSM;
      if (localObject == null)
      {
        parambjc = null;
        if (parambjc == null)
        {
          localObject = (cq)this;
          Log.i(((cq)localObject).TAG, "lotteryInfo.participant_info is null ,so use loacal current role info");
          Iterator localIterator = ((Iterable)((e)((cq)localObject).business(e.class)).EdK).iterator();
          if (!localIterator.hasNext()) {
            break label540;
          }
          parambjc = localIterator.next();
          if (((bcz)parambjc).ZNI != ((e)((cq)localObject).business(e.class)).EdI.ZNI) {
            break label535;
          }
          i = 1;
          label262:
          if (i == 0) {
            break label538;
          }
          label266:
          parambjc = (bcz)parambjc;
          if (parambjc != null) {
            a(this, parambjc);
          }
        }
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egs = true;
        parambjc = this.Dmv;
        if (parambjc == null) {
          break label851;
        }
        parambjc.setVisibility(0);
        paramBoolean = true;
      }
    }
    for (;;)
    {
      label310:
      if ((k > 0) && (j >= k))
      {
        parambjc = this.Dmy;
        if (parambjc != null) {
          parambjc.setVisibility(0);
        }
        label336:
        if (!paramBoolean) {
          break label760;
        }
        parambjc = this.Dmx;
        if (parambjc != null)
        {
          localObject = am.aixg;
          localObject = this.mJe.getContext().getResources().getString(p.h.finder_live_lottery_result);
          s.s(localObject, "root.context.resources.g…nder_live_lottery_result)");
          localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(k), Integer.valueOf(j) }, 2));
          s.s(localObject, "java.lang.String.format(format, *args)");
          parambjc.setText((CharSequence)localObject);
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "visitorLotteryDone isWin:" + bool + ",participateCnt:" + j + ",realWinnerCnt:" + k + ",haveLotteryResult:" + paramBoolean);
        AppMethodBeat.o(354582);
        return;
        parambjc = new bcz();
        parambjc.xkY = ((ebc)localObject).xkY;
        parambjc.nickname = ((ebc)localObject).nickname;
        localObject = ah.aiuX;
        a(this, parambjc);
        parambjc = ah.aiuX;
        break;
        label535:
        i = 0;
        break label262;
        label538:
        break label215;
        label540:
        parambjc = null;
        break label266;
        if (paramBoolean)
        {
          OU(this.Dmk);
          parambjc = this.Dmr;
          if (parambjc != null) {
            parambjc.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.finder_live_lottery_no_win_tip));
          }
          parambjc = this.Dmv;
          if (parambjc == null) {
            break label851;
          }
          parambjc.setVisibility(8);
          paramBoolean = true;
          break label310;
        }
        if ((k > 0) && (j >= k))
        {
          rO(false);
          parambjc = this.Dmv;
          if (parambjc != null) {
            parambjc.setVisibility(8);
          }
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFj, String.valueOf(q.cj.DFH.result));
          paramBoolean = true;
          break label310;
        }
        OU(this.Dmk);
        parambjc = this.Dmr;
        if (parambjc != null) {
          parambjc.setText((CharSequence)this.mJe.getContext().getResources().getString(p.h.CmP));
        }
        parambjc = this.Dmv;
        if (parambjc != null) {
          parambjc.setVisibility(8);
        }
        com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFj, String.valueOf(q.cj.DFH.result));
        paramBoolean = false;
        break label310;
        parambjc = this.Dmy;
        if (parambjc == null) {
          break label336;
        }
        parambjc.setVisibility(8);
        break label336;
        label760:
        parambjc = this.Dmx;
        if (parambjc != null)
        {
          localObject = am.aixg;
          localObject = this.mJe.getContext().getResources().getString(p.h.finder_live_lottery_statement);
          s.s(localObject, "root.context.resources.g…r_live_lottery_statement)");
          localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(k), Integer.valueOf(j) }, 2));
          s.s(localObject, "java.lang.String.format(format, *args)");
          parambjc.setText((CharSequence)localObject);
        }
      }
      label851:
      paramBoolean = true;
    }
  }
  
  private static final void b(cq paramcq)
  {
    AppMethodBeat.i(354697);
    s.u(paramcq, "this$0");
    Rect localRect = new Rect();
    Object localObject = paramcq.Dmw;
    if (localObject != null) {
      ((View)localObject).getHitRect(localRect);
    }
    int i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_A);
    localRect.inset(-i, -i);
    localObject = paramcq.Dmw;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((View)localObject).getParent())
    {
      paramcq = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(354697);
      throw paramcq;
    }
    ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, paramcq.Dmw));
    AppMethodBeat.o(354697);
  }
  
  private static final void b(cq paramcq, View paramView)
  {
    AppMethodBeat.i(354689);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcq, "this$0");
    paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)paramcq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (paramView != null)
    {
      paramView = paramView.Bhm;
      if (paramView != null) {
        paramcq.a(paramView, false);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354689);
  }
  
  private final void b(bib parambib)
  {
    com.tencent.mm.bx.b localb = null;
    int j = 0;
    AppMethodBeat.i(354532);
    int i;
    if (parambib == null) {
      i = j;
    }
    Object localObject;
    for (;;)
    {
      Log.i(this.TAG, s.X("parseWinnerList winnerListSize:", Integer.valueOf(i)));
      if (i <= 0) {
        break;
      }
      a(parambib);
      AppMethodBeat.o(354532);
      return;
      localObject = parambib.ZRh;
      i = j;
      if (localObject != null)
      {
        localObject = ((bjf)localObject).ZSS;
        i = j;
        if (localObject != null) {
          i = ((LinkedList)localObject).size();
        }
      }
    }
    parambib = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    bib localbib;
    if (parambib == null)
    {
      parambib = null;
      Log.i(this.TAG, s.X("parseWinnerList record is empty!lotteryId:", parambib));
      if (parambib != null)
      {
        localObject = aj.CGT;
        localObject = aj.getFinderLiveAssistant();
        if (localObject != null)
        {
          localbib = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egr;
          if (localbib != null) {
            break label209;
          }
        }
      }
    }
    for (;;)
    {
      ((ap)localObject).a(parambib, localb, (ad.a)new f(this));
      AppMethodBeat.o(354532);
      return;
      parambib = parambib.Bhm;
      if (parambib == null)
      {
        parambib = null;
        break;
      }
      parambib = parambib.id;
      break;
      label209:
      localb = localbib.lastBuffer;
    }
  }
  
  private static final void c(cq paramcq, View paramView)
  {
    AppMethodBeat.i(354703);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramcq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramcq, "this$0");
    paramcq.rO(true);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354703);
  }
  
  private final boolean esD()
  {
    AppMethodBeat.i(354630);
    boolean bool = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).esD();
    AppMethodBeat.o(354630);
    return bool;
  }
  
  private final void esN()
  {
    AppMethodBeat.i(354547);
    TextView localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setCompoundDrawablePadding(0);
    }
    localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setPadding(0, 0, 0, 0);
    }
    localTextView = this.Dmn;
    if (localTextView != null) {
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    AppMethodBeat.o(354547);
  }
  
  private final void esO()
  {
    int j = 0;
    int k = 1;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(354624);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)((e)business(e.class)).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label330;
      }
      Log.i(((cq)this).TAG, "checkParticipability participability is empty!");
    }
    Object localObject4;
    int i;
    label152:
    label174:
    label314:
    label330:
    for (boolean bool = true;; bool = ((Boolean)localObject1).booleanValue())
    {
      if (bool) {
        break label340;
      }
      AppMethodBeat.o(354624);
      return;
      localObject1 = ((m)localObject1).Bhm;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bjc)localObject1).ZSN;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      if (((bjd)localObject1).ZSP)
      {
        localObject4 = (CharSequence)((bjd)localObject1).wording;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label214;
          }
          localObject1 = this.mJe.getContext().getResources().getString(p.h.CmU);
          aa.showTextToast(this.mJe.getContext(), (String)localObject1);
          Log.i(this.TAG, "checkParticipability client_version_not_support!");
          bool = false;
        }
      }
      for (;;)
      {
        localObject1 = Boolean.valueOf(bool);
        break;
        i = 0;
        break label152;
        label214:
        localObject1 = ((bjd)localObject1).wording;
        break label174;
        if (!((bjd)localObject1).ZSO)
        {
          localObject4 = (CharSequence)((bjd)localObject1).wording;
          if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
          {
            i = 1;
            if (i == 0) {
              break label314;
            }
          }
          for (localObject1 = this.mJe.getContext().getResources().getString(p.h.Cmy);; localObject1 = ((bjd)localObject1).wording)
          {
            aa.showTextToast(this.mJe.getContext(), (String)localObject1);
            Log.i(this.TAG, "checkParticipability is_participable false!");
            bool = false;
            break;
            i = 0;
            break label259;
          }
        }
        bool = true;
      }
    }
    label259:
    label340:
    localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label502;
      }
      label368:
      if (localObject1 != null) {
        break label516;
      }
      label373:
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        tO(8);
        i = q.ce.DFa.type;
        if ((!((e)business(e.class)).Ect) || (!((e)business(e.class)).Ecs))
        {
          aa.showTextToast(this.mJe.getContext(), MMApplicationContext.getContext().getResources().getString(p.h.finder_live_comment_anchor_disable));
          AppMethodBeat.o(354624);
          return;
          localObject1 = ((m)localObject1).Bhm;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((bjc)localObject1).ZQa;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = Integer.valueOf(((bja)localObject1).ZSK);
          break;
          label502:
          if (((Integer)localObject1).intValue() != 1) {
            break label368;
          }
          i = k;
          continue;
          label516:
          if (((Integer)localObject1).intValue() != 3) {
            break label373;
          }
          i = k;
          continue;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
        if (localObject1 == null)
        {
          localObject1 = localObject3;
          if (localObject1 == null) {
            break label703;
          }
          localObject2 = this.nfT;
          localObject3 = b.c.ndW;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", (String)localObject1);
          ah localah = ah.aiuX;
          ((com.tencent.mm.live.b.b)localObject2).statusChange((b.c)localObject3, (Bundle)localObject4);
        }
        for (;;)
        {
          if (this.nfT.getLiveRole() == 0)
          {
            localObject3 = com.tencent.mm.plugin.finder.live.report.k.Doi;
            localObject4 = q.cf.DFg;
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = "";
            }
            ((com.tencent.mm.plugin.finder.live.report.k)localObject3).a((q.cf)localObject4, String.valueOf(i), (String)localObject2);
          }
          AppMethodBeat.o(354624);
          return;
          localObject2 = ((m)localObject1).Bhm;
          localObject1 = localObject3;
          if (localObject2 == null) {
            break;
          }
          localObject2 = ((bjc)localObject2).ZQa;
          localObject1 = localObject3;
          if (localObject2 == null) {
            break;
          }
          localObject1 = ((bja)localObject2).CJJ;
          break;
          label703:
          b.b.a(this.nfT, b.c.ndW);
        }
      }
    }
    if (localObject1 == null)
    {
      label721:
      if (localObject1 != null) {
        break label866;
      }
      label726:
      if (localObject1 != null) {
        break label973;
      }
      label731:
      localObject3 = this.TAG;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject1 != null) {
        break label1030;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Log.i((String)localObject3, s.X("onAttendBtnClick type:", localObject1));
      i = j;
      localObject1 = localObject2;
      break;
      if (((Integer)localObject1).intValue() != 2) {
        break label721;
      }
      tO(8);
      i = q.ce.DEZ.type;
      if (!((e)business(e.class)).Ecx)
      {
        aa.showTextToast(this.mJe.getContext(), MMApplicationContext.getContext().getResources().getString(p.h.finder_live_like_anchor_disable));
        AppMethodBeat.o(354624);
        return;
      }
      b.b.a(this.nfT, b.c.ner);
      localObject1 = localObject2;
      break;
      label866:
      if (((Integer)localObject1).intValue() != 4) {
        break label726;
      }
      tO(8);
      i = q.ce.DFb.type;
      if (esD())
      {
        esQ();
        localObject1 = localObject2;
        break;
      }
      localObject1 = ak.CHI;
      localObject3 = this.nfT;
      localObject1 = ((f)business(f.class)).liveInfo;
      if (localObject1 == null) {}
      for (localObject1 = null;; localObject1 = Long.valueOf(((bip)localObject1).liveId))
      {
        ak.a((com.tencent.mm.live.b.b)localObject3, ((Long)localObject1).longValue(), ak.b.CHQ);
        localObject1 = localObject2;
        break;
      }
      label973:
      if (((Integer)localObject1).intValue() != 5) {
        break label731;
      }
      tO(8);
      j = q.ce.DFc.type;
      i = j;
      localObject1 = localObject2;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Eff) {
        break;
      }
      esQ();
      i = j;
      localObject1 = localObject2;
      break;
      label1030:
      localObject1 = ((m)localObject1).Bhm;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((bjc)localObject1).ZQa;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = Integer.valueOf(((bja)localObject1).ZSK);
        }
      }
    }
  }
  
  private final void esP()
  {
    AppMethodBeat.i(354649);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    label30:
    label55:
    View localView;
    int i;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label103;
      }
      localObject = this.Dmn;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.finder_live_attend_lottery));
      }
      localView = eqT();
      if (localView != null)
      {
        i = p.e.BEt;
        localObject = this.Dmn;
        if (localObject != null) {
          break label465;
        }
      }
    }
    label131:
    label135:
    label139:
    label314:
    label465:
    for (localObject = null;; localObject = ((TextView)localObject).getText())
    {
      localView.setTag(i, localObject);
      AppMethodBeat.o(354649);
      return;
      localObject = Integer.valueOf(((m)localObject).CBc);
      break;
      label103:
      if (((Integer)localObject).intValue() != 1) {
        break label30;
      }
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label212;
        }
        if (localObject != null) {
          break label225;
        }
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label238;
        }
        localObject = this.Dmn;
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.CiB));
        break;
        localObject = ((m)localObject).Bhm;
        if (localObject == null)
        {
          localObject = null;
          break label131;
        }
        localObject = ((bjc)localObject).ZQa;
        if (localObject == null)
        {
          localObject = null;
          break label131;
        }
        localObject = Integer.valueOf(((bja)localObject).ZSK);
        break label131;
        label212:
        if (((Integer)localObject).intValue() != 1) {
          break label135;
        }
        i = 1;
        continue;
        label225:
        if (((Integer)localObject).intValue() != 3) {
          break label139;
        }
        i = 1;
      }
      label238:
      if (localObject == null)
      {
        label242:
        if (localObject != null) {
          break label314;
        }
        label246:
        if (localObject != null) {
          break label385;
        }
      }
      while (((Integer)localObject).intValue() != 5)
      {
        localObject = this.Dmn;
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.finder_live_attend_lottery));
        break;
        if (((Integer)localObject).intValue() != 2) {
          break label242;
        }
        localObject = this.Dmn;
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.CiD));
        break;
        if (((Integer)localObject).intValue() != 4) {
          break label246;
        }
        if (esD())
        {
          localObject = this.Dmn;
          if (localObject == null) {
            break;
          }
          ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.finder_live_attend_lottery));
          break;
        }
        localObject = this.Dmn;
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.CiC));
        break;
      }
      if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class)).Eff)
      {
        localObject = this.Dmn;
        if (localObject == null) {
          break label55;
        }
        ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.Cmo));
        break label55;
      }
      localObject = this.Dmn;
      if (localObject == null) {
        break label55;
      }
      ((TextView)localObject).setText((CharSequence)MMApplicationContext.getResources().getString(p.h.Cmn));
      break label55;
    }
  }
  
  private final void esQ()
  {
    AppMethodBeat.i(354655);
    b.b.a(this.nfT, b.c.neq);
    AppMethodBeat.o(354655);
  }
  
  private final void rO(boolean paramBoolean)
  {
    AppMethodBeat.i(354594);
    Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
    int i;
    int j;
    if (localObject == null)
    {
      i = 0;
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (localObject != null) {
        break label226;
      }
      j = 0;
      label50:
      Log.i(this.TAG, "visitorLotteryDoneWinnerList realWinnerCnt:" + i + ",participateCount:" + j);
      OU(this.Dmj);
      localObject = this.CVQ;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.CVR;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.CVS;
      if (localObject != null) {
        ((RecyclerView)localObject).setVisibility(0);
      }
      b(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egr);
      if (!paramBoolean) {
        break label252;
      }
      localObject = this.Dmp;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.cf.DFk, "");
      AppMethodBeat.o(354594);
      return;
      localObject = ((m)localObject).Bhm;
      if (localObject == null)
      {
        i = 0;
        break;
      }
      i = ((bjc)localObject).ZSL;
      break;
      label226:
      localObject = ((m)localObject).Bhm;
      if (localObject == null)
      {
        j = 0;
        break label50;
      }
      j = ((bjc)localObject).Avb;
      break label50;
      label252:
      localObject = this.Dmp;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
    }
  }
  
  public final void a(final boolean paramBoolean, m paramm)
  {
    AppMethodBeat.i(354923);
    s.u(paramm, "lotteryInfoWrapper");
    super.a(paramBoolean, paramm);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h(paramm, this, paramBoolean));
    AppMethodBeat.o(354923);
  }
  
  public final void eqW()
  {
    AppMethodBeat.i(354935);
    super.eqW();
    this.Dmm = this.Dmi;
    AppMethodBeat.o(354935);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354913);
    super.initView();
    this.CVJ = this.mJe.findViewById(p.e.CaB);
    Object localObject1 = this.CVJ;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.pmf = ((TextView)localObject1);
      localObject1 = this.pmf;
      if (localObject1 != null) {
        break label709;
      }
      localObject1 = null;
      label53:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label717;
      }
      localObject1 = null;
      label74:
      this.CVK = ((TextView)localObject1);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label731;
      }
      localObject1 = null;
      label90:
      this.CVL = ((TextView)localObject1);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label745;
      }
      localObject1 = null;
      label106:
      this.Dmo = ((TextView)localObject1);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label759;
      }
      localObject1 = null;
      label122:
      this.Dmn = ((TextView)localObject1);
      localObject1 = this.Dmn;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener(new cq..ExternalSyntheticLambda2(this));
      }
      View localView = eqT();
      if (localView != null)
      {
        int i = p.e.BEv;
        localObject1 = this.CVJ;
        if (localObject1 != null) {
          break label773;
        }
        localObject1 = null;
        label174:
        localView.setTag(i, localObject1);
      }
      this.CVM = this.mJe.findViewById(p.e.BCO);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label801;
      }
      localObject1 = null;
      label206:
      this.CVN = ((View)localObject1);
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label812;
      }
      localObject1 = null;
      label222:
      this.Dmp = ((WeImageView)localObject1);
      localObject1 = this.Dmp;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.Dmp;
      if (localObject1 != null) {
        ((WeImageView)localObject1).post(new cq..ExternalSyntheticLambda4(this));
      }
      localObject1 = this.Dmp;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener(new cq..ExternalSyntheticLambda1(this));
      }
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label826;
      }
      localObject1 = null;
      label295:
      this.CVQ = ((TextView)localObject1);
      localObject1 = this.CVQ;
      if (localObject1 != null) {
        break label840;
      }
      localObject1 = null;
      label311:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label848;
      }
      localObject1 = null;
      label332:
      this.CVR = ((TextView)localObject1);
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label862;
      }
      localObject1 = null;
      label348:
      this.CVS = ((RecyclerView)localObject1);
      this.CVW = new v(getBuContext());
      localObject1 = this.CVS;
      if (localObject1 != null)
      {
        this.mJe.getContext();
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.CVW);
        ((RecyclerView)localObject1).a((RecyclerView.l)new d(this));
      }
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label876;
      }
      localObject1 = null;
      label438:
      this.uiF = ((View)localObject1);
      localObject1 = this.CVN;
      if (localObject1 != null) {
        break label887;
      }
      localObject1 = null;
      label454:
      this.CVT = ((TextView)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label901;
      }
      localObject1 = null;
      label470:
      this.Dmq = ((View)localObject1);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label912;
      }
      localObject1 = null;
      label486:
      this.Dmr = ((TextView)localObject1);
      localObject1 = this.Dmr;
      if (localObject1 != null) {
        break label926;
      }
      localObject1 = null;
      label502:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label934;
      }
      localObject1 = null;
      label523:
      this.Dms = ((TextView)localObject1);
      localObject1 = this.Dms;
      if (localObject1 != null) {
        break label948;
      }
      localObject1 = null;
      label539:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label956;
      }
      localObject1 = null;
      label560:
      this.Dmt = ((ImageView)localObject1);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label970;
      }
      localObject1 = null;
      label576:
      this.Dmu = ((TextView)localObject1);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label984;
      }
      localObject1 = null;
      label592:
      this.Dmv = ((TextView)localObject1);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label998;
      }
      localObject1 = null;
      label608:
      this.Dmw = ((View)localObject1);
      localObject1 = this.Dmw;
      if (localObject1 != null) {
        ((View)localObject1).post(new cq..ExternalSyntheticLambda3(this));
      }
      localObject1 = this.Dmw;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener(new cq..ExternalSyntheticLambda0(this));
      }
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label1009;
      }
      localObject1 = null;
      label667:
      this.Dmx = ((TextView)localObject1);
      localObject1 = this.Dmq;
      if (localObject1 != null) {
        break label1023;
      }
    }
    label709:
    label717:
    label731:
    label745:
    label759:
    label1023:
    for (localObject1 = localObject2;; localObject1 = ((View)localObject1).findViewById(p.e.BXm))
    {
      this.Dmy = ((View)localObject1);
      AppMethodBeat.o(354913);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.desc);
      break;
      localObject1 = ((TextView)localObject1).getPaint();
      break label53;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCL);
      break label74;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCK);
      break label90;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BVE);
      break label106;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BBD);
      break label122;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.bottom_desc_tv);
      if (localObject1 == null)
      {
        localObject1 = null;
        break label174;
      }
      localObject1 = ((TextView)localObject1).getText();
      break label174;
      localObject1 = ((View)localObject1).findViewById(p.e.Ccq);
      break label206;
      localObject1 = (WeImageView)((View)localObject1).findViewById(p.e.BXn);
      break label222;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Ccp);
      break label295;
      localObject1 = ((TextView)localObject1).getPaint();
      break label311;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.CbH);
      break label332;
      localObject1 = (RecyclerView)((View)localObject1).findViewById(p.e.Ccu);
      break label348;
      localObject1 = ((View)localObject1).findViewById(p.e.Ccr);
      break label438;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
      break label454;
      localObject1 = ((View)localObject1).findViewById(p.e.BXN);
      break label470;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BYC);
      break label486;
      localObject1 = ((TextView)localObject1).getPaint();
      break label502;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Ccv);
      break label523;
      localObject1 = ((TextView)localObject1).getPaint();
      break label539;
      localObject1 = (ImageView)((View)localObject1).findViewById(p.e.Cco);
      break label560;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Ccs);
      break label576;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCi);
      break label592;
      localObject1 = ((View)localObject1).findViewById(p.e.BXw);
      break label608;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BXv);
      break label667;
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(354932);
    if (((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())
    {
      this.mJe.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(354932);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(354932);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ad.a
  {
    a(cq paramcq) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(353377);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dmz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).a(parambib.Bhm);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dmz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).d(parambib);
        cq.e(this.Dmz);
      }
      cq.f(this.Dmz);
      cq.g(this.Dmz);
      AppMethodBeat.o(353377);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<bjc, ah>
  {
    b(cq paramcq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bjc, ah>
  {
    c(cq paramcq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(cq paramcq) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(353381);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(353381);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).Jx();
      cq.b(this.Dmz, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(353381);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(353383);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(353383);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(cq paramcq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements ad.a
  {
    f(cq paramcq) {}
    
    public final void a(int paramInt1, int paramInt2, final bib parambib)
    {
      AppMethodBeat.i(353419);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dmz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).a(parambib.Bhm);
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dmz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).d(parambib);
        cq.e(this.Dmz);
        AppMethodBeat.o(353419);
        return;
      }
      parambib = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.k)this.Dmz.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.k.class)).Egp;
      if (parambib != null)
      {
        parambib = parambib.Bhm;
        if (parambib != null) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.Dmz, parambib));
        }
      }
      AppMethodBeat.o(353419);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(cq paramcq, bjc parambjc)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(cq paramcq, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(m paramm, cq paramcq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cq
 * JD-Core Version:    0.7.0.1
 */