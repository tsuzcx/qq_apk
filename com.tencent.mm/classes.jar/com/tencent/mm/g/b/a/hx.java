package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hx
  extends a
{
  private long dWt;
  private String esa = "";
  private long etb;
  private long euA;
  private hx.a euY;
  private String euZ = "";
  private String euy = "";
  private long eva;
  private hx.b evb;
  private String evc = "";
  private long evd;
  private long eve;
  
  public final String RC()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etb);
    ((StringBuffer)localObject).append(",");
    if (this.euY != null) {}
    for (int i = this.euY.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euA);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.euZ);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eva);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.evb != null) {
        i = this.evb.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dWt);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.evd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eve);
      localObject = ((StringBuffer)localObject).toString();
      axO((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.etb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.euY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.euZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.eva);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.evb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.evc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.esa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.evd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.eve);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final hx a(hx.a parama)
  {
    this.euY = parama;
    return this;
  }
  
  public final hx a(hx.b paramb)
  {
    this.evb = paramb;
    return this;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final hx nA(long paramLong)
  {
    this.eve = paramLong;
    return this;
  }
  
  public final hx nx(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final hx ny(long paramLong)
  {
    this.euA = paramLong;
    return this;
  }
  
  public final hx nz(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final hx qX(String paramString)
  {
    AppMethodBeat.i(180156);
    this.euy = t("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final hx qY(String paramString)
  {
    AppMethodBeat.i(180157);
    this.euZ = t("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final hx qZ(String paramString)
  {
    AppMethodBeat.i(180158);
    this.evc = t("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final hx ra(String paramString)
  {
    AppMethodBeat.i(180159);
    this.esa = t("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx
 * JD-Core Version:    0.7.0.1
 */