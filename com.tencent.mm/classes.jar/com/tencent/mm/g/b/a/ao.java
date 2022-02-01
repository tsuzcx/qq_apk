package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  private String dSb;
  private String dUR;
  private String dVO;
  private String dVW;
  private String dVX;
  private long dVY;
  private long dVZ;
  private long dWq;
  private long dWr;
  private String dWs;
  private long dWt;
  private long dWu;
  private long dWv;
  
  public final String RD()
  {
    AppMethodBeat.i(209083);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWv);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209083);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209084);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.dWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dVW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dVX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dVY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dVZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIType:").append(this.dWv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209084);
    return localObject;
  }
  
  public final ao RQ()
  {
    this.dWr = 1L;
    return this;
  }
  
  public final ao dh(long paramLong)
  {
    this.dWq = paramLong;
    return this;
  }
  
  public final ao di(long paramLong)
  {
    this.dWt = paramLong;
    return this;
  }
  
  public final ao dj(long paramLong)
  {
    this.dWu = paramLong;
    return this;
  }
  
  public final ao dk(long paramLong)
  {
    this.dWv = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final ao hK(String paramString)
  {
    AppMethodBeat.i(209078);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(209078);
    return this;
  }
  
  public final ao hL(String paramString)
  {
    AppMethodBeat.i(209079);
    this.dWs = t("SourceUsr", paramString, true);
    AppMethodBeat.o(209079);
    return this;
  }
  
  public final ao hM(String paramString)
  {
    AppMethodBeat.i(209080);
    this.dUR = t("FeedId", paramString, true);
    AppMethodBeat.o(209080);
    return this;
  }
  
  public final ao hN(String paramString)
  {
    AppMethodBeat.i(209081);
    this.dVO = t("FeedUsr", paramString, true);
    AppMethodBeat.o(209081);
    return this;
  }
  
  public final ao hO(String paramString)
  {
    AppMethodBeat.i(209082);
    this.dVW = t("Tag", paramString, true);
    AppMethodBeat.o(209082);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ao
 * JD-Core Version:    0.7.0.1
 */