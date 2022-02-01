package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tv
  extends a
{
  public long iFe = 0L;
  public String ilF = "";
  public long jFe = 0L;
  public long jFf = 0L;
  public String jFg = "";
  public String jFh = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jFh);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.iFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.jFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ilF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.jFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.jFg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.jFh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116493);
    return localObject;
  }
  
  public final int getId()
  {
    return 14688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tv
 * JD-Core Version:    0.7.0.1
 */