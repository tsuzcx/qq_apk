package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  public long dPl;
  public long dVd;
  public long dYD = 0L;
  public long eeC;
  public long efj;
  public long efk = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(19864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(19864);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(19865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelfSendMsg:").append(this.efj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.eeC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CopyLen:").append(this.efk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dg
 * JD-Core Version:    0.7.0.1
 */