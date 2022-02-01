package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.af;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends af
{
  public static IAutoDBItem.MAutoDBInfo iBg;
  
  static
  {
    AppMethodBeat.i(6187);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appMsgReportContextId";
    localMAutoDBInfo.colsMap.put("appMsgReportContextId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appMsgReportContextId";
    localMAutoDBInfo.columns[1] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "reportTime";
    localMAutoDBInfo.colsMap.put("reportTime", "LONG");
    localStringBuilder.append(" reportTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "aScene";
    localMAutoDBInfo.colsMap.put("aScene", "INTEGER");
    localStringBuilder.append(" aScene INTEGER");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    iBg = localMAutoDBInfo;
    AppMethodBeat.o(6187);
  }
  
  public a() {}
  
  public a(gb paramgb)
  {
    this.field_url = paramgb.Url;
    this.field_reportTime = paramgb.KJQ;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return iBg;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6186);
    String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
    AppMethodBeat.o(6186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a
 * JD-Core Version:    0.7.0.1
 */