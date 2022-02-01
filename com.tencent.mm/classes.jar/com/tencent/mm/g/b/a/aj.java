package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  private String dSb;
  private String dUR;
  private long dUW;
  private String dVH;
  private String dVI;
  private String dVJ;
  private long dVK;
  private long dVL;
  private long dVM;
  
  public final String RD()
  {
    AppMethodBeat.i(209064);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVM);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209064);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209065);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.dVH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.dVI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.dVJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.dVK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.dVL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.dVM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209065);
    return localObject;
  }
  
  public final aj cJ(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final aj cK(long paramLong)
  {
    this.dVK = paramLong;
    return this;
  }
  
  public final aj cL(long paramLong)
  {
    this.dVL = paramLong;
    return this;
  }
  
  public final aj cM(long paramLong)
  {
    this.dVM = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final aj hn(String paramString)
  {
    AppMethodBeat.i(209059);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209059);
    return this;
  }
  
  public final aj ho(String paramString)
  {
    AppMethodBeat.i(209060);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209060);
    return this;
  }
  
  public final aj hp(String paramString)
  {
    AppMethodBeat.i(209061);
    this.dVH = t("PosterUsername", paramString, true);
    AppMethodBeat.o(209061);
    return this;
  }
  
  public final aj hq(String paramString)
  {
    AppMethodBeat.i(209062);
    this.dVI = t("ViewerUsername", paramString, true);
    AppMethodBeat.o(209062);
    return this;
  }
  
  public final aj hr(String paramString)
  {
    AppMethodBeat.i(209063);
    this.dVJ = t("MentionedUsername", paramString, true);
    AppMethodBeat.o(209063);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aj
 * JD-Core Version:    0.7.0.1
 */