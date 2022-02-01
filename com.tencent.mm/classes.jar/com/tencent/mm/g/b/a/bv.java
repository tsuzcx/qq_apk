package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  private String dSb;
  private long ear;
  
  public final String RD()
  {
    AppMethodBeat.i(209240);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ear);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209240);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209241);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.ear);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209241);
    return localObject;
  }
  
  public final bv gN(long paramLong)
  {
    this.ear = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final bv kO(String paramString)
  {
    AppMethodBeat.i(209239);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209239);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bv
 * JD-Core Version:    0.7.0.1
 */