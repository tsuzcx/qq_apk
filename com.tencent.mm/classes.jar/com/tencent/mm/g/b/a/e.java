package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class e
  extends a
{
  private int dRj;
  private long dRk;
  private long dRl;
  private long dRm;
  private long dRn;
  private String dRo = "";
  private String dRp = "";
  private long dRq;
  
  public final String RC()
  {
    AppMethodBeat.i(221070);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRq);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221070);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221071);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqNum:").append(this.dRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespNum:").append(this.dRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataStartTime:").append(this.dRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataEndTime:").append(this.dRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqContent:").append(this.dRo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespContent:").append(this.dRp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataNum:").append(this.dRq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221071);
    return localObject;
  }
  
  public final e bp(long paramLong)
  {
    this.dRk = paramLong;
    return this;
  }
  
  public final e bq(long paramLong)
  {
    this.dRl = paramLong;
    return this;
  }
  
  public final e br(long paramLong)
  {
    this.dRm = paramLong;
    return this;
  }
  
  public final e bs(long paramLong)
  {
    this.dRn = paramLong;
    return this;
  }
  
  public final e bt(long paramLong)
  {
    this.dRq = paramLong;
    return this;
  }
  
  public final e gK(String paramString)
  {
    AppMethodBeat.i(221068);
    this.dRo = t("ReqContent", paramString, true);
    AppMethodBeat.o(221068);
    return this;
  }
  
  public final e gL(String paramString)
  {
    AppMethodBeat.i(221069);
    this.dRp = t("RespContent", paramString, true);
    AppMethodBeat.o(221069);
    return this;
  }
  
  public final int getId()
  {
    return 20808;
  }
  
  public final e ih(int paramInt)
  {
    this.dRj = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */