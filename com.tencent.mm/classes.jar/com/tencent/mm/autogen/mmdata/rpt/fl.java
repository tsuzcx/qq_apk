package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fl
  extends a
{
  public long iAH;
  public String iHK = "";
  public String iHL = "";
  public long iHM;
  public long iHN;
  public long iHO;
  private long iHP;
  
  public final String aIE()
  {
    AppMethodBeat.i(368042);
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
    ((StringBuffer)localObject).append(this.iHP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368042);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368044);
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
    ((StringBuffer)localObject).append("DeleteFlag:").append(this.iHP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368044);
    return localObject;
  }
  
  public final int getId()
  {
    return 21638;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fl
 * JD-Core Version:    0.7.0.1
 */