package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.cgi.m;
import com.tencent.mm.plugin.finder.live.model.cgi.m.a;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.adapter.f;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.protocal.protobuf.avp;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_UI", "", "getDONE_UI", "()I", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "cancelBtn", "Landroid/widget/TextView;", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneNobodyAttend", "doneNobodyAttendDesc", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerRv", "Landroid/support/v7/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "runningContainer", "statementTips", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "anchorDoneAction", "anchorLotteryCancelled", "anchorLotteryComputing", "anchorLotteryDone", "anchorLotteryRunning", "lcoalRemainTime", "anchorOpenCard", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneView", "initRunningView", "initView", "onCancelBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "setLotteryDesc", "updateCountDown", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "plugin-finder_release"})
public final class q
  extends an
{
  final String TAG;
  final com.tencent.mm.live.c.b hOp;
  TextView jCB;
  TextView kaq;
  View qdl;
  private View unA;
  private TextView unB;
  private TextView unC;
  private TextView unD;
  private TextView unE;
  private RecyclerView unF;
  TextView unG;
  private TextView unH;
  f unI;
  boolean unJ;
  final kotlin.g.a.b<awi, x> unK;
  final kotlin.g.a.b<awi, x> unL;
  final int unt;
  private final int unu;
  final int unv;
  private View unw;
  TextView unx;
  TextView uny;
  private View unz;
  
  public q(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246508);
    this.hOp = paramb;
    this.TAG = "FinderLiveLotteryAnchorCardPlugin";
    this.unu = 1;
    this.unv = 10;
    this.unK = ((kotlin.g.a.b)new c(this));
    this.unL = ((kotlin.g.a.b)new d(this));
    AppMethodBeat.o(246508);
  }
  
  private final void a(avy paramavy)
  {
    AppMethodBeat.i(246507);
    Object localObject1;
    if (paramavy != null)
    {
      localObject1 = paramavy.tWe;
      if (localObject1 == null) {
        break label259;
      }
      TextView localTextView = this.unD;
      Object localObject2;
      if (localTextView != null)
      {
        localObject2 = ae.SYK;
        localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(2131760064);
        p.g(localObject2, "root.context.resources.g…ive_lottery_winner_count)");
        localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((awi)localObject1).LHc) }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject2);
      }
      localTextView = this.unE;
      if (localTextView != null)
      {
        localObject2 = ae.SYK;
        localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        localObject2 = ((Context)localObject2).getResources().getString(2131760055);
        p.g(localObject2, "root.context.resources.g…ottery_participate_count)");
        localObject1 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(((awi)localObject1).trl) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        localTextView.setText((CharSequence)localObject1);
      }
      label202:
      localObject1 = this.unI;
      if (localObject1 != null)
      {
        if (paramavy == null) {
          break label272;
        }
        paramavy = paramavy.LGt;
        if (paramavy == null) {
          break label272;
        }
      }
    }
    label259:
    label272:
    for (paramavy = paramavy.LHf;; paramavy = null)
    {
      ((f)localObject1).an(paramavy);
      paramavy = this.unI;
      if (paramavy == null) {
        break label277;
      }
      paramavy.notifyDataSetChanged();
      AppMethodBeat.o(246507);
      return;
      localObject1 = null;
      break;
      Log.e(this.TAG, "updateWinnerList error lotteryInfo is empty!");
      break label202;
    }
    label277:
    AppMethodBeat.o(246507);
  }
  
  final void Jj(int paramInt)
  {
    AppMethodBeat.i(246503);
    Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(paramInt)));
    if (paramInt == this.unu)
    {
      localView = this.unw;
      if (localView != null) {
        localView.setVisibility(8);
      }
      localView = this.unz;
      if (localView != null)
      {
        localView.setVisibility(0);
        AppMethodBeat.o(246503);
        return;
      }
      AppMethodBeat.o(246503);
      return;
    }
    View localView = this.unw;
    if (localView != null) {
      localView.setVisibility(0);
    }
    localView = this.unz;
    if (localView != null)
    {
      localView.setVisibility(8);
      AppMethodBeat.o(246503);
      return;
    }
    AppMethodBeat.o(246503);
  }
  
  final void Jk(final int paramInt)
  {
    AppMethodBeat.i(246506);
    d.h((kotlin.g.a.a)new j(this, paramInt));
    AppMethodBeat.o(246506);
  }
  
  public final void a(final boolean paramBoolean, final i parami)
  {
    AppMethodBeat.i(246504);
    p.h(parami, "lotteryInfoWrapper");
    super.a(paramBoolean, parami);
    d.h((kotlin.g.a.a)new a(this, parami, paramBoolean));
    AppMethodBeat.o(246504);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(246502);
    super.initView();
    this.unw = this.hwr.findViewById(2131307196);
    Object localObject = this.unw;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131299495);
      this.jCB = ((TextView)localObject);
      localObject = this.unw;
      if (localObject == null) {
        break label539;
      }
      localObject = (TextView)((View)localObject).findViewById(2131299546);
      label69:
      this.unx = ((TextView)localObject);
      localObject = this.unw;
      if (localObject == null) {
        break label544;
      }
      localObject = (TextView)((View)localObject).findViewById(2131299541);
      label94:
      this.uny = ((TextView)localObject);
      localObject = this.uny;
      if (localObject == null) {
        break label549;
      }
      localObject = ((TextView)localObject).getPaint();
      label113:
      ao.a((Paint)localObject, 0.8F);
      localObject = this.unw;
      if (localObject == null) {
        break label554;
      }
      localObject = (TextView)((View)localObject).findViewById(2131297959);
      label143:
      this.kaq = ((TextView)localObject);
      localObject = this.kaq;
      if (localObject != null) {
        ((TextView)localObject).setOnClickListener((View.OnClickListener)new f(this));
      }
      this.unz = this.hwr.findViewById(2131299730);
      localObject = this.unz;
      if (localObject == null) {
        break label559;
      }
      localObject = ((View)localObject).findViewById(2131310513);
      label203:
      this.unA = ((View)localObject);
      localObject = this.unz;
      if (localObject == null) {
        break label564;
      }
      localObject = (TextView)((View)localObject).findViewById(2131305469);
      label228:
      this.unC = ((TextView)localObject);
      localObject = this.unz;
      if (localObject == null) {
        break label569;
      }
      localObject = (TextView)((View)localObject).findViewById(2131305468);
      label253:
      this.unB = ((TextView)localObject);
      localObject = this.unB;
      if (localObject == null) {
        break label574;
      }
      localObject = ((TextView)localObject).getPaint();
      label272:
      ao.a((Paint)localObject, 0.8F);
      localObject = this.unz;
      if (localObject == null) {
        break label579;
      }
      localObject = (TextView)((View)localObject).findViewById(2131310512);
      label302:
      this.unD = ((TextView)localObject);
      localObject = this.unD;
      if (localObject == null) {
        break label584;
      }
      localObject = ((TextView)localObject).getPaint();
      label321:
      ao.a((Paint)localObject, 0.8F);
      localObject = this.unz;
      if (localObject == null) {
        break label589;
      }
      localObject = (TextView)((View)localObject).findViewById(2131309366);
      label351:
      this.unE = ((TextView)localObject);
      localObject = this.unz;
      if (localObject == null) {
        break label594;
      }
      localObject = (RecyclerView)((View)localObject).findViewById(2131310517);
      label376:
      this.unF = ((RecyclerView)localObject);
      this.unI = new f(getLiveData());
      localObject = this.unF;
      if (localObject != null)
      {
        this.hwr.getContext();
        ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.unI);
        ((RecyclerView)localObject).a((RecyclerView.l)new e(this));
      }
      localObject = this.unz;
      if (localObject == null) {
        break label599;
      }
      localObject = ((View)localObject).findViewById(2131310514);
      label472:
      this.qdl = ((View)localObject);
      localObject = this.unz;
      if (localObject == null) {
        break label604;
      }
      localObject = (TextView)((View)localObject).findViewById(2131303685);
      label497:
      this.unG = ((TextView)localObject);
      localObject = this.unz;
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
    for (localObject = (TextView)((View)localObject).findViewById(2131308386);; localObject = null)
    {
      this.unH = ((TextView)localObject);
      AppMethodBeat.o(246502);
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
  
  final void m(TextView paramTextView)
  {
    AppMethodBeat.i(246505);
    Object localObject1 = getLiveData().uEa;
    Object localObject2;
    Object localObject3;
    label39:
    label63:
    int i;
    label74:
    StringBuilder localStringBuilder;
    if (localObject1 != null)
    {
      localObject2 = ((i)localObject1).tWe;
      if (localObject2 == null) {
        break label276;
      }
      localObject3 = ((awi)localObject2).description;
      if (localObject2 == null) {
        break label282;
      }
      localObject1 = ((awi)localObject2).LGn;
      if (localObject1 == null) {
        break label282;
      }
      localObject1 = ((awg)localObject1).LGZ;
      if (localObject2 == null) {
        break label288;
      }
      i = ((awi)localObject2).ugF;
      localStringBuilder = new StringBuilder();
      if (localObject3 != null) {
        localStringBuilder.append((String)localObject3 + '\n');
      }
      if (localObject2 == null) {
        break label293;
      }
      localObject2 = ((awi)localObject2).LGn;
      if (localObject2 == null) {
        break label293;
      }
      localObject2 = Integer.valueOf(((awg)localObject2).LGY);
      label141:
      if (localObject2 != null) {
        break label299;
      }
      label146:
      if (localObject2 != null) {
        break label509;
      }
    }
    for (;;)
    {
      if (i > 0)
      {
        localObject1 = ae.SYK;
        localObject1 = this.hwr.getContext();
        p.g(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(2131760031);
        p.g(localObject1, "root.context.resources.g…e_lottery_desc_winnercnt)");
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(i) }, 1));
        p.g(localObject1, "java.lang.String.format(format, *args)");
        localStringBuilder.append(String.valueOf(localObject1));
        if (paramTextView != null) {
          paramTextView.setText((CharSequence)localStringBuilder.toString());
        }
        if (paramTextView != null)
        {
          paramTextView.setVisibility(0);
          AppMethodBeat.o(246505);
          return;
          localObject2 = null;
          break;
          label276:
          localObject3 = null;
          break label39;
          label282:
          localObject1 = null;
          break label63;
          label288:
          i = 0;
          break label74;
          label293:
          localObject2 = null;
          break label141;
          label299:
          if (((Integer)localObject2).intValue() != 1) {
            break label146;
          }
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              break label400;
            }
            localObject1 = new StringBuilder();
            localObject2 = this.hwr.getContext();
            p.g(localObject2, "root.context");
            localStringBuilder.append(((Context)localObject2).getResources().getString(2131760023) + 65292);
            break;
          }
          label400:
          if (localObject1 == null) {
            continue;
          }
          localObject2 = new StringBuilder();
          localObject3 = ae.SYK;
          localObject3 = this.hwr.getContext();
          p.g(localObject3, "root.context");
          localObject3 = ((Context)localObject3).getResources().getString(2131760022);
          p.g(localObject3, "root.context.resources.g…ottery_card_desc_comment)");
          localObject1 = String.format((String)localObject3, Arrays.copyOf(new Object[] { localObject1 }, 1));
          p.g(localObject1, "java.lang.String.format(format, *args)");
          localStringBuilder.append((String)localObject1 + 65292);
          continue;
          label509:
          if (((Integer)localObject2).intValue() != 2) {
            continue;
          }
          localObject1 = new StringBuilder();
          localObject2 = this.hwr.getContext();
          p.g(localObject2, "root.context");
          localStringBuilder.append(((Context)localObject2).getResources().getString(2131760051) + 65292);
          continue;
        }
        AppMethodBeat.o(246505);
        return;
      }
    }
    Log.i(this.TAG, "setLotteryDesc winnerCnt:".concat(String.valueOf(i)));
    if (paramTextView != null)
    {
      paramTextView.setVisibility(8);
      AppMethodBeat.o(246505);
      return;
    }
    AppMethodBeat.o(246505);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    a(q paramq, i parami, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class b
    implements o.a
  {
    b(q paramq, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(246489);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.unM.getLiveData().a(paramavy.tWe);
        this.unM.getLiveData().d(paramavy);
        q.a(this.unM);
      }
      this.unM.Jk(8);
      this.unM.unJ = false;
      AppMethodBeat.o(246489);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<awi, x>
  {
    c(q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<awi, x>
  {
    d(q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    e(q paramq) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(246494);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(246494);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kv();
      q localq = this.unM;
      paramRecyclerView = localq.unI;
      if (paramRecyclerView != null)
      {
        localObject1 = localq.getLiveData().uEc;
        if ((localObject1 == null) || (((avy)localObject1).continueFlag != 1) || (paramInt < 0) || (paramInt < paramRecyclerView.getItemCount() - localq.unv)) {
          break label347;
        }
        paramRecyclerView = localq.getLiveData().uEa;
        if (paramRecyclerView == null) {
          break label337;
        }
        paramRecyclerView = paramRecyclerView.tWe;
        if (paramRecyclerView == null) {
          break label337;
        }
        paramRecyclerView = paramRecyclerView.id;
        if ((!localq.unJ) && (paramRecyclerView != null))
        {
          Object localObject3 = localq.TAG;
          Object localObject4 = new StringBuilder("load more product,product size:");
          localObject1 = localq.getLiveData().uEc;
          if (localObject1 == null) {
            break label342;
          }
          localObject1 = ((avy)localObject1).LGt;
          if (localObject1 == null) {
            break label342;
          }
          localObject1 = ((awk)localObject1).LHf;
          if (localObject1 == null) {
            break label342;
          }
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          label233:
          Log.i((String)localObject3, localObject1);
          localq.unJ = true;
          localq.Jk(0);
          localObject1 = o.ujN;
          localObject3 = o.getFinderLiveAssistant();
          if (localObject3 != null)
          {
            localObject4 = localq.getLiveData().uEc;
            localObject1 = localObject2;
            if (localObject4 != null) {
              localObject1 = ((avy)localObject4).lastBuffer;
            }
            ((s)localObject3).a(paramRecyclerView, (com.tencent.mm.bw.b)localObject1, (o.a)new q.b(localq, paramInt));
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(246494);
        return;
        label337:
        paramRecyclerView = null;
        break;
        label342:
        localObject1 = null;
        break label233;
        label347:
        localq.Jk(8);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246495);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initDoneView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(246495);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(q paramq) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(246496);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = this.unM;
      paramView = ((q)localObject1).getLiveData().liveInfo;
      long l1;
      long l2;
      Object localObject2;
      int i;
      label134:
      int k;
      if (paramView != null)
      {
        paramView = Long.valueOf(paramView.liveId);
        l1 = paramView.longValue();
        l2 = ((q)localObject1).getLiveData().hFK;
        paramView = ((q)localObject1).getLiveData().hwg;
        localObject2 = ((q)localObject1).getLiveData().uEa;
        if (localObject2 == null) {
          break label237;
        }
        localObject2 = ((i)localObject2).tWe;
        if (localObject2 == null) {
          break label237;
        }
        localObject2 = ((awi)localObject2).LGn;
        if (localObject2 == null) {
          break label237;
        }
        i = ((awg)localObject2).LGY;
        localObject2 = m.ukW;
        k = m.dgG();
        localObject2 = ((q)localObject1).getLiveData().uEa;
        if (localObject2 == null) {
          break label242;
        }
        localObject2 = ((i)localObject2).tWe;
        if (localObject2 == null) {
          break label242;
        }
      }
      label237:
      label242:
      for (int j = ((awi)localObject2).ugF;; j = 0)
      {
        new m(l1, l2, paramView, 0, "", i, "", k, j, (m.a)new q.g((q)localObject1)).aYI();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246496);
        return;
        paramView = null;
        break;
        i = 0;
        break label134;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$onCancelBtnClick$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveCreateLottery$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCreateLotteryResponse;", "plugin-finder_release"})
  public static final class g
    implements m.a
  {
    public final void a(final int paramInt1, final int paramInt2, String paramString, final avp paramavp)
    {
      AppMethodBeat.i(246498);
      p.h(paramavp, "resp");
      d.h((kotlin.g.a.a)new a(this, paramInt1, paramInt2, paramavp));
      AppMethodBeat.o(246498);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(q.g paramg, int paramInt1, int paramInt2, avp paramavp)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    h(q paramq)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class i
    implements o.a
  {
    i(q paramq, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(246500);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.unM.getLiveData().a(paramavy.tWe);
        this.unM.getLiveData().d(paramavy);
        q.a(this.unM);
      }
      AppMethodBeat.o(246500);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(q paramq, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.q
 * JD-Core Version:    0.7.0.1
 */