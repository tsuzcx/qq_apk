package com.tencent.mm.plugin.clean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class a
{
  public static String eT(List<Map.Entry<String, Long>> paramList)
  {
    AppMethodBeat.i(271842);
    if (!paramList.isEmpty())
    {
      StringBuffer localStringBuffer = new StringBuffer();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramList.next();
        localStringBuffer.append(Util.getSizeMB(((Long)localEntry.getValue()).longValue())).append(" -> ").append((String)localEntry.getKey()).append("\n");
      }
      paramList = localStringBuffer.toString();
      AppMethodBeat.o(271842);
      return paramList;
    }
    AppMethodBeat.o(271842);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.a
 * JD-Core Version:    0.7.0.1
 */