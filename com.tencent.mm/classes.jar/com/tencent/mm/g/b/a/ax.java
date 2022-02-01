package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  public String dKA;
  public int dKB = 0;
  public int dKC = 0;
  public int dKD = 0;
  public int dKE = 0;
  public int dKu = 0;
  public String dKv;
  public String dKw = "";
  public long dKx = 0L;
  public long dKy = 0L;
  public long dKz = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(121751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKE);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121752);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dKu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dKw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.dKx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.dKy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.dKz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.dKA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dKC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dKD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dKE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final ax hN(String paramString)
  {
    AppMethodBeat.i(121749);
    this.dKv = t("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final ax hO(String paramString)
  {
    AppMethodBeat.i(121750);
    this.dKw = t("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ax
 * JD-Core Version:    0.7.0.1
 */