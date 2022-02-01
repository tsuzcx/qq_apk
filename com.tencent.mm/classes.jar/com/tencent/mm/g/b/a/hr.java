package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  private long eru = 0L;
  private String esR;
  private long esT = 0L;
  private hr.a eta;
  private long etb = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(43476);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eru);
    ((StringBuffer)localObject).append(",");
    if (this.eta != null) {}
    for (int i = this.eta.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.esT);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.etb);
      localObject = ((StringBuffer)localObject).toString();
      awz((String)localObject);
      AppMethodBeat.o(43476);
      return localObject;
    }
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.eta);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileAllocSize:").append(this.etb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43477);
    return localObject;
  }
  
  public final hr a(hr.a parama)
  {
    this.eta = parama;
    return this;
  }
  
  public final int getId()
  {
    return 17688;
  }
  
  public final hr ni(long paramLong)
  {
    this.eru = paramLong;
    return this;
  }
  
  public final hr nj(long paramLong)
  {
    this.esT = paramLong;
    return this;
  }
  
  public final hr nk(long paramLong)
  {
    this.etb = paramLong;
    return this;
  }
  
  public final hr qx(String paramString)
  {
    AppMethodBeat.i(43475);
    this.esR = t("AppId", paramString, true);
    AppMethodBeat.o(43475);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hr
 * JD-Core Version:    0.7.0.1
 */