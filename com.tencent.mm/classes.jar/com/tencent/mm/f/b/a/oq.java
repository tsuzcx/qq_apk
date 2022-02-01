package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oq
  extends a
{
  private long gYL;
  private long gYN;
  private String gfn = "";
  private String gmF = "";
  private long gnP;
  private String gtA = "";
  private oq.a hcl;
  private String hcm = "";
  private long hcn;
  private oq.b hco;
  private long hcp;
  private long hcq;
  
  public final oq Bc(long paramLong)
  {
    this.gYL = paramLong;
    return this;
  }
  
  public final oq Bd(long paramLong)
  {
    this.gYN = paramLong;
    return this;
  }
  
  public final oq Be(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final oq Bf(long paramLong)
  {
    this.hcq = paramLong;
    return this;
  }
  
  public final oq FG(String paramString)
  {
    AppMethodBeat.i(180156);
    this.gmF = z("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final oq FH(String paramString)
  {
    AppMethodBeat.i(180157);
    this.hcm = z("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final oq FI(String paramString)
  {
    AppMethodBeat.i(180158);
    this.gtA = z("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final oq FJ(String paramString)
  {
    AppMethodBeat.i(180159);
    this.gfn = z("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
  
  public final oq a(oq.a parama)
  {
    this.hcl = parama;
    return this;
  }
  
  public final oq a(oq.b paramb)
  {
    this.hco = paramb;
    return this;
  }
  
  public final String agH()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYL);
    ((StringBuffer)localObject).append(",");
    if (this.hcl != null) {}
    for (int i = this.hcl.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gYN);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcn);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.hco != null) {
        i = this.hco.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gtA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gfn);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.gnP);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.hcq);
      localObject = ((StringBuffer)localObject).toString();
      aWW((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String agI()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.gmF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.gYL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.hcl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.gYN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.hcm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.hcn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.hco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.gtA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.gfn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.hcp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.hcq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final int getId()
  {
    return 19280;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.oq
 * JD-Core Version:    0.7.0.1
 */