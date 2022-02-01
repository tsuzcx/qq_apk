package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  public long egU = 0L;
  public long egV = 0L;
  public String egW = "";
  public long egX = 0L;
  public String egY = "";
  public String egZ = "";
  
  public final String PV()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.egU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.egU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.egV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.egW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.egX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.egY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.egZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116493);
    return localObject;
  }
  
  public final int getId()
  {
    return 14688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gj
 * JD-Core Version:    0.7.0.1
 */