package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kj
  extends a
{
  private String gMR = "";
  public long gMT = 0L;
  public long gMU;
  public long gMV = 0L;
  public long gMW = 0L;
  public long gMX;
  public long gMY;
  private String gMZ = "";
  
  public final kj Bk(String paramString)
  {
    AppMethodBeat.i(255167);
    this.gMR = z("RoomId", paramString, true);
    AppMethodBeat.o(255167);
    return this;
  }
  
  public final kj Bl(String paramString)
  {
    AppMethodBeat.i(255168);
    this.gMZ = z("ToUsers", paramString, true);
    AppMethodBeat.o(255168);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(255169);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gMR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMZ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(255169);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(255171);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomId:").append(this.gMR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OrigInvitedUV:").append(this.gMU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailUV:").append(this.gMV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Opt:").append(this.gMW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUV:").append(this.gMX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalResult:").append(this.gMY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HistoryID:").append(this.gMT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsers:").append(this.gMZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(255171);
    return localObject;
  }
  
  public final int getId()
  {
    return 20542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.b.a.kj
 * JD-Core Version:    0.7.0.1
 */