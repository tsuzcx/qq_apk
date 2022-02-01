package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class sj
  extends a
{
  private String iEy = "";
  private String ilM = "";
  private String imT = "";
  public long ind;
  public long iqr;
  public long jax;
  public sj.a jxZ;
  private String jya = "";
  private long jyb;
  public sj.b jyc;
  private long jyd;
  public long jye;
  
  public final String aIE()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    if (this.jxZ != null) {}
    for (int i = this.jxZ.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jax);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jya);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyb);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.jyc != null) {
        i = this.jyc.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iEy);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ilM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.iqr);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jyd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.jye);
      localObject = ((StringBuffer)localObject).toString();
      aUm((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.jxZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.jya);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.jyb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.jyc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.jyd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.jye);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final sj yX(String paramString)
  {
    AppMethodBeat.i(180156);
    this.imT = F("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final sj yY(String paramString)
  {
    AppMethodBeat.i(180157);
    this.jya = F("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final sj yZ(String paramString)
  {
    AppMethodBeat.i(180158);
    this.iEy = F("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final sj za(String paramString)
  {
    AppMethodBeat.i(180159);
    this.ilM = F("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sj
 * JD-Core Version:    0.7.0.1
 */