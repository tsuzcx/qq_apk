package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  public String giM = "";
  public long giN;
  public long giO = 0L;
  public long giP = 0L;
  public long giQ = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.giM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.giN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.giO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.giP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.giQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ak
 * JD-Core Version:    0.7.0.1
 */