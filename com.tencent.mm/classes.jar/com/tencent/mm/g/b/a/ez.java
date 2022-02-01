package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;

public final class ez
  extends a
{
  private String dTr = "";
  public long ele = 0L;
  private long elf = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ele);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elf);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.ele);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.elf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final ez Ts()
  {
    AppMethodBeat.i(94831);
    this.elf = bu.fpO();
    super.bh("ClickTimeStampMs", this.elf);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
  
  public final ez oA(String paramString)
  {
    AppMethodBeat.i(94830);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ez
 * JD-Core Version:    0.7.0.1
 */