package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bx
  extends a
{
  public String dJA;
  public int dJB = 0;
  public int dJC = 0;
  public int dJD = 0;
  public int dJE = 0;
  public int dJu = 0;
  public String dJv;
  public String dJw = "";
  public long dJx = 0L;
  public long dJy = 0L;
  public long dJz = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(121751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJE);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121752);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.dJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.dJy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.dJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.dJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.dJB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dJD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dJE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final bx jR(String paramString)
  {
    AppMethodBeat.i(121749);
    this.dJv = t("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final bx jS(String paramString)
  {
    AppMethodBeat.i(121750);
    this.dJw = t("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bx
 * JD-Core Version:    0.7.0.1
 */