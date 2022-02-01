package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ml
  extends a
{
  private long gBI;
  private String gTY = "";
  private String gTZ = "";
  private String gUa = "";
  private String gUb = "";
  private String gUc = "";
  private String gUd = "";
  private String gUe = "";
  private String gUf = "";
  private String gUg = "";
  private long gUh;
  private long gUi;
  private String gUj = "";
  private long gUk;
  private long gUl;
  private long gUm;
  private long gUn;
  private int gUo;
  private String gUp = "";
  private long gUq;
  private long gUr;
  private long gUs;
  private long gef;
  private String gjO = "";
  private String gnE = "";
  
  public final ml CO(String paramString)
  {
    AppMethodBeat.i(234578);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(234578);
    return this;
  }
  
  public final ml CP(String paramString)
  {
    AppMethodBeat.i(234579);
    this.gTY = z("TopicID", paramString, true);
    AppMethodBeat.o(234579);
    return this;
  }
  
  public final ml CQ(String paramString)
  {
    AppMethodBeat.i(234580);
    this.gTZ = z("TextStatusID", paramString, true);
    AppMethodBeat.o(234580);
    return this;
  }
  
  public final ml CR(String paramString)
  {
    AppMethodBeat.i(234584);
    this.gUb = z("IconID", paramString, true);
    AppMethodBeat.o(234584);
    return this;
  }
  
  public final ml CS(String paramString)
  {
    AppMethodBeat.i(234585);
    this.gUc = z("SourceID", paramString, true);
    AppMethodBeat.o(234585);
    return this;
  }
  
  public final ml CT(String paramString)
  {
    AppMethodBeat.i(234586);
    this.gUd = z("SourceActivityID", paramString, true);
    AppMethodBeat.o(234586);
    return this;
  }
  
  public final ml CU(String paramString)
  {
    AppMethodBeat.i(234587);
    this.gUe = z("SourceName", paramString, true);
    AppMethodBeat.o(234587);
    return this;
  }
  
  public final ml CV(String paramString)
  {
    AppMethodBeat.i(234589);
    this.gUf = z("SourceExtraInfo", paramString, true);
    AppMethodBeat.o(234589);
    return this;
  }
  
  public final ml CW(String paramString)
  {
    AppMethodBeat.i(234591);
    this.gUg = z("CurrLikeIcon", paramString, true);
    AppMethodBeat.o(234591);
    return this;
  }
  
  public final ml CX(String paramString)
  {
    AppMethodBeat.i(234593);
    this.gUj = z("AuthorUsername", paramString, true);
    AppMethodBeat.o(234593);
    return this;
  }
  
  public final ml CY(String paramString)
  {
    AppMethodBeat.i(234595);
    this.gnE = z("ActionResult", paramString, true);
    AppMethodBeat.o(234595);
    return this;
  }
  
  public final ml CZ(String paramString)
  {
    AppMethodBeat.i(234596);
    this.gUp = z("SourceFeedID", paramString, true);
    AppMethodBeat.o(234596);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(234597);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUs);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(234597);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(234598);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopicID:").append(this.gTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextStatusID:").append(this.gTZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopicText:").append(this.gUa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconID:").append(this.gUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.gUc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceActivityID:").append(this.gUd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceName:").append(this.gUe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceExtraInfo:").append(this.gUf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrLikeIcon:").append(this.gUg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrSameFriCnt:").append(this.gUh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrChattingCnt:").append(this.gUi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AuthorUsername:").append(this.gUj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UsersRelationship:").append(this.gUk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrScene:").append(this.gUl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNoticeEntrance:").append(this.gUm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ListPos:").append(this.gUn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.gnE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.gBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsInPullDownMode:").append(this.gUo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceFeedID:").append(this.gUp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BroadcastDuration:").append(this.gUq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BroadcastCycle:").append(this.gUr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SameFriendPageSource:").append(this.gUs);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(234598);
    return localObject;
  }
  
  public final String ahi()
  {
    return this.gnE;
  }
  
  public final int getId()
  {
    return 22216;
  }
  
  public final ml nQ(int paramInt)
  {
    this.gUo = paramInt;
    return this;
  }
  
  public final ml xP(long paramLong)
  {
    this.gUh = paramLong;
    return this;
  }
  
  public final ml xQ(long paramLong)
  {
    this.gUi = paramLong;
    return this;
  }
  
  public final ml xR(long paramLong)
  {
    this.gUk = paramLong;
    return this;
  }
  
  public final ml xS(long paramLong)
  {
    this.gUl = paramLong;
    return this;
  }
  
  public final ml xT(long paramLong)
  {
    this.gUm = paramLong;
    return this;
  }
  
  public final ml xU(long paramLong)
  {
    this.gUn = paramLong;
    return this;
  }
  
  public final ml xV(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final ml xW(long paramLong)
  {
    this.gBI = paramLong;
    return this;
  }
  
  public final ml xX(long paramLong)
  {
    this.gUq = paramLong;
    return this;
  }
  
  public final ml xY(long paramLong)
  {
    this.gUr = paramLong;
    return this;
  }
  
  public final ml xZ(long paramLong)
  {
    this.gUs = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ml
 * JD-Core Version:    0.7.0.1
 */