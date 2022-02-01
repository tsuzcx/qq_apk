package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jq
  extends a
{
  private String eQC = "";
  private long eQF = 0L;
  private long eQG = 0L;
  private long eQM = 0L;
  private long eQN = 0L;
  private long eQO = 0L;
  private long eQP = 2L;
  private long eQQ = 0L;
  private long eQS = 0L;
  private long eQT = 0L;
  private long eSc = 0L;
  private long eSd = 0L;
  private long eSe = 0L;
  private long eSf = 0L;
  private long eSg = 0L;
  private long eSh = 0L;
  private String eSi = "";
  private long elI = 0L;
  private long eqk = 0L;
  private long etp = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eQT);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.elI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.eQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.etp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.eqk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.eSc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.eSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.eSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.eQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.eQG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.eSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.eSg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.eSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.eSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.eQM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.eQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.eQO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.eQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.eQQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.eQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.eQT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final jq ahL()
  {
    this.eSd = 1L;
    return this;
  }
  
  public final jq ahM()
  {
    this.eSe = 1L;
    return this;
  }
  
  public final jq ahN()
  {
    this.eSg = 1L;
    return this;
  }
  
  public final jq ahO()
  {
    this.eQN = 1L;
    return this;
  }
  
  public final jq ahP()
  {
    this.eQS = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final jq sB(long paramLong)
  {
    this.elI = paramLong;
    return this;
  }
  
  public final jq sC(long paramLong)
  {
    this.etp = paramLong;
    return this;
  }
  
  public final jq sD(long paramLong)
  {
    this.eqk = paramLong;
    return this;
  }
  
  public final jq sE(long paramLong)
  {
    this.eSc = paramLong;
    return this;
  }
  
  public final jq sF(long paramLong)
  {
    this.eQF = paramLong;
    return this;
  }
  
  public final jq sG(long paramLong)
  {
    this.eQG = paramLong;
    return this;
  }
  
  public final jq sH(long paramLong)
  {
    this.eSf = paramLong;
    return this;
  }
  
  public final jq sI(long paramLong)
  {
    this.eQM = paramLong;
    return this;
  }
  
  public final jq sJ(long paramLong)
  {
    this.eQO = paramLong;
    return this;
  }
  
  public final jq sK(long paramLong)
  {
    this.eQP = paramLong;
    return this;
  }
  
  public final jq sL(long paramLong)
  {
    this.eQQ = paramLong;
    return this;
  }
  
  public final jq wV(String paramString)
  {
    AppMethodBeat.i(74984);
    this.eQC = x("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final jq wW(String paramString)
  {
    AppMethodBeat.i(74985);
    this.eSi = x("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jq
 * JD-Core Version:    0.7.0.1
 */