package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gu
  extends a
{
  private String dWK;
  private String ebg;
  private long eqA = 0L;
  private String eqs;
  private String eqt;
  private long equ = 0L;
  private long eqv = 0L;
  private long eqw = 0L;
  private long eqx = 0L;
  private long eqy = 0L;
  private long eqz = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(187811);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.equ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqA);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(187811);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187812);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.equ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.eqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateResult:").append(this.eqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCostTimeInMs:").append(this.eqy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackWaitTimeInMs:").append(this.eqz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ebg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.eqA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187812);
    return localObject;
  }
  
  public final int getId()
  {
    return 20579;
  }
  
  public final gu lY(long paramLong)
  {
    this.equ = paramLong;
    return this;
  }
  
  public final gu lZ(long paramLong)
  {
    this.eqv = paramLong;
    return this;
  }
  
  public final gu ma(long paramLong)
  {
    this.eqw = paramLong;
    return this;
  }
  
  public final gu mb(long paramLong)
  {
    this.eqx = paramLong;
    return this;
  }
  
  public final gu mc(long paramLong)
  {
    this.eqy = paramLong;
    return this;
  }
  
  public final gu md(long paramLong)
  {
    this.eqz = paramLong;
    return this;
  }
  
  public final gu me(long paramLong)
  {
    this.eqA = paramLong;
    return this;
  }
  
  public final gu pD(String paramString)
  {
    AppMethodBeat.i(187807);
    this.eqs = t("Appid", paramString, true);
    AppMethodBeat.o(187807);
    return this;
  }
  
  public final gu pE(String paramString)
  {
    AppMethodBeat.i(187808);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(187808);
    return this;
  }
  
  public final gu pF(String paramString)
  {
    AppMethodBeat.i(187809);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(187809);
    return this;
  }
  
  public final gu pG(String paramString)
  {
    AppMethodBeat.i(187810);
    this.ebg = t("NetType", paramString, true);
    AppMethodBeat.o(187810);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gu
 * JD-Core Version:    0.7.0.1
 */