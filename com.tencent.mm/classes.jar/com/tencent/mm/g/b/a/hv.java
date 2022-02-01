package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hv
  extends a
{
  private long dVd;
  private String eqt;
  private long eru;
  private String esR;
  private long esT;
  private hv.a etr;
  private String ets;
  private long ett;
  private hv.b etu;
  private String etv;
  private long etw;
  private long etx;
  
  public final String RD()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.etr != null) {}
    for (int i = this.etr.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ets);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ett);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.etu != null) {
        i = this.etu.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etv);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eqt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dVd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etw);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etx);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.etr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.ets);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.ett);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.etu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.etv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.etw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.etx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final hv a(hv.a parama)
  {
    this.etr = parama;
    return this;
  }
  
  public final hv a(hv.b paramb)
  {
    this.etu = paramb;
    return this;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final hv nl(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final hv nm(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final hv nn(long paramLong)
  {
    this.dVd = paramLong;
    return this;
  }
  
  public final hv no(long paramLong)
  {
    this.etx = paramLong;
    return this;
  }
  
  public final hv qC(String paramString)
  {
    AppMethodBeat.i(180156);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final hv qD(String paramString)
  {
    AppMethodBeat.i(180157);
    this.ets = t("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final hv qE(String paramString)
  {
    AppMethodBeat.i(180158);
    this.etv = t("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final hv qF(String paramString)
  {
    AppMethodBeat.i(180159);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hv
 * JD-Core Version:    0.7.0.1
 */