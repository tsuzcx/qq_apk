package com.tencent.mm.plugin.finder.feed.model.internal;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer;", "T", "A", "", "policy", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;", "name", "", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Policy;Ljava/lang/String;)V", "buffer", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$PageData;", "empty", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "length", "", "getLength", "()I", "setLength", "(I)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "clear", "", "makeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "offer", "page", "take", "count", "expiredTimeMs", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "Callback", "Companion", "PageData", "Policy", "plugin-finder_release"})
public final class j<T, A>
{
  public static final j.b rou;
  public final ReentrantLock cEu;
  public int length;
  public final String name;
  public final Condition ror;
  public final LinkedList<j.c<T, A>> ros;
  private final j.d rot;
  
  static
  {
    AppMethodBeat.i(202277);
    rou = new j.b((byte)0);
    AppMethodBeat.o(202277);
  }
  
  public j()
  {
    this(null, null, 3);
  }
  
  private j(j.d paramd, String paramString)
  {
    AppMethodBeat.i(202275);
    this.rot = paramd;
    this.name = paramString;
    this.cEu = new ReentrantLock();
    this.ror = this.cEu.newCondition();
    this.ros = new LinkedList();
    AppMethodBeat.o(202275);
  }
  
  public final j.c<T, A> a(int paramInt, long paramLong, a parama)
  {
    AppMethodBeat.i(202273);
    k.h(parama, "callback");
    ac.i("PageDataBuffer", "[take#begin] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
    long l1 = SystemClock.uptimeMillis();
    LinkedList localLinkedList = new LinkedList();
    j.c localc = new j.c(localLinkedList);
    this.cEu.lock();
    for (;;)
    {
      try
      {
        if ((paramInt > this.length) && (this.rot == j.d.rox))
        {
          parama.csU();
          ac.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
          this.ror.await();
          parama = this.ros.iterator();
          k.g(parama, "buffer.iterator()");
          if ((!parama.hasNext()) || (localLinkedList.size() >= paramInt)) {
            break;
          }
          Object localObject = parama.next();
          k.g(localObject, "iterator.next()");
          localObject = (j.c)localObject;
          List localList = ((j.c)localObject).DK(paramInt - localLinkedList.size());
          localLinkedList.addAll((Collection)localList);
          this.length -= localList.size();
          if (((j.c)localObject).fBS.size() <= 0) {
            parama.remove();
          }
          localc.rov = ((j.c)localObject).rov;
          continue;
        }
        if (this.length > 0) {
          continue;
        }
      }
      finally
      {
        this.cEu.unlock();
        AppMethodBeat.o(202273);
      }
      parama.csU();
      ac.i("PageDataBuffer", "[take#request] name=" + this.name + " count=" + paramInt + " expiredTimeMs=" + paramLong);
      this.ror.await();
    }
    this.cEu.unlock();
    long l2 = paramLong - (SystemClock.uptimeMillis() - l1);
    if ((l2 > 0L) && (localLinkedList.size() > 0)) {
      SystemClock.sleep(l2);
    }
    ac.i("PageDataBuffer", "[take#end] name=" + this.name + ' ' + localc + " expiredTimeMs=" + paramLong + " length=" + this.length + " delay=" + l2 + " cost=" + (SystemClock.uptimeMillis() - l1) + "ms");
    AppMethodBeat.o(202273);
    return localc;
  }
  
  public final void a(j.c<T, A> paramc)
  {
    AppMethodBeat.i(202272);
    k.h(paramc, "page");
    this.cEu.lock();
    try
    {
      this.ros.addLast(paramc);
      this.length += paramc.fBS.size();
      this.ror.signal();
      this.cEu.unlock();
      ac.i("PageDataBuffer", "[offer] name=" + this.name + " page=" + paramc + " length=" + this.length);
      AppMethodBeat.o(202272);
      return;
    }
    finally
    {
      this.cEu.unlock();
      AppMethodBeat.o(202272);
    }
  }
  
  public final ArrayList<T> cvG()
  {
    AppMethodBeat.i(202274);
    this.cEu.lock();
    try
    {
      ArrayList localArrayList = new ArrayList(this.length);
      Iterator localIterator = ((Iterable)this.ros).iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll((Collection)((j.c)localIterator.next()).fBS);
      }
      this.cEu.unlock();
    }
    finally
    {
      this.cEu.unlock();
      AppMethodBeat.o(202274);
    }
    AppMethodBeat.o(202274);
    return localArrayList1;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/PageDataBuffer$Callback;", "", "request", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void csU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.j
 * JD-Core Version:    0.7.0.1
 */