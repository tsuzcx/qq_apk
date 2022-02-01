package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  private String dNh = "";
  public long dNj;
  
  public final String PR()
  {
    AppMethodBeat.i(184630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNj);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184630);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.dNh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dNj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184631);
    return localObject;
  }
  
  public final int getId()
  {
    return 19352;
  }
  
  public final bs jO(String paramString)
  {
    AppMethodBeat.i(184629);
    this.dNh = t("Roomid", paramString, true);
    AppMethodBeat.o(184629);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bs
 * JD-Core Version:    0.7.0.1
 */