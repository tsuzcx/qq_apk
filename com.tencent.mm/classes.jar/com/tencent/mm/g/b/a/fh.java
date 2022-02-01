package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fh
  extends a
{
  public long dXk = 0L;
  public String dXl = "";
  public String dXm = "";
  
  public final String PR()
  {
    AppMethodBeat.i(19868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(19868);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(19869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.dXk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.dXl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.dXm);
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
 * Qualified Name:     com.tencent.mm.g.b.a.fh
 * JD-Core Version:    0.7.0.1
 */