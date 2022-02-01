package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  private long dPl;
  private String dSb;
  private String dWK;
  
  public final String RD()
  {
    AppMethodBeat.i(184163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184163);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184164);
    return localObject;
  }
  
  public final be fa(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19431;
  }
  
  public final be jw(String paramString)
  {
    AppMethodBeat.i(184161);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(184161);
    return this;
  }
  
  public final be jx(String paramString)
  {
    AppMethodBeat.i(184162);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(184162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */