package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mb
  extends a
{
  private long eFm;
  private String enR = "";
  private String exq = "";
  private String faS = "";
  private String faT = "";
  private long faU;
  private long faV;
  private long faW;
  private int faX;
  private int faY;
  private int faZ;
  
  public final String abV()
  {
    AppMethodBeat.i(226068);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.faS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.faZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226068);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226069);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.faS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.enR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.faT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startTimeStamp:").append(this.faU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("endTimeStamp:").append(this.faV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.eFm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("responseSize:").append(this.faW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ret:").append(this.faX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bizRet:").append(this.faY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cgiNo:").append(this.faZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226069);
    return localObject;
  }
  
  public final int getId()
  {
    return 19127;
  }
  
  public final mb mn(int paramInt)
  {
    this.faX = paramInt;
    return this;
  }
  
  public final mb mo(int paramInt)
  {
    this.faY = paramInt;
    return this;
  }
  
  public final mb mp(int paramInt)
  {
    this.faZ = paramInt;
    return this;
  }
  
  public final mb vB(long paramLong)
  {
    this.faU = paramLong;
    return this;
  }
  
  public final mb vC(long paramLong)
  {
    this.faV = paramLong;
    return this;
  }
  
  public final mb vD(long paramLong)
  {
    this.eFm = paramLong;
    return this;
  }
  
  public final mb vE(long paramLong)
  {
    this.faW = paramLong;
    return this;
  }
  
  public final mb zl(String paramString)
  {
    AppMethodBeat.i(226064);
    this.faS = x("instanceId", paramString, true);
    AppMethodBeat.o(226064);
    return this;
  }
  
  public final mb zm(String paramString)
  {
    AppMethodBeat.i(226065);
    this.enR = x("appid", paramString, true);
    AppMethodBeat.o(226065);
    return this;
  }
  
  public final mb zn(String paramString)
  {
    AppMethodBeat.i(226066);
    this.faT = x("username", paramString, true);
    AppMethodBeat.o(226066);
    return this;
  }
  
  public final mb zo(String paramString)
  {
    AppMethodBeat.i(226067);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(226067);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mb
 * JD-Core Version:    0.7.0.1
 */