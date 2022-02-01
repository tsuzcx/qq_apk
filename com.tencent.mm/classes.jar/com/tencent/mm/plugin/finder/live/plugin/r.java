package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.model.cgi.ad.a;
import com.tencent.mm.plugin.finder.live.model.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.model.cgi.y;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.adapter.v;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.k;
import com.tencent.mm.plugin.finder.live.viewmodel.data.m;
import com.tencent.mm.protocal.protobuf.bgj;
import com.tencent.mm.protocal.protobuf.bib;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_UI", "", "getDONE_UI", "()I", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelBtn", "Landroid/widget/TextView;", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneNobodyAttend", "doneNobodyAttendDesc", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "runningContainer", "statementTips", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "anchorDoneAction", "anchorLotteryCancelled", "anchorLotteryComputing", "anchorLotteryDone", "anchorLotteryRunning", "lcoalRemainTime", "anchorOpenCard", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneView", "initRunningView", "initView", "onCancelBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "setLotteryDesc", "updateCountDown", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends bb
{
  final int CVG;
  private final int CVH;
  private final int CVI;
  private View CVJ;
  private TextView CVK;
  private TextView CVL;
  private View CVM;
  private View CVN;
  private TextView CVO;
  private TextView CVP;
  private TextView CVQ;
  private TextView CVR;
  private RecyclerView CVS;
  private TextView CVT;
  private TextView CVU;
  private v CVW;
  private boolean CVX;
  final kotlin.g.a.b<bjc, ah> CVY;
  final kotlin.g.a.b<bjc, ah> CVZ;
  final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  private TextView pOq;
  private TextView pmf;
  private View uiF;
  
  public r(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(353833);
    this.nfT = paramb;
    this.TAG = "FinderLiveLotteryAnchorCardPlugin";
    this.CVH = 1;
    this.CVI = 10;
    this.CVY = ((kotlin.g.a.b)new c(this));
    this.CVZ = ((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(353833);
  }
  
  private final void OU(int paramInt)
  {
    AppMethodBeat.i(353846);
    Log.i(this.TAG, s.X("chooseContainer ui mode:", Integer.valueOf(paramInt)));
    View localView;
    if (paramInt == this.CVH)
    {
      localView = this.CVJ;
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = this.CVM;
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(353846);
      }
    }
    else
    {
      localView = this.CVJ;
      if (localView != null) {
        localView.setVisibility(0);
      }
      localView = this.CVM;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    AppMethodBeat.o(353846);
  }
  
  private final void OV(final int paramInt)
  {
    AppMethodBeat.i(353866);
    d.uiThread((kotlin.g.a.a)new i(this, paramInt));
    AppMethodBeat.o(353866);
  }
  
  private static final void a(r paramr, View paramView)
  {
    AppMethodBeat.i(353889);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramr);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramr, "this$0");
    paramView = ((f)paramr.business(f.class)).liveInfo;
    long l1;
    long l2;
    int i;
    label140:
    int k;
    int j;
    if (paramView == null)
    {
      paramView = null;
      l1 = paramView.longValue();
      l2 = ((f)paramr.business(f.class)).hKN;
      localObject = ((f)paramr.business(f.class)).nonceId;
      paramView = ((k)paramr.business(k.class)).Egp;
      if (paramView != null) {
        break label277;
      }
      i = 0;
      paramView = x.CJC;
      k = x.emE();
      paramView = ((k)paramr.business(k.class)).Egp;
      if (paramView != null) {
        break label313;
      }
      j = 0;
      label169:
      paramView = ((k)paramr.business(k.class)).Egu;
      if (paramView != null) {
        break label335;
      }
    }
    label277:
    label313:
    label335:
    for (paramView = null;; paramView = Long.valueOf(paramView.CJK))
    {
      new x(new y(l1, l2, (String)localObject, "", i, "", k, j, paramView.longValue()), (x.a)new f(paramr)).bFJ();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(353889);
      return;
      paramView = Long.valueOf(paramView.liveId);
      break;
      paramView = paramView.Bhm;
      if (paramView == null)
      {
        i = 0;
        break label140;
      }
      paramView = paramView.ZQa;
      if (paramView == null)
      {
        i = 0;
        break label140;
      }
      i = paramView.ZSK;
      break label140;
      paramView = paramView.Bhm;
      if (paramView == null)
      {
        j = 0;
        break label169;
      }
      j = paramView.Czn;
      break label169;
    }
  }
  
  private final void a(bib parambib)
  {
    AppMethodBeat.i(353876);
    Object localObject1;
    if (parambib == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label228;
      }
      TextView localTextView = this.CVQ;
      Object localObject2;
      if (localTextView != null)
      {
        localObject2 = am.aixg;
        localObject2 = this.mJe.getContext().getResources().getString(p.h.CmV);
        s.s(localObject2, "root.context.resources.g…ive_lottery_winner_count)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((bjc)localObject1).ZSL) }, 1));
        s.s(localObject2, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject2);
      }
      localTextView = this.CVR;
      if (localTextView != null)
      {
        localObject2 = am.aixg;
        localObject2 = this.mJe.getContext().getResources().getString(p.h.CmQ);
        s.s(localObject2, "root.context.resources.g…ottery_participate_count)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((bjc)localObject1).Avb) }, 1));
        s.s(localObject1, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject1);
      }
      label177:
      localObject1 = this.CVW;
      if (localObject1 != null)
      {
        if (parambib != null) {
          break label241;
        }
        parambib = null;
      }
    }
    for (;;)
    {
      ((v)localObject1).av(parambib);
      parambib = this.CVW;
      if (parambib != null) {
        parambib.bZE.notifyChanged();
      }
      AppMethodBeat.o(353876);
      return;
      localObject1 = parambib.Bhm;
      break;
      label228:
      Log.e(this.TAG, "updateWinnerList error lotteryInfo is empty!");
      break label177;
      label241:
      parambib = parambib.ZRh;
      if (parambib == null) {
        parambib = null;
      } else {
        parambib = parambib.ZSS;
      }
    }
  }
  
  private final void u(TextView paramTextView)
  {
    Object localObject4 = null;
    AppMethodBeat.i(353858);
    Object localObject1 = ((k)business(k.class)).Egp;
    Object localObject2;
    Object localObject3;
    label40:
    label48:
    int j;
    label55:
    StringBuilder localStringBuilder;
    label92:
    label97:
    label102:
    int i;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label282;
      }
      localObject3 = null;
      if (localObject2 != null) {
        break label292;
      }
      localObject1 = null;
      if (localObject2 != null) {
        break label320;
      }
      j = 0;
      localStringBuilder = new StringBuilder();
      if (localObject3 != null) {
        localStringBuilder.append(s.X((String)localObject3, "\n"));
      }
      if (localObject2 != null) {
        break label329;
      }
      localObject2 = localObject4;
      if (localObject2 != null) {
        break label358;
      }
      if (localObject2 != null) {
        break label372;
      }
      i = 0;
      label104:
      if (i == 0) {
        break label472;
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label386;
      }
      i = 1;
      label132:
      if (i == 0) {
        break label391;
      }
      label163:
      localStringBuilder.append(s.X(this.mJe.getContext().getResources().getString(p.h.Cmq), "，"));
      break label477;
    }
    for (;;)
    {
      if (j <= 0) {
        break label562;
      }
      localObject1 = am.aixg;
      localObject1 = this.mJe.getContext().getResources().getString(p.h.CmA);
      s.s(localObject1, "root.context.resources.g…e_lottery_desc_winnercnt)");
      localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
      s.s(localObject1, "java.lang.String.format(format, *args)");
      localStringBuilder.append(String.valueOf(localObject1));
      if (paramTextView != null) {
        paramTextView.setText((CharSequence)localStringBuilder.toString());
      }
      if (paramTextView == null) {
        break label589;
      }
      paramTextView.setVisibility(0);
      AppMethodBeat.o(353858);
      return;
      localObject2 = ((m)localObject1).Bhm;
      break;
      label282:
      localObject3 = ((bjc)localObject2).description;
      break label40;
      label292:
      localObject1 = ((bjc)localObject2).ZQa;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label48;
      }
      localObject1 = ((bja)localObject1).CJJ;
      break label48;
      label320:
      j = ((bjc)localObject2).Czn;
      break label55;
      label329:
      localObject3 = ((bjc)localObject2).ZQa;
      localObject2 = localObject4;
      if (localObject3 == null) {
        break label92;
      }
      localObject2 = Integer.valueOf(((bja)localObject3).ZSK);
      break label92;
      label358:
      if (((Integer)localObject2).intValue() != 1) {
        break label97;
      }
      i = 1;
      break label104;
      label372:
      if (((Integer)localObject2).intValue() != 3) {
        break label102;
      }
      i = 1;
      break label104;
      label386:
      i = 0;
      break label132;
      label391:
      if (localObject1 != null)
      {
        localObject2 = am.aixg;
        localObject2 = this.mJe.getContext().getResources().getString(p.h.Cmm);
        s.s(localObject2, "root.context.resources.g…ottery_card_desc_comment)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { localObject1 }, 1));
        s.s(localObject1, "java.lang.String.format(format, *args)");
        localStringBuilder.append(s.X((String)localObject1, "，"));
        continue;
        label472:
        if (localObject2 == null)
        {
          label477:
          if ((localObject2 != null) && (((Integer)localObject2).intValue() == 4)) {
            localStringBuilder.append(s.X(this.mJe.getContext().getResources().getString(p.h.Cmp), "，"));
          }
        }
        else
        {
          if (((Integer)localObject2).intValue() != 2) {
            break label163;
          }
          localStringBuilder.append(s.X(this.mJe.getContext().getResources().getString(p.h.CmM), "，"));
        }
      }
    }
    label562:
    Log.i(this.TAG, s.X("setLotteryDesc winnerCnt:", Integer.valueOf(j)));
    if (paramTextView != null) {
      paramTextView.setVisibility(8);
    }
    label589:
    AppMethodBeat.o(353858);
  }
  
  public final void a(final boolean paramBoolean, m paramm)
  {
    AppMethodBeat.i(354037);
    s.u(paramm, "lotteryInfoWrapper");
    super.a(paramBoolean, paramm);
    d.uiThread((kotlin.g.a.a)new a(paramm, this, paramBoolean));
    AppMethodBeat.o(354037);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354025);
    super.initView();
    this.CVJ = this.mJe.findViewById(p.e.CaB);
    Object localObject1 = this.CVJ;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.pmf = ((TextView)localObject1);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label427;
      }
      localObject1 = null;
      label53:
      this.CVK = ((TextView)localObject1);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label441;
      }
      localObject1 = null;
      label69:
      this.CVL = ((TextView)localObject1);
      localObject1 = this.CVL;
      if (localObject1 != null) {
        break label455;
      }
      localObject1 = null;
      label85:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.CVJ;
      if (localObject1 != null) {
        break label463;
      }
      localObject1 = null;
      label106:
      this.pOq = ((TextView)localObject1);
      localObject1 = this.pOq;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener(new r..ExternalSyntheticLambda0(this));
      }
      this.CVM = this.mJe.findViewById(p.e.BCO);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label477;
      }
      localObject1 = null;
      label157:
      this.CVN = ((View)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label488;
      }
      localObject1 = null;
      label173:
      this.CVP = ((TextView)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label502;
      }
      localObject1 = null;
      label189:
      this.CVO = ((TextView)localObject1);
      localObject1 = this.CVO;
      if (localObject1 != null) {
        break label516;
      }
      localObject1 = null;
      label205:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label524;
      }
      localObject1 = null;
      label226:
      this.CVQ = ((TextView)localObject1);
      localObject1 = this.CVQ;
      if (localObject1 != null) {
        break label538;
      }
      localObject1 = null;
      label242:
      aw.a((Paint)localObject1, 0.8F);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label546;
      }
      localObject1 = null;
      label263:
      this.CVR = ((TextView)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label560;
      }
      localObject1 = null;
      label279:
      this.CVS = ((RecyclerView)localObject1);
      this.CVW = new v(getBuContext());
      localObject1 = this.CVS;
      if (localObject1 != null)
      {
        this.mJe.getContext();
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.CVW);
        ((RecyclerView)localObject1).a((RecyclerView.l)new e(this));
      }
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label574;
      }
      localObject1 = null;
      label369:
      this.uiF = ((View)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label585;
      }
      localObject1 = null;
      label385:
      this.CVT = ((TextView)localObject1);
      localObject1 = this.CVM;
      if (localObject1 != null) {
        break label599;
      }
    }
    label427:
    label441:
    label455:
    label463:
    label599:
    for (localObject1 = localObject2;; localObject1 = (TextView)((View)localObject1).findViewById(p.e.Cbs))
    {
      this.CVU = ((TextView)localObject1);
      AppMethodBeat.o(354025);
      return;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.desc);
      break;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCL);
      break label53;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BCK);
      break label69;
      localObject1 = ((TextView)localObject1).getPaint();
      break label85;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.cancel);
      break label106;
      label477:
      localObject1 = ((View)localObject1).findViewById(p.e.Ccq);
      break label157;
      label488:
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BYE);
      break label173;
      label502:
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.BYD);
      break label189;
      localObject1 = ((TextView)localObject1).getPaint();
      break label205;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.Ccp);
      break label226;
      localObject1 = ((TextView)localObject1).getPaint();
      break label242;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.CbH);
      break label263;
      localObject1 = (RecyclerView)((View)localObject1).findViewById(p.e.Ccu);
      break label279;
      localObject1 = ((View)localObject1).findViewById(p.e.Ccr);
      break label369;
      localObject1 = (TextView)((View)localObject1).findViewById(p.e.load_more_footer_tip_tv);
      break label385;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(m paramm, r paramr, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ad.a
  {
    b(r paramr) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(356002);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((k)this.CWa.business(k.class)).a(parambib.Bhm);
        ((k)this.CWa.business(k.class)).d(parambib);
        r.d(this.CWa);
      }
      r.e(this.CWa);
      r.f(this.CWa);
      AppMethodBeat.o(356002);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bjc, ah>
  {
    c(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<bjc, ah>
  {
    d(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(r paramr) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(356070);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(356070);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).Jx();
      r.b(this.CWa, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(356070);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(356076);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(356076);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$onCancelBtnClick$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements x.a
  {
    f(r paramr) {}
    
    public final void a(int paramInt1, final int paramInt2, String paramString, final bgj parambgj)
    {
      AppMethodBeat.i(356066);
      s.u(parambgj, "resp");
      d.uiThread((kotlin.g.a.a)new a(paramInt1, paramInt2, parambgj, this.CWa));
      AppMethodBeat.o(356066);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(int paramInt1, int paramInt2, bgj parambgj, r paramr)
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
    g(r paramr)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ad.a
  {
    h(r paramr) {}
    
    public final void a(int paramInt1, int paramInt2, bib parambib)
    {
      AppMethodBeat.i(356071);
      s.u(parambib, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((k)this.CWa.business(k.class)).a(parambib.Bhm);
        ((k)this.CWa.business(k.class)).d(parambib);
        r.d(this.CWa);
      }
      AppMethodBeat.o(356071);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(r paramr, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.r
 * JD-Core Version:    0.7.0.1
 */