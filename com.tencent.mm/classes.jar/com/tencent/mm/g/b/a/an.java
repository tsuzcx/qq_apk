package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class an
  extends a
{
  private String dTr = "";
  private long dXG;
  private String dXH = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189106);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189106);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189107);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.dXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.dXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189107);
    return localObject;
  }
  
  public final an dg(long paramLong)
  {
    AppMethodBeat.i(189103);
    this.dXG = paramLong;
    super.bh("EnterTimeStampMs", this.dXG);
    AppMethodBeat.o(189103);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final an hQ(String paramString)
  {
    AppMethodBeat.i(189104);
    this.dXH = t("FinerUsername", paramString, true);
    AppMethodBeat.o(189104);
    return this;
  }
  
  public final an hR(String paramString)
  {
    AppMethodBeat.i(189105);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189105);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.an
 * JD-Core Version:    0.7.0.1
 */