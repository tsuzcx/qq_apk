package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qi
  extends a
{
  private String iPh = "";
  public long ikE;
  public String jlW = "";
  public String jlX = "";
  private String jrH = "";
  private String jrI = "";
  private String jrJ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369293);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369293);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369300);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppID:").append(this.jrH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppName:").append(this.iPh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jrI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScopeList:").append(this.jrJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.jlW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPrivacyFullStatus:").append(this.jlX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369300);
    return localObject;
  }
  
  public final int getId()
  {
    return 24370;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qi
 * JD-Core Version:    0.7.0.1
 */