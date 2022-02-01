package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fn
  extends a
{
  public String iHK = "";
  public String iHS = "";
  public long iHT;
  public long ioV;
  public long izR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368047);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368047);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368051);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickId:").append(this.iHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostId:").append(this.iHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.izR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTab:").append(this.iHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368051);
    return localObject;
  }
  
  public final int getId()
  {
    return 21149;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fn
 * JD-Core Version:    0.7.0.1
 */