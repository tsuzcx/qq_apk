package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a$an
{
  public Long RHm;
  public Long RHp;
  
  static an w(HashMap paramHashMap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(199233);
    an localan = new an();
    Object localObject1 = paramHashMap.get("id");
    if (localObject1 == null)
    {
      localObject1 = null;
      localan.RHm = ((Long)localObject1);
      paramHashMap = paramHashMap.get("trackId");
      if (paramHashMap == null)
      {
        paramHashMap = localObject2;
        localan.RHp = paramHashMap;
        AppMethodBeat.o(199233);
        return localan;
      }
    }
    else
    {
      if ((localObject1 instanceof Integer)) {}
      for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
      {
        localObject1 = Long.valueOf(l);
        break;
      }
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
 * Qualified Name:     com.tencent.d.a.an
 * JD-Core Version:    0.7.0.1
 */