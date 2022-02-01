package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  private String dTr = "";
  private long ebL;
  
  public final String RC()
  {
    AppMethodBeat.i(189275);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebL);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189275);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.ebL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189276);
    return localObject;
  }
  
  public final bv gS(long paramLong)
  {
    this.ebL = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19947;
  }
  
  public final bv lb(String paramString)
  {
    AppMethodBeat.i(189274);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189274);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bv
 * JD-Core Version:    0.7.0.1
 */