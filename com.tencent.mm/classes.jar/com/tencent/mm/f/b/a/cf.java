package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  private String gcU = "";
  private long gps;
  private String gpt = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209134);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gps);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209134);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209135);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.gps);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.gpt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209135);
    return localObject;
  }
  
  public final cf fd(long paramLong)
  {
    AppMethodBeat.i(209130);
    this.gps = paramLong;
    super.bm("EnterTimeStampMs", this.gps);
    AppMethodBeat.o(209130);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final cf lX(String paramString)
  {
    AppMethodBeat.i(209131);
    this.gpt = z("FinerUsername", paramString, true);
    AppMethodBeat.o(209131);
    return this;
  }
  
  public final cf lY(String paramString)
  {
    AppMethodBeat.i(209133);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209133);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cf
 * JD-Core Version:    0.7.0.1
 */