package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jl
  extends a
{
  public long dPH = 0L;
  private String dSD = "";
  public long eAg = 0L;
  public long eAw = 0L;
  public long ehT = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(76371);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehT);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(76371);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(76372);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.dSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timecost:").append(this.eAg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("drawStrategy:").append(this.eAw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.ehT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76372);
    return localObject;
  }
  
  public final int getId()
  {
    return 15841;
  }
  
  public final jl rU(String paramString)
  {
    AppMethodBeat.i(76370);
    this.dSD = t("appid", paramString, true);
    AppMethodBeat.o(76370);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jl
 * JD-Core Version:    0.7.0.1
 */