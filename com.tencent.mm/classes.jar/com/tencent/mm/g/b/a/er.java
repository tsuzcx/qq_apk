package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  public long dKe = 0L;
  private String dZA;
  
  public final String PV()
  {
    AppMethodBeat.i(149947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZA);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(149947);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(149948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.dZA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149948);
    return localObject;
  }
  
  public final int getId()
  {
    return 18263;
  }
  
  public final er kK(String paramString)
  {
    AppMethodBeat.i(149946);
    this.dZA = t("ReqKey", paramString, true);
    AppMethodBeat.o(149946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.er
 * JD-Core Version:    0.7.0.1
 */