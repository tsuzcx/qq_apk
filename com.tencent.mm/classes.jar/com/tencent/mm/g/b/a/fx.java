package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fx
  extends a
{
  private String dJb = "";
  private String dZT;
  private String dZU = "";
  private long eaM = 0L;
  private long eaQ = 0L;
  private long eaR;
  private long eaT = 0L;
  private String eaU;
  
  public final String PR()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZT);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eaM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.eaT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.eaQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.eaR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.eaU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final fx kp(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final fx kq(long paramLong)
  {
    this.eaT = paramLong;
    return this;
  }
  
  public final fx kr(long paramLong)
  {
    this.eaQ = paramLong;
    return this;
  }
  
  public final fx ks(long paramLong)
  {
    this.eaR = paramLong;
    return this;
  }
  
  public final fx nu(String paramString)
  {
    AppMethodBeat.i(43460);
    this.dJb = t("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final fx nv(String paramString)
  {
    AppMethodBeat.i(43461);
    this.dZU = t("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final fx nw(String paramString)
  {
    AppMethodBeat.i(43462);
    this.eaU = t("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final fx nx(String paramString)
  {
    AppMethodBeat.i(43463);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fx
 * JD-Core Version:    0.7.0.1
 */