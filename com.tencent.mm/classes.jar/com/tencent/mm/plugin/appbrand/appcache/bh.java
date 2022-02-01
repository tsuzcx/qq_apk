package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.w;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class bh
  extends g
{
  static final IAutoDBItem.MAutoDBInfo lqK;
  static final String[] nHu;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146004);
    nHu = new String[] { "appId", "version", "debugType" };
    lqK = w.aoY();
    String str = " PRIMARY KEY (";
    Object localObject1 = nHu;
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
    Object localObject2 = lqK;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql = (((IAutoDBItem.MAutoDBInfo)localObject2).sql + "," + str);
    AppMethodBeat.o(146004);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bh
 * JD-Core Version:    0.7.0.1
 */