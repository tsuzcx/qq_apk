package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public final class b
  extends com.tencent.mm.plugin.expt.d.h.b.a
{
  public b(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(195941);
    if ((paramV8Array == null) || (paramV8Array.length() < 2))
    {
      AppMethodBeat.o(195941);
      return null;
    }
    Object localObject1 = paramV8Array.getString(0);
    paramV8Array = paramV8Array.getString(1);
    ae.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiReadDBData]] logic, dbPath : " + (String)localObject1 + ", sql : " + paramV8Array);
    if ((g.ef((String)localObject1)) || (g.ef(paramV8Array)))
    {
      AppMethodBeat.o(195941);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.d.a.cow();
    if ((g.ef((String)localObject1)) || (g.ef(paramV8Array))) {}
    for (paramV8Array = null; (paramV8Array == null) || (paramV8Array.size() <= 0); paramV8Array = ((com.tencent.mm.plugin.expt.d.a)localObject2).qXn.fU((String)localObject1, paramV8Array))
    {
      AppMethodBeat.o(195941);
      return null;
    }
    localObject2 = new StringBuilder();
    Iterator localIterator1 = paramV8Array.iterator();
    while (localIterator1.hasNext())
    {
      List localList = (List)localIterator1.next();
      if ((localList != null) && (localList.size() > 0))
      {
        if (((StringBuilder)localObject2).length() > 0) {
          ((StringBuilder)localObject2).append(";");
        }
        Iterator localIterator2 = localList.iterator();
        int i = 0;
        while (localIterator2.hasNext())
        {
          localObject1 = (String)localIterator2.next();
          paramV8Array = (V8Array)localObject1;
          if (localObject1 == null) {
            paramV8Array = "";
          }
          localObject1 = paramV8Array;
          if (g.eo(paramV8Array, ",")) {
            localObject1 = g.bu(paramV8Array, ",", "\\#");
          }
          paramV8Array = (V8Array)localObject1;
          if (g.eo((String)localObject1, ";")) {
            paramV8Array = g.bu((String)localObject1, ";", "\\$");
          }
          ((StringBuilder)localObject2).append(paramV8Array);
          if (i < localList.size() - 1) {
            ((StringBuilder)localObject2).append(",");
          }
          i += 1;
        }
      }
    }
    paramV8Array = ((StringBuilder)localObject2).toString();
    AppMethodBeat.o(195941);
    return paramV8Array;
  }
  
  public final String coO()
  {
    return "read_db_data";
  }
  
  public final int getType()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b.a.b
 * JD-Core Version:    0.7.0.1
 */