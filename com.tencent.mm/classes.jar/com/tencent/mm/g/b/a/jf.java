package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jf
  extends a
{
  public long eAa = 0L;
  public long eAb = 0L;
  public String eAc = "";
  public long eAd = 0L;
  public String eAe = "";
  public String eAf = "";
  
  public final String RD()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eAa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eAf);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.eAa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.eAb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.eAc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.eAd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.eAe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.eAf);
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
 * Qualified Name:     com.tencent.mm.g.b.a.jf
 * JD-Core Version:    0.7.0.1
 */