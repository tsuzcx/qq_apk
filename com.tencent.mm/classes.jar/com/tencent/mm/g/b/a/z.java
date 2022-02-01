package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class z
  extends a
{
  private String dHr;
  private String dJL;
  private long dKf;
  private long dKg;
  private String dKh;
  private String dKi;
  private long dKj;
  private long dKk;
  private String dKl;
  private long dKm;
  private long dKn;
  private long dKo;
  private long dKp;
  
  public final String PV()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKp);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.dKf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.dKg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.dKh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.dKi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.dKj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.dKk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.dKm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dKn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.dKo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dKp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final z cA(long paramLong)
  {
    this.dKm = paramLong;
    return this;
  }
  
  public final z cB(long paramLong)
  {
    this.dKn = paramLong;
    return this;
  }
  
  public final z cC(long paramLong)
  {
    this.dKo = paramLong;
    return this;
  }
  
  public final z cD(long paramLong)
  {
    this.dKp = paramLong;
    return this;
  }
  
  public final z cw(long paramLong)
  {
    this.dKf = paramLong;
    return this;
  }
  
  public final z cx(long paramLong)
  {
    this.dKg = paramLong;
    return this;
  }
  
  public final z cy(long paramLong)
  {
    this.dKj = paramLong;
    return this;
  }
  
  public final z cz(long paramLong)
  {
    this.dKk = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
  
  public final z gr(String paramString)
  {
    AppMethodBeat.i(184147);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final z gs(String paramString)
  {
    AppMethodBeat.i(184148);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final z gt(String paramString)
  {
    AppMethodBeat.i(184149);
    this.dKh = t("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final z gu(String paramString)
  {
    AppMethodBeat.i(184150);
    this.dKi = t("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final z gv(String paramString)
  {
    AppMethodBeat.i(184151);
    this.dKl = t("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */