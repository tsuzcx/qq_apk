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
  private com.tencent.h.a.c.a.a ahZs;
  
  public c(com.tencent.h.a.a.c paramc)
  {
    super(paramc);
  }
  
  private void OK(boolean paramBoolean)
  {
    AppMethodBeat.i(212216);
    if ((!paramBoolean) || (this.ahZl == null))
    {
      kdM().clearAll();
      kdM().ahZq.clear();
      AppMethodBeat.o(212216);
      return;
    }
    com.tencent.g.c.i.i("sensor_MasterEngine", "[method: dataPush ] ");
    if (this.ahZs != null) {
      this.ahZs.a(kdM().ahZn, kdM().ahZo, kdM().ahZp, this.ahZl);
    }
    kdM().clearAll();
    AppMethodBeat.o(212216);
  }
  
  public final void OJ(boolean paramBoolean)
  {
    AppMethodBeat.i(212243);
    OK(paramBoolean);
    AppMethodBeat.o(212243);
  }
  
  public final void T(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(212229);
    a.a locala = kdM();
    if (paramInt == 1)
    {
      if (paramObject != null)
      {
        paramObject = (List)paramObject;
        if ((paramObject == null) || (paramObject.isEmpty()))
        {
          AppMethodBeat.o(212229);
          return;
        }
        Object localObject = (g)paramObject.get(0);
        if (localObject != null)
        {
          localObject = locala.bGy(a.a.qc(paramInt, ((g)localObject).ahuv));
          ((ArrayList)localObject).addAll(paramObject);
          if ((locala.ahZr.ahXc != null) && (locala.ahZr.ahXc.ahWr == com.tencent.h.a.c.ahWn)) {}
          for (long l = 0L; l <= 0L; l = 500L)
          {
            ((List)localObject).clear();
            AppMethodBeat.o(212229);
            return;
          }
          paramInt = (int)Math.ceil((float)(locala.ahZr.ahWN.ahWO.kda().ahWy * 500L) * 1.0F / 1000.0F * 1.0F);
          if (((List)localObject).size() > paramInt) {
            ((List)localObject).removeAll(new ArrayList(((List)localObject).subList(0, ((List)localObject).size() - paramInt)));
          }
          AppMethodBeat.o(212229);
        }
      }
    }
    else {
      locala.bGy(a.a.qc(paramInt, -1)).add(paramObject);
    }
    AppMethodBeat.o(212229);
  }
  
  public final void U(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(212237);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = (List)paramObject;
      localObject2 = kdM();
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramObject = (g)((List)localObject1).get(0);
        if (paramObject == null) {
          break label211;
        }
        paramInt = paramObject.ahuv;
        paramObject = (List)((a.a)localObject2).ahZn.get(Integer.valueOf(paramInt));
        if (paramObject != null) {
          break label363;
        }
        paramObject = new ArrayList();
        ((a.a)localObject2).ahZn.put(Integer.valueOf(paramInt), paramObject);
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
      AppMethodBeat.o(212237);
      return;
      if ((paramInt == 11) && ((paramObject instanceof com.tencent.h.a.c.b.i)))
      {
        paramObject = (com.tencent.h.a.c.b.i)paramObject;
        localObject1 = kdM();
        if (paramObject != null)
        {
          localObject2 = ((a.a)localObject1).ahZo;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            break label217;
          }
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          ((a.a)localObject1).ahZo.add(paramObject);
        }
        AppMethodBeat.o(212237);
        return;
        com.tencent.h.a.c.b.i locali = (com.tencent.h.a.c.b.i)((List)localObject2).get(((List)localObject2).size() - 1);
        if ((paramObject.ahYz != locali.ahYz) || (paramObject.ahYC != locali.ahYC))
        {
          paramInt = 0;
        }
        else if ((locali.ahYy == 1) && ((paramObject.ahYy == 3) || (paramObject.ahYy == 4)))
        {
          paramObject.ahYz += 1L;
          ((List)localObject2).add(paramObject);
          paramInt = 1;
        }
        else if ((locali.ahYy == 1) && (paramObject.ahYy == 2))
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
  
  public final void a(com.tencent.h.a.b.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(212221);
    this.ahXc = parama.kdk();
    if (this.ahXc == null) {}
    for (;;)
    {
      this.ahZs = ((com.tencent.h.a.c.a.a)localObject);
      kdM().clearAll();
      kdN();
      AppMethodBeat.o(212221);
      return;
      if (this.ahXc.ahWr == com.tencent.h.a.c.ahWm) {
        localObject = new com.tencent.h.a.c.a.c(this.ahWN, parama);
      } else if (this.ahXc.ahWr == com.tencent.h.a.c.ahWn) {
        localObject = new b(this.ahWN, parama);
      }
    }
  }
  
  public final void fzH()
  {
    AppMethodBeat.i(212248);
    kdM().clearAll();
    kdM().ahZq.clear();
    if (this.ahZs != null) {
      this.ahZs.fzH();
    }
    AppMethodBeat.o(212248);
  }
  
  public final void kdN()
  {
    AppMethodBeat.i(212256);
    Iterator localIterator = kdM().ahZq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      kdM();
      if (a.a.bGz((String)localEntry.getKey()) == 1)
      {
        U(1, localArrayList);
      }
      else
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          Object localObject = localArrayList.get(i);
          U(Integer.valueOf((String)localEntry.getKey()).intValue(), localObject);
          i += 1;
        }
      }
    }
    kdM().ahZq.clear();
    AppMethodBeat.o(212256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */