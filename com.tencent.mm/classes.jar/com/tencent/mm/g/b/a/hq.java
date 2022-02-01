package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  private long eru = 0L;
  private String esR;
  private hq.a esS;
  private long esT = 0L;
  private long esU = 0L;
  private String esV;
  
  public final String RD()
  {
    AppMethodBeat.i(43470);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.esS != null) {}
    for (int i = this.esS.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esU);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esV);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43470);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43471);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.esS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.esU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DirPrefix:").append(this.esV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43471);
    return localObject;
  }
  
  public final long UU()
  {
    return this.esU;
  }
  
  public final String UV()
  {
    return this.esV;
  }
  
  public final hq a(hq.a parama)
  {
    this.esS = parama;
    return this;
  }
  
  public final String getAppId()
  {
    return this.esR;
  }
  
  public final int getId()
  {
    return 17687;
  }
  
  public final hq nf(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final hq ng(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final hq nh(long paramLong)
  {
    this.esU = paramLong;
    return this;
  }
  
  public final hq qv(String paramString)
  {
    AppMethodBeat.i(43469);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43469);
    return this;
  }
  
  public final hq qw(String paramString)
  {
    AppMethodBeat.i(180149);
    this.esV = t("DirPrefix", paramString, true);
    AppMethodBeat.o(180149);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hq
 * JD-Core Version:    0.7.0.1
 */