package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class ez
  extends a
{
  private String dSb = "";
  private long ejy = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.ejy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final ez Tn()
  {
    AppMethodBeat.i(94837);
    this.ejy = bt.flT();
    super.bg("ClickTimeStampMs", this.ejy);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
  
  public final ez og(String paramString)
  {
    AppMethodBeat.i(94836);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ez
 * JD-Core Version:    0.7.0.1
 */