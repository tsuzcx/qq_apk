package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class in
  extends a
{
  private String eOG = "";
  private String eOL = "";
  public int eOM;
  public long eON;
  public long eOO;
  public int eOP;
  private String etI = "";
  
  public final String abV()
  {
    AppMethodBeat.i(201834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eOG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eON);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(201834);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(201835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PublishId:").append(this.eOG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FriendUsername:").append(this.eOL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentType:").append(this.eOM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentLikeCount:").append(this.eON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentCommentCount:").append(this.eOO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpResult:").append(this.eOP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201835);
    return localObject;
  }
  
  public final int getId()
  {
    return 20565;
  }
  
  public final in wk(String paramString)
  {
    AppMethodBeat.i(201831);
    this.eOG = x("PublishId", paramString, true);
    AppMethodBeat.o(201831);
    return this;
  }
  
  public final in wl(String paramString)
  {
    AppMethodBeat.i(201832);
    this.eOL = x("FriendUsername", paramString, true);
    AppMethodBeat.o(201832);
    return this;
  }
  
  public final in wm(String paramString)
  {
    AppMethodBeat.i(201833);
    this.etI = x("CommentId", paramString, true);
    AppMethodBeat.o(201833);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.in
 * JD-Core Version:    0.7.0.1
 */