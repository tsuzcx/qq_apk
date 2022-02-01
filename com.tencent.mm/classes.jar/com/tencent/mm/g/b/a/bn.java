package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bn
  extends a
{
  private String dSb;
  private String dTd;
  private String dUR;
  private long dUY;
  private String dVc;
  private String dZN;
  private String dZO;
  private long dZP;
  
  public final String RD()
  {
    AppMethodBeat.i(209207);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZP);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209207);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209208);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.dZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.dZO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refuseLastCount:").append(this.dZP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209208);
    return localObject;
  }
  
  public final bn fY(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final bn fZ(long paramLong)
  {
    this.dZP = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final bn ki(String paramString)
  {
    AppMethodBeat.i(209201);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209201);
    return this;
  }
  
  public final bn kj(String paramString)
  {
    AppMethodBeat.i(209202);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209202);
    return this;
  }
  
  public final bn kk(String paramString)
  {
    AppMethodBeat.i(209203);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209203);
    return this;
  }
  
  public final bn kl(String paramString)
  {
    AppMethodBeat.i(209204);
    this.dZN = t("AddUsername", paramString, true);
    AppMethodBeat.o(209204);
    return this;
  }
  
  public final bn km(String paramString)
  {
    AppMethodBeat.i(209205);
    this.dZO = t("DeleteUsername", paramString, true);
    AppMethodBeat.o(209205);
    return this;
  }
  
  public final bn kn(String paramString)
  {
    AppMethodBeat.i(209206);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209206);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bn
 * JD-Core Version:    0.7.0.1
 */