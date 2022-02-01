package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.pluginsdk.model.b.b;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.oe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "context", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "hotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "rootView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;Landroid/view/View;)V", "barContainer", "getBarContainer", "()Landroid/view/View;", "barContainer$delegate", "Lkotlin/Lazy;", "getContext", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineUI;", "hotList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "getHotList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "setHotList", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "getHotView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotView;", "listView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "getListView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "listView$delegate", "getRootView", "getBizFinderLives", "", "hideVideoTitle", "notifyDataChange", "onDestroy", "onLiveStopStatusChange", "bizUserName", "", "exportId", "scene", "", "onOrientationChange", "onPause", "onResume", "reportShow", "setOftenReadTitlePaddingLeft", "left", "", "setVideoTitlePaddingLeft", "Companion", "plugin-brandservice_release"})
public final class a
  implements k
{
  private static MTimerHandler sIK;
  private static boolean sIL;
  public static final a sIM;
  final View oFW;
  private final kotlin.f sIF;
  private final kotlin.f sIG;
  CopyOnWriteArrayList<d> sIH;
  private final BizTimeLineUI sII;
  private final BizTimeLineHotView sIJ;
  
  static
  {
    AppMethodBeat.i(258957);
    sIM = new a((byte)0);
    AppMethodBeat.o(258957);
  }
  
  public a(BizTimeLineUI paramBizTimeLineUI, BizTimeLineHotView paramBizTimeLineHotView, View paramView)
  {
    AppMethodBeat.i(258954);
    this.sII = paramBizTimeLineUI;
    this.sIJ = paramBizTimeLineHotView;
    this.oFW = paramView;
    this.sIF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.sIG = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.sIH = new CopyOnWriteArrayList();
    cBb().a((Context)this.sII, (List)new ArrayList(), this.sIJ.getReadReport(), (k)this, true);
    paramBizTimeLineUI = cBb();
    paramBizTimeLineHotView = this.sIJ.getDecoration();
    if (paramBizTimeLineHotView == null) {
      p.iCn();
    }
    paramBizTimeLineUI.b((RecyclerView.h)paramBizTimeLineHotView);
    AppMethodBeat.o(258954);
  }
  
  public static void onPause()
  {
    AppMethodBeat.i(258944);
    if (sIK != null)
    {
      Log.d("MicroMsg.BizFinderLiveBar", "stopCheckLiveBar");
      MTimerHandler localMTimerHandler = sIK;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      sIK = null;
    }
    AppMethodBeat.o(258944);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(258952);
    if (paramString1 == null)
    {
      AppMethodBeat.o(258952);
      return;
    }
    if (sIL)
    {
      AppMethodBeat.o(258952);
      return;
    }
    paramString2 = (CharSequence)paramString2;
    if ((paramString2 == null) || (n.ba(paramString2))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString2 = b.b.QUa;
        if (paramInt != b.b.hgA())
        {
          paramString2 = b.b.QUa;
          if (paramInt != b.b.hgz()) {
            break;
          }
        }
      }
      AppMethodBeat.o(258952);
      return;
    }
    paramString2 = this.sIH;
    if (paramString2 != null)
    {
      Iterator localIterator = ((Iterable)paramString2).iterator();
      while (localIterator.hasNext())
      {
        paramString2 = localIterator.next();
        if (p.h(((d)paramString2).RKL, paramString1))
        {
          paramString1 = paramString2;
          paramString1 = (d)paramString1;
          if (paramString1 == null) {
            break label257;
          }
          paramString2 = this.sIH;
          if (paramString2 != null) {
            paramString2.remove(paramString1);
          }
          paramString1 = (Collection)this.sIH;
          if ((paramString1 != null) && (!paramString1.isEmpty())) {
            break label218;
          }
          paramInt = 1;
          label186:
          if (paramInt == 0) {
            break label223;
          }
          cBc().setVisibility(8);
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.BizFinderLiveBar", "refreshData on live stop  for live bar");
        AppMethodBeat.o(258952);
        return;
        paramString1 = null;
        break;
        label218:
        paramInt = 0;
        break label186;
        label223:
        paramString1 = cBb();
        if (paramString1 != null) {
          paramString1.b((List)this.sIH, false);
        }
        paramString1 = com.tencent.mm.pluginsdk.model.b.QTJ;
        com.tencent.mm.pluginsdk.model.b.TM(11L);
      }
    }
    label257:
    AppMethodBeat.o(258952);
  }
  
  public final BizTimeLineHotListView cBb()
  {
    AppMethodBeat.i(258941);
    BizTimeLineHotListView localBizTimeLineHotListView = (BizTimeLineHotListView)this.sIF.getValue();
    AppMethodBeat.o(258941);
    return localBizTimeLineHotListView;
  }
  
  public final View cBc()
  {
    AppMethodBeat.i(258942);
    View localView = (View)this.sIG.getValue();
    AppMethodBeat.o(258942);
    return localView;
  }
  
  public final void cBd()
  {
    AppMethodBeat.i(258947);
    if (cBc().getVisibility() == 0)
    {
      localObject = (Collection)this.sIH;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label50;
      }
    }
    label50:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(258947);
      return;
    }
    Object localObject = cBb();
    if (localObject != null)
    {
      ((BizTimeLineHotListView)localObject).cBd();
      AppMethodBeat.o(258947);
      return;
    }
    AppMethodBeat.o(258947);
  }
  
  public final void cBe() {}
  
  public final void cBf() {}
  
  public final void setOftenReadTitlePaddingLeft(float paramFloat) {}
  
  public final void setVideoTitlePaddingLeft(float paramFloat) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar$Companion;", "", "()V", "TAG", "", "checkLiveBarTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "isUpdatingLiveBar", "", "doGetBizFinderLives", "", "liveBar", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar;", "startCheckLiveBar", "stopCheckLiveBar", "plugin-brandservice_release"})
  public static final class a
  {
    static void a(a parama)
    {
      AppMethodBeat.i(266143);
      parama = new WeakReference(parama);
      kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRs(), (m)new a(parama, null), 2);
      AppMethodBeat.o(266143);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<ak, kotlin.d.d<? super x>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      a(WeakReference paramWeakReference, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(264755);
        p.k(paramd, "completion");
        paramd = new a(this.sAJ, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(264755);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(264756);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(264756);
        return paramObject1;
      }
      
      public final Object invokeSuspend(final Object paramObject)
      {
        AppMethodBeat.i(264754);
        Object localObject2 = kotlin.d.a.a.aaAA;
        int i;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(264754);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          if (a.cBg())
          {
            paramObject = x.aazN;
            AppMethodBeat.o(264754);
            return paramObject;
          }
          a.lD(true);
          localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.bcJ().encode("bar_list_last_refresh_time", System.currentTimeMillis());
          localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
          localObject1 = b.b.QUa;
          i = b.b.hgA();
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = com.tencent.mm.pluginsdk.model.b.a(i, null, this);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(264754);
            return localObject2;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (oe)paramObject;
        if (paramObject != null)
        {
          localObject1 = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.bcJ().encode("bar_list_refresh_interval", paramObject.RVv);
        }
        for (;;)
        {
          Log.d("MicroMsg.BizFinderLiveBar", "doGetBizFinderLives");
          a.lD(false);
          if (paramObject != null)
          {
            paramObject = paramObject.RVu;
            if (paramObject != null) {
              break;
            }
          }
          paramObject = x.aazN;
          AppMethodBeat.o(264754);
          return paramObject;
          paramObject = null;
        }
        Object localObject1 = (Iterable)paramObject;
        paramObject = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        Object localObject3;
        Object localObject4;
        label297:
        label356:
        label359:
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (oc)localObject2;
          if (ab.Ql(((oc)localObject3).RKL))
          {
            localObject4 = (CharSequence)((oc)localObject3).RVp;
            if ((localObject4 == null) || (n.ba((CharSequence)localObject4)))
            {
              i = 1;
              if ((i != 0) || (g.apE(((oc)localObject3).RKL))) {
                break label356;
              }
              localObject4 = com.tencent.mm.pluginsdk.model.b.QTJ;
              if (com.tencent.mm.pluginsdk.model.b.nd(((oc)localObject3).RKL, ((oc)localObject3).RVp)) {
                break label356;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label359;
            }
            paramObject.add(localObject2);
            break;
            i = 0;
            break label297;
          }
        }
        localObject1 = (Iterable)paramObject;
        paramObject = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (oc)((Iterator)localObject1).next();
          localObject3 = new d();
          ((d)localObject3).RKL = ((oc)localObject2).RKL;
          ((d)localObject3).RVp = ((oc)localObject2).RVp;
          ((d)localObject3).tmL = ((oc)localObject2).tmL;
          ((d)localObject3).RVq = ((oc)localObject2).RVq;
          ((d)localObject3).title = ((oc)localObject2).title;
          localObject4 = com.tencent.mm.pluginsdk.model.b.QTJ;
          com.tencent.mm.pluginsdk.model.b.a((oc)localObject2);
          paramObject.add(localObject3);
        }
        paramObject = (List)paramObject;
        localObject1 = (a)this.sAJ.get();
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).sIH;
          if (localObject1 != null) {
            ((CopyOnWriteArrayList)localObject1).clear();
          }
        }
        localObject1 = (a)this.sAJ.get();
        if (localObject1 != null)
        {
          localObject1 = ((a)localObject1).sIH;
          if (localObject1 != null) {
            ((CopyOnWriteArrayList)localObject1).addAll((Collection)kotlin.a.j.c((Iterable)paramObject, b.sJR));
          }
        }
        localObject1 = (a)this.sAJ.get();
        if (localObject1 != null) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a((a)localObject1, paramObject));
        }
        paramObject = x.aazN;
        AppMethodBeat.o(264754);
        return paramObject;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizFinderLiveBar$Companion$doGetBizFinderLives$1$1$1"})
      static final class a
        extends q
        implements kotlin.g.a.a<x>
      {
        a(a parama, List paramList)
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
    public static final class b
      implements MTimerHandler.CallBack
    {
      public b(WeakReference paramWeakReference) {}
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(263769);
        a locala = (a)this.svK.get();
        if (locala != null)
        {
          Object localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
          int i = i.ov(com.tencent.mm.pluginsdk.model.b.bcJ().decodeInt("bar_list_refresh_interval", 0), 5);
          localObject = com.tencent.mm.pluginsdk.model.b.QTJ;
          long l = com.tencent.mm.pluginsdk.model.b.bcJ().decodeLong("bar_list_last_refresh_time", 0L);
          Log.d("MicroMsg.BizFinderLiveBar", "checkLiveBarUpdate");
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localObject = a.sIM;
            p.j(locala, "it");
            a.a.a(locala);
          }
        }
        AppMethodBeat.o(263769);
        return true;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotListView;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<BizTimeLineHotListView>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.a
 * JD-Core Version:    0.7.0.1
 */