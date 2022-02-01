package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.x;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bh
  extends g
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  static final String[] qHh;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146004);
    qHh = new String[] { "appId", "version", "debugType" };
    nVV = x.aJm();
    String str = " PRIMARY KEY (";
    Object localObject1 = qHh;
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
    Object localObject2 = nVV;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(146004);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bh
 * JD-Core Version:    0.7.0.1
 */