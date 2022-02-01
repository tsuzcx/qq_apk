package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a$r
{
  public Long RHm;
  
  static r t(HashMap paramHashMap)
  {
    AppMethodBeat.i(199230);
    r localr = new r();
    paramHashMap = paramHashMap.get("id");
    if (paramHashMap == null)
    {
      paramHashMap = null;
      localr.RHm = paramHashMap;
      AppMethodBeat.o(199230);
      return localr;
    }
    if ((paramHashMap instanceof Integer)) {}
    for (long l = ((Integer)paramHashMap).intValue();; l = ((Long)paramHashMap).longValue())
    {
      paramHashMap = Long.valueOf(l);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.a.r
 * JD-Core Version:    0.7.0.1
 */