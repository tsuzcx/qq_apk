package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
  extends a
{
  private long dKB;
  private String dLw;
  private String dLx;
  private String dPZ;
  private String dQa;
  private String dQb;
  private String dQc;
  private String dQd;
  private String dQe;
  private String dQf;
  private String dQg;
  private String dQh;
  private String dQi;
  private String dQj;
  private long dQk;
  private long dQl;
  private long dQm;
  private long dQn;
  private String dQo;
  
  public final String PR()
  {
    AppMethodBeat.i(199477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dLw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQo);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(199477);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(199478);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PostId:").append(this.dLw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.dLx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtraInfo:").append(this.dPZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isBeauty:").append(this.dQa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("targetDuration:").append(this.dQb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("originDuration:").append(this.dQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isSlowMotion:").append(this.dQd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("dragCount:").append(this.dQe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scaleCount:").append(this.dQf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickEditCount:").append(this.dQg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("durationCutCount:").append(this.dQh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("durationScrollCount:").append(this.dQi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isDurationCut:").append(this.dQj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cropRectChangeCount:").append(this.dQk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("seekBarDragCount:").append(this.dQl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("is60sDurationCut:").append(this.dQm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NextStep:").append(this.dQn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoType:").append(this.dQo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199478);
    return localObject;
  }
  
  public final int getId()
  {
    return 19904;
  }
  
  public final cq hW(long paramLong)
  {
    this.dQk = paramLong;
    return this;
  }
  
  public final cq hX(long paramLong)
  {
    this.dQl = paramLong;
    return this;
  }
  
  public final cq hY(long paramLong)
  {
    this.dQm = paramLong;
    return this;
  }
  
  public final cq hZ(long paramLong)
  {
    this.dQn = paramLong;
    return this;
  }
  
  public final cq kB(String paramString)
  {
    AppMethodBeat.i(199463);
    this.dLw = t("PostId", paramString, true);
    AppMethodBeat.o(199463);
    return this;
  }
  
  public final cq kC(String paramString)
  {
    AppMethodBeat.i(199464);
    this.dLx = t("EditId", paramString, true);
    AppMethodBeat.o(199464);
    return this;
  }
  
  public final cq kD(String paramString)
  {
    AppMethodBeat.i(199465);
    this.dPZ = t("ExtraInfo", paramString, true);
    AppMethodBeat.o(199465);
    return this;
  }
  
  public final cq kE(String paramString)
  {
    AppMethodBeat.i(199466);
    this.dQa = t("isBeauty", paramString, true);
    AppMethodBeat.o(199466);
    return this;
  }
  
  public final cq kF(String paramString)
  {
    AppMethodBeat.i(199467);
    this.dQb = t("targetDuration", paramString, true);
    AppMethodBeat.o(199467);
    return this;
  }
  
  public final cq kG(String paramString)
  {
    AppMethodBeat.i(199468);
    this.dQc = t("originDuration", paramString, true);
    AppMethodBeat.o(199468);
    return this;
  }
  
  public final cq kH(String paramString)
  {
    AppMethodBeat.i(199469);
    this.dQd = t("isSlowMotion", paramString, true);
    AppMethodBeat.o(199469);
    return this;
  }
  
  public final cq kI(String paramString)
  {
    AppMethodBeat.i(199470);
    this.dQe = t("dragCount", paramString, true);
    AppMethodBeat.o(199470);
    return this;
  }
  
  public final cq kJ(String paramString)
  {
    AppMethodBeat.i(199471);
    this.dQf = t("scaleCount", paramString, true);
    AppMethodBeat.o(199471);
    return this;
  }
  
  public final cq kK(String paramString)
  {
    AppMethodBeat.i(199472);
    this.dQg = t("clickEditCount", paramString, true);
    AppMethodBeat.o(199472);
    return this;
  }
  
  public final cq kL(String paramString)
  {
    AppMethodBeat.i(199473);
    this.dQh = t("durationCutCount", paramString, true);
    AppMethodBeat.o(199473);
    return this;
  }
  
  public final cq kM(String paramString)
  {
    AppMethodBeat.i(199474);
    this.dQi = t("durationScrollCount", paramString, true);
    AppMethodBeat.o(199474);
    return this;
  }
  
  public final cq kN(String paramString)
  {
    AppMethodBeat.i(199475);
    this.dQj = t("isDurationCut", paramString, true);
    AppMethodBeat.o(199475);
    return this;
  }
  
  public final cq kO(String paramString)
  {
    AppMethodBeat.i(199476);
    this.dQo = t("VideoType", paramString, true);
    AppMethodBeat.o(199476);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq
 * JD-Core Version:    0.7.0.1
 */