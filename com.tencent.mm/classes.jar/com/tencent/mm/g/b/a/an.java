package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class an
  extends a
{
  private String dHV;
  private String dHW;
  private long dHY;
  private String dIv;
  private long dJK;
  private String dJM;
  private String dJP;
  private String dJQ;
  private long dJR;
  private String dJS;
  private long dJT;
  private long dJU;
  private long dJV;
  private long dJW;
  private long dJX;
  
  public final String PR()
  {
    AppMethodBeat.i(194948);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJX);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194948);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194949);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.dJQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dJR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IndexInfo:").append(this.dJS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.dJK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTime:").append(this.dJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposeTime:").append(this.dJU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposeTime:").append(this.dJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCnt:").append(this.dJW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.dIv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dJX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194949);
    return localObject;
  }
  
  public final an jdMethod_do(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final an dp(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final an dq(long paramLong)
  {
    this.dJK = paramLong;
    return this;
  }
  
  public final an dr(long paramLong)
  {
    this.dJT = paramLong;
    return this;
  }
  
  public final an ds(long paramLong)
  {
    this.dJU = paramLong;
    return this;
  }
  
  public final an dt(long paramLong)
  {
    this.dJV = paramLong;
    return this;
  }
  
  public final an du(long paramLong)
  {
    this.dJW = paramLong;
    return this;
  }
  
  public final an dv(long paramLong)
  {
    this.dJX = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19997;
  }
  
  public final an hl(String paramString)
  {
    AppMethodBeat.i(194941);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(194941);
    return this;
  }
  
  public final an hm(String paramString)
  {
    AppMethodBeat.i(194942);
    this.dHW = t("Contextid", paramString, true);
    AppMethodBeat.o(194942);
    return this;
  }
  
  public final an hn(String paramString)
  {
    AppMethodBeat.i(194943);
    this.dJP = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(194943);
    return this;
  }
  
  public final an ho(String paramString)
  {
    AppMethodBeat.i(194944);
    this.dJQ = t("Feedid", paramString, true);
    AppMethodBeat.o(194944);
    return this;
  }
  
  public final an hp(String paramString)
  {
    AppMethodBeat.i(194945);
    this.dJS = t("IndexInfo", paramString, true);
    AppMethodBeat.o(194945);
    return this;
  }
  
  public final an hq(String paramString)
  {
    AppMethodBeat.i(194946);
    this.dJM = t("PageTag", paramString, true);
    AppMethodBeat.o(194946);
    return this;
  }
  
  public final an hr(String paramString)
  {
    AppMethodBeat.i(194947);
    this.dIv = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(194947);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.an
 * JD-Core Version:    0.7.0.1
 */