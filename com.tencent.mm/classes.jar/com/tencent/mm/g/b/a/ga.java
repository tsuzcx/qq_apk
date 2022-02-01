package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ga
  extends a
{
  private long dQy = 0L;
  private long dUB = 0L;
  private long dWq = 0L;
  private long elA = 0L;
  private long elB = 2L;
  private long elC = 0L;
  private long elE = 0L;
  private long elF = 0L;
  private String elo = "";
  private long elr = 0L;
  private long els = 0L;
  private long ely = 0L;
  private long elz = 0L;
  private long emP = 0L;
  private long emQ = 0L;
  private long emR = 0L;
  private long emS = 0L;
  private long emT = 0L;
  private long emU = 0L;
  private String emV = "";
  
  public final String RD()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ely);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elF);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.elo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.emP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.emQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.emR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.elr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.emS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.emT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.emU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.emV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.ely);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.elz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.elA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.elB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.elC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.elE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.elF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final ga TQ()
  {
    this.emQ = 1L;
    return this;
  }
  
  public final ga TR()
  {
    this.emR = 1L;
    return this;
  }
  
  public final ga TS()
  {
    this.emT = 1L;
    return this;
  }
  
  public final ga TT()
  {
    this.elz = 1L;
    return this;
  }
  
  public final ga TU()
  {
    this.elE = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final ga lo(long paramLong)
  {
    this.dQy = paramLong;
    return this;
  }
  
  public final ga lp(long paramLong)
  {
    this.dWq = paramLong;
    return this;
  }
  
  public final ga lq(long paramLong)
  {
    this.dUB = paramLong;
    return this;
  }
  
  public final ga lr(long paramLong)
  {
    this.emP = paramLong;
    return this;
  }
  
  public final ga ls(long paramLong)
  {
    this.elr = paramLong;
    return this;
  }
  
  public final ga lt(long paramLong)
  {
    this.els = paramLong;
    return this;
  }
  
  public final ga lu(long paramLong)
  {
    this.emS = paramLong;
    return this;
  }
  
  public final ga lv(long paramLong)
  {
    this.ely = paramLong;
    return this;
  }
  
  public final ga lw(long paramLong)
  {
    this.elA = paramLong;
    return this;
  }
  
  public final ga lx(long paramLong)
  {
    this.elB = paramLong;
    return this;
  }
  
  public final ga ly(long paramLong)
  {
    this.elC = paramLong;
    return this;
  }
  
  public final ga oR(String paramString)
  {
    AppMethodBeat.i(74984);
    this.elo = t("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final ga oS(String paramString)
  {
    AppMethodBeat.i(74985);
    this.emV = t("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ga
 * JD-Core Version:    0.7.0.1
 */