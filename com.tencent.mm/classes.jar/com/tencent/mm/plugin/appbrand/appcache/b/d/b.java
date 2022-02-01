package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.x;
import com.tencent.mm.plugin.appbrand.y.b.a;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends x
  implements com.tencent.mm.plugin.appbrand.y.b
{
  static final c.a hlR;
  static final String[] jlk;
  
  static
  {
    AppMethodBeat.i(44430);
    jlk = new String[] { "appId", "version", "packageType", "packageKey" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).GvF = new Field[7];
    ((c.a)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).GvH.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).GvH.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "packageType";
    ((c.a)localObject1).GvH.put("packageType", "INTEGER");
    ((StringBuilder)localObject2).append(" packageType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "packageKey";
    ((c.a)localObject1).GvH.put("packageKey", "TEXT");
    ((StringBuilder)localObject2).append(" packageKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "source";
    ((c.a)localObject1).GvH.put("source", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" source INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "hitCount";
    ((c.a)localObject1).GvH.put("hitCount", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" hitCount INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "reportId";
    ((c.a)localObject1).GvH.put("reportId", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" reportId INTEGER default '0' ");
    ((c.a)localObject1).columns[7] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hlR = (c.a)localObject1;
    localObject1 = new StringBuilder();
    localObject2 = hlR;
    ((c.a)localObject2).sql += b.a.r(jlk);
    AppMethodBeat.o(44430);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
  
  public final String[] getKeys()
  {
    return jlk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.b
 * JD-Core Version:    0.7.0.1
 */