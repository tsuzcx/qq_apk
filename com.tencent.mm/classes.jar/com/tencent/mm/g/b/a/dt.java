package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dt
  extends a
{
  private long eBA;
  private long eBB;
  private String eBC = "";
  private long eBD;
  private long eBE;
  private long eBF;
  private long eBn;
  private String eBo = "";
  private String eBp = "";
  private String eBq = "";
  private long eBr;
  private long eBs;
  private String eBt = "";
  private String eBu = "";
  private long eBv;
  private String eBw = "";
  private String eBx = "";
  private long eBy;
  private long eBz;
  private String eoC = "";
  private String eoD = "";
  private long eyO;
  
  public final String abV()
  {
    AppMethodBeat.i(209181);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209181);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209182);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.eBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.eBo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.eBp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoParentPath:").append(this.eBq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.eBr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoCountNum:").append(this.eBs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoTitle:").append(this.eBt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoExt:").append(this.eBu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotAction:").append(this.eBv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.eBw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.eoD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.eBx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.eyO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.eBy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsTriggerByUser:").append(this.eBz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnverVersion:").append(this.eBA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecTimeStamp:").append(this.eBB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoIconUrl:").append(this.eBC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.eBD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasFinderAccount:").append(this.eBE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotactiontimestamp:").append(this.eBF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209182);
    return localObject;
  }
  
  public final dt afg()
  {
    this.eBA = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 20411;
  }
  
  public final dt kA(long paramLong)
  {
    this.eBn = paramLong;
    return this;
  }
  
  public final dt kB(long paramLong)
  {
    this.eBr = paramLong;
    return this;
  }
  
  public final dt kC(long paramLong)
  {
    this.eBs = paramLong;
    return this;
  }
  
  public final dt kD(long paramLong)
  {
    this.eBv = paramLong;
    return this;
  }
  
  public final dt kE(long paramLong)
  {
    this.eyO = paramLong;
    return this;
  }
  
  public final dt kF(long paramLong)
  {
    this.eBy = paramLong;
    return this;
  }
  
  public final dt kG(long paramLong)
  {
    this.eBz = paramLong;
    return this;
  }
  
  public final dt kH(long paramLong)
  {
    this.eBB = paramLong;
    return this;
  }
  
  public final dt kI(long paramLong)
  {
    this.eBD = paramLong;
    return this;
  }
  
  public final dt kJ(long paramLong)
  {
    this.eBE = paramLong;
    return this;
  }
  
  public final dt kK(long paramLong)
  {
    this.eBF = paramLong;
    return this;
  }
  
  public final dt pI(String paramString)
  {
    AppMethodBeat.i(209171);
    this.eBo = x("RedDotTipsID", paramString, true);
    AppMethodBeat.o(209171);
    return this;
  }
  
  public final dt pJ(String paramString)
  {
    AppMethodBeat.i(209172);
    this.eBp = x("RedDotShowInfoPath", paramString, true);
    AppMethodBeat.o(209172);
    return this;
  }
  
  public final dt pK(String paramString)
  {
    AppMethodBeat.i(209173);
    this.eBq = x("RedDotShowInfoParentPath", paramString, true);
    AppMethodBeat.o(209173);
    return this;
  }
  
  public final dt pL(String paramString)
  {
    AppMethodBeat.i(209174);
    this.eBt = x("RedDotShowInfoTitle", paramString, true);
    AppMethodBeat.o(209174);
    return this;
  }
  
  public final dt pM(String paramString)
  {
    AppMethodBeat.i(209175);
    this.eBu = x("RedDotShowInfoExt", paramString, true);
    AppMethodBeat.o(209175);
    return this;
  }
  
  public final dt pN(String paramString)
  {
    AppMethodBeat.i(209176);
    this.eBw = x("CurrUI", paramString, true);
    AppMethodBeat.o(209176);
    return this;
  }
  
  public final dt pO(String paramString)
  {
    AppMethodBeat.i(209177);
    this.eoD = x("ContextID", paramString, true);
    AppMethodBeat.o(209177);
    return this;
  }
  
  public final dt pP(String paramString)
  {
    AppMethodBeat.i(209178);
    this.eBx = x("ClickTabContextID", paramString, true);
    AppMethodBeat.o(209178);
    return this;
  }
  
  public final dt pQ(String paramString)
  {
    AppMethodBeat.i(209179);
    this.eoC = x("SessionID", paramString, true);
    AppMethodBeat.o(209179);
    return this;
  }
  
  public final dt pR(String paramString)
  {
    AppMethodBeat.i(209180);
    this.eBC = x("RedDotShowInfoIconUrl", paramString, true);
    AppMethodBeat.o(209180);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dt
 * JD-Core Version:    0.7.0.1
 */