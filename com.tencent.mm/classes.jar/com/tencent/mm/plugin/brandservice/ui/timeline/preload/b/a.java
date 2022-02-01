package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ag;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class a
  extends ag
{
  public static IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(6187);
    nVV = aJm();
    AppMethodBeat.o(6187);
  }
  
  public a() {}
  
  public a(gj paramgj)
  {
    this.field_url = paramgj.Url;
    this.field_reportTime = paramgj.YIa;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
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
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.a
 * JD-Core Version:    0.7.0.1
 */