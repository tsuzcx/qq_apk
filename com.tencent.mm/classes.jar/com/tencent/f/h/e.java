package com.tencent.f.h;

import android.os.Handler;
import com.tencent.f.d.a;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class e
{
  public final c RUA;
  public final f RUB;
  public final b RUz;
  
  public e(com.tencent.f.a parama)
  {
    AppMethodBeat.i(183363);
    this.RUz = new b(parama.RSr, parama.RSq);
    this.RUA = new c(parama.RSs);
    this.RUB = new f();
    AppMethodBeat.o(183363);
  }
  
  public static <V> com.tencent.f.i.d<V> a(k<V> paramk, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(183365);
    paramk.a(paramd);
    long l;
    if ((paramk instanceof com.tencent.f.j.e))
    {
      paramd = (com.tencent.f.j.e)paramk;
      com.tencent.f.j.d locald = paramd.serial.RUS;
      if (paramBoolean)
      {
        l = -2147483648L;
        locald.a(l, paramd);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(183365);
      return paramk;
      l = paramk.getDelay(TimeUnit.MILLISECONDS);
      break;
      paramk.RUL.g(paramk);
    }
  }
  
  private d k(k<?> paramk)
  {
    AppMethodBeat.i(183367);
    if (com.tencent.f.c.b.RTE != null)
    {
      if (com.tencent.f.c.b.RTE.ez(paramk.getKey()))
      {
        paramk = this.RUz;
        AppMethodBeat.o(183367);
        return paramk;
      }
      paramk = this.RUA;
      AppMethodBeat.o(183367);
      return paramk;
    }
    if (this.RUA.isBusy())
    {
      paramk = this.RUz;
      AppMethodBeat.o(183367);
      return paramk;
    }
    paramk = this.RUA;
    AppMethodBeat.o(183367);
    return paramk;
  }
  
  public final <V> com.tencent.f.i.d<V> a(k<V> paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(183364);
    paramk = a(paramk, paramBoolean, k(paramk));
    AppMethodBeat.o(183364);
    return paramk;
  }
  
  public final Map<String, List<String>> hme()
  {
    AppMethodBeat.i(183366);
    localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = this.RUB.RUC;
      Object localObject2 = new LinkedList();
      ((f.a)localObject1).aDv.dump(new f.a.2((f.a)localObject1, (List)localObject2), "");
      localLinkedHashMap.put("UIPool", localObject2);
      localLinkedHashMap.put("HotPool", this.RUA.hmx());
      localLinkedHashMap.put("ColdPool", this.RUz.hmx());
      localObject1 = com.tencent.f.j.a.hmH().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.f.j.a)((Iterator)localObject1).next();
        List localList = ((com.tencent.f.j.a)localObject2).RUS.hmI();
        if (localList.size() > 0) {
          localLinkedHashMap.put(((com.tencent.f.j.a)localObject2).tag, localList);
        }
      }
      return localLinkedHashMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.f.d.RSS.e("PoolAdapter", "[dumpWaitingTask] e=%s", new Object[] { localNullPointerException });
      AppMethodBeat.o(183366);
    }
  }
  
  public final <V> com.tencent.f.i.d<V> j(k<V> paramk)
  {
    AppMethodBeat.i(256675);
    paramk = a(paramk, false, this.RUA);
    AppMethodBeat.o(256675);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.h.e
 * JD-Core Version:    0.7.0.1
 */