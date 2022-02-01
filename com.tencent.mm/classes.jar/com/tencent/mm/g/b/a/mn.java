package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mn
  extends a
{
  public String eJx = "";
  public long eYW;
  public String fbm = "";
  public long fcC;
  public long fcD;
  public long fcE;
  public String fcF = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fcC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fcD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fcE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fbm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fcF);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43631);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("visitScene:").append(this.fcC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessScene:").append(this.fcD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerScene:").append(this.fcE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.fbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openRate:").append(this.fcF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43632);
    return localObject;
  }
  
  public final int getId()
  {
    return 18852;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mn
 * JD-Core Version:    0.7.0.1
 */