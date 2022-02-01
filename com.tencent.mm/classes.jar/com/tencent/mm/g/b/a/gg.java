package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  public long dCQ = 0L;
  private String ebs;
  public long ebt = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(149944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dCQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ebt);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(149944);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(149945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dCQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.ebs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSettingScene:").append(this.ebt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149945);
    return localObject;
  }
  
  public final int getId()
  {
    return 18262;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gg
 * JD-Core Version:    0.7.0.1
 */