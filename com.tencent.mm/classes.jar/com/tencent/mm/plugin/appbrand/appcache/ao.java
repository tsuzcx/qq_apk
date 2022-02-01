package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fp;
import com.tencent.mm.plugin.appbrand.ab.b;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class ao
  extends fp
  implements b
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  static final String[] kJX;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90564);
    kJX = new String[] { "appId", "appVersion" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[5];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[6];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "appVersion";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appVersion", "INTEGER");
    ((StringBuilder)localObject2).append(" appVersion INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "decryptKey";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("decryptKey", "TEXT");
    ((StringBuilder)localObject2).append(" decryptKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "pkgMd5";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pkgMd5", "TEXT");
    ((StringBuilder)localObject2).append(" pkgMd5 TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "reportId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("reportId", "INTEGER");
    ((StringBuilder)localObject2).append(" reportId INTEGER");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    iBg = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = kJX;
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
    Object localObject3 = iBg;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(90564);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
  
  public final String[] getKeys()
  {
    return kJX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ao
 * JD-Core Version:    0.7.0.1
 */