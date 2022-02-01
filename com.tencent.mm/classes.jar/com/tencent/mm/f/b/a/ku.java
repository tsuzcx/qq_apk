package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ku
  extends a
{
  private long gOJ = 0L;
  private String gcU = "";
  
  public final ku BI(String paramString)
  {
    AppMethodBeat.i(94836);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.gOJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final ku amC()
  {
    AppMethodBeat.i(94837);
    this.gOJ = Util.nowMilliSecond();
    super.bm("ClickTimeStampMs", this.gOJ);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ku
 * JD-Core Version:    0.7.0.1
 */