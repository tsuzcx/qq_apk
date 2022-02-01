package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class kp
  extends a
{
  public long gOI = 0L;
  private long gOJ = 0L;
  private String gcU = "";
  
  public final kp BF(String paramString)
  {
    AppMethodBeat.i(94830);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gOJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.gOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.gOJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final kp amB()
  {
    AppMethodBeat.i(94831);
    this.gOJ = Util.nowMilliSecond();
    super.bm("ClickTimeStampMs", this.gOJ);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kp
 * JD-Core Version:    0.7.0.1
 */