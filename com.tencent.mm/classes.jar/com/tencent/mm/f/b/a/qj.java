package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qj
  extends a
{
  private String giT = "";
  private String gtA = "";
  private long gtV = 0L;
  private String gym = "";
  private long hfY = 0L;
  private long hjB = 0L;
  private int hjC = 0;
  private String hjD = "";
  private String hjE = "";
  private String hjF = "";
  private String hjG = "";
  private long hjH = 0L;
  private String hjI = "";
  private String hjJ = "";
  private long hjK = 0L;
  private String hjL = "";
  private long hjM = 0L;
  
  public final qj DI(long paramLong)
  {
    this.gtV = paramLong;
    return this;
  }
  
  public final qj DJ(long paramLong)
  {
    this.hjB = paramLong;
    return this;
  }
  
  public final qj DK(long paramLong)
  {
    this.hjH = paramLong;
    return this;
  }
  
  public final qj DL(long paramLong)
  {
    this.hfY = paramLong;
    return this;
  }
  
  public final qj He(String paramString)
  {
    AppMethodBeat.i(43763);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(43763);
    return this;
  }
  
  public final qj Hf(String paramString)
  {
    AppMethodBeat.i(43764);
    this.hjE = z("errorMessage", paramString, true);
    AppMethodBeat.o(43764);
    return this;
  }
  
  public final qj Hg(String paramString)
  {
    AppMethodBeat.i(43765);
    this.hjF = z("errorStack", paramString, true);
    AppMethodBeat.o(43765);
    return this;
  }
  
  public final qj Hh(String paramString)
  {
    AppMethodBeat.i(43766);
    this.hjG = z("sdkversion", paramString, true);
    AppMethodBeat.o(43766);
    return this;
  }
  
  public final qj Hi(String paramString)
  {
    AppMethodBeat.i(43767);
    this.hjI = z("route", paramString, true);
    AppMethodBeat.o(43767);
    return this;
  }
  
  public final qj Hj(String paramString)
  {
    AppMethodBeat.i(43768);
    this.gym = z("query", paramString, true);
    AppMethodBeat.o(43768);
    return this;
  }
  
  public final qj Hk(String paramString)
  {
    AppMethodBeat.i(278286);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(278286);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43769);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gym);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hfY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtA);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43769);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appversion:").append(this.gtV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appstate:").append(this.hjB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorType:").append(this.hjC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorName:").append(this.hjD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorMessage:").append(this.hjE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorStack:").append(this.hjF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkversion:").append(this.hjG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("apptype:").append(this.hjH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("route:").append(this.hjI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.gym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkupdatetime:").append(this.hjJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneId:").append(this.hfY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUnhandledRejection:").append(this.hjK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("source:").append(this.hjL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pluginversion:").append(this.hjM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43770);
    return localObject;
  }
  
  public final qj aoW()
  {
    this.hjC = 9;
    return this;
  }
  
  public final int getId()
  {
    return 13582;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qj
 * JD-Core Version:    0.7.0.1
 */