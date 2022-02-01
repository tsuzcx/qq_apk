package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class rx
  extends a
{
  public String ipx = "";
  public int iuF;
  public String jwS = "";
  public String jwT = "";
  public int jwU;
  public int jwV;
  
  public final String aIE()
  {
    AppMethodBeat.i(368625);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jwS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jwV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368625);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368634);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("requestid:").append(this.jwS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("message:").append(this.jwT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontype:").append(this.jwU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pagetype:").append(this.jwV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368634);
    return localObject;
  }
  
  public final int getId()
  {
    return 23012;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.rx
 * JD-Core Version:    0.7.0.1
 */