package com.tencent.c.a.a;

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
  private static r bUY = null;
  private Map<Integer, q> bUW;
  private int bUX;
  
  private r(Context paramContext)
  {
    AppMethodBeat.i(125724);
    this.bUW = null;
    this.bUX = 0;
    this.bUW = new HashMap(3);
    this.bUW.put(Integer.valueOf(1), new o(paramContext));
    this.bUW.put(Integer.valueOf(2), new d(paramContext));
    this.bUW.put(Integer.valueOf(4), new k(paramContext));
    AppMethodBeat.o(125724);
  }
  
  private a E(List<Integer> paramList)
  {
    AppMethodBeat.i(125729);
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
          AppMethodBeat.o(125729);
          return paramList;
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.bUW.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).zT();
    } while (localObject == null);
    AppMethodBeat.o(125729);
    return localObject;
  }
  
  static r aN(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(125725);
      if (bUY == null) {
        bUY = new r(paramContext);
      }
      paramContext = bUY;
      AppMethodBeat.o(125725);
      return paramContext;
    }
    finally {}
  }
  
  final g D(List<Integer> paramList)
  {
    AppMethodBeat.i(125727);
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
          AppMethodBeat.o(125727);
          return paramList;
        }
        localObject = (Integer)paramList.next();
        localObject = (q)this.bUW.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).zS();
    } while ((localObject == null) || (!s.cJ(((g)localObject).bUE)));
    AppMethodBeat.o(125727);
    return localObject;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(125730);
    Iterator localIterator = this.bUW.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(125730);
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(parama);
    }
  }
  
  final void b(g paramg)
  {
    AppMethodBeat.i(125731);
    Iterator localIterator = this.bUW.entrySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        AppMethodBeat.o(125731);
        return;
      }
      ((q)((Map.Entry)localIterator.next()).getValue()).b(paramg);
    }
  }
  
  final g zS()
  {
    AppMethodBeat.i(125726);
    g localg = D(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
    AppMethodBeat.o(125726);
    return localg;
  }
  
  final a zT()
  {
    AppMethodBeat.i(125728);
    a locala = E(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
    AppMethodBeat.o(125728);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.c.a.a.r
 * JD-Core Version:    0.7.0.1
 */