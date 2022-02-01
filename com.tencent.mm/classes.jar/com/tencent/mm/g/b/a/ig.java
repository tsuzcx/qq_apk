package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ig
  extends a
{
  private String dTT = "";
  private long eeF;
  private String evc = "";
  private long ewA;
  private long ewB;
  private int ewC;
  private int ewD;
  private int ewE;
  private String ewx = "";
  private String ewy = "";
  private long ewz;
  
  public final String RC()
  {
    AppMethodBeat.i(221939);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ewx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewE);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221939);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221940);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.ewx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.ewy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startTimeStamp:").append(this.ewz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("endTimeStamp:").append(this.ewA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.eeF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("responseSize:").append(this.ewB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ret:").append(this.ewC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bizRet:").append(this.ewD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cgiNo:").append(this.ewE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221940);
    return localObject;
  }
  
  public final int getId()
  {
    return 19127;
  }
  
  public final ig jl(int paramInt)
  {
    this.ewC = paramInt;
    return this;
  }
  
  public final ig jm(int paramInt)
  {
    this.ewD = paramInt;
    return this;
  }
  
  public final ig jn(int paramInt)
  {
    this.ewE = paramInt;
    return this;
  }
  
  public final ig nR(long paramLong)
  {
    this.ewz = paramLong;
    return this;
  }
  
  public final ig nS(long paramLong)
  {
    this.ewA = paramLong;
    return this;
  }
  
  public final ig nT(long paramLong)
  {
    this.eeF = paramLong;
    return this;
  }
  
  public final ig nU(long paramLong)
  {
    this.ewB = paramLong;
    return this;
  }
  
  public final ig ri(String paramString)
  {
    AppMethodBeat.i(221935);
    this.ewx = t("instanceId", paramString, true);
    AppMethodBeat.o(221935);
    return this;
  }
  
  public final ig rj(String paramString)
  {
    AppMethodBeat.i(221936);
    this.dTT = t("appid", paramString, true);
    AppMethodBeat.o(221936);
    return this;
  }
  
  public final ig rk(String paramString)
  {
    AppMethodBeat.i(221937);
    this.ewy = t("username", paramString, true);
    AppMethodBeat.o(221937);
    return this;
  }
  
  public final ig rl(String paramString)
  {
    AppMethodBeat.i(221938);
    this.evc = t("networkType", paramString, true);
    AppMethodBeat.o(221938);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ig
 * JD-Core Version:    0.7.0.1
 */