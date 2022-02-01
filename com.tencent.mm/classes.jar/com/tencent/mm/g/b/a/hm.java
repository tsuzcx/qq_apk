package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  public long dWt = 0L;
  private String etE = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etE);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149947);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.etE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149948);
    return localObject;
  }
  
  public final int getId()
  {
    return 18263;
  }
  
  public final hm qw(String paramString)
  {
    AppMethodBeat.i(149946);
    this.etE = t("ReqKey", paramString, true);
    AppMethodBeat.o(149946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hm
 * JD-Core Version:    0.7.0.1
 */