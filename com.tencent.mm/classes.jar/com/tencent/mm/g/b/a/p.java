package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public long dSA = 0L;
  public String dSw = "";
  public long dSx;
  public long dSy = 0L;
  public long dSz = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSA);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dSx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.dSA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.p
 * JD-Core Version:    0.7.0.1
 */