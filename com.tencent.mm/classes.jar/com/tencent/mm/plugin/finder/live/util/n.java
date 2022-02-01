package com.tencent.mm.plugin.finder.live.util;

import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.a.j;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "()V", "TAG", "", "clientMsgIdSet", "", "incrementMsgId", "Ljava/util/concurrent/atomic/AtomicLong;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "lock", "", "observerSet", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "addAll", "", "collection", "", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "notifyGiftAdding", "giftType", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "remove", "size", "", "unregisterObserver", "Companion", "plugin-finder_release"})
public final class n
  implements p
{
  private static final int MAX_SIZE;
  private static final int yQy;
  public static final a yQz;
  private final String TAG;
  private LinkedList<p.b> jmy;
  private final Object lock;
  private final Set<p.a> yQv;
  private AtomicLong yQw;
  private final Set<String> yQx;
  
  static
  {
    AppMethodBeat.i(228616);
    yQz = new a((byte)0);
    a locala = a.Zlt;
    MAX_SIZE = ((Number)a.ilS().aSr()).intValue();
    locala = a.Zlt;
    yQy = ((Number)a.ilT().aSr()).intValue();
    AppMethodBeat.o(228616);
  }
  
  public n()
  {
    AppMethodBeat.i(228611);
    this.yQw = new AtomicLong(1L);
    this.TAG = ("Finder.GiftQueueImpl@" + hashCode());
    this.jmy = new LinkedList();
    this.lock = new byte[0];
    this.yQv = ((Set)new CopyOnWriteArraySet());
    this.yQx = ((Set)new CopyOnWriteArraySet());
    Log.i(this.TAG, "MAX_SIZE:" + MAX_SIZE + ",COMBOID_LIVE_TIME:" + yQy);
    AppMethodBeat.o(228611);
  }
  
  private p.b aCO(String paramString)
  {
    AppMethodBeat.i(228546);
    kotlin.g.b.p.k(paramString, "comboId");
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.jmy).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (paramString.equals(((p.b)localObject1).yru))
        {
          paramString = localObject1;
          paramString = (p.b)paramString;
          AppMethodBeat.o(228546);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  private final void b(p.c paramc)
  {
    AppMethodBeat.i(228606);
    Iterator localIterator = ((Iterable)this.yQv).iterator();
    while (localIterator.hasNext()) {
      ((p.a)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(228606);
  }
  
  public final void a(p.a parama)
  {
    AppMethodBeat.i(228599);
    kotlin.g.b.p.k(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("registerObserver ").append(parama).append("  ").append(this.yQv.size()).append(' ');
    aj localaj = aj.AGc;
    Log.i(str, aj.eek());
    this.yQv.add(parama);
    AppMethodBeat.o(228599);
  }
  
  public final p.b aCM(String paramString)
  {
    AppMethodBeat.i(228539);
    kotlin.g.b.p.k(paramString, "targetUserName");
    for (;;)
    {
      Object localObject1;
      int i;
      synchronized (this.lock)
      {
        Iterator localIterator = ((Iterable)this.jmy).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          p.b localb = (p.b)localObject1;
          if ((!localb.yQE) && (paramString.equals(localb.yrD)))
          {
            i = 1;
            break label119;
            paramString = (p.b)paramString;
            AppMethodBeat.o(228539);
            return paramString;
          }
          else
          {
            i = 0;
          }
        }
        else
        {
          paramString = null;
        }
      }
      label119:
      if (i != 0) {
        paramString = localObject1;
      }
    }
  }
  
  public final p.b aCN(String paramString)
  {
    AppMethodBeat.i(228545);
    kotlin.g.b.p.k(paramString, "targetUserName");
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.jmy).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (paramString.equals(((p.b)localObject1).yrD))
        {
          paramString = localObject1;
          paramString = (p.b)paramString;
          AppMethodBeat.o(228545);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final p.b aCP(String paramString)
  {
    AppMethodBeat.i(228550);
    kotlin.g.b.p.k(paramString, "comboId");
    synchronized (this.lock)
    {
      paramString = aCO(paramString);
      if (paramString != null) {
        this.jmy.remove(paramString);
      }
      AppMethodBeat.o(228550);
      return paramString;
    }
  }
  
  public final boolean addAll(Collection<p.b> paramCollection)
  {
    AppMethodBeat.i(228580);
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(228580);
      return false;
    }
    ??? = paramCollection.iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (p.b)((Iterator)???).next();
      if (!Util.isNullOrNil(((p.b)localObject2).yQF.SJs)) {
        if (this.yQx.contains(((p.b)localObject2).yQF.SJs))
        {
          Log.i(this.TAG, "addAll: duplicate client_msg_id:" + ((p.b)localObject2).yQF.SJs);
          ((Iterator)???).remove();
        }
        else
        {
          localObject2 = ((p.b)localObject2).yQF.SJs;
          if (localObject2 != null) {
            this.yQx.add(localObject2);
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i(this.TAG, "addAll: incrementMsgId = " + this.yQw + ", list size = " + this.jmy.size() + ", collection size = " + paramCollection.size() + ", observerSetSize:" + this.yQv.size());
        if (paramCollection.size() > MAX_SIZE)
        {
          Log.i(this.TAG, "addAll: oversize, drop origin collection:" + j.O(j.p((Iterable)paramCollection), paramCollection.size() - MAX_SIZE));
          paramCollection = j.c((Iterable)paramCollection, MAX_SIZE);
          if (this.jmy.size() + paramCollection.size() > MAX_SIZE)
          {
            Log.i(this.TAG, "offer: oversize, drop list:" + j.O((List)this.jmy, this.jmy.size() + paramCollection.size() - MAX_SIZE));
            this.jmy = new LinkedList((Collection)j.N((List)this.jmy, this.jmy.size() + paramCollection.size() - MAX_SIZE));
          }
          localObject2 = ((Iterable)paramCollection).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ((p.b)((Iterator)localObject2).next()).yQB = this.yQw.getAndIncrement();
        }
      }
      paramCollection = j.p((Iterable)paramCollection);
    }
    this.jmy.addAll((Collection)paramCollection);
    j.lm((List)this.jmy);
    paramCollection = x.aazN;
    paramCollection = dEu();
    if (paramCollection != null) {
      b(paramCollection);
    }
    AppMethodBeat.o(228580);
    return true;
  }
  
  public final void b(p.a parama)
  {
    AppMethodBeat.i(228604);
    kotlin.g.b.p.k(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregisterObserver ").append(parama).append("  ").append(this.yQv.size()).append(' ');
    aj localaj = aj.AGc;
    Log.i(str, aj.eek());
    this.yQv.remove(parama);
    AppMethodBeat.o(228604);
  }
  
  public final boolean b(p.b paramb)
  {
    AppMethodBeat.i(228561);
    if (paramb == null)
    {
      AppMethodBeat.o(228561);
      return false;
    }
    if (!Util.isNullOrNil(paramb.yQF.SJs))
    {
      if (this.yQx.contains(paramb.yQF.SJs))
      {
        Log.i(this.TAG, "offer: duplicate client_msg_id:" + paramb.yQF.SJs);
        AppMethodBeat.o(228561);
        return false;
      }
      ??? = paramb.yQF.SJs;
      if (??? != null) {
        this.yQx.add(???);
      }
    }
    synchronized (this.lock)
    {
      Log.i(this.TAG, "offer: incrementMsgId = " + this.yQw + ", size = " + this.jmy.size());
      if ((this.jmy.size() >= MAX_SIZE) && (MAX_SIZE > 0))
      {
        Log.i(this.TAG, "offer: oversize, drop:" + j.O((List)this.jmy, this.jmy.size() - MAX_SIZE + 1));
        this.jmy = new LinkedList((Collection)j.c((Iterable)this.jmy, MAX_SIZE - 1));
      }
      paramb.yQB = this.yQw.getAndIncrement();
      this.jmy.offerLast(paramb);
      j.lm((List)this.jmy);
      paramb = x.aazN;
      paramb = dEu();
      if (paramb != null) {
        b(paramb);
      }
      AppMethodBeat.o(228561);
      return true;
    }
  }
  
  public final boolean c(p.b paramb)
  {
    AppMethodBeat.i(228582);
    kotlin.g.b.p.k(paramb, "giftShowInfo");
    synchronized (this.lock)
    {
      boolean bool = this.jmy.remove(paramb);
      AppMethodBeat.o(228582);
      return bool;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(228588);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("clear observer ");
    ??? = aj.AGc;
    if (aj.eej()) {
      ??? = Util.getStack().toString();
    }
    for (;;)
    {
      Log.i((String)localObject2, (String)???);
      synchronized (this.lock)
      {
        this.jmy.clear();
        localObject2 = x.aazN;
        this.yQv.clear();
        AppMethodBeat.o(228588);
        return;
        ??? = "";
      }
    }
  }
  
  public final p.c dEu()
  {
    AppMethodBeat.i(228533);
    synchronized (this.lock)
    {
      Object localObject1 = (p.b)this.jmy.peekFirst();
      if (localObject1 != null)
      {
        localObject1 = ((p.b)localObject1).yQA;
        AppMethodBeat.o(228533);
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public final p.b dEv()
  {
    AppMethodBeat.i(228536);
    synchronized (this.lock)
    {
      p.b localb = (p.b)this.jmy.pollFirst();
      AppMethodBeat.o(228536);
      return localb;
    }
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(228532);
    synchronized (this.lock)
    {
      boolean bool = ((Collection)this.jmy).isEmpty();
      if (!bool)
      {
        bool = true;
        AppMethodBeat.o(228532);
        return bool;
      }
      bool = false;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(228590);
    synchronized (this.lock)
    {
      int i = this.jmy.size();
      AppMethodBeat.o(228590);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl$Companion;", "", "()V", "COMBOID_LIVE_TIME", "", "getCOMBOID_LIVE_TIME", "()I", "MAX_SIZE", "getMAX_SIZE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.n
 * JD-Core Version:    0.7.0.1
 */