package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jl
  extends a
{
  private String dTT = "";
  private long eBQ = 0L;
  private long eBR = 0L;
  private int eBS = 0;
  private String eBT = "";
  private String eBU = "";
  private String eBV = "";
  private String eBW = "";
  private long eBX = 0L;
  private String eBY = "";
  private String eBZ = "";
  private String ejP = "";
  private long eyH = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyH);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.eBQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.eBR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.eBS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.eBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.eBU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.eBV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.eBW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.eBX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.eBY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.ejP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.eBZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.eyH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final jl Vz()
  {
    this.eBS = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
  
  public final jl pT(long paramLong)
  {
    this.eBQ = paramLong;
    return this;
  }
  
  public final jl pU(long paramLong)
  {
    this.eBR = paramLong;
    return this;
  }
  
  public final jl pV(long paramLong)
  {
    this.eBX = paramLong;
    return this;
  }
  
  public final jl pW(long paramLong)
  {
    this.eyH = paramLong;
    return this;
  }
  
  public final jl si(String paramString)
  {
    AppMethodBeat.i(43763);
    this.dTT = t("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final jl sj(String paramString)
  {
    AppMethodBeat.i(43764);
    this.eBU = t("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final jl sk(String paramString)
  {
    AppMethodBeat.i(43765);
    this.eBV = t("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final jl sl(String paramString)
  {
    AppMethodBeat.i(43766);
    this.eBW = t("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final jl sm(String paramString)
  {
    AppMethodBeat.i(43767);
    this.eBY = t("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final jl sn(String paramString)
  {
    AppMethodBeat.i(43768);
    this.ejP = t("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jl
 * JD-Core Version:    0.7.0.1
 */