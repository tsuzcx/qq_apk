package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  public long dFd;
  public long dKe;
  public long dNI = 0L;
  public long dNM;
  public long dOu;
  public long dOv = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(19864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(19864);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(19865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelfSendMsg:").append(this.dOu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CopyLen:").append(this.dOv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19865);
    return localObject;
  }
  
  public final int getId()
  {
    return 18712;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bc
 * JD-Core Version:    0.7.0.1
 */