package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  private long dPl;
  private String dSb;
  
  public final String RD()
  {
    AppMethodBeat.i(209163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209163);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209164);
    return localObject;
  }
  
  public final bd eZ(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19954;
  }
  
  public final bd jv(String paramString)
  {
    AppMethodBeat.i(209162);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bd
 * JD-Core Version:    0.7.0.1
 */