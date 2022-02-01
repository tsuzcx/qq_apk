package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  public String ijk = "";
  public long ipV;
  public long iuA;
  public String ivZ = "";
  public long iwa;
  public long iwb;
  public long iwc;
  public String iwd = "";
  public long iwe;
  private long iwf;
  
  public final String aIE()
  {
    AppMethodBeat.i(368251);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368251);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368258);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.iwa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.iwb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.iwc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.iwd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedType:").append(this.iwe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iwf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368258);
    return localObject;
  }
  
  public final int getId()
  {
    return 19185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ci
 * JD-Core Version:    0.7.0.1
 */