package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gl
  extends a
{
  private String eBx = "";
  private String eCL = "";
  private long eCM;
  private String eCN = "";
  private long eCO;
  private long enH;
  private String eoC = "";
  private String eoD = "";
  private long ezg;
  
  public final String abV()
  {
    AppMethodBeat.i(209290);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209290);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209291);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.eoC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.eCL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.enH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.ezg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.eCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextID:").append(this.eBx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.eCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.eCO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.eoD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209291);
    return localObject;
  }
  
  public final int getId()
  {
    return 21835;
  }
  
  public final gl qp(long paramLong)
  {
    AppMethodBeat.i(209284);
    this.enH = paramLong;
    super.bi("StayTimeMs", this.enH);
    AppMethodBeat.o(209284);
    return this;
  }
  
  public final gl qq(long paramLong)
  {
    AppMethodBeat.i(209285);
    this.ezg = paramLong;
    super.bi("EnterTimeMs", this.ezg);
    AppMethodBeat.o(209285);
    return this;
  }
  
  public final gl qr(long paramLong)
  {
    AppMethodBeat.i(209286);
    this.eCM = paramLong;
    super.bi("ExitTimeMs", this.eCM);
    AppMethodBeat.o(209286);
    return this;
  }
  
  public final gl qs(long paramLong)
  {
    this.eCO = paramLong;
    return this;
  }
  
  public final gl uf(String paramString)
  {
    AppMethodBeat.i(209282);
    this.eoC = x("SessionID", paramString, true);
    AppMethodBeat.o(209282);
    return this;
  }
  
  public final gl ug(String paramString)
  {
    AppMethodBeat.i(209283);
    this.eCL = x("PageName", paramString, true);
    AppMethodBeat.o(209283);
    return this;
  }
  
  public final gl uh(String paramString)
  {
    AppMethodBeat.i(209287);
    this.eBx = x("ClickTabContextID", paramString, true);
    AppMethodBeat.o(209287);
    return this;
  }
  
  public final gl ui(String paramString)
  {
    AppMethodBeat.i(209288);
    this.eCN = x("Sid", paramString, true);
    AppMethodBeat.o(209288);
    return this;
  }
  
  public final gl uj(String paramString)
  {
    AppMethodBeat.i(209289);
    this.eoD = x("ContextID", paramString, true);
    AppMethodBeat.o(209289);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gl
 * JD-Core Version:    0.7.0.1
 */