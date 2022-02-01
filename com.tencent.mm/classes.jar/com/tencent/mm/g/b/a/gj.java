package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  private long enE;
  private long enF;
  private long enG;
  private String enN;
  private long enP;
  
  public final String RD()
  {
    AppMethodBeat.i(219018);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enN);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219018);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219019);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.enE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.enF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.enG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordSize:").append(this.enP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordVersion:").append(this.enN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219019);
    return localObject;
  }
  
  public final int getId()
  {
    return 20203;
  }
  
  public final gj lQ(long paramLong)
  {
    this.enE = paramLong;
    return this;
  }
  
  public final gj lR(long paramLong)
  {
    this.enF = paramLong;
    return this;
  }
  
  public final gj lS(long paramLong)
  {
    this.enG = paramLong;
    return this;
  }
  
  public final gj lT(long paramLong)
  {
    this.enP = paramLong;
    return this;
  }
  
  public final gj pf(String paramString)
  {
    AppMethodBeat.i(219017);
    this.enN = t("WordVersion", paramString, true);
    AppMethodBeat.o(219017);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gj
 * JD-Core Version:    0.7.0.1
 */