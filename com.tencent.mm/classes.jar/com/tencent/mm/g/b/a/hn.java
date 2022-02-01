package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hn
  extends a
{
  private String dKI;
  private long dKX;
  private long dKe;
  private long dQc;
  private String dkR;
  private String gnM;
  private long iYs;
  private String iZx;
  private String jiI;
  private String kyH;
  private String kyJ;
  private long lQi;
  private long lQj;
  private long llY;
  private long lzt;
  
  public final String PV()
  {
    AppMethodBeat.i(203732);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kyH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kyJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.llY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lzt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQj);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203732);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203733);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.jiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.kyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.dQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IndexInfo:").append(this.kyJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.iYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTime:").append(this.dKX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartExposeTime:").append(this.llY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndExposeTime:").append(this.lzt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCnt:").append(this.lQi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.iZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gnM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.lQj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203733);
    return localObject;
  }
  
  public final hn aJo(String paramString)
  {
    AppMethodBeat.i(203730);
    this.iZx = t("PageTag", paramString, true);
    AppMethodBeat.o(203730);
    return this;
  }
  
  public final hn aJs(String paramString)
  {
    AppMethodBeat.i(203731);
    this.gnM = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(203731);
    return this;
  }
  
  public final hn awU(String paramString)
  {
    AppMethodBeat.i(203725);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203725);
    return this;
  }
  
  public final hn awV(String paramString)
  {
    AppMethodBeat.i(203726);
    this.dkR = t("Contextid", paramString, true);
    AppMethodBeat.o(203726);
    return this;
  }
  
  public final hn awW(String paramString)
  {
    AppMethodBeat.i(203727);
    this.jiI = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(203727);
    return this;
  }
  
  public final hn awX(String paramString)
  {
    AppMethodBeat.i(203728);
    this.kyH = t("Feedid", paramString, true);
    AppMethodBeat.o(203728);
    return this;
  }
  
  public final hn ayx(String paramString)
  {
    AppMethodBeat.i(203729);
    this.kyJ = t("IndexInfo", paramString, true);
    AppMethodBeat.o(203729);
    return this;
  }
  
  public final int getId()
  {
    return 19997;
  }
  
  public final hn yq(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final hn yr(long paramLong)
  {
    this.dQc = paramLong;
    return this;
  }
  
  public final hn ys(long paramLong)
  {
    this.iYs = paramLong;
    return this;
  }
  
  public final hn yt(long paramLong)
  {
    this.dKX = paramLong;
    return this;
  }
  
  public final hn yu(long paramLong)
  {
    this.llY = paramLong;
    return this;
  }
  
  public final hn yv(long paramLong)
  {
    this.lzt = paramLong;
    return this;
  }
  
  public final hn yw(long paramLong)
  {
    this.lQi = paramLong;
    return this;
  }
  
  public final hn yx(long paramLong)
  {
    this.lQj = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hn
 * JD-Core Version:    0.7.0.1
 */