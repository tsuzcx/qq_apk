package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  private long dQB;
  private long dZW;
  
  public final String RC()
  {
    AppMethodBeat.i(189264);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189264);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189265);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189265);
    return localObject;
  }
  
  public final br gA(long paramLong)
  {
    this.dZW = paramLong;
    return this;
  }
  
  public final br gB(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19952;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */