package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class r
  extends a
{
  public long dGa;
  public long dGb;
  public long dGc = 0L;
  public String dGd = "";
  
  public final String PR()
  {
    AppMethodBeat.i(206461);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGd);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(206461);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(206462);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.dGa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.dGb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.dGc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dGd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(206462);
    return localObject;
  }
  
  public final int getId()
  {
    return 20134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.r
 * JD-Core Version:    0.7.0.1
 */