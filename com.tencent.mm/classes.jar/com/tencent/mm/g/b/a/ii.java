package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;

public final class ii
  extends a
{
  public long eOC = 0L;
  private long eOD = 0L;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eOC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eOD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.eOC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.eOD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final ii ahh()
  {
    AppMethodBeat.i(94831);
    this.eOD = Util.nowMilliSecond();
    super.bj("ClickTimeStampMs", this.eOD);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
  
  public final ii wg(String paramString)
  {
    AppMethodBeat.i(94830);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ii
 * JD-Core Version:    0.7.0.1
 */