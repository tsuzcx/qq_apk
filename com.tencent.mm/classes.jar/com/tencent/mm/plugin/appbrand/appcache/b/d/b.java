package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.s;
import com.tencent.mm.plugin.appbrand.r.b.a;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends s
  implements com.tencent.mm.plugin.appbrand.r.b
{
  static final c.a fkk;
  static final String[] gUa;
  
  static
  {
    AppMethodBeat.i(129503);
    gUa = new String[] { "appId", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).yrK = new Field[5];
    ((c.a)localObject1).columns = new String[6];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).yrM.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).yrM.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "source";
    ((c.a)localObject1).yrM.put("source", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" source INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "hitCount";
    ((c.a)localObject1).yrM.put("hitCount", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" hitCount INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "reportId";
    ((c.a)localObject1).yrM.put("reportId", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" reportId INTEGER default '0' ");
    ((c.a)localObject1).columns[5] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fkk = (c.a)localObject1;
    localObject1 = new StringBuilder();
    localObject2 = fkk;
    ((c.a)localObject2).sql += b.a.l(gUa);
    AppMethodBeat.o(129503);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.b
 * JD-Core Version:    0.7.0.1
 */