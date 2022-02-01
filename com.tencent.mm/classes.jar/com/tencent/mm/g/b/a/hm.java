package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hm
  extends a
{
  private String dHr;
  private long dKe;
  private String dLe;
  private String dMw;
  private long dNj;
  private String gnM;
  private String iSe;
  private String iSf;
  private long iYs;
  private long iZi;
  private String iZx;
  private String iZy;
  
  public final String PV()
  {
    AppMethodBeat.i(203723);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iZy);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203723);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203724);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.dLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickFeedid:").append(this.iSe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AllFeedInfo:").append(this.iSf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RefreshTime:").append(this.iYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.iZi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageTag:").append(this.iZx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gnM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dNj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ScreenInfo:").append(this.iZy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203724);
    return localObject;
  }
  
  public final hm ZA(String paramString)
  {
    AppMethodBeat.i(203717);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(203717);
    return this;
  }
  
  public final hm ZF(String paramString)
  {
    AppMethodBeat.i(203718);
    this.iSe = t("ClickFeedid", paramString, true);
    AppMethodBeat.o(203718);
    return this;
  }
  
  public final hm ZO(String paramString)
  {
    AppMethodBeat.i(203719);
    this.iSf = t("AllFeedInfo", paramString, true);
    AppMethodBeat.o(203719);
    return this;
  }
  
  public final hm Zx(String paramString)
  {
    AppMethodBeat.i(203715);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203715);
    return this;
  }
  
  public final hm Zz(String paramString)
  {
    AppMethodBeat.i(203716);
    this.dLe = t("ContextId", paramString, true);
    AppMethodBeat.o(203716);
    return this;
  }
  
  public final hm awx(String paramString)
  {
    AppMethodBeat.i(203720);
    this.iZx = t("PageTag", paramString, true);
    AppMethodBeat.o(203720);
    return this;
  }
  
  public final hm awy(String paramString)
  {
    AppMethodBeat.i(203721);
    this.gnM = t("SessionBuffer", paramString, true);
    AppMethodBeat.o(203721);
    return this;
  }
  
  public final hm awz(String paramString)
  {
    AppMethodBeat.i(203722);
    this.iZy = t("ScreenInfo", paramString, true);
    AppMethodBeat.o(203722);
    return this;
  }
  
  public final int getId()
  {
    return 19993;
  }
  
  public final hm ym(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final hm yn(long paramLong)
  {
    this.iYs = paramLong;
    return this;
  }
  
  public final hm yo(long paramLong)
  {
    this.iZi = paramLong;
    return this;
  }
  
  public final hm yp(long paramLong)
  {
    this.dNj = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hm
 * JD-Core Version:    0.7.0.1
 */