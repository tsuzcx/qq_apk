package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.u;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class u$a
  extends u
{
  static final c.a hEe;
  static final String[] jFa;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44576);
    jFa = new String[] { "username", "versionType" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IhA = new Field[4];
    ((c.a)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "username";
    ((c.a)localObject1).IhC.put("username", "TEXT");
    ((StringBuilder)localObject2).append(" username TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "versionType";
    ((c.a)localObject1).IhC.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "updateTime";
    ((c.a)localObject1).IhC.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "orderSequence";
    ((c.a)localObject1).IhC.put("orderSequence", "LONG");
    ((StringBuilder)localObject2).append(" orderSequence LONG");
    ((c.a)localObject1).columns[4] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hEe = (c.a)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = jFa;
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
    Object localObject3 = hEe;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44576);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u.a
 * JD-Core Version:    0.7.0.1
 */