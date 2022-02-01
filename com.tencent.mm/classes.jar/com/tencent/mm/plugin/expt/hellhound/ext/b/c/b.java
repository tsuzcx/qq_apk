package com.tencent.mm.plugin.expt.hellhound.ext.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "", "sessionId", "", "pageName", "stayTimeMs", "", "enterTimeMs", "exitTimeMs", "clickTabContextId", "sid", "reportType", "", "isPoi", "", "extraInfo", "enterSourceInfo", "finderContextID", "(Ljava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClickTabContextId", "()Ljava/lang/String;", "setClickTabContextId", "(Ljava/lang/String;)V", "getEnterSourceInfo", "setEnterSourceInfo", "getEnterTimeMs", "()J", "setEnterTimeMs", "(J)V", "getExitTimeMs", "setExitTimeMs", "getExtraInfo", "setExtraInfo", "getFinderContextID", "setFinderContextID", "()Z", "setPoi", "(Z)V", "getPageName", "setPageName", "getReportType", "()I", "setReportType", "(I)V", "getSessionId", "setSessionId", "getSid", "setSid", "getStayTimeMs", "setStayTimeMs", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public String extraInfo;
  public String hJW;
  public int hYb;
  public String sessionId;
  public long zIA;
  public String zIB;
  public String zIC;
  public boolean zID;
  public String zIE;
  private String zIF;
  public long zIy;
  public long zIz;
  
  public b()
  {
    this(null, null, 0L, 0L, 0L, null, null, 0, null, null, 4095);
  }
  
  private b(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    AppMethodBeat.i(300264);
    this.sessionId = paramString1;
    this.hJW = paramString2;
    this.zIy = paramLong1;
    this.zIz = paramLong2;
    this.zIA = paramLong3;
    this.zIB = paramString3;
    this.zIC = paramString4;
    this.hYb = paramInt;
    this.zID = false;
    this.extraInfo = paramString5;
    this.zIE = null;
    this.zIF = paramString6;
    AppMethodBeat.o(300264);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(300287);
    if (this == paramObject)
    {
      AppMethodBeat.o(300287);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.hJW, paramObject.hJW))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (this.zIy != paramObject.zIy)
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (this.zIz != paramObject.zIz)
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (this.zIA != paramObject.zIA)
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.zIB, paramObject.zIB))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.zIC, paramObject.zIC))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (this.hYb != paramObject.hYb)
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (this.zID != paramObject.zID)
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.extraInfo, paramObject.extraInfo))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.zIE, paramObject.zIE))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    if (!s.p(this.zIF, paramObject.zIF))
    {
      AppMethodBeat.o(300287);
      return false;
    }
    AppMethodBeat.o(300287);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300279);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("StayTimeStatistics(sessionId=").append(this.sessionId).append(", pageName=").append(this.hJW).append(", stayTimeMs=").append(this.zIy).append(", enterTimeMs=").append(this.zIz).append(", exitTimeMs=").append(this.zIA).append(", clickTabContextId=").append(this.zIB).append(", sid=").append(this.zIC).append(", reportType=").append(this.hYb).append(", isPoi=").append(this.zID).append(", extraInfo=").append(this.extraInfo).append(", enterSourceInfo=").append(this.zIE).append(", finderContextID=");
    ((StringBuilder)localObject).append(this.zIF).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(300279);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.c.b
 * JD-Core Version:    0.7.0.1
 */