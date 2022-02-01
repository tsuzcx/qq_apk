package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  private String dFe;
  private long dHN;
  private long dHR;
  private String dIp;
  private String dIq;
  private long dIr;
  private long dIs;
  private String dLA;
  
  public final String PR()
  {
    AppMethodBeat.i(168912);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHN);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(168912);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(168913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.dLA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dHN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168913);
    return localObject;
  }
  
  public final ay eO(long paramLong)
  {
    this.dHR = paramLong;
    return this;
  }
  
  public final ay eP(long paramLong)
  {
    this.dHN = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19188;
  }
  
  public final ay iv(String paramString)
  {
    AppMethodBeat.i(168908);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(168908);
    return this;
  }
  
  public final ay iw(String paramString)
  {
    AppMethodBeat.i(168909);
    this.dIp = t("Tag", paramString, true);
    AppMethodBeat.o(168909);
    return this;
  }
  
  public final ay ix(String paramString)
  {
    AppMethodBeat.i(168910);
    this.dIq = t("TagId", paramString, true);
    AppMethodBeat.o(168910);
    return this;
  }
  
  public final ay iy(String paramString)
  {
    AppMethodBeat.i(168911);
    this.dLA = t("feedid", paramString, true);
    AppMethodBeat.o(168911);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */