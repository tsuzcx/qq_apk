package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  private long dPl;
  private long dYD;
  
  public final String RD()
  {
    AppMethodBeat.i(209229);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209229);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209230);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209230);
    return localObject;
  }
  
  public final int getId()
  {
    return 19952;
  }
  
  public final br gx(long paramLong)
  {
    this.dYD = paramLong;
    return this;
  }
  
  public final br gy(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */