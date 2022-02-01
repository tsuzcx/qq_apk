package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  public long enB = 0L;
  public String enC = "";
  public String enD = "";
  
  public final String RD()
  {
    AppMethodBeat.i(19868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(19868);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(19869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.enB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.enC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.enD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19869);
    return localObject;
  }
  
  public final int getId()
  {
    return 15493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gg
 * JD-Core Version:    0.7.0.1
 */