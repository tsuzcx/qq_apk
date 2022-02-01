package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private String dSb;
  private String dUR;
  private long dUS;
  private long dUT;
  private long dUZ;
  private long dWE;
  private long dWG;
  private long dWH;
  private String dWI;
  private long dWJ;
  private String dWK;
  private long dWL;
  
  public final String RD()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.dWH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.dWI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.dWJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dWE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dWG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.dWL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dUZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final aq dt(long paramLong)
  {
    this.dWJ = paramLong;
    return this;
  }
  
  public final aq du(long paramLong)
  {
    this.dWE = paramLong;
    return this;
  }
  
  public final aq dv(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final aq dw(long paramLong)
  {
    this.dUT = paramLong;
    return this;
  }
  
  public final aq dx(long paramLong)
  {
    this.dWG = paramLong;
    return this;
  }
  
  public final aq dy(long paramLong)
  {
    this.dWL = paramLong;
    return this;
  }
  
  public final aq dz(long paramLong)
  {
    this.dUZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
  
  public final aq hU(String paramString)
  {
    AppMethodBeat.i(184154);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final aq hV(String paramString)
  {
    AppMethodBeat.i(184155);
    this.dWI = t("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final aq hW(String paramString)
  {
    AppMethodBeat.i(184156);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final aq hX(String paramString)
  {
    AppMethodBeat.i(184157);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aq
 * JD-Core Version:    0.7.0.1
 */