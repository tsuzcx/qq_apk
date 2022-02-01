package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kq
  extends a
{
  private long eJb = 0L;
  private long eLO = 0L;
  private long eSS = 0L;
  private String eWa = "";
  private long eXc = 0L;
  private long eXd = 0L;
  private long eXe = 0L;
  private long eXf = 0L;
  private String eXg = "";
  private String etW = "";
  private long ezt = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(43458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXg);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43458);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43459);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsEncrypt:").append(this.eXd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.eJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.eSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RetryCount:").append(this.ezt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CmdSequence:").append(this.eXe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReportId:").append(this.eLO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageType:").append(this.eXf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PackageKey:").append(this.eXg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43459);
    return localObject;
  }
  
  public final kq aiw()
  {
    this.eXd = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 16636;
  }
  
  public final kq tO(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final kq tP(long paramLong)
  {
    this.eJb = paramLong;
    return this;
  }
  
  public final kq tQ(long paramLong)
  {
    this.eSS = paramLong;
    return this;
  }
  
  public final kq tR(long paramLong)
  {
    this.ezt = paramLong;
    return this;
  }
  
  public final kq tS(long paramLong)
  {
    this.eXe = paramLong;
    return this;
  }
  
  public final kq tT(long paramLong)
  {
    this.eLO = paramLong;
    return this;
  }
  
  public final kq tU(long paramLong)
  {
    this.eXf = paramLong;
    return this;
  }
  
  public final kq ya(String paramString)
  {
    AppMethodBeat.i(226060);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(226060);
    return this;
  }
  
  public final kq yb(String paramString)
  {
    AppMethodBeat.i(226061);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(226061);
    return this;
  }
  
  public final kq yc(String paramString)
  {
    AppMethodBeat.i(226062);
    this.eXg = x("PackageKey", paramString, true);
    AppMethodBeat.o(226062);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kq
 * JD-Core Version:    0.7.0.1
 */