package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.h.c.j;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends j
{
  public static c.a fKL;
  static final String[] fKM;
  
  static
  {
    int i = 0;
    fKM = new String[] { "username", "fetchType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).ujL = new Field[7];
    ((c.a)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "username";
    ((c.a)localObject1).ujN.put("username", "TEXT");
    ((StringBuilder)localObject2).append(" username TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "fetchType";
    ((c.a)localObject1).ujN.put("fetchType", "INTEGER");
    ((StringBuilder)localObject2).append(" fetchType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "updateTime";
    ((c.a)localObject1).ujN.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "path";
    ((c.a)localObject1).ujN.put("path", "TEXT");
    ((StringBuilder)localObject2).append(" path TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "query";
    ((c.a)localObject1).ujN.put("query", "TEXT");
    ((StringBuilder)localObject2).append(" query TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[5] = "scene";
    ((c.a)localObject1).ujN.put("scene", "INTEGER");
    ((StringBuilder)localObject2).append(" scene INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[6] = "data";
    ((c.a)localObject1).ujN.put("data", "TEXT");
    ((StringBuilder)localObject2).append(" data TEXT");
    ((c.a)localObject1).columns[7] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fKL = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = fKM;
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
    Object localObject3 = fKL;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  protected final c.a rM()
  {
    return fKL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.c
 * JD-Core Version:    0.7.0.1
 */