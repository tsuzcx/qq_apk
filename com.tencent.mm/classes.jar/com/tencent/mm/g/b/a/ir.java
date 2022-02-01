package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ir
  extends a
{
  public long euA;
  public String euy = "";
  public String ewR = "";
  public long eyf;
  public long eyg;
  public long eyh;
  public String eyi = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eyf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyi);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43631);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("visitScene:").append(this.eyf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessScene:").append(this.eyg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerScene:").append(this.eyh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.ewR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openRate:").append(this.eyi);
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
 * Qualified Name:     com.tencent.mm.g.b.a.ir
 * JD-Core Version:    0.7.0.1
 */