package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  public String dJA = "";
  public int dJB;
  public int dJC;
  public int dJD;
  public int dJE;
  private String dJF = "";
  public String dJG;
  public String dJH;
  public int dJu;
  public String dJv;
  public String dJw;
  public long dJx;
  public long dJy;
  public long dJz;
  
  public final String PR()
  {
    AppMethodBeat.i(169253);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJH);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(169254);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.dJF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.dJG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.dJH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final al gZ(String paramString)
  {
    AppMethodBeat.i(169249);
    this.dJv = t("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final al ha(String paramString)
  {
    AppMethodBeat.i(169250);
    this.dJw = t("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final al hb(String paramString)
  {
    AppMethodBeat.i(169251);
    this.dJG = t("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final al hc(String paramString)
  {
    AppMethodBeat.i(169252);
    this.dJH = t("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */