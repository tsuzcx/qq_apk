package com.tencent.d.e.a.a;

import com.tencent.d.e.a.b.f;
import com.tencent.d.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
{
  private final int Isg;
  final int Ish;
  Object[] LV;
  int Zo;
  final int cPu;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138410);
    this.Isg = paramInt1;
    this.LV = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.Zo = 0;
    this.cPu = paramInt3;
    this.Ish = paramInt2;
    AppMethodBeat.o(138410);
  }
  
  private ArrayList<f> abM(int paramInt)
  {
    AppMethodBeat.i(138411);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.LV[paramInt];
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
      localf.IsB = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(138411);
    return localArrayList;
  }
  
  public final Object[] fmt()
  {
    AppMethodBeat.i(138413);
    Object[] arrayOfObject = (Object[])this.LV.clone();
    AppMethodBeat.o(138413);
    return arrayOfObject;
  }
  
  public final ArrayList<g> ip(List<k> paramList)
  {
    AppMethodBeat.i(138412);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.LV.length)
    {
      Object localObject = (List)this.LV[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = abM(j);
        localHashMap = new HashMap();
        if (this.Isg != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.IsD = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.IsC = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.Isj = ((k)localObject).Isj;
              localg.Isk = ((k)localObject).Isk;
              localg.Isl = ((k)localObject).Isl;
              localg.Ism = ((k)localObject).Ism;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.Isg == 4) {
          i = 2;
        } else if (this.Isg == 9) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.d.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */