package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  public long dVd = 0L;
  private String erX;
  
  public final String RD()
  {
    AppMethodBeat.i(149947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149947);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.erX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149948);
    return localObject;
  }
  
  public final int getId()
  {
    return 18263;
  }
  
  public final hk qb(String paramString)
  {
    AppMethodBeat.i(149946);
    this.erX = t("ReqKey", paramString, true);
    AppMethodBeat.o(149946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hk
 * JD-Core Version:    0.7.0.1
 */