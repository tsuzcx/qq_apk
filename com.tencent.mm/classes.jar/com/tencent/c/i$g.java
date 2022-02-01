package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class i$g
{
  public Long ahhO;
  public Long ahhR;
  public Long ahhS;
  public Long ahhT;
  public Long ahhU;
  public Map<String, String> params;
  
  static g dg(Map<String, Object> paramMap)
  {
    Object localObject2 = null;
    AppMethodBeat.i(229144);
    g localg = new g();
    Object localObject1 = paramMap.get("playerId");
    if (localObject1 == null)
    {
      localObject1 = null;
      localg.ahhO = ((Long)localObject1);
      localObject1 = paramMap.get("effectId");
      if (localObject1 == null)
      {
        localObject1 = null;
        localg.ahhT = ((Long)localObject1);
        localObject1 = paramMap.get("effectType");
        if (localObject1 != null) {
          break label217;
        }
        localObject1 = null;
        localg.ahhU = ((Long)localObject1);
        localObject1 = paramMap.get("startTimeMs");
        if (localObject1 != null) {
          break label252;
        }
        localObject1 = null;
        localg.ahhR = ((Long)localObject1);
        localObject1 = paramMap.get("endTimeMs");
        if (localObject1 != null) {
          break label287;
        }
        localObject1 = localObject2;
        localg.ahhS = ((Long)localObject1);
        localg.params = ((Map)paramMap.get("params"));
        AppMethodBeat.o(229144);
        return localg;
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
    label217:
    if ((localObject1 instanceof Integer)) {}
    for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
    label252:
    if ((localObject1 instanceof Integer)) {}
    for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
    label287:
    if ((localObject1 instanceof Integer)) {}
    for (l = ((Integer)localObject1).intValue();; l = ((Long)localObject1).longValue())
    {
      localObject1 = Long.valueOf(l);
      break;
    }
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229149);
    HashMap localHashMap = new HashMap();
    localHashMap.put("playerId", this.ahhO);
    localHashMap.put("effectId", this.ahhT);
    localHashMap.put("effectType", this.ahhU);
    localHashMap.put("startTimeMs", this.ahhR);
    localHashMap.put("endTimeMs", this.ahhS);
    localHashMap.put("params", this.params);
    AppMethodBeat.o(229149);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.c.i.g
 * JD-Core Version:    0.7.0.1
 */