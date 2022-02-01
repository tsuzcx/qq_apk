package com.tencent.mm.plugin.datareport.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class a
{
  public static boolean anH()
  {
    AppMethodBeat.i(262815);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger()))
    {
      AppMethodBeat.o(262815);
      return true;
    }
    AppMethodBeat.o(262815);
    return false;
  }
  
  public static String d(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(262825);
    if ((paramArrayOfStackTraceElement == null) || (paramArrayOfStackTraceElement.length <= 0))
    {
      AppMethodBeat.o(262825);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("\r\n");
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfStackTraceElement[i].toString()).append("\r\n");
      i += 1;
    }
    paramArrayOfStackTraceElement = localStringBuilder.toString();
    AppMethodBeat.o(262825);
    return paramArrayOfStackTraceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.j.a
 * JD-Core Version:    0.7.0.1
 */