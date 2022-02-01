package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  private String dQt;
  private long dYT;
  private long dYU;
  private long dYV;
  private long dYW;
  private long dYX;
  private long dYY;
  private long dYZ;
  
  public final String RD()
  {
    AppMethodBeat.i(209174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209174);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dQt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDotEnter:").append(this.dYU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.dYV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BannerType:").append(this.dYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.dYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveRedDot:").append(this.dYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCnt:").append(this.dYZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209175);
    return localObject;
  }
  
  public final bh fq(long paramLong)
  {
    AppMethodBeat.i(209173);
    this.dYT = paramLong;
    super.bf("EnterTimeMs", this.dYT);
    AppMethodBeat.o(209173);
    return this;
  }
  
  public final bh fr(long paramLong)
  {
    this.dYU = paramLong;
    return this;
  }
  
  public final bh fs(long paramLong)
  {
    this.dYV = paramLong;
    return this;
  }
  
  public final bh ft(long paramLong)
  {
    this.dYW = paramLong;
    return this;
  }
  
  public final bh fu(long paramLong)
  {
    this.dYX = paramLong;
    return this;
  }
  
  public final bh fv(long paramLong)
  {
    this.dYY = paramLong;
    return this;
  }
  
  public final bh fw(long paramLong)
  {
    this.dYZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20372;
  }
  
  public final bh jB(String paramString)
  {
    AppMethodBeat.i(209172);
    this.dQt = t("sessionid", paramString, true);
    AppMethodBeat.o(209172);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bh
 * JD-Core Version:    0.7.0.1
 */