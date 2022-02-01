package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class km
  extends a
{
  private String eWa = "";
  private String eWb = "";
  public long eWc = 0L;
  public long eWd = 0L;
  public long eWe = 0L;
  public long eWi = 0L;
  public long eWj = 0L;
  public long eWk = 0L;
  private String ejm = "";
  private String etW = "";
  
  public final String abV()
  {
    AppMethodBeat.i(226052);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWb);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(226052);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(226053);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Appid:").append(this.eWa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpenScene:").append(this.eWc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetAppVersion:").append(this.eWd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LocalAppVersion:").append(this.eWe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FallbackScene:").append(this.eWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitTimeInMs:").append(this.eWk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.ejm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsWeakNet:").append(this.eWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(226053);
    return localObject;
  }
  
  public final long aip()
  {
    return this.eWc;
  }
  
  public final long aiq()
  {
    return this.eWd;
  }
  
  public final long air()
  {
    return this.eWe;
  }
  
  public final long ais()
  {
    return this.eWk;
  }
  
  public final String ait()
  {
    return this.ejm;
  }
  
  public final long aiu()
  {
    return this.eWi;
  }
  
  public final String aiv()
  {
    return this.eWb;
  }
  
  public final String getAppid()
  {
    return this.eWa;
  }
  
  public final int getId()
  {
    return 20572;
  }
  
  public final String getUsername()
  {
    return this.etW;
  }
  
  public final km xO(String paramString)
  {
    AppMethodBeat.i(226048);
    this.eWa = x("Appid", paramString, true);
    AppMethodBeat.o(226048);
    return this;
  }
  
  public final km xP(String paramString)
  {
    AppMethodBeat.i(226049);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(226049);
    return this;
  }
  
  public final km xQ(String paramString)
  {
    AppMethodBeat.i(226050);
    this.ejm = x("NetType", paramString, true);
    AppMethodBeat.o(226050);
    return this;
  }
  
  public final km xR(String paramString)
  {
    AppMethodBeat.i(226051);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(226051);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.km
 * JD-Core Version:    0.7.0.1
 */