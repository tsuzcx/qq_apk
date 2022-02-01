package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qk
  extends a
{
  private long gBe = 0L;
  private long gzC = 0L;
  private long hjN;
  public long hjO = 0L;
  public long hjP = 0L;
  private String hjQ = "";
  
  public final qk Hl(String paramString)
  {
    AppMethodBeat.i(94858);
    this.hjQ = z("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hjN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.hjN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.hjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.hjP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.gzC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.hjQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qk
 * JD-Core Version:    0.7.0.1
 */