package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bf;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class r
  extends bf
{
  static final IAutoDBItem.MAutoDBInfo DB_INFO;
  static final String[] qDJ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146064);
    qDJ = new String[] { "appId", "versionType" };
    DB_INFO = bf.aJm();
    String str = " PRIMARY KEY (";
    Object localObject1 = qDJ;
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
    Object localObject2 = DB_INFO;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(146064);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r
 * JD-Core Version:    0.7.0.1
 */