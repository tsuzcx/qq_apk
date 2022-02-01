package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bd;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends bd
{
  static final String[] kJX;
  static final IAutoDBItem.MAutoDBInfo kLR;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146064);
    kJX = new String[] { "appId", "versionType" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[3];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "versionType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "extJson";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("extJson", "TEXT");
    ((StringBuilder)localObject2).append(" extJson TEXT");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    kLR = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = kJX;
    int j = localObject2.length;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localObject1 = (String)localObject1 + ", " + (String)localObject3;
      i += 1;
    }
    localObject1 = ((String)localObject1).replaceFirst(",", "");
    localObject1 = (String)localObject1 + " )";
    localObject2 = new StringBuilder();
    Object localObject3 = kLR;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(146064);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r
 * JD-Core Version:    0.7.0.1
 */