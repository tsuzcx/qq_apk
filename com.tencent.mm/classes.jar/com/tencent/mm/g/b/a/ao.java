package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ao
  extends a
{
  public long cSK = 0L;
  public long cUH = 0L;
  public long cUI = 0L;
  public long cUJ = 0L;
  public long cUK = 0L;
  public long cUL = 0L;
  private long cUM = 0L;
  private String cUN = "";
  
  public final String Ff()
  {
    AppMethodBeat.i(145235);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cUN);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(145235);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(145236);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Source:").append(this.cSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadLikeCount:").append(this.cUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadCommentCount:").append(this.cUI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.cUJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickLikeCount:").append(this.cUK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickCommentCount:").append(this.cUL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStartTimeMs:").append(this.cUM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BrowseJson:").append(this.cUN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(145236);
    return localObject;
  }
  
  public final ao bB(long paramLong)
  {
    AppMethodBeat.i(145233);
    this.cUM = paramLong;
    super.ay("EnterStartTimeMs", this.cUM);
    AppMethodBeat.o(145233);
    return this;
  }
  
  public final ao fT(String paramString)
  {
    AppMethodBeat.i(145234);
    this.cUN = t("BrowseJson", paramString, true);
    AppMethodBeat.o(145234);
    return this;
  }
  
  public final int getId()
  {
    return 13677;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ao
 * JD-Core Version:    0.7.0.1
 */