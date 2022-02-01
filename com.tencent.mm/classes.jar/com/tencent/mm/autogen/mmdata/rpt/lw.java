package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lw
  extends a
{
  public long jau = 0L;
  private String jav = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(149928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jav);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149928);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.jau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.jav);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149929);
    return localObject;
  }
  
  public final int getId()
  {
    return 16868;
  }
  
  public final lw uz(String paramString)
  {
    AppMethodBeat.i(162225);
    this.jav = F("emoticonMd5", paramString, true);
    AppMethodBeat.o(162225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lw
 * JD-Core Version:    0.7.0.1
 */