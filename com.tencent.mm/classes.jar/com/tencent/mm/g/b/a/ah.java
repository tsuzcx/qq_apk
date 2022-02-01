package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  private long dFd;
  private String dHr;
  private String dJL;
  private long dKY;
  private String dLF;
  private long dLG;
  private long dLH;
  private long dLI;
  private long dLJ;
  private String dLK;
  private String dLL;
  private long dLM;
  private String dLe;
  private String dMw;
  private long lZe;
  private long lZj;
  private long lZk;
  
  public final String PV()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZk);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.dLF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.dLG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.dLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.dLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dKY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.dLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.dLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.dLL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.dLM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.lZe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.lZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.lZk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final ah aSB(String paramString)
  {
    AppMethodBeat.i(203799);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203799);
    return this;
  }
  
  public final ah dA(long paramLong)
  {
    this.dKY = paramLong;
    return this;
  }
  
  public final ah dB(long paramLong)
  {
    this.dLJ = paramLong;
    return this;
  }
  
  public final ah dw(long paramLong)
  {
    this.dLG = paramLong;
    return this;
  }
  
  public final ah dx(long paramLong)
  {
    this.dFd = paramLong;
    return this;
  }
  
  public final ah dy(long paramLong)
  {
    this.dLH = paramLong;
    return this;
  }
  
  public final ah dz(long paramLong)
  {
    this.dLI = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final ah hg(String paramString)
  {
    AppMethodBeat.i(184176);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final ah hh(String paramString)
  {
    AppMethodBeat.i(184177);
    this.dLF = t("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final ah hi(String paramString)
  {
    AppMethodBeat.i(184178);
    this.dLK = t("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final ah hj(String paramString)
  {
    AppMethodBeat.i(186003);
    this.dLL = t("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final ah hk(String paramString)
  {
    AppMethodBeat.i(190564);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(190564);
    return this;
  }
  
  public final ah hl(String paramString)
  {
    AppMethodBeat.i(190565);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(190565);
    return this;
  }
  
  public final ah zl(long paramLong)
  {
    this.lZe = paramLong;
    return this;
  }
  
  public final ah zm(long paramLong)
  {
    this.lZj = paramLong;
    return this;
  }
  
  public final ah zn(long paramLong)
  {
    this.lZk = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ah
 * JD-Core Version:    0.7.0.1
 */