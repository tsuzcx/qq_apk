package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapUtils
{
  public static <K, V> K getKeyFromMap(Map<K, V> paramMap, K paramK)
  {
    AppMethodBeat.i(5272);
    if (paramMap.containsKey(paramK))
    {
      paramMap = paramMap.keySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = paramMap.next();
        if (localObject.equals(paramK))
        {
          AppMethodBeat.o(5272);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(5272);
    return null;
  }
  
  public static void writeStringMapToJson(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(5271);
    paramStringBuilder.append("{");
    Iterator localIterator = paramHashMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i == 0) {
        paramStringBuilder.append(",");
      }
      String str2;
      for (;;)
      {
        str2 = (String)paramHashMap.get(str1);
        paramStringBuilder.append("\"").append(str1).append("\":");
        if (str2 != null) {
          break label104;
        }
        paramStringBuilder.append("null");
        break;
        i = 0;
      }
      label104:
      paramStringBuilder.append("\"").append(str2).append("\"");
    }
    paramStringBuilder.append("}");
    AppMethodBeat.o(5271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.MapUtils
 * JD-Core Version:    0.7.0.1
 */