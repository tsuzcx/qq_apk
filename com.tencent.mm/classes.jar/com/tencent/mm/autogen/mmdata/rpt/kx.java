package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kx
  extends a
{
  private String iYn = "";
  public long iYo;
  public long ijA;
  private String ijk = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iYn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368298);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368304);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.iYn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ijA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptType:").append(this.iYo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368304);
    return localObject;
  }
  
  public final int getId()
  {
    return 23677;
  }
  
  public final kx tS(String paramString)
  {
    AppMethodBeat.i(368287);
    this.iYn = F("Type", paramString, true);
    AppMethodBeat.o(368287);
    return this;
  }
  
  public final kx tT(String paramString)
  {
    AppMethodBeat.i(368292);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368292);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kx
 * JD-Core Version:    0.7.0.1
 */