package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ez
  extends a
{
  public String ekG = "";
  public String euA = "";
  public int euB = 0;
  public int euC = 0;
  public int euD = 0;
  public int euE = 0;
  public int euv = 0;
  public String euw = "";
  public long eux = 0L;
  public long euy = 0L;
  public long euz = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(121751);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.euv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eux);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euE);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121751);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121752);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.euv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.euw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.eux);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.euy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.euz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.euA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.euB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.euC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.euD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.euE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121752);
    return localObject;
  }
  
  public final int getId()
  {
    return 16242;
  }
  
  public final ez rV(String paramString)
  {
    AppMethodBeat.i(121749);
    this.euw = x("PName", paramString, true);
    AppMethodBeat.o(121749);
    return this;
  }
  
  public final ez rW(String paramString)
  {
    AppMethodBeat.i(121750);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(121750);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ez
 * JD-Core Version:    0.7.0.1
 */