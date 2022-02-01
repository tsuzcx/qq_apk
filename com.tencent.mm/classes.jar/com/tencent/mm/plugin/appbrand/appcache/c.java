package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.v;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends v
  implements b
{
  static final c.a hEe;
  public static final String[] hEf;
  public static final String[] jFa;
  
  static
  {
    AppMethodBeat.i(180191);
    jFa = new String[] { "appId", "versionType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IhA = new Field[3];
    ((c.a)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IhC.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "versionType";
    ((c.a)localObject1).IhC.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "versionMd5";
    ((c.a)localObject1).IhC.put("versionMd5", "TEXT");
    ((StringBuilder)localObject2).append(" versionMd5 TEXT");
    ((c.a)localObject1).columns[3] = "rowid";
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
    hEf = new String[] { j.getCreateSQLs(hEe, "AppBrandTestCodeVersionMarkTable") };
    AppMethodBeat.o(180191);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.c
 * JD-Core Version:    0.7.0.1
 */