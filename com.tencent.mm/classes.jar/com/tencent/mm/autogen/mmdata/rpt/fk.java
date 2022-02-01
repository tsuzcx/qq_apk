package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fk
  extends a
{
  public String iHI = "";
  public String iHJ = "";
  public String ijk = "";
  public String ivZ = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368040);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHJ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368040);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368043);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.iHI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.iHJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368043);
    return localObject;
  }
  
  public final int getId()
  {
    return 19792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fk
 * JD-Core Version:    0.7.0.1
 */