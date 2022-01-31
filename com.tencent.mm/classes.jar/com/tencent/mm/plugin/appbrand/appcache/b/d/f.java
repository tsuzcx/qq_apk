package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.h.c.dl;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends dl
  implements b
{
  static final c.a dUa;
  static final String[] fCT;
  
  static
  {
    int i = 0;
    fCT = new String[] { "appId", "scene" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).ujL = new Field[6];
    ((c.a)localObject1).columns = new String[7];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).ujN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "scene";
    ((c.a)localObject1).ujN.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "launchProtoBlob";
    ((c.a)localObject1).ujN.put("launchProtoBlob", "BLOB");
    ((StringBuilder)localObject2).append(" launchProtoBlob BLOB");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "startTime";
    ((c.a)localObject1).ujN.put("startTime", "LONG");
    ((StringBuilder)localObject2).append(" startTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "endTime";
    ((c.a)localObject1).ujN.put("endTime", "LONG");
    ((StringBuilder)localObject2).append(" endTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "reportId";
    ((c.a)localObject1).ujN.put("reportId", "LONG");
    ((StringBuilder)localObject2).append(" reportId LONG");
    ((c.a)localObject1).columns[6] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    dUa = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = fCT;
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
    Object localObject3 = dUa;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  public final String[] getKeys()
  {
    return fCT;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.d.f
 * JD-Core Version:    0.7.0.1
 */