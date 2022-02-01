package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
  extends a
{
  public String ipq = "";
  public long ipr;
  public long ips = 0L;
  public long ipt = 0L;
  public long ipu = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.ipq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.ipr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.ipt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.ipu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.as
 * JD-Core Version:    0.7.0.1
 */