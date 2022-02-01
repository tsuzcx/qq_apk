package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aj
  extends a
{
  private String dTr = "";
  private String dWX = "";
  private String dWY = "";
  private String dWZ = "";
  private String dWh = "";
  private long dWm;
  private long dXa;
  private long dXb;
  private long dXc;
  
  public final String RC()
  {
    AppMethodBeat.i(189092);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXc);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189092);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189093);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.dWX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.dWY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.dWZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dWm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.dXa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.dXb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.dXc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189093);
    return localObject;
  }
  
  public final aj cJ(long paramLong)
  {
    this.dWm = paramLong;
    return this;
  }
  
  public final aj cK(long paramLong)
  {
    this.dXa = paramLong;
    return this;
  }
  
  public final aj cL(long paramLong)
  {
    this.dXb = paramLong;
    return this;
  }
  
  public final aj cM(long paramLong)
  {
    this.dXc = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final aj ht(String paramString)
  {
    AppMethodBeat.i(189087);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189087);
    return this;
  }
  
  public final aj hu(String paramString)
  {
    AppMethodBeat.i(189088);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189088);
    return this;
  }
  
  public final aj hv(String paramString)
  {
    AppMethodBeat.i(189089);
    this.dWX = t("PosterUsername", paramString, true);
    AppMethodBeat.o(189089);
    return this;
  }
  
  public final aj hw(String paramString)
  {
    AppMethodBeat.i(189090);
    this.dWY = t("ViewerUsername", paramString, true);
    AppMethodBeat.o(189090);
    return this;
  }
  
  public final aj hx(String paramString)
  {
    AppMethodBeat.i(189091);
    this.dWZ = t("MentionedUsername", paramString, true);
    AppMethodBeat.o(189091);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aj
 * JD-Core Version:    0.7.0.1
 */