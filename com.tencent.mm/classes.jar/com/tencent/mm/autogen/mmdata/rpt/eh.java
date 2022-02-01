package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  public long iBZ;
  public String iCR = "";
  public String iCS = "";
  public long iCT;
  public long iCU;
  public long ioV;
  public String ivZ = "";
  public long iwS;
  public String iwX = "";
  public String izG = "";
  public String izH = "";
  public int izI;
  public String izJ = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(367950);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367950);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367956);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.izG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.izH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.izI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.izJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.izK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveId:").append(this.iCR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.iCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveTime:").append(this.iwS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCount:").append(this.iBZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineCount:").append(this.iCT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.iwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.iCU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367956);
    return localObject;
  }
  
  public final eh eN(long paramLong)
  {
    AppMethodBeat.i(367921);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(367921);
    return this;
  }
  
  public final int getId()
  {
    return 21054;
  }
  
  public final eh oC(String paramString)
  {
    AppMethodBeat.i(367901);
    this.izG = F("FinderUsrname", paramString, true);
    AppMethodBeat.o(367901);
    return this;
  }
  
  public final eh oD(String paramString)
  {
    AppMethodBeat.i(367909);
    this.izH = F("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(367909);
    return this;
  }
  
  public final eh oE(String paramString)
  {
    AppMethodBeat.i(367914);
    this.izJ = F("FinderSessionId", paramString, true);
    AppMethodBeat.o(367914);
    return this;
  }
  
  public final eh oF(String paramString)
  {
    AppMethodBeat.i(367925);
    this.iCR = F("LiveId", paramString, true);
    AppMethodBeat.o(367925);
    return this;
  }
  
  public final eh oG(String paramString)
  {
    AppMethodBeat.i(367930);
    this.ivZ = F("FeedId", paramString, true);
    AppMethodBeat.o(367930);
    return this;
  }
  
  public final eh oH(String paramString)
  {
    AppMethodBeat.i(367935);
    this.iCS = F("Description", paramString, true);
    AppMethodBeat.o(367935);
    return this;
  }
  
  public final eh oI(String paramString)
  {
    AppMethodBeat.i(367941);
    this.iwX = F("ActionResult", paramString, true);
    AppMethodBeat.o(367941);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.eh
 * JD-Core Version:    0.7.0.1
 */