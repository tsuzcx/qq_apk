package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e$f
{
  public String key;
  public String name;
  public String value;
  
  static f db(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229173);
    f localf = new f();
    localf.name = ((String)paramMap.get("name"));
    localf.key = ((String)paramMap.get("key"));
    localf.value = ((String)paramMap.get("value"));
    AppMethodBeat.o(229173);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.c.e.f
 * JD-Core Version:    0.7.0.1
 */