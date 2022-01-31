package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.z;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends z
{
  public static c.a fkk;
  
  static
  {
    AppMethodBeat.i(14394);
    c.a locala = new c.a();
    locala.yrK = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appMsgReportContextId";
    locala.yrM.put("appMsgReportContextId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "appMsgReportContextId";
    locala.columns[1] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportTime";
    locala.yrM.put("reportTime", "LONG");
    localStringBuilder.append(" reportTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "aScene";
    locala.yrM.put("aScene", "INTEGER");
    localStringBuilder.append(" aScene INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    fkk = locala;
    AppMethodBeat.o(14394);
  }
  
  public a() {}
  
  public a(eq parameq)
  {
    this.field_url = parameq.Url;
    this.field_reportTime = parameq.wqL;
  }
  
  public final c.a getDBInfo()
  {
    return fkk;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(14393);
    String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
    AppMethodBeat.o(14393);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a
 * JD-Core Version:    0.7.0.1
 */