package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qc
  extends a
{
  public String gfg = "";
  public long guA = 0L;
  public long hjl = 0L;
  public long hjm = 0L;
  public String hjn = "";
  public String hjo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.guA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hjo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.guA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.hjl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.gfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.hjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.hjn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.hjo);
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
 * Qualified Name:     com.tencent.mm.f.b.a.qc
 * JD-Core Version:    0.7.0.1
 */