package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ha
  extends a
{
  private String dWK = "";
  private String eqs = "";
  private String eqt;
  private long erB = 0L;
  private String erC;
  private long eru = 0L;
  private long ery = 0L;
  private long erz;
  
  public final String RD()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqt);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.erB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.erz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.erC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final ha mj(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final ha mk(long paramLong)
  {
    this.erB = paramLong;
    return this;
  }
  
  public final ha ml(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final ha mm(long paramLong)
  {
    this.erz = paramLong;
    return this;
  }
  
  public final ha pT(String paramString)
  {
    AppMethodBeat.i(43460);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final ha pU(String paramString)
  {
    AppMethodBeat.i(43461);
    this.eqs = t("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final ha pV(String paramString)
  {
    AppMethodBeat.i(43462);
    this.erC = t("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final ha pW(String paramString)
  {
    AppMethodBeat.i(43463);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ha
 * JD-Core Version:    0.7.0.1
 */