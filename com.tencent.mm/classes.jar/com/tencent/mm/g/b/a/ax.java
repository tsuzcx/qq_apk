package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  private String dTr = "";
  private String dUt = "";
  private String dWs = "";
  private long dWt;
  private String dXs = "";
  private String dYT = "";
  private String dYU = "";
  private long dYV;
  private long dYW;
  private String dYX = "";
  private long dYY;
  private String dYZ = "";
  private long dZa;
  private String dZb = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189158);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.dYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.dYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dXs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.dYZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.dZa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189159);
    return localObject;
  }
  
  public final ax ea(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ax eb(long paramLong)
  {
    this.dYV = paramLong;
    return this;
  }
  
  public final ax ec(long paramLong)
  {
    this.dYW = paramLong;
    return this;
  }
  
  public final ax ed(long paramLong)
  {
    this.dYY = paramLong;
    return this;
  }
  
  public final ax ee(long paramLong)
  {
    this.dZa = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final ax iI(String paramString)
  {
    AppMethodBeat.i(189149);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189149);
    return this;
  }
  
  public final ax iJ(String paramString)
  {
    AppMethodBeat.i(189150);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189150);
    return this;
  }
  
  public final ax iK(String paramString)
  {
    AppMethodBeat.i(189151);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189151);
    return this;
  }
  
  public final ax iL(String paramString)
  {
    AppMethodBeat.i(189152);
    this.dYT = t("ClickFeedid", paramString, true);
    AppMethodBeat.o(189152);
    return this;
  }
  
  public final ax iM(String paramString)
  {
    AppMethodBeat.i(189153);
    this.dYU = t("AllFeedInfo", paramString, true);
    AppMethodBeat.o(189153);
    return this;
  }
  
  public final ax iN(String paramString)
  {
    AppMethodBeat.i(189154);
    this.dYX = t("PageTag", paramString, true);
    AppMethodBeat.o(189154);
    return this;
  }
  
  public final ax iO(String paramString)
  {
    AppMethodBeat.i(189155);
    this.dXs = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(189155);
    return this;
  }
  
  public final ax iP(String paramString)
  {
    AppMethodBeat.i(189156);
    this.dYZ = t("ScreenInfo", paramString, true);
    AppMethodBeat.o(189156);
    return this;
  }
  
  public final ax iQ(String paramString)
  {
    AppMethodBeat.i(189157);
    this.dZb = t("RecommendWording", paramString, true);
    AppMethodBeat.o(189157);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ax
 * JD-Core Version:    0.7.0.1
 */