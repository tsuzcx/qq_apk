package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  public String dKA = "";
  public int dKB;
  public int dKC;
  public int dKD;
  public int dKE;
  private String dKF = "";
  public String dKG;
  public String dKH;
  public int dKu;
  public String dKv;
  public String dKw;
  public long dKx;
  public long dKy;
  public long dKz;
  
  public final String PV()
  {
    AppMethodBeat.i(169253);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKH);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(169253);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(169254);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Performance:").append(this.dKF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionPageId:").append(this.dKG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionKey:").append(this.dKH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(169254);
    return localObject;
  }
  
  public final ab gA(String paramString)
  {
    AppMethodBeat.i(169249);
    this.dKv = t("PName", paramString, true);
    AppMethodBeat.o(169249);
    return this;
  }
  
  public final ab gB(String paramString)
  {
    AppMethodBeat.i(169250);
    this.dKw = t("sessionId", paramString, true);
    AppMethodBeat.o(169250);
    return this;
  }
  
  public final ab gC(String paramString)
  {
    AppMethodBeat.i(169251);
    this.dKG = t("SessionPageId", paramString, true);
    AppMethodBeat.o(169251);
    return this;
  }
  
  public final ab gD(String paramString)
  {
    AppMethodBeat.i(169252);
    this.dKH = t("SessionKey", paramString, true);
    AppMethodBeat.o(169252);
    return this;
  }
  
  public final int getId()
  {
    return 18260;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ab
 * JD-Core Version:    0.7.0.1
 */