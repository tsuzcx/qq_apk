package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private long cRG = 0L;
  public long cTb = 0L;
  private String cZA = "";
  private long cZB = 0L;
  private long cZD = 0L;
  private String dar = "";
  private long dat = 0L;
  public long dau = 0L;
  private long dav = 0L;
  private cs.a dcN;
  public cs.c dcO;
  public cs.b dcP;
  public long dcQ = 0L;
  
  public final String Ff()
  {
    int j = -1;
    AppMethodBeat.i(128846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dar);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.dcN != null)
    {
      i = this.dcN.value;
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
      if (this.dcO == null) {
        break label277;
      }
    }
    label277:
    for (int i = this.dcO.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.dcP != null) {
        i = this.dcP.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cTb);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dcQ);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128846);
      return localObject;
      i = -1;
      break;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dar);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.dcN);
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
    ((StringBuffer)localObject).append("Ret:").append(this.dcO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSync:").append(this.dcP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.cTb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsNormalOpen:").append(this.dcQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128847);
    return localObject;
  }
  
  public final cs a(cs.a parama)
  {
    this.dcN = parama;
    return this;
  }
  
  public final cs fn(long paramLong)
  {
    this.cZB = paramLong;
    return this;
  }
  
  public final cs fo(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final cs fp(long paramLong)
  {
    AppMethodBeat.i(128843);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128843);
    return this;
  }
  
  public final cs fq(long paramLong)
  {
    this.cRG = paramLong;
    return this;
  }
  
  public final cs fr(long paramLong)
  {
    AppMethodBeat.i(128844);
    this.dau = paramLong;
    super.az("StartTimeStampMs", this.dau);
    AppMethodBeat.o(128844);
    return this;
  }
  
  public final cs fs(long paramLong)
  {
    AppMethodBeat.i(128845);
    this.dav = paramLong;
    super.az("EndTimeStampMs", this.dav);
    AppMethodBeat.o(128845);
    return this;
  }
  
  public final int getId()
  {
    return 15765;
  }
  
  public final cs hS(String paramString)
  {
    AppMethodBeat.i(128841);
    this.dar = t("InstanceId", paramString, true);
    AppMethodBeat.o(128841);
    return this;
  }
  
  public final cs hT(String paramString)
  {
    AppMethodBeat.i(128842);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs
 * JD-Core Version:    0.7.0.1
 */