package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "", "sessionId", "", "pageName", "stayTimeMs", "", "enterTimeMs", "exitTimeMs", "clickTabContextId", "sid", "reportType", "", "isPoi", "", "(Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;IZ)V", "getClickTabContextId", "()Ljava/lang/String;", "setClickTabContextId", "(Ljava/lang/String;)V", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "getExitTimeMs", "setExitTimeMs", "()Z", "setPoi", "(Z)V", "getPageName", "setPageName", "getReportType", "()I", "setReportType", "(I)V", "getSessionId", "setSessionId", "getSid", "setSid", "getStayTimeMs", "setStayTimeMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"})
public final class b
{
  public int dFx;
  public String dtL = null;
  public long qXg = -1L;
  public long qXh = -1L;
  public long qXi = -1L;
  public String qXj = null;
  public String qXk = null;
  public boolean qXl;
  public String sessionId = null;
  
  public b(byte paramByte)
  {
    this();
  }
  
  private b(int paramInt)
  {
    this.dFx = paramInt;
    this.qXl = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210867);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.sessionId, paramObject.sessionId)) || (!p.i(this.dtL, paramObject.dtL)) || (this.qXg != paramObject.qXg) || (this.qXh != paramObject.qXh) || (this.qXi != paramObject.qXi) || (!p.i(this.qXj, paramObject.qXj)) || (!p.i(this.qXk, paramObject.qXk)) || (this.dFx != paramObject.dFx) || (this.qXl != paramObject.qXl)) {}
      }
    }
    else
    {
      AppMethodBeat.o(210867);
      return true;
    }
    AppMethodBeat.o(210867);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210865);
    String str = "StayTimeStatistics(sessionId=" + this.sessionId + ", pageName=" + this.dtL + ", stayTimeMs=" + this.qXg + ", enterTimeMs=" + this.qXh + ", exitTimeMs=" + this.qXi + ", clickTabContextId=" + this.qXj + ", sid=" + this.qXk + ", reportType=" + this.dFx + ", isPoi=" + this.qXl + ")";
    AppMethodBeat.o(210865);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */