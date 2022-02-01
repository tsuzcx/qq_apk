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
  private final int ZpL;
  final int ZpM;
  final int fip;
  int iU;
  Object[] zL;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138410);
    this.ZpL = paramInt1;
    this.zL = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.iU = 0;
    this.fip = paramInt3;
    this.ZpM = paramInt2;
    AppMethodBeat.o(138410);
  }
  
  private ArrayList<f> aAo(int paramInt)
  {
    AppMethodBeat.i(138411);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.zL[paramInt];
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
      localf.x = localj.fkN[0];
      localf.y = localj.fkN[1];
      localf.z = localj.fkN[2];
      localf.Zqg = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(138411);
    return localArrayList;
  }
  
  public final Object[] iok()
  {
    AppMethodBeat.i(138413);
    Object[] arrayOfObject = (Object[])this.zL.clone();
    AppMethodBeat.o(138413);
    return arrayOfObject;
  }
  
  public final ArrayList<g> kX(List<k> paramList)
  {
    AppMethodBeat.i(138412);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.zL.length)
    {
      Object localObject = (List)this.zL[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = aAo(j);
        localHashMap = new HashMap();
        if (this.ZpL != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.Zqi = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.Zqh = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.ZpO = ((k)localObject).ZpO;
              localg.ZpP = ((k)localObject).ZpP;
              localg.ZpQ = ((k)localObject).ZpQ;
              localg.ZpR = ((k)localObject).ZpR;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.ZpL == 4) {
          i = 2;
        } else if (this.ZpL == 9) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */