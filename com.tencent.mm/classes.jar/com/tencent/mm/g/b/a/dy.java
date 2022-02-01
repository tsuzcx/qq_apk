package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dy
  extends a
{
  public String dHM;
  public long dHS;
  public long dNc;
  private String dSX;
  public long dSY;
  public long dSZ;
  public long dTa;
  public long dTb;
  public long dTc;
  public long dTd;
  public long dTe;
  public long dTf;
  public long dTg;
  public long dTh;
  public long dTi;
  public long dTj;
  
  public final String PR()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTj);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.dSX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.dNc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.dHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.dSZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.dTa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.dTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.dTc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.dTe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.dTf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.dTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.dTh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.dTi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.dTj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final dy Re()
  {
    this.dSY = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final dy lT(String paramString)
  {
    AppMethodBeat.i(94826);
    this.dSX = t("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final dy lU(String paramString)
  {
    AppMethodBeat.i(94827);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dy
 * JD-Core Version:    0.7.0.1
 */