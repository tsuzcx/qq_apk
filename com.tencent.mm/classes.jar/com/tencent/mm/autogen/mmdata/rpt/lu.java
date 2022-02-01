package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lu
  extends a
{
  public long jau = 0L;
  private String jav = "";
  public long jaw = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaw);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.jau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.jav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.jaw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149925);
    return localObject;
  }
  
  public final int getId()
  {
    return 16872;
  }
  
  public final lu uy(String paramString)
  {
    AppMethodBeat.i(368082);
    this.jav = F("emoticonMd5", paramString, true);
    AppMethodBeat.o(368082);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lu
 * JD-Core Version:    0.7.0.1
 */