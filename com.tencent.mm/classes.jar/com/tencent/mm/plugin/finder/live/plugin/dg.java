package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.cgi.x.a;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bm;
import com.tencent.mm.plugin.finder.live.report.s.bq;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.g;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.dis;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.af;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DONE_NO_WIN_UI", "", "getDONE_NO_WIN_UI", "()I", "DONE_WINNER_LIST_UI", "getDONE_WINNER_LIST_UI", "DONE_WIN_UI", "getDONE_WIN_UI", "LOAD_MORE_THRESHOLD", "getLOAD_MORE_THRESHOLD", "RUNNING_UI", "getRUNNING_UI", "TAG", "", "getTAG", "()Ljava/lang/String;", "UNDEFINE_UI", "getUNDEFINE_UI", "attendBtn", "Landroid/widget/TextView;", "attendedBtn", "chaseWayTip", "computingAnimCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getComputingAnimCallback", "()Lkotlin/jvm/functions/Function1;", "curLotteryUIState", "getCurLotteryUIState", "setCurLotteryUIState", "(I)V", "desc", "detailAttend", "detailCountdown", "doneAnimCallback", "getDoneAnimCallback", "doneContainer", "Landroid/view/View;", "doneLotteryBack", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "doneNoWin", "doneTotalParticipated", "doneWinnerCount", "doneWinnerListContainer", "doneWinnerLotteryResultContainer", "doneWinnerRv", "Landroidx/recyclerview/widget/RecyclerView;", "footer", "footerTv", "loadingMore", "", "lotteryArrow", "lotteryDetail", "lotteryDetailContainer", "runningContainer", "winnderAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveLotteryWinnerListAdapter;", "winnerAvatar", "Landroid/widget/ImageView;", "winnerNickname", "winnerTips", "changeToUnvisible", "checkLoadMoreWinner", "lastVisiblePosition", "chooseContainer", "ui", "initDoneDetailView", "initRunningView", "initView", "initWinnerListView", "isDoneUIShowing", "onAttendBtnClick", "onLoadMoreFinish", "success", "openCardImpl", "statusChange", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "parseWinnerList", "record", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "setFooterTvVisibility", "visibility", "setVisible", "visible", "updateCountDown", "localRemainTime", "beginTime", "endTime", "serverRemainTime", "participateCount", "updateWinnerList", "visitorDoneAction", "visitorLotteryCancelled", "visitorLotteryComputing", "visitorLotteryDone", "fromUpdate", "visitorLotteryDoneWinnerList", "showBackIcon", "visitorLotteryRunning", "visitorOpenCard", "plugin-finder_release"})
public final class dg
  extends bm
{
  final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  private TextView msF;
  private View tzi;
  final int ymO;
  private final int ymQ;
  private View ymR;
  private TextView ymS;
  private TextView ymT;
  private View ymU;
  private View ymV;
  private TextView ymY;
  private TextView ymZ;
  private RecyclerView yna;
  private TextView ynb;
  private com.tencent.mm.plugin.finder.live.view.adapter.p ynd;
  private boolean yne;
  final kotlin.g.a.b<bal, x> ynf;
  final kotlin.g.a.b<bal, x> yng;
  private View yzA;
  private TextView yzB;
  private View yzC;
  private final int yzm;
  private final int yzn;
  private final int yzo;
  private final int yzp;
  private volatile int yzq;
  private TextView yzr;
  private TextView yzs;
  private WeImageView yzt;
  private View yzu;
  private TextView yzv;
  private TextView yzw;
  private ImageView yzx;
  private TextView yzy;
  private TextView yzz;
  
  public dg(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(273751);
    this.kCL = paramb;
    this.TAG = "FinderLiveLotteryVisitorCardPlugin";
    this.yzm = -1;
    this.yzn = 1;
    this.yzo = 2;
    this.yzp = 3;
    this.yzq = this.yzm;
    this.ymQ = 10;
    this.ynf = ((kotlin.g.a.b)new b(this));
    this.yng = ((kotlin.g.a.b)new c(this));
    AppMethodBeat.o(273751);
  }
  
  private final void Nw(int paramInt)
  {
    AppMethodBeat.i(273733);
    Log.i(this.TAG, "chooseContainer ui mode:".concat(String.valueOf(paramInt)));
    this.yzq = paramInt;
    Object localObject;
    if (paramInt == this.ymO)
    {
      localObject = this.ymR;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ymU;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = dBU();
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(b.e.icon_live_lottery_card_bg);
        AppMethodBeat.o(273733);
        return;
      }
      AppMethodBeat.o(273733);
      return;
    }
    if (paramInt == this.yzn)
    {
      localObject = this.ymR;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.ymU;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ymV;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.yzu;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = dBU();
      if (localObject != null)
      {
        ((View)localObject).setBackgroundResource(b.e.icon_live_lottery_card_bg);
        AppMethodBeat.o(273733);
        return;
      }
      AppMethodBeat.o(273733);
      return;
    }
    if (paramInt == this.yzo)
    {
      localObject = this.ymR;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.ymU;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ymV;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.yzu;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.yzv;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.yzw;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.yzx;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.yzy;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = dBU();
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(b.e.icon_live_lottery_card_bg);
      }
      m.yCt.a(s.bm.yMS, String.valueOf(s.bq.yNn.result));
      AppMethodBeat.o(273733);
      return;
    }
    if (paramInt == this.yzp)
    {
      localObject = this.ymR;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.ymU;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.ymV;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.yzu;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.yzv;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
      localObject = this.yzw;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = this.yzx;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.yzy;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
      localObject = dBU();
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(b.e.icon_live_lottery_card_winner_bg);
      }
      m.yCt.a(s.bm.yMS, String.valueOf(s.bq.yNm.result));
    }
    AppMethodBeat.o(273733);
  }
  
  private final void Nx(final int paramInt)
  {
    AppMethodBeat.i(273739);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new l(this, paramInt));
    AppMethodBeat.o(273739);
  }
  
  private final void a(azs paramazs)
  {
    Object localObject3 = null;
    AppMethodBeat.i(273735);
    Object localObject4;
    Object localObject2;
    if (paramazs != null)
    {
      localObject1 = paramazs.xHW;
      localObject4 = this.ymY;
      if (localObject4 != null)
      {
        localObject2 = af.aaBG;
        localObject2 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject2, "root.context");
        String str = ((Context)localObject2).getResources().getString(b.j.finder_live_lottery_winner_count);
        kotlin.g.b.p.j(str, "root.context.resources.g…ive_lottery_winner_count)");
        if (localObject1 == null) {
          break label274;
        }
        localObject2 = Integer.valueOf(((bal)localObject1).SMr);
        label80:
        localObject2 = String.format(str, Arrays.copyOf(new Object[] { localObject2 }, 1));
        kotlin.g.b.p.j(localObject2, "java.lang.String.format(format, *args)");
        ((TextView)localObject4).setText((CharSequence)localObject2);
      }
      localObject2 = this.ymZ;
      if (localObject2 != null)
      {
        localObject4 = af.aaBG;
        localObject4 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject4, "root.context");
        localObject4 = ((Context)localObject4).getResources().getString(b.j.finder_live_lottery_participate_count);
        kotlin.g.b.p.j(localObject4, "root.context.resources.g…ottery_participate_count)");
        if (localObject1 == null) {
          break label279;
        }
      }
    }
    label274:
    label279:
    for (Object localObject1 = Integer.valueOf(((bal)localObject1).SCT);; localObject1 = null)
    {
      localObject1 = String.format((String)localObject4, Arrays.copyOf(new Object[] { localObject1 }, 1));
      kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
      ((TextView)localObject2).setText((CharSequence)localObject1);
      localObject2 = this.ynd;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (paramazs != null)
        {
          paramazs = paramazs.SLp;
          localObject1 = localObject3;
          if (paramazs != null) {
            localObject1 = paramazs.SMv;
          }
        }
        ((com.tencent.mm.plugin.finder.live.view.adapter.p)localObject2).at((LinkedList)localObject1);
      }
      paramazs = this.ynd;
      if (paramazs == null) {
        break label284;
      }
      paramazs.notifyDataSetChanged();
      AppMethodBeat.o(273735);
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label80;
    }
    label284:
    AppMethodBeat.o(273735);
  }
  
  private final void a(bal parambal, boolean paramBoolean)
  {
    AppMethodBeat.i(273743);
    if ((this.kiF.getVisibility() == 0) && ((this.yzq == this.yzp) || (this.yzq == this.yzo) || (this.yzq == this.yzn))) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i(this.TAG, "visitorLotteryDone fromUpdate:" + paramBoolean + ",isDoneUIShowing:" + bool);
      if ((!paramBoolean) || (!bool)) {
        break;
      }
      AppMethodBeat.o(273743);
      return;
    }
    bool = com.tencent.mm.ae.d.dr(parambal.extFlag, 2);
    paramBoolean = com.tencent.mm.ae.d.dr(parambal.extFlag, 1);
    int j = parambal.SCT;
    int k = parambal.SMr;
    z.bdb();
    Object localObject1;
    Object localObject2;
    if (bool)
    {
      Nw(this.yzp);
      localObject1 = new m(this);
      parambal = parambal.SMs;
      if (parambal != null)
      {
        localObject2 = new axc();
        ((axc)localObject2).ueX = parambal.ueX;
        ((axc)localObject2).nickname = parambal.nickname;
        ((m)localObject1).a((axc)localObject2);
        ((g)business(g.class)).zif = true;
        parambal = this.yzz;
        if (parambal == null) {
          break label554;
        }
        parambal.setVisibility(0);
        paramBoolean = true;
        label240:
        if ((k <= 0) || (j < k)) {
          break label785;
        }
        parambal = this.yzC;
        if (parambal != null) {
          parambal.setVisibility(0);
        }
        label266:
        if (!paramBoolean) {
          break label803;
        }
        parambal = this.yzB;
        if (parambal != null)
        {
          localObject1 = af.aaBG;
          localObject1 = this.kiF.getContext();
          kotlin.g.b.p.j(localObject1, "root.context");
          localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_lottery_result);
          kotlin.g.b.p.j(localObject1, "root.context.resources.g…nder_live_lottery_result)");
          localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(k), Integer.valueOf(j) }, 2));
          kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
          parambal.setText((CharSequence)localObject1);
        }
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "visitorLotteryDone isWin:" + bool + ",participateCnt:" + j + ",realWinnerCnt:" + k + ",haveLotteryResult:" + paramBoolean);
      AppMethodBeat.o(273743);
      return;
      localObject2 = (dg)this;
      Log.i(((dg)localObject2).TAG, "lotteryInfo.participant_info is null ,so use loacal current role info");
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((dg)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfU).iterator();
      label475:
      int i;
      if (localIterator.hasNext())
      {
        parambal = localIterator.next();
        if (((axc)parambal).SJy == ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((dg)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy)
        {
          i = 1;
          label522:
          if (i == 0) {
            break label547;
          }
        }
      }
      for (;;)
      {
        parambal = (axc)parambal;
        if (parambal == null) {
          break;
        }
        ((m)localObject1).a(parambal);
        break;
        i = 0;
        break label522;
        label547:
        break label475;
        parambal = null;
      }
      label554:
      paramBoolean = true;
      break label240;
      if (paramBoolean)
      {
        Nw(this.yzo);
        parambal = this.yzv;
        if (parambal != null)
        {
          localObject1 = this.kiF.getContext();
          kotlin.g.b.p.j(localObject1, "root.context");
          parambal.setText((CharSequence)((Context)localObject1).getResources().getString(b.j.finder_live_lottery_no_win_tip));
        }
        parambal = this.yzz;
        if (parambal != null)
        {
          parambal.setVisibility(8);
          paramBoolean = true;
          break label240;
        }
        paramBoolean = true;
        break label240;
      }
      if ((k > 0) && (j >= k))
      {
        pq(false);
        parambal = this.yzz;
        if (parambal != null) {
          parambal.setVisibility(8);
        }
        m.yCt.a(s.bm.yMS, String.valueOf(s.bq.yNo.result));
        paramBoolean = true;
        break label240;
      }
      Nw(this.yzo);
      parambal = this.yzv;
      if (parambal != null)
      {
        localObject1 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject1, "root.context");
        parambal.setText((CharSequence)((Context)localObject1).getResources().getString(b.j.finder_live_lottery_nobody_win));
      }
      parambal = this.yzz;
      if (parambal != null) {
        parambal.setVisibility(8);
      }
      m.yCt.a(s.bm.yMS, String.valueOf(s.bq.yNo.result));
      paramBoolean = false;
      break label240;
      label785:
      parambal = this.yzC;
      if (parambal == null) {
        break label266;
      }
      parambal.setVisibility(8);
      break label266;
      label803:
      parambal = this.yzB;
      if (parambal != null)
      {
        localObject1 = af.aaBG;
        localObject1 = this.kiF.getContext();
        kotlin.g.b.p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources().getString(b.j.finder_live_lottery_statement);
        kotlin.g.b.p.j(localObject1, "root.context.resources.g…r_live_lottery_statement)");
        localObject1 = String.format((String)localObject1, Arrays.copyOf(new Object[] { Integer.valueOf(k), Integer.valueOf(j) }, 2));
        kotlin.g.b.p.j(localObject1, "java.lang.String.format(format, *args)");
        parambal.setText((CharSequence)localObject1);
      }
    }
  }
  
  private final void b(final azs paramazs)
  {
    com.tencent.mm.cd.b localb = null;
    AppMethodBeat.i(273738);
    Object localObject;
    if (paramazs != null)
    {
      localObject = paramazs.SLp;
      if (localObject != null)
      {
        localObject = ((ban)localObject).SMv;
        if (localObject == null) {}
      }
    }
    for (int i = ((LinkedList)localObject).size();; i = 0)
    {
      Log.i(this.TAG, "parseWinnerList winnerListSize:".concat(String.valueOf(i)));
      if (i <= 0) {
        break;
      }
      a(paramazs);
      AppMethodBeat.o(273738);
      return;
    }
    paramazs = ((g)business(g.class)).zic;
    if (paramazs != null)
    {
      paramazs = paramazs.xHW;
      if (paramazs == null) {}
    }
    for (paramazs = paramazs.id;; paramazs = null)
    {
      Log.i(this.TAG, "parseWinnerList record is empty!lotteryId:".concat(String.valueOf(paramazs)));
      if (paramazs == null) {
        break;
      }
      localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject == null) {
        break;
      }
      azs localazs = ((g)business(g.class)).zie;
      if (localazs != null) {
        localb = localazs.lastBuffer;
      }
      ((an)localObject).a(paramazs, localb, (x.a)new k(this, paramazs));
      AppMethodBeat.o(273738);
      return;
    }
    AppMethodBeat.o(273738);
  }
  
  private final void pq(boolean paramBoolean)
  {
    AppMethodBeat.i(273745);
    Object localObject = ((g)business(g.class)).zic;
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
      if (localObject != null)
      {
        i = ((bal)localObject).SMr;
        localObject = ((g)business(g.class)).zic;
        if (localObject == null) {
          break label237;
        }
        localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.l)localObject).xHW;
        if (localObject == null) {
          break label237;
        }
        j = ((bal)localObject).SCT;
        label82:
        Log.i(this.TAG, "visitorLotteryDoneWinnerList realWinnerCnt:" + i + ",participateCount:" + j);
        Nw(this.yzn);
        localObject = this.ymY;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.ymZ;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
        localObject = this.yna;
        if (localObject != null) {
          ((RecyclerView)localObject).setVisibility(0);
        }
        b(((g)business(g.class)).zie);
        if (!paramBoolean) {
          break label242;
        }
        localObject = this.yzt;
        if (localObject != null) {
          ((WeImageView)localObject).setVisibility(0);
        }
      }
    }
    for (;;)
    {
      m.yCt.a(s.bm.yMT, "");
      AppMethodBeat.o(273745);
      return;
      i = 0;
      break;
      label237:
      j = 0;
      break label82;
      label242:
      localObject = this.yzt;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
    }
  }
  
  public final void a(final boolean paramBoolean, final com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml)
  {
    AppMethodBeat.i(273740);
    kotlin.g.b.p.k(paraml, "lotteryInfoWrapper");
    super.a(paramBoolean, paraml);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(this, paraml, paramBoolean));
    AppMethodBeat.o(273740);
  }
  
  public final void dBX()
  {
    AppMethodBeat.i(273749);
    super.dBX();
    this.yzq = this.yzm;
    AppMethodBeat.o(273749);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(273732);
    super.initView();
    this.ymR = this.kiF.findViewById(b.f.running_container);
    Object localObject1 = this.ymR;
    if (localObject1 != null)
    {
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.desc);
      this.msF = ((TextView)localObject1);
      localObject1 = this.msF;
      if (localObject1 == null) {
        break label870;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label65:
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = this.ymR;
      if (localObject1 == null) {
        break label875;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.detail_countdown);
      label95:
      this.ymS = ((TextView)localObject1);
      localObject1 = this.ymR;
      if (localObject1 == null) {
        break label880;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.detail_attend);
      label120:
      this.ymT = ((TextView)localObject1);
      localObject1 = this.ymR;
      if (localObject1 == null) {
        break label885;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.have_attended);
      label145:
      this.yzs = ((TextView)localObject1);
      localObject1 = this.ymR;
      if (localObject1 == null) {
        break label890;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.attend);
      label170:
      this.yzr = ((TextView)localObject1);
      localObject1 = this.yzr;
      if (localObject1 != null) {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new f(this));
      }
      this.ymU = this.kiF.findViewById(b.f.done_container);
      localObject1 = this.ymU;
      if (localObject1 == null) {
        break label895;
      }
      localObject1 = ((View)localObject1).findViewById(b.f.winner_list_container);
      label230:
      this.ymV = ((View)localObject1);
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label900;
      }
      localObject1 = (WeImageView)((View)localObject1).findViewById(b.f.lottery_back);
      label255:
      this.yzt = ((WeImageView)localObject1);
      localObject1 = this.yzt;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setVisibility(0);
      }
      localObject1 = this.yzt;
      if (localObject1 != null) {
        ((WeImageView)localObject1).post((Runnable)new h(this));
      }
      localObject1 = this.yzt;
      if (localObject1 != null) {
        ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new i(this));
      }
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label905;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.winner_count);
      label343:
      this.ymY = ((TextView)localObject1);
      localObject1 = this.ymY;
      if (localObject1 == null) {
        break label910;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label362:
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label915;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.total_participate);
      label392:
      this.ymZ = ((TextView)localObject1);
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label920;
      }
      localObject1 = (RecyclerView)((View)localObject1).findViewById(b.f.winner_rv);
      label417:
      this.yna = ((RecyclerView)localObject1);
      this.ynd = new com.tencent.mm.plugin.finder.live.view.adapter.p(getBuContext());
      localObject1 = this.yna;
      if (localObject1 != null)
      {
        this.kiF.getContext();
        ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.ynd);
        ((RecyclerView)localObject1).a((RecyclerView.l)new g(this));
      }
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label925;
      }
      localObject1 = ((View)localObject1).findViewById(b.f.winner_list_footer);
      label513:
      this.tzi = ((View)localObject1);
      localObject1 = this.ymV;
      if (localObject1 == null) {
        break label930;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.load_more_footer_tip_tv);
      label538:
      this.ynb = ((TextView)localObject1);
      localObject1 = this.ymU;
      if (localObject1 == null) {
        break label935;
      }
      localObject1 = ((View)localObject1).findViewById(b.f.lottery_result_container);
      label560:
      this.yzu = ((View)localObject1);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label940;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.no_win_lottery);
      label585:
      this.yzv = ((TextView)localObject1);
      localObject1 = this.yzv;
      if (localObject1 == null) {
        break label945;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label604:
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label950;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.winner_tip);
      label634:
      this.yzw = ((TextView)localObject1);
      localObject1 = this.yzw;
      if (localObject1 == null) {
        break label955;
      }
      localObject1 = ((TextView)localObject1).getPaint();
      label653:
      ar.a((Paint)localObject1, 0.8F);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label960;
      }
      localObject1 = (ImageView)((View)localObject1).findViewById(b.f.winner_avatar);
      label683:
      this.yzx = ((ImageView)localObject1);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label965;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.winner_nickname);
      label708:
      this.yzy = ((TextView)localObject1);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label970;
      }
      localObject1 = (TextView)((View)localObject1).findViewById(b.f.chase_way_tip);
      label733:
      this.yzz = ((TextView)localObject1);
      localObject1 = this.yzu;
      if (localObject1 == null) {
        break label975;
      }
      localObject1 = ((View)localObject1).findViewById(b.f.lottery_detail_container);
      label755:
      this.yzA = ((View)localObject1);
      localObject1 = this.yzA;
      if (localObject1 != null) {
        ((View)localObject1).post((Runnable)new d(this));
      }
      localObject1 = this.yzA;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      }
      localObject1 = this.yzu;
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
    for (localObject1 = (TextView)((View)localObject1).findViewById(b.f.lottery_detail);; localObject1 = null)
    {
      this.yzB = ((TextView)localObject1);
      View localView = this.yzu;
      localObject1 = localObject2;
      if (localView != null) {
        localObject1 = localView.findViewById(b.f.lottery_arrow);
      }
      this.yzC = ((View)localObject1);
      AppMethodBeat.o(273732);
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
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(273748);
    com.tencent.mm.kernel.c.a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    kotlin.g.b.p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    if (((com.tencent.mm.plugin.teenmode.a.b)locala).ZM())
    {
      this.kiF.setVisibility(8);
      Log.w(this.TAG, "setVisible return for isTeenMode");
      AppMethodBeat.o(273748);
      return;
    }
    super.tU(paramInt);
    AppMethodBeat.o(273748);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$checkLoadMoreWinner$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class a
    implements x.a
  {
    a(dg paramdg, int paramInt) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(282370);
      kotlin.g.b.p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.yzD.business(g.class)).a(paramazs.xHW);
        ((g)this.yzD.business(g.class)).d(paramazs);
        dg.e(this.yzD);
      }
      dg.h(this.yzD);
      dg.i(this.yzD);
      AppMethodBeat.o(282370);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<bal, x>
  {
    b(dg paramdg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<bal, x>
  {
    c(dg paramdg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(dg paramdg) {}
    
    public final void run()
    {
      AppMethodBeat.i(246201);
      Rect localRect = new Rect();
      Object localObject = dg.c(this.yzD);
      if (localObject != null) {
        ((View)localObject).getHitRect(localRect);
      }
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      int i = ((Context)localObject).getResources().getDimensionPixelOffset(b.d.Edge_A);
      localRect.inset(-i, -i);
      localObject = dg.c(this.yzD);
      if (localObject != null) {}
      for (localObject = ((View)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(246201);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, dg.c(this.yzD)));
      AppMethodBeat.o(246201);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(dg paramdg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221618);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      dg.d(this.yzD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initDoneDetailView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221618);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(dg paramdg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(247213);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      dg.a(this.yzD);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initRunningView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247213);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$3$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    g(dg paramdg) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(220617);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new kotlin.t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(220617);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kM();
      dg.a(this.yzD, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(220617);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(220621);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(220621);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(dg paramdg) {}
    
    public final void run()
    {
      AppMethodBeat.i(275179);
      Rect localRect = new Rect();
      Object localObject = dg.b(this.yzD);
      if (localObject != null) {
        ((WeImageView)localObject).getHitRect(localRect);
      }
      localObject = MMApplicationContext.getContext();
      kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
      int i = ((Context)localObject).getResources().getDimensionPixelOffset(b.d.Edge_2A);
      localRect.inset(-i, -i);
      localObject = dg.b(this.yzD);
      if (localObject != null) {}
      for (localObject = ((WeImageView)localObject).getParent(); localObject == null; localObject = null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(275179);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setTouchDelegate(new TouchDelegate(localRect, (View)dg.b(this.yzD)));
      AppMethodBeat.o(275179);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(dg paramdg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(221920);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = ((g)this.yzD.business(g.class)).zic;
      if (paramView != null)
      {
        paramView = paramView.xHW;
        if (paramView != null) {
          dg.a(this.yzD, paramView);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$initWinnerListView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(221920);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(dg paramdg)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorLotteryCardPlugin$parseWinnerList$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
  public static final class k
    implements x.a
  {
    k(dg paramdg, String paramString) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, azs paramazs)
    {
      AppMethodBeat.i(273971);
      kotlin.g.b.p.k(paramazs, "resp");
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ((g)this.yzD.business(g.class)).a(paramazs.xHW);
        ((g)this.yzD.business(g.class)).d(paramazs);
        dg.e(this.yzD);
        AppMethodBeat.o(273971);
        return;
      }
      paramString = ((g)this.yzD.business(g.class)).zic;
      if (paramString != null)
      {
        paramString = paramString.xHW;
        if (paramString != null)
        {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramString) {});
          AppMethodBeat.o(273971);
          return;
        }
      }
      AppMethodBeat.o(273971);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<x>
  {
    l(dg paramdg, int paramInt)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"updateAvatarAndName", "", "info", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.b<axc, x>
  {
    m(dg paramdg)
    {
      super();
    }
    
    public final void a(axc paramaxc)
    {
      AppMethodBeat.i(288378);
      kotlin.g.b.p.k(paramaxc, "info");
      Object localObject1 = dg.j(this.yzD);
      if (localObject1 != null)
      {
        Object localObject2;
        e locale;
        com.tencent.mm.plugin.finder.loader.t localt;
        if (paramaxc.SJy == 3)
        {
          localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.dJh();
          locale = new e(Util.nullAsNil(paramaxc.ueX));
          localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject2).a(locale, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
        }
        for (;;)
        {
          localObject1 = dg.k(this.yzD);
          if (localObject1 == null) {
            break;
          }
          ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.yzD.kiF.getContext(), (CharSequence)paramaxc.nickname));
          AppMethodBeat.o(288378);
          return;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.ztT;
          localObject2 = com.tencent.mm.plugin.finder.loader.t.dJi();
          locale = new e(Util.nullAsNil(paramaxc.ueX));
          localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          ((com.tencent.mm.loader.d)localObject2).a(locale, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztZ));
        }
        AppMethodBeat.o(288378);
        return;
      }
      AppMethodBeat.o(288378);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<x>
  {
    n(dg paramdg, com.tencent.mm.plugin.finder.live.viewmodel.data.l paraml, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.dg
 * JD-Core Version:    0.7.0.1
 */