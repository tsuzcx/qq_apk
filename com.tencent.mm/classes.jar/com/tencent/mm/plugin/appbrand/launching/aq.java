package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ed;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class aq
  extends ed
{
  public static final IAutoDBItem.MAutoDBInfo kLR;
  
  static
  {
    AppMethodBeat.i(146070);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "launchPB";
    localMAutoDBInfo.colsMap.put("launchPB", "BLOB");
    localStringBuilder.append(" launchPB BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    kLR = localMAutoDBInfo;
    AppMethodBeat.o(146070);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return kLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aq
 * JD-Core Version:    0.7.0.1
 */