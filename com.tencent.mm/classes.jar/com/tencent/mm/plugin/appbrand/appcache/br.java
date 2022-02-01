package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jh;
import com.tencent.mm.plugin.appbrand.ae.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class br
  extends jh
  implements b
{
  static final IAutoDBItem.MAutoDBInfo nVV;
  public static final String[] nVW;
  static final String[] qHX;
  
  static
  {
    AppMethodBeat.i(182787);
    qHX = new String[] { "pluginAppID", "pluginAppVersion" };
    nVV = jh.aJm();
    String str = " PRIMARY KEY (";
    Object localObject1 = qHX;
    int j = localObject1.length;
    int i = 0;
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
    nVW = new String[] { MAutoStorage.getCreateSQLs(nVV, "WxaPluginCodeVersionInfo") };
    AppMethodBeat.o(182787);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String[] getKeys()
  {
    return qHX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.br
 * JD-Core Version:    0.7.0.1
 */