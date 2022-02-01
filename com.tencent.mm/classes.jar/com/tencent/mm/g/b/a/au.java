package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String dFe;
  private long dKB;
  private long dKC;
  private long dKD;
  
  public final String PR()
  {
    AppMethodBeat.i(194978);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKD);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194978);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194979);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.dKC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.dKD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194979);
    return localObject;
  }
  
  public final au eg(long paramLong)
  {
    this.dKB = paramLong;
    return this;
  }
  
  public final au eh(long paramLong)
  {
    this.dKC = paramLong;
    return this;
  }
  
  public final au ei(long paramLong)
  {
    this.dKD = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final au ib(String paramString)
  {
    AppMethodBeat.i(194977);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194977);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */