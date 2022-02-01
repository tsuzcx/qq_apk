package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class no
  extends a
{
  public int ilm;
  public int imW;
  public int jfr;
  public String jfs = "";
  private String jft = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(367821);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jfs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jft);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367821);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContentType:").append(this.jfr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OwnerUsername:").append(this.jfs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderFeedID:").append(this.jft);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367832);
    return localObject;
  }
  
  public final int getId()
  {
    return 23665;
  }
  
  public final no vJ(String paramString)
  {
    AppMethodBeat.i(367812);
    this.jft = F("FinderFeedID", paramString, true);
    AppMethodBeat.o(367812);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.no
 * JD-Core Version:    0.7.0.1
 */