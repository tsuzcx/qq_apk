package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class k
  extends a
{
  public String dFh = "";
  public String dFi = "";
  public int dFj = 0;
  
  public final String PR()
  {
    AppMethodBeat.i(121744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFj);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121744);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dFh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.dFi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.dFj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121745);
    return localObject;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.k
 * JD-Core Version:    0.7.0.1
 */