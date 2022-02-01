package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.il;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;
import java.util.Map;

public final class br
  extends il
  implements b
{
  static final IAutoDBItem.MAutoDBInfo lqK;
  public static final String[] lqL;
  static final String[] nIh;
  
  static
  {
    AppMethodBeat.i(182787);
    nIh = new String[] { "pluginAppID", "pluginAppVersion" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[3];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "pluginAppID";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pluginAppID", "TEXT");
    ((StringBuilder)localObject2).append(" pluginAppID TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "pluginAppVersion";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pluginAppVersion", "INTEGER");
    ((StringBuilder)localObject2).append(" pluginAppVersion INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "pluginStringVersion";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pluginStringVersion", "TEXT");
    ((StringBuilder)localObject2).append(" pluginStringVersion TEXT");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    lqK = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = nIh;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localObject1 = (String)localObject1 + ", " + (String)localObject3;
      i += 1;
    }
    localObject1 = ((String)localObject1).replaceFirst(",", "");
    localObject1 = (String)localObject1 + " )";
    localObject2 = new StringBuilder();
    Object localObject3 = lqK;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    lqL = new String[] { MAutoStorage.getCreateSQLs(lqK, "WxaPluginCodeVersionInfo") };
    AppMethodBeat.o(182787);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
  
  public final String[] getKeys()
  {
    return nIh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.br
 * JD-Core Version:    0.7.0.1
 */