package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  private String dSb;
  private long dUS;
  private long dUW;
  private String dVW;
  private String dVX;
  private long dVY;
  private long dVZ;
  private String dXz;
  
  public final String RD()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dUS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final bk fR(long paramLong)
  {
    this.dUW = paramLong;
    return this;
  }
  
  public final bk fS(long paramLong)
  {
    this.dUS = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final bk jT(String paramString)
  {
    AppMethodBeat.i(168908);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final bk jU(String paramString)
  {
    AppMethodBeat.i(168909);
    this.dVW = t("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final bk jV(String paramString)
  {
    AppMethodBeat.i(168910);
    this.dVX = t("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final bk jW(String paramString)
  {
    AppMethodBeat.i(168911);
    this.dXz = t("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */