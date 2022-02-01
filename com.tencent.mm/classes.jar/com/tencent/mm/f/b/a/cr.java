package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  public String gfl = "";
  public int gqB;
  public String gqC = "";
  public long gqD;
  public long gqE;
  public long gqF;
  public String gqG = "";
  public int gqH;
  public int gqI;
  public int gqJ;
  public int gqK;
  private String gqL = "";
  public String gqM = "";
  public String gqN = "";
  
  public final String agH()
  {
    AppMethodBeat.i(169253);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(169254);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.gqL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.gqM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.gqN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final cr mY(String paramString)
  {
    AppMethodBeat.i(169249);
    this.gqC = z("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final cr mZ(String paramString)
  {
    AppMethodBeat.i(169250);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final cr na(String paramString)
  {
    AppMethodBeat.i(169251);
    this.gqM = z("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final cr nb(String paramString)
  {
    AppMethodBeat.i(169252);
    this.gqN = z("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cr
 * JD-Core Version:    0.7.0.1
 */