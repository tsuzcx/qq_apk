package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.utils.y;
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
import kotlin.m.h;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "()V", "TAG", "", "incrementMsgId", "Ljava/util/concurrent/atomic/AtomicLong;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "lock", "", "observerSet", "", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "addAll", "", "collection", "", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "notifyGiftAdding", "giftType", "offer", "giftShowInfo", "peek", "peekNonPrecious", "poll", "pollNonPrecious", "registerObserver", "observer", "remove", "size", "", "unregisterObserver", "Companion", "plugin-finder_release"})
public final class n
  implements p
{
  private static final int MAX_SIZE;
  private static final int uwQ;
  public static final a uwR;
  private final String TAG;
  private LinkedList<p.b> gCs;
  private final Object lock;
  private final Set<p.a> uwO;
  private AtomicLong uwP;
  
  static
  {
    AppMethodBeat.i(247280);
    uwR = new a((byte)0);
    c localc = c.vCb;
    MAX_SIZE = ((Number)c.dwa().value()).intValue();
    localc = c.vCb;
    uwQ = ((Number)c.dwb().value()).intValue();
    AppMethodBeat.o(247280);
  }
  
  public n()
  {
    AppMethodBeat.i(247279);
    this.uwP = new AtomicLong(1L);
    this.TAG = ("Finder.GiftQueueImpl@" + hashCode());
    this.gCs = new LinkedList();
    this.lock = new byte[0];
    this.uwO = ((Set)new CopyOnWriteArraySet());
    Log.i(this.TAG, "MAX_SIZE:" + MAX_SIZE + ",COMBOID_LIVE_TIME:" + uwQ);
    AppMethodBeat.o(247279);
  }
  
  private final void b(p.c paramc)
  {
    AppMethodBeat.i(247278);
    Iterator localIterator = ((Iterable)this.uwO).iterator();
    while (localIterator.hasNext()) {
      ((p.a)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(247278);
  }
  
  public final void a(p.a parama)
  {
    AppMethodBeat.i(247276);
    kotlin.g.b.p.h(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("registerObserver ").append(parama).append("  ").append(this.uwO.size()).append(' ');
    y localy = y.vXH;
    Log.i(str, y.dCN());
    this.uwO.add(parama);
    AppMethodBeat.o(247276);
  }
  
  public final boolean a(p.b paramb)
  {
    AppMethodBeat.i(247271);
    if (paramb == null)
    {
      AppMethodBeat.o(247271);
      return false;
    }
    synchronized (this.lock)
    {
      Log.i(this.TAG, "offer: incrementMsgId = " + this.uwP + ", size = " + this.gCs.size());
      if ((this.gCs.size() >= MAX_SIZE) && (MAX_SIZE > 0))
      {
        Log.i(this.TAG, "offer: oversize, drop:" + j.N((List)this.gCs, this.gCs.size() - MAX_SIZE + 1));
        this.gCs = new LinkedList((Collection)j.b((Iterable)this.gCs, MAX_SIZE - 1));
      }
      paramb.uwT = this.uwP.getAndIncrement();
      this.gCs.offerLast(paramb);
      j.sort((List)this.gCs);
      paramb = x.SXb;
      paramb = dii();
      if (paramb != null) {
        b(paramb);
      }
      AppMethodBeat.o(247271);
      return true;
    }
  }
  
  public final boolean addAll(Collection<p.b> paramCollection)
  {
    AppMethodBeat.i(247272);
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(247272);
      return false;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i(this.TAG, "addAll: incrementMsgId = " + this.uwP + ", size = " + this.gCs.size() + ", observerSetSize:" + this.uwO.size());
        if (paramCollection.size() > MAX_SIZE)
        {
          Log.i(this.TAG, "addAll: oversize, drop origin collection:" + j.N(j.p((Iterable)paramCollection), paramCollection.size() - MAX_SIZE));
          paramCollection = j.b((Iterable)paramCollection, MAX_SIZE);
          if (this.gCs.size() + paramCollection.size() > MAX_SIZE)
          {
            Log.i(this.TAG, "offer: oversize, drop list:" + j.N((List)this.gCs, this.gCs.size() + paramCollection.size() - MAX_SIZE));
            this.gCs = new LinkedList((Collection)j.M((List)this.gCs, this.gCs.size() + paramCollection.size() - MAX_SIZE));
          }
          Iterator localIterator = ((Iterable)paramCollection).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((p.b)localIterator.next()).uwT = this.uwP.getAndIncrement();
        }
      }
      paramCollection = j.p((Iterable)paramCollection);
    }
    this.gCs.addAll((Collection)paramCollection);
    j.sort((List)this.gCs);
    paramCollection = x.SXb;
    paramCollection = dii();
    if (paramCollection != null) {
      b(paramCollection);
    }
    AppMethodBeat.o(247272);
    return true;
  }
  
  public final void b(p.a parama)
  {
    AppMethodBeat.i(247277);
    kotlin.g.b.p.h(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregisterObserver ").append(parama).append("  ").append(this.uwO.size()).append(' ');
    y localy = y.vXH;
    Log.i(str, y.dCN());
    this.uwO.remove(parama);
    AppMethodBeat.o(247277);
  }
  
  public final boolean b(p.b paramb)
  {
    AppMethodBeat.i(247273);
    kotlin.g.b.p.h(paramb, "giftShowInfo");
    synchronized (this.lock)
    {
      boolean bool = this.gCs.remove(paramb);
      AppMethodBeat.o(247273);
      return bool;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(247274);
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("clear observer ");
    ??? = y.vXH;
    if (y.dCM()) {
      ??? = Util.getStack().toString();
    }
    for (;;)
    {
      Log.i((String)localObject2, (String)???);
      synchronized (this.lock)
      {
        this.gCs.clear();
        localObject2 = x.SXb;
        this.uwO.clear();
        AppMethodBeat.o(247274);
        return;
        ??? = "";
      }
    }
  }
  
  public final p.c dii()
  {
    AppMethodBeat.i(247267);
    synchronized (this.lock)
    {
      Object localObject1 = (p.b)this.gCs.peekFirst();
      if (localObject1 != null)
      {
        localObject1 = ((p.b)localObject1).uwS;
        AppMethodBeat.o(247267);
        return localObject1;
      }
      localObject1 = null;
    }
  }
  
  public final p.b dij()
  {
    AppMethodBeat.i(247268);
    synchronized (this.lock)
    {
      p.b localb = (p.b)this.gCs.peekFirst();
      AppMethodBeat.o(247268);
      return localb;
    }
  }
  
  public final p.b dik()
  {
    AppMethodBeat.i(247269);
    synchronized (this.lock)
    {
      p.b localb = (p.b)this.gCs.pollFirst();
      AppMethodBeat.o(247269);
      return localb;
    }
  }
  
  public final p.b dil()
  {
    AppMethodBeat.i(247270);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        Iterator localIterator = j.z((Iterable)this.gCs).iterator();
        Object localObject1;
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          if (!((p.b)localObject1).uwW)
          {
            i = 1;
            break label99;
            localObject1 = (p.b)localObject1;
            AppMethodBeat.o(247270);
            return localObject1;
          }
          else
          {
            i = 0;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
      label99:
      if (i == 0) {}
    }
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(247266);
    synchronized (this.lock)
    {
      boolean bool = ((Collection)this.gCs).isEmpty();
      if (!bool)
      {
        bool = true;
        AppMethodBeat.o(247266);
        return bool;
      }
      bool = false;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(247275);
    synchronized (this.lock)
    {
      int i = this.gCs.size();
      AppMethodBeat.o(247275);
      return i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl$Companion;", "", "()V", "COMBOID_LIVE_TIME", "", "getCOMBOID_LIVE_TIME", "()I", "MAX_SIZE", "getMAX_SIZE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.n
 * JD-Core Version:    0.7.0.1
 */