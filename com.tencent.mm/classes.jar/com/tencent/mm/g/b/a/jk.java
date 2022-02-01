package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jk
  extends a
{
  private long eAr;
  public long eAs = 0L;
  public long eAt = 0L;
  private long eAu = 0L;
  private String eAv;
  private long eca = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eAr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAv);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.eAr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.eAs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.eAt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eAu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.eAv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
  
  public final jk rT(String paramString)
  {
    AppMethodBeat.i(94858);
    this.eAv = t("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jk
 * JD-Core Version:    0.7.0.1
 */