package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qj
  extends a
{
  public long iOd = 0L;
  public String iqX = "";
  public long iyP;
  public String jmP = "";
  public long jql = 0L;
  public long jrK = 0L;
  private int jrL = -1;
  public long jrM;
  public long jrN;
  public long jrO;
  public long jrP;
  
  public final String aIE()
  {
    AppMethodBeat.i(369296);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jrP);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369296);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369305);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickedType:").append(this.jql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.jrK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.jrL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextStatusID:").append(this.jmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSource:").append(this.jrM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSns:").append(this.jrN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasFinder:").append(this.jrO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.iyP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUserGender:").append(this.jrP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369305);
    return localObject;
  }
  
  public final int getId()
  {
    return 16055;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qj
 * JD-Core Version:    0.7.0.1
 */