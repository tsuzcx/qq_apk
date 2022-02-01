package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class di
  extends a
{
  private long dCQ = 0L;
  private String dHv;
  private String dHx;
  private long dJR = 0L;
  private long dKB = 0L;
  private long dPp = 0L;
  private String dRR;
  private String dRS;
  private long dRT = 0L;
  private long dRU = 0L;
  private long dRV = 0L;
  private String dRW;
  private String dRX;
  private String dRY;
  private String dRZ;
  
  public final String JC()
  {
    return this.dHx;
  }
  
  public final String PR()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dPp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.dRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.dRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.dHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.dHx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.dRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.dRU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.dRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.dRW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.dRX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.dRY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.dRZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final String QW()
  {
    return this.dHv;
  }
  
  public final di QX()
  {
    this.dRT = 4L;
    return this;
  }
  
  public final String QY()
  {
    return this.dRW;
  }
  
  public final String QZ()
  {
    return this.dRX;
  }
  
  public final String Ra()
  {
    return this.dRY;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final di ii(long paramLong)
  {
    this.dPp = paramLong;
    return this;
  }
  
  public final di ij(long paramLong)
  {
    this.dCQ = paramLong;
    return this;
  }
  
  public final di ik(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final di lf(String paramString)
  {
    AppMethodBeat.i(104424);
    this.dRR = t("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final di lg(String paramString)
  {
    AppMethodBeat.i(104425);
    this.dRS = t("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final di lh(String paramString)
  {
    AppMethodBeat.i(104426);
    this.dHv = t("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final di li(String paramString)
  {
    AppMethodBeat.i(104427);
    this.dHx = t("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final di lj(String paramString)
  {
    AppMethodBeat.i(104428);
    this.dRW = t("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final di lk(String paramString)
  {
    AppMethodBeat.i(104429);
    this.dRX = t("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final di ll(String paramString)
  {
    AppMethodBeat.i(104430);
    this.dRY = t("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final di lm(String paramString)
  {
    AppMethodBeat.i(209774);
    this.dRZ = t("ChatID", paramString, true);
    AppMethodBeat.o(209774);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.di
 * JD-Core Version:    0.7.0.1
 */