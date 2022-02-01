package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jh
  extends a
{
  public long eBJ = 0L;
  public long eBK = 0L;
  public String eBL = "";
  public long eBM = 0L;
  public String eBN = "";
  public String eBO = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eBJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBO);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116492);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actionType:").append(this.eBJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clientTimestamp:").append(this.eBK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.eBL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serviceType:").append(this.eBM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statBuffer:").append(this.eBN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("switchId:").append(this.eBO);
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
 * Qualified Name:     com.tencent.mm.g.b.a.jh
 * JD-Core Version:    0.7.0.1
 */