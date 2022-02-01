package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class m
  extends a
{
  public String dFr = "";
  public long dFs;
  public long dFt = 0L;
  public long dFu = 0L;
  public long dFv = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.dFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.dFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.dFu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.dFv);
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
 * Qualified Name:     com.tencent.mm.g.b.a.m
 * JD-Core Version:    0.7.0.1
 */