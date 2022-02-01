package com.tencent.e.e.a.a;

import com.tencent.e.e.a.b.f;
import com.tencent.e.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
{
  Object[] OW;
  private final int RNf;
  final int RNg;
  int acm;
  final int dpI;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138410);
    this.RNf = paramInt1;
    this.OW = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.acm = 0;
    this.dpI = paramInt3;
    this.RNg = paramInt2;
    AppMethodBeat.o(138410);
  }
  
  private ArrayList<f> aqB(int paramInt)
  {
    AppMethodBeat.i(138411);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.OW[paramInt];
    if (localList == null)
    {
      AppMethodBeat.o(138411);
      return localArrayList;
    }
    paramInt = 0;
    while (paramInt < localList.size())
    {
      j localj = (j)localList.get(paramInt);
      f localf = new f();
      localf.x = localj.values[0];
      localf.y = localj.values[1];
      localf.z = localj.values[2];
      localf.RNA = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(138411);
    return localArrayList;
  }
  
  public final Object[] hkM()
  {
    AppMethodBeat.i(138413);
    Object[] arrayOfObject = (Object[])this.OW.clone();
    AppMethodBeat.o(138413);
    return arrayOfObject;
  }
  
  public final ArrayList<g> kd(List<k> paramList)
  {
    AppMethodBeat.i(138412);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.OW.length)
    {
      Object localObject = (List)this.OW[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = aqB(j);
        localHashMap = new HashMap();
        if (this.RNf != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.RNC = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.RNB = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.RNi = ((k)localObject).RNi;
              localg.RNj = ((k)localObject).RNj;
              localg.RNk = ((k)localObject).RNk;
              localg.RNl = ((k)localObject).RNl;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.RNf == 4) {
          i = 2;
        } else if (this.RNf == 9) {
          i = 4;
        } else {
          i = -1;
        }
      }
    }
    AppMethodBeat.o(138412);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */