package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  private long cRG = 0L;
  private long cRH = 0L;
  private String cZA = "";
  private long cZD = 0L;
  private long dat = 0L;
  private cz.a ddU;
  private String ddV = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(128908);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cZA);
    ((StringBuffer)localObject).append(",");
    if (this.ddU != null) {}
    for (int i = this.ddU.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cZD);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dat);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRG);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cRH);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ddV);
      localObject = ((StringBuffer)localObject).toString();
      Yp((String)localObject);
      AppMethodBeat.o(128908);
      return localObject;
    }
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(128909);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("AppId:").append(this.cZA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ddU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.cZD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.dat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.cRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrMsg:").append(this.ddV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(128909);
    return localObject;
  }
  
  public final cz a(cz.a parama)
  {
    this.ddU = parama;
    return this;
  }
  
  public final cz fB(long paramLong)
  {
    this.cZD = paramLong;
    return this;
  }
  
  public final cz fC(long paramLong)
  {
    AppMethodBeat.i(128906);
    this.dat = paramLong;
    super.ay("CostTimeMs", this.dat);
    AppMethodBeat.o(128906);
    return this;
  }
  
  public final cz fD(long paramLong)
  {
    this.cRG = paramLong;
    return this;
  }
  
  public final cz fE(long paramLong)
  {
    this.cRH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 17147;
  }
  
  public final cz ik(String paramString)
  {
    AppMethodBeat.i(128905);
    this.cZA = t("AppId", paramString, true);
    AppMethodBeat.o(128905);
    return this;
  }
  
  public final cz il(String paramString)
  {
    AppMethodBeat.i(128907);
    this.ddV = t("ErrMsg", paramString, true);
    AppMethodBeat.o(128907);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz
 * JD-Core Version:    0.7.0.1
 */