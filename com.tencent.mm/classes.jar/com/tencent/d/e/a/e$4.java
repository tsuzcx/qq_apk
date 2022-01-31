package com.tencent.d.e.a;

import com.tencent.d.e.a.a.h;
import com.tencent.d.e.a.a.h.a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class e$4
  extends com.tencent.d.e.a.a.c
{
  e$4(e parame, com.tencent.d.e.a.a.e parame1, String paramString) {}
  
  public final void cOQ()
  {
    Object localObject1 = h.cOW().cOX();
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (((Map)localObject1).size() != 0)
    {
      localObject2 = h.d((Map)localObject1, 0);
      if (localObject2 != null) {
        localHashMap.put(((h.a)localObject2).wNC, ((h.a)localObject2).wND);
      }
      localObject2 = h.d((Map)localObject1, 1);
      if (localObject2 != null) {
        localHashMap.put(((h.a)localObject2).wNC, ((h.a)localObject2).wND);
      }
      localObject1 = h.d((Map)localObject1, 2);
      if (localObject1 != null) {
        localHashMap.put(((h.a)localObject1).wNC, ((h.a)localObject1).wND);
      }
    }
    if (localHashMap.size() == 0)
    {
      this.wNl.Zf();
      return;
    }
    localObject1 = localHashMap.keySet().iterator();
    label292:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.tencent.d.e.a.b.a)((Iterator)localObject1).next();
      ((com.tencent.d.e.a.b.a)localObject2).wNK = System.currentTimeMillis();
      ((com.tencent.d.e.a.b.a)localObject2).wNL = this.wNm;
      boolean bool;
      if ((this.wNl instanceof a)) {
        bool = e.a((a)this.wNl, (com.tencent.d.e.a.b.a)localObject2);
      }
      for (;;)
      {
        if (!bool) {
          break label292;
        }
        localObject2 = ((List)localHashMap.get(localObject2)).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          try
          {
            new File(str).delete();
          }
          catch (Throwable localThrowable) {}
        }
        break;
        if ((this.wNl instanceof c)) {
          bool = e.a((c)this.wNl, (com.tencent.d.e.a.b.a)localObject2);
        } else {
          bool = false;
        }
      }
    }
  }
  
  public final void cOR()
  {
    if (e.f(this.wNh) != null) {
      e.f(this.wNh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.a.e.4
 * JD-Core Version:    0.7.0.1
 */