package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class u
  extends a
{
  public long dTf;
  public long dTg;
  public long dTh = 0L;
  public String dTi = "";
  
  public final String RD()
  {
    AppMethodBeat.i(197134);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTi);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(197134);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(197135);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.dTf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.dTg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.dTh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.dTi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(197135);
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