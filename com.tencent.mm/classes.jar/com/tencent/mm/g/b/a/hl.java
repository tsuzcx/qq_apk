package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hl
  extends a
{
  public long dQB = 0L;
  private String etE = "";
  public long etF = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etF);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149944);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.etE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSettingScene:").append(this.etF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149945);
    return localObject;
  }
  
  public final int getId()
  {
    return 18262;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hl
 * JD-Core Version:    0.7.0.1
 */