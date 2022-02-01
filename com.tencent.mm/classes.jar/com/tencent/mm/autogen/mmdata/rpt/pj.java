package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pj
  extends a
{
  private String iBL = "";
  public long ioV;
  private long iuW;
  private String jlT = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369147);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369147);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369148);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.iuW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.iBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSessionId:").append(this.jlT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369148);
    return localObject;
  }
  
  public final pj aIW()
  {
    this.iuW = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 24071;
  }
  
  public final pj wL(String paramString)
  {
    AppMethodBeat.i(369136);
    this.iBL = F("ItemId", paramString, true);
    AppMethodBeat.o(369136);
    return this;
  }
  
  public final pj wM(String paramString)
  {
    AppMethodBeat.i(369142);
    this.jlT = F("ItemSessionId", paramString, true);
    AppMethodBeat.o(369142);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pj
 * JD-Core Version:    0.7.0.1
 */