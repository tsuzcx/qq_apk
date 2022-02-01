package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ld
  extends a
{
  private String eXK = "";
  public long erW = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149947);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.eXK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149948);
    return localObject;
  }
  
  public final int getId()
  {
    return 18263;
  }
  
  public final ld yq(String paramString)
  {
    AppMethodBeat.i(149946);
    this.eXK = x("ReqKey", paramString, true);
    AppMethodBeat.o(149946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ld
 * JD-Core Version:    0.7.0.1
 */