package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hk;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends hk
  implements com.tencent.mm.plugin.appbrand.y.b
{
  static final c.a hEe;
  public static final String[] hEf;
  static final String[] jFa;
  
  static
  {
    AppMethodBeat.i(47973);
    jFa = new String[] { "appId", "commLibVersionId", "appVersionId", "pageURL" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IhA = new Field[7];
    ((c.a)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IhC.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "commLibVersionId";
    ((c.a)localObject1).IhC.put("commLibVersionId", "TEXT");
    ((StringBuilder)localObject2).append(" commLibVersionId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "appVersionId";
    ((c.a)localObject1).IhC.put("appVersionId", "TEXT");
    ((StringBuilder)localObject2).append(" appVersionId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "pageURL";
    ((c.a)localObject1).IhC.put("pageURL", "TEXT");
    ((StringBuilder)localObject2).append(" pageURL TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "updateTime";
    ((c.a)localObject1).IhC.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "accessTime";
    ((c.a)localObject1).IhC.put("accessTime", "LONG");
    ((StringBuilder)localObject2).append(" accessTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "cacheFilePath";
    ((c.a)localObject1).IhC.put("cacheFilePath", "TEXT");
    ((StringBuilder)localObject2).append(" cacheFilePath TEXT");
    ((c.a)localObject1).columns[7] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hEe = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = jFa;
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
    Object localObject3 = hEe;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    hEf = new String[] { j.getCreateSQLs(hEe, "WxaAppWebRenderingCacheAccessStatsTable") };
    AppMethodBeat.o(47973);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.b
 * JD-Core Version:    0.7.0.1
 */