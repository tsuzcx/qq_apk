package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  private int dSI;
  private int dSg;
  private String dTd;
  private long dUY;
  private String dVc;
  private String dWM;
  private String dWN;
  private int dWO;
  private long dWP;
  private long dWQ;
  private String dWR;
  private int dWS;
  private String dWT;
  private long dWU;
  private String dWV;
  private String dWW;
  
  public final String RD()
  {
    AppMethodBeat.i(209094);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209094);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209095);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedID:").append(this.dWM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionValue:").append(this.dWN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionCurrentVersion:").append(this.dWO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dWP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStampMs:").append(this.dWQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.dWR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dWS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionBuffer:").append(this.dWT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("videoDurationTime:").append(this.dWU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedId:").append(this.dWV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedContextId:").append(this.dWW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209095);
    return localObject;
  }
  
  public final ar dA(long paramLong)
  {
    AppMethodBeat.i(209087);
    this.dWQ = paramLong;
    super.bg("ActionTimeStampMs", this.dWQ);
    AppMethodBeat.o(209087);
    return this;
  }
  
  public final ar dB(long paramLong)
  {
    this.dWU = paramLong;
    return this;
  }
  
  public final ar dC(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18054;
  }
  
  public final ar hY(String paramString)
  {
    AppMethodBeat.i(209085);
    this.dWM = t("FeedID", paramString, true);
    AppMethodBeat.o(209085);
    return this;
  }
  
  public final ar hZ(String paramString)
  {
    AppMethodBeat.i(209086);
    this.dWN = t("ActionValue", paramString, true);
    AppMethodBeat.o(209086);
    return this;
  }
  
  public final ar ia(String paramString)
  {
    AppMethodBeat.i(209088);
    this.dWR = t("sessionID", paramString, true);
    AppMethodBeat.o(209088);
    return this;
  }
  
  public final ar ib(String paramString)
  {
    AppMethodBeat.i(209089);
    this.dWT = t("sessionBuffer", paramString, true);
    AppMethodBeat.o(209089);
    return this;
  }
  
  public final ar ic(String paramString)
  {
    AppMethodBeat.i(209090);
    this.dWV = t("ClickFeedId", paramString, true);
    AppMethodBeat.o(209090);
    return this;
  }
  
  public final ar ie(String paramString)
  {
    AppMethodBeat.i(209091);
    this.dWW = t("ClickFeedContextId", paramString, true);
    AppMethodBeat.o(209091);
    return this;
  }
  
  public final ar jdMethod_if(String paramString)
  {
    AppMethodBeat.i(209092);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209092);
    return this;
  }
  
  public final ar ig(String paramString)
  {
    AppMethodBeat.i(209093);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209093);
    return this;
  }
  
  public final ar io(int paramInt)
  {
    this.dSI = paramInt;
    return this;
  }
  
  public final ar ip(int paramInt)
  {
    this.dWO = paramInt;
    return this;
  }
  
  public final ar iq(int paramInt)
  {
    this.dWS = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ar
 * JD-Core Version:    0.7.0.1
 */