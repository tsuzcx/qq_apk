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
  private static r cDQ = null;
  private Map<Integer, q> cDO;
  private int cDP;
  
  private r(Context paramContext)
  {
    AppMethodBeat.i(87606);
    this.cDO = null;
    this.cDP = 0;
    this.cDO = new HashMap(3);
    this.cDO.put(Integer.valueOf(1), new o(paramContext));
    this.cDO.put(Integer.valueOf(2), new d(paramContext));
    this.cDO.put(Integer.valueOf(4), new k(paramContext));
    AppMethodBeat.o(87606);
  }
  
  private a H(List<Integer> paramList)
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
        localObject = (q)this.cDO.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).Ij();
    } while (localObject == null);
    AppMethodBeat.o(87611);
    return localObject;
  }
  
  static r aX(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87607);
      if (cDQ == null) {
        cDQ = new r(paramContext);
      }
      paramContext = cDQ;
      AppMethodBeat.o(87607);
      return paramContext;
    }
    finally {}
  }
  
  final g G(List<Integer> paramList)
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
        localObject = (q)this.cDO.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).Ii();
    } while ((localObject == null) || (!s.dp(((g)localObject).cDw)));
    AppMethodBeat.o(87609);
    return localObject;
  }
  
  final g Ii()
  {
    AppMethodBeat.i(87608);
    g localg = G(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
    AppMethodBeat.o(87608);
    return localg;
  }
  
  final a Ij()
  {
    AppMethodBeat.i(87610);
    a locala = H(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
    AppMethodBeat.o(87610);
    return locala;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(87612);
    Iterator localIterator = this.cDO.entrySet().iterator();
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
    Iterator localIterator = this.cDO.entrySet().iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.r
 * JD-Core Version:    0.7.0.1
 */