package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kr
  extends a
{
  private long eLO = 0L;
  private String eWa = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eXf;
  private long eXh = 0L;
  private String eXi = "";
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.eXh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.eLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.eXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.eXi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final kr tV(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final kr tW(long paramLong)
  {
    this.eXh = paramLong;
    return this;
  }
  
  public final kr tX(long paramLong)
  {
    this.eLO = paramLong;
    return this;
  }
  
  public final kr tY(long paramLong)
  {
    this.eXf = paramLong;
    return this;
  }
  
  public final kr yd(String paramString)
  {
    AppMethodBeat.i(43460);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final kr ye(String paramString)
  {
    AppMethodBeat.i(43461);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final kr yf(String paramString)
  {
    AppMethodBeat.i(43462);
    this.eXi = x("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final kr yg(String paramString)
  {
    AppMethodBeat.i(43463);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kr
 * JD-Core Version:    0.7.0.1
 */