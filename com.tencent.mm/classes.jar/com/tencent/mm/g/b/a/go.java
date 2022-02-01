package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class go
  extends a
{
  private long dMB = 0L;
  private long ehl;
  public long ehm = 0L;
  public long ehn = 0L;
  private long eho = 0L;
  private String ehp;
  
  public final String PV()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eho);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehp);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.ehl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.ehm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.ehn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dMB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eho);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.ehp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
  
  public final go mh(String paramString)
  {
    AppMethodBeat.i(94858);
    this.ehp = t("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.go
 * JD-Core Version:    0.7.0.1
 */