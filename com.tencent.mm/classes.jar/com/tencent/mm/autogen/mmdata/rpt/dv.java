package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dv
  extends a
{
  public String iAU = "";
  public long iAV;
  public String iAW = "";
  public long iAX;
  public long iAY;
  public String ijl = "";
  public long ipV;
  public String ivZ = "";
  public String iwI = "";
  public String ixm = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368346);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAY);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368346);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368352);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.ixm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.iwI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.ijl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.iAU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.iAV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.iAW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.iAX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.iAY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368352);
    return localObject;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final dv nJ(String paramString)
  {
    AppMethodBeat.i(368341);
    this.iAW = F("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(368341);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dv
 * JD-Core Version:    0.7.0.1
 */