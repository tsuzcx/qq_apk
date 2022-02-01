package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  private String dSb;
  private long enE;
  private long enF;
  private long enG;
  private long enH;
  
  public final String RD()
  {
    AppMethodBeat.i(219013);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219013);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219014);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.enE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.enF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.enG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.enH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219014);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
  
  public final gh lM(long paramLong)
  {
    this.enE = paramLong;
    return this;
  }
  
  public final gh lN(long paramLong)
  {
    this.enF = paramLong;
    return this;
  }
  
  public final gh lO(long paramLong)
  {
    this.enG = paramLong;
    return this;
  }
  
  public final gh lP(long paramLong)
  {
    this.enH = paramLong;
    return this;
  }
  
  public final gh pe(String paramString)
  {
    AppMethodBeat.i(219012);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(219012);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gh
 * JD-Core Version:    0.7.0.1
 */