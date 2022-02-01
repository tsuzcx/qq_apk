package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  private String dTr = "";
  private String dUt = "";
  private long dWp;
  private long dXT;
  private String eaL = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eaL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.eaL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final ca hh(long paramLong)
  {
    this.dXT = paramLong;
    return this;
  }
  
  public final ca hi(long paramLong)
  {
    this.dWp = paramLong;
    return this;
  }
  
  public final ca lr(String paramString)
  {
    AppMethodBeat.i(184188);
    this.eaL = t("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final ca ls(String paramString)
  {
    AppMethodBeat.i(184189);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
  
  public final ca lt(String paramString)
  {
    AppMethodBeat.i(189284);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189284);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */