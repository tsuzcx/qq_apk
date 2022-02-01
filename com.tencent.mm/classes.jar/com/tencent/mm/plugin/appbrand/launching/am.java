package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ig;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;
import java.util.Map;

public final class am
  extends ig
  implements b
{
  public static final String[] lqL;
  public static final String[] nDP;
  static final IAutoDBItem.MAutoDBInfo nFK;
  
  static
  {
    AppMethodBeat.i(276291);
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[4];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "appType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appType", "INTEGER");
    ((StringBuilder)localObject2).append(" appType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "versionType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "permissionBytes";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("permissionBytes", "BLOB");
    ((StringBuilder)localObject2).append(" permissionBytes BLOB");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    nFK = (IAutoDBItem.MAutoDBInfo)localObject1;
    nDP = new String[] { "appId", "appType", "versionType" };
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = nDP;
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
    Object localObject3 = nFK;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    lqL = new String[] { MAutoStorage.getCreateSQLs(nFK, "WxaAppidABTestInfo") };
    AppMethodBeat.o(276291);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nFK;
  }
  
  public final String[] getKeys()
  {
    return nDP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.am
 * JD-Core Version:    0.7.0.1
 */