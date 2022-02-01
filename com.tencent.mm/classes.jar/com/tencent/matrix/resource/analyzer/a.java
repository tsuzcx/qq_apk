package com.tencent.matrix.resource.analyzer;

import com.c.a.b.e;
import com.c.a.b.i;
import com.c.a.b.l;
import com.tencent.matrix.resource.analyzer.a.c.a;
import com.tencent.matrix.resource.analyzer.model.d;
import com.tencent.matrix.resource.analyzer.model.g;
import com.tencent.matrix.resource.analyzer.model.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private final String cWR;
  private final d cWS;
  
  public a(String paramString, d paramd)
  {
    this.cWR = paramString;
    this.cWS = paramd;
  }
  
  private com.tencent.matrix.resource.analyzer.model.a a(g paramg, String paramString)
  {
    long l = System.nanoTime();
    try
    {
      paramg = paramg.coS;
      localObject2 = paramg.cJ("com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
      if (localObject2 == null) {
        throw new IllegalStateException("Unabled to find destroy activity info class with name: com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
      }
    }
    catch (Throwable paramg)
    {
      return com.tencent.matrix.resource.analyzer.model.a.a(paramg, com.tencent.matrix.resource.analyzer.a.a.bg(l));
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = ((com.c.a.b.c)localObject2).Ke().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = e.b((i)((Iterator)localObject2).next());
      String str = e.as(e.b((List)localObject3, "mKey"));
      if (str.equals(paramString))
      {
        localObject3 = (i)e.b((List)localObject3, "mActivityRef");
        if (localObject3 != null)
        {
          paramString = (i)e.b(e.b((i)localObject3), "referent");
          if (paramString != null) {
            break label202;
          }
          return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(l));
        }
      }
      else
      {
        ((List)localObject1).add(str);
      }
    }
    throw new IllegalStateException("Could not find weak reference with key " + paramString + " in " + localObject1);
    label202:
    localObject1 = new com.tencent.matrix.resource.analyzer.a.c(this.cWS);
    localObject2 = new ArrayList();
    ((List)localObject2).add(paramString);
    paramg = ((com.tencent.matrix.resource.analyzer.a.c)localObject1).a(paramg, (Collection)localObject2);
    if (paramg.isEmpty()) {}
    for (paramg = new c.a(null, false); paramg.cYy == null; paramg = (c.a)paramg.get(paramString)) {
      return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(l));
    }
    localObject1 = paramg.Ta();
    paramString = paramString.Ka().mClassName;
    if (!paramg.cYz)
    {
      if (((h)localObject1).elements != null) {
        if (!((h)localObject1).elements.isEmpty()) {
          break label368;
        }
      }
    }
    else {
      return com.tencent.matrix.resource.analyzer.model.a.bf(com.tencent.matrix.resource.analyzer.a.a.bg(l));
    }
    label368:
    label371:
    for (;;)
    {
      paramg = com.tencent.matrix.resource.analyzer.model.a.a(paramString, (h)localObject1, com.tencent.matrix.resource.analyzer.a.a.bg(l));
      return paramg;
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label371;
        }
        break;
      }
    }
  }
  
  public final com.tencent.matrix.resource.analyzer.model.a a(g paramg)
  {
    return a(paramg, this.cWR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a
 * JD-Core Version:    0.7.0.1
 */