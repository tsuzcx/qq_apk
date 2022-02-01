package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fa
  extends a
{
  private long dKe;
  private long dYT;
  private String dYa;
  private fa.a eaG;
  private String eaH;
  private long eaI;
  private fa.b eaJ;
  private String eaK;
  private long eaL;
  private long eaM;
  private String eag;
  private long eai;
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(180160);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.eaG != null) {}
    for (int i = this.eaG.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaI);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.eaJ != null) {
        i = this.eaJ.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dYa);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaL);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eaM);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(180160);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(180161);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eaG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginAppid:").append(this.eaH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginVersion:").append(this.eaI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PluginState:").append(this.eaJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.eaK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateScene:").append(this.eaL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("updateResult:").append(this.eaM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(180161);
    return localObject;
  }
  
  public final fa a(fa.a parama)
  {
    this.eaG = parama;
    return this;
  }
  
  public final fa a(fa.b paramb)
  {
    this.eaJ = paramb;
    return this;
  }
  
  public final int getId()
  {
    return 19280;
  }
  
  public final fa hP(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fa hQ(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fa hR(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fa hS(long paramLong)
  {
    this.eaM = paramLong;
    return this;
  }
  
  public final fa kY(String paramString)
  {
    AppMethodBeat.i(180156);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(180156);
    return this;
  }
  
  public final fa kZ(String paramString)
  {
    AppMethodBeat.i(180157);
    this.eaH = t("PluginAppid", paramString, true);
    AppMethodBeat.o(180157);
    return this;
  }
  
  public final fa la(String paramString)
  {
    AppMethodBeat.i(180158);
    this.eaK = t("networkType", paramString, true);
    AppMethodBeat.o(180158);
    return this;
  }
  
  public final fa lb(String paramString)
  {
    AppMethodBeat.i(180159);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(180159);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fa
 * JD-Core Version:    0.7.0.1
 */