package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  private String dRJ = "";
  private long eam;
  private long ean;
  private long eao;
  private long eap;
  private long eaq;
  private long ear;
  private long eas;
  
  public final String RC()
  {
    AppMethodBeat.i(189208);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eam);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ean);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eao);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eap);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ear);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eas);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189208);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189209);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.eam);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDotEnter:").append(this.ean);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.eao);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BannerType:").append(this.eap);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.eaq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveRedDot:").append(this.ear);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCnt:").append(this.eas);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189209);
    return localObject;
  }
  
  public final bh ft(long paramLong)
  {
    AppMethodBeat.i(189207);
    this.eam = paramLong;
    super.bg("EnterTimeMs", this.eam);
    AppMethodBeat.o(189207);
    return this;
  }
  
  public final bh fu(long paramLong)
  {
    this.ean = paramLong;
    return this;
  }
  
  public final bh fv(long paramLong)
  {
    this.eao = paramLong;
    return this;
  }
  
  public final bh fw(long paramLong)
  {
    this.eap = paramLong;
    return this;
  }
  
  public final bh fx(long paramLong)
  {
    this.eaq = paramLong;
    return this;
  }
  
  public final bh fy(long paramLong)
  {
    this.ear = paramLong;
    return this;
  }
  
  public final bh fz(long paramLong)
  {
    this.eas = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20372;
  }
  
  public final bh jN(String paramString)
  {
    AppMethodBeat.i(189206);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(189206);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bh
 * JD-Core Version:    0.7.0.1
 */