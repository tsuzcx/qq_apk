package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lc
  extends a
{
  private String eXK = "";
  public long eXL = 0L;
  public long ejA = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149944);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXL);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149944);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149945);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqKey:").append(this.eXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterSettingScene:").append(this.eXL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149945);
    return localObject;
  }
  
  public final int getId()
  {
    return 18262;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.lc
 * JD-Core Version:    0.7.0.1
 */