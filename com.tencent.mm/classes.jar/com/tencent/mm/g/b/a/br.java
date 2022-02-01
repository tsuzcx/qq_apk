package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class br
  extends a
{
  public long dHY;
  private String dNh = "";
  public long dNi = 0L;
  public long dNj = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(184627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNj);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(184627);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(184628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.dNh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dNi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.dNj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184628);
    return localObject;
  }
  
  public final int getId()
  {
    return 19353;
  }
  
  public final br jN(String paramString)
  {
    AppMethodBeat.i(184626);
    this.dNh = t("Roomid", paramString, true);
    AppMethodBeat.o(184626);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.br
 * JD-Core Version:    0.7.0.1
 */