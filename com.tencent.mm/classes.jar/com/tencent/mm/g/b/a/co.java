package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class co
  extends a
{
  public long dCQ;
  public long dHY;
  public long dKB = 0L;
  public long dPV;
  public long dPW = 0L;
  public long dPn;
  
  public final String PR()
  {
    AppMethodBeat.i(19864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(19864);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(19865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelfSendMsg:").append(this.dPV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dPn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CopyLen:").append(this.dPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19865);
    return localObject;
  }
  
  public final int getId()
  {
    return 18712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.co
 * JD-Core Version:    0.7.0.1
 */