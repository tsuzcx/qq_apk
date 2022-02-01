package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ko
  extends a
{
  public long gBe;
  private String gHP = "";
  public long gOA;
  public long gOB;
  public long gOC;
  public long gOD;
  public long gOE;
  public long gOF;
  public long gOG;
  public long gOH;
  public long gOw;
  public long gOx;
  public long gOy;
  public long gOz;
  public String gmO = "";
  public long gmU;
  
  public final ko BD(String paramString)
  {
    AppMethodBeat.i(94826);
    this.gHP = z("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ko BE(String paramString)
  {
    AppMethodBeat.i(94827);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOH);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.gHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.gmU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.gOw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.gOx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.gOy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.gOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.gOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.gOB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.gOC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.gOD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.gOE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.gOF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.gOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.gOH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ko amA()
  {
    this.gOw = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ko
 * JD-Core Version:    0.7.0.1
 */