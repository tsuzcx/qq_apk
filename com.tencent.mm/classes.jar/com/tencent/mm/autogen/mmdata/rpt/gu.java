package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  public long iAZ;
  public long iBa;
  public String iBc = "";
  public String ijk = "";
  public String iyA = "";
  public String iyB = "";
  private long iyC;
  public long iyD;
  
  public final String aIE()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.iAZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.iBa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.iyA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.iyB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.iyC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.iyD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.iBc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final int getId()
  {
    return 19187;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gu
 * JD-Core Version:    0.7.0.1
 */