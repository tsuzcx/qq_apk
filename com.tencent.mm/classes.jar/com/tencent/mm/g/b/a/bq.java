package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  private long dQB;
  private String dTr = "";
  private String dUt = "";
  private String dWh = "";
  private long dWp;
  private String dWs = "";
  private String eaI = "";
  private long ebB;
  private long ebH;
  private long ebI;
  private long ebJ;
  private long ebK;
  private long ebL;
  private String ebM = "";
  private String ebN = "";
  private long ebO;
  private long ebP;
  private long ebn;
  private String ebz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaI);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.ebz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.ebI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.ebJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.ebK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.ebL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.ebM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.ebN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.ebO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.ebn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.ebB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.ebH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoClick:").append(this.ebP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.eaI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final bq gq(long paramLong)
  {
    this.ebI = paramLong;
    return this;
  }
  
  public final bq gr(long paramLong)
  {
    this.dQB = paramLong;
    return this;
  }
  
  public final bq gs(long paramLong)
  {
    this.ebJ = paramLong;
    return this;
  }
  
  public final bq gt(long paramLong)
  {
    this.ebK = paramLong;
    return this;
  }
  
  public final bq gu(long paramLong)
  {
    this.dWp = paramLong;
    return this;
  }
  
  public final bq gv(long paramLong)
  {
    this.ebL = paramLong;
    return this;
  }
  
  public final bq gw(long paramLong)
  {
    this.ebn = paramLong;
    return this;
  }
  
  public final bq gx(long paramLong)
  {
    this.ebB = paramLong;
    return this;
  }
  
  public final bq gy(long paramLong)
  {
    this.ebH = paramLong;
    return this;
  }
  
  public final bq gz(long paramLong)
  {
    this.ebP = paramLong;
    return this;
  }
  
  public final bq kN(String paramString)
  {
    AppMethodBeat.i(184176);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final bq kO(String paramString)
  {
    AppMethodBeat.i(184177);
    this.ebz = t("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final bq kP(String paramString)
  {
    AppMethodBeat.i(184178);
    this.ebM = t("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final bq kQ(String paramString)
  {
    AppMethodBeat.i(186003);
    this.ebN = t("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final bq kR(String paramString)
  {
    AppMethodBeat.i(189260);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189260);
    return this;
  }
  
  public final bq kS(String paramString)
  {
    AppMethodBeat.i(189261);
    this.dUt = t("ContextId", paramString, true);
    AppMethodBeat.o(189261);
    return this;
  }
  
  public final bq kT(String paramString)
  {
    AppMethodBeat.i(189262);
    this.dWs = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(189262);
    return this;
  }
  
  public final bq kU(String paramString)
  {
    AppMethodBeat.i(189263);
    this.eaI = t("ExtInfo", paramString, true);
    AppMethodBeat.o(189263);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */