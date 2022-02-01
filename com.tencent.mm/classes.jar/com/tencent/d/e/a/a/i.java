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
  private final int MkF;
  final int MkG;
  Object[] OI;
  int abZ;
  final int cZd;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(138410);
    this.MkF = paramInt1;
    this.OI = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.abZ = 0;
    this.cZd = paramInt3;
    this.MkG = paramInt2;
    AppMethodBeat.o(138410);
  }
  
  private ArrayList<f> aho(int paramInt)
  {
    AppMethodBeat.i(138411);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.OI[paramInt];
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
      localf.Mla = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(138411);
    return localArrayList;
  }
  
  public final Object[] fYA()
  {
    AppMethodBeat.i(138413);
    Object[] arrayOfObject = (Object[])this.OI.clone();
    AppMethodBeat.o(138413);
    return arrayOfObject;
  }
  
  public final ArrayList<g> iZ(List<k> paramList)
  {
    AppMethodBeat.i(138412);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.OI.length)
    {
      Object localObject = (List)this.OI[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = aho(j);
        localHashMap = new HashMap();
        if (this.MkF != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.Mlc = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.Mlb = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.MkI = ((k)localObject).MkI;
              localg.MkJ = ((k)localObject).MkJ;
              localg.MkK = ((k)localObject).MkK;
              localg.MkL = ((k)localObject).MkL;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.MkF == 4) {
          i = 2;
        } else if (this.MkF == 9) {
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