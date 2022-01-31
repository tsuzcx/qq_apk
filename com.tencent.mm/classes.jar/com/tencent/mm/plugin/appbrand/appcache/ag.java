package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ag
  extends dy
  implements b
{
  static final c.a fkk;
  static final String[] gUa;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(59451);
    gUa = new String[] { "appId", "appVersion" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).yrK = new Field[5];
    ((c.a)localObject1).columns = new String[6];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).yrM.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "appVersion";
    ((c.a)localObject1).yrM.put("appVersion", "INTEGER");
    ((StringBuilder)localObject2).append(" appVersion INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "decryptKey";
    ((c.a)localObject1).yrM.put("decryptKey", "TEXT");
    ((StringBuilder)localObject2).append(" decryptKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "pkgMd5";
    ((c.a)localObject1).yrM.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "reportId";
    ((c.a)localObject1).yrM.put("reportId", "INTEGER");
    ((StringBuilder)localObject2).append(" reportId INTEGER");
    ((c.a)localObject1).columns[5] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fkk = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = gUa;
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
    Object localObject3 = fkk;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(59451);
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
  
  public final String[] getKeys()
  {
    return gUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ag
 * JD-Core Version:    0.7.0.1
 */