package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.u.j;
import java.util.Collection;
import java.util.Iterator;

public final class e
{
  private static final j<q, z> htk = new j();
  
  public static z a(q paramq, e.a parama)
  {
    if (paramq == null) {
      return null;
    }
    paramq = htk.aV(paramq);
    if (paramq != null)
    {
      paramq = paramq.iterator();
      while (paramq.hasNext())
      {
        z localz = (z)paramq.next();
        if ((localz != null) && (parama.a(localz))) {
          return localz;
        }
      }
    }
    return null;
  }
  
  public static void a(q paramq, z paramz)
  {
    htk.h(paramq, paramz);
  }
  
  public static void t(q paramq)
  {
    htk.aW(paramq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.e
 * JD-Core Version:    0.7.0.1
 */