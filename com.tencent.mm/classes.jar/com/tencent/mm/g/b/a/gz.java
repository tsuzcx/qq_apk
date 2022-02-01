package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gz
  extends a
{
  public int dJp;
  public long dNO;
  public int dUs;
  public String ejr;
  public String ejs;
  
  public final String PV()
  {
    AppMethodBeat.i(190178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUs);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(190178);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(190179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dNO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RegisterMobile:").append(this.ejr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeviceID:").append(this.ejs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.dUs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190179);
    return localObject;
  }
  
  public final int getId()
  {
    return 19822;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gz
 * JD-Core Version:    0.7.0.1
 */