package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class im
  extends a
{
  private long dNI;
  private String lYR;
  private String lYS;
  private String pFI;
  private String pGh;
  private String pGk;
  private String pGl;
  private String pGm;
  private String pGn;
  private String pGo;
  private String pGp;
  private String pGq;
  private String pGr;
  private String pGs;
  private long pGt;
  private long pGu;
  private long pGw;
  private long pGx;
  private String pGy;
  
  public final im AQ(long paramLong)
  {
    this.pGt = paramLong;
    return this;
  }
  
  public final im AR(long paramLong)
  {
    this.pGu = paramLong;
    return this;
  }
  
  public final im AS(long paramLong)
  {
    this.pGw = paramLong;
    return this;
  }
  
  public final im AT(long paramLong)
  {
    this.pGx = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(204066);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.lYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lYS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.pGy);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(204066);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(204067);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PostId:").append(this.lYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.lYS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.pFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isBeauty:").append(this.pGh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("targetDuration:").append(this.pGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("originDuration:").append(this.pGl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSlowMotion:").append(this.pGm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dragCount:").append(this.pGn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scaleCount:").append(this.pGo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickEditCount:").append(this.pGp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("durationCutCount:").append(this.pGq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("durationScrollCount:").append(this.pGr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDurationCut:").append(this.pGs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cropRectChangeCount:").append(this.pGt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("seekBarDragCount:").append(this.pGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is60sDurationCut:").append(this.pGw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextStep:").append(this.pGx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.pGy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(204067);
    return localObject;
  }
  
  public final im aTA(String paramString)
  {
    AppMethodBeat.i(204062);
    this.pGq = t("durationCutCount", paramString, true);
    AppMethodBeat.o(204062);
    return this;
  }
  
  public final im aTB(String paramString)
  {
    AppMethodBeat.i(204063);
    this.pGr = t("durationScrollCount", paramString, true);
    AppMethodBeat.o(204063);
    return this;
  }
  
  public final im aTC(String paramString)
  {
    AppMethodBeat.i(204064);
    this.pGs = t("isDurationCut", paramString, true);
    AppMethodBeat.o(204064);
    return this;
  }
  
  public final im aTD(String paramString)
  {
    AppMethodBeat.i(204065);
    this.pGy = t("VideoType", paramString, true);
    AppMethodBeat.o(204065);
    return this;
  }
  
  public final im aTq(String paramString)
  {
    AppMethodBeat.i(204052);
    this.lYR = t("PostId", paramString, true);
    AppMethodBeat.o(204052);
    return this;
  }
  
  public final im aTr(String paramString)
  {
    AppMethodBeat.i(204053);
    this.lYS = t("EditId", paramString, true);
    AppMethodBeat.o(204053);
    return this;
  }
  
  public final im aTs(String paramString)
  {
    AppMethodBeat.i(204054);
    this.pFI = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(204054);
    return this;
  }
  
  public final im aTt(String paramString)
  {
    AppMethodBeat.i(204055);
    this.pGh = t("isBeauty", paramString, true);
    AppMethodBeat.o(204055);
    return this;
  }
  
  public final im aTu(String paramString)
  {
    AppMethodBeat.i(204056);
    this.pGk = t("targetDuration", paramString, true);
    AppMethodBeat.o(204056);
    return this;
  }
  
  public final im aTv(String paramString)
  {
    AppMethodBeat.i(204057);
    this.pGl = t("originDuration", paramString, true);
    AppMethodBeat.o(204057);
    return this;
  }
  
  public final im aTw(String paramString)
  {
    AppMethodBeat.i(204058);
    this.pGm = t("isSlowMotion", paramString, true);
    AppMethodBeat.o(204058);
    return this;
  }
  
  public final im aTx(String paramString)
  {
    AppMethodBeat.i(204059);
    this.pGn = t("dragCount", paramString, true);
    AppMethodBeat.o(204059);
    return this;
  }
  
  public final im aTy(String paramString)
  {
    AppMethodBeat.i(204060);
    this.pGo = t("scaleCount", paramString, true);
    AppMethodBeat.o(204060);
    return this;
  }
  
  public final im aTz(String paramString)
  {
    AppMethodBeat.i(204061);
    this.pGp = t("clickEditCount", paramString, true);
    AppMethodBeat.o(204061);
    return this;
  }
  
  public final int getId()
  {
    return 19904;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.im
 * JD-Core Version:    0.7.0.1
 */