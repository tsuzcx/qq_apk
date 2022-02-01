package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nm
  extends a
{
  private long gHC = 0L;
  private long gLD = 0L;
  private long gTn = 0L;
  private long gYL = 0L;
  private long gZI = 0L;
  private long gZJ = 0L;
  private long gZK = 0L;
  private String gZL = "";
  private String gfm = "";
  private String gqd = "";
  private long gvq = 0L;
  
  public final nm Es(String paramString)
  {
    AppMethodBeat.i(282827);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(282827);
    return this;
  }
  
  public final nm Et(String paramString)
  {
    AppMethodBeat.i(282828);
    this.gfm = z("Appid", paramString, true);
    AppMethodBeat.o(282828);
    return this;
  }
  
  public final nm Eu(String paramString)
  {
    AppMethodBeat.i(282830);
    this.gZL = z("PackageKey", paramString, true);
    AppMethodBeat.o(282830);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.gfm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.gZI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.gHC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.gTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.gvq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.gZJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.gLD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.gZK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.gZL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final nm anZ()
  {
    this.gZI = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 16636;
  }
  
  public final nm zD(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final nm zE(long paramLong)
  {
    this.gHC = paramLong;
    return this;
  }
  
  public final nm zF(long paramLong)
  {
    this.gTn = paramLong;
    return this;
  }
  
  public final nm zG(long paramLong)
  {
    this.gvq = paramLong;
    return this;
  }
  
  public final nm zH(long paramLong)
  {
    this.gZJ = paramLong;
    return this;
  }
  
  public final nm zI(long paramLong)
  {
    this.gLD = paramLong;
    return this;
  }
  
  public final nm zJ(long paramLong)
  {
    this.gZK = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nm
 * JD-Core Version:    0.7.0.1
 */