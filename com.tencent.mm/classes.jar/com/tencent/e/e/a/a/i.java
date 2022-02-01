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
  Object[] RY;
  private final int ahut;
  final int ahuu;
  final int hmC;
  int jP;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138410);
    this.ahut = paramInt1;
    this.RY = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.jP = 0;
    this.hmC = paramInt3;
    this.ahuu = paramInt2;
    AppMethodBeat.o(138410);
  }
  
  private ArrayList<f> aGZ(int paramInt)
  {
    AppMethodBeat.i(138411);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.RY[paramInt];
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
      localf.x = localj.hpa[0];
      localf.y = localj.hpa[1];
      localf.z = localj.hpa[2];
      localf.ahuN = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(138411);
    return localArrayList;
  }
  
  public final Object[] jXv()
  {
    AppMethodBeat.i(138413);
    Object[] arrayOfObject = (Object[])this.RY.clone();
    AppMethodBeat.o(138413);
    return arrayOfObject;
  }
  
  public final ArrayList<g> ou(List<k> paramList)
  {
    AppMethodBeat.i(138412);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.RY.length)
    {
      Object localObject = (List)this.RY[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = aGZ(j);
        localHashMap = new HashMap();
        if (this.ahut != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.ahuP = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.ahuO = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.ahuw = ((k)localObject).ahuw;
              localg.ahux = ((k)localObject).ahux;
              localg.ahuy = ((k)localObject).ahuy;
              localg.ahuz = ((k)localObject).ahuz;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.ahut == 4) {
          i = 2;
        } else if (this.ahut == 9) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */