package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  private String dHr;
  private long dNI;
  private long lYs;
  private long lYt;
  
  public final String PV()
  {
    AppMethodBeat.i(203761);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYt);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203761);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.lYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.lYt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203762);
    return localObject;
  }
  
  public final hr aSa(String paramString)
  {
    AppMethodBeat.i(203760);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203760);
    return this;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final hr yN(long paramLong)
  {
    this.dNI = paramLong;
    return this;
  }
  
  public final hr yO(long paramLong)
  {
    this.lYs = paramLong;
    return this;
  }
  
  public final hr yP(long paramLong)
  {
    this.lYt = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr
 * JD-Core Version:    0.7.0.1
 */