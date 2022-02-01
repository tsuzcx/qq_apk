package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class cl
  extends a
{
  private String dHr = "";
  public long dRw = 0L;
  private long dRx = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(94832);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRx);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94832);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Entrance:").append(this.dRw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTimeStampMs:").append(this.dRx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94833);
    return localObject;
  }
  
  public final cl QD()
  {
    AppMethodBeat.i(94831);
    this.dRx = bt.eGO();
    super.bb("ClickTimeStampMs", this.dRx);
    AppMethodBeat.o(94831);
    return this;
  }
  
  public final int getId()
  {
    return 15987;
  }
  
  public final cl jf(String paramString)
  {
    AppMethodBeat.i(94830);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(94830);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */