package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public String dTM = "";
  public long dTN;
  public long dTO = 0L;
  public long dTP = 0L;
  public long dTQ = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTQ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.dTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.dTQ);
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