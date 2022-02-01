package com.tencent.h.a.c.d;

import com.tencent.h.a.c.a.b;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.h.a;
import com.tencent.h.a.j;
import com.tencent.h.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  extends a
{
  private com.tencent.h.a.c.a.a ZUT;
  
  public c(com.tencent.h.a.a.c paramc)
  {
    super(paramc);
  }
  
  private void II(boolean paramBoolean)
  {
    AppMethodBeat.i(207724);
    if ((!paramBoolean) || (this.ZUM == null))
    {
      iuq().clearAll();
      iuq().ZUR.clear();
      AppMethodBeat.o(207724);
      return;
    }
    com.tencent.g.c.i.i("sensor_MasterEngine", "[method: dataPush ] ");
    if (this.ZUT != null) {
      this.ZUT.a(iuq().ZUO, iuq().ZUP, iuq().ZUQ, this.ZUM);
    }
    iuq().clearAll();
    AppMethodBeat.o(207724);
  }
  
  public final void A(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(207721);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = (List)paramObject;
      localObject2 = iuq();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramObject = (g)((List)localObject1).get(0);
        if (paramObject == null) {
          break label211;
        }
        paramInt = paramObject.ZpN;
        paramObject = (List)((a.a)localObject2).ZUO.get(Integer.valueOf(paramInt));
        if (paramObject != null) {
          break label363;
        }
        paramObject = new ArrayList();
        ((a.a)localObject2).ZUO.put(Integer.valueOf(paramInt), paramObject);
      }
    }
    label211:
    label217:
    label363:
    for (;;)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (g)((Iterator)localObject1).next();
        if (localObject2 != null) {
          paramObject.add(localObject2);
        }
      }
      AppMethodBeat.o(207721);
      return;
      if ((paramInt == 11) && ((paramObject instanceof com.tencent.h.a.c.b.i)))
      {
        paramObject = (com.tencent.h.a.c.b.i)paramObject;
        localObject1 = iuq();
        if (paramObject != null)
        {
          localObject2 = ((a.a)localObject1).ZUP;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            break label217;
          }
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          ((a.a)localObject1).ZUP.add(paramObject);
        }
        AppMethodBeat.o(207721);
        return;
        com.tencent.h.a.c.b.i locali = (com.tencent.h.a.c.b.i)((List)localObject2).get(((List)localObject2).size() - 1);
        if ((paramObject.ZTZ != locali.ZTZ) || (paramObject.ZUc != locali.ZUc))
        {
          paramInt = 0;
        }
        else if ((locali.ZTY == 1) && ((paramObject.ZTY == 3) || (paramObject.ZTY == 4)))
        {
          paramObject.ZTZ += 1L;
          ((List)localObject2).add(paramObject);
          paramInt = 1;
        }
        else if ((locali.ZTY == 1) && (paramObject.ZTY == 2))
        {
          paramInt = 1;
        }
        else
        {
          ((List)localObject2).remove(locali);
          ((List)localObject2).add(paramObject);
          paramInt = 1;
        }
      }
    }
  }
  
  public final void IH(boolean paramBoolean)
  {
    AppMethodBeat.i(207722);
    II(paramBoolean);
    AppMethodBeat.o(207722);
  }
  
  public final void a(com.tencent.h.a.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(207719);
    this.ZSC = parama.itO();
    if (this.ZSC == null) {}
    for (;;)
    {
      this.ZUT = ((com.tencent.h.a.c.a.a)localObject);
      iuq().clearAll();
      iur();
      AppMethodBeat.o(207719);
      return;
      if (this.ZSC.ZRU == com.tencent.h.a.c.ZRP) {
        localObject = new com.tencent.h.a.c.a.c(this.ZSp, parama);
      } else if (this.ZSC.ZRU == com.tencent.h.a.c.ZRQ) {
        localObject = new b(this.ZSp, parama);
      }
    }
  }
  
  public final void esN()
  {
    AppMethodBeat.i(207723);
    iuq().clearAll();
    iuq().ZUR.clear();
    if (this.ZUT != null) {
      this.ZUT.esN();
    }
    AppMethodBeat.o(207723);
  }
  
  public final void iur()
  {
    AppMethodBeat.i(207725);
    Iterator localIterator = iuq().ZUR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      iuq();
      if (a.a.bEa((String)localEntry.getKey()) == 1)
      {
        A(1, localArrayList);
      }
      else
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          Object localObject = localArrayList.get(i);
          A(Integer.valueOf((String)localEntry.getKey()).intValue(), localObject);
          i += 1;
        }
      }
    }
    iuq().ZUR.clear();
    AppMethodBeat.o(207725);
  }
  
  public final void z(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(207720);
    a.a locala = iuq();
    if (paramInt == 1)
    {
      if (paramObject != null)
      {
        paramObject = (List)paramObject;
        if ((paramObject == null) || (paramObject.isEmpty()))
        {
          AppMethodBeat.o(207720);
          return;
        }
        Object localObject = (g)paramObject.get(0);
        if (localObject != null)
        {
          localObject = locala.bDZ(a.a.of(paramInt, ((g)localObject).ZpN));
          ((ArrayList)localObject).addAll(paramObject);
          if ((locala.ZUS.ZSC != null) && (locala.ZUS.ZSC.ZRU == com.tencent.h.a.c.ZRQ)) {}
          for (long l = 0L; l <= 0L; l = 500L)
          {
            ((List)localObject).clear();
            AppMethodBeat.o(207720);
            return;
          }
          paramInt = (int)Math.ceil((float)(locala.ZUS.ZSp.ZSq.itF().ZSb * 500L) * 1.0F / 1000.0F * 1.0F);
          if (((List)localObject).size() > paramInt) {
            ((List)localObject).removeAll(new ArrayList(((List)localObject).subList(0, ((List)localObject).size() - paramInt)));
          }
          AppMethodBeat.o(207720);
        }
      }
    }
    else {
      locala.bDZ(a.a.of(paramInt, -1)).add(paramObject);
    }
    AppMethodBeat.o(207720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */