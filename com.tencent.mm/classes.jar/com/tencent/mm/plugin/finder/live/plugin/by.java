package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.cgi.o.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.adapter.f;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.ay;
import com.tencent.mm.plugin.finder.report.live.s.bc;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awg;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.LinkedList;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_NO_WIN_UI", "", "getDONE_NO_WIN_UI", "()I", "DONE_WINNER_LIST_UI", "getDONE_WINNER_LIST_UI", "DONE_WIN_UI", "getDONE_WIN_UI", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "UNDEFINE_UI", "getUNDEFINE_UI", "attendBtn", "Landroid/widget/TextView;", "attendedBtn", "chaseWayTip", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "curLotteryUIState", "getCurLotteryUIState", "setCurLotteryUIState", "(I)V", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneLotteryBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "doneNoWin", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerLotteryResultContainer", "doneWinnerRv", "Landroid/support/v7/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "lotteryArrow", "lotteryDetail", "lotteryDetailContainer", "runningContainer", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "winnerAvatar", "Landroid/widget/ImageView;", "winnerNickname", "winnerTips", "changeToUnvisible", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneDetailView", "initRunningView", "initView", "initWinnerListView", "isDoneUIShowing", "onAttendBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "updateCountDown", "localRemainTime", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "visitorDoneAction", "visitorLotteryCancelled", "visitorLotteryComputing", "visitorLotteryDone", "fromUpdate", "visitorLotteryDoneWinnerList", "showBackIcon", "visitorLotteryRunning", "visitorOpenCard", "plugin-finder_release"})
public final class by
  extends an
{
  final String TAG;
  final com.tencent.mm.live.c.b hOp;
  TextView jCB;
  View qdl;
  private View unA;
  private TextView unD;
  private TextView unE;
  private RecyclerView unF;
  TextView unG;
  f unI;
  boolean unJ;
  final kotlin.g.a.b<awi, x> unK;
  final kotlin.g.a.b<awi, x> unL;
  final int unt;
  final int unv;
  private View unw;
  TextView unx;
  TextView uny;
  private View unz;
  private final int uvA;
  private volatile int uvB;
  TextView uvC;
  TextView uvD;
  WeImageView uvE;
  private View uvF;
  private TextView uvG;
  private TextView uvH;
  private ImageView uvI;
  private TextView uvJ;
  private TextView uvK;
  View uvL;
  private TextView uvM;
  private View uvN;
  private final int uvx;
  private final int uvy;
  private final int uvz;
  
  public by(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247203);
    this.hOp = paramb;
    this.TAG = "FinderLiveLotteryVisitorCardPlugin";
    this.uvx = -1;
    this.uvy = 1;
    this.uvz = 2;
    this.uvA = 3;
    this.uvB = this.uvx;
    this.unv = 10;
    this.unK = ((kotlin.g.a.b)new b(this));
    this.unL = ((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(247203);
  }
  
  private final void a(avy paramavy)
  {
    Object localObject3 = null;
    AppMethodBeat.i(247196);
    Object localObject4;
    Object localObject2;
    if (paramavy != null)
    {
      localObject1 = paramavy.tWe;
      localObject4 = this.unD;
      if (localObject4 != null)
      {
        localObject2 = ae.SYK;
        localObject2 = this.hwr.getContext();
        p.g(localObject2, "root.context");
        String str = ((Context)localObject2).getResources().getString(2131760064);
        p.g(str, "root.context.resources.g…ive_lottery_winner_count)");
        if (localObject1 == null) {
          break label274;
        }
        localObject2 = Integer.valueOf(((awi)localObject1).LHc);
        label80:
        localObject2 = String.format(str, Arrays.copyOf(new Object[] { localObject2 }, 1));
        p.g(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)localObject2);
      }
      localObject2 = this.unE;
      if (localObject2 != null)
      {
        localObject4 = ae.SYK;
        localObject4 = this.hwr.getContext();
        p.g(localObject4, "root.context");
        localObject4 = ((Context)localObject4).getResources().getString(2131760055);
        p.g(localObject4, "root.context.resources.g…ottery_participate_count)");
        if (localObject1 == null) {
          break label279;
        }
      }
    }
    label274:
    label279:
    for (Object localObject1 = Integer.valueOf(((awi)localObject1).trl);; localObject1 = null)
    {
      localObject1 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject1 }, 1));
      p.g(localObject1, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.unI;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (paramavy != null)
        {
          paramavy = paramavy.LGt;
          localObject1 = localObject3;
          if (paramavy != null) {
            localObject1 = paramavy.LHf;
          }
        }
        ((f)localObject2).an((LinkedList)localObject1);
      }
      paramavy = this.unI;
      if (paramavy == null) {
        break label284;
      }
      paramavy.notifyDataSetChanged();
      AppMethodBeat.o(247196);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label80;
    }
    label284:
    AppMethodBeat.o(247196);
  }
  
  private final void b(final avy paramavy)
  {
    com.tencent.mm.bw.b localb = null;
    AppMethodBeat.i(247197);
    Object localObject;
    if (paramavy != null)
    {
      localObject = paramavy.LGt;
      if (localObject != null)
      {
        localObject = ((awk)localObject).LHf;
        if (localObject == null) {}
      }
    }
    for (int i = ((LinkedList)localObject).size();; i = 0)
    {
      Log.i(this.TAG, "parseWinnerList winnerListSize:".concat(String.valueOf(i)));
      if (i <= 0) {
        break;
      }
      a(paramavy);
      AppMethodBeat.o(247197);
      return;
    }
    paramavy = getLiveData().uEa;
    if (paramavy != null)
    {
      paramavy = paramavy.tWe;
      if (paramavy == null) {}
    }
    for (paramavy = paramavy.id;; paramavy = null)
    {
      Log.i(this.TAG, "parseWinnerList record is empty!lotteryId:".concat(String.valueOf(paramavy)));
      if (paramavy == null) {
        break;
      }
      localObject = o.ujN;
      localObject = o.getFinderLiveAssistant();
      if (localObject == null) {
        break;
      }
      avy localavy = getLiveData().uEc;
      if (localavy != null) {
        localb = localavy.lastBuffer;
      }
      ((s)localObject).a(paramavy, localb, (o.a)new k(this, paramavy));
      AppMethodBeat.o(247197);
      return;
    }
    AppMethodBeat.o(247197);
  }
  
  final void Jj(int paramInt)
  {
    AppMethodBeat.i(247195);
    Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(paramInt)));
    this.uvB = paramInt;
    Object localObject;
    if (paramInt == this.unt)
    {
      localObject = this.unw;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.unz;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.urW;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(2131233109);
        AppMethodBeat.o(247195);
        return;
      }
      AppMethodBeat.o(247195);
      return;
    }
    if (paramInt == this.uvy)
    {
      localObject = this.unw;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.unz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.unA;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.uvF;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.urW;
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(2131233109);
        AppMethodBeat.o(247195);
        return;
      }
      AppMethodBeat.o(247195);
      return;
    }
    if (paramInt == this.uvz)
    {
      localObject = this.unw;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.unz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.unA;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.uvF;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.uvG;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.uvH;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.uvI;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.uvJ;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.urW;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2131233109);
      }
      localObject = m.vli;
      m.a(s.ay.vsM, String.valueOf(s.bc.vtg.result));
      AppMethodBeat.o(247195);
      return;
    }
    if (paramInt == this.uvA)
    {
      localObject = this.unw;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.unz;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.unA;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.uvF;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.uvG;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.uvH;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.uvI;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.uvJ;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.urW;
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2131233110);
      }
      localObject = m.vli;
      m.a(s.ay.vsM, String.valueOf(s.bc.vtf.result));
    }
    AppMethodBeat.o(247195);
  }
  
  final void Jk(final int paramInt)
  {
    AppMethodBeat.i(247198);
    d.h((kotlin.g.a.a)new l(this, paramInt));
    AppMethodBeat.o(247198);
  }
  
  final void a(awi paramawi, boolean paramBoolean)
  {
    AppMethodBeat.i(247200);
    if ((this.hwr.getVisibility() == 0) && ((this.uvB == this.uvA) || (this.uvB == this.uvz) || (this.uvB == this.uvy))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "visitorLotteryDone fromUpdate:" + paramBoolean + ",isDoneUIShowing:" + bool);
      if ((!paramBoolean) || (!bool)) {
        break;
      }
      AppMethodBeat.o(247200);
      return;
    }
    bool = d.cW(paramawi.extFlag, 2);
    paramBoolean = d.cW(paramawi.extFlag, 1);
    int i = paramawi.trl;
    int j = paramawi.LHc;
    paramawi = z.aUa();
    Object localObject;
    if (bool)
    {
      Jj(this.uvA);
      localObject = this.uvI;
      if (localObject != null) {
        a.b.c((ImageView)localObject, z.aTY());
      }
      localObject = this.uvJ;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.hwr.getContext(), (CharSequence)paramawi));
      }
      getLiveData().uEd = true;
      paramawi = this.uvK;
      if (paramawi != null)
      {
        paramawi.setVisibility(0);
        paramBoolean = true;
        if ((j <= 0) || (i < j)) {
          break label655;
        }
        paramawi = this.uvN;
        if (paramawi != null) {
          paramawi.setVisibility(0);
        }
        label257:
        if (!paramBoolean) {
          break label673;
        }
        paramawi = this.uvM;
        if (paramawi != null)
        {
          localObject = ae.SYK;
          localObject = this.hwr.getContext();
          p.g(localObject, "root.context");
          localObject = ((Context)localObject).getResources().getString(2131760059);
          p.g(localObject, "root.context.resources.g…nder_live_lottery_result)");
          localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(i) }, 2));
          p.g(localObject, "java.lang.String.format(format, *args)");
          paramawi.setText((CharSequence)localObject);
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "visitorLotteryDone isWin:" + bool + ",participateCnt:" + i + ",realWinnerCnt:" + j + ",haveLotteryResult:" + paramBoolean);
      AppMethodBeat.o(247200);
      return;
      paramBoolean = true;
      break;
      if (paramBoolean)
      {
        Jj(this.uvz);
        paramawi = this.uvG;
        if (paramawi != null)
        {
          localObject = this.hwr.getContext();
          p.g(localObject, "root.context");
          paramawi.setText((CharSequence)((Context)localObject).getResources().getString(2131760052));
        }
        paramawi = this.uvK;
        if (paramawi != null)
        {
          paramawi.setVisibility(8);
          paramBoolean = true;
          break;
        }
        paramBoolean = true;
        break;
      }
      if ((j > 0) && (i >= j))
      {
        ny(false);
        paramawi = this.uvK;
        if (paramawi != null) {
          paramawi.setVisibility(8);
        }
        paramawi = m.vli;
        m.a(s.ay.vsM, String.valueOf(s.bc.vth.result));
        paramBoolean = true;
        break;
      }
      Jj(this.uvz);
      paramawi = this.uvG;
      if (paramawi != null)
      {
        localObject = this.hwr.getContext();
        p.g(localObject, "root.context");
        paramawi.setText((CharSequence)((Context)localObject).getResources().getString(2131760054));
      }
      paramawi = this.uvK;
      if (paramawi != null) {
        paramawi.setVisibility(8);
      }
      paramawi = m.vli;
      m.a(s.ay.vsM, String.valueOf(s.bc.vth.result));
      paramBoolean = false;
      break;
      label655:
      paramawi = this.uvN;
      if (paramawi == null) {
        break label257;
      }
      paramawi.setVisibility(8);
      break label257;
      label673:
      paramawi = this.uvM;
      if (paramawi != null)
      {
        localObject = ae.SYK;
        localObject = this.hwr.getContext();
        p.g(localObject, "root.context");
        localObject = ((Context)localObject).getResources().getString(2131760062);
        p.g(localObject, "root.context.resources.g…r_live_lottery_statement)");
        localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(j), Integer.valueOf(i) }, 2));
        p.g(localObject, "java.lang.String.format(format, *args)");
        paramawi.setText((CharSequence)localObject);
      }
    }
  }
  
  public final void a(final boolean paramBoolean, final i parami)
  {
    AppMethodBeat.i(247199);
    p.h(parami, "lotteryInfoWrapper");
    super.a(paramBoolean, parami);
    d.h((kotlin.g.a.a)new m(this, parami, paramBoolean));
    AppMethodBeat.o(247199);
  }
  
  public final void dhx()
  {
    AppMethodBeat.i(247202);
    super.dhx();
    this.uvB = this.uvx;
    AppMethodBeat.o(247202);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(247194);
    super.initView();
    this.unw = this.hwr.findViewById(2131307196);
    Object localObject1 = this.unw;
    if (localObject1 != null)
    {
      localObject1 = (TextView)((View)localObject1).findViewById(2131299495);
      this.jCB = ((TextView)localObject1);
      localObject1 = this.jCB;
      if (localObject1 == null) {
        break label870;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label65:
      ao.a((Paint)localObject1, 0.8F);
      localObject1 = this.unw;
      if (localObject1 == null) {
        break label875;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131299546);
      label95:
      this.unx = ((TextView)localObject1);
      localObject1 = this.unw;
      if (localObject1 == null) {
        break label880;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131299541);
      label120:
      this.uny = ((TextView)localObject1);
      localObject1 = this.unw;
      if (localObject1 == null) {
        break label885;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131302254);
      label145:
      this.uvD = ((TextView)localObject1);
      localObject1 = this.unw;
      if (localObject1 == null) {
        break label890;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131297074);
      label170:
      this.uvC = ((TextView)localObject1);
      localObject1 = this.uvC;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
      }
      this.unz = this.hwr.findViewById(2131299730);
      localObject1 = this.unz;
      if (localObject1 == null) {
        break label895;
      }
      localObject1 = ((View)localObject1).findViewById(2131310513);
      label230:
      this.unA = ((View)localObject1);
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label900;
      }
      localObject1 = (WeImageView)((View)localObject1).findViewById(2131303840);
      label255:
      this.uvE = ((WeImageView)localObject1);
      localObject1 = this.uvE;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.uvE;
      if (localObject1 != null) {
        ((WeImageView)localObject1).post((Runnable)new h(this));
      }
      localObject1 = this.uvE;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new i(this));
      }
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label905;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131310512);
      label343:
      this.unD = ((TextView)localObject1);
      localObject1 = this.unD;
      if (localObject1 == null) {
        break label910;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label362:
      ao.a((Paint)localObject1, 0.8F);
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label915;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131309366);
      label392:
      this.unE = ((TextView)localObject1);
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label920;
      }
      localObject1 = (RecyclerView)((View)localObject1).findViewById(2131310517);
      label417:
      this.unF = ((RecyclerView)localObject1);
      this.unI = new f(getLiveData());
      localObject1 = this.unF;
      if (localObject1 != null)
      {
        this.hwr.getContext();
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.unI);
        ((RecyclerView)localObject1).a((RecyclerView.l)new g(this));
      }
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label925;
      }
      localObject1 = ((View)localObject1).findViewById(2131310514);
      label513:
      this.qdl = ((View)localObject1);
      localObject1 = this.unA;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131303685);
      label538:
      this.unG = ((TextView)localObject1);
      localObject1 = this.unz;
      if (localObject1 == null) {
        break label935;
      }
      localObject1 = ((View)localObject1).findViewById(2131303860);
      label560:
      this.uvF = ((View)localObject1);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label940;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131305466);
      label585:
      this.uvG = ((TextView)localObject1);
      localObject1 = this.uvG;
      if (localObject1 == null) {
        break label945;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label604:
      ao.a((Paint)localObject1, 0.8F);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label950;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131310518);
      label634:
      this.uvH = ((TextView)localObject1);
      localObject1 = this.uvH;
      if (localObject1 == null) {
        break label955;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label653:
      ao.a((Paint)localObject1, 0.8F);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label960;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(2131310510);
      label683:
      this.uvI = ((ImageView)localObject1);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label965;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131310515);
      label708:
      this.uvJ = ((TextView)localObject1);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label970;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(2131298291);
      label733:
      this.uvK = ((TextView)localObject1);
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label975;
      }
      localObject1 = ((View)localObject1).findViewById(2131303845);
      label755:
      this.uvL = ((View)localObject1);
      localObject1 = this.uvL;
      if (localObject1 != null) {
        ((View)localObject1).post((Runnable)new d(this));
      }
      localObject1 = this.uvL;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      }
      localObject1 = this.uvF;
      if (localObject1 == null) {
        break label980;
      }
    }
    label900:
    label905:
    label910:
    label915:
    label920:
    label925:
    label930:
    label935:
    label940:
    label945:
    label950:
    label955:
    label960:
    label965:
    label970:
    label975:
    label980:
    for (localObject1 = (TextView)((View)localObject1).findViewById(2131303844);; localObject1 = null)
    {
      this.uvM = ((TextView)localObject1);
      View localView = this.uvF;
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView.findViewById(2131303839);
      }
      this.uvN = ((View)localObject1);
      AppMethodBeat.o(247194);
      return;
      localObject1 = null;
      break;
      label870:
      localObject1 = null;
      break label65;
      label875:
      localObject1 = null;
      break label95;
      label880:
      localObject1 = null;
      break label120;
      label885:
      localObject1 = null;
      break label145;
      label890:
      localObject1 = null;
      break label170;
      label895:
      localObject1 = null;
      break label230;
      localObject1 = null;
      break label255;
      localObject1 = null;
      break label343;
      localObject1 = null;
      break label362;
      localObject1 = null;
      break label392;
      localObject1 = null;
      break label417;
      localObject1 = null;
      break label513;
      localObject1 = null;
      break label538;
      localObject1 = null;
      break label560;
      localObject1 = null;
      break label585;
      localObject1 = null;
      break label604;
      localObject1 = null;
      break label634;
      localObject1 = null;
      break label653;
      localObject1 = null;
      break label683;
      localObject1 = null;
      break label708;
      localObject1 = null;
      break label733;
      localObject1 = null;
      break label755;
    }
  }
  
  final void ny(boolean paramBoolean)
  {
    AppMethodBeat.i(247201);
    Object localObject = getLiveData().uEa;
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((i)localObject).tWe;
      if (localObject != null)
      {
        i = ((awi)localObject).LHc;
        localObject = getLiveData().uEa;
        if (localObject == null) {
          break label221;
        }
        localObject = ((i)localObject).tWe;
        if (localObject == null) {
          break label221;
        }
        j = ((awi)localObject).trl;
        label70:
        Log.i(this.TAG, "visitorLotteryDoneWinnerList realWinnerCnt:" + i + ",participateCount:" + j);
        Jj(this.uvy);
        localObject = this.unD;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.unE;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.unF;
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        b(getLiveData().uEc);
        if (!paramBoolean) {
          break label226;
        }
        localObject = this.uvE;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      localObject = m.vli;
      m.a(s.ay.vsN, "");
      AppMethodBeat.o(247201);
      return;
      i = 0;
      break;
      label221:
      j = 0;
      break label70;
      label226:
      localObject = this.uvE;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class a
    implements o.a
  {
    a(by paramby, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(247177);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uvO.getLiveData().a(paramavy.tWe);
        this.uvO.getLiveData().d(paramavy);
        by.a(this.uvO);
      }
      this.uvO.Jk(8);
      this.uvO.unJ = false;
      AppMethodBeat.o(247177);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<awi, x>
  {
    b(by paramby)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<awi, x>
  {
    c(by paramby)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(by paramby) {}
    
    public final void run()
    {
      AppMethodBeat.i(247182);
      Rect localRect = new Rect();
      Object localObject = this.uvO.uvL;
      if (localObject != null) {
        ((View)localObject).getHitRect(localRect);
      }
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      int i = ((Context)localObject).getResources().getDimensionPixelOffset(2131165314);
      localRect.inset(-i, -i);
      localObject = this.uvO.uvL;
      if (localObject != null) {}
      for (localObject = ((View)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(247182);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, this.uvO.uvL));
      AppMethodBeat.o(247182);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(by paramby) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247183);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.uvO.ny(true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247183);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(by paramby) {}
    
    public final void onClick(View paramView)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(247184);
      Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject3).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).axR());
      localObject3 = this.uvO;
      paramView = ((by)localObject3).getLiveData().uEa;
      label90:
      label94:
      Object localObject4;
      if (paramView != null)
      {
        paramView = paramView.tWe;
        if (paramView != null)
        {
          paramView = paramView.LGn;
          if (paramView != null)
          {
            paramView = Integer.valueOf(paramView.LGY);
            if (paramView != null) {
              break label212;
            }
            if (paramView != null) {
              break label326;
            }
            localObject2 = ((by)localObject3).TAG;
            localObject4 = new StringBuilder("onAttendBtnClick type:");
            paramView = ((by)localObject3).getLiveData().uEa;
            if (paramView == null) {
              break label357;
            }
            paramView = paramView.tWe;
            if (paramView == null) {
              break label357;
            }
            paramView = paramView.LGn;
            if (paramView == null) {
              break label357;
            }
          }
        }
      }
      label212:
      label357:
      for (paramView = Integer.valueOf(paramView.LGY);; paramView = null)
      {
        Log.i((String)localObject2, paramView);
        paramView = (View)localObject1;
        for (;;)
        {
          if (((by)localObject3).hOp.getLiveRole() == 0)
          {
            localObject1 = m.vli;
            m.a(s.ay.vsJ, paramView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247184);
          return;
          paramView = null;
          break;
          if (paramView.intValue() != 1) {
            break label90;
          }
          ((by)localObject3).rg(8);
          localObject1 = ((by)localObject3).getLiveData().uEa;
          paramView = (View)localObject2;
          if (localObject1 != null)
          {
            localObject1 = ((i)localObject1).tWe;
            paramView = (View)localObject2;
            if (localObject1 != null)
            {
              localObject1 = ((awi)localObject1).LGn;
              paramView = (View)localObject2;
              if (localObject1 != null) {
                paramView = ((awg)localObject1).LGZ;
              }
            }
          }
          if (paramView != null)
          {
            localObject1 = ((by)localObject3).hOp;
            localObject2 = b.c.hNi;
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("PARAM_FINDER_LIVE_AUTO_INPUT_MSG", paramView);
            ((com.tencent.mm.live.c.b)localObject1).statusChange((b.c)localObject2, (Bundle)localObject4);
          }
          else
          {
            b.b.a(((by)localObject3).hOp, b.c.hNi);
            continue;
            if (paramView.intValue() != 2) {
              break label94;
            }
            ((by)localObject3).rg(8);
            b.b.a(((by)localObject3).hOp, b.c.hNI);
            paramView = (View)localObject1;
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    g(by paramby) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(247185);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(247185);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kv();
      by localby = this.uvO;
      paramRecyclerView = localby.unI;
      if (paramRecyclerView != null)
      {
        localObject1 = localby.getLiveData().uEc;
        if ((localObject1 == null) || (((avy)localObject1).continueFlag != 1) || (paramInt < 0) || (paramInt < paramRecyclerView.getItemCount() - localby.unv)) {
          break label347;
        }
        paramRecyclerView = localby.getLiveData().uEa;
        if (paramRecyclerView == null) {
          break label337;
        }
        paramRecyclerView = paramRecyclerView.tWe;
        if (paramRecyclerView == null) {
          break label337;
        }
        paramRecyclerView = paramRecyclerView.id;
        if ((!localby.unJ) && (paramRecyclerView != null))
        {
          Object localObject3 = localby.TAG;
          Object localObject4 = new StringBuilder("load more product,product size:");
          localObject1 = localby.getLiveData().uEc;
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
          localby.unJ = true;
          localby.Jk(0);
          localObject1 = o.ujN;
          localObject3 = o.getFinderLiveAssistant();
          if (localObject3 != null)
          {
            localObject4 = localby.getLiveData().uEc;
            localObject1 = localObject2;
            if (localObject4 != null) {
              localObject1 = ((avy)localObject4).lastBuffer;
            }
            ((s)localObject3).a(paramRecyclerView, (com.tencent.mm.bw.b)localObject1, (o.a)new by.a(localby, paramInt));
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(247185);
        return;
        label337:
        paramRecyclerView = null;
        break;
        label342:
        localObject1 = null;
        break label233;
        label347:
        localby.Jk(8);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(247186);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(247186);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(by paramby) {}
    
    public final void run()
    {
      AppMethodBeat.i(247187);
      Rect localRect = new Rect();
      Object localObject = this.uvO.uvE;
      if (localObject != null) {
        ((WeImageView)localObject).getHitRect(localRect);
      }
      localObject = MMApplicationContext.getContext();
      p.g(localObject, "MMApplicationContext.getContext()");
      int i = ((Context)localObject).getResources().getDimensionPixelOffset(2131165296);
      localRect.inset(-i, -i);
      localObject = this.uvO.uvE;
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(247187);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, (View)this.uvO.uvE));
      AppMethodBeat.o(247187);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(by paramby) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247188);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.uvO.getLiveData().uEa;
      if (paramView != null)
      {
        paramView = paramView.tWe;
        if (paramView != null) {
          this.uvO.a(paramView, false);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247188);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(by paramby)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class k
    implements o.a
  {
    k(by paramby, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, avy paramavy)
    {
      AppMethodBeat.i(247191);
      p.h(paramavy, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.uvO.getLiveData().a(paramavy.tWe);
        this.uvO.getLiveData().d(paramavy);
        by.a(this.uvO);
        AppMethodBeat.o(247191);
        return;
      }
      paramString = this.uvO.getLiveData().uEa;
      if (paramString != null)
      {
        paramString = paramString.tWe;
        if (paramString != null)
        {
          d.h((kotlin.g.a.a)new q(paramString) {});
          AppMethodBeat.o(247191);
          return;
        }
      }
      AppMethodBeat.o(247191);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(by paramby, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<x>
  {
    m(by paramby, i parami, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.by
 * JD-Core Version:    0.7.0.1
 */