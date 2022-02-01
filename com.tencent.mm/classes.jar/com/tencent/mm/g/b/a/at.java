package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  private long dCQ;
  private String dFe;
  private String dJb;
  
  public final String PR()
  {
    AppMethodBeat.i(184163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184163);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184164);
    return localObject;
  }
  
  public final at ef(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19431;
  }
  
  public final at hZ(String paramString)
  {
    AppMethodBeat.i(184161);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(184161);
    return this;
  }
  
  public final at ia(String paramString)
  {
    AppMethodBeat.i(184162);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(184162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */