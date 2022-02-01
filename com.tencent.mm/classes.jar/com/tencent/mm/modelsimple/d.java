package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.messenger.b.a;
import com.tencent.mm.plugin.messenger.b.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  implements q
{
  public final int bLN()
  {
    AppMethodBeat.i(236708);
    int i = a.gaM();
    AppMethodBeat.o(236708);
    return i;
  }
  
  public final List<Integer> bLO()
  {
    AppMethodBeat.i(236712);
    ArrayList localArrayList = new ArrayList();
    if (a.gaM() == 9)
    {
      Iterator localIterator = a.gaL().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(Integer.valueOf(((a.a)localIterator.next()).qvo));
      }
    }
    localArrayList.add(Integer.valueOf(a.gaM()));
    AppMethodBeat.o(236712);
    return localArrayList;
  }
  
  public final int bLP()
  {
    AppMethodBeat.i(236716);
    int i = a.bLP();
    AppMethodBeat.o(236716);
    return i;
  }
  
  public final boolean bLQ()
  {
    AppMethodBeat.i(236723);
    bh.bCz();
    boolean bool = c.bzw();
    AppMethodBeat.o(236723);
    return bool;
  }
  
  public final String bLR()
  {
    AppMethodBeat.i(236725);
    if ((a.gaK() != null) && (a.gaK().KPZ != null))
    {
      String str = a.gaK().KPZ;
      AppMethodBeat.o(236725);
      return str;
    }
    AppMethodBeat.o(236725);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.d
 * JD-Core Version:    0.7.0.1
 */