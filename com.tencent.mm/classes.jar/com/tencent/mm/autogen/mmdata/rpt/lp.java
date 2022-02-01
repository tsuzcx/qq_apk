package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lp
  extends a
{
  private String ijk = "";
  public int ilm;
  public int imW;
  public int inj;
  
  public final String aIE()
  {
    AppMethodBeat.i(368142);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368142);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368148);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.inj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368148);
    return localObject;
  }
  
  public final int getId()
  {
    return 20379;
  }
  
  public final lp ux(String paramString)
  {
    AppMethodBeat.i(368136);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368136);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lp
 * JD-Core Version:    0.7.0.1
 */