package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.h.c.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class g
  extends au
{
  static final String[] fCT;
  static final c.a fCU;
  
  static
  {
    int i = 0;
    fCT = new String[] { "appId", "versionType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).ujL = new Field[3];
    ((c.a)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).ujN.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "versionType";
    ((c.a)localObject1).ujN.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "extJson";
    ((c.a)localObject1).ujN.put("extJson", "TEXT");
    ((StringBuilder)localObject2).append(" extJson TEXT");
    ((c.a)localObject1).columns[3] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fCU = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
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
    Object localObject3 = fCU;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */