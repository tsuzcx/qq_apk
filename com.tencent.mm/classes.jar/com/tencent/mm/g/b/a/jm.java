package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jm
  extends a
{
  private long eCa;
  public long eCb = 0L;
  public long eCc = 0L;
  private long eCd = 0L;
  private String eCe = "";
  private long edv = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(94859);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCe);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94859);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpenimUin:").append(this.eCa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionType:").append(this.eCb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OptionResult:").append(this.eCc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAction:").append(this.eCd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenimUsername:").append(this.eCe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94860);
    return localObject;
  }
  
  public final int getId()
  {
    return 18337;
  }
  
  public final jm so(String paramString)
  {
    AppMethodBeat.i(94858);
    this.eCe = t("OpenimUsername", paramString, true);
    AppMethodBeat.o(94858);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jm
 * JD-Core Version:    0.7.0.1
 */