package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cm
  extends a
{
  private String gcU = "";
  private long ggh;
  private String gmO = "";
  private long gmP;
  private long gmQ;
  private long gmV;
  private long gpQ;
  private long gqa;
  private String gqb = "";
  private long gqc;
  private String gqd = "";
  private long gqe;
  
  public final String agH()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.gqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.gqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.gqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.gmP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.gmQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.gpQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.gqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final cm fA(long paramLong)
  {
    this.gmP = paramLong;
    return this;
  }
  
  public final cm fB(long paramLong)
  {
    this.gmQ = paramLong;
    return this;
  }
  
  public final cm fC(long paramLong)
  {
    this.gpQ = paramLong;
    return this;
  }
  
  public final cm fD(long paramLong)
  {
    this.gqe = paramLong;
    return this;
  }
  
  public final cm fE(long paramLong)
  {
    this.gmV = paramLong;
    return this;
  }
  
  public final cm fy(long paramLong)
  {
    this.gqc = paramLong;
    return this;
  }
  
  public final cm fz(long paramLong)
  {
    this.ggh = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
  
  public final cm mA(String paramString)
  {
    AppMethodBeat.i(184154);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final cm mB(String paramString)
  {
    AppMethodBeat.i(184155);
    this.gqb = z("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final cm mC(String paramString)
  {
    AppMethodBeat.i(184156);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final cm mD(String paramString)
  {
    AppMethodBeat.i(184157);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cm
 * JD-Core Version:    0.7.0.1
 */