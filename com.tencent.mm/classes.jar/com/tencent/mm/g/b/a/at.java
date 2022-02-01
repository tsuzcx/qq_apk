package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  private long dWo;
  private long dWp;
  private String dWq = "";
  private String dXu = "";
  private String dYp = "";
  private long dYq;
  private long dYr;
  private long dYs;
  private long dYt;
  private long dYu;
  private long dYv;
  
  public final String RC()
  {
    AppMethodBeat.i(189136);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189136);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189137);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.dYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.dYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.dYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.dYt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.dYu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.dYv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189137);
    return localObject;
  }
  
  public final String RJ()
  {
    return this.dWq;
  }
  
  public final String RP()
  {
    return this.dYp;
  }
  
  public final long RQ()
  {
    return this.dWo;
  }
  
  public final long RR()
  {
    return this.dYq;
  }
  
  public final long RS()
  {
    return this.dYr;
  }
  
  public final long RT()
  {
    return this.dYs;
  }
  
  public final long RU()
  {
    return this.dYt;
  }
  
  public final at RV()
  {
    this.dWp = 3L;
    return this;
  }
  
  public final long RW()
  {
    return this.dWp;
  }
  
  public final long RX()
  {
    return this.dYu;
  }
  
  public final long RY()
  {
    return this.dYv;
  }
  
  public final at dM(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final at dN(long paramLong)
  {
    this.dYq = paramLong;
    return this;
  }
  
  public final at dO(long paramLong)
  {
    this.dYr = paramLong;
    return this;
  }
  
  public final at dP(long paramLong)
  {
    this.dYs = paramLong;
    return this;
  }
  
  public final at dQ(long paramLong)
  {
    this.dYt = paramLong;
    return this;
  }
  
  public final at dR(long paramLong)
  {
    this.dYu = paramLong;
    return this;
  }
  
  public final at dS(long paramLong)
  {
    this.dYv = paramLong;
    return this;
  }
  
  public final String getExtraInfo()
  {
    return this.dXu;
  }
  
  public final int getId()
  {
    return 20672;
  }
  
  public final at iu(String paramString)
  {
    AppMethodBeat.i(189133);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189133);
    return this;
  }
  
  public final at iv(String paramString)
  {
    AppMethodBeat.i(189134);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189134);
    return this;
  }
  
  public final at iw(String paramString)
  {
    AppMethodBeat.i(189135);
    this.dXu = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(189135);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */