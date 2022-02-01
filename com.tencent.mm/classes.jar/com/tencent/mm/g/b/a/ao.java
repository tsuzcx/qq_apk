package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  private String dHM;
  private long dHT;
  private String dHV;
  private String dHW;
  private String dJP;
  private String dJY;
  private long dJZ;
  private String dKa;
  private long dKb;
  private long dKc;
  
  public final String PR()
  {
    AppMethodBeat.i(194956);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194956);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194957);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.dKc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194957);
    return localObject;
  }
  
  public final String Qg()
  {
    return this.dKa;
  }
  
  public final ao dw(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final ao dx(long paramLong)
  {
    this.dJZ = paramLong;
    return this;
  }
  
  public final ao dy(long paramLong)
  {
    this.dKb = paramLong;
    return this;
  }
  
  public final ao dz(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final ao hs(String paramString)
  {
    AppMethodBeat.i(194950);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(194950);
    return this;
  }
  
  public final ao ht(String paramString)
  {
    AppMethodBeat.i(194951);
    this.dHW = t("Contextid", paramString, true);
    AppMethodBeat.o(194951);
    return this;
  }
  
  public final ao hu(String paramString)
  {
    AppMethodBeat.i(194952);
    this.dJP = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(194952);
    return this;
  }
  
  public final ao hv(String paramString)
  {
    AppMethodBeat.i(194953);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(194953);
    return this;
  }
  
  public final ao hw(String paramString)
  {
    AppMethodBeat.i(194954);
    this.dJY = t("FlodUsername", paramString, true);
    AppMethodBeat.o(194954);
    return this;
  }
  
  public final ao hx(String paramString)
  {
    AppMethodBeat.i(194955);
    this.dKa = t("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(194955);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ao
 * JD-Core Version:    0.7.0.1
 */