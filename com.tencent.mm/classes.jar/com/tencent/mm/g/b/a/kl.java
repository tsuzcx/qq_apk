package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kl
  extends a
{
  private String eWa = "";
  private String eWb = "";
  private long eWc = 0L;
  private long eWd = 0L;
  private long eWe = 0L;
  private long eWf = 0L;
  private long eWg = 0L;
  private long eWh = 0L;
  private long eWi = 0L;
  private long eWj = 0L;
  private String ejm = "";
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(226046);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226046);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226047);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.eWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.eWd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.eWe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateResult:").append(this.eWf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UpdateCostTimeInMs:").append(this.eWg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackWaitTimeInMs:").append(this.eWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.eWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.eWj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226047);
    return localObject;
  }
  
  public final int getId()
  {
    return 20579;
  }
  
  public final kl tC(long paramLong)
  {
    this.eWc = paramLong;
    return this;
  }
  
  public final kl tD(long paramLong)
  {
    this.eWd = paramLong;
    return this;
  }
  
  public final kl tE(long paramLong)
  {
    this.eWe = paramLong;
    return this;
  }
  
  public final kl tF(long paramLong)
  {
    this.eWf = paramLong;
    return this;
  }
  
  public final kl tG(long paramLong)
  {
    this.eWg = paramLong;
    return this;
  }
  
  public final kl tH(long paramLong)
  {
    this.eWh = paramLong;
    return this;
  }
  
  public final kl tI(long paramLong)
  {
    this.eWi = paramLong;
    return this;
  }
  
  public final kl tJ(long paramLong)
  {
    this.eWj = paramLong;
    return this;
  }
  
  public final kl xK(String paramString)
  {
    AppMethodBeat.i(226042);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(226042);
    return this;
  }
  
  public final kl xL(String paramString)
  {
    AppMethodBeat.i(226043);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(226043);
    return this;
  }
  
  public final kl xM(String paramString)
  {
    AppMethodBeat.i(226044);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(226044);
    return this;
  }
  
  public final kl xN(String paramString)
  {
    AppMethodBeat.i(226045);
    this.ejm = x("NetType", paramString, true);
    AppMethodBeat.o(226045);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kl
 * JD-Core Version:    0.7.0.1
 */