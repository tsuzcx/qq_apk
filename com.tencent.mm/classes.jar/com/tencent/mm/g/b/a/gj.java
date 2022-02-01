package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  private String dTr = "";
  private long epm;
  private long epn;
  private long epo;
  private long epp;
  
  public final String RC()
  {
    AppMethodBeat.i(188491);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188491);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.epm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.epn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.epo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.epp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188492);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
  
  public final gj lX(long paramLong)
  {
    this.epm = paramLong;
    return this;
  }
  
  public final gj lY(long paramLong)
  {
    this.epn = paramLong;
    return this;
  }
  
  public final gj lZ(long paramLong)
  {
    this.epo = paramLong;
    return this;
  }
  
  public final gj ma(long paramLong)
  {
    this.epp = paramLong;
    return this;
  }
  
  public final gj pA(String paramString)
  {
    AppMethodBeat.i(188490);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(188490);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gj
 * JD-Core Version:    0.7.0.1
 */