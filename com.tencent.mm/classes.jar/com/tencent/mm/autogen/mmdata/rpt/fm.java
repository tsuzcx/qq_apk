package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fm
  extends a
{
  private long iAH;
  public String iHK = "";
  public String iHL = "";
  public long iHM;
  public long iHN;
  public long iHO;
  public long iHQ;
  public long iHR;
  
  public final String aIE()
  {
    AppMethodBeat.i(368046);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iHK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368046);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368048);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PostId:").append(this.iHK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.iHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.iHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.iAH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicCnt:").append(this.iHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoLen:").append(this.iHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaViewType:").append(this.iHQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewViewScene:").append(this.iHR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368048);
    return localObject;
  }
  
  public final int getId()
  {
    return 21640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fm
 * JD-Core Version:    0.7.0.1
 */