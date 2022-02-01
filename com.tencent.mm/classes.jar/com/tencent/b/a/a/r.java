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
  private static r dgd = null;
  private Map<Integer, q> dgb;
  private int dgc;
  
  private r(Context paramContext)
  {
    AppMethodBeat.i(87606);
    this.dgb = null;
    this.dgc = 0;
    this.dgb = new HashMap(3);
    this.dgb.put(Integer.valueOf(1), new o(paramContext));
    this.dgb.put(Integer.valueOf(2), new d(paramContext));
    this.dgb.put(Integer.valueOf(4), new k(paramContext));
    AppMethodBeat.o(87606);
  }
  
  private a N(List<Integer> paramList)
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
        localObject = (q)this.dgb.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).Ue();
    } while (localObject == null);
    AppMethodBeat.o(87611);
    return localObject;
  }
  
  static r bs(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(87607);
      if (dgd == null) {
        dgd = new r(paramContext);
      }
      paramContext = dgd;
      AppMethodBeat.o(87607);
      return paramContext;
    }
    finally {}
  }
  
  final g M(List<Integer> paramList)
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
        localObject = (q)this.dgb.get(localObject);
      } while (localObject == null);
      localObject = ((q)localObject).Ud();
    } while ((localObject == null) || (!s.eZ(((g)localObject).dfK)));
    AppMethodBeat.o(87609);
    return localObject;
  }
  
  final g Ud()
  {
    AppMethodBeat.i(87608);
    g localg = M(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4) })));
    AppMethodBeat.o(87608);
    return localg;
  }
  
  final a Ue()
  {
    AppMethodBeat.i(87610);
    a locala = N(new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(4) })));
    AppMethodBeat.o(87610);
    return locala;
  }
  
  final void b(a parama)
  {
    AppMethodBeat.i(87612);
    Iterator localIterator = this.dgb.entrySet().iterator();
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
    Iterator localIterator = this.dgb.entrySet().iterator();
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