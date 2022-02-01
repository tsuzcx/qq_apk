package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private long dXI;
  private long dXJ;
  private String dXK = "";
  private long dXL;
  private long dXM;
  private long dXN;
  private String dXe = "";
  private String dXm = "";
  private String dXn = "";
  private long dXo;
  private long dXp;
  
  public final String RC()
  {
    AppMethodBeat.i(189113);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXN);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189113);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189114);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dXI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.dXJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.dXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dXe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dXn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dXo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dXp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.dXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dXM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIType:").append(this.dXN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189114);
    return localObject;
  }
  
  public final ao dh(long paramLong)
  {
    this.dXI = paramLong;
    return this;
  }
  
  public final ao di(long paramLong)
  {
    this.dXJ = paramLong;
    return this;
  }
  
  public final ao dj(long paramLong)
  {
    this.dXL = paramLong;
    return this;
  }
  
  public final ao dk(long paramLong)
  {
    this.dXM = paramLong;
    return this;
  }
  
  public final ao dl(long paramLong)
  {
    this.dXN = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final ao hS(String paramString)
  {
    AppMethodBeat.i(189108);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(189108);
    return this;
  }
  
  public final ao hT(String paramString)
  {
    AppMethodBeat.i(189109);
    this.dXK = t("SourceUsr", paramString, true);
    AppMethodBeat.o(189109);
    return this;
  }
  
  public final ao hU(String paramString)
  {
    AppMethodBeat.i(189110);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(189110);
    return this;
  }
  
  public final ao hV(String paramString)
  {
    AppMethodBeat.i(189111);
    this.dXe = t("FeedUsr", paramString, true);
    AppMethodBeat.o(189111);
    return this;
  }
  
  public final ao hW(String paramString)
  {
    AppMethodBeat.i(189112);
    this.dXm = t("Tag", paramString, true);
    AppMethodBeat.o(189112);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ao
 * JD-Core Version:    0.7.0.1
 */