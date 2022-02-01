package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class if
  extends a
{
  private String dFy = "";
  private String dSz = "";
  private long egi = 0L;
  private long ejh = 0L;
  private long eji = 0L;
  private int ejj = 0;
  private String ejk = "";
  private String ejl = "";
  private String ejm = "";
  private String ejn = "";
  private long ejo = 0L;
  private String ejp = "";
  private String ejq = "";
  
  public final String PR()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eji);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egi);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.ejh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.eji);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.ejj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.ejk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.ejl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.ejn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.ejo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.ejp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.ejq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.egi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final if Te()
  {
    this.ejj = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final if nI(long paramLong)
  {
    this.ejh = paramLong;
    return this;
  }
  
  public final if nJ(long paramLong)
  {
    this.eji = paramLong;
    return this;
  }
  
  public final if nK(long paramLong)
  {
    this.ejo = paramLong;
    return this;
  }
  
  public final if nL(long paramLong)
  {
    this.egi = paramLong;
    return this;
  }
  
  public final if pg(String paramString)
  {
    AppMethodBeat.i(43763);
    this.dFy = t("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final if ph(String paramString)
  {
    AppMethodBeat.i(43764);
    this.ejl = t("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final if pi(String paramString)
  {
    AppMethodBeat.i(43765);
    this.ejm = t("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final if pj(String paramString)
  {
    AppMethodBeat.i(43766);
    this.ejn = t("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final if pk(String paramString)
  {
    AppMethodBeat.i(43767);
    this.ejp = t("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final if pl(String paramString)
  {
    AppMethodBeat.i(43768);
    this.dSz = t("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.if
 * JD-Core Version:    0.7.0.1
 */