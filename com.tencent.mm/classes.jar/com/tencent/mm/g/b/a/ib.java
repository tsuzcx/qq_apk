package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  public long eja = 0L;
  public long ejb = 0L;
  public String ejc = "";
  public long ejd = 0L;
  public String eje = "";
  public String ejf = "";
  
  public final String PR()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eja);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eje);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejf);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.eja);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.ejb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ejc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.ejd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.eje);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.ejf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116493);
    return localObject;
  }
  
  public final int getId()
  {
    return 14688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ib
 * JD-Core Version:    0.7.0.1
 */