package com.tencent.b.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class r
{
  private static r cGI = null;
  private Map<Integer, q> cGG;
  private int cGH;
  
  private r(Context paramContext)
  {
    AppMethodBeat.i(87606);
    this.cGG = null;
    this.cGH = 0;
    this.cGG = new HashMap(3);
    this.cGG.put(Integer.valueOf(1), new o(paramContext));
    this.cGG.put(Integer.valueOf(2), new d(paramContext));
    this.cGG.put(Integer.valueOf(4), new k(paramContext));
    AppMethodBeat.o(87606);
  }
  
  private a Q(List<Integer> paramList)
  {
    AppMethodBeat.i(87611);
    if (paramList.size() > 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext())
        {
          paramList = new a();
          AppMethodBeat.o(87611);
          return paramList;
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.cGG.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).IA();
    } while (localObject == null);
    AppMethodBeat.o(87611);
    return localObject;
  }
  
  static r aW(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87607);
      if (cGI == null) {
        cGI = new r(paramContext);
      }
      paramContext = cGI;
      AppMethodBeat.o(87607);
      return paramContext;
    }
    finally {}
  }
  
  final a IA()
  {
    AppMethodBeat.i(87610);
    a locala = Q(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
    AppMethodBeat.o(87610);
    return locala;
  }
  
  final g Iz()
  {
    AppMethodBeat.i(87608);
    g localg = P(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
    AppMethodBeat.o(87608);
    return localg;
  }
  
  final g P(List<Integer> paramList)
  {
    AppMethodBeat.i(87609);
    if (paramList.size() >= 0) {
      paramList = paramList.iterator();
    }
    Object localObject;
    do
    {
      do
      {
        if (!paramList.hasNext())
        {
          paramList = new g();
          AppMethodBeat.o(87609);
          return paramList;
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.cGG.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).Iz();
    } while ((localObject == null) || (!s.dA(((g)localObject).cGo)));
    AppMethodBeat.o(87609);
    return localObject;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(87612);
    Iterator localIterator = this.cGG.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(87612);
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(parama);
    }
  }
  
  final void b(g paramg)
  {
    AppMethodBeat.i(87613);
    Iterator localIterator = this.cGG.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(87613);
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(paramg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */