package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ik
  extends a
{
  private long eOF;
  private String els = "";
  
  public final String abV()
  {
    AppMethodBeat.i(237196);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(237196);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(237197);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeType:").append(this.eOF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(237197);
    return localObject;
  }
  
  public final int getId()
  {
    return 21183;
  }
  
  public final ik rq(long paramLong)
  {
    this.eOF = paramLong;
    return this;
  }
  
  public final ik wi(String paramString)
  {
    AppMethodBeat.i(237195);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(237195);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik
 * JD-Core Version:    0.7.0.1
 */