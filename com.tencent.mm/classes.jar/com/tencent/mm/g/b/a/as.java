package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
  extends a
{
  private String dMG = "";
  public long dMI;
  
  public final String PV()
  {
    AppMethodBeat.i(184630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dMG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(184630);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(184631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.dMG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dMI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184631);
    return localObject;
  }
  
  public final int getId()
  {
    return 19352;
  }
  
  public final as hK(String paramString)
  {
    AppMethodBeat.i(184629);
    this.dMG = t("Roomid", paramString, true);
    AppMethodBeat.o(184629);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.as
 * JD-Core Version:    0.7.0.1
 */