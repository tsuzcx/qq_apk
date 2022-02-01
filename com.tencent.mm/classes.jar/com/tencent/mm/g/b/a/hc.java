package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hc
  extends a
{
  private String dYc = "";
  private String erZ = "";
  private String esa = "";
  private long etb = 0L;
  private long etf = 0L;
  private long etg;
  private long eti = 0L;
  private String etj = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eti);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.eti);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.etf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.etg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.etj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final hc mv(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final hc mw(long paramLong)
  {
    this.eti = paramLong;
    return this;
  }
  
  public final hc mx(long paramLong)
  {
    this.etf = paramLong;
    return this;
  }
  
  public final hc my(long paramLong)
  {
    this.etg = paramLong;
    return this;
  }
  
  public final hc qo(String paramString)
  {
    AppMethodBeat.i(43460);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final hc qp(String paramString)
  {
    AppMethodBeat.i(43461);
    this.erZ = t("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final hc qq(String paramString)
  {
    AppMethodBeat.i(43462);
    this.etj = t("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final hc qr(String paramString)
  {
    AppMethodBeat.i(43463);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hc
 * JD-Core Version:    0.7.0.1
 */