package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends hx
  implements com.tencent.mm.plugin.appbrand.ab.b
{
  static final IAutoDBItem.MAutoDBInfo iBg;
  public static final String[] iBh;
  static final String[] kJX;
  
  static
  {
    AppMethodBeat.i(47973);
    kJX = new String[] { "appId", "commLibVersionId", "appVersionId", "pageURL" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[7];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "commLibVersionId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("commLibVersionId", "TEXT");
    ((StringBuilder)localObject2).append(" commLibVersionId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "appVersionId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appVersionId", "TEXT");
    ((StringBuilder)localObject2).append(" appVersionId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "pageURL";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("pageURL", "TEXT");
    ((StringBuilder)localObject2).append(" pageURL TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "updateTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "accessTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("accessTime", "LONG");
    ((StringBuilder)localObject2).append(" accessTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "cacheFilePath";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("cacheFilePath", "TEXT");
    ((StringBuilder)localObject2).append(" cacheFilePath TEXT");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[7] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    iBg = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = kJX;
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
    Object localObject3 = iBg;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    iBh = new String[] { MAutoStorage.getCreateSQLs(iBg, "WxaAppWebRenderingCacheAccessStatsTable") };
    AppMethodBeat.o(47973);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.b
 * JD-Core Version:    0.7.0.1
 */