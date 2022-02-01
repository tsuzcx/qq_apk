package com.tencent.mm.plugin.brandservice.model;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.at;
import com.tencent.mm.plugin.bizui.widget.StoryListView;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ab;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/model/BizFinderLiveUILogic;", "", "()V", "TAG", "", "checkOftenReadLiveTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "doingCigUserNameList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getDoingCigUserNameList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "firstVisibleItem", "", "getFirstVisibleItem", "()I", "setFirstVisibleItem", "(I)V", "isUpdatingOftenReadLive", "", "liveStatusChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/BizFinderLineStatusChangedEvent;", "addLiveStatusChangeListener", "", "adapter", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter;", "listView", "Lcom/tencent/mm/plugin/bizui/widget/StoryListView;", "checkOftenRead", "bizTimeLineHotView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/IBizTimeLineHotView;", "mOftenReadList", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/offenread/BizTimeLineHotViewInfo;", "checkPosition", "onDestroy", "startCheckOftenReadBizLives", "stopCheckOftenReadBizLivesTimer", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vBp;
  private static MTimerHandler vBq;
  private static boolean vBr;
  private static int vBs;
  private static IListener<at> vBt;
  private static final CopyOnWriteArrayList<String> vBu;
  
  static
  {
    AppMethodBeat.i(303504);
    vBp = new a();
    vBu = new CopyOnWriteArrayList();
    AppMethodBeat.o(303504);
  }
  
  public static void GZ(int paramInt)
  {
    vBs = paramInt;
  }
  
  public static void a(final StoryListView paramStoryListView, b paramb)
  {
    AppMethodBeat.i(303482);
    Object localObject1 = c.XPt;
    if (!c.iGY())
    {
      AppMethodBeat.o(303482);
      return;
    }
    if (paramStoryListView == null)
    {
      AppMethodBeat.o(303482);
      return;
    }
    if (paramb == null)
    {
      AppMethodBeat.o(303482);
      return;
    }
    int m = paramStoryListView.getFirstVisiblePosition();
    int n = paramStoryListView.getLastVisiblePosition();
    LinkedList localLinkedList = new LinkedList();
    int j;
    int i;
    if (m <= n)
    {
      j = m;
      i = 0;
    }
    for (;;)
    {
      label121:
      Object localObject2;
      if (j != 0)
      {
        localObject1 = paramStoryListView.getChildAt(i);
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getTag();
          if (!(localObject1 instanceof com.tencent.mm.plugin.brandservice.ui.timeline.item.a)) {
            break label313;
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1;
          if (localObject1 != null) {
            break label319;
          }
          localObject1 = null;
          if ((localObject1 != null) && (((ab)localObject1).iYe()))
          {
            localObject2 = (CharSequence)((ab)localObject1).field_talker;
            if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
              break label329;
            }
          }
        }
      }
      label313:
      label319:
      label329:
      for (int k = 1;; k = 0)
      {
        if (k == 0)
        {
          localObject2 = c.XPt;
          if (c.bpl(((ab)localObject1).field_talker)) {
            localLinkedList.add(((ab)localObject1).field_talker);
          }
        }
        if (j != n) {
          break label335;
        }
        Log.d("MicroMsg.BizFinderLiveUILogic", "checkPosition startPos=" + m + ", endPos=" + n + ", size = " + localLinkedList.size());
        localLinkedList.removeAll((Collection)vBu);
        if (!Util.isNullOrNil((List)localLinkedList))
        {
          paramStoryListView = new WeakReference(paramb);
          j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new b(localLinkedList, paramStoryListView, null), 2);
        }
        AppMethodBeat.o(303482);
        return;
        localObject1 = null;
        break;
        localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.a)localObject1).vGS;
        break label121;
      }
      label335:
      j += 1;
      i += 1;
    }
  }
  
  public static void a(b paramb, StoryListView paramStoryListView)
  {
    AppMethodBeat.i(303477);
    s.u(paramb, "adapter");
    s.u(paramStoryListView, "listView");
    if (vBt == null)
    {
      paramb = new WeakReference(paramb);
      paramb = (IListener)new BizFinderLiveUILogic.addLiveStatusChangeListener.1(new WeakReference(paramStoryListView), paramStoryListView, paramb, com.tencent.mm.app.f.hfK);
      vBt = paramb;
      paramb.alive();
    }
    AppMethodBeat.o(303477);
  }
  
  public static void a(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k paramk, CopyOnWriteArrayList<e> paramCopyOnWriteArrayList)
  {
    AppMethodBeat.i(303486);
    s.u(paramk, "bizTimeLineHotView");
    s.u(paramCopyOnWriteArrayList, "mOftenReadList");
    if (vBq == null)
    {
      c localc = c.XPt;
      if (c.iGW()) {}
    }
    else
    {
      AppMethodBeat.o(303486);
      return;
    }
    Log.d("MicroMsg.BizFinderLiveUILogic", "startCheckOftenReadBizLives");
    paramk = new MTimerHandler("CheckOftenReadBizLives", new a..ExternalSyntheticLambda0(new WeakReference(paramk), paramCopyOnWriteArrayList), true);
    vBq = paramk;
    paramk.startTimer(5000L, 5000L);
    AppMethodBeat.o(303486);
  }
  
  private static final boolean a(final WeakReference paramWeakReference, CopyOnWriteArrayList paramCopyOnWriteArrayList)
  {
    AppMethodBeat.i(303493);
    s.u(paramWeakReference, "$weakBizComponent");
    s.u(paramCopyOnWriteArrayList, "$mOftenReadList");
    if (vBs > 0)
    {
      Log.d("MicroMsg.BizFinderLiveUILogic", "startCheckOftenReadBizLives often read bar hide");
      AppMethodBeat.o(303493);
      return true;
    }
    paramWeakReference = (com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      s.u(paramWeakReference, "bizTimeLineHotView");
      s.u(paramCopyOnWriteArrayList, "mOftenReadList");
      c localc = c.XPt;
      if (c.iGW())
      {
        paramWeakReference = new WeakReference(paramWeakReference);
        j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCi(), null, (m)new a(paramCopyOnWriteArrayList, paramWeakReference, null), 2);
      }
    }
    AppMethodBeat.o(303493);
    return true;
  }
  
  public static CopyOnWriteArrayList<String> dbO()
  {
    return vBu;
  }
  
  public static void dbP()
  {
    AppMethodBeat.i(303488);
    if (vBq != null)
    {
      Log.d("MicroMsg.BizFinderLiveUILogic", "stopCheckOftenReadBizLivesTimer");
      MTimerHandler localMTimerHandler = vBq;
      if (localMTimerHandler != null) {
        localMTimerHandler.stopTimer();
      }
      vBq = null;
    }
    AppMethodBeat.o(303488);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(303485);
    Object localObject = c.XPt;
    c.onDestroy();
    localObject = vBt;
    if (localObject != null) {
      ((IListener)localObject).dead();
    }
    vBt = null;
    AppMethodBeat.o(303485);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    a(CopyOnWriteArrayList<e> paramCopyOnWriteArrayList, WeakReference<com.tencent.mm.plugin.brandservice.ui.timeline.offenread.k> paramWeakReference, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(303446);
      paramObject = (kotlin.d.d)new a(this.vBy, paramWeakReference, paramd);
      AppMethodBeat.o(303446);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(303441);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      Object localObject3;
      Object localObject4;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303441);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new LinkedList();
        localObject1 = ((Iterable)this.vBy).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (e)((Iterator)localObject1).next();
          localObject4 = c.XPt;
          if (c.bpl(((e)localObject3).YIf)) {
            paramObject.add(((e)localObject3).YIf);
          }
        }
        Log.d("MicroMsg.BizFinderLiveUILogic", s.X("checkOftenRead size = ", Integer.valueOf(paramObject.size())));
        if (!Util.isNullOrNil((List)paramObject))
        {
          if (a.dbQ())
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(303441);
            return paramObject;
          }
          localObject1 = a.vBp;
          a.mM(true);
          localObject1 = c.XPt;
          localObject1 = (kotlin.d.d)this;
          this.L$0 = paramObject;
          this.label = 1;
          localObject1 = c.a(1, paramObject, (kotlin.d.d)localObject1);
          if (localObject1 != localObject2) {
            break label550;
          }
          AppMethodBeat.o(303441);
          return localObject2;
        }
        break;
      case 1: 
        localObject2 = (LinkedList)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      label408:
      label550:
      for (;;)
      {
        localObject3 = (pn)localObject1;
        localObject1 = a.vBp;
        a.mM(false);
        localObject1 = new ah.a();
        localObject2 = new HashMap();
        if (localObject3 != null)
        {
          localObject3 = ((pn)localObject3).YSX;
          if (localObject3 != null)
          {
            localObject3 = ((Iterable)localObject3).iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject4 = (pi)((Iterator)localObject3).next();
              Object localObject5 = c.XPt;
              Object localObject6;
              int i;
              if (c.pb(((pi)localObject4).YIf, ((pi)localObject4).YSM))
              {
                ((ah.a)localObject1).aiwY = true;
                localObject5 = new StringBuilder("checkOftenRead data change userName=").append(((pi)localObject4).YIf).append(" isLive=");
                localObject6 = (CharSequence)((pi)localObject4).YSM;
                if ((localObject6 != null) && (!n.bp((CharSequence)localObject6))) {
                  break label497;
                }
                i = 1;
                if (i != 0) {
                  break label502;
                }
              }
              label497:
              label502:
              for (boolean bool = true;; bool = false)
              {
                Log.i("MicroMsg.BizFinderLiveUILogic", bool);
                localObject5 = (Map)localObject2;
                localObject6 = ((pi)localObject4).YIf;
                s.s(localObject6, "info.bizusername");
                ((Map)localObject5).put(localObject6, ((pi)localObject4).YSM);
                localObject5 = c.XPt;
                c.aJ(((pi)localObject4).YIf, ((pi)localObject4).YSM, 1);
                localObject5 = c.XPt;
                c.a((pi)localObject4);
                break;
                i = 0;
                break label408;
              }
            }
          }
        }
        if (((ah.a)localObject1).aiwY) {
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(paramWeakReference) {});
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(303441);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(LinkedList<String> paramLinkedList, WeakReference<b> paramWeakReference, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(303438);
      paramObject = (kotlin.d.d)new b(this.vBA, paramStoryListView, paramd);
      AppMethodBeat.o(303438);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(303433);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(303433);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.vBp;
        a.dbO().addAll((Collection)this.vBA);
        paramObject = c.XPt;
        paramObject = this.vBA;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = c.a(3, paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(303433);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = (pn)paramObject;
      paramObject = a.vBp;
      a.dbO().removeAll((Collection)this.vBA);
      paramObject = new ah.a();
      if (localObject1 != null)
      {
        localObject1 = ((pn)localObject1).YSX;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (pi)((Iterator)localObject1).next();
            c localc = c.XPt;
            if (c.pb(((pi)localObject2).YIf, ((pi)localObject2).YSM))
            {
              paramObject.aiwY = true;
              localc = c.XPt;
              c.aJ(((pi)localObject2).YIf, ((pi)localObject2).YSM, 3);
              Log.i("MicroMsg.BizFinderLiveUILogic", s.X("checkPosition data change bizUserName=", ((pi)localObject2).YIf));
            }
            localc = c.XPt;
            c.a((pi)localObject2);
          }
        }
      }
      Log.d("MicroMsg.BizFinderLiveUILogic", s.X("checkPosition isChange=", Boolean.valueOf(paramObject.aiwY)));
      if (paramObject.aiwY) {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new u(paramStoryListView) {});
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(303433);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.model.a
 * JD-Core Version:    0.7.0.1
 */