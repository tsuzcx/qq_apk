package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bu
  extends a
{
  public long iuA;
  public long iuB;
  public long iuC;
  private String iuz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368783);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368783);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368791);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("pid:").append(this.iuz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("channelLinkExposure:").append(this.iuB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("channelLinkClick:").append(this.iuC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368791);
    return localObject;
  }
  
  public final int getId()
  {
    return 23532;
  }
  
  public final bu ld(String paramString)
  {
    AppMethodBeat.i(368776);
    this.iuz = F("pid", paramString, true);
    AppMethodBeat.o(368776);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bu
 * JD-Core Version:    0.7.0.1
 */