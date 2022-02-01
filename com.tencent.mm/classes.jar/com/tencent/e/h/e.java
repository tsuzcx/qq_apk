package com.tencent.e.h;

import android.os.Handler;
import com.tencent.e.i.k;
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
  public final b IzC;
  public final c IzD;
  public final f IzE;
  
  public e(com.tencent.e.a parama)
  {
    AppMethodBeat.i(183363);
    this.IzC = new b(parama.Ixt, parama.Ixs);
    this.IzD = new c(parama.Ixu);
    this.IzE = new f();
    AppMethodBeat.o(183363);
  }
  
  public static <V> com.tencent.e.i.d<V> a(k<V> paramk, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(183365);
    paramk.a(paramd);
    long l;
    if ((paramk instanceof com.tencent.e.j.e))
    {
      paramd = (com.tencent.e.j.e)paramk;
      com.tencent.e.j.d locald = paramd.EYE.IzX;
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
      paramk.IzP.h(paramk);
    }
  }
  
  private d l(k<?> paramk)
  {
    AppMethodBeat.i(183367);
    if (com.tencent.e.c.b.IyG != null)
    {
      if (com.tencent.e.c.b.IyG.aNY(paramk.getKey()))
      {
        paramk = this.IzC;
        AppMethodBeat.o(183367);
        return paramk;
      }
      paramk = this.IzD;
      AppMethodBeat.o(183367);
      return paramk;
    }
    if (this.IzD.isBusy())
    {
      paramk = this.IzC;
      AppMethodBeat.o(183367);
      return paramk;
    }
    paramk = this.IzD;
    AppMethodBeat.o(183367);
    return paramk;
  }
  
  public final <V> com.tencent.e.i.d<V> a(k<V> paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(183364);
    paramk = a(paramk, paramBoolean, l(paramk));
    AppMethodBeat.o(183364);
    return paramk;
  }
  
  public final Map<String, List<String>> fnM()
  {
    AppMethodBeat.i(183366);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject1 = this.IzE.IzF;
    Object localObject2 = new LinkedList();
    ((f.a)localObject1).azU.dump(new f.a.2((f.a)localObject1, (List)localObject2), "");
    localLinkedHashMap.put("UIPool", localObject2);
    localLinkedHashMap.put("HotPool", this.IzD.fof());
    localLinkedHashMap.put("ColdPool", this.IzC.fof());
    localObject1 = com.tencent.e.j.a.fop().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.e.j.a)((Iterator)localObject1).next();
      List localList = ((com.tencent.e.j.a)localObject2).IzX.foq();
      if (localList.size() > 0) {
        localLinkedHashMap.put(((com.tencent.e.j.a)localObject2).tag, localList);
      }
    }
    AppMethodBeat.o(183366);
    return localLinkedHashMap;
  }
  
  public final <V> com.tencent.e.i.d<V> k(k<V> paramk)
  {
    AppMethodBeat.i(186959);
    paramk = a(paramk, false, this.IzD);
    AppMethodBeat.o(186959);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.e
 * JD-Core Version:    0.7.0.1
 */