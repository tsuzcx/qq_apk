package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ih
  extends a
{
  public String iPG = "";
  public int iPR = 0;
  public long iPS = 0L;
  public long iPT = 0L;
  public long iPU = 0L;
  public int iPV = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(369188);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369188);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369195);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartType:").append(this.iPR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessTime:").append(this.iPS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BusinessTime:").append(this.iPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllTime:").append(this.iPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendStr:").append(this.iPG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartReason:").append(this.iPV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369195);
    return localObject;
  }
  
  public final int getId()
  {
    return 22023;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ih
 * JD-Core Version:    0.7.0.1
 */