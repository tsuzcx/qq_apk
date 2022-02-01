package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qv
  extends a
{
  public long iLV;
  public long iPP;
  public long ioV;
  public long iqr;
  public String iwX = "";
  public String jtS = "";
  public long jtT;
  
  public final String aIE()
  {
    AppMethodBeat.i(369236);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369236);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369243);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.iwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VoiceId:").append(this.jtS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalTime:").append(this.iPP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StopReason:").append(this.jtT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayTime:").append(this.iLV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369243);
    return localObject;
  }
  
  public final int getId()
  {
    return 25041;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qv
 * JD-Core Version:    0.7.0.1
 */