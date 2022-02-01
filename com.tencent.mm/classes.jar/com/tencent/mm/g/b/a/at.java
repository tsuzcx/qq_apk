package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  private long dUY;
  private long dUZ;
  private String dVa;
  private String dWX;
  private long dWY;
  private long dWZ;
  private long dXa;
  private long dXb;
  private String dXc;
  private long dXd;
  private long dXe;
  
  public final String RD()
  {
    AppMethodBeat.i(209104);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXe);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209104);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209105);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiType:").append(this.dWY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LoadingTime:").append(this.dWZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartCgiTimestamp:").append(this.dXa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("status:").append(this.dXb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.dXd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndCgiTimestamp:").append(this.dXe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209105);
    return localObject;
  }
  
  public final String RK()
  {
    return this.dVa;
  }
  
  public final String RR()
  {
    return this.dWX;
  }
  
  public final long RS()
  {
    return this.dUY;
  }
  
  public final long RT()
  {
    return this.dWY;
  }
  
  public final long RU()
  {
    return this.dWZ;
  }
  
  public final long RV()
  {
    return this.dXa;
  }
  
  public final long RW()
  {
    return this.dXb;
  }
  
  public final at RX()
  {
    this.dUZ = 2L;
    return this;
  }
  
  public final long RY()
  {
    return this.dUZ;
  }
  
  public final long RZ()
  {
    return this.dXd;
  }
  
  public final long Sa()
  {
    return this.dXe;
  }
  
  public final at dL(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final at dM(long paramLong)
  {
    this.dWY = paramLong;
    return this;
  }
  
  public final at dN(long paramLong)
  {
    this.dWZ = paramLong;
    return this;
  }
  
  public final at dO(long paramLong)
  {
    this.dXa = paramLong;
    return this;
  }
  
  public final at dP(long paramLong)
  {
    this.dXb = paramLong;
    return this;
  }
  
  public final at dQ(long paramLong)
  {
    this.dXd = paramLong;
    return this;
  }
  
  public final at dR(long paramLong)
  {
    this.dXe = paramLong;
    return this;
  }
  
  public final String getExtraInfo()
  {
    return this.dXc;
  }
  
  public final int getId()
  {
    return 20672;
  }
  
  public final at ik(String paramString)
  {
    AppMethodBeat.i(209101);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209101);
    return this;
  }
  
  public final at il(String paramString)
  {
    AppMethodBeat.i(209102);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209102);
    return this;
  }
  
  public final at im(String paramString)
  {
    AppMethodBeat.i(209103);
    this.dXc = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(209103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.at
 * JD-Core Version:    0.7.0.1
 */