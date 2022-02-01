package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class an
  extends a
{
  private String dSb = "";
  private long dWo;
  private String dWp = "";
  
  public final String RD()
  {
    AppMethodBeat.i(209076);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209076);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209077);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.dWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209077);
    return localObject;
  }
  
  public final an dg(long paramLong)
  {
    AppMethodBeat.i(209073);
    this.dWo = paramLong;
    super.bg("EnterTimeStampMs", this.dWo);
    AppMethodBeat.o(209073);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final an hI(String paramString)
  {
    AppMethodBeat.i(209074);
    this.dWp = t("FinerUsername", paramString, true);
    AppMethodBeat.o(209074);
    return this;
  }
  
  public final an hJ(String paramString)
  {
    AppMethodBeat.i(209075);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209075);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.an
 * JD-Core Version:    0.7.0.1
 */