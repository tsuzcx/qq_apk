package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
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
    AppMethodBeat.i(209099);
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
    AppMethodBeat.o(209099);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209100);
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
    AppMethodBeat.o(209100);
    return localObject;
  }
  
  public final as dD(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final as dE(long paramLong)
  {
    this.dWY = paramLong;
    return this;
  }
  
  public final as dF(long paramLong)
  {
    this.dWZ = paramLong;
    return this;
  }
  
  public final as dG(long paramLong)
  {
    this.dXa = paramLong;
    return this;
  }
  
  public final as dH(long paramLong)
  {
    this.dXb = paramLong;
    return this;
  }
  
  public final as dI(long paramLong)
  {
    this.dUZ = paramLong;
    return this;
  }
  
  public final as dJ(long paramLong)
  {
    this.dXd = paramLong;
    return this;
  }
  
  public final as dK(long paramLong)
  {
    this.dXe = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20713;
  }
  
  public final as ih(String paramString)
  {
    AppMethodBeat.i(209096);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209096);
    return this;
  }
  
  public final as ii(String paramString)
  {
    AppMethodBeat.i(209097);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209097);
    return this;
  }
  
  public final as ij(String paramString)
  {
    AppMethodBeat.i(209098);
    this.dXc = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(209098);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.as
 * JD-Core Version:    0.7.0.1
 */