package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;

public final class cd
  extends a
{
  public long cRG = 0L;
  private String cZA = "";
  public long cZD = 0L;
  public cd.a daA;
  public long daB = 0L;
  private String dar = "";
  private long dat = 0L;
  public long dau = 0L;
  public long dav = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(128674);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    if (this.daA != null) {}
    for (int i = this.daA.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dau);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dav);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.daB);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128674);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128675);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.daA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.dau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.dav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPreload:").append(this.daB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128675);
    return localObject;
  }
  
  public final cd GY()
  {
    AppMethodBeat.i(128673);
    this.dav = bo.aoy();
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128673);
    return this;
  }
  
  public final cd eF(long paramLong)
  {
    AppMethodBeat.i(128671);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128671);
    return this;
  }
  
  public final cd eG(long paramLong)
  {
    AppMethodBeat.i(128672);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128672);
    return this;
  }
  
  public final int getId()
  {
    return 17111;
  }
  
  public final cd he(String paramString)
  {
    AppMethodBeat.i(128669);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128669);
    return this;
  }
  
  public final cd hf(String paramString)
  {
    AppMethodBeat.i(128670);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128670);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cd
 * JD-Core Version:    0.7.0.1
 */