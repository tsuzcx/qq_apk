package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class e
  extends a
{
  private int dPT;
  private long dPU;
  private long dPV;
  private long dPW;
  private long dPX;
  private String dPY;
  private String dPZ;
  private long dQa;
  
  public final String RD()
  {
    AppMethodBeat.i(197132);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQa);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(197132);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(197133);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqNum:").append(this.dPU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespNum:").append(this.dPV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataStartTime:").append(this.dPW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataEndTime:").append(this.dPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqContent:").append(this.dPY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespContent:").append(this.dPZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataNum:").append(this.dQa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197133);
    return localObject;
  }
  
  public final e bp(long paramLong)
  {
    this.dPU = paramLong;
    return this;
  }
  
  public final e bq(long paramLong)
  {
    this.dPV = paramLong;
    return this;
  }
  
  public final e br(long paramLong)
  {
    this.dPW = paramLong;
    return this;
  }
  
  public final e bs(long paramLong)
  {
    this.dPX = paramLong;
    return this;
  }
  
  public final e bt(long paramLong)
  {
    this.dQa = paramLong;
    return this;
  }
  
  public final e gE(String paramString)
  {
    AppMethodBeat.i(197130);
    this.dPY = t("ReqContent", paramString, true);
    AppMethodBeat.o(197130);
    return this;
  }
  
  public final e gF(String paramString)
  {
    AppMethodBeat.i(197131);
    this.dPZ = t("RespContent", paramString, true);
    AppMethodBeat.o(197131);
    return this;
  }
  
  public final int getId()
  {
    return 20808;
  }
  
  public final e jdMethod_if(int paramInt)
  {
    this.dPT = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */