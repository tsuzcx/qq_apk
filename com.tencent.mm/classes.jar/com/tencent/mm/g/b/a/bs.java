package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  private String eiB = "";
  private String err = "";
  private long etC;
  private long etD;
  private String etE = "";
  private String etF = "";
  private long etG;
  private long etH;
  private String etI = "";
  private long etJ;
  private long etK;
  private long etL;
  private long etM;
  
  public final String abV()
  {
    AppMethodBeat.i(184152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etM);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184152);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ExpandType:").append(this.etC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExpandCommentCount:").append(this.etD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsername:").append(this.etE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUsername:").append(this.etF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentLikeCount:").append(this.etG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTime:").append(this.etH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubCommentCount:").append(this.etJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.etK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentRole:").append(this.etL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.etM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184153);
    return localObject;
  }
  
  public final bs eA(long paramLong)
  {
    this.etH = paramLong;
    return this;
  }
  
  public final bs eB(long paramLong)
  {
    this.etJ = paramLong;
    return this;
  }
  
  public final bs eC(long paramLong)
  {
    this.etK = paramLong;
    return this;
  }
  
  public final bs eD(long paramLong)
  {
    this.etL = paramLong;
    return this;
  }
  
  public final bs eE(long paramLong)
  {
    this.etM = paramLong;
    return this;
  }
  
  public final bs ex(long paramLong)
  {
    this.etC = paramLong;
    return this;
  }
  
  public final bs ey(long paramLong)
  {
    this.etD = paramLong;
    return this;
  }
  
  public final bs ez(long paramLong)
  {
    this.etG = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19421;
  }
  
  public final bs jZ(String paramString)
  {
    AppMethodBeat.i(184147);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(184147);
    return this;
  }
  
  public final bs ka(String paramString)
  {
    AppMethodBeat.i(184148);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(184148);
    return this;
  }
  
  public final bs kb(String paramString)
  {
    AppMethodBeat.i(184149);
    this.etE = x("FeedUsername", paramString, true);
    AppMethodBeat.o(184149);
    return this;
  }
  
  public final bs kc(String paramString)
  {
    AppMethodBeat.i(184150);
    this.etF = x("CommentUsername", paramString, true);
    AppMethodBeat.o(184150);
    return this;
  }
  
  public final bs kd(String paramString)
  {
    AppMethodBeat.i(184151);
    this.etI = x("CommentId", paramString, true);
    AppMethodBeat.o(184151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */