package com.tencent.mm.plugin.appbrand.appcache.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends ff
  implements b
{
  static final c.a hGW;
  static final String[] jHZ;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44443);
    jHZ = new String[] { "appId", "scene" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IBL = new Field[6];
    ((c.a)localObject1).columns = new String[7];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IBN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "scene";
    ((c.a)localObject1).IBN.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "launchProtoBlob";
    ((c.a)localObject1).IBN.put("launchProtoBlob", "BLOB");
    ((StringBuilder)localObject2).append(" launchProtoBlob BLOB");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "startTime";
    ((c.a)localObject1).IBN.put("startTime", "LONG");
    ((StringBuilder)localObject2).append(" startTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "endTime";
    ((c.a)localObject1).IBN.put("endTime", "LONG");
    ((StringBuilder)localObject2).append(" endTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "reportId";
    ((c.a)localObject1).IBN.put("reportId", "LONG");
    ((StringBuilder)localObject2).append(" reportId LONG");
    ((c.a)localObject1).columns[6] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hGW = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = jHZ;
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
    AppMethodBeat.o(44443);
  }
  
  public final c.a getDBInfo()
  {
    return hGW;
  }
  
  public final String[] getKeys()
  {
    return jHZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.e.f
 * JD-Core Version:    0.7.0.1
 */