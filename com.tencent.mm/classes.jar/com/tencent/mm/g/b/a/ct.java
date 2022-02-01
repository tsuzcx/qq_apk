package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ct
  extends a
{
  private String eiB = "";
  private long enl;
  private String erP = "";
  private long etR;
  
  public final String abV()
  {
    AppMethodBeat.i(220157);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220157);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.etR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220158);
    return localObject;
  }
  
  public final long acK()
  {
    return this.etR;
  }
  
  public final long acL()
  {
    return this.enl;
  }
  
  public final String acu()
  {
    return this.erP;
  }
  
  public final int getId()
  {
    return 21919;
  }
  
  public final String getSessionId()
  {
    return this.eiB;
  }
  
  public final ct hO(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final ct hP(long paramLong)
  {
    AppMethodBeat.i(220155);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220155);
    return this;
  }
  
  public final ct nu(String paramString)
  {
    AppMethodBeat.i(220154);
    this.erP = x("ActionResult", paramString, true);
    AppMethodBeat.o(220154);
    return this;
  }
  
  public final ct nv(String paramString)
  {
    AppMethodBeat.i(220156);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(220156);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ct
 * JD-Core Version:    0.7.0.1
 */