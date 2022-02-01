package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gn
  extends a
{
  private String dHL = "";
  private String dQK = "";
  private long eec = 0L;
  private long ehb = 0L;
  private long ehc = 0L;
  private int ehd = 0;
  private String ehe = "";
  private String ehf = "";
  private String ehg = "";
  private String ehh = "";
  private long ehi = 0L;
  private String ehj = "";
  private String ehk = "";
  
  public final String PV()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eec);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dHL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.ehb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.ehc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.ehd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.ehe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.ehf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.ehg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.ehh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.ehi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.ehj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.dQK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.ehk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.eec);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final gn Sl()
  {
    this.ehd = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final gn kg(long paramLong)
  {
    this.ehb = paramLong;
    return this;
  }
  
  public final gn kh(long paramLong)
  {
    this.ehc = paramLong;
    return this;
  }
  
  public final gn ki(long paramLong)
  {
    this.ehi = paramLong;
    return this;
  }
  
  public final gn kj(long paramLong)
  {
    this.eec = paramLong;
    return this;
  }
  
  public final gn mb(String paramString)
  {
    AppMethodBeat.i(43763);
    this.dHL = t("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final gn mc(String paramString)
  {
    AppMethodBeat.i(43764);
    this.ehf = t("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final gn md(String paramString)
  {
    AppMethodBeat.i(43765);
    this.ehg = t("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final gn me(String paramString)
  {
    AppMethodBeat.i(43766);
    this.ehh = t("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final gn mf(String paramString)
  {
    AppMethodBeat.i(43767);
    this.ehj = t("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final gn mg(String paramString)
  {
    AppMethodBeat.i(43768);
    this.dQK = t("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gn
 * JD-Core Version:    0.7.0.1
 */