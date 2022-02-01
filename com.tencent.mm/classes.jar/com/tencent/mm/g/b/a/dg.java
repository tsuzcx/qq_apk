package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  public long dQB;
  public long dWt;
  public long dZW = 0L;
  public long egK;
  public long egL = 0L;
  public long egc;
  
  public final String RC()
  {
    AppMethodBeat.i(19864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(19864);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(19865);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SelfSendMsg:").append(this.egK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.egc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CopyLen:").append(this.egL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
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