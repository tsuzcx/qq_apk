package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qt
  extends a
{
  public long ikE;
  private String imN = "";
  public long imY;
  public long imZ;
  private String jtw = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369238);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369238);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369244);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeId:").append(this.jtw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369244);
    return localObject;
  }
  
  public final int getId()
  {
    return 22613;
  }
  
  public final qt xT(String paramString)
  {
    AppMethodBeat.i(369225);
    this.imN = F("ChatName", paramString, true);
    AppMethodBeat.o(369225);
    return this;
  }
  
  public final qt xU(String paramString)
  {
    AppMethodBeat.i(369232);
    this.jtw = F("NoticeId", paramString, true);
    AppMethodBeat.o(369232);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qt
 * JD-Core Version:    0.7.0.1
 */