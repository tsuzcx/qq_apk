package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.w;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class bd
  extends w
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  public static final String[] kNu;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146004);
    kNu = new String[] { "appId", "version", "debugType" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[10];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[11];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "version";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "versionMd5";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionMd5", "TEXT");
    ((StringBuilder)localObject2).append(" versionMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "NewMd5";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("NewMd5", "TEXT");
    ((StringBuilder)localObject2).append(" NewMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "pkgPath";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pkgPath", "TEXT");
    ((StringBuilder)localObject2).append(" pkgPath TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "createTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("createTime", "LONG");
    ((StringBuilder)localObject2).append(" createTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "debugType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("debugType", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" debugType INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[7] = "downloadURL";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("downloadURL", "TEXT");
    ((StringBuilder)localObject2).append(" downloadURL TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[8] = "startTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("startTime", "LONG");
    ((StringBuilder)localObject2).append(" startTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[9] = "endTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("endTime", "LONG");
    ((StringBuilder)localObject2).append(" endTime LONG");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[10] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    iBg = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = kNu;
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
    AppMethodBeat.o(146004);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bd
 * JD-Core Version:    0.7.0.1
 */