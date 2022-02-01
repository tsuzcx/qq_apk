package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gx
  extends a
{
  private String dYc = "";
  private String ecB = "";
  private String erZ = "";
  private String esa = "";
  public long esb = 0L;
  public long esc = 0L;
  public long esd = 0L;
  public long esh = 0L;
  public long esi = 0L;
  public long esj = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(221926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221926);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221927);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.erZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.esb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.esc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.esi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitTimeInMs:").append(this.esj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ecB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.esh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221927);
    return localObject;
  }
  
  public final long UA()
  {
    return this.esc;
  }
  
  public final long UB()
  {
    return this.esd;
  }
  
  public final long UC()
  {
    return this.esj;
  }
  
  public final String UD()
  {
    return this.ecB;
  }
  
  public final long UE()
  {
    return this.esh;
  }
  
  public final String UF()
  {
    return this.esa;
  }
  
  public final long Uz()
  {
    return this.esb;
  }
  
  public final String getAppid()
  {
    return this.erZ;
  }
  
  public final int getId()
  {
    return 20572;
  }
  
  public final String getUsername()
  {
    return this.dYc;
  }
  
  public final gx qc(String paramString)
  {
    AppMethodBeat.i(221922);
    this.erZ = t("Appid", paramString, true);
    AppMethodBeat.o(221922);
    return this;
  }
  
  public final gx qd(String paramString)
  {
    AppMethodBeat.i(221923);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(221923);
    return this;
  }
  
  public final gx qe(String paramString)
  {
    AppMethodBeat.i(221924);
    this.ecB = t("NetType", paramString, true);
    AppMethodBeat.o(221924);
    return this;
  }
  
  public final gx qf(String paramString)
  {
    AppMethodBeat.i(221925);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(221925);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gx
 * JD-Core Version:    0.7.0.1
 */