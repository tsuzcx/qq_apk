package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jq
  extends a
{
  public long iNl;
  public long iUv;
  public long iUw;
  public long iUx;
  public long iUy;
  public String imN = "";
  public long ipv;
  
  public final String aIE()
  {
    AppMethodBeat.i(368513);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iUy);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368513);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatType:").append(this.iNl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topStatus:").append(this.iUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.ipv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clipStatus:").append(this.iUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rownumAbsolute:").append(this.iUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("unreadCount:").append(this.iUy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368518);
    return localObject;
  }
  
  public final int getId()
  {
    return 23513;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jq
 * JD-Core Version:    0.7.0.1
 */