package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ef
  extends a
{
  private long eBJ;
  private String eiB = "";
  private long ejA;
  
  public final String abV()
  {
    AppMethodBeat.i(209219);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209219);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209220);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.eBJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209220);
    return localObject;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final ef lI(long paramLong)
  {
    this.eBJ = paramLong;
    return this;
  }
  
  public final ef lJ(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final ef qL(String paramString)
  {
    AppMethodBeat.i(209218);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209218);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ef
 * JD-Core Version:    0.7.0.1
 */