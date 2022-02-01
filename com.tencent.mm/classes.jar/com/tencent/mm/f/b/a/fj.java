package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fj
  extends a
{
  private String gcU = "";
  private long giK = 0L;
  private String gjk = "";
  private String gnq = "";
  private String gnr = "";
  private long guY = 0L;
  private long gzA = 0L;
  private String gzB = "";
  private String gzx = "";
  private long gzy = 0L;
  private String gzz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(251200);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(251200);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(251203);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.gzx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.giK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.guY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.gzy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.gzz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.gzA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderContextID:").append(this.gzB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.gnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterSourceInfo:").append(this.gnr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(251203);
    return localObject;
  }
  
  public final String agY()
  {
    return this.gjk;
  }
  
  public final String ahJ()
  {
    return this.gnq;
  }
  
  public final String akA()
  {
    return this.gzx;
  }
  
  public final long akB()
  {
    return this.guY;
  }
  
  public final long akC()
  {
    return this.gzy;
  }
  
  public final String akD()
  {
    return this.gzz;
  }
  
  public final long akE()
  {
    return this.gzA;
  }
  
  public final String akF()
  {
    return this.gzB;
  }
  
  public final String akG()
  {
    return this.gnr;
  }
  
  public final long akl()
  {
    return this.giK;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.gcU;
  }
  
  public final fj nn(long paramLong)
  {
    AppMethodBeat.i(251178);
    this.giK = paramLong;
    super.bk("StayTimeMs", this.giK);
    AppMethodBeat.o(251178);
    return this;
  }
  
  public final fj no(long paramLong)
  {
    AppMethodBeat.i(251181);
    this.guY = paramLong;
    super.bk("EnterTimeMs", this.guY);
    AppMethodBeat.o(251181);
    return this;
  }
  
  public final fj np(long paramLong)
  {
    AppMethodBeat.i(251183);
    this.gzy = paramLong;
    super.bk("ExitTimeMs", this.gzy);
    AppMethodBeat.o(251183);
    return this;
  }
  
  public final fj nq(long paramLong)
  {
    this.gzA = paramLong;
    return this;
  }
  
  public final fj ui(String paramString)
  {
    AppMethodBeat.i(251174);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(251174);
    return this;
  }
  
  public final fj uj(String paramString)
  {
    AppMethodBeat.i(251176);
    this.gzx = z("PageName", paramString, true);
    AppMethodBeat.o(251176);
    return this;
  }
  
  public final fj uk(String paramString)
  {
    AppMethodBeat.i(251187);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(251187);
    return this;
  }
  
  public final fj ul(String paramString)
  {
    AppMethodBeat.i(251191);
    this.gzz = z("Sid", paramString, true);
    AppMethodBeat.o(251191);
    return this;
  }
  
  public final fj um(String paramString)
  {
    AppMethodBeat.i(251196);
    this.gzB = z("FinderContextID", paramString, true);
    AppMethodBeat.o(251196);
    return this;
  }
  
  public final fj un(String paramString)
  {
    AppMethodBeat.i(251197);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(251197);
    return this;
  }
  
  public final fj uo(String paramString)
  {
    AppMethodBeat.i(251199);
    this.gnr = z("enterSourceInfo", paramString, true);
    AppMethodBeat.o(251199);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fj
 * JD-Core Version:    0.7.0.1
 */