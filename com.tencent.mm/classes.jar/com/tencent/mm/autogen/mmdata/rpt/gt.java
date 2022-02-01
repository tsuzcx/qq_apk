package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  public long iLB;
  public String ijk = "";
  public String ipW = "";
  public long iuA;
  public long iwa;
  public long iwb;
  public long iwc;
  public String iwd = "";
  public String iyA = "";
  public String iyB = "";
  private long iyC;
  private long iyD;
  
  public final String aIE()
  {
    AppMethodBeat.i(168919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwc);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(168919);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(168920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentPageName:").append(this.iwd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedtype:").append(this.iLB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.iyA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.iyB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.iyC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.iyD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.iwa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.iwb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.iwc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168920);
    return localObject;
  }
  
  public final int getId()
  {
    return 19186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gt
 * JD-Core Version:    0.7.0.1
 */