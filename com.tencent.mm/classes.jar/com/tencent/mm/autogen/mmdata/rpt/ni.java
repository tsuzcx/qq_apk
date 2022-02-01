package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ni
  extends a
{
  public long iOd;
  private String iWh = "";
  public String ivZ = "";
  public long iwe;
  public long jeL;
  public long jeM;
  public long jeN;
  public long jeO;
  public long jeP;
  public long jeQ;
  public long jeR;
  public long jeS;
  public long jeT;
  public long jeU;
  public long jeV;
  public long jeW;
  
  public final String aIE()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jeW);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.iOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.iwe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.jeL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.jeM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.jeN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.jeO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.jeP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.jeQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.jeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.jeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.jeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.jeU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.jeV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.jeW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ni aIT()
  {
    this.jeL = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final ni vF(String paramString)
  {
    AppMethodBeat.i(94826);
    this.iWh = F("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ni vG(String paramString)
  {
    AppMethodBeat.i(94827);
    this.ivZ = F("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ni
 * JD-Core Version:    0.7.0.1
 */