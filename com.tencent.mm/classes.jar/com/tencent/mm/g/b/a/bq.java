package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bq
  extends a
{
  private long dPl;
  private String dSb;
  private String dTd;
  private String dUR;
  private long dUZ;
  private String dVc;
  private long dZT;
  private String dZp;
  private String eaf;
  private long eah;
  private long ean;
  private long eao;
  private long eap;
  private long eaq;
  private long ear;
  private String eas;
  private String eat;
  private long eau;
  private long eav;
  
  public final String RD()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eao);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eap);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ear);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ean);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZp);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.eaf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.eao);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.eap);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.eaq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.ear);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.eas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.eat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.eau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.eah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.ean);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoClick:").append(this.eav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.dZp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final bq gn(long paramLong)
  {
    this.eao = paramLong;
    return this;
  }
  
  public final bq go(long paramLong)
  {
    this.dPl = paramLong;
    return this;
  }
  
  public final bq gp(long paramLong)
  {
    this.eap = paramLong;
    return this;
  }
  
  public final bq gq(long paramLong)
  {
    this.eaq = paramLong;
    return this;
  }
  
  public final bq gr(long paramLong)
  {
    this.dUZ = paramLong;
    return this;
  }
  
  public final bq gs(long paramLong)
  {
    this.ear = paramLong;
    return this;
  }
  
  public final bq gt(long paramLong)
  {
    this.dZT = paramLong;
    return this;
  }
  
  public final bq gu(long paramLong)
  {
    this.eah = paramLong;
    return this;
  }
  
  public final bq gv(long paramLong)
  {
    this.ean = paramLong;
    return this;
  }
  
  public final bq gw(long paramLong)
  {
    this.eav = paramLong;
    return this;
  }
  
  public final bq kA(String paramString)
  {
    AppMethodBeat.i(184176);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final bq kB(String paramString)
  {
    AppMethodBeat.i(184177);
    this.eaf = t("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final bq kC(String paramString)
  {
    AppMethodBeat.i(184178);
    this.eas = t("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final bq kD(String paramString)
  {
    AppMethodBeat.i(186003);
    this.eat = t("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final bq kE(String paramString)
  {
    AppMethodBeat.i(209225);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209225);
    return this;
  }
  
  public final bq kF(String paramString)
  {
    AppMethodBeat.i(209226);
    this.dTd = t("ContextId", paramString, true);
    AppMethodBeat.o(209226);
    return this;
  }
  
  public final bq kG(String paramString)
  {
    AppMethodBeat.i(209227);
    this.dVc = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209227);
    return this;
  }
  
  public final bq kH(String paramString)
  {
    AppMethodBeat.i(209228);
    this.dZp = t("ExtInfo", paramString, true);
    AppMethodBeat.o(209228);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bq
 * JD-Core Version:    0.7.0.1
 */