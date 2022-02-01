package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dm
  extends a
{
  public String ijk = "";
  public String imU = "";
  public long imY;
  public String ivZ = "";
  public long iwa;
  public long iwb;
  public long iwf;
  public long izC;
  private long izL;
  public String izM = "";
  public long izN;
  public long izO;
  
  public final String aIE()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwf);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.izL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.izM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.izN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.imU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.imY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.iwa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.iwb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.izC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.izO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iwf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final int getId()
  {
    return 19405;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dm
 * JD-Core Version:    0.7.0.1
 */