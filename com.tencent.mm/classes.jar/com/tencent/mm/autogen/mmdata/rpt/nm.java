package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nm
  extends a
{
  public String inx = "";
  public long jfm;
  
  public final String aIE()
  {
    AppMethodBeat.i(367857);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367857);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367864);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exposeType:").append(this.jfm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367864);
    return localObject;
  }
  
  public final int getId()
  {
    return 21183;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nm
 * JD-Core Version:    0.7.0.1
 */