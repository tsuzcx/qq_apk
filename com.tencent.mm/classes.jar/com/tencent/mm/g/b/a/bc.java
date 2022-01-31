package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  private long cOA = 0L;
  private long cVA = 0L;
  private long cVB = 0L;
  private String cVh = "";
  private long cVi = 0L;
  private long cVj = 0L;
  private long cVn = 0L;
  private long cVo = 0L;
  private long cVu = 0L;
  private long cVv = 0L;
  private long cVw = 0L;
  private long cVx = 2L;
  private long cVy = 0L;
  private long cWH = 0L;
  private long cWI = 0L;
  private long cWJ = 0L;
  private long cWK = 0L;
  private long cWL = 0L;
  private long cWM = 0L;
  private String cWN = "";
  
  public final bc FU()
  {
    this.cWI = 1L;
    return this;
  }
  
  public final bc FV()
  {
    this.cWJ = 1L;
    return this;
  }
  
  public final bc FW()
  {
    this.cWL = 1L;
    return this;
  }
  
  public final bc FX()
  {
    this.cVv = 1L;
    return this;
  }
  
  public final bc FY()
  {
    this.cVA = 1L;
    return this;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(108871);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cWN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVB);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108871);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108872);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.cOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.cVh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.cVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.cVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.cWH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.cWI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.cWJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.cVn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.cVo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.cWK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.cWL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.cWM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.cWN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.cVu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.cVv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.cVw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.cVx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.cVy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.cVA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.cVB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108872);
    return localObject;
  }
  
  public final bc cU(long paramLong)
  {
    this.cOA = paramLong;
    return this;
  }
  
  public final bc cV(long paramLong)
  {
    this.cVi = paramLong;
    return this;
  }
  
  public final bc cW(long paramLong)
  {
    this.cVj = paramLong;
    return this;
  }
  
  public final bc cX(long paramLong)
  {
    this.cWH = paramLong;
    return this;
  }
  
  public final bc cY(long paramLong)
  {
    this.cVn = paramLong;
    return this;
  }
  
  public final bc cZ(long paramLong)
  {
    this.cVo = paramLong;
    return this;
  }
  
  public final bc da(long paramLong)
  {
    this.cWK = paramLong;
    return this;
  }
  
  public final bc db(long paramLong)
  {
    this.cVu = paramLong;
    return this;
  }
  
  public final bc dc(long paramLong)
  {
    this.cVw = paramLong;
    return this;
  }
  
  public final bc dd(long paramLong)
  {
    this.cVx = paramLong;
    return this;
  }
  
  public final bc de(long paramLong)
  {
    this.cVy = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final bc gq(String paramString)
  {
    AppMethodBeat.i(108869);
    this.cVh = t("PublishObjectId", paramString, true);
    AppMethodBeat.o(108869);
    return this;
  }
  
  public final bc gr(String paramString)
  {
    AppMethodBeat.i(108870);
    this.cWN = t("NewActionTrace", paramString, true);
    AppMethodBeat.o(108870);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bc
 * JD-Core Version:    0.7.0.1
 */