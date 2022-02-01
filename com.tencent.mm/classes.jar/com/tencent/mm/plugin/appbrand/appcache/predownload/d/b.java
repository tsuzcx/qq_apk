package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.x;
import com.tencent.mm.plugin.appbrand.ab.b.a;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class b
  extends x
  implements com.tencent.mm.plugin.appbrand.ab.b
{
  static final IAutoDBItem.MAutoDBInfo lqK;
  static final String[] nDP;
  
  static
  {
    AppMethodBeat.i(44430);
    nDP = new String[] { "appId", "version", "packageType", "packageKey" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[7];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[8];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "version";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("version", "INTEGER");
    ((StringBuilder)localObject2).append(" version INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "packageType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("packageType", "INTEGER");
    ((StringBuilder)localObject2).append(" packageType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "packageKey";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("packageKey", "TEXT");
    ((StringBuilder)localObject2).append(" packageKey TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "source";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("source", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" source INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[5] = "hitCount";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("hitCount", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" hitCount INTEGER default '0' ");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[6] = "reportId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("reportId", "INTEGER default '0' ");
    ((StringBuilder)localObject2).append(" reportId INTEGER default '0' ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[7] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    lqK = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = new StringBuilder();
    localObject2 = lqK;
    ((IAutoDBItem.MAutoDBInfo)localObject2).sql += b.a.s(nDP);
    AppMethodBeat.o(44430);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
  
  public final String[] getKeys()
  {
    return nDP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d.b
 * JD-Core Version:    0.7.0.1
 */