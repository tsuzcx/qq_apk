package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  public long dPl = 0L;
  private String erX;
  public long erY = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149944);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.dPl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.erX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSettingScene:").append(this.erY);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hj
 * JD-Core Version:    0.7.0.1
 */