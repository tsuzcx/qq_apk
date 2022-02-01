package com.tencent.mm.accessibility.uitl;

import android.view.View;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.pending.IPendingEvent;
import com.tencent.mm.sdk.event.pending.PendingEventHandler;
import com.tencent.mm.sdk.event.pending.UIPendingEventNotifier;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/uitl/TimeBlocker;", "", "()V", "INTERVAL_TIME", "", "TAG", "", "handle", "com/tencent/mm/accessibility/uitl/TimeBlocker$handle$1", "Lcom/tencent/mm/accessibility/uitl/TimeBlocker$handle$1;", "lastTimeCache", "", "", "ownerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/sdk/event/pending/UIPendingEventNotifier;", "Lcom/tencent/mm/accessibility/uitl/TimeBlocker$CallbackEvent;", "addObserver", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "isSinceLastTrue", "", "key", "time", "pendingExcu", "view", "Landroid/view/View;", "type", "callback", "Lkotlin/Function0;", "CallbackEvent", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimeBlocker
{
  public static final TimeBlocker INSTANCE;
  private static final long INTERVAL_TIME = 1000L;
  private static final String TAG = "MicroMsg.Acc.TimeBlocker";
  private static final handle.1 handle;
  private static final Map<Integer, Long> lastTimeCache;
  private static final ConcurrentHashMap<Integer, UIPendingEventNotifier<CallbackEvent>> ownerMap;
  
  static
  {
    AppMethodBeat.i(234140);
    INSTANCE = new TimeBlocker();
    lastTimeCache = (Map)new LinkedHashMap();
    handle = new PendingEventHandler()
    {
      public final void handleEvent(List<TimeBlocker.CallbackEvent> paramAnonymousList)
      {
        AppMethodBeat.i(234121);
        s.u(paramAnonymousList, "eventList");
        paramAnonymousList = ((Iterable)paramAnonymousList).iterator();
        while (paramAnonymousList.hasNext()) {
          ((TimeBlocker.CallbackEvent)paramAnonymousList.next()).getCallback().invoke();
        }
        AppMethodBeat.o(234121);
      }
    };
    ownerMap = new ConcurrentHashMap();
    AppMethodBeat.o(234140);
  }
  
  private final void addObserver(q paramq)
  {
    AppMethodBeat.i(234125);
    Log.i("MicroMsg.Acc.TimeBlocker", s.X("wait synchronized ", paramq));
    try
    {
      boolean bool = ownerMap.containsKey(Integer.valueOf(paramq.hashCode()));
      if (bool) {
        return;
      }
      Log.i("MicroMsg.Acc.TimeBlocker", s.X("addObserver init ", paramq));
      p local1 = new p()
      {
        @z(Ho=j.a.ON_DESTROY)
        public final void onDestroy()
        {
          AppMethodBeat.i(234138);
          TimeBlocker.access$getOwnerMap$p().remove(Integer.valueOf(this.$owner.hashCode()));
          Log.i("MicroMsg.Acc.TimeBlocker", s.X("removeObserver onDestroy: ", this.$owner));
          AppMethodBeat.o(234138);
        }
      };
      h.ahAA.bl(new TimeBlocker..ExternalSyntheticLambda0(paramq, local1));
      return;
    }
    finally
    {
      AppMethodBeat.o(234125);
    }
  }
  
  private static final void addObserver$lambda-4$lambda-3(q paramq, addObserver.1.observer.1 param1)
  {
    AppMethodBeat.i(234131);
    s.u(paramq, "$owner");
    s.u(param1, "$observer");
    Log.i("MicroMsg.Acc.TimeBlocker", "addObserver in uiAtFront:" + paramq + ' ' + paramq.getLifecycle().getCurrentState().name());
    j localj = paramq.getLifecycle();
    if (localj.getCurrentState() != j.b.bHg)
    {
      localj.addObserver((p)param1);
      AppMethodBeat.o(234131);
      return;
    }
    Log.i("MicroMsg.Acc.TimeBlocker", s.X("addObserver in uiAtFront but destroy ", paramq));
    ownerMap.remove(Integer.valueOf(paramq.hashCode()));
    AppMethodBeat.o(234131);
  }
  
  public final boolean isSinceLastTrue(int paramInt, long paramLong)
  {
    AppMethodBeat.i(234156);
    long l1 = System.currentTimeMillis();
    Map localMap = lastTimeCache;
    Integer localInteger = Integer.valueOf(paramInt);
    Object localObject2 = localMap.get(localInteger);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Long.valueOf(0L);
      localMap.put(localInteger, localObject1);
    }
    long l2 = ((Number)localObject1).longValue();
    if ((l1 - l2 > paramLong) || (l1 - l2 < 0L))
    {
      lastTimeCache.put(Integer.valueOf(paramInt), Long.valueOf(l1));
      AppMethodBeat.o(234156);
      return true;
    }
    AppMethodBeat.o(234156);
    return false;
  }
  
  public final void pendingExcu(View paramView, String paramString, a<ah> parama)
  {
    AppMethodBeat.i(234166);
    s.u(paramView, "view");
    s.u(paramString, "type");
    s.u(parama, "callback");
    Object localObject1 = paramView.getContext();
    if ((localObject1 instanceof q)) {}
    for (localObject1 = (q)localObject1; localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(234166);
      return;
    }
    if (!ownerMap.containsKey(Integer.valueOf(localObject1.hashCode()))) {
      addObserver((q)localObject1);
    }
    if (((q)localObject1).getLifecycle().getCurrentState() == j.b.bHg)
    {
      Log.i("MicroMsg.Acc.TimeBlocker", "skip getOrPut because of " + localObject1 + " DESTROYED");
      AppMethodBeat.o(234166);
      return;
    }
    Object localObject3 = (ConcurrentMap)ownerMap;
    Integer localInteger = Integer.valueOf(localObject1.hashCode());
    Object localObject2 = ((ConcurrentMap)localObject3).get(localInteger);
    if (localObject2 == null)
    {
      Log.i("MicroMsg.Acc.TimeBlocker", "put " + localObject1 + " into ownerMap, current status is " + ((q)localObject1).getLifecycle().getCurrentState().name());
      localObject2 = new UIPendingEventNotifier(1000L, (PendingEventHandler)handle, (q)localObject1);
      localObject3 = ((ConcurrentMap)localObject3).putIfAbsent(localInteger, localObject2);
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = localObject2)
    {
      s.s(localObject1, "ownerMap.getOrPut(owner.…handle, owner)\n        })");
      UIPendingEventNotifier.doNotify$default((UIPendingEventNotifier)localObject1, (IPendingEvent)new CallbackEvent(paramView.hashCode() + paramString, parama), false, 2, null);
      AppMethodBeat.o(234166);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/uitl/TimeBlocker$CallbackEvent;", "Lcom/tencent/mm/sdk/event/pending/IPendingEvent;", "_key", "", "callback", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "get_key", "()Ljava/lang/String;", "getCallback", "()Lkotlin/jvm/functions/Function0;", "getKey", "mergeEvent", "newEvent", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class CallbackEvent
    implements IPendingEvent
  {
    private final String _key;
    private final a<ah> callback;
    
    public CallbackEvent(String paramString, a<ah> parama)
    {
      AppMethodBeat.i(234115);
      this._key = paramString;
      this.callback = parama;
      AppMethodBeat.o(234115);
    }
    
    public final a<ah> getCallback()
    {
      return this.callback;
    }
    
    public final String getKey()
    {
      return this._key;
    }
    
    public final String get_key()
    {
      return this._key;
    }
    
    public final IPendingEvent mergeEvent(IPendingEvent paramIPendingEvent)
    {
      AppMethodBeat.i(234132);
      s.u(paramIPendingEvent, "newEvent");
      AppMethodBeat.o(234132);
      return paramIPendingEvent;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.uitl.TimeBlocker
 * JD-Core Version:    0.7.0.1
 */