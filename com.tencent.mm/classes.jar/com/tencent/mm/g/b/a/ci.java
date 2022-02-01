package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ci
  extends a
{
  public long dVd;
  private String ecw = "";
  public long ecx = 0L;
  public long ecy = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.ecw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.ecx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.ecy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final ci lJ(String paramString)
  {
    AppMethodBeat.i(184626);
    this.ecw = t("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ci
 * JD-Core Version:    0.7.0.1
 */