package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ar
  extends a
{
  public long dKe;
  private String dMG = "";
  public long dMH = 0L;
  public long dMI = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.dMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dMH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dMI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final ar hJ(String paramString)
  {
    AppMethodBeat.i(184626);
    this.dMG = t("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ar
 * JD-Core Version:    0.7.0.1
 */