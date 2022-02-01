package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ky
  extends a
{
  public long gBe = 0L;
  public long gPH = 0L;
  public long gPI = 0L;
  public long gPJ = 0L;
  private long gPK = 0L;
  public String gPL = "";
  public long glN = 0L;
  public long gsD = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(94843);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gPL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94843);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94844);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.gPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.gPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.glN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.gsD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.gPJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.gPK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.gPL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94844);
    return localObject;
  }
  
  public final int getId()
  {
    return 13677;
  }
  
  public final ky vl(long paramLong)
  {
    AppMethodBeat.i(94842);
    this.gPK = paramLong;
    super.bk("EnterStartTimeMs", this.gPK);
    AppMethodBeat.o(94842);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ky
 * JD-Core Version:    0.7.0.1
 */