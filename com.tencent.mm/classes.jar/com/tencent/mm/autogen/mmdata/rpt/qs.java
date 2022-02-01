package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qs
  extends a
{
  public String imN = "";
  public long imY;
  public long imZ;
  public long iuA;
  public long jtv;
  public String jtw = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369263);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369263);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369267);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.imZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isMuteRoom:").append(this.jtv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeId:").append(this.jtw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369267);
    return localObject;
  }
  
  public final int getId()
  {
    return 22600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qs
 * JD-Core Version:    0.7.0.1
 */