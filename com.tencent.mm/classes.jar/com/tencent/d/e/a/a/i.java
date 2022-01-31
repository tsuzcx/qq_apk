package com.tencent.d.e.a.a;

import com.tencent.d.e.a.b.f;
import com.tencent.d.e.a.b.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i
{
  Object[] Eh;
  final int dNA;
  int jVi;
  private final int wNE;
  final int wyC;
  
  public i(int paramInt1, int paramInt2, int paramInt3)
  {
    this.wNE = paramInt1;
    this.Eh = new Object[(int)Math.ceil(1.0F * paramInt3 / paramInt2)];
    this.jVi = 0;
    this.dNA = paramInt3;
    this.wyC = paramInt2;
  }
  
  private ArrayList<f> Jm(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = (List)this.Eh[paramInt];
    if (localList == null) {
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
      localf.wNZ = localj.timestamp;
      localArrayList.add(localf);
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public final Object[] cOY()
  {
    return (Object[])this.Eh.clone();
  }
  
  public final ArrayList<g> ex(List<k> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (j < this.Eh.length)
    {
      Object localObject = (List)this.Eh[j];
      g localg;
      ArrayList localArrayList2;
      HashMap localHashMap;
      int i;
      if ((localObject != null) && (((List)localObject).size() != 0))
      {
        localg = new g();
        localArrayList2 = Jm(j);
        localHashMap = new HashMap();
        if (this.wNE != 1) {
          break label212;
        }
        i = 0;
      }
      for (;;)
      {
        localHashMap.put(Integer.valueOf(i), localArrayList2);
        localg.wOb = localHashMap;
        localObject = (j)((List)localObject).get(0);
        if (localObject != null)
        {
          localg.wOa = ((j)localObject).timestamp;
          if (paramList.size() > j)
          {
            localObject = (k)paramList.get(j);
            if (localObject != null)
            {
              localg.wNG = ((k)localObject).wNG;
              localg.wNH = ((k)localObject).wNH;
              localg.wNI = ((k)localObject).wNI;
              localg.wNJ = ((k)localObject).wNJ;
            }
          }
          localArrayList1.add(localg);
        }
        j += 1;
        break;
        label212:
        if (this.wNE == 4) {
          i = 2;
        } else if (this.wNE == 9) {
          i = 4;
        } else {
          i = -1;
        }
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.e.a.a.i
 * JD-Core Version:    0.7.0.1
 */