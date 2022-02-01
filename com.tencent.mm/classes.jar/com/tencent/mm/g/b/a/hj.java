package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hj
  extends a
{
  private String dHr;
  private String dJL;
  private String dJM;
  private String dJY;
  private String dJZ;
  private long dKa;
  private long dKb;
  private long dSY;
  private long gDa;
  private String gDb;
  private long gSO;
  private long hoM;
  
  public final String PV()
  {
    AppMethodBeat.i(203697);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hoM);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203697);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203698);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CardType:").append(this.gDa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUsr:").append(this.gDb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedUsr:").append(this.dJM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveCover:").append(this.gSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsCgiEnd:").append(this.hoM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203698);
    return localObject;
  }
  
  public final hj Vs()
  {
    this.gDa = 1L;
    return this;
  }
  
  public final hj Wb(String paramString)
  {
    AppMethodBeat.i(203692);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203692);
    return this;
  }
  
  public final hj Wc(String paramString)
  {
    AppMethodBeat.i(203693);
    this.gDb = t("SourceUsr", paramString, true);
    AppMethodBeat.o(203693);
    return this;
  }
  
  public final hj Wd(String paramString)
  {
    AppMethodBeat.i(203694);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203694);
    return this;
  }
  
  public final hj We(String paramString)
  {
    AppMethodBeat.i(203695);
    this.dJM = t("FeedUsr", paramString, true);
    AppMethodBeat.o(203695);
    return this;
  }
  
  public final hj Wf(String paramString)
  {
    AppMethodBeat.i(203696);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(203696);
    return this;
  }
  
  public final int getId()
  {
    return 18944;
  }
  
  public final hj ya(long paramLong)
  {
    this.dSY = paramLong;
    return this;
  }
  
  public final hj yb(long paramLong)
  {
    this.gSO = paramLong;
    return this;
  }
  
  public final hj yc(long paramLong)
  {
    this.hoM = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hj
 * JD-Core Version:    0.7.0.1
 */