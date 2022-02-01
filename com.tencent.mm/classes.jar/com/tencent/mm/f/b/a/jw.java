package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jw
  extends a
{
  private String gLW = "";
  public long gLX = 0L;
  public long gLY = 0L;
  public long gLZ = 0L;
  public long gMa = 0L;
  private String gMb = "";
  private String gMc = "";
  private String giT = "";
  public long gyo = 0L;
  
  public final jw AR(String paramString)
  {
    AppMethodBeat.i(76364);
    this.gLW = z("statId", paramString, true);
    AppMethodBeat.o(76364);
    return this;
  }
  
  public final jw AS(String paramString)
  {
    AppMethodBeat.i(76365);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(76365);
    return this;
  }
  
  public final jw AT(String paramString)
  {
    AppMethodBeat.i(76366);
    this.gMb = z("netType", paramString, true);
    AppMethodBeat.o(76366);
    return this;
  }
  
  public final jw AU(String paramString)
  {
    AppMethodBeat.i(76367);
    this.gMc = z("jsError", paramString, true);
    AppMethodBeat.o(76367);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(76368);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gLW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gLZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gMc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(76368);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(76369);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("statId:").append(this.gLW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statEvent:").append(this.gLX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("statTimeStamp:").append(this.gLY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("success:").append(this.gLZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.gyo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasInitData:").append(this.gMa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("netType:").append(this.gMb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("jsError:").append(this.gMc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(76369);
    return localObject;
  }
  
  public final int getId()
  {
    return 14452;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jw
 * JD-Core Version:    0.7.0.1
 */