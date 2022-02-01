package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  private String dSb;
  private String dVW;
  private String dVX;
  private long dVY;
  private long dVZ;
  private long dXX;
  private long dXY;
  private String dYa;
  
  public final String RD()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYa);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.dXX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.dXY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.dYa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final bx gT(long paramLong)
  {
    this.dXX = paramLong;
    return this;
  }
  
  public final bx gU(long paramLong)
  {
    this.dXY = paramLong;
    return this;
  }
  
  public final bx gV(long paramLong)
  {
    this.dVZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final bx kU(String paramString)
  {
    AppMethodBeat.i(168921);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final bx kV(String paramString)
  {
    AppMethodBeat.i(168922);
    this.dVW = t("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final bx kW(String paramString)
  {
    AppMethodBeat.i(168923);
    this.dVX = t("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final bx kX(String paramString)
  {
    AppMethodBeat.i(168924);
    this.dYa = t("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */