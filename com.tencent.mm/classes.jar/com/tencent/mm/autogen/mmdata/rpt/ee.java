package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ee
  extends a
{
  public String iCw = "";
  public String iCx = "";
  public String iCy = "";
  public String iny = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367942);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCy);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367942);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportExtraInfo:").append(this.iCw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceFeedid:").append(this.iCx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSourceUsername:").append(this.iCy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367949);
    return localObject;
  }
  
  public final int getId()
  {
    return 21140;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ee
 * JD-Core Version:    0.7.0.1
 */