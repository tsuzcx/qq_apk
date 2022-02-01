package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  private String iPs = "";
  private String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369235);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369235);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationList:").append(this.iPs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369241);
    return localObject;
  }
  
  public final int getId()
  {
    return 21771;
  }
  
  public final ib rJ(String paramString)
  {
    AppMethodBeat.i(369220);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369220);
    return this;
  }
  
  public final ib rK(String paramString)
  {
    AppMethodBeat.i(369228);
    this.iPs = F("OperationList", paramString, true);
    AppMethodBeat.o(369228);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ib
 * JD-Core Version:    0.7.0.1
 */