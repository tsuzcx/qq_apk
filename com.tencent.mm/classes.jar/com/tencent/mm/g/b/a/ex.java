package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class ex
  extends a
{
  private String dSb = "";
  public long ejx = 0L;
  private long ejy = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejy);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.ejx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.ejy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final ex Tm()
  {
    AppMethodBeat.i(94831);
    this.ejy = bt.flT();
    super.bg("ClickTimeStampMs", this.ejy);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
  
  public final ex of(String paramString)
  {
    AppMethodBeat.i(94830);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ex
 * JD-Core Version:    0.7.0.1
 */