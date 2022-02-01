package com.tencent.mm.plugin.expt.d.h.b.a;

import com.eclipsesource.v8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public final class b
  extends com.tencent.mm.plugin.expt.d.h.b.a
{
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(220364);
    if ((paramV8Array == null) || (paramV8Array.length() <= 0))
    {
      AppMethodBeat.o(220364);
      return null;
    }
    paramV8Array = paramV8Array.getString(0);
    Log.d("EdgeComputingJsApiBase", "[EdgeComputingJsApiReadEdgeDBData]] logic, sql : ".concat(String.valueOf(paramV8Array)));
    if (g.eP(paramV8Array))
    {
      AppMethodBeat.o(220364);
      return null;
    }
    paramV8Array = com.tencent.mm.plugin.expt.d.a.cMI().aok(paramV8Array);
    if ((paramV8Array == null) || (paramV8Array.size() <= 0))
    {
      AppMethodBeat.o(220364);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = paramV8Array.iterator();
    while (localIterator1.hasNext())
    {
      List localList = (List)localIterator1.next();
      if ((localList != null) && (localList.size() > 0))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(";");
        }
        Iterator localIterator2 = localList.iterator();
        int i = 0;
        while (localIterator2.hasNext())
        {
          Object localObject = (String)localIterator2.next();
          paramV8Array = (V8Array)localObject;
          if (localObject == null) {
            paramV8Array = "";
          }
          localObject = paramV8Array;
          if (g.eH(paramV8Array, ",")) {
            localObject = g.bC(paramV8Array, ",", "\\#");
          }
          paramV8Array = (V8Array)localObject;
          if (g.eH((String)localObject, ";")) {
            paramV8Array = g.bC((String)localObject, ";", "\\$");
          }
          localStringBuilder.append(paramV8Array);
          if (i < localList.size() - 1) {
            localStringBuilder.append(",");
          }
          i += 1;
        }
      }
    }
    paramV8Array = localStringBuilder.toString();
    AppMethodBeat.o(220364);
    return paramV8Array;
  }
  
  public final String cNb()
  {
    return "read_edge_db_data";
  }
  
  public final int getType()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b.a.b
 * JD-Core Version:    0.7.0.1
 */