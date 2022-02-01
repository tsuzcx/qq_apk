package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  private String dSb;
  private String dXz;
  private long dYD;
  private long dYE;
  private long dYF;
  
  public final String RD()
  {
    AppMethodBeat.i(209167);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXz);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209167);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209168);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.dYE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.dYF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dXz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209168);
    return localObject;
  }
  
  public final bf fb(long paramLong)
  {
    this.dYD = paramLong;
    return this;
  }
  
  public final bf fc(long paramLong)
  {
    this.dYE = paramLong;
    return this;
  }
  
  public final bf fd(long paramLong)
  {
    this.dYF = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final bf jy(String paramString)
  {
    AppMethodBeat.i(209165);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209165);
    return this;
  }
  
  public final bf jz(String paramString)
  {
    AppMethodBeat.i(209166);
    this.dXz = t("feedid", paramString, true);
    AppMethodBeat.o(209166);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */