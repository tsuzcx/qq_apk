package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  private String dJL;
  private String dKI;
  private long dkQ;
  private String dkR;
  private String jiI;
  private String lQk;
  private long lQl;
  private String lQn;
  private long lQo;
  private long lQp;
  
  public final String PV()
  {
    AppMethodBeat.i(203740);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dkQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQp);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203740);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CommentScene:").append(this.dkQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.jiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodUsername:").append(this.lQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlodFeedCnt:").append(this.lQl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFlodFeedItems:").append(this.lQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MoreTabClickTimestamp:").append(this.lQo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopTabClickTimestamp:").append(this.lQp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203741);
    return localObject;
  }
  
  public final ho aRG(String paramString)
  {
    AppMethodBeat.i(203734);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203734);
    return this;
  }
  
  public final ho aRH(String paramString)
  {
    AppMethodBeat.i(203735);
    this.dkR = t("Contextid", paramString, true);
    AppMethodBeat.o(203735);
    return this;
  }
  
  public final ho aRI(String paramString)
  {
    AppMethodBeat.i(203736);
    this.jiI = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(203736);
    return this;
  }
  
  public final ho aRJ(String paramString)
  {
    AppMethodBeat.i(203737);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203737);
    return this;
  }
  
  public final ho aRK(String paramString)
  {
    AppMethodBeat.i(203738);
    this.lQk = t("FlodUsername", paramString, true);
    AppMethodBeat.o(203738);
    return this;
  }
  
  public final ho aRL(String paramString)
  {
    AppMethodBeat.i(203739);
    this.lQn = t("AllFlodFeedItems", paramString, true);
    AppMethodBeat.o(203739);
    return this;
  }
  
  public final String akp()
  {
    return this.lQn;
  }
  
  public final int getId()
  {
    return 20027;
  }
  
  public final ho yA(long paramLong)
  {
    this.lQo = paramLong;
    return this;
  }
  
  public final ho yB(long paramLong)
  {
    this.lQp = paramLong;
    return this;
  }
  
  public final ho yy(long paramLong)
  {
    this.dkQ = paramLong;
    return this;
  }
  
  public final ho yz(long paramLong)
  {
    this.lQl = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ho
 * JD-Core Version:    0.7.0.1
 */