package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fe;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

public final class al
  extends fe
  implements b
{
  static final c.a hEe;
  static final String[] jFa;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90559);
    jFa = new String[] { "appId", "type", "version" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).IhA = new Field[5];
    ((c.a)localObject1).columns = new String[6];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "appId";
    ((c.a)localObject1).IhC.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "version";
    ((c.a)localObject1).IhC.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "type";
    ((c.a)localObject1).IhC.put("type", "INTEGER");
    ((StringBuilder)localObject2).append(" type INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[3] = "pkgMd5";
    ((c.a)localObject1).IhC.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[4] = "pkgPath";
    ((c.a)localObject1).IhC.put("pkgPath", "TEXT");
    ((StringBuilder)localObject2).append(" pkgPath TEXT");
    ((c.a)localObject1).columns[5] = "rowid";
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
    AppMethodBeat.o(90559);
  }
  
  public final c.a getDBInfo()
  {
    return hEe;
  }
  
  public final String[] getKeys()
  {
    return jFa;
  }
  
  public final String toShortString()
  {
    AppMethodBeat.i(90558);
    String str = String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", new Object[] { this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version) });
    AppMethodBeat.o(90558);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.al
 * JD-Core Version:    0.7.0.1
 */