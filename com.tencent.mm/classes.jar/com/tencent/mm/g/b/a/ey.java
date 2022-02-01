package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ey
  extends a
{
  public String dWh = "";
  public long dWn;
  public long edv;
  private String eht = "";
  public long ekS;
  public long ekT;
  public long ekU;
  public long ekV;
  public long ekW;
  public long ekX;
  public long ekY;
  public long ekZ;
  public long ela;
  public long elb;
  public long elc;
  public long eld;
  
  public final String RC()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eht);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ela);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eld);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.eht);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.edv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dWn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.ekS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.ekT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.ekU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.ekV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.ekW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.ekX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.ekY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.ekZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.ela);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.elb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.elc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.eld);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ey Tr()
  {
    this.ekS = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final ey oy(String paramString)
  {
    AppMethodBeat.i(94826);
    this.eht = t("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ey oz(String paramString)
  {
    AppMethodBeat.i(94827);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ey
 * JD-Core Version:    0.7.0.1
 */