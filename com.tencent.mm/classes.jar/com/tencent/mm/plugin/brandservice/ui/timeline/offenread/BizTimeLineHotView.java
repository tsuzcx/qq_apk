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
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.a.ao;
import com.tencent.mm.f.a.ao.a;
import com.tencent.mm.f.a.ap;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.protocal.protobuf.err;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bizFinderLiveBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "getBizFinderLiveBar", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "setBizFinderLiveBar", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;)V", "decoration", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewItemDecoration;", "getDecoration", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewItemDecoration;", "setDecoration", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewItemDecoration;)V", "hasGetOftenRead", "", "idleHandler", "Landroid/os/MessageQueue$IdleHandler;", "isFirstTimeRefresh", "isServerRank", "itemPadding", "getItemPadding", "()I", "mBizDeleteContactListener", "Lcom/tencent/mm/sdk/event/IListener;", "mContextWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getMContextWeakRef", "()Ljava/lang/ref/WeakReference;", "setMContextWeakRef", "(Ljava/lang/ref/WeakReference;)V", "mItemPadding", "mLastConfigOrientation", "mListView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "mOftenReadList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "mTitle", "Landroid/widget/TextView;", "mVideoTitle", "paddingLeft", "", "readReport", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineOftenReadReport;", "getReadReport", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineOftenReadReport;", "videoPaddingLeft", "doGetOftenRead", "", "getLocalOftenReadData", "hasVideoChannel", "hideVideoTitle", "init", "initFinderLive", "rootView", "Landroid/view/View;", "initOftenReadList", "resp", "Lcom/tencent/mm/protocal/protobuf/TimelineGetOftenReadBizResp;", "notifyDataChange", "onClick", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDelete", "onDestroy", "onLiveStopStatusChange", "bizUserName", "", "exportId", "scene", "onNotifyChange", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUpdateGreenDot", "refreshData", "refreshUnread", "reportShow", "saveRespData", "setOftenReadTitlePaddingLeft", "left", "setVideoTitlePaddingLeft", "sortListView", "list", "Ljava/util/ArrayList;", "sortLiveStatusOnly", "updateGreenDot", "talker", "updateInfo", "hotViewInfo", "Companion", "plugin-brandservice_release"})
public final class BizTimeLineHotView
  extends LinearLayout
  implements com.tencent.mm.an.i, k, MStorageEx.IOnStorageChange
{
  public static final a sJF;
  private static IListener<ap> svD;
  private TextView mLH;
  private float paddingLeft;
  public final h sIV;
  public a sJA;
  public final IListener<?> sJB;
  private float sJC;
  private boolean sJD;
  private final MessageQueue.IdleHandler sJE;
  private WeakReference<Activity> sJr;
  public BizTimeLineHotListView sJs;
  private TextView sJt;
  private int sJu;
  private boolean sJv;
  public CopyOnWriteArrayList<d> sJw;
  private e sJx;
  private int sJy;
  private boolean sJz;
  
  static
  {
    AppMethodBeat.i(265261);
    sJF = new a((byte)0);
    AppMethodBeat.o(265261);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(6105);
    this.sJw = new CopyOnWriteArrayList();
    this.sIV = new h();
    this.sJB = ((IListener)new d(this));
    this.paddingLeft = -1.0F;
    this.sJC = -1.0F;
    this.sJD = true;
    this.sJE = ((MessageQueue.IdleHandler)new b(this));
    init(paramContext);
    AppMethodBeat.o(6105);
  }
  
  public BizTimeLineHotView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(6106);
    this.sJw = new CopyOnWriteArrayList();
    this.sIV = new h();
    this.sJB = ((IListener)new d(this));
    this.paddingLeft = -1.0F;
    this.sJC = -1.0F;
    this.sJD = true;
    this.sJE = ((MessageQueue.IdleHandler)new b(this));
    init(paramContext);
    AppMethodBeat.o(6106);
  }
  
  public static void O(ArrayList<d> paramArrayList)
  {
    AppMethodBeat.i(265257);
    p.k(paramArrayList, "list");
    if (Util.isNullOrNil((List)paramArrayList))
    {
      AppMethodBeat.o(265257);
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      d((d)paramArrayList.next());
    }
    AppMethodBeat.o(265257);
  }
  
  private final void a(final err paramerr)
  {
    AppMethodBeat.i(6116);
    if (paramerr != null)
    {
      com.tencent.mm.plugin.brandservice.ui.b.a.Ia(paramerr.UtK * 1000);
      com.tencent.mm.plugin.brandservice.ui.b.a.Ib(paramerr.UtI);
      com.tencent.mm.pluginsdk.model.b localb = com.tencent.mm.pluginsdk.model.b.QTJ;
      com.tencent.mm.pluginsdk.model.b.DI(paramerr.UtL);
      if (paramerr.UtH != null) {}
      for (int i = paramerr.UtH.size();; i = 0)
      {
        Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size %d,server_rank:%d,display_ctrl_flag:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramerr.UtJ), Integer.valueOf(paramerr.UtI) });
        if (!com.tencent.mm.plugin.brandservice.ui.b.a.Hv(4)) {
          break;
        }
        setVisibility(8);
        AppMethodBeat.o(6116);
        return;
      }
    }
    AppMethodBeat.o(6116);
    return;
    if (com.tencent.mm.plugin.biz.b.c.cxL())
    {
      paramerr.UtH.clear();
      this.sJw.clear();
    }
    if ((Util.isNullOrNil((List)paramerr.UtH)) && (Util.isNullOrNil((List)this.sJw)) && (!cBm()))
    {
      setVisibility(8);
      Log.i("MicroMsg.BizTimeLineHotList", "initOftenReadList size is null");
      AppMethodBeat.o(6116);
      return;
    }
    com.tencent.e.h.ZvG.d((Runnable)new c(this, paramerr), "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(6116);
  }
  
  private final void a(ArrayList<d> paramArrayList, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(265258);
    if (Util.isNullOrNil((List)paramArrayList))
    {
      AppMethodBeat.o(265258);
      return;
    }
    this.sJz = paramBoolean1;
    Log.d("MicroMsg.BizTimeLineHotList", "sortListView isServerRank=" + paramBoolean1 + ", sortLiveStatusOnly=" + paramBoolean2);
    j.a((List)paramArrayList, (Comparator)new j(paramBoolean2, paramBoolean1));
    this.sJw.clear();
    this.sJw.addAll((Collection)paramArrayList);
    AppMethodBeat.o(265258);
  }
  
  private final void cBl()
  {
    AppMethodBeat.i(265255);
    com.tencent.e.h.ZvG.d((Runnable)new i(this), "MicroMsg.BizTimeLineHotList");
    AppMethodBeat.o(265255);
  }
  
  private static boolean cBm()
  {
    AppMethodBeat.i(265256);
    if ((com.tencent.mm.plugin.brandservice.b.d.cyY()) && (com.tencent.mm.plugin.brandservice.b.d.cza() != null))
    {
      AppMethodBeat.o(265256);
      return true;
    }
    AppMethodBeat.o(265256);
    return false;
  }
  
  public static boolean d(d paramd)
  {
    AppMethodBeat.i(6118);
    Object localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbL();
    if (paramd == null) {
      p.iCn();
    }
    long l = ((bv)localObject).bwk(paramd.RKL);
    localObject = af.bjB().UA(l);
    if (localObject == null)
    {
      AppMethodBeat.o(6118);
      return false;
    }
    paramd.rLi = ((z)localObject).field_createTime;
    localObject = com.tencent.mm.kernel.h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((n)localObject).bbR().bwx(paramd.RKL);
    boolean bool = paramd.sJW;
    paramd.sJW = false;
    if (localObject != null) {}
    for (int i = ((az)localObject).apz();; i = 0)
    {
      if ((i > 0) && (System.currentTimeMillis() - paramd.rLi < com.tencent.mm.plugin.brandservice.ui.b.a.cEm()))
      {
        i = af.bjD().UQ(l);
        p.j(localObject, "cvs");
        if (((az)localObject).apz() > i) {
          paramd.sJW = true;
        }
      }
      if (bool == paramd.sJW) {
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
    if (!Util.isNullOrNil((List)this.sJw))
    {
      AppMethodBeat.o(6114);
      return;
    }
    a(g.cBq());
    AppMethodBeat.o(6114);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(6111);
    p.k(paramContext, "context");
    com.tencent.mm.kernel.h.aGY().a(2768, (com.tencent.mm.an.i)this);
    this.sJr = new WeakReference((Activity)paramContext);
    b.init(paramContext);
    this.sJu = getItemPadding();
    Object localObject = ad.kS(paramContext).inflate(d.f.sqv, (ViewGroup)this);
    this.sJs = ((BizTimeLineHotListView)((View)localObject).findViewById(d.e.squ));
    this.mLH = ((TextView)((View)localObject).findViewById(d.e.sqI));
    this.sJt = ((TextView)((View)localObject).findViewById(d.e.sqJ));
    this.sJx = new e(this.sJu, paramContext);
    BizTimeLineHotListView localBizTimeLineHotListView = this.sJs;
    if (localBizTimeLineHotListView != null)
    {
      e locale = this.sJx;
      if (locale == null) {
        p.iCn();
      }
      localBizTimeLineHotListView.b((RecyclerView.h)locale);
    }
    localBizTimeLineHotListView = this.sJs;
    if (localBizTimeLineHotListView != null) {
      localBizTimeLineHotListView.a(paramContext, (List)this.sJw, this.sIV, (k)this, false);
    }
    getLocalOftenReadData();
    if (!this.sJv)
    {
      this.sJv = true;
      paramContext = new l();
      com.tencent.mm.kernel.h.aGY().b((q)paramContext);
    }
    p.j(localObject, "rootView");
    paramContext = com.tencent.mm.pluginsdk.model.b.QTJ;
    if (((Boolean)com.tencent.mm.pluginsdk.model.b.QTw.getValue()).booleanValue())
    {
      paramContext = (ViewStub)((View)localObject).findViewById(d.e.sqs);
      if ((paramContext != null) && (paramContext.inflate() != null)) {
        break label378;
      }
    }
    for (;;)
    {
      paramContext = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramContext, "MMKernel.service(IMessengerStorage::class.java)");
      ((n)paramContext).bbR().add((MStorageEx.IOnStorageChange)this);
      EventCenter.instance.addListener(this.sJB);
      paramContext = com.tencent.mm.pluginsdk.model.b.QTJ;
      if (!com.tencent.mm.pluginsdk.model.b.hgd()) {
        break;
      }
      paramContext = (k)this;
      p.k(paramContext, "hotView");
      if (svD != null) {
        break;
      }
      paramContext = (IListener)new BizTimeLineHotView.a.a(new WeakReference(paramContext));
      svD = paramContext;
      paramContext.alive();
      AppMethodBeat.o(6111);
      return;
      label378:
      paramContext = getContext();
      if (paramContext == null)
      {
        paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI");
        AppMethodBeat.o(6111);
        throw paramContext;
      }
      this.sJA = new a((BizTimeLineUI)paramContext, this, (View)localObject);
      paramContext = this.sJA;
      if (paramContext != null)
      {
        localObject = a.sIM;
        a.a.a(paramContext);
      }
    }
    AppMethodBeat.o(6111);
  }
  
  private final void refreshData()
  {
    AppMethodBeat.i(265260);
    com.tencent.e.h.ZvG.bc((Runnable)new g(this));
    AppMethodBeat.o(265260);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(265253);
    if (paramString1 == null)
    {
      AppMethodBeat.o(265253);
      return;
    }
    Object localObject = b.b.QUa;
    if (paramInt != b.b.hgz())
    {
      localObject = b.b.QUa;
      if (paramInt != b.b.hgA())
      {
        Iterator localIterator = ((Iterable)this.sJw).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.h(((d)localObject).RKL, paramString1));
      }
    }
    for (;;)
    {
      localObject = (d)localObject;
      if (localObject != null)
      {
        ((d)localObject).RVp = paramString2;
        refreshData();
        cBl();
        localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.TM(10L);
        Log.i("MicroMsg.BizTimeLineHotList", "refreshData on live stop for often read");
      }
      localObject = this.sJA;
      if (localObject == null) {
        break;
      }
      ((a)localObject).J(paramString1, paramString2, paramInt);
      AppMethodBeat.o(265253);
      return;
      localObject = null;
    }
    AppMethodBeat.o(265253);
  }
  
  public final void apD(final String paramString)
  {
    AppMethodBeat.i(6108);
    com.tencent.mm.plugin.brandservice.b.am((Runnable)new k(this, paramString));
    AppMethodBeat.o(6108);
  }
  
  public final void cBd()
  {
    AppMethodBeat.i(6119);
    if (getVisibility() == 0)
    {
      if (!Util.isNullOrNil((List)this.sJw)) {
        break label57;
      }
      localObject = this.sJs;
      if (localObject != null)
      {
        if (((BizTimeLineHotListView)localObject).cBi() == true) {
          break label57;
        }
        AppMethodBeat.o(6119);
        return;
      }
    }
    AppMethodBeat.o(6119);
    return;
    label57:
    Object localObject = this.sJs;
    if (localObject != null) {
      ((BizTimeLineHotListView)localObject).cBd();
    }
    localObject = this.sJA;
    if (localObject != null)
    {
      ((a)localObject).cBd();
      AppMethodBeat.o(6119);
      return;
    }
    AppMethodBeat.o(6119);
  }
  
  public final void cBe()
  {
    AppMethodBeat.i(265251);
    if (this.sJt != null)
    {
      TextView localTextView = this.sJt;
      if (localTextView == null) {
        p.iCn();
      }
      if (localTextView.getVisibility() == 0)
      {
        localTextView = this.sJt;
        if (localTextView == null) {
          p.iCn();
        }
        localTextView.setVisibility(8);
      }
    }
    AppMethodBeat.o(265251);
  }
  
  public final void cBf()
  {
    AppMethodBeat.i(265252);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.sJw);
    a(localArrayList, this.sJz, true);
    refreshData();
    cBl();
    AppMethodBeat.o(265252);
  }
  
  public final a getBizFinderLiveBar()
  {
    return this.sJA;
  }
  
  public final e getDecoration()
  {
    return this.sJx;
  }
  
  public final int getItemPadding()
  {
    AppMethodBeat.i(6110);
    int i = b.eQ(getContext());
    AppMethodBeat.o(6110);
    return i;
  }
  
  public final WeakReference<Activity> getMContextWeakRef()
  {
    return this.sJr;
  }
  
  public final h getReadReport()
  {
    return this.sIV;
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(6112);
    p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    Object localObject = this.sJr;
    if (localObject != null) {}
    for (localObject = (Activity)((WeakReference)localObject).get(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(6112);
      return;
    }
    localObject = this.sJr;
    if (localObject != null)
    {
      localObject = (Activity)((WeakReference)localObject).get();
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            break label97;
          }
        }
      }
    }
    AppMethodBeat.o(6112);
    return;
    label97:
    p.j(localObject, "mContextWeakRef?.get()?.…ndow?.decorView ?: return");
    ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new e(this, (View)localObject, paramConfiguration));
    AppMethodBeat.o(6112);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(6109);
    p.k(paramMStorageEx, "stg");
    p.k(paramObject, "obj");
    if (!(paramObject instanceof String))
    {
      Log.e("MicroMsg.BizTimeLineHotList", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(6109);
      return;
    }
    paramMStorageEx = this.sJr;
    if (paramMStorageEx != null)
    {
      paramMStorageEx = (Activity)paramMStorageEx.get();
      if ((paramMStorageEx != null) && (paramMStorageEx.isFinishing() == true))
      {
        AppMethodBeat.o(6109);
        return;
      }
    }
    apD((String)paramObject);
    AppMethodBeat.o(6109);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(6120);
    p.k(paramq, "scene");
    Log.i("MicroMsg.BizTimeLineHotList", "onSceneEnd, type %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(6120);
      return;
    }
    if ((paramq instanceof l))
    {
      paramString = ((l)paramq).cBt();
      paramq = this.sJr;
      if (paramq != null)
      {
        paramq = (Activity)paramq.get();
        if ((paramq != null) && (paramq.isFinishing() == true))
        {
          AppMethodBeat.o(6120);
          return;
        }
      }
      if (com.tencent.mm.plugin.brandservice.ui.b.c.b((com.tencent.mm.cd.a)paramString, (com.tencent.mm.cd.a)g.cBq()))
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
  
  public final void p(final z paramz)
  {
    AppMethodBeat.i(6107);
    if (paramz != null) {
      com.tencent.e.h.ZvG.d((Runnable)new f(this, paramz), "MicroMsg.BizTimeLineHotList");
    }
    AppMethodBeat.o(6107);
  }
  
  public final void setBizFinderLiveBar(a parama)
  {
    this.sJA = parama;
  }
  
  public final void setDecoration(e parame)
  {
    this.sJx = parame;
  }
  
  public final void setMContextWeakRef(WeakReference<Activity> paramWeakReference)
  {
    this.sJr = paramWeakReference;
  }
  
  public final void setOftenReadTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(265249);
    if (this.mLH != null)
    {
      if (this.paddingLeft == paramFloat)
      {
        AppMethodBeat.o(265249);
        return;
      }
      this.paddingLeft = paramFloat;
      TextView localTextView1 = this.mLH;
      if (localTextView1 == null) {
        p.iCn();
      }
      int i = (int)paramFloat;
      TextView localTextView2 = this.mLH;
      if (localTextView2 == null) {
        p.iCn();
      }
      int j = localTextView2.getPaddingTop();
      localTextView2 = this.mLH;
      if (localTextView2 == null) {
        p.iCn();
      }
      int k = localTextView2.getPaddingRight();
      localTextView2 = this.mLH;
      if (localTextView2 == null) {
        p.iCn();
      }
      localTextView1.setPadding(i, j, k, localTextView2.getPaddingBottom());
    }
    AppMethodBeat.o(265249);
  }
  
  public final void setVideoTitlePaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(265250);
    if (this.sJt != null)
    {
      if (this.sJC == paramFloat)
      {
        AppMethodBeat.o(265250);
        return;
      }
      this.sJC = paramFloat;
      TextView localTextView1 = this.sJt;
      if (localTextView1 == null) {
        p.iCn();
      }
      if (localTextView1.getVisibility() != 0)
      {
        localTextView1 = this.sJt;
        if (localTextView1 == null) {
          p.iCn();
        }
        localTextView1.setVisibility(0);
      }
      localTextView1 = this.sJt;
      if (localTextView1 == null) {
        p.iCn();
      }
      int i = (int)paramFloat;
      TextView localTextView2 = this.sJt;
      if (localTextView2 == null) {
        p.iCn();
      }
      int j = localTextView2.getPaddingTop();
      localTextView2 = this.sJt;
      if (localTextView2 == null) {
        p.iCn();
      }
      int k = localTextView2.getPaddingRight();
      localTextView2 = this.sJt;
      if (localTextView2 == null) {
        p.iCn();
      }
      localTextView1.setPadding(i, j, k, localTextView2.getPaddingBottom());
    }
    AppMethodBeat.o(265250);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$Companion;", "", "()V", "TAG", "", "liveStatusChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BizFinderLineStatusChangedEvent;", "addLiveStatusChangeListener", "", "hotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "removeLiveStatusChangeListener", "plugin-brandservice_release"})
  public static final class a
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$Companion$addLiveStatusChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BizFinderLineStatusChangedEvent;", "callback", "", "event", "plugin-brandservice_release"})
    public static final class a
      extends IListener<ap>
    {
      a(WeakReference paramWeakReference) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$idleHandler$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "plugin-brandservice_release"})
  public static final class b
    implements MessageQueue.IdleHandler
  {
    public final boolean queueIdle()
    {
      AppMethodBeat.i(266334);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      Object localObject = this.sJH.getMContextWeakRef();
      if (localObject != null)
      {
        localObject = (Activity)((WeakReference)localObject).get();
        if ((localObject != null) && (((Activity)localObject).isFinishing() == true))
        {
          AppMethodBeat.o(266334);
          return false;
        }
      }
      localObject = BizTimeLineHotView.c(this.sJH);
      if (localObject != null) {
        ((BizTimeLineHotListView)localObject).b((List)this.sJH.sJw, true);
      }
      AppMethodBeat.o(266334);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(BizTimeLineHotView paramBizTimeLineHotView, err paramerr) {}
    
    public final void run()
    {
      boolean bool = false;
      AppMethodBeat.i(257923);
      if (!Util.isNullOrNil((List)paramerr.UtH))
      {
        ArrayList localArrayList = new ArrayList();
        Object localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
        localObject1 = paramerr.UtH;
        p.j(localObject1, "resp.biz_info_list");
        com.tencent.mm.pluginsdk.model.b.cc((LinkedList)localObject1);
        localObject1 = paramerr.UtH.iterator();
        int i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          eru localeru = (eru)((Iterator)localObject1).next();
          int j = i + 1;
          if (j > b.sJR) {
            break;
          }
          Object localObject2 = new d();
          i = j;
          if (ab.Ql(localeru.RKL))
          {
            ((d)localObject2).RKL = localeru.RKL;
            ((d)localObject2).RVp = localeru.RVp;
            ((d)localObject2).tmL = localeru.tmL;
            ((d)localObject2).RVq = localeru.RVq;
            ((d)localObject2).title = localeru.title;
            localArrayList.add(localObject2);
            localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
            if (com.tencent.mm.pluginsdk.model.b.ni(localeru.RKL, localeru.RVp))
            {
              localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
              localObject2 = localeru.RKL;
              String str = localeru.RVp;
              b.b localb = b.b.QUa;
              com.tencent.mm.pluginsdk.model.b.ax((String)localObject2, str, b.b.hgz());
            }
            localObject2 = com.tencent.mm.pluginsdk.model.b.QTJ;
            localObject2 = new oc();
            ((oc)localObject2).RKL = localeru.RKL;
            ((oc)localObject2).RVp = localeru.RVp;
            ((oc)localObject2).tmL = localeru.tmL;
            ((oc)localObject2).title = localeru.title;
            ((oc)localObject2).RVq = localeru.RVq;
            com.tencent.mm.pluginsdk.model.b.a((oc)localObject2);
            i = j;
          }
        }
        BizTimeLineHotView.O(localArrayList);
        localObject1 = this.sJH;
        if (paramerr.UtJ == 1) {
          bool = true;
        }
        BizTimeLineHotView.a((BizTimeLineHotView)localObject1, localArrayList, bool);
      }
      BizTimeLineHotView.d(this.sJH);
      AppMethodBeat.o(257923);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$mBizDeleteContactListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BizDeleteContactEvent;", "callback", "", "event", "plugin-brandservice_release"})
  public static final class d
    extends IListener<ao>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(BizTimeLineHotView.d paramd, ao paramao) {}
      
      public final void run()
      {
        AppMethodBeat.i(262273);
        Iterator localIterator = this.sJJ.sJH.sJw.iterator();
        d locald;
        String str;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          locald = (d)localIterator.next();
          str = this.sJK.fvX.userName;
          if (locald == null) {
            p.iCn();
          }
        } while (!p.h(str, locald.RKL));
        for (;;)
        {
          if (locald != null) {
            this.sJJ.sJH.sJw.remove(locald);
          }
          BizTimeLineHotView.d(this.sJJ.sJH);
          AppMethodBeat.o(262273);
          return;
          locald = null;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-brandservice_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    e(View paramView, Configuration paramConfiguration) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(265499);
      this.sJL.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i = this.sJH.getItemPadding();
      if ((BizTimeLineHotView.a(this.sJH) != paramConfiguration.orientation) || (BizTimeLineHotView.b(this.sJH) != i))
      {
        BizTimeLineHotView.b(this.sJH, i);
        Object localObject = this.sJH.getDecoration();
        if (localObject != null) {
          ((e)localObject).GS(BizTimeLineHotView.b(this.sJH));
        }
        BizTimeLineHotView.a(this.sJH, paramConfiguration.orientation);
        localObject = BizTimeLineHotView.c(this.sJH);
        if (localObject != null) {
          ((BizTimeLineHotListView)localObject).cBj();
        }
        localObject = BizTimeLineHotView.c(this.sJH);
        if (localObject != null) {
          ((BizTimeLineHotListView)localObject).b((List)this.sJH.sJw, true);
        }
        localObject = this.sJH.getBizFinderLiveBar();
        if (localObject != null)
        {
          BizTimeLineHotListView localBizTimeLineHotListView = ((a)localObject).cBb();
          if (localBizTimeLineHotListView != null) {
            localBizTimeLineHotListView.cBj();
          }
          localBizTimeLineHotListView = ((a)localObject).cBb();
          if (localBizTimeLineHotListView != null)
          {
            localBizTimeLineHotListView.b((List)((a)localObject).sIH, true);
            AppMethodBeat.o(265499);
            return;
          }
          AppMethodBeat.o(265499);
          return;
        }
      }
      AppMethodBeat.o(265499);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(BizTimeLineHotView paramBizTimeLineHotView, z paramz) {}
    
    public final void run()
    {
      AppMethodBeat.i(258609);
      Object localObject = af.bjB().UA(paramz.field_talkerId);
      if ((localObject != null) && (((z)localObject).field_msgId == paramz.field_msgId))
      {
        localObject = com.tencent.mm.kernel.h.ae(n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        ((n)localObject).bbR().bwz(paramz.field_talker);
        this.sJH.apD(paramz.field_talker);
      }
      AppMethodBeat.o(258609);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(BizTimeLineHotView paramBizTimeLineHotView) {}
    
    public final void run()
    {
      AppMethodBeat.i(265584);
      Object localObject = this.sJH.getMContextWeakRef();
      if (localObject != null)
      {
        localObject = (Activity)((WeakReference)localObject).get();
        if ((localObject != null) && (((Activity)localObject).isFinishing() == true))
        {
          AppMethodBeat.o(265584);
          return;
        }
      }
      if ((Util.isNullOrNil((List)this.sJH.sJw)) && (!BizTimeLineHotView.cBn()))
      {
        this.sJH.setVisibility(8);
        AppMethodBeat.o(265584);
        return;
      }
      if (Util.isNullOrNil((List)this.sJH.sJw))
      {
        localObject = BizTimeLineHotView.e(this.sJH);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        if (!BizTimeLineHotView.cBn()) {
          break label224;
        }
        localObject = BizTimeLineHotView.f(this.sJH);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      for (;;)
      {
        if (this.sJH.getVisibility() != 0) {
          this.sJH.setVisibility(0);
        }
        if (!BizTimeLineHotView.g(this.sJH)) {
          break label251;
        }
        BizTimeLineHotView.h(this.sJH);
        localObject = BizTimeLineHotView.c(this.sJH);
        if (localObject == null) {
          break label245;
        }
        ((BizTimeLineHotListView)localObject).cs((List)this.sJH.sJw);
        AppMethodBeat.o(265584);
        return;
        localObject = BizTimeLineHotView.e(this.sJH);
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setVisibility(0);
        break;
        label224:
        localObject = BizTimeLineHotView.f(this.sJH);
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
      }
      label245:
      AppMethodBeat.o(265584);
      return;
      label251:
      Looper.myQueue().removeIdleHandler(BizTimeLineHotView.i(this.sJH));
      Looper.myQueue().addIdleHandler(BizTimeLineHotView.i(this.sJH));
      AppMethodBeat.o(265584);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(BizTimeLineHotView paramBizTimeLineHotView, d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(263848);
      BizTimeLineHotListView localBizTimeLineHotListView = BizTimeLineHotView.c(this.sJH);
      if (localBizTimeLineHotListView != null)
      {
        localBizTimeLineHotListView.a(this.sJN);
        AppMethodBeat.o(263848);
        return;
      }
      AppMethodBeat.o(263848);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(BizTimeLineHotView paramBizTimeLineHotView) {}
    
    public final void run()
    {
      AppMethodBeat.i(264114);
      err localerr = g.cBq();
      localerr.UtH.clear();
      localerr.UtH.addAll((Collection)this.sJH.sJw);
      g.b(localerr);
      AppMethodBeat.o(264114);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "a", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "kotlin.jvm.PlatformType", "b", "compare"})
  static final class j<T>
    implements Comparator<d>
  {
    j(boolean paramBoolean1, boolean paramBoolean2) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(BizTimeLineHotView paramBizTimeLineHotView, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(264164);
      if (this.sJH.sJw.isEmpty())
      {
        AppMethodBeat.o(264164);
        return;
      }
      if ((paramString == null) || (ab.QL(paramString)))
      {
        AppMethodBeat.o(264164);
        return;
      }
      try
      {
        Iterator localIterator = this.sJH.sJw.iterator();
        while (localIterator.hasNext())
        {
          d locald = (d)localIterator.next();
          String str = paramString;
          if (locald == null) {
            p.iCn();
          }
          if (p.h(str, locald.RKL))
          {
            if (BizTimeLineHotView.d(locald)) {
              BizTimeLineHotView.a(this.sJH, locald);
            }
            AppMethodBeat.o(264164);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.BizTimeLineHotList", "updateGreenDot ex:%s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(264164);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView
 * JD-Core Version:    0.7.0.1
 */