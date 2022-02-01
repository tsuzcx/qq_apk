package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class e$a
{
  public Boolean ahhE;
  public String key;
  public String name;
  
  static a cZ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229170);
    a locala = new a();
    locala.name = ((String)paramMap.get("name"));
    locala.key = ((String)paramMap.get("key"));
    locala.ahhE = ((Boolean)paramMap.get("value"));
    AppMethodBeat.o(229170);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.c.e.a
 * JD-Core Version:    0.7.0.1
 */