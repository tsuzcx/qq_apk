package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cj
  extends a
{
  private String ecw = "";
  public long ecy;
  
  public final String RD()
  {
    AppMethodBeat.i(184630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(184630);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(184631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.ecw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.ecy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184631);
    return localObject;
  }
  
  public final int getId()
  {
    return 19352;
  }
  
  public final cj lK(String paramString)
  {
    AppMethodBeat.i(184629);
    this.ecw = t("Roomid", paramString, true);
    AppMethodBeat.o(184629);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cj
 * JD-Core Version:    0.7.0.1
 */