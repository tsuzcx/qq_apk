package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ht
  extends a
{
  private String dHr = "";
  private String dJL;
  private String lYH;
  private String lYI = "";
  
  public final String PV()
  {
    AppMethodBeat.i(203770);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203770);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203771);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.dJL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PostUsername:").append(this.lYH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mentionedDetailInfo:").append(this.lYI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203771);
    return localObject;
  }
  
  public final ht aSc(String paramString)
  {
    AppMethodBeat.i(203766);
    this.dJL = t("FeedId", paramString, true);
    AppMethodBeat.o(203766);
    return this;
  }
  
  public final ht aSd(String paramString)
  {
    AppMethodBeat.i(203767);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203767);
    return this;
  }
  
  public final ht aSe(String paramString)
  {
    AppMethodBeat.i(203768);
    this.lYH = t("PostUsername", paramString, true);
    AppMethodBeat.o(203768);
    return this;
  }
  
  public final ht aSf(String paramString)
  {
    AppMethodBeat.i(203769);
    this.lYI = t("mentionedDetailInfo", paramString, true);
    AppMethodBeat.o(203769);
    return this;
  }
  
  public final int getId()
  {
    return 19792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ht
 * JD-Core Version:    0.7.0.1
 */