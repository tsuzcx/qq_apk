package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dr;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class aa
  extends dr
{
  static final String[] gUa;
  static final c.a gUb;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(129406);
    gUa = new String[] { "key", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).yrK = new Field[4];
    ((c.a)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "key";
    ((c.a)localObject1).yrM.put("key", "TEXT");
    ((StringBuilder)localObject2).append(" key TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).yrM.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "scene";
    ((c.a)localObject1).yrM.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "updateTime";
    ((c.a)localObject1).yrM.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((c.a)localObject1).columns[4] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    gUb = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
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
    Object localObject3 = gUb;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(129406);
  }
  
  public final c.a getDBInfo()
  {
    return gUb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */