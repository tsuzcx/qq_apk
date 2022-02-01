package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class du
  extends a
{
  public int dSg;
  public String dWK;
  public String ehb;
  public int ehc;
  
  public final String RD()
  {
    AppMethodBeat.i(193097);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehc);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(193097);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(193098);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.ehb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.ehc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193098);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.du
 * JD-Core Version:    0.7.0.1
 */