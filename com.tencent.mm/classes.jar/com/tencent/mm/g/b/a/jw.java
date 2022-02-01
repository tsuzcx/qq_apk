package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jw
  extends a
{
  public int dPT;
  public String eCx;
  public String eCy;
  public long eeE;
  public int emu;
  
  public final String RD()
  {
    AppMethodBeat.i(219288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emu);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(219288);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(219289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eeE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.eCx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.eCy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.emu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(219289);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jw
 * JD-Core Version:    0.7.0.1
 */