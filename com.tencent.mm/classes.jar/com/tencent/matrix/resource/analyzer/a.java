package com.tencent.matrix.resource.analyzer;

import com.d.a.b.c;
import com.d.a.b.e;
import com.d.a.b.i;
import com.d.a.b.l;
import com.tencent.matrix.resource.analyzer.a.b;
import com.tencent.matrix.resource.analyzer.a.b.a;
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
  public final String daR;
  private final d daS;
  
  public a(String paramString, d paramd)
  {
    this.daR = paramString;
    this.daS = paramd;
  }
  
  public final com.tencent.matrix.resource.analyzer.model.a a(g paramg, String paramString)
  {
    long l = System.nanoTime();
    try
    {
      paramg = paramg.cks;
      localObject2 = paramg.cW("com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
      if (localObject2 == null) {
        throw new IllegalStateException("Unabled to find destroy activity info class with name: com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo");
      }
    }
    catch (Throwable paramg)
    {
      return com.tencent.matrix.resource.analyzer.model.a.a(paramg, com.tencent.matrix.resource.analyzer.a.a.bs(l));
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = ((c)localObject2).KX().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = e.b((i)((Iterator)localObject2).next());
      String str = e.ap(e.b((List)localObject3, "mKey"));
      if (str.equals(paramString))
      {
        localObject3 = (i)e.b((List)localObject3, "mActivityRef");
        if (localObject3 != null)
        {
          paramString = (i)e.b(e.b((i)localObject3), "referent");
          if (paramString != null) {
            break label202;
          }
          return com.tencent.matrix.resource.analyzer.model.a.br(com.tencent.matrix.resource.analyzer.a.a.bs(l));
        }
      }
      else
      {
        ((List)localObject1).add(str);
      }
    }
    throw new IllegalStateException("Could not find weak reference with key " + paramString + " in " + localObject1);
    label202:
    localObject1 = new b(this.daS);
    localObject2 = new ArrayList();
    ((List)localObject2).add(paramString);
    paramg = ((b)localObject1).a(paramg, (Collection)localObject2);
    if (paramg.isEmpty()) {}
    for (paramg = new b.a(null, false); paramg.dcy == null; paramg = (b.a)paramg.get(paramString)) {
      return com.tencent.matrix.resource.analyzer.model.a.br(com.tencent.matrix.resource.analyzer.a.a.bs(l));
    }
    localObject1 = paramg.XD();
    paramString = paramString.KU().mClassName;
    if (!paramg.dcz)
    {
      if (((h)localObject1).elements != null) {
        if (!((h)localObject1).elements.isEmpty()) {
          break label368;
        }
      }
    }
    else {
      return com.tencent.matrix.resource.analyzer.model.a.br(com.tencent.matrix.resource.analyzer.a.a.bs(l));
    }
    label368:
    label371:
    for (;;)
    {
      paramg = com.tencent.matrix.resource.analyzer.model.a.a(paramString, (h)localObject1, com.tencent.matrix.resource.analyzer.a.a.bs(l));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.analyzer.a
 * JD-Core Version:    0.7.0.1
 */