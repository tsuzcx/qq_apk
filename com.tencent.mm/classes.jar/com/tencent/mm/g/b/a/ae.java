package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ae
  extends a
{
  public String enK = "";
  public long enL;
  public long enM = 0L;
  public long enN = 0L;
  public long enO = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(184762);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enO);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184762);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184763);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.enK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.enL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.enM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topBefore:").append(this.enN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAfter:").append(this.enO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184763);
    return localObject;
  }
  
  public final int getId()
  {
    return 19437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ae
 * JD-Core Version:    0.7.0.1
 */