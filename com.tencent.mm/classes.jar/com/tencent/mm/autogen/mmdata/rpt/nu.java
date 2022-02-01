package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nu
  extends a
{
  private String iVg = "";
  private String izz = "";
  private String jga = "";
  public int jgb;
  public long jgc;
  public long jgd;
  public int jge;
  
  public final String aIE()
  {
    AppMethodBeat.i(367828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jga);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jgd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jge);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367828);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.iVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUsername:").append(this.jga);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.izz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentType:").append(this.jgb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLikeCount:").append(this.jgc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentCommentCount:").append(this.jgd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.jge);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367838);
    return localObject;
  }
  
  public final int getId()
  {
    return 20565;
  }
  
  public final nu vN(String paramString)
  {
    AppMethodBeat.i(367807);
    this.iVg = F("PublishId", paramString, true);
    AppMethodBeat.o(367807);
    return this;
  }
  
  public final nu vO(String paramString)
  {
    AppMethodBeat.i(367810);
    this.jga = F("FriendUsername", paramString, true);
    AppMethodBeat.o(367810);
    return this;
  }
  
  public final nu vP(String paramString)
  {
    AppMethodBeat.i(367817);
    this.izz = F("CommentId", paramString, true);
    AppMethodBeat.o(367817);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.nu
 * JD-Core Version:    0.7.0.1
 */