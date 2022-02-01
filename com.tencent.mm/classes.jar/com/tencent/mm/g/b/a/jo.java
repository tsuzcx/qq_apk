package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jo
  extends a
{
  public long dZW;
  public long eCg;
  public long edt;
  
  public final String RC()
  {
    AppMethodBeat.i(188462);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(188462);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(188463);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("WordCount:").append(this.eCg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.edt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(188463);
    return localObject;
  }
  
  public final int getId()
  {
    return 20734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jo
 * JD-Core Version:    0.7.0.1
 */