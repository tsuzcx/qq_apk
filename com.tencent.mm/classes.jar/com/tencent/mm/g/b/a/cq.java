package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
  extends a
{
  public String dVa;
  private long dWo;
  public long dZW;
  public String dZX = "";
  public long eaa;
  
  public final String RD()
  {
    AppMethodBeat.i(200895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(200895);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(200896);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.eaa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.dZX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200896);
    return localObject;
  }
  
  public final int getId()
  {
    return 20493;
  }
  
  public final cq ie(long paramLong)
  {
    AppMethodBeat.i(200894);
    this.dWo = paramLong;
    super.bg("EnterTimeStampMs", this.dWo);
    AppMethodBeat.o(200894);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq
 * JD-Core Version:    0.7.0.1
 */