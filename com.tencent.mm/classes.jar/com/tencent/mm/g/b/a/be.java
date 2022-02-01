package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class be
  extends a
{
  private long dQB;
  private String dTr = "";
  private String dYc = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184163);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184163);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184164);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184164);
    return localObject;
  }
  
  public final be fd(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19431;
  }
  
  public final be jI(String paramString)
  {
    AppMethodBeat.i(184161);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(184161);
    return this;
  }
  
  public final be jJ(String paramString)
  {
    AppMethodBeat.i(184162);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(184162);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.be
 * JD-Core Version:    0.7.0.1
 */