package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  private long dFd;
  private String dHr;
  private String dKt;
  
  public final String PV()
  {
    AppMethodBeat.i(184163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184163);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184164);
    return localObject;
  }
  
  public final ae de(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final ae gR(String paramString)
  {
    AppMethodBeat.i(184161);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(184161);
    return this;
  }
  
  public final ae gS(String paramString)
  {
    AppMethodBeat.i(184162);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(184162);
    return this;
  }
  
  public final int getId()
  {
    return 19431;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */