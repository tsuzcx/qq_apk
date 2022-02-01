package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class eb
  extends a
{
  private String dFe = "";
  private long dTl = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.dTl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final eb Rg()
  {
    AppMethodBeat.i(94837);
    this.dTl = bs.eWj();
    super.bd("ClickTimeStampMs", this.dTl);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
  
  public final eb lW(String paramString)
  {
    AppMethodBeat.i(94836);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eb
 * JD-Core Version:    0.7.0.1
 */