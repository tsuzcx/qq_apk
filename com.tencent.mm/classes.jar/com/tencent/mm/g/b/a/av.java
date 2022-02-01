package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class av
  extends a
{
  public int dXl;
  public String dXm;
  public String dXn;
  public long dXo;
  public long dXp;
  public long dXq;
  public String dXr = "";
  public int dXs;
  public int dXt;
  public int dXu;
  public int dXv;
  private String dXw = "";
  public String dXx;
  public String dXy;
  
  public final String RD()
  {
    AppMethodBeat.i(169253);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(169254);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dXl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("frontTime:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("stayTotalTime:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scrollTotalTime:").append(this.dXq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedList:").append(this.dXr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportFeedCount:").append(this.dXs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dXt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.dXu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.dXv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.dXw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.dXx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.dXy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final int getId()
  {
    return 18260;
  }
  
  public final av iq(String paramString)
  {
    AppMethodBeat.i(169249);
    this.dXm = t("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final av ir(String paramString)
  {
    AppMethodBeat.i(169250);
    this.dXn = t("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final av is(String paramString)
  {
    AppMethodBeat.i(169251);
    this.dXx = t("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final av it(String paramString)
  {
    AppMethodBeat.i(169252);
    this.dXy = t("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.av
 * JD-Core Version:    0.7.0.1
 */