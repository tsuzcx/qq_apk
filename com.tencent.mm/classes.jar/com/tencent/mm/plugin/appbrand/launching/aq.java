package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.fq;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class aq
  extends fq
{
  static final String[] nDP;
  static final IAutoDBItem.MAutoDBInfo nFK;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(232699);
    nDP = new String[] { "appId", "versionDesc" };
    Object localObject1 = new IAutoDBItem.MAutoDBInfo();
    ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[3];
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[4];
    Object localObject2 = new StringBuilder();
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "appId";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("appId", "TEXT");
    ((StringBuilder)localObject2).append(" appId TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "versionDesc";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionDesc", "TEXT");
    ((StringBuilder)localObject2).append(" versionDesc TEXT");
    ((StringBuilder)localObject2).append(", ");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "devKey";
    ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("devKey", "LONG");
    ((StringBuilder)localObject2).append(" devKey LONG");
    ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "rowid";
    ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
    nFK = (IAutoDBItem.MAutoDBInfo)localObject1;
    localObject1 = " PRIMARY KEY (";
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
    Object localObject3 = nFK;
    ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
    AppMethodBeat.o(232699);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aq
 * JD-Core Version:    0.7.0.1
 */