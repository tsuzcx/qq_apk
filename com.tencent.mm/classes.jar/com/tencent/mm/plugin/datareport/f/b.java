package com.tencent.mm.plugin.datareport.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.c.i;

public final class b
{
  public String eventId;
  public Map<String, Object> params;
  
  public b()
  {
    AppMethodBeat.i(262806);
    this.params = new HashMap();
    AppMethodBeat.o(262806);
  }
  
  public final void ae(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262813);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(262813);
      return;
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!i.hm(str))
      {
        Object localObject = paramMap.get(str);
        if (localObject != null) {
          this.params.put(str, localObject);
        }
      }
    }
    AppMethodBeat.o(262813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.f.b
 * JD-Core Version:    0.7.0.1
 */