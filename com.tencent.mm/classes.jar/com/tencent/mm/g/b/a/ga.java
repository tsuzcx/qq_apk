package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ga
  extends a
{
  public long eHz;
  public long eIq;
  public long eIr = 0L;
  public long ejA;
  public long erW;
  public long erY = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(19864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(19864);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(19865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelfSendMsg:").append(this.eIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.eHz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CopyLen:").append(this.eIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19865);
    return localObject;
  }
  
  public final int getId()
  {
    return 18712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ga
 * JD-Core Version:    0.7.0.1
 */