package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qx
  extends a
{
  public int gSe;
  public int geN;
  public long gto;
  public String hlP = "";
  public String hlQ = "";
  
  public final String agH()
  {
    AppMethodBeat.i(186858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gto);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSe);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186858);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186860);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gto);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.hlP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.hlQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.gSe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186860);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qx
 * JD-Core Version:    0.7.0.1
 */