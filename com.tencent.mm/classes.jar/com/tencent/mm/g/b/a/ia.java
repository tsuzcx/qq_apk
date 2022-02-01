package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ia
  extends a
{
  private long dHB = 0L;
  private String dHr = "";
  private String dMw;
  private String lZs = "";
  private long lZt = 0L;
  private long lZu = 0L;
  private String lZv;
  private long lZw = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(205341);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dMw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lZw);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(205341);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(205342);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageName:").append(this.lZs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTimeMs:").append(this.dHB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.lZt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitTimeMs:").append(this.lZu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.dMw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sid:").append(this.lZv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reportType:").append(this.lZw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(205342);
    return localObject;
  }
  
  public final ia aSI(String paramString)
  {
    AppMethodBeat.i(205334);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(205334);
    return this;
  }
  
  public final ia aSJ(String paramString)
  {
    AppMethodBeat.i(205335);
    this.lZs = t("PageName", paramString, true);
    AppMethodBeat.o(205335);
    return this;
  }
  
  public final ia aSK(String paramString)
  {
    AppMethodBeat.i(205339);
    this.dMw = t("ClickTabContextId", paramString, true);
    AppMethodBeat.o(205339);
    return this;
  }
  
  public final ia aSL(String paramString)
  {
    AppMethodBeat.i(205340);
    this.lZv = t("Sid", paramString, true);
    AppMethodBeat.o(205340);
    return this;
  }
  
  public final String aYS()
  {
    return this.lZs;
  }
  
  public final long baR()
  {
    return this.dHB;
  }
  
  public final long bqZ()
  {
    return this.lZt;
  }
  
  public final long bsA()
  {
    return this.lZu;
  }
  
  public final String bsB()
  {
    return this.dMw;
  }
  
  public final String bsO()
  {
    return this.lZv;
  }
  
  public final long bsX()
  {
    return this.lZw;
  }
  
  public final int getId()
  {
    return 19943;
  }
  
  public final String getSessionId()
  {
    return this.dHr;
  }
  
  public final ia zA(long paramLong)
  {
    this.lZw = paramLong;
    return this;
  }
  
  public final ia zx(long paramLong)
  {
    AppMethodBeat.i(205336);
    this.dHB = paramLong;
    super.ba("StayTimeMs", this.dHB);
    AppMethodBeat.o(205336);
    return this;
  }
  
  public final ia zy(long paramLong)
  {
    AppMethodBeat.i(205337);
    this.lZt = paramLong;
    super.ba("EnterTimeMs", this.lZt);
    AppMethodBeat.o(205337);
    return this;
  }
  
  public final ia zz(long paramLong)
  {
    AppMethodBeat.i(205338);
    this.lZu = paramLong;
    super.ba("ExitTimeMs", this.lZu);
    AppMethodBeat.o(205338);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ia
 * JD-Core Version:    0.7.0.1
 */