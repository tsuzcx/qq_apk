package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  public String ijk = "";
  public String ipT = "";
  public String ipU = "";
  public long ipV;
  public String ipW = "";
  private String ipX = "";
  private String ipY = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368529);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipY);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368529);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368531);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ipV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rootCommentid:").append(this.ipX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("subCommentid:").append(this.ipY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368531);
    return localObject;
  }
  
  public final int getId()
  {
    return 23092;
  }
  
  public final ax kL(String paramString)
  {
    AppMethodBeat.i(368520);
    this.ipX = F("rootCommentid", paramString, true);
    AppMethodBeat.o(368520);
    return this;
  }
  
  public final ax kM(String paramString)
  {
    AppMethodBeat.i(368525);
    this.ipY = F("subCommentid", paramString, true);
    AppMethodBeat.o(368525);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ax
 * JD-Core Version:    0.7.0.1
 */