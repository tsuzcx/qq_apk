package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  private String cZA;
  private long cZB = 0L;
  private bx.a cZC;
  private long cZD = 0L;
  private long cZE = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(155895);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cZB);
    ((StringBuffer)localObject).append(",");
    if (this.cZC != null) {}
    for (int i = this.cZC.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZE);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(155895);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(155896);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.cZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.cZC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileOccupation:").append(this.cZE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(155896);
    return localObject;
  }
  
  public final bx a(bx.a parama)
  {
    this.cZC = parama;
    return this;
  }
  
  public final bx ew(long paramLong)
  {
    this.cZB = paramLong;
    return this;
  }
  
  public final bx ex(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final bx ey(long paramLong)
  {
    this.cZE = paramLong;
    return this;
  }
  
  public final bx gX(String paramString)
  {
    AppMethodBeat.i(155894);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(155894);
    return this;
  }
  
  public final int getId()
  {
    return 17687;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */