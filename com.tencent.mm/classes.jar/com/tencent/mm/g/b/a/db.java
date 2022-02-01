package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class db
  extends a
{
  public int dHw;
  public String dJb;
  public String dRE;
  public int dRF;
  
  public final String PR()
  {
    AppMethodBeat.i(195933);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRF);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195933);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195934);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.dRE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.dRF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195934);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.db
 * JD-Core Version:    0.7.0.1
 */