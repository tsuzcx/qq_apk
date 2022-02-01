package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  public long dHY = 0L;
  private String ebs;
  
  public final String PR()
  {
    AppMethodBeat.i(149947);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebs);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149947);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.ebs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149948);
    return localObject;
  }
  
  public final int getId()
  {
    return 18263;
  }
  
  public final gh nC(String paramString)
  {
    AppMethodBeat.i(149946);
    this.ebs = t("ReqKey", paramString, true);
    AppMethodBeat.o(149946);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gh
 * JD-Core Version:    0.7.0.1
 */