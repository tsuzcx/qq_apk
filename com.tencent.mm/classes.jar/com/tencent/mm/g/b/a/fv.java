package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fv
  extends a
{
  private String dTr = "";
  private int enA = 0;
  private int enB = 0;
  private int enC = 0;
  private int enD = 0;
  private String enE = "";
  private int enF = 0;
  private int enG = 0;
  private String enH = "";
  private long enI = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enI);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.enA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.enB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.enC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.enD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.enE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.enF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.enG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.enH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.enI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int TC()
  {
    return this.enA;
  }
  
  public final int TD()
  {
    return this.enD;
  }
  
  public final int TE()
  {
    return this.enG;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final fv iG(int paramInt)
  {
    this.enA = paramInt;
    return this;
  }
  
  public final fv iH(int paramInt)
  {
    this.enB = paramInt;
    return this;
  }
  
  public final fv iI(int paramInt)
  {
    this.enC = paramInt;
    return this;
  }
  
  public final fv iJ(int paramInt)
  {
    this.enD = paramInt;
    return this;
  }
  
  public final fv iK(int paramInt)
  {
    this.enF = paramInt;
    return this;
  }
  
  public final fv iL(int paramInt)
  {
    this.enG = paramInt;
    return this;
  }
  
  public final fv lb(long paramLong)
  {
    this.enI = paramLong;
    return this;
  }
  
  public final fv pe(String paramString)
  {
    AppMethodBeat.i(118490);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final fv pf(String paramString)
  {
    AppMethodBeat.i(118491);
    this.enE = t("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final fv pg(String paramString)
  {
    AppMethodBeat.i(118492);
    this.enH = t("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fv
 * JD-Core Version:    0.7.0.1
 */