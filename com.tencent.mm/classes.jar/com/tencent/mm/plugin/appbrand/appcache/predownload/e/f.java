package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fn;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends fn
  implements b
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  static final String[] kJX;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44443);
    kJX = new String[] { "appId", "scene" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[6];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[7];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "scene";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "launchProtoBlob";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("launchProtoBlob", "BLOB");
    ((StringBuilder)localObject2).append(" launchProtoBlob BLOB");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "startTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("startTime", "LONG");
    ((StringBuilder)localObject2).append(" startTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "endTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("endTime", "LONG");
    ((StringBuilder)localObject2).append(" endTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "reportId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("reportId", "LONG");
    ((StringBuilder)localObject2).append(" reportId LONG");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    iBg = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY ( ";
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
    Object localObject3 = iBg;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44443);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
  
  public final String[] getKeys()
  {
    return kJX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.f
 * JD-Core Version:    0.7.0.1
 */