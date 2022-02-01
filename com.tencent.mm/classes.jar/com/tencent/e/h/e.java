package com.tencent.e.h;

import android.os.Handler;
import com.tencent.e.d.a;
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
  public final b Msd;
  public final c Mse;
  public final f Msf;
  
  public e(com.tencent.e.a parama)
  {
    AppMethodBeat.i(183363);
    this.Msd = new b(parama.MpU, parama.MpT);
    this.Mse = new c(parama.MpV);
    this.Msf = new f();
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
      com.tencent.e.j.d locald = paramd.IBW.Msx;
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
      paramk.Msq.h(paramk);
    }
  }
  
  private d l(k<?> paramk)
  {
    AppMethodBeat.i(183367);
    if (com.tencent.e.c.b.Mrh != null)
    {
      if (com.tencent.e.c.b.Mrh.bbe(paramk.getKey()))
      {
        paramk = this.Msd;
        AppMethodBeat.o(183367);
        return paramk;
      }
      paramk = this.Mse;
      AppMethodBeat.o(183367);
      return paramk;
    }
    if (this.Mse.isBusy())
    {
      paramk = this.Msd;
      AppMethodBeat.o(183367);
      return paramk;
    }
    paramk = this.Mse;
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
  
  public final Map<String, List<String>> fZT()
  {
    AppMethodBeat.i(183366);
    localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = this.Msf.Msg;
      Object localObject2 = new LinkedList();
      ((f.a)localObject1).aCF.dump(new f.a.2((f.a)localObject1, (List)localObject2), "");
      localLinkedHashMap.put("UIPool", localObject2);
      localLinkedHashMap.put("HotPool", this.Mse.gam());
      localLinkedHashMap.put("ColdPool", this.Msd.gam());
      localObject1 = com.tencent.e.j.a.gaw().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.e.j.a)((Iterator)localObject1).next();
        List localList = ((com.tencent.e.j.a)localObject2).Msx.gax();
        if (localList.size() > 0) {
          localLinkedHashMap.put(((com.tencent.e.j.a)localObject2).tag, localList);
        }
      }
      return localLinkedHashMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.e.d.Mqv.e("PoolAdapter", "[dumpWaitingTask] e=%s", new Object[] { localNullPointerException });
      AppMethodBeat.o(183366);
    }
  }
  
  public final <V> com.tencent.e.i.d<V> k(k<V> paramk)
  {
    AppMethodBeat.i(216745);
    paramk = a(paramk, false, this.Mse);
    AppMethodBeat.o(216745);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.e
 * JD-Core Version:    0.7.0.1
 */