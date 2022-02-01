package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  public long dUv;
  public long dUw;
  public long dUx = 0L;
  public String dUy = "";
  
  public final String RC()
  {
    AppMethodBeat.i(221072);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUy);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(221072);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(221073);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.dUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.dUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.dUx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dUy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(221073);
    return localObject;
  }
  
  public final int getId()
  {
    return 20134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.u
 * JD-Core Version:    0.7.0.1
 */