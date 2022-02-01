package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  private String dSb;
  private String dTd;
  private long dUZ;
  private long dWB;
  private String dZs;
  
  public final String RD()
  {
    AppMethodBeat.i(184190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184190);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184191);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184191);
    return localObject;
  }
  
  public final int getId()
  {
    return 19433;
  }
  
  public final ca hc(long paramLong)
  {
    this.dWB = paramLong;
    return this;
  }
  
  public final ca hd(long paramLong)
  {
    this.dUZ = paramLong;
    return this;
  }
  
  public final ca le(String paramString)
  {
    AppMethodBeat.i(184188);
    this.dZs = t("Action", paramString, true);
    AppMethodBeat.o(184188);
    return this;
  }
  
  public final ca lf(String paramString)
  {
    AppMethodBeat.i(184189);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(184189);
    return this;
  }
  
  public final ca lg(String paramString)
  {
    AppMethodBeat.i(209249);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209249);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */