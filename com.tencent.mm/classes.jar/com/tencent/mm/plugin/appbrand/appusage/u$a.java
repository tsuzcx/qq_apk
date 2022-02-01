package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.u;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class u$a
  extends u
{
  static final IAutoDBItem.MAutoDBInfo lqK;
  static final String[] nDP;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(44576);
    nDP = new String[] { "username", "versionType" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[4];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[5];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "username";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("username", "TEXT");
    ((StringBuilder)localObject2).append(" username TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "versionType";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionType", "INTEGER");
    ((StringBuilder)localObject2).append(" versionType INTEGER");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "updateTime";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("updateTime", "LONG");
    ((StringBuilder)localObject2).append(" updateTime LONG");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "orderSequence";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("orderSequence", "LONG");
    ((StringBuilder)localObject2).append(" orderSequence LONG");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    lqK = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY ( ";
    localObject2 = nDP;
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
    Object localObject3 = lqK;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(44576);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return lqK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u.a
 * JD-Core Version:    0.7.0.1
 */