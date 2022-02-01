package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mm
  extends a
{
  public String iNB = "";
  public long ips;
  public String ipx = "";
  public String ipy = "";
  public long jbD;
  public long jbG;
  public long jbH;
  
  public final String aIE()
  {
    AppMethodBeat.i(184778);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jbD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184778);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184779);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.ipy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("todo:").append(this.jbH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openHelp:").append(this.jbG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exit:").append(this.jbD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184779);
    return localObject;
  }
  
  public final int getId()
  {
    return 19440;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mm
 * JD-Core Version:    0.7.0.1
 */