package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ip
  extends a
{
  public String esR;
  public long esT;
  public String evk;
  public long ewv;
  public long eww;
  public long ewx;
  public String ewy;
  
  public final String RD()
  {
    AppMethodBeat.i(43631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ewv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eww);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(43631);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(43632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("visitScene:").append(this.ewv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessScene:").append(this.eww);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerScene:").append(this.ewx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.esR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.evk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openRate:").append(this.ewy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43632);
    return localObject;
  }
  
  public final int getId()
  {
    return 18852;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ip
 * JD-Core Version:    0.7.0.1
 */