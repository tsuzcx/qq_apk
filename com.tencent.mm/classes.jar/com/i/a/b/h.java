package com.i.a.b;

import com.i.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  public static Map<String, Object> a(f paramf)
  {
    AppMethodBeat.i(153416);
    Object localObject = null;
    d locald = paramf.alx();
    paramf = localObject;
    if (locald != null)
    {
      paramf = new HashMap();
      paramf.put("sql", locald.sql);
      paramf.put("arguments", locald.ede);
    }
    AppMethodBeat.o(153416);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.b.h
 * JD-Core Version:    0.7.0.1
 */