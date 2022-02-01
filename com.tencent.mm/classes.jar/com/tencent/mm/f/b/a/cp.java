package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  private String gcV = "";
  private long gjl;
  private long gmV;
  private String gnO = "";
  private String gnq = "";
  private long gqq;
  private long gqr;
  private long gqs;
  private long gqt;
  private long gqu;
  private long gqv;
  
  public final String agH()
  {
    AppMethodBeat.i(208801);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gnO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208801);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208802);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.gnO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.gcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.gqq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.gqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.gqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.gqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.gnq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.gmV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.gqu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.gqv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208802);
    return localObject;
  }
  
  public final String ahD()
  {
    return this.gcV;
  }
  
  public final long ahE()
  {
    return this.gjl;
  }
  
  public final long ahF()
  {
    return this.gqq;
  }
  
  public final long ahG()
  {
    return this.gqr;
  }
  
  public final long ahH()
  {
    return this.gqs;
  }
  
  public final long ahI()
  {
    return this.gqt;
  }
  
  public final String ahJ()
  {
    return this.gnq;
  }
  
  public final cp ahK()
  {
    this.gmV = 10L;
    return this;
  }
  
  public final long ahL()
  {
    return this.gmV;
  }
  
  public final long ahM()
  {
    return this.gqu;
  }
  
  public final long ahN()
  {
    return this.gqv;
  }
  
  public final String ahq()
  {
    return this.gnO;
  }
  
  public final cp fR(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final cp fS(long paramLong)
  {
    this.gqq = paramLong;
    return this;
  }
  
  public final cp fT(long paramLong)
  {
    this.gqr = paramLong;
    return this;
  }
  
  public final cp fU(long paramLong)
  {
    this.gqs = paramLong;
    return this;
  }
  
  public final cp fV(long paramLong)
  {
    this.gqt = paramLong;
    return this;
  }
  
  public final cp fW(long paramLong)
  {
    this.gqu = paramLong;
    return this;
  }
  
  public final cp fX(long paramLong)
  {
    this.gqv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20672;
  }
  
  public final cp mS(String paramString)
  {
    AppMethodBeat.i(208796);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(208796);
    return this;
  }
  
  public final cp mT(String paramString)
  {
    AppMethodBeat.i(208797);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(208797);
    return this;
  }
  
  public final cp mU(String paramString)
  {
    AppMethodBeat.i(208799);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(208799);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cp
 * JD-Core Version:    0.7.0.1
 */