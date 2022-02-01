package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class im
  extends a
{
  private long eOD = 0L;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(94838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94838);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94839);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.eOD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94839);
    return localObject;
  }
  
  public final im ahi()
  {
    AppMethodBeat.i(94837);
    this.eOD = Util.nowMilliSecond();
    super.bj("ClickTimeStampMs", this.eOD);
    AppMethodBeat.o(94837);
    return this;
  }
  
  public final int getId()
  {
    return 15988;
  }
  
  public final im wj(String paramString)
  {
    AppMethodBeat.i(94836);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(94836);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.im
 * JD-Core Version:    0.7.0.1
 */