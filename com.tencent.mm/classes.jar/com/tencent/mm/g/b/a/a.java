package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.plugin.report.a
{
  public long dFb;
  public String dFc;
  public long dFd = 0L;
  public String dFe;
  
  public final String PV()
  {
    AppMethodBeat.i(185997);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(185997);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(185998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Requestcode:").append(this.dFb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProcessName:").append(this.dFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(185998);
    return localObject;
  }
  
  public final int getId()
  {
    return 19574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.a
 * JD-Core Version:    0.7.0.1
 */