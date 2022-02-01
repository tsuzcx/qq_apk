package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag
  extends a
{
  private String dHr;
  private long dJR;
  private String dJY;
  private String dJZ;
  private long dKa;
  private long dKb;
  private long dKc;
  private String dLE;
  
  public final String PV()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJR);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dJR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final ag du(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final ag dv(long paramLong)
  {
    this.dJR = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final ag hc(String paramString)
  {
    AppMethodBeat.i(168908);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final ag hd(String paramString)
  {
    AppMethodBeat.i(168909);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final ag he(String paramString)
  {
    AppMethodBeat.i(168910);
    this.dJZ = t("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final ag hf(String paramString)
  {
    AppMethodBeat.i(168911);
    this.dLE = t("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ag
 * JD-Core Version:    0.7.0.1
 */