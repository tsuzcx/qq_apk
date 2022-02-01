package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class al
  extends fb
{
  static final String[] jHZ;
  static final c.a jJU;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44328);
    jHZ = new String[] { "appId", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IBL = new Field[4];
    ((c.a)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IBN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).IBN.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "hit";
    ((c.a)localObject1).IBN.put("hit", "INTEGER");
    ((StringBuilder)localObject2).append(" hit INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "hitTimeMS";
    ((c.a)localObject1).IBN.put("hitTimeMS", "LONG");
    ((StringBuilder)localObject2).append(" hitTimeMS LONG");
    ((c.a)localObject1).columns[4] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    jJU = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
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
    Object localObject3 = jJU;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44328);
  }
  
  public final c.a getDBInfo()
  {
    return jJU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */