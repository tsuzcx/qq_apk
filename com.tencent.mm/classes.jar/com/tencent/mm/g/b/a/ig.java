package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private long dNc = 0L;
  private long ejr;
  public long ejs = 0L;
  public long ejt = 0L;
  private long eju = 0L;
  private String ejv;
  
  public final String PR()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.ejr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.ejs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dNc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.ejv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
  
  public final ig pm(String paramString)
  {
    AppMethodBeat.i(94858);
    this.ejv = t("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig
 * JD-Core Version:    0.7.0.1
 */