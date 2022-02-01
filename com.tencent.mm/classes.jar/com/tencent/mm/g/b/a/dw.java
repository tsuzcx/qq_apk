package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dw
  extends a
{
  public int dTw;
  public String dYc = "";
  public String eiL = "";
  public int eiM;
  
  public final String RC()
  {
    AppMethodBeat.i(186334);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiM);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(186334);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(186335);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatUsername:").append(this.eiL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageCount:").append(this.eiM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186335);
    return localObject;
  }
  
  public final int getId()
  {
    return 19963;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dw
 * JD-Core Version:    0.7.0.1
 */