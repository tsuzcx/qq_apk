package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "", "sessionId", "", "pageName", "stayTimeMs", "", "enterTimeMs", "exitTimeMs", "clickTabContextId", "sid", "reportType", "", "isPoi", "", "extraInfo", "enterSourceInfo", "(Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "setClickTabContextId", "(Ljava/lang/String;)V", "getEnterSourceInfo", "setEnterSourceInfo", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "getExitTimeMs", "setExitTimeMs", "getExtraInfo", "setExtraInfo", "()Z", "setPoi", "(Z)V", "getPageName", "setPageName", "getReportType", "()I", "setReportType", "(I)V", "getSessionId", "setSessionId", "getSid", "setSid", "getStayTimeMs", "setStayTimeMs", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"})
public final class b
{
  public String dMl = null;
  public int dYn;
  public String extraInfo;
  public long sGB = -1L;
  public long sGC = -1L;
  public long sGD = -1L;
  public String sGE = null;
  public String sGF = null;
  public boolean sGG;
  public String sGH;
  public String sessionId = null;
  
  public b(byte paramByte)
  {
    this();
  }
  
  private b(int paramInt)
  {
    this.dYn = paramInt;
    this.sGG = false;
    this.extraInfo = null;
    this.sGH = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221030);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.sessionId, paramObject.sessionId)) || (!p.j(this.dMl, paramObject.dMl)) || (this.sGB != paramObject.sGB) || (this.sGC != paramObject.sGC) || (this.sGD != paramObject.sGD) || (!p.j(this.sGE, paramObject.sGE)) || (!p.j(this.sGF, paramObject.sGF)) || (this.dYn != paramObject.dYn) || (this.sGG != paramObject.sGG) || (!p.j(this.extraInfo, paramObject.extraInfo)) || (!p.j(this.sGH, paramObject.sGH))) {}
      }
    }
    else
    {
      AppMethodBeat.o(221030);
      return true;
    }
    AppMethodBeat.o(221030);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221028);
    String str = "StayTimeStatistics(sessionId=" + this.sessionId + ", pageName=" + this.dMl + ", stayTimeMs=" + this.sGB + ", enterTimeMs=" + this.sGC + ", exitTimeMs=" + this.sGD + ", clickTabContextId=" + this.sGE + ", sid=" + this.sGF + ", reportType=" + this.dYn + ", isPoi=" + this.sGG + ", extraInfo=" + this.extraInfo + ", enterSourceInfo=" + this.sGH + ")";
    AppMethodBeat.o(221028);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */