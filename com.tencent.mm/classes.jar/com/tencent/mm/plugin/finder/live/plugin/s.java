package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.cgi.v.a;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.g;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_UI", "", "getDONE_UI", "()I", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelBtn", "Landroid/widget/TextView;", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneNobodyAttend", "doneNobodyAttendDesc", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "runningContainer", "statementTips", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "anchorDoneAction", "anchorLotteryCancelled", "anchorLotteryComputing", "anchorLotteryDone", "anchorLotteryRunning", "lcoalRemainTime", "anchorOpenCard", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneView", "initRunningView", "initView", "onCancelBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "setLotteryDesc", "updateCountDown", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "plugin-finder_release"})
public final class s
  extends bm
{
  final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private TextView mRJ;
  private TextView msF;
  private View tzi;
  final int ymO;
  private final int ymP;
  private final int ymQ;
  private View ymR;
  private TextView ymS;
  private TextView ymT;
  private View ymU;
  private View ymV;
  private TextView ymW;
  private TextView ymX;
  private TextView ymY;
  private TextView ymZ;
  private RecyclerView yna;
  private TextView ynb;
  private TextView ync;
  private com.tencent.mm.plugin.finder.live.view.adapter.p ynd;
  private boolean yne;
  final kotlin.g.a.b<bal, x> ynf;
  final kotlin.g.a.b<bal, x> yng;
  
  public s(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(284111);
    this.kCL = paramb;
    this.TAG = "FinderLiveLotteryAnchorCardPlugin";
    this.ymP = 1;
    this.ymQ = 10;
    this.ynf = ((kotlin.g.a.b)new c(this));
    this.yng = ((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(284111);
  }
  
  private final void Nw(int paramInt)
  {
    AppMethodBeat.i(284106);
    Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(paramInt)));
    if (paramInt == this.ymP)
    {
      localView = this.ymR;
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = this.ymU;
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(284106);
        return;
      }
      AppMethodBeat.o(284106);
      return;
    }
    View localView = this.ymR;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.ymU;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(284106);
      return;
    }
    AppMethodBeat.o(284106);
  }
  
  private final void Nx(final int paramInt)
  {
    AppMethodBeat.i(284109);
    d.uiThread((kotlin.g.a.a)new j(this, paramInt));
    AppMethodBeat.o(284109);
  }
  
  private final void a(azs paramazs)
  {
    AppMethodBeat.i(284110);
    Object localObject1;
    if (paramazs != null)
    {
      localObject1 = paramazs.xHW;
      if (localObject1 == null) {
        break label261;
      }
      TextView localTextView = this.ymY;
      Object localObject2;
      if (localTextView != null)
      {
        localObject2 = af.aaBG;
        localObject2 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_lottery_winner_count);
        kotlin.g.b.p.j(localObject2, "root.context.resources.g…ive_lottery_winner_count)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((bal)localObject1).SMr) }, 1));
        kotlin.g.b.p.j(localObject2, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject2);
      }
      localTextView = this.ymZ;
      if (localTextView != null)
      {
        localObject2 = af.aaBG;
        localObject2 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(b.j.finder_live_lottery_participate_count);
        kotlin.g.b.p.j(localObject2, "root.context.resources.g…ottery_participate_count)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((bal)localObject1).SCT) }, 1));
        kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject1);
      }
      label204:
      localObject1 = this.ynd;
      if (localObject1 != null)
      {
        if (paramazs == null) {
          break label274;
        }
        paramazs = paramazs.SLp;
        if (paramazs == null) {
          break label274;
        }
      }
    }
    label261:
    label274:
    for (paramazs = paramazs.SMv;; paramazs = null)
    {
      ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject1).at(paramazs);
      paramazs = this.ynd;
      if (paramazs == null) {
        break label279;
      }
      paramazs.notifyDataSetChanged();
      AppMethodBeat.o(284110);
      return;
      localObject1 = null;
      break;
      Log.e(this.TAG, "updateWinnerList error lotteryInfo is empty!");
      break label204;
    }
    label279:
    AppMethodBeat.o(284110);
  }
  
  private final void p(TextView paramTextView)
  {
    AppMethodBeat.i(284108);
    Object localObject1 = ((g)business(g.class)).zic;
    Object localObject2;
    Object localObject3;
    label45:
    label69:
    int i;
    label80:
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject1).xHW;
      if (localObject2 == null) {
        break label283;
      }
      localObject3 = ((bal)localObject2).description;
      if (localObject2 == null) {
        break label289;
      }
      localObject1 = ((bal)localObject2).SKZ;
      if (localObject1 == null) {
        break label289;
      }
      localObject1 = ((baj)localObject1).SMq;
      if (localObject2 == null) {
        break label295;
      }
      i = ((bal)localObject2).yaH;
      localStringBuilder = new StringBuilder();
      if (localObject3 != null) {
        localStringBuilder.append((String)localObject3 + '\n');
      }
      if (localObject2 == null) {
        break label300;
      }
      localObject2 = ((bal)localObject2).SKZ;
      if (localObject2 == null) {
        break label300;
      }
      localObject2 = Integer.valueOf(((baj)localObject2).SMp);
      label147:
      if (localObject2 != null) {
        break label306;
      }
      label152:
      if (localObject2 != null) {
        break label518;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject1 = af.aaBG;
        localObject1 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_lottery_desc_winnercnt);
        kotlin.g.b.p.j(localObject1, "root.context.resources.g…e_lottery_desc_winnercnt)");
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
        localStringBuilder.append(String.valueOf(localObject1));
        if (paramTextView != null) {
          paramTextView.setText((CharSequence)localStringBuilder.toString());
        }
        if (paramTextView != null)
        {
          paramTextView.setVisibility(0);
          AppMethodBeat.o(284108);
          return;
          localObject2 = null;
          break;
          label283:
          localObject3 = null;
          break label45;
          label289:
          localObject1 = null;
          break label69;
          label295:
          i = 0;
          break label80;
          label300:
          localObject2 = null;
          break label147;
          label306:
          if (((Integer)localObject2).intValue() != 1) {
            break label152;
          }
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label408;
            }
            localObject1 = new StringBuilder();
            localObject2 = this.kiF.getContext();
            kotlin.g.b.p.j(localObject2, "root.context");
            localStringBuilder.append(((Context)localObject2).getResources().getString(b.j.finder_live_lottery_card_input_any_comment) + 65292);
            break;
          }
          label408:
          if (localObject1 == null) {
            continue;
          }
          localObject2 = new StringBuilder();
          localObject3 = af.aaBG;
          localObject3 = this.kiF.getContext();
          kotlin.g.b.p.j(localObject3, "root.context");
          localObject3 = ((Context)localObject3).getResources().getString(b.j.finder_live_lottery_card_desc_comment);
          kotlin.g.b.p.j(localObject3, "root.context.resources.g…ottery_card_desc_comment)");
          localObject1 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject1 }, 1));
          kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
          localStringBuilder.append((String)localObject1 + 65292);
          continue;
          label518:
          if (((Integer)localObject2).intValue() != 2) {
            continue;
          }
          localObject1 = new StringBuilder();
          localObject2 = this.kiF.getContext();
          kotlin.g.b.p.j(localObject2, "root.context");
          localStringBuilder.append(((Context)localObject2).getResources().getString(b.j.finder_live_lottery_like_attend) + 65292);
          continue;
        }
        AppMethodBeat.o(284108);
        return;
      }
    }
    Log.i(this.TAG, "setLotteryDesc winnerCnt:".concat(String.valueOf(i)));
    if (paramTextView != null)
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(284108);
      return;
    }
    AppMethodBeat.o(284108);
  }
  
  public final void a(final boolean paramBoolean, final com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml)
  {
    AppMethodBeat.i(284107);
    kotlin.g.b.p.k(paraml, "lotteryInfoWrapper");
    super.a(paramBoolean, paraml);
    d.uiThread((kotlin.g.a.a)new a(this, paraml, paramBoolean));
    AppMethodBeat.o(284107);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(284105);
    super.initView();
    this.ymR = this.kiF.findViewById(b.f.running_container);
    Object localObject = this.ymR;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(b.f.desc);
      this.msF = ((TextView)localObject);
      localObject = this.ymR;
      if (localObject == null) {
        break label539;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.detail_countdown);
      label69:
      this.ymS = ((TextView)localObject);
      localObject = this.ymR;
      if (localObject == null) {
        break label544;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.detail_attend);
      label94:
      this.ymT = ((TextView)localObject);
      localObject = this.ymT;
      if (localObject == null) {
        break label549;
      }
      localObject = ((TextView)localObject).getPaint();
      label113:
      ar.a((Paint)localObject, 0.8F);
      localObject = this.ymR;
      if (localObject == null) {
        break label554;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.cancel);
      label143:
      this.mRJ = ((TextView)localObject);
      localObject = this.mRJ;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this));
      }
      this.ymU = this.kiF.findViewById(b.f.done_container);
      localObject = this.ymU;
      if (localObject == null) {
        break label559;
      }
      localObject = ((View)localObject).findViewById(b.f.winner_list_container);
      label203:
      this.ymV = ((View)localObject);
      localObject = this.ymU;
      if (localObject == null) {
        break label564;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.nobody_attend_desc);
      label228:
      this.ymX = ((TextView)localObject);
      localObject = this.ymU;
      if (localObject == null) {
        break label569;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.nobody_attend);
      label253:
      this.ymW = ((TextView)localObject);
      localObject = this.ymW;
      if (localObject == null) {
        break label574;
      }
      localObject = ((TextView)localObject).getPaint();
      label272:
      ar.a((Paint)localObject, 0.8F);
      localObject = this.ymU;
      if (localObject == null) {
        break label579;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.winner_count);
      label302:
      this.ymY = ((TextView)localObject);
      localObject = this.ymY;
      if (localObject == null) {
        break label584;
      }
      localObject = ((TextView)localObject).getPaint();
      label321:
      ar.a((Paint)localObject, 0.8F);
      localObject = this.ymU;
      if (localObject == null) {
        break label589;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.total_participate);
      label351:
      this.ymZ = ((TextView)localObject);
      localObject = this.ymU;
      if (localObject == null) {
        break label594;
      }
      localObject = (RecyclerView)((View)localObject).findViewById(b.f.winner_rv);
      label376:
      this.yna = ((RecyclerView)localObject);
      this.ynd = new com.tencent.mm.plugin.finder.live.view.adapter.p(getBuContext());
      localObject = this.yna;
      if (localObject != null)
      {
        this.kiF.getContext();
        ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.ynd);
        ((RecyclerView)localObject).a((RecyclerView.l)new e(this));
      }
      localObject = this.ymU;
      if (localObject == null) {
        break label599;
      }
      localObject = ((View)localObject).findViewById(b.f.winner_list_footer);
      label472:
      this.tzi = ((View)localObject);
      localObject = this.ymU;
      if (localObject == null) {
        break label604;
      }
      localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
      label497:
      this.ynb = ((TextView)localObject);
      localObject = this.ymU;
      if (localObject == null) {
        break label609;
      }
    }
    label539:
    label544:
    label549:
    label554:
    label559:
    label564:
    label569:
    label574:
    label579:
    label584:
    label589:
    label594:
    label599:
    label604:
    label609:
    for (localObject = (TextView)((View)localObject).findViewById(b.f.statement_tips);; localObject = null)
    {
      this.ync = ((TextView)localObject);
      AppMethodBeat.o(284105);
      return;
      localObject = null;
      break;
      localObject = null;
      break label69;
      localObject = null;
      break label94;
      localObject = null;
      break label113;
      localObject = null;
      break label143;
      localObject = null;
      break label203;
      localObject = null;
      break label228;
      localObject = null;
      break label253;
      localObject = null;
      break label272;
      localObject = null;
      break label302;
      localObject = null;
      break label321;
      localObject = null;
      break label351;
      localObject = null;
      break label376;
      localObject = null;
      break label472;
      localObject = null;
      break label497;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(s params, com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class b
    implements x.a
  {
    b(s params, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(285340);
      kotlin.g.b.p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.ynh.business(g.class)).a(paramazs.xHW);
        ((g)this.ynh.business(g.class)).d(paramazs);
        s.d(this.ynh);
      }
      s.e(this.ynh);
      s.f(this.ynh);
      AppMethodBeat.o(285340);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<bal, x>
  {
    c(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<bal, x>
  {
    d(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    e(s params) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(259262);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(259262);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kM();
      s.a(this.ynh, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(259262);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(259264);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(259264);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(s params) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(282871);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      s.a(this.ynh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(282871);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$onCancelBtnClick$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static final class g
    implements v.a
  {
    public final void a(final int paramInt1, final int paramInt2, String paramString, final azc paramazc)
    {
      AppMethodBeat.i(282344);
      kotlin.g.b.p.k(paramazc, "resp");
      d.uiThread((kotlin.g.a.a)new a(this, paramInt1, paramInt2, paramazc));
      AppMethodBeat.o(282344);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(s.g paramg, int paramInt1, int paramInt2, azc paramazc)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(s params)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class i
    implements x.a
  {
    i(s params, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(288367);
      kotlin.g.b.p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.ynh.business(g.class)).a(paramazs.xHW);
        ((g)this.ynh.business(g.class)).d(paramazs);
        s.d(this.ynh);
      }
      AppMethodBeat.o(288367);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(s params, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.s
 * JD-Core Version:    0.7.0.1
 */