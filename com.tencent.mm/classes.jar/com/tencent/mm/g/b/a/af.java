package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class af
  extends a
{
  private String dFe = "";
  private long dIG;
  private String dIH = "";
  
  public final String PR()
  {
    AppMethodBeat.i(194906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194906);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194907);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.dIG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.dIH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194907);
    return localObject;
  }
  
  public final af cL(long paramLong)
  {
    AppMethodBeat.i(194903);
    this.dIG = paramLong;
    super.bd("EnterTimeStampMs", this.dIG);
    AppMethodBeat.o(194903);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final af gy(String paramString)
  {
    AppMethodBeat.i(194904);
    this.dIH = t("FinerUsername", paramString, true);
    AppMethodBeat.o(194904);
    return this;
  }
  
  public final af gz(String paramString)
  {
    AppMethodBeat.i(194905);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(194905);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.af
 * JD-Core Version:    0.7.0.1
 */