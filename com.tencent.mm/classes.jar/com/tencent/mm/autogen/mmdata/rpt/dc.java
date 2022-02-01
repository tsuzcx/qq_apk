package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dc
  extends a
{
  public String ijk = "";
  public String ipT = "";
  public String ipU = "";
  public long iqr;
  public String ivZ = "";
  public long iwa;
  public long iwb;
  public long iwc;
  public int iyI;
  public long iyJ;
  public String iys = "";
  public String iyt = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(184145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iys);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184145);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickUI:").append(this.iys);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.iyt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.iwa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.iwb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedFriLikeCount:").append(this.iwc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickAll:").append(this.iyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FullScreenCommentsArea:").append(this.iyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184146);
    return localObject;
  }
  
  public final int getId()
  {
    return 19017;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dc
 * JD-Core Version:    0.7.0.1
 */