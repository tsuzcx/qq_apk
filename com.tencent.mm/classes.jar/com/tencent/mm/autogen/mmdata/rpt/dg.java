package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  public String ijk = "";
  private long ize;
  public String izf = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ize);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368464);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.ize);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.izf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368471);
    return localObject;
  }
  
  public final dg eH(long paramLong)
  {
    AppMethodBeat.i(368455);
    this.ize = paramLong;
    super.by("EnterTimeStampMs", this.ize);
    AppMethodBeat.o(368455);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dg
 * JD-Core Version:    0.7.0.1
 */