package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ol
  extends a
{
  private long ejA;
  private String eoC = "";
  private String erP = "";
  private long oqA;
  private long oqC;
  private long oqG;
  private long oqH;
  private String oqi = "";
  private String oqj = "";
  private String oqk = "";
  private String oql = "";
  private String oqm = "";
  private String oqn = "";
  private String oqo = "";
  private String oqt = "";
  private String oqu = "";
  private long oqw;
  private long oqx;
  private String oqy = "";
  private long oqz;
  
  public final ol QA(long paramLong)
  {
    this.oqC = paramLong;
    return this;
  }
  
  public final ol QB(long paramLong)
  {
    this.oqG = paramLong;
    return this;
  }
  
  public final ol QC(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final ol QD(long paramLong)
  {
    this.oqH = paramLong;
    return this;
  }
  
  public final ol Qw(long paramLong)
  {
    this.oqw = paramLong;
    return this;
  }
  
  public final ol Qx(long paramLong)
  {
    this.oqx = paramLong;
    return this;
  }
  
  public final ol Qy(long paramLong)
  {
    this.oqz = paramLong;
    return this;
  }
  
  public final ol Qz(long paramLong)
  {
    this.oqA = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258386);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqH);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258386);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258387);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopicID:").append(this.oqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextStatusID:").append(this.oqj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopicText:").append(this.oqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconID:").append(this.oql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.oqm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceActivityID:").append(this.oqn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceName:").append(this.oqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceExtraInfo:").append(this.oqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrLikeIcon:").append(this.oqu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrSameFriCnt:").append(this.oqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrChattingCnt:").append(this.oqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AuthorUsername:").append(this.oqy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UsersRelationship:").append(this.oqz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrScene:").append(this.oqA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNoticeEntrance:").append(this.oqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ListPos:").append(this.oqG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.oqH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258387);
    return localObject;
  }
  
  public final ol bwA(String paramString)
  {
    AppMethodBeat.i(258378);
    this.oql = x("IconID", paramString, true);
    AppMethodBeat.o(258378);
    return this;
  }
  
  public final ol bwB(String paramString)
  {
    AppMethodBeat.i(258379);
    this.oqm = x("SourceID", paramString, true);
    AppMethodBeat.o(258379);
    return this;
  }
  
  public final ol bwC(String paramString)
  {
    AppMethodBeat.i(258380);
    this.oqn = x("SourceActivityID", paramString, true);
    AppMethodBeat.o(258380);
    return this;
  }
  
  public final ol bwD(String paramString)
  {
    AppMethodBeat.i(258381);
    this.oqo = x("SourceName", paramString, true);
    AppMethodBeat.o(258381);
    return this;
  }
  
  public final ol bwE(String paramString)
  {
    AppMethodBeat.i(258382);
    this.oqt = x("SourceExtraInfo", paramString, true);
    AppMethodBeat.o(258382);
    return this;
  }
  
  public final ol bwF(String paramString)
  {
    AppMethodBeat.i(258383);
    this.oqu = x("CurrLikeIcon", paramString, true);
    AppMethodBeat.o(258383);
    return this;
  }
  
  public final ol bwG(String paramString)
  {
    AppMethodBeat.i(258384);
    this.oqy = x("AuthorUsername", paramString, true);
    AppMethodBeat.o(258384);
    return this;
  }
  
  public final ol bwH(String paramString)
  {
    AppMethodBeat.i(258385);
    this.erP = x("ActionResult", paramString, true);
    AppMethodBeat.o(258385);
    return this;
  }
  
  public final ol bwx(String paramString)
  {
    AppMethodBeat.i(258375);
    this.eoC = x("SessionID", paramString, true);
    AppMethodBeat.o(258375);
    return this;
  }
  
  public final ol bwy(String paramString)
  {
    AppMethodBeat.i(258376);
    this.oqi = x("TopicID", paramString, true);
    AppMethodBeat.o(258376);
    return this;
  }
  
  public final ol bwz(String paramString)
  {
    AppMethodBeat.i(258377);
    this.oqj = x("TextStatusID", paramString, true);
    AppMethodBeat.o(258377);
    return this;
  }
  
  public final int getId()
  {
    return 22216;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ol
 * JD-Core Version:    0.7.0.1
 */