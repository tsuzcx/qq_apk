package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  public long iAd;
  public long iAe;
  public long iAf;
  public long iAg;
  public long iAh;
  public long iAi;
  public String ijl = "";
  public long ipV;
  public String iwJ = "";
  public long iwf;
  public String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368426);
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
    AppMethodBeat.o(368426);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368430);
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
    AppMethodBeat.o(368430);
    return localObject;
  }
  
  public final dp aIL()
  {
    this.iwf = 10L;
    return this;
  }
  
  public final int getId()
  {
    return 20672;
  }
  
  public final dp nB(String paramString)
  {
    AppMethodBeat.i(368400);
    this.ixm = F("Sessionid", paramString, true);
    AppMethodBeat.o(368400);
    return this;
  }
  
  public final dp nC(String paramString)
  {
    AppMethodBeat.i(368406);
    this.ijl = F("ClickTabContextid", paramString, true);
    AppMethodBeat.o(368406);
    return this;
  }
  
  public final dp nD(String paramString)
  {
    AppMethodBeat.i(368413);
    this.iwJ = F("ExtraInfo", paramString, true);
    AppMethodBeat.o(368413);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dp
 * JD-Core Version:    0.7.0.1
 */