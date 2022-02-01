package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class j
  extends a
{
  public long dFd;
  public String dFe;
  public long dFf;
  public long dFg;
  
  public final String PR()
  {
    AppMethodBeat.i(163174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFg);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(163174);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(163175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.dFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeShiCount:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTime:").append(this.dFg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163175);
    return localObject;
  }
  
  public final int getId()
  {
    return 18869;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.j
 * JD-Core Version:    0.7.0.1
 */