package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gp
  extends a
{
  public String gfl = "";
  public int gqB = 0;
  public String gqC = "";
  public long gqD = 0L;
  public long gqE = 0L;
  public long gqF = 0L;
  public String gqG = "";
  public int gqH = 0;
  public int gqI = 0;
  public int gqJ = 0;
  public int gqK = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(121751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqK);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121752);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.gqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.gqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.gfl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.gqD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.gqE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.gqF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.gqG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.gqH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.gqI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.gqJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.gqK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final gp vC(String paramString)
  {
    AppMethodBeat.i(121749);
    this.gqC = z("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final gp vD(String paramString)
  {
    AppMethodBeat.i(121750);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gp
 * JD-Core Version:    0.7.0.1
 */