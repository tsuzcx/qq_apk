package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nn
  extends a
{
  private long gLD = 0L;
  private long gYL = 0L;
  private long gZK;
  private long gZM = 0L;
  private String gZN = "";
  private String gfm = "";
  private String gfn = "";
  private String gqd = "";
  
  public final nn Ev(String paramString)
  {
    AppMethodBeat.i(43460);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(43460);
    return this;
  }
  
  public final nn Ew(String paramString)
  {
    AppMethodBeat.i(43461);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(43461);
    return this;
  }
  
  public final nn Ex(String paramString)
  {
    AppMethodBeat.i(43462);
    this.gZN = z("ModuleName", paramString, true);
    AppMethodBeat.o(43462);
    return this;
  }
  
  public final nn Ey(String paramString)
  {
    AppMethodBeat.i(43463);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(43463);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfn);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43464);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43465);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFirstHit:").append(this.gZM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.gLD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.gZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModuleName:").append(this.gZN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43465);
    return localObject;
  }
  
  public final int getId()
  {
    return 16634;
  }
  
  public final nn zK(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final nn zL(long paramLong)
  {
    this.gZM = paramLong;
    return this;
  }
  
  public final nn zM(long paramLong)
  {
    this.gLD = paramLong;
    return this;
  }
  
  public final nn zN(long paramLong)
  {
    this.gZK = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nn
 * JD-Core Version:    0.7.0.1
 */