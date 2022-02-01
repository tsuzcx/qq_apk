package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bm
  extends a
{
  private String dFe = "";
  private long dFo = 0L;
  private String dHX;
  private String dMg = "";
  private long dMh = 0L;
  private long dMi = 0L;
  private String dMj;
  private long dMk = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(195174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMk);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195174);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.dMg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.dMh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.dMi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dHX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.dMj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.dMk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195175);
    return localObject;
  }
  
  public final String QA()
  {
    return this.dHX;
  }
  
  public final String QB()
  {
    return this.dMj;
  }
  
  public final long QC()
  {
    return this.dMk;
  }
  
  public final String Qw()
  {
    return this.dMg;
  }
  
  public final long Qx()
  {
    return this.dFo;
  }
  
  public final long Qy()
  {
    return this.dMh;
  }
  
  public final long Qz()
  {
    return this.dMi;
  }
  
  public final bm fL(long paramLong)
  {
    AppMethodBeat.i(195169);
    this.dFo = paramLong;
    super.bc("StayTimeMs", this.dFo);
    AppMethodBeat.o(195169);
    return this;
  }
  
  public final bm fM(long paramLong)
  {
    AppMethodBeat.i(195170);
    this.dMh = paramLong;
    super.bc("EnterTimeMs", this.dMh);
    AppMethodBeat.o(195170);
    return this;
  }
  
  public final bm fN(long paramLong)
  {
    AppMethodBeat.i(195171);
    this.dMi = paramLong;
    super.bc("ExitTimeMs", this.dMi);
    AppMethodBeat.o(195171);
    return this;
  }
  
  public final bm fO(long paramLong)
  {
    this.dMk = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.dFe;
  }
  
  public final bm ju(String paramString)
  {
    AppMethodBeat.i(195167);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(195167);
    return this;
  }
  
  public final bm jv(String paramString)
  {
    AppMethodBeat.i(195168);
    this.dMg = t("PageName", paramString, true);
    AppMethodBeat.o(195168);
    return this;
  }
  
  public final bm jw(String paramString)
  {
    AppMethodBeat.i(195172);
    this.dHX = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(195172);
    return this;
  }
  
  public final bm jx(String paramString)
  {
    AppMethodBeat.i(195173);
    this.dMj = t("Sid", paramString, true);
    AppMethodBeat.o(195173);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bm
 * JD-Core Version:    0.7.0.1
 */