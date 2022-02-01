package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class do
  extends a
{
  public long iAd;
  public long iAe;
  public long iAf;
  public long iAg;
  public long iAh;
  public long iAi;
  private String ijl = "";
  public long ipV;
  private String iwJ = "";
  public long iwf;
  private String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368416);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAi);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368416);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368421);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.iAd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.iAe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.iAf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.iAg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iwf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.iAh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.iAi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368421);
    return localObject;
  }
  
  public final int getId()
  {
    return 20713;
  }
  
  public final do nA(String paramString)
  {
    AppMethodBeat.i(368407);
    this.iwJ = F("ExtraInfo", paramString, true);
    AppMethodBeat.o(368407);
    return this;
  }
  
  public final do ny(String paramString)
  {
    AppMethodBeat.i(368395);
    this.ixm = F("Sessionid", paramString, true);
    AppMethodBeat.o(368395);
    return this;
  }
  
  public final do nz(String paramString)
  {
    AppMethodBeat.i(368401);
    this.ijl = F("ClickTabContextid", paramString, true);
    AppMethodBeat.o(368401);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.do
 * JD-Core Version:    0.7.0.1
 */