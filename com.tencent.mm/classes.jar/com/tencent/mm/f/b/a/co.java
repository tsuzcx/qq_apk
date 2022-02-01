package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class co
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
    AppMethodBeat.i(208002);
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
    AppMethodBeat.o(208002);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208004);
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
    AppMethodBeat.o(208004);
    return localObject;
  }
  
  public final co fJ(long paramLong)
  {
    this.gjl = paramLong;
    return this;
  }
  
  public final co fK(long paramLong)
  {
    this.gqq = paramLong;
    return this;
  }
  
  public final co fL(long paramLong)
  {
    this.gqr = paramLong;
    return this;
  }
  
  public final co fM(long paramLong)
  {
    this.gqs = paramLong;
    return this;
  }
  
  public final co fN(long paramLong)
  {
    this.gqt = paramLong;
    return this;
  }
  
  public final co fO(long paramLong)
  {
    this.gmV = paramLong;
    return this;
  }
  
  public final co fP(long paramLong)
  {
    this.gqu = paramLong;
    return this;
  }
  
  public final co fQ(long paramLong)
  {
    this.gqv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20713;
  }
  
  public final co mP(String paramString)
  {
    AppMethodBeat.i(207995);
    this.gnO = z("Sessionid", paramString, true);
    AppMethodBeat.o(207995);
    return this;
  }
  
  public final co mQ(String paramString)
  {
    AppMethodBeat.i(207996);
    this.gcV = z("ClickTabContextid", paramString, true);
    AppMethodBeat.o(207996);
    return this;
  }
  
  public final co mR(String paramString)
  {
    AppMethodBeat.i(207997);
    this.gnq = z("ExtraInfo", paramString, true);
    AppMethodBeat.o(207997);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.co
 * JD-Core Version:    0.7.0.1
 */