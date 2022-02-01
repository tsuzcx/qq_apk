package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hi
  extends a
{
  private String dHr = "";
  private long gCY;
  private String gCZ = "";
  
  public final String PV()
  {
    AppMethodBeat.i(203690);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203690);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203691);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterTimeStampMs:").append(this.gCY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinerUsername:").append(this.gCZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203691);
    return localObject;
  }
  
  public final hi VM(String paramString)
  {
    AppMethodBeat.i(203688);
    this.gCZ = t("FinerUsername", paramString, true);
    AppMethodBeat.o(203688);
    return this;
  }
  
  public final hi Wa(String paramString)
  {
    AppMethodBeat.i(203689);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(203689);
    return this;
  }
  
  public final int getId()
  {
    return 19760;
  }
  
  public final hi xZ(long paramLong)
  {
    AppMethodBeat.i(203687);
    this.gCY = paramLong;
    super.bb("EnterTimeStampMs", this.gCY);
    AppMethodBeat.o(203687);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hi
 * JD-Core Version:    0.7.0.1
 */