package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  private String dHr;
  private long dKY;
  private long dKk;
  private String dLe;
  private String dLx;
  
  public final String PV()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dLx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dLx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dKk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dKY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final am dS(long paramLong)
  {
    this.dKk = paramLong;
    return this;
  }
  
  public final am dT(long paramLong)
  {
    this.dKY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final am hA(String paramString)
  {
    AppMethodBeat.i(190566);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(190566);
    return this;
  }
  
  public final am hy(String paramString)
  {
    AppMethodBeat.i(184188);
    this.dLx = t("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final am hz(String paramString)
  {
    AppMethodBeat.i(184189);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */