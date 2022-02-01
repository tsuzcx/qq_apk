package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class fb
  extends a
{
  private String dTr = "";
  private long elf = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elf);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.elf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final fb Tt()
  {
    AppMethodBeat.i(94837);
    this.elf = bu.fpO();
    super.bh("ClickTimeStampMs", this.elf);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
  
  public final fb oB(String paramString)
  {
    AppMethodBeat.i(94836);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fb
 * JD-Core Version:    0.7.0.1
 */