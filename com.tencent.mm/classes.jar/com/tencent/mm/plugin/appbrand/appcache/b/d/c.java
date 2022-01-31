package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.h.c.dj;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends dj
  implements b
{
  static final c.a dUa;
  static final String[] fCT;
  
  static
  {
    int i = 0;
    fCT = new String[] { "appId", "type", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).ujL = new Field[11];
    ((c.a)localObject1).columns = new String[12];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).ujN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).ujN.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "type";
    ((c.a)localObject1).ujN.put("type", "INTEGER");
    ((StringBuilder)localObject2).append(" type INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "retryTimes";
    ((c.a)localObject1).ujN.put("retryTimes", "INTEGER");
    ((StringBuilder)localObject2).append(" retryTimes INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "retriedCount";
    ((c.a)localObject1).ujN.put("retriedCount", "INTEGER");
    ((StringBuilder)localObject2).append(" retriedCount INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "retryInterval";
    ((c.a)localObject1).ujN.put("retryInterval", "LONG");
    ((StringBuilder)localObject2).append(" retryInterval LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "networkType";
    ((c.a)localObject1).ujN.put("networkType", "INTEGER");
    ((StringBuilder)localObject2).append(" networkType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[7] = "pkgMd5";
    ((c.a)localObject1).ujN.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[8] = "lastRetryTime";
    ((c.a)localObject1).ujN.put("lastRetryTime", "LONG");
    ((StringBuilder)localObject2).append(" lastRetryTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[9] = "firstTimeTried";
    ((c.a)localObject1).ujN.put("firstTimeTried", "INTEGER");
    ((StringBuilder)localObject2).append(" firstTimeTried INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[10] = "reportId";
    ((c.a)localObject1).ujN.put("reportId", "INTEGER");
    ((StringBuilder)localObject2).append(" reportId INTEGER");
    ((c.a)localObject1).columns[11] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    dUa = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = fCT;
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
    Object localObject3 = dUa;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  public final String[] getKeys()
  {
    return fCT;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.c
 * JD-Core Version:    0.7.0.1
 */