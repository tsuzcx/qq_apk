package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.k;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class c
  extends k
{
  public static IAutoDBItem.MAutoDBInfo qRM;
  static final String[] qRN;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44704);
    qRN = new String[] { "username", "fetchType" };
    qRM = aJm();
    String str = " PRIMARY KEY ( ";
    Object localObject1 = qRN;
    int j = localObject1.length;
    while (i < j)
    {
      localObject2 = localObject1[i];
      str = str + ", " + (String)localObject2;
      i += 1;
    }
    str = str.replaceFirst(",", "");
    str = str + " )";
    localObject1 = new StringBuilder();
    Object localObject2 = qRM;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(44704);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return qRM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.c
 * JD-Core Version:    0.7.0.1
 */