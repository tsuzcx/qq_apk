package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class j$j
{
  public String LYS;
  public Long ahin;
  private String ahio;
  
  static j dk(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(229258);
    j localj = new j();
    Object localObject = paramMap.get("fiderObjectId");
    if (localObject == null)
    {
      localObject = null;
      localj.ahin = ((Long)localObject);
      localj.LYS = ((String)paramMap.get("finderNonceId"));
      localj.ahio = ((String)paramMap.get("finderThumb"));
      AppMethodBeat.o(229258);
      return localj;
    }
    if ((localObject instanceof Integer)) {}
    for (long l = ((Integer)localObject).intValue();; l = ((Long)localObject).longValue())
    {
      localObject = Long.valueOf(l);
      break;
    }
  }
  
  final Map<String, Object> jRw()
  {
    AppMethodBeat.i(229263);
    HashMap localHashMap = new HashMap();
    localHashMap.put("fiderObjectId", this.ahin);
    localHashMap.put("finderNonceId", this.LYS);
    localHashMap.put("finderThumb", this.ahio);
    AppMethodBeat.o(229263);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.j.j
 * JD-Core Version:    0.7.0.1
 */