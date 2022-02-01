package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dg
  extends a
{
  public long dRL = 0L;
  private String dRM = "";
  
  public final String PR()
  {
    AppMethodBeat.i(149928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRM);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149928);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.dRL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.dRM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149929);
    return localObject;
  }
  
  public final int getId()
  {
    return 16868;
  }
  
  public final dg le(String paramString)
  {
    AppMethodBeat.i(162225);
    this.dRM = t("emoticonMd5", paramString, true);
    AppMethodBeat.o(162225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dg
 * JD-Core Version:    0.7.0.1
 */