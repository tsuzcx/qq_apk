package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nd
  extends a
{
  public String ekB = "";
  public long fgg = 0L;
  public long fgh = 0L;
  public long fgi = 0L;
  public String fgj = "";
  public String fgk = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fgg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fgk);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.fgg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.fgh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ekB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.fgi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.fgj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.fgk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116493);
    return localObject;
  }
  
  public final int getId()
  {
    return 14688;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.nd
 * JD-Core Version:    0.7.0.1
 */