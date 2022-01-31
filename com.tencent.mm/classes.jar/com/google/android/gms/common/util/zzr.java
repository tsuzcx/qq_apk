package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class zzr
{
  public static void zza(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap)
  {
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
          break label98;
        }
        paramStringBuilder.append("null");
        break;
        i = 0;
      }
      label98:
      paramStringBuilder.append("\"").append(str2).append("\"");
    }
    paramStringBuilder.append("}");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.util.zzr
 * JD-Core Version:    0.7.0.1
 */