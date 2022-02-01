package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qa
  extends a
{
  public long jpV;
  public long jpW;
  public long jpX;
  public long jpY;
  public long jpZ;
  public long jqa;
  public long jqb;
  
  public final String aIE()
  {
    AppMethodBeat.i(369038);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jpV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jpZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqb);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369038);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369044);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SingleCount:").append(this.jpV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GroupCount:").append(this.jpW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ServiceCount:").append(this.jpX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedChatTopCount:").append(this.jpY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedChatNoTopCount:").append(this.jpZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OneScreenCount:").append(this.jqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LimitRate:").append(this.jqb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369044);
    return localObject;
  }
  
  public final int getId()
  {
    return 23512;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qa
 * JD-Core Version:    0.7.0.1
 */