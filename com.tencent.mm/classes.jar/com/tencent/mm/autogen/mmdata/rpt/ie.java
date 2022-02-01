package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  public int iPE;
  public int iPF = 0;
  public String iPG = "";
  public int imW;
  
  public final String aIE()
  {
    AppMethodBeat.i(369210);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iPE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369210);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369213);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Enable:").append(this.iPE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendInt:").append(this.iPF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendStr:").append(this.iPG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369213);
    return localObject;
  }
  
  public final int getId()
  {
    return 22421;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ie
 * JD-Core Version:    0.7.0.1
 */