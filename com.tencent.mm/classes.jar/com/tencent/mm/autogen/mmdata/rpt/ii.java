package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ii
  extends a
{
  private String iPs = "";
  private String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369199);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iPs);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369199);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369204);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OperationList:").append(this.iPs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369204);
    return localObject;
  }
  
  public final int getId()
  {
    return 21767;
  }
  
  public final ii rL(String paramString)
  {
    AppMethodBeat.i(369190);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(369190);
    return this;
  }
  
  public final ii rM(String paramString)
  {
    AppMethodBeat.i(369196);
    this.iPs = F("OperationList", paramString, true);
    AppMethodBeat.o(369196);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ii
 * JD-Core Version:    0.7.0.1
 */