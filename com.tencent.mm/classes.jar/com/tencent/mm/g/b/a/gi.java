package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  public long epj = 0L;
  public String epk = "";
  public String epl = "";
  
  public final String RC()
  {
    AppMethodBeat.i(19868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.epj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epl);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(19868);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(19869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.epj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.epk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.epl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19869);
    return localObject;
  }
  
  public final int getId()
  {
    return 15493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gi
 * JD-Core Version:    0.7.0.1
 */