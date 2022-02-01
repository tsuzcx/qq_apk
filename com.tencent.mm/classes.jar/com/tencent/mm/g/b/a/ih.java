package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ih
  extends a
{
  public long eDV;
  private String eJm = "";
  public long eOA;
  public long eOB;
  public long eOq;
  public long eOr;
  public long eOs;
  public long eOt;
  public long eOu;
  public long eOv;
  public long eOw;
  public long eOx;
  public long eOy;
  public long eOz;
  public String err = "";
  public long erx;
  
  public final String abV()
  {
    AppMethodBeat.i(94828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94828);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.eJm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.eDV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.erx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfAddText:").append(this.eOq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedMediaCount:").append(this.eOr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickedFromAlbum:").append(this.eOs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickIntoDetail:").append(this.eOt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtDetail:").append(this.eOu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowsedPicCountAtGallery:").append(this.eOv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtDetail:").append(this.eOw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseTimeAtGallery:").append(this.eOx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewCommentCount:").append(this.eOy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CanViewLikeCount:").append(this.eOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentFlag:").append(this.eOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeFlag:").append(this.eOB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94829);
    return localObject;
  }
  
  public final ih ahg()
  {
    this.eOq = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 18849;
  }
  
  public final ih we(String paramString)
  {
    AppMethodBeat.i(94826);
    this.eJm = x("ToUsername", paramString, true);
    AppMethodBeat.o(94826);
    return this;
  }
  
  public final ih wf(String paramString)
  {
    AppMethodBeat.i(94827);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(94827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ih
 * JD-Core Version:    0.7.0.1
 */