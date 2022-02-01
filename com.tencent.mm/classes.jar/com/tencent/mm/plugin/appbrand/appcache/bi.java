package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.he;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.j;
import java.lang.reflect.Field;
import java.util.Map;

public final class bi
  extends he
  implements b
{
  static final c.a hlR;
  public static final String[] hlS;
  static final String[] jpj;
  
  static
  {
    AppMethodBeat.i(182787);
    jpj = new String[] { "pluginAppID", "pluginAppVersion" };
    Object localObject1 = new c.a();
    ((c.a)localObject1).GvF = new Field[3];
    ((c.a)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((c.a)localObject1).columns[0] = "pluginAppID";
    ((c.a)localObject1).GvH.put("pluginAppID", "TEXT");
    ((StringBuilder)localObject2).append(" pluginAppID TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[1] = "pluginAppVersion";
    ((c.a)localObject1).GvH.put("pluginAppVersion", "INTEGER");
    ((StringBuilder)localObject2).append(" pluginAppVersion INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((c.a)localObject1).columns[2] = "pluginStringVersion";
    ((c.a)localObject1).GvH.put("pluginStringVersion", "TEXT");
    ((StringBuilder)localObject2).append(" pluginStringVersion TEXT");
    ((c.a)localObject1).columns[3] = "rowid";
    ((c.a)localObject1).sql = ((StringBuilder)localObject2).toString();
    hlR = (c.a)localObject1;
    localObject1 = " PRIMARY KEY (";
    localObject2 = jpj;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localObject1 = (String)localObject1 + ", " + (String)localObject3;
      i += 1;
    }
    localObject1 = ((String)localObject1).replaceFirst(",", "");
    localObject1 = (String)localObject1 + " )";
    localObject2 = new StringBuilder();
    Object localObject3 = hlR;
    ((c.a)localObject3).sql = (((c.a)localObject3).sql + "," + (String)localObject1);
    hlS = new String[] { j.getCreateSQLs(hlR, "WxaPluginCodeVersionInfo") };
    AppMethodBeat.o(182787);
  }
  
  public final c.a getDBInfo()
  {
    return hlR;
  }
  
  public final String[] getKeys()
  {
    return jpj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bi
 * JD-Core Version:    0.7.0.1
 */