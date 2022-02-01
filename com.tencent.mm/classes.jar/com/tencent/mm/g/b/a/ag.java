package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ag
  extends a
{
  private String dFe;
  private String dHM;
  private long dII;
  private long dIJ;
  private String dIK;
  private long dIL;
  private long dIM;
  private String dIh;
  private String dIp;
  private String dIq;
  private long dIr;
  private long dIs;
  
  public final String PR()
  {
    AppMethodBeat.i(194913);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dII);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIM);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194913);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dII);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.dIJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.dIK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dHM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.dIL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.dIM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194914);
    return localObject;
  }
  
  public final ag Qc()
  {
    this.dIJ = 1L;
    return this;
  }
  
  public final ag cM(long paramLong)
  {
    this.dII = paramLong;
    return this;
  }
  
  public final ag cN(long paramLong)
  {
    this.dIL = paramLong;
    return this;
  }
  
  public final ag cO(long paramLong)
  {
    this.dIM = paramLong;
    return this;
  }
  
  public final ag gA(String paramString)
  {
    AppMethodBeat.i(194908);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194908);
    return this;
  }
  
  public final ag gB(String paramString)
  {
    AppMethodBeat.i(194909);
    this.dIK = t("SourceUsr", paramString, true);
    AppMethodBeat.o(194909);
    return this;
  }
  
  public final ag gC(String paramString)
  {
    AppMethodBeat.i(194910);
    this.dHM = t("FeedId", paramString, true);
    AppMethodBeat.o(194910);
    return this;
  }
  
  public final ag gD(String paramString)
  {
    AppMethodBeat.i(194911);
    this.dIh = t("FeedUsr", paramString, true);
    AppMethodBeat.o(194911);
    return this;
  }
  
  public final ag gE(String paramString)
  {
    AppMethodBeat.i(194912);
    this.dIp = t("Tag", paramString, true);
    AppMethodBeat.o(194912);
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ag
 * JD-Core Version:    0.7.0.1
 */