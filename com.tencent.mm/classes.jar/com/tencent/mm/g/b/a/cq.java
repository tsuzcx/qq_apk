package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
  extends a
{
  private long cRG = 0L;
  public long cTb = 0L;
  private String cZA = "";
  private long cZB = 0L;
  private long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  private long dau = 0L;
  private long dav = 0L;
  private cq.a dcr;
  public cq.c dcs;
  public cq.b dct;
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(128816);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dcr != null)
    {
      i = this.dcr.value;
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
      if (this.dcs == null) {
        break label261;
      }
    }
    label261:
    for (int i = this.dcs.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.dct != null) {
        i = this.dct.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cTb);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128816);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128817);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dcr);
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
    ((StringBuffer)localObject).append("Ret:").append(this.dcs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.dct);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.cTb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128817);
    return localObject;
  }
  
  public final cq a(cq.a parama)
  {
    this.dcr = parama;
    return this;
  }
  
  public final cq fe(long paramLong)
  {
    this.cZB = paramLong;
    return this;
  }
  
  public final cq ff(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final cq fg(long paramLong)
  {
    AppMethodBeat.i(128813);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128813);
    return this;
  }
  
  public final cq fh(long paramLong)
  {
    this.cRG = paramLong;
    return this;
  }
  
  public final cq fi(long paramLong)
  {
    AppMethodBeat.i(128814);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128814);
    return this;
  }
  
  public final cq fj(long paramLong)
  {
    AppMethodBeat.i(128815);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128815);
    return this;
  }
  
  public final int getId()
  {
    return 15764;
  }
  
  public final cq hO(String paramString)
  {
    AppMethodBeat.i(128811);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128811);
    return this;
  }
  
  public final cq hP(String paramString)
  {
    AppMethodBeat.i(128812);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128812);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq
 * JD-Core Version:    0.7.0.1
 */