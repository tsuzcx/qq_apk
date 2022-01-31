package com.tencent.e.e.a;

import com.tencent.e.e.a.a.h;
import com.tencent.e.e.a.a.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class e$4
  extends com.tencent.e.e.a.a.c
{
  e$4(e parame, com.tencent.e.e.a.a.e parame1, String paramString) {}
  
  public final void dUF()
  {
    AppMethodBeat.i(114540);
    Object localObject1 = h.dUM().dUN();
    HashMap localHashMap = new HashMap();
    Object localObject2;
    if (((Map)localObject1).size() != 0)
    {
      localObject2 = h.e((Map)localObject1, 0);
      if (localObject2 != null) {
        localHashMap.put(((h.a)localObject2).Blb, ((h.a)localObject2).Blc);
      }
      localObject2 = h.e((Map)localObject1, 1);
      if (localObject2 != null) {
        localHashMap.put(((h.a)localObject2).Blb, ((h.a)localObject2).Blc);
      }
      localObject1 = h.e((Map)localObject1, 2);
      if (localObject1 != null) {
        localHashMap.put(((h.a)localObject1).Blb, ((h.a)localObject1).Blc);
      }
    }
    if (localHashMap.size() == 0)
    {
      this.BkK.asO();
      AppMethodBeat.o(114540);
      return;
    }
    localObject1 = localHashMap.keySet().iterator();
    label308:
    for (;;)
    {
      boolean bool;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.e.e.a.b.a)((Iterator)localObject1).next();
        ((com.tencent.e.e.a.b.a)localObject2).Blj = System.currentTimeMillis();
        ((com.tencent.e.e.a.b.a)localObject2).feA = this.BkL;
        if ((this.BkK instanceof a)) {
          bool = e.a((a)this.BkK, (com.tencent.e.e.a.b.a)localObject2);
        }
      }
      for (;;)
      {
        if (!bool) {
          break label308;
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
        if ((this.BkK instanceof c))
        {
          bool = e.a((c)this.BkK, (com.tencent.e.e.a.b.a)localObject2);
          continue;
          AppMethodBeat.o(114540);
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public final void dUG()
  {
    AppMethodBeat.i(114541);
    if (e.f(this.BkG) != null) {
      e.f(this.BkG);
    }
    AppMethodBeat.o(114541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.e.e.a.e.4
 * JD-Core Version:    0.7.0.1
 */