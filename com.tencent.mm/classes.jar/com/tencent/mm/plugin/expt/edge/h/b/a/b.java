package com.tencent.mm.plugin.expt.edge.h.b.a;

import com.eclipsesource.mmv8.V8Array;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class b
  extends com.tencent.mm.plugin.expt.edge.h.b.a
{
  private com.tencent.mm.plugin.expt.edge.c.a zAr;
  private Map<String, List<List<String>>> zAs;
  
  public b()
  {
    AppMethodBeat.i(299736);
    this.zAs = new HashMap();
    AppMethodBeat.o(299736);
  }
  
  public final Object b(V8Array paramV8Array)
  {
    AppMethodBeat.i(299753);
    if ((paramV8Array == null) || (paramV8Array.length() <= 0))
    {
      AppMethodBeat.o(299753);
      return null;
    }
    Object localObject = paramV8Array.getString(0);
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingJsApiBase", "[EdgeComputingJsApiReadEdgeDBData] logic, sql : ".concat(String.valueOf(localObject)));
    if (i.hm((String)localObject))
    {
      AppMethodBeat.o(299753);
      return null;
    }
    if (!this.zAs.containsKey(localObject))
    {
      if (this.zAr == null) {
        this.zAr = new com.tencent.mm.plugin.expt.edge.c.a();
      }
      paramV8Array = this.zAr.hi("Edge.db", (String)localObject);
      this.zAs.put(localObject, paramV8Array);
    }
    while ((paramV8Array == null) || (paramV8Array.size() <= 0))
    {
      AppMethodBeat.o(299753);
      return null;
      paramV8Array = (List)this.zAs.get(localObject);
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
          localObject = (String)localIterator2.next();
          paramV8Array = (V8Array)localObject;
          if (localObject == null) {
            paramV8Array = "";
          }
          localObject = paramV8Array;
          if (i.fm(paramV8Array, ",")) {
            localObject = i.ca(paramV8Array, ",", "\\#");
          }
          paramV8Array = (V8Array)localObject;
          if (i.fm((String)localObject, ";")) {
            paramV8Array = i.ca((String)localObject, ";", "\\$");
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
    AppMethodBeat.o(299753);
    return paramV8Array;
  }
  
  public final String dIx()
  {
    return "read_edge_db_data";
  }
  
  public final int getType()
  {
    return 5;
  }
  
  public final void release()
  {
    AppMethodBeat.i(299782);
    this.zAs.clear();
    if (this.zAr != null)
    {
      this.zAr.release();
      this.zAr = null;
    }
    AppMethodBeat.o(299782);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.h.b.a.b
 * JD-Core Version:    0.7.0.1
 */