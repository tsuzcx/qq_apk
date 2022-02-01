package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  public String iBQ = "";
  public String iKA = "";
  public String iKB = "";
  public long iKC;
  public long iKD;
  public long iKE;
  public long iKF;
  public long iKG;
  public long ijn;
  public String ilK = "";
  public String ipU = "";
  public long ixI;
  
  public final String aIE()
  {
    AppMethodBeat.i(367986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKG);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367986);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367992);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionId:").append(this.ilK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.ixI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionId:").append(this.iKA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestId:").append(this.iBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.iKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchScene:").append(this.iKC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.iKD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.ijn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchResultType:").append(this.iKE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAccountEmpty:").append(this.iKF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFeedEmpty:").append(this.iKG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367992);
    return localObject;
  }
  
  public final int getId()
  {
    return 21690;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ge
 * JD-Core Version:    0.7.0.1
 */