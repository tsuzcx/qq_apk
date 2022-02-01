package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private String dWq = "";
  private String dWr = "";
  private long dWt;
  private String dXs = "";
  private long dYR;
  private long dYV;
  private String dYX = "";
  private String dYp = "";
  private long dZa;
  private String dZb = "";
  private String dZc = "";
  private long dZd;
  private String dZe = "";
  private long dZf;
  private long dZg;
  private long dZh;
  private long dZi;
  
  public final String RC()
  {
    AppMethodBeat.i(189168);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189168);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189169);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IndexInfo:").append(this.dZe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTime:").append(this.dZf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposeTime:").append(this.dZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposeTime:").append(this.dZh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCnt:").append(this.dZi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dXs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.dZa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.dZb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189169);
    return localObject;
  }
  
  public final ay ef(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ay eg(long paramLong)
  {
    this.dZd = paramLong;
    return this;
  }
  
  public final ay eh(long paramLong)
  {
    this.dYV = paramLong;
    return this;
  }
  
  public final ay ei(long paramLong)
  {
    this.dZf = paramLong;
    return this;
  }
  
  public final ay ej(long paramLong)
  {
    this.dZg = paramLong;
    return this;
  }
  
  public final ay ek(long paramLong)
  {
    this.dZh = paramLong;
    return this;
  }
  
  public final ay el(long paramLong)
  {
    this.dZi = paramLong;
    return this;
  }
  
  public final ay em(long paramLong)
  {
    this.dYR = paramLong;
    return this;
  }
  
  public final ay en(long paramLong)
  {
    this.dZa = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19997;
  }
  
  public final ay iR(String paramString)
  {
    AppMethodBeat.i(189160);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189160);
    return this;
  }
  
  public final ay iS(String paramString)
  {
    AppMethodBeat.i(189161);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189161);
    return this;
  }
  
  public final ay iT(String paramString)
  {
    AppMethodBeat.i(189162);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189162);
    return this;
  }
  
  public final ay iU(String paramString)
  {
    AppMethodBeat.i(189163);
    this.dZc = t("Feedid", paramString, true);
    AppMethodBeat.o(189163);
    return this;
  }
  
  public final ay iV(String paramString)
  {
    AppMethodBeat.i(189164);
    this.dZe = t("IndexInfo", paramString, true);
    AppMethodBeat.o(189164);
    return this;
  }
  
  public final ay iW(String paramString)
  {
    AppMethodBeat.i(189165);
    this.dYX = t("PageTag", paramString, true);
    AppMethodBeat.o(189165);
    return this;
  }
  
  public final ay iX(String paramString)
  {
    AppMethodBeat.i(189166);
    this.dXs = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(189166);
    return this;
  }
  
  public final ay iY(String paramString)
  {
    AppMethodBeat.i(189167);
    this.dZb = t("RecommendWording", paramString, true);
    AppMethodBeat.o(189167);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */