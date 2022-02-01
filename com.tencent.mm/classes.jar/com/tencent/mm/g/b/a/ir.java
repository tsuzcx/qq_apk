package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ir
  extends a
{
  public int dHr;
  public long dPp;
  public int dWe;
  public String elv;
  public String elw;
  
  public final String PR()
  {
    AppMethodBeat.i(207482);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(207482);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(207483);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dPp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.elv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.elw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dWe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207483);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ir
 * JD-Core Version:    0.7.0.1
 */