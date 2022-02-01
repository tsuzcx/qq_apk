package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kw
  extends a
{
  private String gOX = "";
  private String gPk = "";
  public int gPl;
  public long gPm;
  public long gPn;
  public int gPo;
  private String gpN = "";
  
  public final kw BJ(String paramString)
  {
    AppMethodBeat.i(263864);
    this.gOX = z("PublishId", paramString, true);
    AppMethodBeat.o(263864);
    return this;
  }
  
  public final kw BK(String paramString)
  {
    AppMethodBeat.i(263865);
    this.gPk = z("FriendUsername", paramString, true);
    AppMethodBeat.o(263865);
    return this;
  }
  
  public final kw BL(String paramString)
  {
    AppMethodBeat.i(263866);
    this.gpN = z("CommentId", paramString, true);
    AppMethodBeat.o(263866);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(263867);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(263867);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(263868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.gOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUsername:").append(this.gPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.gpN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentType:").append(this.gPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLikeCount:").append(this.gPm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentCommentCount:").append(this.gPn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.gPo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(263868);
    return localObject;
  }
  
  public final int getId()
  {
    return 20565;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kw
 * JD-Core Version:    0.7.0.1
 */