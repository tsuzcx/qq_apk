package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class k
  extends a
{
  public int dRQ = 0;
  public int dRR = 0;
  public int dRS = 0;
  public int dRT = 0;
  private String dRU;
  public int dRV;
  public long dRW = 0L;
  public long dRX = 0L;
  private String dRY;
  public long dRZ = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRZ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.dRQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.dRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.dRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.dRU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.dRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.dRW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.dRX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.dRY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.dRZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final k gG(String paramString)
  {
    AppMethodBeat.i(149903);
    this.dRU = t("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
  
  public final k gH(String paramString)
  {
    AppMethodBeat.i(149904);
    this.dRY = t("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(149904);
    return this;
  }
  
  public final int getId()
  {
    return 17473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.k
 * JD-Core Version:    0.7.0.1
 */