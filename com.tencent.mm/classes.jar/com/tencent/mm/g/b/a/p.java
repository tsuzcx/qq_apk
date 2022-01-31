package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class p
  extends a
{
  public int cRR = 0;
  public String cRS;
  public String cRT = "";
  public long cRU = 0L;
  public long cRV = 0L;
  public long cRW = 0L;
  public String cRX;
  public int cRY = 0;
  public int cRZ = 0;
  public int cSa = 0;
  public int cSb = 0;
  
  public final String Ff()
  {
    AppMethodBeat.i(73289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSb);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73289);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.cRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.cRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.cRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.cRU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.cRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.cRW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.cRX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.cRY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.cRZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.cSa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.cSb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73290);
    return localObject;
  }
  
  public final p fh(String paramString)
  {
    AppMethodBeat.i(73287);
    this.cRS = t("PName", paramString, true);
    AppMethodBeat.o(73287);
    return this;
  }
  
  public final p fi(String paramString)
  {
    AppMethodBeat.i(73288);
    this.cRT = t("sessionId", paramString, true);
    AppMethodBeat.o(73288);
    return this;
  }
  
  public final int getId()
  {
    return 16242;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.p
 * JD-Core Version:    0.7.0.1
 */