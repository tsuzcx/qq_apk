package com.tencent.i.a.c.d;

import com.tencent.h.c.h;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
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
  public com.tencent.i.a.c.a.a Stq;
  
  public c(com.tencent.i.a.a.c paramc)
  {
    super(paramc);
  }
  
  public final void Eg(boolean paramBoolean)
  {
    AppMethodBeat.i(214817);
    if ((!paramBoolean) || (this.Stj == null))
    {
      this.Stk.clearAll();
      this.Stk.Sto.clear();
      AppMethodBeat.o(214817);
      return;
    }
    h.i("sensor_MasterEngine", "[method: dataPush ] ");
    if (this.Stq != null) {
      this.Stq.a(this.Stk.Stl, this.Stk.Stm, this.Stk.Stn, this.Stj);
    }
    this.Stk.clearAll();
    AppMethodBeat.o(214817);
  }
  
  public final void dQn()
  {
    AppMethodBeat.i(214816);
    this.Stk.clearAll();
    this.Stk.Sto.clear();
    if (this.Stq != null) {
      this.Stq.dQn();
    }
    AppMethodBeat.o(214816);
  }
  
  public final void hqH()
  {
    AppMethodBeat.i(214818);
    Iterator localIterator = this.Stk.Sto.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ArrayList localArrayList = (ArrayList)localEntry.getValue();
      if (a.a.brb((String)localEntry.getKey()) == 1)
      {
        v(1, localArrayList);
      }
      else
      {
        int i = 0;
        while (i < localArrayList.size())
        {
          Object localObject = localArrayList.get(i);
          v(Integer.valueOf((String)localEntry.getKey()).intValue(), localObject);
          i += 1;
        }
      }
    }
    this.Stk.Sto.clear();
    AppMethodBeat.o(214818);
  }
  
  public final void v(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(214815);
    Object localObject1;
    Object localObject2;
    if (paramInt == 1)
    {
      localObject1 = (List)paramObject;
      localObject2 = this.Stk;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        paramObject = (g)((List)localObject1).get(0);
        if (paramObject == null) {
          break label211;
        }
        paramInt = paramObject.RNh;
        paramObject = (List)((a.a)localObject2).Stl.get(Integer.valueOf(paramInt));
        if (paramObject != null) {
          break label363;
        }
        paramObject = new ArrayList();
        ((a.a)localObject2).Stl.put(Integer.valueOf(paramInt), paramObject);
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
      AppMethodBeat.o(214815);
      return;
      if ((paramInt == 11) && ((paramObject instanceof i)))
      {
        paramObject = (i)paramObject;
        localObject1 = this.Stk;
        if (paramObject != null)
        {
          localObject2 = ((a.a)localObject1).Stm;
          if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
            break label217;
          }
          paramInt = 0;
        }
      }
      for (;;)
      {
        if (paramInt == 0) {
          ((a.a)localObject1).Stm.add(paramObject);
        }
        AppMethodBeat.o(214815);
        return;
        i locali = (i)((List)localObject2).get(((List)localObject2).size() - 1);
        if ((paramObject.Ssw != locali.Ssw) || (paramObject.Ssz != locali.Ssz))
        {
          paramInt = 0;
        }
        else if ((locali.Ssv == 1) && ((paramObject.Ssv == 3) || (paramObject.Ssv == 4)))
        {
          paramObject.Ssw += 1L;
          ((List)localObject2).add(paramObject);
          paramInt = 1;
        }
        else if ((locali.Ssv == 1) && (paramObject.Ssv == 2))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.d.c
 * JD-Core Version:    0.7.0.1
 */