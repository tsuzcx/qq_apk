package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dw
  extends a
{
  private String ggA = "";
  private long guY;
  private long guZ;
  private long gva;
  private long gvb;
  private long gvc;
  private long gvd;
  private long gve;
  
  public final String agH()
  {
    AppMethodBeat.i(208484);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gva);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gve);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208484);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.guY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDotEnter:").append(this.guZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.gva);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BannerType:").append(this.gvb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.gvc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveRedDot:").append(this.gvd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCnt:").append(this.gve);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208486);
    return localObject;
  }
  
  public final int getId()
  {
    return 20372;
  }
  
  public final dw jW(long paramLong)
  {
    AppMethodBeat.i(208479);
    this.guY = paramLong;
    super.bk("EnterTimeMs", this.guY);
    AppMethodBeat.o(208479);
    return this;
  }
  
  public final dw jX(long paramLong)
  {
    this.guZ = paramLong;
    return this;
  }
  
  public final dw jY(long paramLong)
  {
    this.gva = paramLong;
    return this;
  }
  
  public final dw jZ(long paramLong)
  {
    this.gvb = paramLong;
    return this;
  }
  
  public final dw ka(long paramLong)
  {
    this.gvc = paramLong;
    return this;
  }
  
  public final dw kb(long paramLong)
  {
    this.gvd = paramLong;
    return this;
  }
  
  public final dw kc(long paramLong)
  {
    this.gve = paramLong;
    return this;
  }
  
  public final dw qY(String paramString)
  {
    AppMethodBeat.i(208478);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(208478);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dw
 * JD-Core Version:    0.7.0.1
 */