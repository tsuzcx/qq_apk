package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  private String dUR;
  private long dUY;
  private String dVa;
  private String dVb;
  private String dWX;
  private String dXS;
  private long dXT;
  private String dXU;
  private long dXV;
  private long dXW;
  
  public final String RD()
  {
    AppMethodBeat.i(209144);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXW);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209144);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.dUY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.dXS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.dXT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.dXU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.dXV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.dXW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209145);
    return localObject;
  }
  
  public final String Sd()
  {
    return this.dXU;
  }
  
  public final az en(long paramLong)
  {
    this.dUY = paramLong;
    return this;
  }
  
  public final az eo(long paramLong)
  {
    this.dXT = paramLong;
    return this;
  }
  
  public final az ep(long paramLong)
  {
    this.dXV = paramLong;
    return this;
  }
  
  public final az eq(long paramLong)
  {
    this.dXW = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final az iP(String paramString)
  {
    AppMethodBeat.i(209138);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209138);
    return this;
  }
  
  public final az iQ(String paramString)
  {
    AppMethodBeat.i(209139);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209139);
    return this;
  }
  
  public final az iR(String paramString)
  {
    AppMethodBeat.i(209140);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209140);
    return this;
  }
  
  public final az iS(String paramString)
  {
    AppMethodBeat.i(209141);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209141);
    return this;
  }
  
  public final az iT(String paramString)
  {
    AppMethodBeat.i(209142);
    this.dXS = t("FlodUsername", paramString, true);
    AppMethodBeat.o(209142);
    return this;
  }
  
  public final az iU(String paramString)
  {
    AppMethodBeat.i(209143);
    this.dXU = t("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(209143);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */