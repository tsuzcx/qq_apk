package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  private String dTr = "";
  private String dYQ = "";
  private long dZW;
  private long dZX;
  private long dZY;
  
  public final String RC()
  {
    AppMethodBeat.i(189201);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYQ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189201);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189202);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOverlap:").append(this.dZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverlapCount:").append(this.dZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dYQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189202);
    return localObject;
  }
  
  public final bf fe(long paramLong)
  {
    this.dZW = paramLong;
    return this;
  }
  
  public final bf ff(long paramLong)
  {
    this.dZX = paramLong;
    return this;
  }
  
  public final bf fg(long paramLong)
  {
    this.dZY = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19946;
  }
  
  public final bf jK(String paramString)
  {
    AppMethodBeat.i(189199);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189199);
    return this;
  }
  
  public final bf jL(String paramString)
  {
    AppMethodBeat.i(189200);
    this.dYQ = t("feedid", paramString, true);
    AppMethodBeat.o(189200);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bf
 * JD-Core Version:    0.7.0.1
 */