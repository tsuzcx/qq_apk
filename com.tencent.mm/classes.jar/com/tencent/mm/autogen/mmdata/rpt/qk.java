package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qk
  extends a
{
  public String jrQ = "";
  public String jrR = "";
  public int jrS = 0;
  public int jrT = 0;
  public long jrU;
  public long jrV;
  public long jrW;
  
  public final String aIE()
  {
    AppMethodBeat.i(369264);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jrQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369264);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369269);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SrcPageName:").append(this.jrQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DestPageName:").append(this.jrR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SrcPageType:").append(this.jrS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DestPageType:").append(this.jrT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Start2OnCreateCost:").append(this.jrU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Start2AnimBeginCost:").append(this.jrV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Start2AnimEndCost:").append(this.jrW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369269);
    return localObject;
  }
  
  public final int getId()
  {
    return 24933;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qk
 * JD-Core Version:    0.7.0.1
 */