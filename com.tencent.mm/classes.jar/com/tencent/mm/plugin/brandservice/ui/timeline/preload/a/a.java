package com.tencent.mm.plugin.brandservice.ui.timeline.preload.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ae;
import com.tencent.mm.protocal.protobuf.fh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends ae
{
  public static c.a gLr;
  
  static
  {
    AppMethodBeat.i(6187);
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appMsgReportContextId";
    locala.EYv.put("appMsgReportContextId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" appMsgReportContextId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "appMsgReportContextId";
    locala.columns[1] = "url";
    locala.EYv.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "reportTime";
    locala.EYv.put("reportTime", "LONG");
    localStringBuilder.append(" reportTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "aScene";
    locala.EYv.put("aScene", "INTEGER");
    localStringBuilder.append(" aScene INTEGER");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    gLr = locala;
    AppMethodBeat.o(6187);
  }
  
  public a() {}
  
  public a(fh paramfh)
  {
    this.field_url = paramfh.Url;
    this.field_reportTime = paramfh.CzW;
  }
  
  public final c.a getDBInfo()
  {
    return gLr;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6186);
    String str = "BizAppMsgReportContext{field_appMsgReportContextId=" + this.field_appMsgReportContextId + ", field_url='" + this.field_url + '\'' + ", field_reportTime=" + this.field_reportTime + ", field_aScene=" + this.field_aScene + '}';
    AppMethodBeat.o(6186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.a.a
 * JD-Core Version:    0.7.0.1
 */