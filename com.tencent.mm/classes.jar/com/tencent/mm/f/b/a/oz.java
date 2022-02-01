package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oz
  extends a
{
  private long gDG;
  private String gXM = "";
  private String giT = "";
  private String gtA = "";
  private String hdK = "";
  private long hdL;
  private long hdM;
  private long hdN;
  private int hdO;
  private int hdP;
  private int hdQ;
  
  public final oz Bw(long paramLong)
  {
    this.hdL = paramLong;
    return this;
  }
  
  public final oz Bx(long paramLong)
  {
    this.hdM = paramLong;
    return this;
  }
  
  public final oz By(long paramLong)
  {
    this.gDG = paramLong;
    return this;
  }
  
  public final oz Bz(long paramLong)
  {
    this.hdN = paramLong;
    return this;
  }
  
  public final oz FR(String paramString)
  {
    AppMethodBeat.i(279472);
    this.hdK = z("instanceId", paramString, true);
    AppMethodBeat.o(279472);
    return this;
  }
  
  public final oz FS(String paramString)
  {
    AppMethodBeat.i(279473);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(279473);
    return this;
  }
  
  public final oz FT(String paramString)
  {
    AppMethodBeat.i(279474);
    this.gXM = z("username", paramString, true);
    AppMethodBeat.o(279474);
    return this;
  }
  
  public final oz FU(String paramString)
  {
    AppMethodBeat.i(279476);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(279476);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(279478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hdK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hdQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(279478);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(279479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.hdK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.gXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startTimeStamp:").append(this.hdL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("endTimeStamp:").append(this.hdM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.gDG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("responseSize:").append(this.hdN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ret:").append(this.hdO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bizRet:").append(this.hdP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cgiNo:").append(this.hdQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(279479);
    return localObject;
  }
  
  public final int getId()
  {
    return 19127;
  }
  
  public final oz oA(int paramInt)
  {
    this.hdQ = paramInt;
    return this;
  }
  
  public final oz oy(int paramInt)
  {
    this.hdO = paramInt;
    return this;
  }
  
  public final oz oz(int paramInt)
  {
    this.hdP = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oz
 * JD-Core Version:    0.7.0.1
 */