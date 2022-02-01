package com.tencent.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class a$ai
{
  public Long RHm;
  public Long RIc;
  public Long end;
  
  static ai v(HashMap paramHashMap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(199232);
    ai localai = new ai();
    Object localObject1 = paramHashMap.get("id");
    if (localObject1 == null)
    {
      localObject1 = null;
      localai.RHm = ((Long)localObject1);
      localObject1 = paramHashMap.get("start");
      if (localObject1 == null)
      {
        localObject1 = null;
        localai.RIc = ((Long)localObject1);
        paramHashMap = paramHashMap.get("end");
        if (paramHashMap != null) {
          break label153;
        }
        paramHashMap = localObject2;
        localai.end = paramHashMap;
        AppMethodBeat.o(199232);
        return localai;
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
    if ((localObject1 instanceof Integer)) {}
    for (long l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
    label153:
    if ((paramHashMap instanceof Integer)) {}
    for (l = ((Integer)paramHashMap).intValue();; l = ((Long)paramHashMap).longValue())
    {
      paramHashMap = Long.valueOf(l);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.a.ai
 * JD-Core Version:    0.7.0.1
 */