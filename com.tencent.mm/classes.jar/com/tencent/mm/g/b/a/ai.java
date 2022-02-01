package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ai
  extends a
{
  private String dFe;
  private String dHM;
  private long dHN;
  private long dHO;
  private long dHU;
  private long dIV;
  private long dIX;
  private long dIY;
  private String dIZ;
  private long dJa;
  private String dJb;
  private long dJc;
  
  public final String PR()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.dIY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.dIZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.dJa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dIV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dHO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dIX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.dJc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dHU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final ai cX(long paramLong)
  {
    this.dJa = paramLong;
    return this;
  }
  
  public final ai cY(long paramLong)
  {
    this.dIV = paramLong;
    return this;
  }
  
  public final ai cZ(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final ai da(long paramLong)
  {
    this.dHO = paramLong;
    return this;
  }
  
  public final ai db(long paramLong)
  {
    this.dIX = paramLong;
    return this;
  }
  
  public final ai dc(long paramLong)
  {
    this.dJc = paramLong;
    return this;
  }
  
  public final ai dd(long paramLong)
  {
    this.dHU = paramLong;
    return this;
  }
  
  public final ai gK(String paramString)
  {
    AppMethodBeat.i(184154);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final ai gL(String paramString)
  {
    AppMethodBeat.i(184155);
    this.dIZ = t("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final ai gM(String paramString)
  {
    AppMethodBeat.i(184156);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final ai gN(String paramString)
  {
    AppMethodBeat.i(184157);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ai
 * JD-Core Version:    0.7.0.1
 */