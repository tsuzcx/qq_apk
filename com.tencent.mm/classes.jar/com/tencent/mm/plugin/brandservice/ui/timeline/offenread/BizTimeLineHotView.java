package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.as;
import com.tencent.mm.autogen.a.as.a;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.protocal.protobuf.fmz;
import com.tencent.mm.protocal.protobuf.fnc;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bizFinderLiveBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "getBizFinderLiveBar", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "setBizFinderLiveBar", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;)V", "hasGetOftenRead", "", "idleHandler", "Landroid/os/MessageQueue$IdleHandler;", "isFirstTimeRefresh", "isServerRank", "itemPadding", "getItemPadding", "()I", "mBizDeleteContactListener", "Lcom/tencent/mm/sdk/event/IListener;", "mContextWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getMContextWeakRef", "()Ljava/lang/ref/WeakReference;", "setMContextWeakRef", "(Ljava/lang/ref/WeakReference;)V", "mItemPadding", "mLastConfigOrientation", "mListView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "mOftenReadLayout", "mOftenReadList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "mTitle", "Landroid/widget/TextView;", "mVideoTitle", "paddingLeft", "", "readReport", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineOftenReadReport;", "getReadReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineOftenReadReport;", "videoPaddingLeft", "doGetOftenRead", "", "getLocalOftenReadData", "hasVideoChannel", "hideVideoTitle", "init", "initFinderLive", "rootView", "Landroid/view/View;", "initOftenReadList", "resp", "Lcom/tencent/mm/protocal/protobuf/TimelineGetOftenReadBizResp;", "isLiveBarVisible", "notifyDataChange", "onClick", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDelete", "onDestroy", "onLiveBarClick", "bizUserName", "", "onLiveStopStatusChange", "exportId", "scene", "onNotifyChange", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUpdateGreenDot", "refreshData", "refreshUnread", "reportShow", "saveRespData", "setOftenReadTitlePaddingLeft", "left", "setVideoTitlePaddingLeft", "sortListView", "list", "Ljava/util/ArrayList;", "sortLiveStatusOnly", "updateGreenDot", "talker", "updateInfo", "hotViewInfo", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BizTimeLineHotView
  extends LinearLayout
  implements com.tencent.mm.am.h, k, MStorageEx.IOnStorageChange
{
  private static IListener<at> vBt;
  public static final BizTimeLineHotView.a vPt;
  private final MessageQueue.IdleHandler fgm;
  private TextView pIp;
  private float paddingLeft;
  public final h vOC;
  public CopyOnWriteArrayList<e> vPA;
  private int vPB;
  private boolean vPC;
  public a vPD;
  public final IListener<?> vPE;
  private float vPF;
  private boolean vPG;
  private WeakReference<Activity> vPu;
  public BizTimeLineHotListView vPv;
  private LinearLayout vPw;
  private TextView vPx;
  private int vPy;
  private boolean vPz;
  
  static
  {
    AppMethodBeat.i(302662);
    vPt = new BizTimeLineHotView.a((byte)0);
    AppMethodBeat.o(302662);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.vPA = new CopyOnWriteArrayList();
    this.vOC = new h();
    this.vPE = ((IListener)new IListener(f.hfK)
    {
      private static final void a(BizTimeLineHotView paramAnonymousBizTimeLineHotView, as paramAnonymousas)
      {
        AppMethodBeat.i(302385);
        kotlin.g.b.s.u(paramAnonymousBizTimeLineHotView, "this$0");
        kotlin.g.b.s.u(paramAnonymousas, "$event");
        Iterator localIterator = paramAnonymousBizTimeLineHotView.vPA.iterator();
        e locale;
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locale = (e)localIterator.next();
          str = paramAnonymousas.hAu.userName;
          kotlin.g.b.s.checkNotNull(locale);
        } while (!kotlin.g.b.s.p(str, locale.YIf));
        for (paramAnonymousas = locale;; paramAnonymousas = null)
        {
          if (paramAnonymousas != null) {
            paramAnonymousBizTimeLineHotView.vPA.remove(paramAnonymousas);
          }
          BizTimeLineHotView.k(paramAnonymousBizTimeLineHotView);
          AppMethodBeat.o(302385);
          return;
        }
      }
    });
    this.paddingLeft = -1.0F;
    this.vPF = -1.0F;
    this.vPG = true;
    this.fgm = ((MessageQueue.IdleHandler)new b(this));
    init(paramContext);
    AppMethodBeat.o(6105);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6106);
    this.vPA = new CopyOnWriteArrayList();
    this.vOC = new h();
    this.vPE = ((IListener)new IListener(f.hfK)
    {
      private static final void a(BizTimeLineHotView paramAnonymousBizTimeLineHotView, as paramAnonymousas)
      {
        AppMethodBeat.i(302385);
        kotlin.g.b.s.u(paramAnonymousBizTimeLineHotView, "this$0");
        kotlin.g.b.s.u(paramAnonymousas, "$event");
        Iterator localIterator = paramAnonymousBizTimeLineHotView.vPA.iterator();
        e locale;
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locale = (e)localIterator.next();
          str = paramAnonymousas.hAu.userName;
          kotlin.g.b.s.checkNotNull(locale);
        } while (!kotlin.g.b.s.p(str, locale.YIf));
        for (paramAnonymousas = locale;; paramAnonymousas = null)
        {
          if (paramAnonymousas != null) {
            paramAnonymousBizTimeLineHotView.vPA.remove(paramAnonymousas);
          }
          BizTimeLineHotView.k(paramAnonymousBizTimeLineHotView);
          AppMethodBeat.o(302385);
          return;
        }
      }
    });
    this.paddingLeft = -1.0F;
    this.vPF = -1.0F;
    this.vPG = true;
    this.fgm = ((MessageQueue.IdleHandler)new b(this));
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  private static void S(ArrayList<e> paramArrayList)
  {
    AppMethodBeat.i(302490);
    kotlin.g.b.s.u(paramArrayList, "list");
    if (Util.isNullOrNil((List)paramArrayList))
    {
      AppMethodBeat.o(302490);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      f((e)paramArrayList.next());
    }
    AppMethodBeat.o(302490);
  }
  
  private static final int a(boolean paramBoolean1, boolean paramBoolean2, e parame1, e parame2)
  {
    int k = 0;
    AppMethodBeat.i(302549);
    com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
    if (kotlin.g.b.s.p(com.tencent.mm.pluginsdk.model.c.iHj(), parame1.YIf))
    {
      AppMethodBeat.o(302549);
      return -1;
    }
    localc = com.tencent.mm.pluginsdk.model.c.XPt;
    if (!kotlin.g.b.s.p(com.tencent.mm.pluginsdk.model.c.iHj(), parame2.YIf))
    {
      localc = com.tencent.mm.pluginsdk.model.c.XPt;
      int j;
      if (com.tencent.mm.pluginsdk.model.c.iGW())
      {
        localc = com.tencent.mm.pluginsdk.model.c.XPt;
        if (com.tencent.mm.pluginsdk.model.c.pa(parame1.YIf, parame1.YSM))
        {
          i = 1;
          localc = com.tencent.mm.pluginsdk.model.c.XPt;
          if (!com.tencent.mm.pluginsdk.model.c.iGW()) {
            break label145;
          }
          localc = com.tencent.mm.pluginsdk.model.c.XPt;
          if (!com.tencent.mm.pluginsdk.model.c.pa(parame2.YIf, parame2.YSM)) {
            break label145;
          }
          j = 1;
        }
      }
      for (;;)
      {
        if (i != j)
        {
          if (i != 0)
          {
            AppMethodBeat.o(302549);
            return -1;
            i = 0;
            break;
            label145:
            j = 0;
            continue;
          }
          AppMethodBeat.o(302549);
          return 1;
        }
      }
      if (paramBoolean1)
      {
        if (parame1.vPP < parame2.vPP)
        {
          AppMethodBeat.o(302549);
          return -1;
        }
        AppMethodBeat.o(302549);
        return 1;
      }
      if ((parame1.vPQ) || (parame1.vPT)) {}
      for (int i = 1;; i = 0)
      {
        if (!parame2.vPQ)
        {
          j = k;
          if (!parame2.vPT) {}
        }
        else
        {
          j = 1;
        }
        if (i == j) {
          break label271;
        }
        if ((!parame1.vPQ) && (!parame1.vPT)) {
          break;
        }
        AppMethodBeat.o(302549);
        return -1;
      }
      AppMethodBeat.o(302549);
      return 1;
      label271:
      if ((paramBoolean2) && (parame1.weight != parame2.weight))
      {
        if (parame1.weight >= parame2.weight)
        {
          AppMethodBeat.o(302549);
          return -1;
        }
        AppMethodBeat.o(302549);
        return 1;
      }
      if (parame1.uWw >= parame2.uWw)
      {
        AppMethodBeat.o(302549);
        return -1;
      }
    }
    AppMethodBeat.o(302549);
    return 1;
  }
  
  private static final void a(BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(302543);
    kotlin.g.b.s.u(paramBizTimeLineHotView, "this$0");
    fmz localfmz = g.deD();
    localfmz.abNc.clear();
    localfmz.abNc.addAll((Collection)paramBizTimeLineHotView.vPA);
    g.b(localfmz);
    AppMethodBeat.o(302543);
  }
  
  private static final void a(BizTimeLineHotView paramBizTimeLineHotView, e parame)
  {
    AppMethodBeat.i(302559);
    kotlin.g.b.s.u(paramBizTimeLineHotView, "this$0");
    paramBizTimeLineHotView = paramBizTimeLineHotView.vPv;
    if (paramBizTimeLineHotView != null) {
      paramBizTimeLineHotView.a(parame);
    }
    AppMethodBeat.o(302559);
  }
  
  private static final void a(BizTimeLineHotView paramBizTimeLineHotView, String paramString)
  {
    AppMethodBeat.i(302534);
    kotlin.g.b.s.u(paramBizTimeLineHotView, "this$0");
    if (paramBizTimeLineHotView.vPA.isEmpty())
    {
      AppMethodBeat.o(302534);
      return;
    }
    if ((paramString == null) || (au.bwp(paramString)))
    {
      AppMethodBeat.o(302534);
      return;
    }
    try
    {
      Iterator localIterator = paramBizTimeLineHotView.vPA.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        kotlin.g.b.s.checkNotNull(locale);
        if (kotlin.g.b.s.p(paramString, locale.YIf))
        {
          if (f(locale)) {
            MMHandlerThread.postToMainThread(new BizTimeLineHotView..ExternalSyntheticLambda1(paramBizTimeLineHotView, locale));
          }
          AppMethodBeat.o(302534);
          return;
        }
      }
    }
    catch (Exception paramBizTimeLineHotView)
    {
      Log.e("MicroMsg.BizTimeLineHotList", "updateGreenDot ex:%s", new Object[] { paramBizTimeLineHotView.getMessage() });
      AppMethodBeat.o(302534);
    }
  }
  
  private final void a(fmz paramfmz)
  {
    AppMethodBeat.i(6116);
    Object localObject1;
    int i;
    if (paramfmz != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.b.ks(paramfmz.abNf * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.b.kt(paramfmz.abNd);
      localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
      com.tencent.mm.pluginsdk.model.c.Jp(paramfmz.abNg);
      if (paramfmz.abNc != null) {}
      for (i = paramfmz.abNc.size();; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramfmz.abNe), Integer.valueOf(paramfmz.abNd) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.b.HX(4)) {
          break;
        }
        paramfmz = this.vPw;
        if (paramfmz != null) {
          paramfmz.setVisibility(8);
        }
        AppMethodBeat.o(6116);
        return;
      }
    }
    paramfmz = this.vPw;
    if (paramfmz != null) {
      paramfmz.setVisibility(8);
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.c.daB())
    {
      paramfmz.abNc.clear();
      this.vPA.clear();
    }
    if ((Util.isNullOrNil((List)paramfmz.abNc)) && (Util.isNullOrNil((List)this.vPA)) && (!deA()))
    {
      paramfmz = this.vPw;
      if (paramfmz != null) {
        paramfmz.setVisibility(8);
      }
      Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList;
    if (!Util.isNullOrNil((List)paramfmz.abNc))
    {
      localArrayList = new ArrayList();
      i = 0;
      localObject1 = com.tencent.mm.pluginsdk.model.c.XPt;
      localObject1 = paramfmz.abNc;
      kotlin.g.b.s.s(localObject1, "resp.biz_info_list");
      com.tencent.mm.pluginsdk.model.c.cn((LinkedList)localObject1);
      Iterator localIterator = paramfmz.abNc.iterator();
      localObject1 = "";
      while (localIterator.hasNext())
      {
        Object localObject2 = (fnc)localIterator.next();
        int j = i + 1;
        if (j > c.vPL) {
          break;
        }
        Object localObject3 = new e();
        i = j;
        if (com.tencent.mm.model.ab.IR(((fnc)localObject2).YIf))
        {
          ((e)localObject3).YIf = ((fnc)localObject2).YIf;
          ((e)localObject3).YSM = ((fnc)localObject2).YSM;
          ((e)localObject3).wrl = ((fnc)localObject2).wrl;
          ((e)localObject3).YSN = ((fnc)localObject2).YSN;
          ((e)localObject3).title = ((fnc)localObject2).title;
          ((e)localObject3).vPU = (((fnc)localObject2).abNj * 1000L);
          localObject1 = (String)localObject1 + "; username = " + ((fnc)localObject2).YIf + ", finderTime = " + ((e)localObject3).vPU;
          localArrayList.add(localObject3);
          localObject3 = com.tencent.mm.pluginsdk.model.c.XPt;
          if (com.tencent.mm.pluginsdk.model.c.pb(((fnc)localObject2).YIf, ((fnc)localObject2).YSM))
          {
            localObject3 = com.tencent.mm.pluginsdk.model.c.XPt;
            com.tencent.mm.pluginsdk.model.c.aJ(((fnc)localObject2).YIf, ((fnc)localObject2).YSM, 1);
          }
          localObject3 = com.tencent.mm.pluginsdk.model.c.XPt;
          localObject3 = new pi();
          ((pi)localObject3).YIf = ((fnc)localObject2).YIf;
          ((pi)localObject3).YSM = ((fnc)localObject2).YSM;
          ((pi)localObject3).wrl = ((fnc)localObject2).wrl;
          ((pi)localObject3).title = ((fnc)localObject2).title;
          ((pi)localObject3).YSN = ((fnc)localObject2).YSN;
          ((pi)localObject3).YSO = ((fnc)localObject2).YSO;
          ((pi)localObject3).YSP = ((fnc)localObject2).YSP;
          localObject2 = ah.aiuX;
          com.tencent.mm.pluginsdk.model.c.a((pi)localObject3);
          i = j;
        }
      }
      Log.i("MicroMsg.BizTimeLineHotList", kotlin.g.b.s.X("finderTimeList: ", localObject1));
      S(localArrayList);
      if (paramfmz.abNe != 1) {
        break label685;
      }
    }
    label685:
    for (boolean bool = true;; bool = false)
    {
      a(localArrayList, bool, false);
      refreshData();
      Log.d("MicroMsg.BizTimeLineHotList", kotlin.g.b.s.X("initOftenReadList cost ", Long.valueOf(System.currentTimeMillis() - l)));
      AppMethodBeat.o(6116);
      return;
    }
  }
  
  private static final void a(com.tencent.mm.storage.ab paramab, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(302519);
    kotlin.g.b.s.u(paramBizTimeLineHotView, "this$0");
    com.tencent.mm.storage.ab localab = com.tencent.mm.an.af.bHl().yK(paramab.field_talkerId);
    if ((localab != null) && (localab.field_msgId == paramab.field_msgId))
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxO(paramab.field_talker);
      paramBizTimeLineHotView.aje(paramab.field_talker);
    }
    AppMethodBeat.o(302519);
  }
  
  private final void a(ArrayList<e> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(302502);
    if (Util.isNullOrNil((List)paramArrayList))
    {
      AppMethodBeat.o(302502);
      return;
    }
    this.vPC = paramBoolean1;
    Log.d("MicroMsg.BizTimeLineHotList", "sortListView isServerRank=" + paramBoolean1 + ", sortLiveStatusOnly=" + paramBoolean2);
    kotlin.a.p.a((List)paramArrayList, new BizTimeLineHotView..ExternalSyntheticLambda4(paramBoolean2, paramBoolean1));
    this.vPA.clear();
    this.vPA.addAll((Collection)paramArrayList);
    AppMethodBeat.o(302502);
  }
  
  private void aje(String paramString)
  {
    AppMethodBeat.i(6108);
    com.tencent.mm.plugin.brandservice.b.au(new BizTimeLineHotView..ExternalSyntheticLambda2(this, paramString));
    AppMethodBeat.o(6108);
  }
  
  private static boolean deA()
  {
    AppMethodBeat.i(302467);
    if ((com.tencent.mm.plugin.brandservice.model.d.dbT()) && (com.tencent.mm.plugin.brandservice.model.d.dbU() != null))
    {
      AppMethodBeat.o(302467);
      return true;
    }
    AppMethodBeat.o(302467);
    return false;
  }
  
  private final void dey()
  {
    AppMethodBeat.i(302413);
    com.tencent.threadpool.h.ahAA.g(new BizTimeLineHotView..ExternalSyntheticLambda0(this), "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(302413);
  }
  
  private final void dez()
  {
    AppMethodBeat.i(302456);
    if (this.vPz)
    {
      AppMethodBeat.o(302456);
      return;
    }
    this.vPz = true;
    l locall = new l();
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)locall, 0);
    AppMethodBeat.o(302456);
  }
  
  private final void eJ(View paramView)
  {
    AppMethodBeat.i(302435);
    Object localObject = com.tencent.mm.pluginsdk.model.c.XPt;
    if (!com.tencent.mm.pluginsdk.model.c.iGX())
    {
      AppMethodBeat.o(302435);
      return;
    }
    localObject = (ViewStub)paramView.findViewById(d.e.biz_time_line_finder_live_container_view_stub);
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((ViewStub)localObject).inflate())
    {
      AppMethodBeat.o(302435);
      return;
    }
    localObject = getContext();
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI");
      AppMethodBeat.o(302435);
      throw paramView;
    }
    this.vPD = new a((BizTimeLineUI)localObject, this, paramView);
    paramView = this.vPD;
    if (paramView != null) {
      paramView.dek();
    }
    AppMethodBeat.o(302435);
  }
  
  private static boolean f(e parame)
  {
    AppMethodBeat.i(6118);
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
    kotlin.g.b.s.checkNotNull(parame);
    long l = ((bx)localObject).bxx(parame.YIf);
    localObject = com.tencent.mm.an.af.bHl().yK(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    parame.uWw = ((com.tencent.mm.storage.ab)localObject).field_createTime;
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(parame.YIf);
    boolean bool1 = parame.vPQ;
    parame.vPQ = false;
    if (localObject == null) {}
    for (int i = 0;; i = ((bd)localObject).field_unReadCount)
    {
      if ((i > 0) && (System.currentTimeMillis() - parame.uWw < com.tencent.mm.plugin.brandservice.ui.b.b.dhO()))
      {
        i = com.tencent.mm.an.af.bHo().yZ(l);
        if (((bd)localObject).field_unReadCount > i) {
          parame.vPQ = true;
        }
      }
      boolean bool2 = parame.vPT;
      localObject = b.vPq;
      b.e(parame);
      if ((bool1 == parame.vPQ) && (bool2 == parame.vPT)) {
        break;
      }
      AppMethodBeat.o(6118);
      return true;
    }
    AppMethodBeat.o(6118);
    return false;
  }
  
  private final void getLocalOftenReadData()
  {
    AppMethodBeat.i(6114);
    if (!Util.isNullOrNil((List)this.vPA))
    {
      AppMethodBeat.o(6114);
      return;
    }
    fmz localfmz = g.deD();
    Object localObject1;
    Object localObject2;
    if (localfmz != null)
    {
      localObject1 = localfmz.abNc;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject1 = ((Iterator)localObject2).next();
            fnc localfnc = (fnc)localObject1;
            com.tencent.mm.pluginsdk.model.c localc = com.tencent.mm.pluginsdk.model.c.XPt;
            if (com.tencent.mm.pluginsdk.model.c.bpk(localfnc.YIf))
            {
              localObject1 = (fnc)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (CharSequence)((fnc)localObject1).YSM;
                if ((localObject2 != null) && (!kotlin.n.n.bp((CharSequence)localObject2))) {
                  break label160;
                }
              }
            }
          }
        }
      }
    }
    label160:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.c.XPt;
        ((fnc)localObject1).YSM = com.tencent.mm.pluginsdk.model.c.iHk();
      }
      a(localfmz);
      AppMethodBeat.o(6114);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(6111);
    kotlin.g.b.s.u(paramContext, "context");
    com.tencent.mm.kernel.h.aZW().a(2768, (com.tencent.mm.am.h)this);
    this.vPu = new WeakReference((Activity)paramContext);
    c.init(paramContext);
    this.vPy = getItemPadding();
    View localView = com.tencent.mm.ui.af.mU(paramContext).inflate(d.f.biz_time_line_hot_view, (ViewGroup)this);
    this.vPv = ((BizTimeLineHotListView)localView.findViewById(d.e.biz_time_line_hot_list_view));
    this.vPw = ((LinearLayout)localView.findViewById(d.e.biz_time_line_often_read_layout));
    this.pIp = ((TextView)localView.findViewById(d.e.biz_time_line_hot_view_title));
    this.vPx = ((TextView)localView.findViewById(d.e.biz_time_line_hot_view_video_title));
    BizTimeLineHotListView localBizTimeLineHotListView = this.vPv;
    if (localBizTimeLineHotListView != null) {
      localBizTimeLineHotListView.a(paramContext, (List)this.vPA, this.vOC, (k)this, false);
    }
    getLocalOftenReadData();
    dez();
    kotlin.g.b.s.s(localView, "rootView");
    eJ(localView);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().add((MStorageEx.IOnStorageChange)this);
    this.vPE.alive();
    paramContext = com.tencent.mm.pluginsdk.model.c.XPt;
    if (com.tencent.mm.pluginsdk.model.c.iGW()) {
      BizTimeLineHotView.a.a((k)this);
    }
    AppMethodBeat.o(6111);
  }
  
  private final void refreshData()
  {
    AppMethodBeat.i(302508);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(302508);
  }
  
  public final void Q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(302819);
    if (paramString1 == null)
    {
      AppMethodBeat.o(302819);
      return;
    }
    Object localObject;
    if ((paramInt != 1) && (paramInt != 2))
    {
      Iterator localIterator = ((Iterable)this.vPA).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!kotlin.g.b.s.p(((e)localObject).YIf, paramString1));
    }
    for (;;)
    {
      localObject = (e)localObject;
      if (localObject != null)
      {
        ((e)localObject).YSM = paramString2;
        refreshData();
        dey();
        localObject = com.tencent.mm.pluginsdk.model.c.XPt;
        com.tencent.mm.pluginsdk.model.c.xY(10L);
        Log.i("MicroMsg.BizTimeLineHotList", "refreshData on live stop for often read");
      }
      localObject = this.vPD;
      if (localObject != null) {
        ((a)localObject).Q(paramString1, paramString2, paramInt);
      }
      AppMethodBeat.o(302819);
      return;
      localObject = null;
    }
  }
  
  public final void ajd(String paramString)
  {
    AppMethodBeat.i(302823);
    BizTimeLineHotListView localBizTimeLineHotListView = this.vPv;
    if (localBizTimeLineHotListView != null) {
      localBizTimeLineHotListView.fN(paramString, null);
    }
    AppMethodBeat.o(302823);
  }
  
  public final void del()
  {
    AppMethodBeat.i(6119);
    Object localObject = this.vPD;
    if (localObject != null) {
      ((a)localObject).del();
    }
    localObject = this.vPw;
    if ((localObject != null) && (((LinearLayout)localObject).getVisibility() == 0))
    {
      i = 1;
      if (i != 0)
      {
        if (!Util.isNullOrNil((List)this.vPA)) {
          break label94;
        }
        localObject = this.vPv;
        if ((localObject == null) || (((BizTimeLineHotListView)localObject).vOB != true)) {
          break label89;
        }
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label94;
      }
      AppMethodBeat.o(6119);
      return;
      i = 0;
      break;
    }
    label94:
    localObject = this.vPv;
    if (localObject != null) {
      ((BizTimeLineHotListView)localObject).del();
    }
    AppMethodBeat.o(6119);
  }
  
  public final boolean dem()
  {
    AppMethodBeat.i(302827);
    a locala = this.vPD;
    if ((locala != null) && (locala.dem() == true))
    {
      AppMethodBeat.o(302827);
      return true;
    }
    AppMethodBeat.o(302827);
    return false;
  }
  
  public final void den()
  {
    AppMethodBeat.i(302804);
    if (this.vPx != null)
    {
      TextView localTextView = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView);
      if (localTextView.getVisibility() == 0)
      {
        localTextView = this.vPx;
        kotlin.g.b.s.checkNotNull(localTextView);
        localTextView.setVisibility(8);
      }
    }
    AppMethodBeat.o(302804);
  }
  
  public final void deo()
  {
    AppMethodBeat.i(302814);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.vPA);
    a(localArrayList, this.vPC, true);
    refreshData();
    dey();
    AppMethodBeat.o(302814);
  }
  
  public final a getBizFinderLiveBar()
  {
    return this.vPD;
  }
  
  public final int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = c.fN(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public final WeakReference<Activity> getMContextWeakRef()
  {
    return this.vPu;
  }
  
  public final h getReadReport()
  {
    return this.vOC;
  }
  
  public final void o(com.tencent.mm.storage.ab paramab)
  {
    AppMethodBeat.i(6107);
    if (paramab != null) {
      com.tencent.threadpool.h.ahAA.g(new BizTimeLineHotView..ExternalSyntheticLambda3(paramab, this), "MicroMsg.BizTimeLineHotList");
    }
    AppMethodBeat.o(6107);
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    Object localObject2 = null;
    AppMethodBeat.i(6112);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Object localObject1 = this.vPu;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = (Activity)((WeakReference)localObject1).get())
    {
      AppMethodBeat.o(6112);
      return;
    }
    localObject1 = this.vPu;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(6112);
      return;
      Object localObject3 = (Activity)((WeakReference)localObject1).get();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((Activity)localObject3).getWindow();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Window)localObject3).getDecorView();
        }
      }
    }
    ((View)localObject1).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c((View)localObject1, this, paramConfiguration));
    AppMethodBeat.o(6112);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(6109);
    kotlin.g.b.s.u(paramMStorageEx, "stg");
    kotlin.g.b.s.u(paramObject, "obj");
    if (!(paramObject instanceof String))
    {
      Log.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    paramMStorageEx = this.vPu;
    if (paramMStorageEx != null)
    {
      paramMStorageEx = (Activity)paramMStorageEx.get();
      if ((paramMStorageEx == null) || (paramMStorageEx.isFinishing() != true)) {}
    }
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(6109);
      return;
    }
    aje((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(6120);
    kotlin.g.b.s.u(paramp, "scene");
    Log.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramp instanceof l))
    {
      paramString = (fmz)c.c.b(((l)paramp).rr.otC);
      paramp = this.vPu;
      if (paramp != null)
      {
        paramp = (Activity)paramp.get();
        if ((paramp == null) || (paramp.isFinishing() != true)) {}
      }
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        AppMethodBeat.o(6120);
        return;
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.d.b((com.tencent.mm.bx.a)paramString, (com.tencent.mm.bx.a)g.deD()))
      {
        Log.d("MicroMsg.BizTimeLineHotList", "onSceneEnd nothing change");
        AppMethodBeat.o(6120);
        return;
      }
      g.b(paramString);
      a(paramString);
    }
    AppMethodBeat.o(6120);
  }
  
  public final void setBizFinderLiveBar(a parama)
  {
    this.vPD = parama;
  }
  
  public final void setMContextWeakRef(WeakReference<Activity> paramWeakReference)
  {
    this.vPu = paramWeakReference;
  }
  
  public final void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(302783);
    if (this.pIp != null)
    {
      if (this.paddingLeft == paramFloat) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(302783);
        return;
      }
      this.paddingLeft = paramFloat;
      TextView localTextView1 = this.pIp;
      kotlin.g.b.s.checkNotNull(localTextView1);
      i = (int)paramFloat;
      TextView localTextView2 = this.pIp;
      kotlin.g.b.s.checkNotNull(localTextView2);
      int j = localTextView2.getPaddingTop();
      localTextView2 = this.pIp;
      kotlin.g.b.s.checkNotNull(localTextView2);
      int k = localTextView2.getPaddingRight();
      localTextView2 = this.pIp;
      kotlin.g.b.s.checkNotNull(localTextView2);
      localTextView1.setPadding(i, j, k, localTextView2.getPaddingBottom());
    }
    AppMethodBeat.o(302783);
  }
  
  public final void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(302792);
    if (this.vPx != null)
    {
      if (this.vPF == paramFloat) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(302792);
        return;
      }
      this.vPF = paramFloat;
      TextView localTextView1 = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView1);
      if (localTextView1.getVisibility() != 0)
      {
        localTextView1 = this.vPx;
        kotlin.g.b.s.checkNotNull(localTextView1);
        localTextView1.setVisibility(0);
      }
      localTextView1 = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView1);
      i = (int)paramFloat;
      TextView localTextView2 = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView2);
      int j = localTextView2.getPaddingTop();
      localTextView2 = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView2);
      int k = localTextView2.getPaddingRight();
      localTextView2 = this.vPx;
      kotlin.g.b.s.checkNotNull(localTextView2);
      localTextView1.setPadding(i, j, k, localTextView2.getPaddingBottom());
    }
    AppMethodBeat.o(302792);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$idleHandler$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MessageQueue.IdleHandler
  {
    b(BizTimeLineHotView paramBizTimeLineHotView) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(302274);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      Object localObject = this.vPI.getMContextWeakRef();
      if (localObject != null)
      {
        localObject = (Activity)((WeakReference)localObject).get();
        if ((localObject == null) || (((Activity)localObject).isFinishing() != true)) {}
      }
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(302274);
        return false;
      }
      localObject = BizTimeLineHotView.d(this.vPI);
      if (localObject != null) {
        ((BizTimeLineHotListView)localObject).f((List)this.vPI.vPA, true);
      }
      AppMethodBeat.o(302274);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    c(View paramView, BizTimeLineHotView paramBizTimeLineHotView, Configuration paramConfiguration) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(302280);
      this.vPJ.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if ((BizTimeLineHotView.b(jdField_this) != paramConfiguration.orientation) || (BizTimeLineHotView.c(jdField_this) != jdField_this.getItemPadding()))
      {
        c.init(jdField_this.getContext());
        Object localObject = BizTimeLineHotView.d(jdField_this);
        if (localObject != null) {
          ((BizTimeLineHotListView)localObject).der();
        }
        BizTimeLineHotView.a(jdField_this, jdField_this.getItemPadding());
        BizTimeLineHotView.b(jdField_this, paramConfiguration.orientation);
        localObject = BizTimeLineHotView.d(jdField_this);
        if (localObject != null) {
          ((BizTimeLineHotListView)localObject).deu();
        }
        localObject = BizTimeLineHotView.d(jdField_this);
        if (localObject != null) {
          ((BizTimeLineHotListView)localObject).f((List)jdField_this.vPA, true);
        }
        localObject = jdField_this.getBizFinderLiveBar();
        if (localObject != null)
        {
          BizTimeLineHotListView localBizTimeLineHotListView = ((a)localObject).deg();
          if (localBizTimeLineHotListView != null) {
            localBizTimeLineHotListView.der();
          }
          localBizTimeLineHotListView = ((a)localObject).deg();
          if (localBizTimeLineHotListView != null) {
            localBizTimeLineHotListView.deu();
          }
          localBizTimeLineHotListView = ((a)localObject).deg();
          if (localBizTimeLineHotListView != null) {
            localBizTimeLineHotListView.f((List)((a)localObject).vOo, true);
          }
        }
      }
      AppMethodBeat.o(302280);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(BizTimeLineHotView paramBizTimeLineHotView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */