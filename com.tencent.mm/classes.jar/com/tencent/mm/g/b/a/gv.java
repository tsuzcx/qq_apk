package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gv
  extends a
{
  private String dWK;
  private String ebg;
  public long eqA = 0L;
  public long eqB = 0L;
  public long eqC = 0L;
  private String eqs;
  private String eqt;
  public long equ = 0L;
  public long eqv = 0L;
  public long eqw = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(187817);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.equ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqt);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(187817);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187818);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.equ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.eqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.eqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitTimeInMs:").append(this.eqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ebg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.eqA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187818);
    return localObject;
  }
  
  public final long Ut()
  {
    return this.equ;
  }
  
  public final long Uu()
  {
    return this.eqv;
  }
  
  public final long Uv()
  {
    return this.eqw;
  }
  
  public final long Uw()
  {
    return this.eqC;
  }
  
  public final String Ux()
  {
    return this.ebg;
  }
  
  public final long Uy()
  {
    return this.eqA;
  }
  
  public final String Uz()
  {
    return this.eqt;
  }
  
  public final String getAppid()
  {
    return this.eqs;
  }
  
  public final int getId()
  {
    return 20572;
  }
  
  public final String getUsername()
  {
    return this.dWK;
  }
  
  public final gv pH(String paramString)
  {
    AppMethodBeat.i(187813);
    this.eqs = t("Appid", paramString, true);
    AppMethodBeat.o(187813);
    return this;
  }
  
  public final gv pI(String paramString)
  {
    AppMethodBeat.i(187814);
    this.dWK = t("Username", paramString, true);
    AppMethodBeat.o(187814);
    return this;
  }
  
  public final gv pJ(String paramString)
  {
    AppMethodBeat.i(187815);
    this.ebg = t("NetType", paramString, true);
    AppMethodBeat.o(187815);
    return this;
  }
  
  public final gv pK(String paramString)
  {
    AppMethodBeat.i(187816);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(187816);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gv
 * JD-Core Version:    0.7.0.1
 */