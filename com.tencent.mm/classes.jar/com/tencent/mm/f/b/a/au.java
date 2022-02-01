package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  public long gjU;
  public long gjV;
  public long gjW = 0L;
  public String gjX = "";
  
  public final String agH()
  {
    AppMethodBeat.i(194900);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(194900);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(194909);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.gjU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.gjV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.gjW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.gjX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194909);
    return localObject;
  }
  
  public final int getId()
  {
    return 20134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.au
 * JD-Core Version:    0.7.0.1
 */