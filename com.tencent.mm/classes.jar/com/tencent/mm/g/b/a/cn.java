package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class cn
  extends a
{
  private String dHr = "";
  private long dRx = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRx);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.dRx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final cn QE()
  {
    AppMethodBeat.i(94837);
    this.dRx = bt.eGO();
    super.bb("ClickTimeStampMs", this.dRx);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
  
  public final cn jg(String paramString)
  {
    AppMethodBeat.i(94836);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn
 * JD-Core Version:    0.7.0.1
 */