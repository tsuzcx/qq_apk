package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  public String dJL;
  public long dJX;
  public long dMB;
  private String dRj;
  public long dRk;
  public long dRl;
  public long dRm;
  public long dRn;
  public long dRo;
  public long dRp;
  public long dRq;
  public long dRr;
  public long dRs;
  public long dRt;
  public long dRu;
  public long dRv;
  
  public final String PV()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRv);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dMB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dJX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.dRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.dRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.dRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.dRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.dRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.dRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.dRq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.dRr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.dRs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.dRt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.dRu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.dRv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ck QC()
  {
    this.dRk = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final ck jd(String paramString)
  {
    AppMethodBeat.i(94826);
    this.dRj = t("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ck je(String paramString)
  {
    AppMethodBeat.i(94827);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ck
 * JD-Core Version:    0.7.0.1
 */