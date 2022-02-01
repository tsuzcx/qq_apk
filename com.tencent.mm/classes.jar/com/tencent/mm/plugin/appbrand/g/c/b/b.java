package com.tencent.mm.plugin.appbrand.g.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  protected Map<String, String> map;
  
  public b()
  {
    AppMethodBeat.i(159025);
    this.map = new HashMap();
    AppMethodBeat.o(159025);
  }
  
  public final String get(String paramString)
  {
    AppMethodBeat.i(159026);
    paramString = (String)this.map.get(paramString);
    AppMethodBeat.o(159026);
    return paramString;
  }
  
  public final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(159027);
    this.map.put(paramString1, paramString2);
    AppMethodBeat.o(159027);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(159028);
    Object localObject = new StringBuilder();
    Iterator localIterator = this.map.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((StringBuilder)localObject).append(localEntry.getKey());
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(localEntry.getValue());
      ((StringBuilder)localObject).append("\n");
    }
    if (((StringBuilder)localObject).length() > 1) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(159028);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.c.b.b
 * JD-Core Version:    0.7.0.1
 */