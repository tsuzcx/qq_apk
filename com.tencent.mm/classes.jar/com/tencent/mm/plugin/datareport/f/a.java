package com.tencent.mm.plugin.datareport.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.c.i;

public final class a
{
  public String cui;
  public Map<String, Object> params;
  
  public a()
  {
    AppMethodBeat.i(262808);
    this.params = new HashMap();
    AppMethodBeat.o(262808);
  }
  
  public final void ae(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(262823);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(262823);
      return;
    }
    this.params.putAll(paramMap);
    AppMethodBeat.o(262823);
  }
  
  public final void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(262814);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(262814);
      return;
    }
    Map localMap = this.params;
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "";
    }
    localMap.put(paramString, localObject);
    AppMethodBeat.o(262814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.f.a
 * JD-Core Version:    0.7.0.1
 */