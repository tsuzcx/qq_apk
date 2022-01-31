package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.h.c.n;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class m
  extends n
{
  public static final String[] fCT;
  public static final c.a fCU;
  
  static
  {
    int i = 0;
    fCT = new String[] { "username", "versionType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).ujL = new Field[3];
    ((c.a)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "username";
    ((c.a)localObject1).ujN.put("username", "TEXT");
    ((StringBuilder)localObject2).append(" username TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "versionType";
    ((c.a)localObject1).ujN.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "updateTime";
    ((c.a)localObject1).ujN.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((c.a)localObject1).columns[3] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    fCU = (c.a)localObject1;
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
    Object localObject3 = fCU;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
  }
  
  protected final c.a rM()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.m
 * JD-Core Version:    0.7.0.1
 */