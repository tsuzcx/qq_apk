package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends t
  implements b
{
  static final c.a hGW;
  public static final String[] hGX;
  public static final String[] jHZ;
  
  static
  {
    AppMethodBeat.i(180190);
    jHZ = new String[] { "appId", "appVersion" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IBL = new Field[3];
    ((c.a)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IBN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "appVersion";
    ((c.a)localObject1).IBN.put("appVersion", "INTEGER");
    ((StringBuilder)localObject2).append(" appVersion INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "isSeparatedPluginsUsed";
    ((c.a)localObject1).IBN.put("isSeparatedPluginsUsed", "INTEGER");
    ((StringBuilder)localObject2).append(" isSeparatedPluginsUsed INTEGER");
    ((c.a)localObject1).columns[3] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hGW = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = jHZ;
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
    Object localObject3 = hGW;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    hGX = new String[] { j.getCreateSQLs(hGW, "AppBrandSeparatedPluginsCompatMarkTable") };
    AppMethodBeat.o(180190);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.a
 * JD-Core Version:    0.7.0.1
 */