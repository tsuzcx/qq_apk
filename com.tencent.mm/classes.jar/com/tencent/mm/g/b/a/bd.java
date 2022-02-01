package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bd
  extends a
{
  private long dCQ;
  private String dFY;
  private String dFe;
  private String dHM;
  private long dHU;
  private String dHX;
  private long dLJ;
  private String dLM;
  private long dLN;
  private long dLO;
  private long dLP;
  private long dLQ;
  private String dLR;
  private String dLS;
  private long dLT;
  private long dLU;
  private long dLV;
  private long dLW;
  
  public final String PR()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLW);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.dLM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.dLN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.dLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.dLP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dHU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.dLQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.dLR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.dLS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.dLT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dFY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.dLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.dLU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.dLV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoClick:").append(this.dLW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final bd fa(long paramLong)
  {
    this.dLN = paramLong;
    return this;
  }
  
  public final bd fb(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final bd fc(long paramLong)
  {
    this.dLO = paramLong;
    return this;
  }
  
  public final bd fd(long paramLong)
  {
    this.dLP = paramLong;
    return this;
  }
  
  public final bd fe(long paramLong)
  {
    this.dHU = paramLong;
    return this;
  }
  
  public final bd ff(long paramLong)
  {
    this.dLQ = paramLong;
    return this;
  }
  
  public final bd fg(long paramLong)
  {
    this.dLJ = paramLong;
    return this;
  }
  
  public final bd fh(long paramLong)
  {
    this.dLU = paramLong;
    return this;
  }
  
  public final bd fi(long paramLong)
  {
    this.dLV = paramLong;
    return this;
  }
  
  public final bd fj(long paramLong)
  {
    this.dLW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final bd iS(String paramString)
  {
    AppMethodBeat.i(184176);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final bd iT(String paramString)
  {
    AppMethodBeat.i(184177);
    this.dLM = t("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final bd iU(String paramString)
  {
    AppMethodBeat.i(184178);
    this.dLR = t("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final bd iV(String paramString)
  {
    AppMethodBeat.i(186003);
    this.dLS = t("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final bd iW(String paramString)
  {
    AppMethodBeat.i(195020);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(195020);
    return this;
  }
  
  public final bd iX(String paramString)
  {
    AppMethodBeat.i(195021);
    this.dFY = t("ContextId", paramString, true);
    AppMethodBeat.o(195021);
    return this;
  }
  
  public final bd iY(String paramString)
  {
    AppMethodBeat.i(195022);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(195022);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bd
 * JD-Core Version:    0.7.0.1
 */