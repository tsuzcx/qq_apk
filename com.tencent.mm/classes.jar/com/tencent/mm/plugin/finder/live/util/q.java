package com.tencent.mm.plugin.finder.live.util;

import com.tencent.d.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bdm;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue;", "()V", "TAG", "", "clientMsgIdSet", "", "incrementMsgId", "Ljava/util/concurrent/atomic/AtomicLong;", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftShowInfo;", "lock", "", "observerSet", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftAddingObserver;", "addAll", "", "collection", "", "clear", "", "getNextGiftType", "Lcom/tencent/mm/plugin/finder/live/util/IGiftQueue$GiftType;", "hasNext", "notifyGiftAdding", "giftType", "offer", "giftShowInfo", "peek", "peekByComboId", "comboId", "peekByTargetUserName", "targetUserName", "peekNonPrecious", "poll", "pollByComboId", "pollByTargetUserName", "pollNonPrecious", "registerObserver", "observer", "remove", "resetMsgIdList", "size", "", "unregisterObserver", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements s
{
  public static final a DJf;
  private static final int DJj;
  private static final int MAX_SIZE;
  private final Set<s.a> DJg;
  private AtomicLong DJh;
  private final Set<String> DJi;
  private final String TAG;
  private LinkedList<s.b> lPK;
  private final Object lock;
  
  static
  {
    AppMethodBeat.i(351292);
    DJf = new a((byte)0);
    a locala = a.ahiX;
    MAX_SIZE = ((Number)a.jSv().bmg()).intValue();
    locala = a.ahiX;
    DJj = ((Number)a.jSw().bmg()).intValue();
    AppMethodBeat.o(351292);
  }
  
  public q()
  {
    AppMethodBeat.i(351271);
    this.DJh = new AtomicLong(1L);
    this.TAG = kotlin.g.b.s.X("Finder.GiftQueueImpl@", Integer.valueOf(hashCode()));
    this.lPK = new LinkedList();
    this.lock = new byte[0];
    this.DJg = ((Set)new CopyOnWriteArraySet());
    this.DJi = ((Set)new CopyOnWriteArraySet());
    Log.i(this.TAG, "MAX_SIZE:" + MAX_SIZE + ",COMBOID_LIVE_TIME:" + DJj);
    AppMethodBeat.o(351271);
  }
  
  private s.b axP(String paramString)
  {
    AppMethodBeat.i(351275);
    kotlin.g.b.s.u(paramString, "comboId");
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (paramString.equals(((s.b)localObject1).Dbx))
        {
          paramString = localObject1;
          paramString = (s.b)paramString;
          AppMethodBeat.o(351275);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  private final void b(s.c paramc)
  {
    AppMethodBeat.i(351281);
    Iterator localIterator = ((Iterable)this.DJg).iterator();
    while (localIterator.hasNext()) {
      ((s.a)localIterator.next()).a(paramc);
    }
    AppMethodBeat.o(351281);
  }
  
  public final void a(s.a parama)
  {
    AppMethodBeat.i(351420);
    kotlin.g.b.s.u(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("registerObserver ").append(parama).append("  ").append(this.DJg.size()).append(' ');
    aw localaw = aw.Gjk;
    Log.i(str, aw.fgr());
    this.DJg.add(parama);
    AppMethodBeat.o(351420);
  }
  
  public final boolean addAll(Collection<s.b> paramCollection)
  {
    AppMethodBeat.i(351378);
    if ((paramCollection == null) || (paramCollection.isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(351378);
      return false;
    }
    ??? = paramCollection.iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (s.b)((Iterator)???).next();
      if (!Util.isNullOrNil(((s.b)localObject2).DJk.Tro)) {
        if (p.a((Iterable)this.DJi, ((s.b)localObject2).DJk.Tro))
        {
          Log.i(this.TAG, kotlin.g.b.s.X("addAll: duplicate client_msg_id:", ((s.b)localObject2).DJk.Tro));
          ((Iterator)???).remove();
        }
        else
        {
          localObject2 = ((s.b)localObject2).DJk.Tro;
          if (localObject2 != null) {
            this.DJi.add(localObject2);
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        Log.i(this.TAG, "addAll: incrementMsgId = " + this.DJh + ", list size = " + this.lPK.size() + ", collection size = " + paramCollection.size() + ", observerSetSize:" + this.DJg.size());
        if (paramCollection.size() > MAX_SIZE)
        {
          Log.i(this.TAG, kotlin.g.b.s.X("addAll: oversize, drop origin collection:", p.ag(p.p((Iterable)paramCollection), paramCollection.size() - MAX_SIZE)));
          paramCollection = p.c((Iterable)paramCollection, MAX_SIZE);
          if (this.lPK.size() + paramCollection.size() > MAX_SIZE)
          {
            Log.i(this.TAG, kotlin.g.b.s.X("offer: oversize, drop list:", p.ag((List)this.lPK, this.lPK.size() + paramCollection.size() - MAX_SIZE)));
            this.lPK = new LinkedList((Collection)p.af((List)this.lPK, this.lPK.size() + paramCollection.size() - MAX_SIZE));
          }
          localObject2 = ((Iterable)paramCollection).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ((s.b)((Iterator)localObject2).next()).DJm = this.DJh.getAndIncrement();
        }
      }
      paramCollection = p.p((Iterable)paramCollection);
    }
    this.lPK.addAll((Collection)paramCollection);
    p.N((List)this.lPK);
    paramCollection = ah.aiuX;
    paramCollection = euw();
    if (paramCollection != null) {
      b(paramCollection);
    }
    AppMethodBeat.o(351378);
    return true;
  }
  
  public final s.b axN(String paramString)
  {
    AppMethodBeat.i(351333);
    kotlin.g.b.s.u(paramString, "targetUserName");
    for (;;)
    {
      Object localObject1;
      int i;
      synchronized (this.lock)
      {
        Iterator localIterator = ((Iterable)this.lPK).iterator();
        if (localIterator.hasNext())
        {
          localObject1 = localIterator.next();
          s.b localb = (s.b)localObject1;
          if ((!localb.DJp) && (paramString.equals(localb.DbG)))
          {
            i = 1;
            break label123;
            paramString = (s.b)paramString;
            AppMethodBeat.o(351333);
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
      label123:
      if (i != 0) {
        paramString = localObject1;
      }
    }
  }
  
  public final s.b axO(String paramString)
  {
    AppMethodBeat.i(351338);
    kotlin.g.b.s.u(paramString, "targetUserName");
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.lPK).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (paramString.equals(((s.b)localObject1).DbG))
        {
          paramString = localObject1;
          paramString = (s.b)paramString;
          AppMethodBeat.o(351338);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public final s.b axQ(String paramString)
  {
    AppMethodBeat.i(351346);
    kotlin.g.b.s.u(paramString, "comboId");
    synchronized (this.lock)
    {
      paramString = axP(paramString);
      if (paramString != null) {
        this.lPK.remove(paramString);
      }
      AppMethodBeat.o(351346);
      return paramString;
    }
  }
  
  public final void b(s.a parama)
  {
    AppMethodBeat.i(351430);
    kotlin.g.b.s.u(parama, "observer");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("unregisterObserver ").append(parama).append("  ").append(this.DJg.size()).append(' ');
    aw localaw = aw.Gjk;
    Log.i(str, aw.fgr());
    this.DJg.remove(parama);
    AppMethodBeat.o(351430);
  }
  
  public final boolean b(s.b paramb)
  {
    AppMethodBeat.i(351359);
    if (paramb == null)
    {
      AppMethodBeat.o(351359);
      return false;
    }
    if (!Util.isNullOrNil(paramb.DJk.Tro))
    {
      if (p.a((Iterable)this.DJi, paramb.DJk.Tro))
      {
        Log.i(this.TAG, kotlin.g.b.s.X("offer: duplicate client_msg_id:", paramb.DJk.Tro));
        AppMethodBeat.o(351359);
        return false;
      }
      ??? = paramb.DJk.Tro;
      if (??? != null) {
        this.DJi.add(???);
      }
    }
    synchronized (this.lock)
    {
      Log.i(this.TAG, "offer: incrementMsgId = " + this.DJh + ", size = " + this.lPK.size());
      if ((this.lPK.size() >= MAX_SIZE) && (MAX_SIZE > 0))
      {
        Log.i(this.TAG, kotlin.g.b.s.X("offer: oversize, drop:", p.ag((List)this.lPK, this.lPK.size() - MAX_SIZE + 1)));
        this.lPK = new LinkedList((Collection)p.c((Iterable)this.lPK, MAX_SIZE - 1));
      }
      paramb.DJm = this.DJh.getAndIncrement();
      this.lPK.offerLast(paramb);
      p.N((List)this.lPK);
      paramb = ah.aiuX;
      paramb = euw();
      if (paramb != null) {
        b(paramb);
      }
      AppMethodBeat.o(351359);
      return true;
    }
  }
  
  public final boolean c(s.b paramb)
  {
    AppMethodBeat.i(351389);
    kotlin.g.b.s.u(paramb, "giftShowInfo");
    synchronized (this.lock)
    {
      boolean bool = this.lPK.remove(paramb);
      AppMethodBeat.o(351389);
      return bool;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(351399);
    Object localObject2 = this.TAG;
    ??? = aw.Gjk;
    if (aw.bgV()) {
      ??? = Util.getStack().toString();
    }
    for (;;)
    {
      Log.i((String)localObject2, kotlin.g.b.s.X("clear observer ", ???));
      synchronized (this.lock)
      {
        this.lPK.clear();
        localObject2 = ah.aiuX;
        this.DJg.clear();
        AppMethodBeat.o(351399);
        return;
        ??? = "";
      }
    }
  }
  
  public final s.c euw()
  {
    AppMethodBeat.i(351315);
    synchronized (this.lock)
    {
      Object localObject1 = (s.b)this.lPK.peekFirst();
      if (localObject1 == null)
      {
        localObject1 = null;
        AppMethodBeat.o(351315);
        return localObject1;
      }
      localObject1 = ((s.b)localObject1).DJl;
    }
  }
  
  public final s.b eux()
  {
    AppMethodBeat.i(351326);
    synchronized (this.lock)
    {
      s.b localb = (s.b)this.lPK.pollFirst();
      AppMethodBeat.o(351326);
      return localb;
    }
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(351304);
    synchronized (this.lock)
    {
      boolean bool = ((Collection)this.lPK).isEmpty();
      if (!bool)
      {
        bool = true;
        AppMethodBeat.o(351304);
        return bool;
      }
      bool = false;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(351408);
    synchronized (this.lock)
    {
      int i = this.lPK.size();
      AppMethodBeat.o(351408);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/util/GiftQueueImpl$Companion;", "", "()V", "COMBOID_LIVE_TIME", "", "getCOMBOID_LIVE_TIME", "()I", "MAX_SIZE", "getMAX_SIZE", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.util.q
 * JD-Core Version:    0.7.0.1
 */