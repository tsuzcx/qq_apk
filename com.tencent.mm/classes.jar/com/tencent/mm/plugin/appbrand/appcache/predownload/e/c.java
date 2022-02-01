package com.tencent.mm.plugin.appbrand.appcache.predownload.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fl;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fl
  implements b
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  static final String[] kJX;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44437);
    kJX = new String[] { "appId", "type", "version", "packageKey", "packageType" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[16];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[17];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "version";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "type";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("type", "INTEGER");
    ((StringBuilder)localObject2).append(" type INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "retryTimes";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("retryTimes", "INTEGER");
    ((StringBuilder)localObject2).append(" retryTimes INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "retriedCount";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("retriedCount", "INTEGER");
    ((StringBuilder)localObject2).append(" retriedCount INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "retryInterval";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("retryInterval", "LONG");
    ((StringBuilder)localObject2).append(" retryInterval LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "networkType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("networkType", "INTEGER");
    ((StringBuilder)localObject2).append(" networkType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[7] = "pkgMd5";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[8] = "packageKey";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("packageKey", "TEXT");
    ((StringBuilder)localObject2).append(" packageKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[9] = "packageType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("packageType", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" packageType INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[10] = "lastRetryTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("lastRetryTime", "LONG");
    ((StringBuilder)localObject2).append(" lastRetryTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[11] = "firstTimeTried";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("firstTimeTried", "INTEGER");
    ((StringBuilder)localObject2).append(" firstTimeTried INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[12] = "reportId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("reportId", "INTEGER");
    ((StringBuilder)localObject2).append(" reportId INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[13] = "splitDownloadURLCgi";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("splitDownloadURLCgi", "INTEGER");
    ((StringBuilder)localObject2).append(" splitDownloadURLCgi INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[14] = "scene";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[15] = "cmdSequence";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("cmdSequence", "LONG");
    ((StringBuilder)localObject2).append(" cmdSequence LONG");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[16] = "rowid";
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
    AppMethodBeat.o(44437);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.e.c
 * JD-Core Version:    0.7.0.1
 */