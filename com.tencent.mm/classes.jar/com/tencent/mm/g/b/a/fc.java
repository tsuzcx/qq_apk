package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fc
  extends a
{
  private String dXU = "";
  private String elg = "";
  private String ell = "";
  public int elm;
  public long eln;
  public long elo;
  public int elp;
  
  public final String RC()
  {
    AppMethodBeat.i(218975);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ell);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(218975);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(218976);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.elg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUsername:").append(this.ell);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentType:").append(this.elm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLikeCount:").append(this.eln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentCommentCount:").append(this.elo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.elp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218976);
    return localObject;
  }
  
  public final int getId()
  {
    return 20565;
  }
  
  public final fc oC(String paramString)
  {
    AppMethodBeat.i(218972);
    this.elg = t("PublishId", paramString, true);
    AppMethodBeat.o(218972);
    return this;
  }
  
  public final fc oD(String paramString)
  {
    AppMethodBeat.i(218973);
    this.ell = t("FriendUsername", paramString, true);
    AppMethodBeat.o(218973);
    return this;
  }
  
  public final fc oE(String paramString)
  {
    AppMethodBeat.i(218974);
    this.dXU = t("CommentId", paramString, true);
    AppMethodBeat.o(218974);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fc
 * JD-Core Version:    0.7.0.1
 */