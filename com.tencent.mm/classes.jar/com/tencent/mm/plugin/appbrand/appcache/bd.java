package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.w;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bd
  extends w
{
  static final c.a hGW;
  public static final String[] jLv;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(146004);
    jLv = new String[] { "appId", "version", "debugType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IBL = new Field[10];
    ((c.a)localObject1).columns = new String[11];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IBN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).IBN.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "versionMd5";
    ((c.a)localObject1).IBN.put("versionMd5", "TEXT");
    ((StringBuilder)localObject2).append(" versionMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "NewMd5";
    ((c.a)localObject1).IBN.put("NewMd5", "TEXT");
    ((StringBuilder)localObject2).append(" NewMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "pkgPath";
    ((c.a)localObject1).IBN.put("pkgPath", "TEXT");
    ((StringBuilder)localObject2).append(" pkgPath TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "createTime";
    ((c.a)localObject1).IBN.put("createTime", "LONG");
    ((StringBuilder)localObject2).append(" createTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "debugType";
    ((c.a)localObject1).IBN.put("debugType", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" debugType INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[7] = "downloadURL";
    ((c.a)localObject1).IBN.put("downloadURL", "TEXT");
    ((StringBuilder)localObject2).append(" downloadURL TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[8] = "startTime";
    ((c.a)localObject1).IBN.put("startTime", "LONG");
    ((StringBuilder)localObject2).append(" startTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[9] = "endTime";
    ((c.a)localObject1).IBN.put("endTime", "LONG");
    ((StringBuilder)localObject2).append(" endTime LONG");
    ((c.a)localObject1).columns[10] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hGW = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = jLv;
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
    Object localObject3 = hGW;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(146004);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bd
 * JD-Core Version:    0.7.0.1
 */