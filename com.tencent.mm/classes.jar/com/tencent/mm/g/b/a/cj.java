package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cj
  extends a
{
  private long dHq;
  private String dHr;
  private long dKe = 0L;
  private String dNe;
  private String dRb;
  private String dRc;
  private long dRd = 0L;
  private long dRe = 0L;
  private long dRf;
  private String dRg;
  private long dRh = 0L;
  private long dRi = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(187845);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(187845);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(187846);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchId:").append(this.dNe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickMD5:").append(this.dRb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueryMD5:").append(this.dRc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Offset:").append(this.dRd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pos:").append(this.dRe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClientTimestamp:").append(this.dRf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestId:").append(this.dRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.dHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tab:").append(this.dRh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSelf:").append(this.dRi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187846);
    return localObject;
  }
  
  public final cj QB()
  {
    this.dKe = 59L;
    return this;
  }
  
  public final cj fa(long paramLong)
  {
    this.dRd = paramLong;
    return this;
  }
  
  public final cj fb(long paramLong)
  {
    this.dRe = paramLong;
    return this;
  }
  
  public final cj fc(long paramLong)
  {
    this.dRf = paramLong;
    return this;
  }
  
  public final cj fd(long paramLong)
  {
    this.dHq = paramLong;
    return this;
  }
  
  public final cj fe(long paramLong)
  {
    this.dRi = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19651;
  }
  
  public final cj iY(String paramString)
  {
    AppMethodBeat.i(187840);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(187840);
    return this;
  }
  
  public final cj iZ(String paramString)
  {
    AppMethodBeat.i(187841);
    this.dNe = t("SearchId", paramString, true);
    AppMethodBeat.o(187841);
    return this;
  }
  
  public final cj ja(String paramString)
  {
    AppMethodBeat.i(187842);
    this.dRb = t("ClickMD5", paramString, true);
    AppMethodBeat.o(187842);
    return this;
  }
  
  public final cj jb(String paramString)
  {
    AppMethodBeat.i(187843);
    this.dRc = t("QueryMD5", paramString, true);
    AppMethodBeat.o(187843);
    return this;
  }
  
  public final cj jc(String paramString)
  {
    AppMethodBeat.i(187844);
    this.dRg = t("RequestId", paramString, true);
    AppMethodBeat.o(187844);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cj
 * JD-Core Version:    0.7.0.1
 */