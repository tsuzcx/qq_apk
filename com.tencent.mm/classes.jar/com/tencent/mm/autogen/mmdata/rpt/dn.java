package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  public String iAa = "";
  public String iAb = "";
  public int iAc = 0;
  private int imW;
  public int ipH;
  public String ipT = "";
  public String ipU = "";
  public long ipV;
  public String iuI = "";
  public String iwJ = "";
  public String iwK = "";
  public String izF = "";
  public String izP = "";
  public int izQ;
  private long izR;
  private long izS;
  public String izT = "";
  public int izU;
  public long izV;
  public String izW = "";
  public String izX = "";
  public String izY = "";
  public long izZ;
  
  public final String aIE()
  {
    AppMethodBeat.i(368414);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368414);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368422);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.iuI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.izP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.izQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.izR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.izS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.izT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.izU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.izF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.izV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.izW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.izX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.iwJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.iwK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.izY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedDisplayType:").append(this.izZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jump_id:").append(this.iAa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("client_udf_kv:").append(this.iAb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is_invalid:").append(this.iAc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368422);
    return localObject;
  }
  
  public final dn eJ(long paramLong)
  {
    AppMethodBeat.i(368396);
    this.izS = paramLong;
    super.by("ActionTimeStampMs", this.izS);
    AppMethodBeat.o(368396);
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final dn nx(String paramString)
  {
    AppMethodBeat.i(368402);
    this.izF = F("sessionBuffer", paramString, true);
    AppMethodBeat.o(368402);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dn
 * JD-Core Version:    0.7.0.1
 */