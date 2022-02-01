package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eo
  extends a
{
  private String gcU = "";
  private long gef;
  private String gjj = "";
  private String gjk = "";
  private String gmO = "";
  private long gmV;
  private long guE;
  private String gwj = "";
  private String gxL = "";
  private long gxN;
  private long gxS;
  private long gxY;
  private long gxZ;
  private long gya;
  private long gyb;
  private String gyc = "";
  private String gyd = "";
  private long gye;
  private long gyf;
  
  public final String agH()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gya);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gye);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gwj);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.gxL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.gxY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.gxZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.gya);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.gyb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.gyc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.gyd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.gye);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.guE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.gxN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.gxS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoClick:").append(this.gyf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.gwj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final eo lX(long paramLong)
  {
    this.gxY = paramLong;
    return this;
  }
  
  public final eo lY(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final eo lZ(long paramLong)
  {
    this.gxZ = paramLong;
    return this;
  }
  
  public final eo ma(long paramLong)
  {
    this.gya = paramLong;
    return this;
  }
  
  public final eo mb(long paramLong)
  {
    this.gmV = paramLong;
    return this;
  }
  
  public final eo mc(long paramLong)
  {
    this.gyb = paramLong;
    return this;
  }
  
  public final eo md(long paramLong)
  {
    this.guE = paramLong;
    return this;
  }
  
  public final eo me(long paramLong)
  {
    this.gxN = paramLong;
    return this;
  }
  
  public final eo mf(long paramLong)
  {
    this.gxS = paramLong;
    return this;
  }
  
  public final eo mg(long paramLong)
  {
    this.gyf = paramLong;
    return this;
  }
  
  public final eo sF(String paramString)
  {
    AppMethodBeat.i(184176);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final eo sG(String paramString)
  {
    AppMethodBeat.i(184177);
    this.gxL = z("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final eo sH(String paramString)
  {
    AppMethodBeat.i(184178);
    this.gyc = z("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final eo sI(String paramString)
  {
    AppMethodBeat.i(186003);
    this.gyd = z("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final eo sJ(String paramString)
  {
    AppMethodBeat.i(209140);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(209140);
    return this;
  }
  
  public final eo sK(String paramString)
  {
    AppMethodBeat.i(209141);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(209141);
    return this;
  }
  
  public final eo sL(String paramString)
  {
    AppMethodBeat.i(209142);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209142);
    return this;
  }
  
  public final eo sM(String paramString)
  {
    AppMethodBeat.i(209144);
    this.gwj = z("ExtInfo", paramString, true);
    AppMethodBeat.o(209144);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eo
 * JD-Core Version:    0.7.0.1
 */