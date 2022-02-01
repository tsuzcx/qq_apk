package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  private String dFY;
  private String dFe;
  private String dHX;
  private long dHY;
  private String dIv;
  private String dJI;
  private String dJJ;
  private long dJK;
  private long dJL;
  private String dJM;
  private long dJN;
  private String dJO;
  
  public final String PR()
  {
    AppMethodBeat.i(194939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJO);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194939);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.dJI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.dJJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dIv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.dJO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194940);
    return localObject;
  }
  
  public final am dk(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final am dl(long paramLong)
  {
    this.dJK = paramLong;
    return this;
  }
  
  public final am dm(long paramLong)
  {
    this.dJL = paramLong;
    return this;
  }
  
  public final am dn(long paramLong)
  {
    this.dJN = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final am hd(String paramString)
  {
    AppMethodBeat.i(194931);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194931);
    return this;
  }
  
  public final am he(String paramString)
  {
    AppMethodBeat.i(194932);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(194932);
    return this;
  }
  
  public final am hf(String paramString)
  {
    AppMethodBeat.i(194933);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(194933);
    return this;
  }
  
  public final am hg(String paramString)
  {
    AppMethodBeat.i(194934);
    this.dJI = t("ClickFeedid", paramString, true);
    AppMethodBeat.o(194934);
    return this;
  }
  
  public final am hh(String paramString)
  {
    AppMethodBeat.i(194935);
    this.dJJ = t("AllFeedInfo", paramString, true);
    AppMethodBeat.o(194935);
    return this;
  }
  
  public final am hi(String paramString)
  {
    AppMethodBeat.i(194936);
    this.dJM = t("PageTag", paramString, true);
    AppMethodBeat.o(194936);
    return this;
  }
  
  public final am hj(String paramString)
  {
    AppMethodBeat.i(194937);
    this.dIv = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(194937);
    return this;
  }
  
  public final am hk(String paramString)
  {
    AppMethodBeat.i(194938);
    this.dJO = t("ScreenInfo", paramString, true);
    AppMethodBeat.o(194938);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */