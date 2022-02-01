package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.j;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends j
{
  public static IAutoDBItem.MAutoDBInfo nSc;
  static final String[] nSd;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44704);
    nSd = new String[] { "username", "fetchType" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[7];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "username";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("username", "TEXT");
    ((StringBuilder)localObject2).append(" username TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "fetchType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("fetchType", "INTEGER");
    ((StringBuilder)localObject2).append(" fetchType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "updateTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "path";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("path", "TEXT");
    ((StringBuilder)localObject2).append(" path TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "query";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("query", "TEXT");
    ((StringBuilder)localObject2).append(" query TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "scene";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "data";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("data", "TEXT");
    ((StringBuilder)localObject2).append(" data TEXT");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[7] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    nSc = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = nSd;
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
    Object localObject3 = nSc;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44704);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nSc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.c
 * JD-Core Version:    0.7.0.1
 */