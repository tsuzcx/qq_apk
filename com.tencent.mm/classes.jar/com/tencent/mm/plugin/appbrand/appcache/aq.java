package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gq;
import com.tencent.mm.plugin.appbrand.ae.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class aq
  extends gq
  implements b
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  static final String[] qDJ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90564);
    qDJ = new String[] { "appId", "appVersion" };
    nVV = aJm();
    String str = " PRIMARY KEY ( ";
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
    Object localObject2 = nVV;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(90564);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String[] getKeys()
  {
    return qDJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aq
 * JD-Core Version:    0.7.0.1
 */