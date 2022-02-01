package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  private String dSb;
  private String dTd;
  private String dVc;
  private long dVd;
  private String dWc;
  private String dXC;
  private String dXD;
  private long dXE;
  private long dXF;
  private String dXG;
  private long dXH;
  private String dXI;
  private long dXJ;
  private String dXK;
  
  public final String RD()
  {
    AppMethodBeat.i(209126);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXK);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209126);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209127);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.dXC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.dXD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.dXF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dXH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.dXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.dXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.dXK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209127);
    return localObject;
  }
  
  public final ax dZ(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final ax ea(long paramLong)
  {
    this.dXE = paramLong;
    return this;
  }
  
  public final ax eb(long paramLong)
  {
    this.dXF = paramLong;
    return this;
  }
  
  public final ax ec(long paramLong)
  {
    this.dXH = paramLong;
    return this;
  }
  
  public final ax ed(long paramLong)
  {
    this.dXJ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final ax iA(String paramString)
  {
    AppMethodBeat.i(209119);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209119);
    return this;
  }
  
  public final ax iB(String paramString)
  {
    AppMethodBeat.i(209120);
    this.dXC = t("ClickFeedid", paramString, true);
    AppMethodBeat.o(209120);
    return this;
  }
  
  public final ax iC(String paramString)
  {
    AppMethodBeat.i(209121);
    this.dXD = t("AllFeedInfo", paramString, true);
    AppMethodBeat.o(209121);
    return this;
  }
  
  public final ax iD(String paramString)
  {
    AppMethodBeat.i(209122);
    this.dXG = t("PageTag", paramString, true);
    AppMethodBeat.o(209122);
    return this;
  }
  
  public final ax iE(String paramString)
  {
    AppMethodBeat.i(209123);
    this.dWc = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(209123);
    return this;
  }
  
  public final ax iF(String paramString)
  {
    AppMethodBeat.i(209124);
    this.dXI = t("ScreenInfo", paramString, true);
    AppMethodBeat.o(209124);
    return this;
  }
  
  public final ax iG(String paramString)
  {
    AppMethodBeat.i(209125);
    this.dXK = t("RecommendWording", paramString, true);
    AppMethodBeat.o(209125);
    return this;
  }
  
  public final ax iy(String paramString)
  {
    AppMethodBeat.i(209117);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209117);
    return this;
  }
  
  public final ax iz(String paramString)
  {
    AppMethodBeat.i(209118);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209118);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ax
 * JD-Core Version:    0.7.0.1
 */