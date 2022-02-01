package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  private String dWC;
  private String ejE;
  public int ejF;
  public long ejG;
  public long ejH;
  public int ejI;
  private String ejz;
  
  public final String RD()
  {
    AppMethodBeat.i(197547);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejI);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(197547);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(197548);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.ejz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUsername:").append(this.ejE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentType:").append(this.ejF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLikeCount:").append(this.ejG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentCommentCount:").append(this.ejH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.ejI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197548);
    return localObject;
  }
  
  public final int getId()
  {
    return 20565;
  }
  
  public final fa oh(String paramString)
  {
    AppMethodBeat.i(197544);
    this.ejz = t("PublishId", paramString, true);
    AppMethodBeat.o(197544);
    return this;
  }
  
  public final fa oi(String paramString)
  {
    AppMethodBeat.i(197545);
    this.ejE = t("FriendUsername", paramString, true);
    AppMethodBeat.o(197545);
    return this;
  }
  
  public final fa oj(String paramString)
  {
    AppMethodBeat.i(197546);
    this.dWC = t("CommentId", paramString, true);
    AppMethodBeat.o(197546);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa
 * JD-Core Version:    0.7.0.1
 */