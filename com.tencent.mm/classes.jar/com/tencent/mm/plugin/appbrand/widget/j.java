package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ef;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ef
{
  public static final IAutoDBItem.MAutoDBInfo kLR;
  
  static
  {
    AppMethodBeat.i(76410);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER");
    localStringBuilder.append(" appIdHash INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pkgType";
    localMAutoDBInfo.colsMap.put("pkgType", "INTEGER");
    localStringBuilder.append(" pkgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "widgetType";
    localMAutoDBInfo.colsMap.put("widgetType", "INTEGER");
    localStringBuilder.append(" widgetType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "launchAction";
    localMAutoDBInfo.colsMap.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "jsApiInfo";
    localMAutoDBInfo.colsMap.put("jsApiInfo", "BLOB");
    localStringBuilder.append(" jsApiInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "versionInfo";
    localMAutoDBInfo.colsMap.put("versionInfo", "BLOB");
    localStringBuilder.append(" versionInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "widgetSetting";
    localMAutoDBInfo.colsMap.put("widgetSetting", "BLOB");
    localStringBuilder.append(" widgetSetting BLOB");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    kLR = localMAutoDBInfo;
    AppMethodBeat.o(76410);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return kLR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.j
 * JD-Core Version:    0.7.0.1
 */