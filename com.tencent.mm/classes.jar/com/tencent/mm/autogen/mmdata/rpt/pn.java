package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pn
  extends a
{
  private int jmK = -1;
  private int jmL = -1;
  private String jmM = "";
  public int jmN = -1;
  
  public final String aIE()
  {
    AppMethodBeat.i(369106);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jmK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmN);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369106);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369112);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IsComeScene:").append(this.jmK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSolve:").append(this.jmL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgExt:").append(this.jmM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isHit:").append(this.jmN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369112);
    return localObject;
  }
  
  public final int getId()
  {
    return 22021;
  }
  
  public final pn wU(String paramString)
  {
    AppMethodBeat.i(369101);
    this.jmM = F("MsgExt", paramString, true);
    AppMethodBeat.o(369101);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pn
 * JD-Core Version:    0.7.0.1
 */