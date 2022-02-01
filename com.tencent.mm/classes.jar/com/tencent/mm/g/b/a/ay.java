package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private String dVa;
  private String dVb;
  private long dVd;
  private String dWX;
  private String dWc;
  private long dXA;
  private long dXE;
  private String dXG;
  private long dXJ;
  private String dXK;
  private String dXL;
  private long dXM;
  private String dXN;
  private long dXO;
  private long dXP;
  private long dXQ;
  private long dXR;
  
  public final String RD()
  {
    AppMethodBeat.i(209136);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXK);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209136);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209137);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IndexInfo:").append(this.dXN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dXE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTime:").append(this.dXO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposeTime:").append(this.dXP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposeTime:").append(this.dXQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCnt:").append(this.dXR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dXG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendType:").append(this.dXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecommendWording:").append(this.dXK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209137);
    return localObject;
  }
  
  public final ay ee(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final ay ef(long paramLong)
  {
    this.dXM = paramLong;
    return this;
  }
  
  public final ay eg(long paramLong)
  {
    this.dXE = paramLong;
    return this;
  }
  
  public final ay eh(long paramLong)
  {
    this.dXO = paramLong;
    return this;
  }
  
  public final ay ei(long paramLong)
  {
    this.dXP = paramLong;
    return this;
  }
  
  public final ay ej(long paramLong)
  {
    this.dXQ = paramLong;
    return this;
  }
  
  public final ay ek(long paramLong)
  {
    this.dXR = paramLong;
    return this;
  }
  
  public final ay el(long paramLong)
  {
    this.dXA = paramLong;
    return this;
  }
  
  public final ay em(long paramLong)
  {
    this.dXJ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19997;
  }
  
  public final ay iH(String paramString)
  {
    AppMethodBeat.i(209128);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209128);
    return this;
  }
  
  public final ay iI(String paramString)
  {
    AppMethodBeat.i(209129);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209129);
    return this;
  }
  
  public final ay iJ(String paramString)
  {
    AppMethodBeat.i(209130);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209130);
    return this;
  }
  
  public final ay iK(String paramString)
  {
    AppMethodBeat.i(209131);
    this.dXL = t("Feedid", paramString, true);
    AppMethodBeat.o(209131);
    return this;
  }
  
  public final ay iL(String paramString)
  {
    AppMethodBeat.i(209132);
    this.dXN = t("IndexInfo", paramString, true);
    AppMethodBeat.o(209132);
    return this;
  }
  
  public final ay iM(String paramString)
  {
    AppMethodBeat.i(209133);
    this.dXG = t("PageTag", paramString, true);
    AppMethodBeat.o(209133);
    return this;
  }
  
  public final ay iN(String paramString)
  {
    AppMethodBeat.i(209134);
    this.dWc = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(209134);
    return this;
  }
  
  public final ay iO(String paramString)
  {
    AppMethodBeat.i(209135);
    this.dXK = t("RecommendWording", paramString, true);
    AppMethodBeat.o(209135);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */