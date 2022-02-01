package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bk
  extends a
{
  private long dHT;
  private String dHV;
  private String dHW;
  private long dHY;
  private String dJP;
  private String dMb;
  private String dMc;
  private long dMd;
  private long dMe;
  private long dMf;
  
  public final String PR()
  {
    AppMethodBeat.i(195033);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195033);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195034);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dHW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dJP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PoiText:").append(this.dMb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FilterTextItems:").append(this.dMc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodtab:").append(this.dMd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsUnflodopen:").append(this.dMe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FliterPageType:").append(this.dMf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.dHT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195034);
    return localObject;
  }
  
  public final bk fE(long paramLong)
  {
    this.dHY = paramLong;
    return this;
  }
  
  public final bk fF(long paramLong)
  {
    this.dMd = paramLong;
    return this;
  }
  
  public final bk fG(long paramLong)
  {
    this.dMe = paramLong;
    return this;
  }
  
  public final bk fH(long paramLong)
  {
    this.dMf = paramLong;
    return this;
  }
  
  public final bk fI(long paramLong)
  {
    this.dHT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19996;
  }
  
  public final bk jm(String paramString)
  {
    AppMethodBeat.i(195028);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(195028);
    return this;
  }
  
  public final bk jn(String paramString)
  {
    AppMethodBeat.i(195029);
    this.dHW = t("Contextid", paramString, true);
    AppMethodBeat.o(195029);
    return this;
  }
  
  public final bk jo(String paramString)
  {
    AppMethodBeat.i(195030);
    this.dJP = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(195030);
    return this;
  }
  
  public final bk jp(String paramString)
  {
    AppMethodBeat.i(195031);
    this.dMb = t("PoiText", paramString, true);
    AppMethodBeat.o(195031);
    return this;
  }
  
  public final bk jq(String paramString)
  {
    AppMethodBeat.i(195032);
    this.dMc = t("FilterTextItems", paramString, true);
    AppMethodBeat.o(195032);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */