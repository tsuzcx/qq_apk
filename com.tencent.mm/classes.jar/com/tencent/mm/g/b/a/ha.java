package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ha
  extends a
{
  private String eiB = "";
  private int eki;
  private int enq;
  private int eqN;
  
  public final String abV()
  {
    AppMethodBeat.i(206897);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(206897);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(206898);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.eqN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(206898);
    return localObject;
  }
  
  public final ha agT()
  {
    this.enq = 3;
    return this;
  }
  
  public final int getId()
  {
    return 20379;
  }
  
  public final ha lo(int paramInt)
  {
    this.eki = paramInt;
    return this;
  }
  
  public final ha lp(int paramInt)
  {
    this.eqN = paramInt;
    return this;
  }
  
  public final ha uP(String paramString)
  {
    AppMethodBeat.i(206896);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(206896);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ha
 * JD-Core Version:    0.7.0.1
 */