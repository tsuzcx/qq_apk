package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ek
  extends a
{
  public String dWq = "";
  private long dXG;
  public long ebq;
  public String ebr = "";
  public long ebu;
  
  public final String RC()
  {
    AppMethodBeat.i(201319);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(201319);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(201320);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.dXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.ebu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.ebr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201320);
    return localObject;
  }
  
  public final int getId()
  {
    return 20491;
  }
  
  public final ek ki(long paramLong)
  {
    AppMethodBeat.i(201318);
    this.dXG = paramLong;
    super.bh("EnterTimeStampMs", this.dXG);
    AppMethodBeat.o(201318);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ek
 * JD-Core Version:    0.7.0.1
 */