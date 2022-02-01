package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fd;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends fd
  implements b
{
  static final c.a hEe;
  static final String[] jFa;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44437);
    jFa = new String[] { "appId", "type", "version", "packageKey", "packageType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IhA = new Field[16];
    ((c.a)localObject1).columns = new String[17];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IhC.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).IhC.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "type";
    ((c.a)localObject1).IhC.put("type", "INTEGER");
    ((StringBuilder)localObject2).append(" type INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "retryTimes";
    ((c.a)localObject1).IhC.put("retryTimes", "INTEGER");
    ((StringBuilder)localObject2).append(" retryTimes INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "retriedCount";
    ((c.a)localObject1).IhC.put("retriedCount", "INTEGER");
    ((StringBuilder)localObject2).append(" retriedCount INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "retryInterval";
    ((c.a)localObject1).IhC.put("retryInterval", "LONG");
    ((StringBuilder)localObject2).append(" retryInterval LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "networkType";
    ((c.a)localObject1).IhC.put("networkType", "INTEGER");
    ((StringBuilder)localObject2).append(" networkType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[7] = "pkgMd5";
    ((c.a)localObject1).IhC.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[8] = "packageKey";
    ((c.a)localObject1).IhC.put("packageKey", "TEXT");
    ((StringBuilder)localObject2).append(" packageKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[9] = "packageType";
    ((c.a)localObject1).IhC.put("packageType", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" packageType INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[10] = "lastRetryTime";
    ((c.a)localObject1).IhC.put("lastRetryTime", "LONG");
    ((StringBuilder)localObject2).append(" lastRetryTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[11] = "firstTimeTried";
    ((c.a)localObject1).IhC.put("firstTimeTried", "INTEGER");
    ((StringBuilder)localObject2).append(" firstTimeTried INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[12] = "reportId";
    ((c.a)localObject1).IhC.put("reportId", "INTEGER");
    ((StringBuilder)localObject2).append(" reportId INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[13] = "splitDownloadURLCgi";
    ((c.a)localObject1).IhC.put("splitDownloadURLCgi", "INTEGER");
    ((StringBuilder)localObject2).append(" splitDownloadURLCgi INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[14] = "scene";
    ((c.a)localObject1).IhC.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[15] = "cmdSequence";
    ((c.a)localObject1).IhC.put("cmdSequence", "LONG");
    ((StringBuilder)localObject2).append(" cmdSequence LONG");
    ((c.a)localObject1).columns[16] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hEe = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = jFa;
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
    Object localObject3 = hEe;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44437);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
  
  public final String[] getKeys()
  {
    return jFa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.c
 * JD-Core Version:    0.7.0.1
 */