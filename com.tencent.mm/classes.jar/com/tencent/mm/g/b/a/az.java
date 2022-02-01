package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  private String dWh = "";
  private long dWo;
  private String dWq = "";
  private String dWr = "";
  private String dYp = "";
  private String dZj = "";
  private long dZk;
  private String dZl = "";
  private long dZm;
  private long dZn;
  
  public final String RC()
  {
    AppMethodBeat.i(189176);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZn);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189176);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189177);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.dWo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.dZj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.dZk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.dZl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.dZm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.dZn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189177);
    return localObject;
  }
  
  public final String Sb()
  {
    return this.dZl;
  }
  
  public final az eo(long paramLong)
  {
    this.dWo = paramLong;
    return this;
  }
  
  public final az ep(long paramLong)
  {
    this.dZk = paramLong;
    return this;
  }
  
  public final az eq(long paramLong)
  {
    this.dZm = paramLong;
    return this;
  }
  
  public final az er(long paramLong)
  {
    this.dZn = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final az iZ(String paramString)
  {
    AppMethodBeat.i(189170);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189170);
    return this;
  }
  
  public final az ja(String paramString)
  {
    AppMethodBeat.i(189171);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189171);
    return this;
  }
  
  public final az jb(String paramString)
  {
    AppMethodBeat.i(189172);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189172);
    return this;
  }
  
  public final az jc(String paramString)
  {
    AppMethodBeat.i(189173);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189173);
    return this;
  }
  
  public final az jd(String paramString)
  {
    AppMethodBeat.i(189174);
    this.dZj = t("FlodUsername", paramString, true);
    AppMethodBeat.o(189174);
    return this;
  }
  
  public final az je(String paramString)
  {
    AppMethodBeat.i(189175);
    this.dZl = t("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(189175);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */