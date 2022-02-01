package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  public String ekG = "";
  public String euA = "";
  public int euB;
  public int euC;
  public int euD;
  public int euE;
  private String euF = "";
  public String euG = "";
  public String euH = "";
  public int euv;
  public String euw = "";
  public long eux;
  public long euy;
  public long euz;
  
  public final String abV()
  {
    AppMethodBeat.i(169253);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(169254);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.euF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.euG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.euH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final ca kI(String paramString)
  {
    AppMethodBeat.i(169249);
    this.euw = x("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final ca kJ(String paramString)
  {
    AppMethodBeat.i(169250);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final ca kK(String paramString)
  {
    AppMethodBeat.i(169251);
    this.euG = x("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final ca kL(String paramString)
  {
    AppMethodBeat.i(169252);
    this.euH = x("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ca
 * JD-Core Version:    0.7.0.1
 */