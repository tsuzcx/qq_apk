package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iq
  extends a
{
  private long giK;
  private String gjO = "";
  private String gjP = "";
  private long guY;
  private String gxM = "";
  private long gzA;
  private String gzx = "";
  private long gzy;
  private String gzz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(207504);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjP);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207504);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.gzx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.giK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.guY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.gzy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.gxM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.gzz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.gzA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.gjP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207506);
    return localObject;
  }
  
  public final int getId()
  {
    return 21835;
  }
  
  public final iq tW(long paramLong)
  {
    AppMethodBeat.i(207494);
    this.giK = paramLong;
    super.bk("StayTimeMs", this.giK);
    AppMethodBeat.o(207494);
    return this;
  }
  
  public final iq tX(long paramLong)
  {
    AppMethodBeat.i(207496);
    this.guY = paramLong;
    super.bk("EnterTimeMs", this.guY);
    AppMethodBeat.o(207496);
    return this;
  }
  
  public final iq tY(long paramLong)
  {
    AppMethodBeat.i(207498);
    this.gzy = paramLong;
    super.bk("ExitTimeMs", this.gzy);
    AppMethodBeat.o(207498);
    return this;
  }
  
  public final iq tZ(long paramLong)
  {
    this.gzA = paramLong;
    return this;
  }
  
  public final iq zE(String paramString)
  {
    AppMethodBeat.i(207488);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(207488);
    return this;
  }
  
  public final iq zF(String paramString)
  {
    AppMethodBeat.i(207492);
    this.gzx = z("PageName", paramString, true);
    AppMethodBeat.o(207492);
    return this;
  }
  
  public final iq zG(String paramString)
  {
    AppMethodBeat.i(207500);
    this.gxM = z("ClickTabContextID", paramString, true);
    AppMethodBeat.o(207500);
    return this;
  }
  
  public final iq zH(String paramString)
  {
    AppMethodBeat.i(207502);
    this.gzz = z("Sid", paramString, true);
    AppMethodBeat.o(207502);
    return this;
  }
  
  public final iq zI(String paramString)
  {
    AppMethodBeat.i(207503);
    this.gjP = z("ContextID", paramString, true);
    AppMethodBeat.o(207503);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.iq
 * JD-Core Version:    0.7.0.1
 */