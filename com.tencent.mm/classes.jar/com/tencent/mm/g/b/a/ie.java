package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  private String dSD;
  private long edk;
  private String etv;
  private String euQ;
  private String euR;
  private long euS;
  private long euT;
  private long euU;
  private int euV;
  private int euW;
  private int euX;
  
  public final String RD()
  {
    AppMethodBeat.i(187830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(187830);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187831);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.euQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.euR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startTimeStamp:").append(this.euS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("endTimeStamp:").append(this.euT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.edk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("responseSize:").append(this.euU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ret:").append(this.euV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bizRet:").append(this.euW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cgiNo:").append(this.euX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187831);
    return localObject;
  }
  
  public final int getId()
  {
    return 19127;
  }
  
  public final ie jj(int paramInt)
  {
    this.euV = paramInt;
    return this;
  }
  
  public final ie jk(int paramInt)
  {
    this.euW = paramInt;
    return this;
  }
  
  public final ie jl(int paramInt)
  {
    this.euX = paramInt;
    return this;
  }
  
  public final ie nF(long paramLong)
  {
    this.euS = paramLong;
    return this;
  }
  
  public final ie nG(long paramLong)
  {
    this.euT = paramLong;
    return this;
  }
  
  public final ie nH(long paramLong)
  {
    this.edk = paramLong;
    return this;
  }
  
  public final ie nI(long paramLong)
  {
    this.euU = paramLong;
    return this;
  }
  
  public final ie qN(String paramString)
  {
    AppMethodBeat.i(187826);
    this.euQ = t("instanceId", paramString, true);
    AppMethodBeat.o(187826);
    return this;
  }
  
  public final ie qO(String paramString)
  {
    AppMethodBeat.i(187827);
    this.dSD = t("appid", paramString, true);
    AppMethodBeat.o(187827);
    return this;
  }
  
  public final ie qP(String paramString)
  {
    AppMethodBeat.i(187828);
    this.euR = t("username", paramString, true);
    AppMethodBeat.o(187828);
    return this;
  }
  
  public final ie qQ(String paramString)
  {
    AppMethodBeat.i(187829);
    this.etv = t("networkType", paramString, true);
    AppMethodBeat.o(187829);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ie
 * JD-Core Version:    0.7.0.1
 */