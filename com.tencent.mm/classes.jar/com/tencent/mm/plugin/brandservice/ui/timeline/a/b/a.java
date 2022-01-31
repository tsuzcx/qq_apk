package com.tencent.mm.plugin.brandservice.ui.timeline.a.b;

import com.tencent.mm.h.c.y;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends y
{
  public static c.a dUa;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appMsgReportContextId";
    locala.ujN.put("appMsgReportContextId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "appMsgReportContextId";
    locala.columns[1] = "url";
    locala.ujN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportTime";
    locala.ujN.put("reportTime", "LONG");
    localStringBuilder.append(" reportTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "aScene";
    locala.ujN.put("aScene", "INTEGER");
    localStringBuilder.append(" aScene INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    dUa = locala;
  }
  
  public a() {}
  
  public a(dp paramdp)
  {
    this.field_url = paramdp.kSC;
    this.field_reportTime = paramdp.sxc;
  }
  
  protected final c.a rM()
  {
    return dUa;
  }
  
  public final String toString()
  {
    return "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.a
 * JD-Core Version:    0.7.0.1
 */