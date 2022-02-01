package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hf
  extends a
{
  public long iCW;
  public long iNA;
  public int iNr;
  public int iNs;
  public int iNt;
  public long iNu;
  public long iNv;
  public long iNw;
  public long iNx;
  public long iNy;
  public long iNz;
  
  public final String aIE()
  {
    AppMethodBeat.i(369032);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369032);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369039);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Mode:").append(this.iNr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.iNs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasModeChanged:").append(this.iNt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LaunchCost:").append(this.iNu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RestoreFromPIPCost:").append(this.iNv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartPSS:").append(this.iNw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AveragePSS:").append(this.iNx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndPSS:").append(this.iNy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.iCW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BootCost:").append(this.iNz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SlowFrameRate:").append(this.iNA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369039);
    return localObject;
  }
  
  public final int getId()
  {
    return 23581;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.hf
 * JD-Core Version:    0.7.0.1
 */