package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ew
  extends a
{
  public String dUR;
  public long dUX;
  public long eca;
  private String ejk;
  public long ejl;
  public long ejm;
  public long ejn;
  public long ejo;
  public long ejp;
  public long ejq;
  public long ejr;
  public long ejs;
  public long ejt;
  public long eju;
  public long ejv;
  public long ejw;
  
  public final String RD()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eca);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eju);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejw);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eca);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dUX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.ejl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.ejn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.ejp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.ejq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.ejr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.ejs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.ejt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.eju);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.ejv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.ejw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ew Tl()
  {
    this.ejl = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final ew od(String paramString)
  {
    AppMethodBeat.i(94826);
    this.ejk = t("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ew oe(String paramString)
  {
    AppMethodBeat.i(94827);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ew
 * JD-Core Version:    0.7.0.1
 */