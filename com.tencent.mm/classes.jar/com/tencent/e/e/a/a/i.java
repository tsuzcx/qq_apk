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
  final int ATU;
  private final int Bld;
  Object[] EX;
  int Sl;
  final int mCapacity;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(114569);
    this.Bld = paramInt1;
    this.EX = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.Sl = 0;
    this.mCapacity = paramInt3;
    this.ATU = paramInt2;
    AppMethodBeat.o(114569);
  }
  
  private ArrayList<f> Si(int paramInt)
  {
    AppMethodBeat.i(114570);
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.EX[paramInt];
    if (localList == null)
    {
      AppMethodBeat.o(114570);
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
      localf.Blx = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    AppMethodBeat.o(114570);
    return localArrayList;
  }
  
  public final Object[] dUO()
  {
    AppMethodBeat.i(114572);
    Object[] arrayOfObject = (Object[])this.EX.clone();
    AppMethodBeat.o(114572);
    return arrayOfObject;
  }
  
  public final ArrayList<g> fJ(List<k> paramList)
  {
    AppMethodBeat.i(114571);
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.EX.length)
    {
      Object localObject = (List)this.EX[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = Si(j);
        localHashMap = new HashMap();
        if (this.Bld != 1) {
          break label217;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.Blz = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.Bly = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.Blf = ((k)localObject).Blf;
              localg.Blg = ((k)localObject).Blg;
              localg.Blh = ((k)localObject).Blh;
              localg.Bli = ((k)localObject).Bli;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label217:
        if (this.Bld == 4) {
          i = 2;
        } else if (this.Bld == 9) {
          i = 4;
        } else {
          i = -1;
        }
      }
    }
    AppMethodBeat.o(114571);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.e.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */