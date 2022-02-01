package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  private String dKt = "";
  private long dYT = 0L;
  private long dYY = 0L;
  private long dYZ;
  private String dYa;
  private String dYb = "";
  private long dZb = 0L;
  private String dZc;
  
  public final String PV()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYa);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.dZb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.dYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.dYZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.dZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final eh gU(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final eh gV(long paramLong)
  {
    this.dZb = paramLong;
    return this;
  }
  
  public final eh gW(long paramLong)
  {
    this.dYY = paramLong;
    return this;
  }
  
  public final eh gX(long paramLong)
  {
    this.dYZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final eh kC(String paramString)
  {
    AppMethodBeat.i(43460);
    this.dKt = t("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final eh kD(String paramString)
  {
    AppMethodBeat.i(43461);
    this.dYb = t("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final eh kE(String paramString)
  {
    AppMethodBeat.i(43462);
    this.dZc = t("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final eh kF(String paramString)
  {
    AppMethodBeat.i(43463);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eh
 * JD-Core Version:    0.7.0.1
 */