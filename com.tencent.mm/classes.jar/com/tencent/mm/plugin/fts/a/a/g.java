package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private static final g.a kwL = new g.1();
  public String kwG;
  public String kwH;
  public String[] kwI;
  public String[] kwJ;
  public List<g.c> kwK = new ArrayList();
  
  public static g a(String paramString, boolean paramBoolean, g.a parama)
  {
    g localg = new g();
    localg.kwG = paramString;
    localg.kwH = d.DR(paramString);
    localg.kwI = parama.split(localg.kwH);
    localg.kwJ = parama.DX(localg.kwH);
    paramString = localg.kwI;
    int k = paramString.length;
    int i = 0;
    List localList;
    int j;
    if (i < k)
    {
      parama = paramString[i];
      localList = localg.kwK;
      if (!paramBoolean) {
        break label495;
      }
      j = 0;
      if (j >= parama.length()) {
        break label495;
      }
      if (com.tencent.mm.plugin.fts.a.g.h(parama.charAt(j))) {}
    }
    label495:
    for (boolean bool = false;; bool = paramBoolean)
    {
      g.c localc = new g.c();
      Object localObject1;
      if (bool)
      {
        Object localObject2 = com.tencent.mm.plugin.fts.a.g.kvW;
        localObject1 = new ArrayList();
        Object localObject3 = parama.toLowerCase().toCharArray();
        j = 0;
        for (;;)
        {
          if (j < localObject3.length)
          {
            int m = localObject3[j];
            if (localObject2.kxA.kxB[(m - 97)] != null)
            {
              ((List)localObject1).add(String.valueOf(localObject3[j]));
              j += 1;
              continue;
              j += 1;
              break;
            }
            ((List)localObject1).clear();
          }
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = new g.b();
          ((g.b)localObject2).kwM = d.kwQ;
          ((g.b)localObject2).content = bk.c((List)localObject1, "​");
          ((g.b)localObject2).kwN = ((List)localObject1);
          localc.kwO.add(localObject2);
        }
        localObject1 = com.tencent.mm.plugin.fts.a.g.kvW.DZ(parama);
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (List)((Iterator)localObject1).next();
            if (((List)localObject2).size() > 0)
            {
              localObject3 = new g.b();
              ((g.b)localObject3).kwM = d.kwP;
              ((g.b)localObject3).content = bk.c((List)localObject2, "​");
              ((g.b)localObject3).kwN = ((List)localObject2);
              localc.kwO.add(localObject3);
            }
          }
        }
        localObject1 = new g.b();
        ((g.b)localObject1).kwM = d.kwR;
        ((g.b)localObject1).content = parama;
        localc.kwO.add(localObject1);
      }
      for (;;)
      {
        localList.add(localc);
        i += 1;
        break;
        localObject1 = new g.b();
        ((g.b)localObject1).kwM = d.kwR;
        ((g.b)localObject1).content = parama;
        localc.kwO.add(localObject1);
      }
      return localg;
    }
  }
  
  public static g aF(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, kwL);
  }
  
  public final String aVy()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < this.kwK.size())
    {
      localStringBuffer.append("(");
      localStringBuffer.append(((g.c)this.kwK.get(i)).aVz());
      localStringBuffer.append(")");
      if (i != this.kwK.size() - 1) {
        localStringBuffer.append(" AND ");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static enum d
  {
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.g
 * JD-Core Version:    0.7.0.1
 */